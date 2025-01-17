package org.example.recursos;

import org.example.entidades.Fornecedor;
import org.example.entidades.Produto;
import org.example.servicos.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {


    @Autowired
    private ProdutoService produtoService;

    //busca todos produtos
    @GetMapping
    public List<Produto> findAll(){
        return produtoService.buscarTodos();
    }

    //busca pelo o ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //Inseri produto
    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    //atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id,
                                             @RequestBody Produto produto){
        return produtoService.buscarPorId(id)
                .map(existingProduto -> {
                    produto.setIdProduto(existingProduto.getIdProduto());
                    return ResponseEntity.ok(produtoService.inserir(produto));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    //deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return produtoService.buscarPorId(id)
                .map(existingProduto -> {
                    produtoService.deleteId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
