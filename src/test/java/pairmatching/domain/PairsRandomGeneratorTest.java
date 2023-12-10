package pairmatching.domain;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PairsRandomGeneratorTest {
    @Test
    void generateFrontendPairs() {
        PairsRandomGenerator pairsRandomGenerator = new PairsRandomGenerator();
        CurriculumDetail curriculumDetail = CurriculumDetail.of(Arrays.asList("프론트엔드", "레벨1", "로또"));
        pairsRandomGenerator.generate(curriculumDetail);
    }
}
