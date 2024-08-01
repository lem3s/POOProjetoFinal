package org.example.livraria.servico;

import java.io.*;
import java.util.List;

public class PersistenciaUtil {
    public static boolean arquivoExiste(String nomeDoArquivo) {
        File file = new File(nomeDoArquivo);
        return file.exists() && !file.isDirectory();
    }

    public static <T extends Serializable> void serializaLista(List<T> lista, String nomeArquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(lista);
            System.out.println("Dado serializado salvo em " + nomeArquivo);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> List<T> desserealizarLista(String nomeArquivo) {
        List<T> list = null;
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            list = (List<T>) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return list;
    }
}
