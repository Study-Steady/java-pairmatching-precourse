package pairmatching.view.validator;

import java.util.List;
import pairmatching.common.Symbol;
import pairmatching.util.validator.GeneralValidator;
import pairmatching.util.validator.StringValidator;

public class InputValidator {
    private static InputValidator inputValidator;
    public static final String CURRICULUM_DETAIL_SEPARATOR = Symbol.COMMA;
    public static final String TEMPLATE_SEPARATOR = CURRICULUM_DETAIL_SEPARATOR;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (inputValidator == null) {
            return new InputValidator();
        }
        return inputValidator;
    }

    public void validateMainOption(String mainOption, String target) {
        StringValidator.validateBlank(mainOption, target);
    }

    public void validateCurriculumDetail(String curriculumDetail, String target) {
        StringValidator.validateBlank(curriculumDetail, target);
        GeneralValidator.validateDuplicateSubstring(CURRICULUM_DETAIL_SEPARATOR, curriculumDetail, target);
        GeneralValidator.validateStartSubstring(CURRICULUM_DETAIL_SEPARATOR, curriculumDetail, target);
        GeneralValidator.validateEndSubstring(CURRICULUM_DETAIL_SEPARATOR, curriculumDetail, target);
        GeneralValidator.validateSplittedCount(CURRICULUM_DETAIL_SEPARATOR, curriculumDetail, 3, target);
    }

    public void validateRematchOption(String rematchOption, String target) {
        StringValidator.validateBlank(rematchOption, target);
    }

//    public static void validateNumber(String template, String target) {
//        StringValidator.validateBlank(template, target);
//        StringValidator.validateNumeric(template, target);
//        StringValidator.validateIntegerRange(template, target);
//    }
//
//    public void validatList(String template, String target) {
//        StringValidator.validateBlank(template, target);
//        GeneralValidator.validateDuplicateSubstring(Symbol.COMMA, template, target);
//        GeneralValidator.validateStartSubstring(Symbol.COMMA, template, target);
//        GeneralValidator.validateEndSubstring(Symbol.COMMA, template, target);
//        GeneralValidator.validateSplittedCount(Symbol.COMMA, template, 2, target);
//    }
//
//    public void validateListEachValue(List<String> values, String target) {
//        values.forEach(value -> StringValidator.validateBlank(value, target));
//        values.forEach(value -> StringValidator.validateNumeric(value, target));
//        values.forEach(value -> StringValidator.validateIntegerRange(value, target));
//    }
}
