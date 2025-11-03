package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Conta;
import br.com.fiap.fintech.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    // --- POST (Criar) ---
    public Conta salvar(Conta conta) {
        if (conta.getIdConta() == 0) {
            conta.setSaldoAtual(conta.getSaldoInicial());
        }
        return contaRepository.save(conta);
    }

    // --- GET (Listar por Usuário) ---
    public List<Conta> listarContasPorUsuario(int idUsuario) {
        return contaRepository.findAllByUsuarioIdUsuario(idUsuario);
    }

    // --- GET (Buscar por ID da Conta) ---
    public Conta buscarPorId(int id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada com ID: " + id));
    }

    // --- PUT (Atualizar) ---
    public Conta atualizar(int id, Conta contaNovosDados) {
        Conta contaExistente = buscarPorId(id);
        contaExistente.setNomeConta(contaNovosDados.getNomeConta());
        return contaRepository.save(contaExistente);
    }

    // --- DELETE (Deletar) ---
    public void deletar(int id) {
        Conta contaParaDeletar = buscarPorId(id);
        contaRepository.delete(contaParaDeletar);
    }
}