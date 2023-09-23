package org.example.Write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private static final String PATH_FILE = "src/main/resources/fileResult.txt";

    private WriteFile() {
    }

    public static void write(String input) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_FILE))) {
writer.write(input);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
