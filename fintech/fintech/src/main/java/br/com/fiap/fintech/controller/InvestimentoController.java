package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    // --- POST ---
    // o JSON de entrada vai precisar do ID da conta
    @PostMapping
    public ResponseEntity<Investimento> create(@RequestBody Investimento investimento) {
        Investimento novoInvestimento = investimentoService.salvar(investimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoInvestimento);
    }

    // --- GET
    @GetMapping("/conta/{idConta}")
    public ResponseEntity<List<Investimento>> getInvestimentosPorConta(@PathVariable int idConta) {
        List<Investimento> investimentos = investimentoService.listarPorConta(idConta);
        return ResponseEntity.ok(investimentos);
    }

    // --- GET
    @GetMapping("/{id}")
    public ResponseEntity<Investimento> getInvestimentoById(@PathVariable int id) {
        try {
            Investimento investimento = investimentoService.buscarPorId(id);
            return ResponseEntity.ok(investimento);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- PUT
    @PutMapping("/{id}")
    public ResponseEntity<Investimento> update(@PathVariable int id, @RequestBody Investimento investimentoNovosDados) {
        try {
            Investimento investimentoAtualizado = investimentoService.atualizar(id, investimentoNovosDados);
            return ResponseEntity.ok(investimentoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            investimentoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}