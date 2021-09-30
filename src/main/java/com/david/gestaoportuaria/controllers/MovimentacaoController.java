package com.david.gestaoportuaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import com.david.gestaoportuaria.utility.SimplesResposta;

import java.util.List;

import com.david.gestaoportuaria.models.Movimentacao;
import com.david.gestaoportuaria.repositorys.MovimentacaoRepository;
import com.david.gestaoportuaria.repositorys.ConteinerRepository;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping(value = "/api")
public class MovimentacaoController {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    ConteinerRepository conteinerRepository;

    @PostMapping("/movimentacoes")
    public Movimentacao criarMovimentacao(@RequestBody Movimentacao movimentacao) {
        //se o conteiner não existir então não se pode criar uma movimentação 
        if (conteinerRepository.findById(movimentacao.getIdConteiner()) == null) {
            return null;
        }
        
        if (!Movimentacao.validarTipoDeMovimentacao(movimentacao.getTipoDeMovimentacao())) {
            return null;
        }

        return movimentacaoRepository.save(movimentacao);

    }

    @GetMapping("/movimentacoes/{id}")
    public Movimentacao buscarMovimentacao(@PathVariable(value = "id") long id) {
        return movimentacaoRepository.findById(id);

    }

    @GetMapping("/movimentacoes")
    public List<Movimentacao> listaMovimentacoes() {
        return movimentacaoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/movimentacoes/cliente")
    public List<Object> ListarRelatorio(String nomeDoCliente, String tipoDeMovimentacao) {
        return movimentacaoRepository.listarRelatorio(nomeDoCliente, tipoDeMovimentacao);
    }

    @PutMapping("/movimentacoes")
    public Movimentacao atualizaMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    @DeleteMapping("/movimentacoes/{id}")
    public SimplesResposta deletaMovimentacao(@PathVariable(value = "id") long id) {

        try {
            movimentacaoRepository.deleteById(id);
            return new SimplesResposta("Contêiner excluido com sucesso");
        } catch (Exception e) {
            return new SimplesResposta("Não foi possivel deletar o contêiner");

        }

    }

}
