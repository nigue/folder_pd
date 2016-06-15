package com.nigue.cl.execute;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperator extends DirectoryOperator {

    private File file;

    public FileOperator(File base, File source) {
        super(base, source);
        this.file = source;
        int cut = source.getAbsolutePath().lastIndexOf(File.separatorChar);
        this.source = new File(source.getAbsolutePath().substring(0, cut));
    }

    @Override
    public void execute() {
        super.execute();
        copyFileTo(base.getAbsolutePath() + getCleanSource() + File.separator + file.getName());
    }

    private void copyFileTo(String to) {
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            File afile = file;
            File bfile = new File(to);
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);
            byte[] buffer = new byte[1024];
            int length;
            //copy the file content in bytes 
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            inStream.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
