// br/com/fiap/fintech/service/MetaService.java

package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Meta;
import br.com.fiap.fintech.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public Meta salvar(Meta meta) {
        // TODO: Adicionar validações de negócio, se necessário
        // (ex: data limite não pode ser no passado)
        return metaRepository.save(meta);
    }

    public List<Meta> listarPorConta(int idConta) {
        return metaRepository.findAllByContaIdConta(idConta);
    }

    public Meta buscarPorId(int id) {
        return metaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meta não encontrada com ID: " + id));
    }

    public Meta atualizar(int id, Meta metaNovosDados) {
        Meta metaExistente = buscarPorId(id);

        // Atualiza os campos
        metaExistente.setNomeMeta(metaNovosDados.getNomeMeta());
        metaExistente.setValorObjetivo(metaNovosDados.getValorObjetivo());
        metaExistente.setDataLimite(metaNovosDados.getDataLimite());

        return metaRepository.save(metaExistente);
    }

    public void deletar(int id) {
        Meta meta = buscarPorId(id); // Garante que existe
        metaRepository.delete(meta);
    }
}