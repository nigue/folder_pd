package com.nigue.cl.execute;

import java.io.File;

public class DirectoryOperator {

    private static String OS = System.getProperty("os.name").toLowerCase();
    protected File source;
    protected File base;

    public DirectoryOperator(File base, File source) {
        this.source = source;
        this.base = base;
    }

    public void execute() {
        File f = new File(base.getAbsolutePath() + getCleanSource());
        f.mkdirs();
    }

    protected String getCleanSource() {
        String file = source.getAbsolutePath();
        if (isWindows()) {
            return file.substring(2);
        } else {
            return file;
        }
    }

    private boolean isWindows() {
        return (OS.contains("win"));
    }

}
