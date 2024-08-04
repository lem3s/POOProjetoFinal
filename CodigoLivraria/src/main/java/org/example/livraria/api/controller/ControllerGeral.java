package org.example.livraria.api.controller;

import org.example.livraria.api.model.Cliente;
import org.example.livraria.api.model.Livro;
import org.example.livraria.api.model.Vendedor;
import org.example.livraria.servico.ClienteServico;
import org.example.livraria.servico.EstoqueServico;
import org.example.livraria.servico.LivroServico;
import org.example.livraria.servico.VendedorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerGeral {

    private EstoqueServico estoqueServico;
    private ClienteServico clienteServico;
    private VendedorServico vendedorServico;

    @Autowired
    public ControllerGeral(EstoqueServico estoqueServico, ClienteServico clienteServico, VendedorServico vendedorServico) {
        this.estoqueServico = estoqueServico;
        this.clienteServico = clienteServico;
        this.vendedorServico = vendedorServico;
    }

    @GetMapping("/")
    public String index() {
        return "Olá!";
    }

    @GetMapping("/estoque")
    public List<Livro> getEstoque (){
        return estoqueServico.retornaLivrosEmEstoque();
    }

    @PostMapping("/adicionaLivro")
    public Livro adicionaLivro(@RequestBody Livro livro) {
        return estoqueServico.adicionaLivro(livro);
    }

    @PostMapping("/removeLivro")
    public boolean removeLivro(@RequestParam("id") String id) {
        return estoqueServico.removerLivro(Integer.parseInt(id));
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteServico.retornaClientes();
    }

    @PostMapping("/adicionaCliente")
    public Cliente adicionaCliente(@RequestBody Cliente cliente) {
        return clienteServico.adicionaCliente(cliente);
    }

    @PostMapping("/removeCliente")
    public boolean removeCliente(@RequestParam("cpf") String cpf) {
        return clienteServico.removeCliente(cpf);
    }

    @GetMapping("/vendedores")
    public List<Vendedor> getVendedores() {
        return vendedorServico.retornaVendedores();
    }

    @PostMapping("/adicionaVendedor")
    public Vendedor adicionaVendedor(@RequestBody Vendedor vendedor) {
        return vendedorServico.adicionaVendedor(vendedor);
    }

    @PostMapping("/removeVendedor")
    public boolean removeVendedor(@RequestParam("cpf") String cpf) {
        return vendedorServico.removeVendedor(cpf);
    }
}
