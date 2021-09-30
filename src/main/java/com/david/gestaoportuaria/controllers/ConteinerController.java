package com.david.gestaoportuaria.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse.Context;

import com.david.gestaoportuaria.repositorys.ConteinerRepository;
import com.david.gestaoportuaria.utility.SimplesResposta;

import java.util.List;

import com.david.gestaoportuaria.models.Conteiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * conteinerControler
 */
@CrossOrigin(origins = "*")

@RestController
@RequestMapping(value = "/api")
public class ConteinerController {

    @Autowired
    ConteinerRepository conteinerRepository;

    @PostMapping("/conteiner")
    public Conteiner criarConteiner(@RequestBody Conteiner conteiner) {

        if (!Conteiner.validarStatus(conteiner.getStatus())) {
            return null;
        }

        return conteinerRepository.save(conteiner);

    }

    @GetMapping("/conteiner/{id}")
    public Conteiner buscarConteiner(@PathVariable(value = "id") long id) {
        return conteinerRepository.findById(id);

    }

    @GetMapping("/conteiner")
    public List<Conteiner> listaConteiner() {
        return conteinerRepository.findAll(Sort.by(Sort.Direction.ASC, "cliente"));
    }

    @PutMapping("/conteiner")
    public Conteiner atualizaConteiner(@RequestBody Conteiner conteiner) {
        return conteinerRepository.save(conteiner);
    }

    @DeleteMapping("/conteiner/{id}")
    public SimplesResposta deletaConteiner(@PathVariable(value = "id") long id) {

        try {
            conteinerRepository.deleteById(id);
            return new SimplesResposta("Contêiner excluido com sucesso");
        } catch (Exception e) {
            return new SimplesResposta("Não foi possivel deletar o contêiner");

        }

    }

}