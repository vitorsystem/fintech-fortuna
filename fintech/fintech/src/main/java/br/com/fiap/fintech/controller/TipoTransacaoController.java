// br/com/fiap/fintech/controller/TipoTransacaoController.java

package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.TipoTransacao;
import br.com.fiap.fintech.service.TipoTransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-transacao")
public class TipoTransacaoController {

    @Autowired
    private TipoTransacaoService tipoTransacaoService;

    @GetMapping
    public ResponseEntity<List<TipoTransacao>> getAllTiposTransacao() {
        return ResponseEntity.ok(tipoTransacaoService.listarTodos());
    }
}