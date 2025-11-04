// br/com/fiap/fintech/controller/TransacaoController.java

package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Transacao;
import br.com.fiap.fintech.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    // --- POST (Criar) ---
    @PostMapping
    public ResponseEntity<Transacao> create(@RequestBody Transacao transacao) {
        try {
            Transacao novaTransacao = transacaoService.salvar(transacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // --- GET (Listar por Conta) ---
    @GetMapping("/conta/{idConta}")
    public ResponseEntity<List<Transacao>> getTransacoesPorConta(@PathVariable int idConta) {
        List<Transacao> transacoes = transacaoService.listarPorConta(idConta);
        return ResponseEntity.ok(transacoes);
    }

    // --- GET (Buscar por ID da Transação) ---
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getTransacaoById(@PathVariable int id) {
        try {
            Transacao transacao = transacaoService.buscarPorId(id);
            return ResponseEntity.ok(transacao);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- PUT ---
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> update(@PathVariable int id, @RequestBody Transacao transacaoNovosDados) {
        try {
            Transacao transacaoAtualizada = transacaoService.atualizar(id, transacaoNovosDados);
            return ResponseEntity.ok(transacaoAtualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            transacaoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}