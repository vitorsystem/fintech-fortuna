// br/com/fiap/fintech/service/TipoTransacaoService.java

package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.TipoTransacao;
import br.com.fiap.fintech.repository.TipoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoTransacaoService {

    @Autowired
    private TipoTransacaoRepository tipoTransacaoRepository;

    public List<TipoTransacao> listarTodos() {
        return tipoTransacaoRepository.findAll();
    }
}