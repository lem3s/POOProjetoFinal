package org.example.livraria.servico;

public class ServicoPadrao {
    public static boolean arquivoExiste() {
        File file = new File(filename);
        return file.exists() && !file.isDirectory();
    }
}
