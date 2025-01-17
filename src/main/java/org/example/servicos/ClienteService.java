package org.example.servicos;

import org.example.entidades.Cliente;
import org.example.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository ClienteRepository;

    //buscar por fornecedores
    public List<Cliente> buscarTodos(){
        return ClienteRepository.findAll();
    }

    //buscar por Id do Fornecedor
    public Optional<Cliente> buscarPorId(Long id){
        return ClienteRepository.findById(id);
    }

    //inserir fornecedor
    public Cliente inserir(Cliente cliente){
        return ClienteRepository.save(cliente);
    }

    //deletar fornecedor
    public void deleteId(Long id){
        ClienteRepository.deleteById(id);
    }
}
