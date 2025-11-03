package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.CategoriaTransacao;
import br.com.fiap.fintech.service.CategoriaTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias-transacao")
public class CategoriaTransacaoController {

    @Autowired
    private CategoriaTransacaoService categoriaTransacaoService;

    @GetMapping
    public ResponseEntity<List<CategoriaTransacao>> getAllCategoriasTransacao() {
        return ResponseEntity.ok(categoriaTransacaoService.listarTodos());
    }

}