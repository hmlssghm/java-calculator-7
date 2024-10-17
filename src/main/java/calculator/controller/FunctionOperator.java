package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionOperator {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Preprocessing preprocessing = new Preprocessing();
    Validation validation = new Validation();

    public void operator() {
        // outputView.입력해주세요();
        String input = inputView.input();

        List<String> separated = new ArrayList<>();
        List<String> separators = Arrays.asList(",", ":");
        // 전처리
        if (preprocessing.firstLetter(input)) {
            // 커스텀 구분자 추출
            List<String> customAndLeft = preprocessing.findCustomSeparator(input);
            separators.add(customAndLeft.get(0));

            // 숫자 - !숫자 구분
            separated = preprocessing.separation(customAndLeft.get(1));
        } else {
            // 숫자 - !숫자 구분
            separated = preprocessing.separation(input);
        }

        // 구분자 유효하면 sum
        int answer = validation.validatingSeparator(separators, separated);
    }

}
