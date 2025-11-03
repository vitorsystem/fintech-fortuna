package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.CategoriaTransacao;
import br.com.fiap.fintech.repository.CategoriaTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaTransacaoService {

    @Autowired
    private CategoriaTransacaoRepository categoriaTransacaoRepository;

    public List<CategoriaTransacao> listarTodos() {
        return categoriaTransacaoRepository.findAll();
    }
}