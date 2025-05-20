package br.com.fiap.bo;

import br.com.fiap.model.EstacaoModel;

public class EstacaoBO {
    private EstacaoModel estacao;

    public EstacaoBO(EstacaoModel estacao) {
        this.estacao = estacao;
    }

    public boolean isAtiva() {
        return "ativo".equalsIgnoreCase(estacao.getStatus());
    }

    public String getNomeMaiusculo() {
        return estacao.getNomeEstacao().toUpperCase();
    }
}