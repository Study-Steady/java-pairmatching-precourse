package pairmatching.domain.textReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import pairmatching.view.input.error.InputError;
import pairmatching.view.input.error.InputIllegalArgumentException;

public class TextReader {

    public List<String> readText(String filePath) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            List<String> textResult = new ArrayList<>();

            while ((str = reader.readLine()) != null) {
                textResult.add(str);
            }
            reader.close();
            return textResult;

        } catch (IOException e) {
            throw new InputIllegalArgumentException(InputError.NOT_AVAILABLE_FILE_PATH);
        }
    }
}
