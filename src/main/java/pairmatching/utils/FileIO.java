package pairmatching.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileIO {

    private FileIO() {
    }

    public static List<String> readByLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read. Invalid file path.");
        }
    }

}
