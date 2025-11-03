package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // --- GET (Listar todos) ---
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    // --- GET (Buscar por ID) ---
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        try {
            Usuario usuario = usuarioService.buscarPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- POST (Criar) ---
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // --- PUT (Atualizar) ---
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable int id, @RequestBody Usuario usuarioNovosDados) {
        try {
            Usuario usuarioAtualizado = usuarioService.atualizar(id, usuarioNovosDados);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE (Deletar) ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}