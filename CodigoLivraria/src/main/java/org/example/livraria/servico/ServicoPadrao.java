package org.example.livraria.servico;

import java.io.*;

public class ServicoPadrao {
    public static boolean arquivoExiste(String nomeDoArquivo) {
        File file = new File(nomeDoArquivo);
        return file.exists() && !file.isDirectory();
    }

    // Outras funções de serialização e desserialização
    public static void serialize(Serializable classe, String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(classe);
        }
    }
}
