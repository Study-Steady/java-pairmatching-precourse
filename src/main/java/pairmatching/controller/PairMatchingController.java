package pairmatching.controller;

import java.util.List;
import java.util.function.Supplier;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.matching.MatchingRecord;
import pairmatching.domain.matching.MatchingRepository;
import pairmatching.domain.matching.dto.MatchingSelection;
import pairmatching.view.input.InputView;
import pairmatching.view.output.Output;
import pairmatching.view.output.OutputView;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    private Crews crews;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String selectFeature;

        do {
            selectFeature = receiveValidatedInput(inputView::readSelectFeature);
            validateSelection(selectFeature);
        } while (!"Q".equals(selectFeature));
    }

    private void validateSelection(String selectFeature) {
        if ("1".equals(selectFeature)) {
            outputView.printMessage(Output.COURSE_AND_MISSION_GUIDE);
            getMatchingStartSelection();
        }
        if ("2".equals(selectFeature)) {
            showExistMatching();
        }
        if ("3".equals(selectFeature)) {
            MatchingRepository.initMatching();
        }
    }

    private void getMatchingStartSelection() {
        MatchingSelection matchingSelection = receiveValidatedInput(inputView::readMatchingSelection);

        crews = receiveValidatedInput(() -> Crews.from(matchingSelection.courseType()));

        List<String> shuffledCrews = crews.getShuffleCrews();

        if (MatchingRepository.isExistSameMissionMatching(matchingSelection)) {
            checkReMatchingOrNot(shuffledCrews, matchingSelection);
        }
        if (!MatchingRepository.isExistSameMissionMatching(matchingSelection)) {
            startMatching(shuffledCrews, false, matchingSelection);
        }
    }

    private void showExistMatching() {
        MatchingSelection matchingSelection = receiveValidatedInput(inputView::readMatchingSelection);

        MatchingRecord matchingRecord = MatchingRepository.findMatchingRecordsByLevelAndMission(matchingSelection);
        if (validateNoExistMatching(matchingRecord)) {
            outputView.printMatchingResult(matchingRecord);
        }
    }

    private void checkReMatchingOrNot(List<String> shuffleCrews,
                                      MatchingSelection matchingSelection) {
        boolean restartOrNot = receiveValidatedInput(inputView::getReMatchingOrNot);

        if (restartOrNot) {
            startMatching(shuffleCrews, true, matchingSelection);
        }
        if (!restartOrNot) {
            getMatchingStartSelection();
        }
    }

    private void startMatching(List<String> shuffleCrews, boolean needSet, MatchingSelection matchingSelection) {
        int shuffleCount = 1;
        List<String> newShuffleCrews = shuffleCrews;

        do {
            MatchingRecord matchingRecord = createMatchingRecord(matchingSelection, newShuffleCrews);
            if (!MatchingRepository.isExistCrewMatching(matchingSelection, matchingRecord)) {
                processMatchingResult(needSet, matchingSelection, matchingRecord);
                break;
            }
            newShuffleCrews = crews.getShuffleCrews();
            shuffleCount++;
        } while (shuffleCount < 4);

        if (shuffleCount == 4) { // 에러 메시지를 출력하라고만 나와있어서 출력만 했습니다.
            outputView.printErrorMessage(Output.OVER_TIMED_MATCH_TRIED);
        }
    }

    private MatchingRecord createMatchingRecord(MatchingSelection matchingSelection, List<String> newShuffleCrews) {
        return new MatchingRecord(matchingSelection.level(), matchingSelection.mission(),
                matchingSelection.courseType(), newShuffleCrews);
    }

    private void processMatchingResult(boolean needSet, MatchingSelection matchingSelection,
                                       MatchingRecord matchingRecord) {
        if (needSet) {
            MatchingRecord orgMatchingRecord = MatchingRepository.findMatchingRecordsByLevelAndMission(
                    matchingSelection);
            MatchingRepository.setMatchingRecord(orgMatchingRecord, matchingRecord);
        }
        if (!needSet) {
            MatchingRepository.addMatchingRecord(matchingRecord);
        }
        outputView.printMatchingResult(matchingRecord);
    }

    private boolean validateNoExistMatching(MatchingRecord matchingRecord) {
        if (matchingRecord == null) {
            System.out.println("[ERROR] 매칭 이력이 없습니다.");
            return false;
        }
        return true;
    }


    private <T> T receiveValidatedInput(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return receiveValidatedInput(inputSupplier);
        }
    }
}
