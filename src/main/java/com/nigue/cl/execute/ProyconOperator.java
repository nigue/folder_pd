package com.nigue.cl.execute;

import com.strobel.decompiler.Decompiler;
import com.strobel.decompiler.DecompilerSettings;
import com.strobel.decompiler.PlainTextOutput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ProyconOperator extends DirectoryOperator {

    private File file;

    public ProyconOperator(File base, File source) {
        super(base, source);
        this.file = source;
        int cut = source.getAbsolutePath().lastIndexOf(File.separatorChar);
        this.source = new File(source.getAbsolutePath().substring(0, cut));
    }

    @Override
    public void execute() {
        super.execute();
//        System.out.println(base.getAbsolutePath() + getCleanSource() + File.separator + getJavaName());
        proyconDecompile(base.getAbsolutePath() + getCleanSource() + File.separator + getJavaName());
    }

    private String getJavaName() {
        String result = file.getName();
        int i = result.indexOf(".class");
        result = result.substring(0, i);
        return result.concat(".java");
    }

    private void proyconDecompile(String to) {
        try {
            final FileOutputStream stream = new FileOutputStream(to);
            try {
                final OutputStreamWriter writer = new OutputStreamWriter(stream);
                try {
                    Decompiler.decompile(
                            file.getAbsolutePath(),
                            new PlainTextOutput(writer),
                            DecompilerSettings.javaDefaults()
                    );
                } finally {
                    writer.close();
                }
            } finally {
                stream.close();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
