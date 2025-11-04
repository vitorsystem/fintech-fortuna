// br/com/fiap/fintech/controller/MetaController.java

package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Meta;
import br.com.fiap.fintech.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    // --- POST ---
    // Ex: { "nomeMeta": "Viagem Japão", "valorObjetivo": 15000, "dataLimite": "2026-12-31", "conta": { "idConta": 1 } }
    @PostMapping
    public ResponseEntity<Meta> create(@RequestBody Meta meta) {
        Meta novaMeta = metaService.salvar(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMeta);
    }

    // --- GET ---
    @GetMapping("/conta/{idConta}")
    public ResponseEntity<List<Meta>> getMetasPorConta(@PathVariable int idConta) {
        List<Meta> metas = metaService.listarPorConta(idConta);
        return ResponseEntity.ok(metas);
    }

    // --- GET ---
    @GetMapping("/{id}")
    public ResponseEntity<Meta> getMetaById(@PathVariable int id) {
        try {
            Meta meta = metaService.buscarPorId(id);
            return ResponseEntity.ok(meta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- PUT ---
    @PutMapping("/{id}")
    public ResponseEntity<Meta> update(@PathVariable int id, @RequestBody Meta metaNovosDados) {
        try {
            Meta metaAtualizada = metaService.atualizar(id, metaNovosDados);
            return ResponseEntity.ok(metaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            metaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}