package org.bean;

public class Config {

    private static String filename;
    private static String fileDir;
    private static String from;

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        Config.filename = filename;
    }

    public static String getFrom() {
        return from;
    }

    public static void setFrom(String from) {
        Config.from = from;
    }

    public static String getFileDir() {
        return fileDir;
    }

    public static void setFileDir(String fileDir) {
        Config.fileDir = fileDir;
    }

    public static String getFilenameFromDir(String dir) {
        String[] files = dir.split("\\\\");
        String filename = files[files.length - 1];
        setFilename(filename);
        return filename;
    }

}
