package org.example.servicos;

import org.example.entidades.Fornecedor;
import org.example.repositorios.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {


    @Autowired
    public FornecedorRepository fornecedorRepository;

    //buscar por fornecedores
    public List<Fornecedor> buscarTodos(){
        return fornecedorRepository.findAll();
    }

    //buscar por Id do Fornecedor
    public Optional<Fornecedor> buscarPorId(Long id){
        return fornecedorRepository.findById(id);
    }

    //inserir fornecedor
    public Fornecedor inserir(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    //deletar fornecedor
    public void deleteId(Long id){
        fornecedorRepository.deleteById(id);
    }
}
