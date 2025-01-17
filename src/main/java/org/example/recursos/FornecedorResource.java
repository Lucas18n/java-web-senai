package org.example.recursos;


import org.example.entidades.Fornecedor;
import org.example.servicos.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorService fornecedorService;

    //busca todos fornecedor
    @GetMapping
    public List<Fornecedor> findAll(){
        return fornecedorService.buscarTodos();
    }

    //busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id){
        return fornecedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Inseri fornecedor
    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor){
        return fornecedorService.inserir(fornecedor);
    }

    //atualizar fornecedor
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id,
                                             @RequestBody Fornecedor fornecedor){
        return fornecedorService.buscarPorId(id)
                .map(existingFornecedor -> {
            fornecedor.setIdFornecedor(existingFornecedor.getIdFornecedor());
            return ResponseEntity.ok(fornecedorService.inserir(fornecedor));
        })
                .orElse(ResponseEntity.notFound().build());
    }

    //deletar fornecedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return fornecedorService.buscarPorId(id)
                .map(existingFornecedor -> {
                    fornecedorService.deleteId(id);
                    return ResponseEntity.notFound().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
