package com.nigue.cl;

import java.io.File;

public class FolderPd {

    public static void main(String[] args) {
        try {
            String primerArgumento = args[0];
            File file = new File(primerArgumento);
            String segundoArgumento;
            try {
                segundoArgumento = args[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                if (file.isFile()) {
                    segundoArgumento = file.getAbsolutePath().substring(0, file.getName().length());
                } else if (file.isDirectory()) {
                    segundoArgumento = file.getAbsolutePath();
                }
            }
            if (file.isFile()) {
                if (file.getName().contains(".class")) {
                    System.out.println("OK ejecutar archivo: " + primerArgumento);
                } else {
                    System.out.println("Mal ejecutado, Ayuda: Tipo de archivo no soportado");
                }
            } else if (file.isDirectory()) {
                System.out.println("OK ejecutar directorio: " + primerArgumento);
            } else {
                System.out.println("Mal ejecutado, Ayuda: componente no entendido");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Mal ejecutado, Ayuda: comando no puede ejecutar");
        }
    }
}
