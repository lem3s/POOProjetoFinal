package org.example.livraria.servico;

import java.io.*;

/**
 * PersistenciaUtil possui utilitários para lidar com a persistência de dados
 */
public class PersistenciaUtil {
    /**
     * Verifica se existe um arquivo com aquele nome na pasta raiz do projeto
     * @param nomeDoArquivo O nome do arquivo a ser buscado
     * @return Boolean com se existe ou não aquele arquivo
     */
    public static boolean arquivoExiste(String nomeDoArquivo) {
        File file = new File(nomeDoArquivo);
        return file.exists() && !file.isDirectory();
    }
}
