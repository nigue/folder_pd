package com.nigue.cl.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFileDisplay {

    public List<String> displayDirectoryContents(File dir) {
       List<String> result = new ArrayList<String>();
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    result.addAll(displayDirectoryContents(file));
                } else {
                    System.out.println("     file:" + file.getCanonicalPath());
                    result.add(file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
