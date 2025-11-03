// br/com/fiap/fintech/repository/TipoTransacaoRepository.java

package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao, Integer> {
}