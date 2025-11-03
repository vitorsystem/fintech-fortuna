package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Conta;
import br.com.fiap.fintech.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    // --- GET (Listar contas de um usuário) ---
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Conta>> getContasPorUsuario(@PathVariable int idUsuario) {
        List<Conta> contas = contaService.listarContasPorUsuario(idUsuario);
        return ResponseEntity.ok(contas);
    }

    // --- GET (Buscar UMA conta pelo ID dela) ---
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable int id) {
        try {
            Conta conta = contaService.buscarPorId(id);
            return ResponseEntity.ok(conta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- POST (Criar uma nova conta) ---
    @PostMapping
    public ResponseEntity<Conta> create(@RequestBody Conta conta) {
        Conta novaConta = contaService.salvar(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
    }

    // --- PUT (Atualizar o nome de uma conta) ---
    @PutMapping("/{id}")
    public ResponseEntity<Conta> update(@PathVariable int id, @RequestBody Conta contaNovosDados) {
        try {
            Conta contaAtualizada = contaService.atualizar(id, contaNovosDados);
            return ResponseEntity.ok(contaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE (Deletar uma conta) ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            contaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}