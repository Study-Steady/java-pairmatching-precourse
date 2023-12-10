package pairmatching.view.input;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> readLineWithPath(String path) {
        List<String> inputs = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path)){
            byte[] buffer = new byte[fis.available()];
            while (fis.read(buffer) != -1) {
                inputs.add(new String(buffer));
            }
            fis.close();
        } catch (Exception e) {

        }
        return inputs;
    }
}
