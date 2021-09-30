package com.david.gestaoportuaria.utility;

//Classa respossavel por encapsular messagem de 
//retorno de uma requisição
public class SimplesResposta {

    String menssagem;

    public SimplesResposta(String menssagem) {
        this.menssagem = menssagem;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

}
