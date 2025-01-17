package org.example.recursos;

import org.example.entidades.FormaPagamento;
import org.example.servicos.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/formaspagamento")
public class FormaPagamentoResource {
    @Autowired
    private FormaPagamentoService formaPagamentoService;

    // Busca todos os tipos de forma de pagamento
    @GetMapping
    public List<FormaPagamento> findAll() {
        return formaPagamentoService.buscarTodos();
    }

    // Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> findById(@PathVariable Long id) {
        return formaPagamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Insere forma de pagamento
    @PostMapping
    public FormaPagamento create(@RequestBody FormaPagamento formaPagamento) {
        return formaPagamentoService.inserir(formaPagamento);
    }

    // Atualiza forma de pagamento
    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> update(@PathVariable Long id,
                                                 @RequestBody FormaPagamento formaPagamento) {
        return formaPagamentoService.buscarPorId(id)
                .map(existingFormaPagamento -> {
                    formaPagamento.setId(existingFormaPagamento.getId());
                    return ResponseEntity.ok(formaPagamentoService.inserir(formaPagamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deleta forma de pagamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return formaPagamentoService.buscarPorId(id)
                .map(existingFormaPagamento -> {
                    formaPagamentoService.deleteId(id);
                    return ResponseEntity.notFound().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
