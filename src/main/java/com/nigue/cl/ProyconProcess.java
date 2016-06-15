package com.nigue.cl;

import com.nigue.cl.execute.DirectoryOperator;
import com.nigue.cl.execute.FileOperator;
import com.nigue.cl.execute.ProyconOperator;
import java.io.File;
import java.util.List;

public class ProyconProcess {

    private List<String> components;
    private File directory;

    public ProyconProcess(List<String> components, File directory) {
        this.components = components;
        this.directory = directory;
    }

    public void execute() {

//        for (String s : components) {
        for (int i = 0; i < components.size(); i++) {
            int n = i+1;
            File f = new File(components.get(i));

            if (f.isFile()) {
                if (f.getAbsolutePath().contains(".class")) {
                    ProyconOperator proyconOperator = new ProyconOperator(directory, f);
                    proyconOperator.execute();
                } else {
                    FileOperator fileOperator = new FileOperator(directory, f);
                    fileOperator.execute();
                }
            } else if (f.isDirectory()) {
                DirectoryOperator directoryOperator = new DirectoryOperator(directory, f);
                directoryOperator.execute();
            }
            System.out.println(n+"/"+components.size() + " componente: " + f.getAbsolutePath());

        }

    }
}
