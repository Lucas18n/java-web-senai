package org.example.servicos;



import org.example.entidades.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    public org.example.repositorios.ContatoRepository ContatoRepository;

    //buscar por fornecedores
    public List<Contato> buscarTodos(){
        return ContatoRepository.findAll();
    }

    //buscar por Id do Fornecedor
    public Optional<Contato> buscarPorId(Long id){
        return ContatoRepository.findById(id);
    }

    //inserir fornecedor
    public Contato inserir(Contato contato){
        return ContatoRepository.save(contato);
    }

    //deletar fornecedor
    public void deleteId(Long id){
        ContatoRepository.deleteById(id);
    }

}
