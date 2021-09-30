package com.david.gestaoportuaria.repositorys;

import java.util.List;

import com.david.gestaoportuaria.models.Movimentacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    Movimentacao findById(long id);

    @Query(value = "SELECT c.cliente, m.dataehora_do_fim, m.dataehora_do_inicio , m.tipo_de_movimentacao, m.id_conteiner, c.categoria  FROM tb_movimentacao AS m INNER JOIN tb_conteiner AS c ON m.id_conteiner = c.id WHERE c.cliente = ?1 AND tipo_de_movimentacao = ?2", nativeQuery = true)
    List<Object> listarRelatorio(String nomeDoCliente, String tipoDeMovimentacao);
}
