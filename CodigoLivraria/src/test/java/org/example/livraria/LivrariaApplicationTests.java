package org.example.livraria;

import org.example.livraria.api.model.Autor;
import org.example.livraria.api.model.Cliente;
import org.example.livraria.api.model.Livro;
import org.example.livraria.api.model.Vendedor;
import org.example.livraria.api.model.Estoque;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivrariaApplicationTests {

    @Test
    void testEstoque() {

        Estoque estoque = new Estoque();

        // Criar livros para adicionar ao estoque
        Autor autor = new Autor(); 
        autor.setNome("Autor Teste");
        Livro livro1 = new Livro("Livro 1");
        livro1.setAutor(autor);
        livro1.setPreco(15.00);
        livro1.setQuantidade(5);

        Livro livro2 = new Livro("Livro 2");
        livro2.setAutor(autor);
        livro2.setPreco(25.00);
        livro2.setQuantidade(3);

        // Adicionar livros ao estoque
        estoque.adicionarLivro(livro1);
        estoque.adicionarLivro(livro2);

        // Verificar se os livros foram adicionados corretamente
        List<Livro> livrosEmEstoque = estoque.getEstoque();
        assertEquals(2, livrosEmEstoque.size());
        assertTrue(livrosEmEstoque.contains(livro1));
        assertTrue(livrosEmEstoque.contains(livro2));

        // Remover um livro do estoque
        assertTrue(estoque.removerLivro(livro1.getId()));

        // Verificar se o livro foi removido
        livrosEmEstoque = estoque.getEstoque();
        assertEquals(1, livrosEmEstoque.size());
        assertFalse(livrosEmEstoque.contains(livro1));
        assertTrue(livrosEmEstoque.contains(livro2));
    }

    @Test
    void testCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setCpf("12345678900");
        cliente.setEndereco("Rua A, 123");

        assertEquals("João", cliente.getNome());
        assertEquals("12345678900", cliente.getCpf());
        assertEquals("Rua A, 123", cliente.getEndereco());
    }

    @Test
    void testLivro() {
        Autor autor = new Autor();
        autor.setNome("Autor Teste");

        Livro livro = new Livro("Livro Teste");
        livro.setAutor(autor);
        livro.setPreco(29.99);
        livro.setQuantidade(10);

        assertEquals("Livro Teste", livro.getTitulo());
        assertEquals(autor, livro.getAutor());
        assertEquals(29.99, livro.getPreco());
        assertEquals(10, livro.getQuantidade());
    }

    @Test
    void testVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome("Maria");
        vendedor.setCpf("98765432100");
        vendedor.setSalario(3000.00);

        assertEquals("Maria", vendedor.getNome());
        assertEquals("98765432100", vendedor.getCpf());
        assertEquals(3000.00, vendedor.getSalario());
    }
}
