package org.example.recursos;

import org.example.entidades.Cliente;
import org.example.servicos.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.buscarTodos();
    }

    // Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Insere cliente
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.inserir(cliente);
    }

    // Atualiza cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id,
                                          @RequestBody Cliente cliente) {
        return clienteService.buscarPorId(id)
                .map(existingCliente -> {
                    cliente.setidCliente(existingCliente.getidCliente());
                    return ResponseEntity.ok(clienteService.inserir(cliente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deleta cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(existingCliente -> {
                    clienteService.deleteId(id);
                    return ResponseEntity.notFound().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
