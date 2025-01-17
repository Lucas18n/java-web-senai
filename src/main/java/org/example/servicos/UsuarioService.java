package org.example.servicos;

import org.example.entidades.Usuario;
import org.example.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository UsuarioRepository;

    //buscar por fornecedores
    public List<Usuario> buscarTodos(){
        return UsuarioRepository.findAll();
    }

    //buscar por Id do Fornecedor
    public Optional<Usuario> buscarPorId(Long id){
        return UsuarioRepository.findById(id);
    }

    //inserir fornecedor
    public Usuario inserir(Usuario usuario){
        return UsuarioRepository.save(usuario);
    }

    //deletar fornecedor
    public void deleteId(Long id){
        UsuarioRepository.deleteById(id);
    }

}
