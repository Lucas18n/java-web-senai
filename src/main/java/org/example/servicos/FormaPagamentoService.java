package org.example.servicos;

import org.example.entidades.FormaPagamento;
import org.example.repositorios.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    @Autowired
    public FormaPagamentoRepository FormaPagamentoRepository;

    //buscar por fornecedores
    public List<FormaPagamento> buscarTodos(){
        return FormaPagamentoRepository.findAll();
    }

    //buscar por Id do Fornecedor
    public Optional<FormaPagamento> buscarPorId(Long id){
        return FormaPagamentoRepository.findById(id);
    }

    //inserir fornecedor
    public FormaPagamento inserir(FormaPagamento formaPagamento){
        return FormaPagamentoRepository.save(formaPagamento);
    }

    //deletar fornecedor
    public void deleteId(Long id){
        FormaPagamentoRepository.deleteById(id);
    }

}
