package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class PairsStorage {
    private final Map<CurriculumDetail, Pairs> pairsStorage;

    public PairsStorage(Map<CurriculumDetail, Pairs> pairsStorage) {
        this.pairsStorage = pairsStorage;
    }

    public static PairsStorage init() {
        Map<CurriculumDetail, Pairs> pairsStorage = new LinkedHashMap<CurriculumDetail, Pairs>();
        return new PairsStorage(pairsStorage);
    }

    public void addMathcingsOf(CurriculumDetail curriculumDetail, PairsGenerator pairsGenerator) {
        for (int tryCount = 0; tryCount < 3; tryCount++) {
            Pairs pairs = pairsGenerator.generate(curriculumDetail);
            if (hasDuplicatedInLevel(pairs, curriculumDetail)) {
                continue;
            }
            pairsStorage.put(curriculumDetail, pairs); // 여기 3번 이상 오류시 나가서 에러메시지 후 메인화면 가게
            return;
        }
    }

    private boolean hasDuplicatedInLevel(Pairs pairs, CurriculumDetail inpuCurriculumDetail) {
        return pairsStorage.entrySet().stream()
                .filter(entry -> entry.getKey().isSameLevel(inpuCurriculumDetail))
                .anyMatch(entry -> entry.getValue().containsSamePair(pairs));
    }

    public Map<CurriculumDetail, Pairs> getPairsStorage() {
        return pairsStorage;
    }

    public boolean containsOf(CurriculumDetail curriculumDetail) {
        return pairsStorage.containsKey(curriculumDetail);
    }
}
