package org.example.servicos;



import org.example.entidades.Produto;
import org.example.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    //buscar por produtos
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    //buscar por Id do Produto
    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    //inserir produto
    public Produto inserir(Produto produto){
        return produtoRepository.save(produto);
    }

    //atualizar produto
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNomeProduto(produtoAtualizado.getNomeProduto());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
            produto.setPrecoCusto(produtoAtualizado.getPrecoCusto());
            produto.setFornecedor(produtoAtualizado.getFornecedor());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    //deletar produto
    public void deleteId (Long id){
        produtoRepository.deleteById(id);
    }
}
