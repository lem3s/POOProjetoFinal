package org.example.livraria.api.controller;

import org.example.livraria.api.model.Cliente;
import org.example.livraria.api.model.Livro;
import org.example.livraria.api.model.Vendedor;
import org.example.livraria.servico.ClienteServico;
import org.example.livraria.servico.EstoqueServico;
import org.example.livraria.servico.VendedorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * O controlador geral que irá administrar as requisições ao sistema
 */
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

    /**
     * Endpoint para consultar todo o estoque
     * @return O estoque de livros no formato json
     */
    @GetMapping("/estoque")
    public List<Livro> getEstoque (){
        return estoqueServico.retornaLivrosEmEstoque();
    }

    /**
     * Enpoint para adicionar um livro ao estoque
     * @param livro Os atributos do objeto Livro a ser atribuído
     * @return O livro adicionado
     */
    @PostMapping("/adicionaLivro")
    public Livro adicionaLivro(@RequestBody Livro livro) {
        return estoqueServico.adicionaLivro(livro);
    }

    /**
     * Endpoint para remover um livro do estoque
     * @param id O id do livro que deseja remover, passado pela query string
     * @return true se conseguiu remover e false se não encontrou o livro com o id especificado
     */
    @PostMapping("/removeLivro")
    public boolean removeLivro(@RequestParam("id") String id) {
        return estoqueServico.removerLivro(Integer.parseInt(id));
    }

    /**
     * Enpoint para consultar a lista de todos os clientes
     * @return A lista com so clientes cadastrados
     */
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteServico.retornaClientes();
    }

    /**
     * Enpoint para adicionar um novo cliente
     * @param cliente Os campos do objeto Cliente no formato json
     * @return O cliente adicionado
     */
    @PostMapping("/adicionaCliente")
    public Cliente adicionaCliente(@RequestBody Cliente cliente) {
        return clienteServico.adicionaCliente(cliente);
    }

    /**
     * Endpoint para remover um cliente
     * @param cpf O CPF do cliente que deseja remover
     * @return true se conseguiu remover e false se não encontrou o cliente com o CPF especificado
     */
    @PostMapping("/removeCliente")
    public boolean removeCliente(@RequestParam("cpf") String cpf) {
        return clienteServico.removeCliente(cpf);
    }

    /**
     * Endpoint para consultar todos os vendedores cadastrados
     * @return A lista com os vendedores
     */
    @GetMapping("/vendedores")
    public List<Vendedor> getVendedores() {
        return vendedorServico.retornaVendedores();
    }

    /**
     * Enpoint para adicionar um novo vendedor ao sistema
     * @param vendedor Os campos do objeto Vendedor no formato json
     * @return O objeto adicionado ao sistema
     */
    @PostMapping("/adicionaVendedor")
    public Vendedor adicionaVendedor(@RequestBody Vendedor vendedor) {
        return vendedorServico.adicionaVendedor(vendedor);
    }

    /**
     * Endpoint para remover um Vendedor
     * @param cpf O CPF do vendedor que deseja remover
     * @return true se conseguiu remover e false se não encontrou o vendedor com o CPF especificado
     */
    @PostMapping("/removeVendedor")
    public boolean removeVendedor(@RequestParam("cpf") String cpf) {
        return vendedorServico.removeVendedor(cpf);
    }
}
