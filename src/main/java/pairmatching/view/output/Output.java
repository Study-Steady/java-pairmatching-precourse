package pairmatching.view.output;

public enum Output {

    COURSE_AND_MISSION_GUIDE("""
                            
            #############################################
            과정: 백엔드 | 프론트엔드
            미션:
              - 레벨1: 자동차경주 | 로또 | 숫자야구게임
              - 레벨2: 장바구니 | 결제 | 지하철노선도
              - 레벨3:\s
              - 레벨4: 성능개선 | 배포
              - 레벨5:\s
            ############################################
            """),

    OVER_TIMED_MATCH_TRIED("매칭을 3번 시도했거나 매칭 될 수 없는 상태입니다.");

    final String message;

    Output(String message) {
        this.message = message;
    }
}
