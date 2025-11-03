// br/com/fiap/fintech/repository/CategoriaTransacaoRepository.java

package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.CategoriaTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaTransacaoRepository extends JpaRepository<CategoriaTransacao, Integer> {
}