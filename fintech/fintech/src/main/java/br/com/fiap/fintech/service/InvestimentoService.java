package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public Investimento salvar(Investimento investimento) {
        return investimentoRepository.save(investimento);
    }

    public List<Investimento> listarPorConta(int idConta) {
        return investimentoRepository.findAllByContaIdConta(idConta);
    }

    public Investimento buscarPorId(int id) {
        return investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado com ID: " + id));
    }

    public Investimento atualizar(int id, Investimento investimentoNovosDados) {
        Investimento investimentoExistente = buscarPorId(id);

        investimentoExistente.setTipoInvestimento(investimentoNovosDados.getTipoInvestimento());
        investimentoExistente.setRentabilidadeAtual(investimentoNovosDados.getRentabilidadeAtual());

        return investimentoRepository.save(investimentoExistente);
    }

    public void deletar(int id) {
        Investimento investimento = buscarPorId(id);
        investimentoRepository.delete(investimento);
    }
}