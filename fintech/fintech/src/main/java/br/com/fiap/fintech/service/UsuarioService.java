package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getHashSenha());
        usuario.setHashSenha(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public Usuario atualizar(int id, Usuario usuarioNovosDados) {
        Usuario usuarioExistente = buscarPorId(id);

        usuarioExistente.setNomeUsuario(usuarioNovosDados.getNomeUsuario());
        usuarioExistente.setEmailUsuario(usuarioNovosDados.getEmailUsuario());
        usuarioExistente.setTelefone(usuarioNovosDados.getTelefone());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletar(int id) {
        buscarPorId(id);
        usuarioRepository.deleteById(id);
    }
}