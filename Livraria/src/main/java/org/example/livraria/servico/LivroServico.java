package org.example.livraria.servico;

import org.example.livraria.api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LivroServico {

    private ArrayList<Livro> listaLivros;

   public LivroServico (){
       listaLivros = new ArrayList<Livro>();

       listaLivros.add(new Livro("Capitães da Areia"));
       listaLivros.add(new Livro("O Rei da Vela"));
       listaLivros.add(new Livro("Niketche"));
   }

    public Optional<Livro> getLivro (Integer id){
       Optional optionalLivro = Optional.empty();
       for (Livro livro : listaLivros) {
           if (livro.getId() == id) {
               optionalLivro = Optional.of(livro);
               return optionalLivro;
           }
       }
       return optionalLivro;
    }
}
