package org.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtil {

    public static byte[] readFile(String filename) {
        File file = new File(filename);
        try (FileInputStream fis = new FileInputStream(file)) {
            return fis.readAllBytes();
        } catch (IOException e) {
            System.out.println("File not found!");
            System.exit(0);
        }
        return null;
    }
}
