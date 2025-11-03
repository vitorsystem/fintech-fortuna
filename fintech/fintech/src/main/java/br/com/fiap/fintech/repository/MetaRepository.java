// br/com/fiap/fintech/repository/MetaRepository.java

package br.com.fiap.fintech.repository;

import br.com.fiap.fintech.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Integer> {

    List<Meta> findAllByContaIdConta(int idConta);
}