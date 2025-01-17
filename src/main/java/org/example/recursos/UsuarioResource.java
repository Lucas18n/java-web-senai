package org.example.recursos;

import org.example.entidades.Usuario;
import org.example.servicos.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    // Busca todos os usuários
    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.buscarTodos();
    }

    // Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Insere usuário
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.inserir(usuario);
    }

    // Atualiza usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id,
                                          @RequestBody Usuario usuario) {
        return usuarioService.buscarPorId(id)
                .map(existingUsuario -> {
                    usuario.setId(existingUsuario.getId());
                    return ResponseEntity.ok(usuarioService.inserir(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deleta usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(existingUsuario -> {
                    usuarioService.deleteId(id);
                    return ResponseEntity.notFound().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
