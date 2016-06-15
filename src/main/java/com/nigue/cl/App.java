package com.nigue.cl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String fileToFiles = args[0];
        String newFolder = args[1];

//        String fileToFiles = "/home/anibal/Comparacion/pdfCartolaFFMM/puro/mioc/insourcingPdf/data_mioc_pdfCartolaFFMM.txt";
//        String newFolder = "/home/anibal/Comparacion/pdfCartolaFFMM/desc/mio2/";

        List<String> files = new ArrayList<String>();

        File file = new File(fileToFiles);
        if (file.isFile()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    files.add(sCurrentLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(fileToFiles + " It's not a file");
        }

        File folder = new File(newFolder);
        if (folder.isDirectory()) {
            ProyconProcess p = new ProyconProcess(files, folder);
            p.execute();
        } else {
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    ProyconProcess p = new ProyconProcess(files, folder);
                    p.execute();
                } else {
                    System.out.println("Failed to create multiple directories!");
                }
            }
        }
    }
}
