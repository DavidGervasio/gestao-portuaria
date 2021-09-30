package com.david.gestaoportuaria.repositorys;

import javax.transaction.Transactional;

import com.david.gestaoportuaria.models.Conteiner;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ConteinerRepository extends JpaRepository<Conteiner, Long> {
    Conteiner findById(long id);

}
