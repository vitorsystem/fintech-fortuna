// br/com/fiap/fintech/service/TransacaoService.java

package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Conta;
import br.com.fiap.fintech.model.TipoTransacao;
import br.com.fiap.fintech.model.Transacao;
import br.com.fiap.fintech.repository.ContaRepository;
import br.com.fiap.fintech.repository.TipoTransacaoRepository;
import br.com.fiap.fintech.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Importante!

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TipoTransacaoRepository tipoTransacaoRepository;

    @Transactional
    public Transacao salvar(Transacao transacao) {
        // 1. Busca a conta que vai receber a transação
        Conta conta = contaRepository.findById(transacao.getConta().getIdConta())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        // 2. Busca o tipo da transação (para saber se é Receita ou Despesa)
        TipoTransacao tipo = tipoTransacaoRepository.findById(transacao.getTipoTransacao().getIdTipoTransacao())
                .orElseThrow(() -> new RuntimeException("Tipo de transação não encontrado"));

        // 3. Atualiza o saldo da conta
        double valor = transacao.getValor();

        if (tipo.getDsTipoTransacao().equals("RECEITA")) {
            conta.setSaldoAtual(conta.getSaldoAtual() + valor);
        } else if (tipo.getDsTipoTransacao().equals("DESPESA") || tipo.getDsTipoTransacao().equals("INVESTIMENTO")) {
            conta.setSaldoAtual(conta.getSaldoAtual() - valor);
        }

        // 4. Salva a conta com o saldo atualizado
        contaRepository.save(conta);

        // 5. Salva a transação
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarPorConta(int idConta) {
        return transacaoRepository.findAllByContaIdContaOrderByDataTransacaoDesc(idConta);
    }

    public Transacao buscarPorId(int id) {
        return transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada com ID: " + id));
    }

    // ATUALIZAR TRANSAÇÃO:
    @Transactional
    public Transacao atualizar(int id, Transacao transacaoNovosDados) {
        Transacao transacaoExistente = buscarPorId(id);

        transacaoExistente.setDescricao(transacaoNovosDados.getDescricao());

        return transacaoRepository.save(transacaoExistente);
    }

    // DELETAR TRANSAÇÃO:
    @Transactional
    public void deletar(int id) {
        Transacao transacao = buscarPorId(id);
        Conta conta = transacao.getConta();
        TipoTransacao tipo = transacao.getTipoTransacao();
        double valor = transacao.getValor();

        if (tipo.getDsTipoTransacao().equals("RECEITA")) {
            conta.setSaldoAtual(conta.getSaldoAtual() - valor);
        } else if (tipo.getDsTipoTransacao().equals("DESPESA") || tipo.getDsTipoTransacao().equals("INVESTIMENTO")) {
            conta.setSaldoAtual(conta.getSaldoAtual() + valor);
        }

        contaRepository.save(conta);
        transacaoRepository.delete(transacao);
    }
}