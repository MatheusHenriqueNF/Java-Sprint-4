package br.com.fiap.service;

import br.com.fiap.bo.CaminhoBO;

import java.util.List;

public class CaminhoService {

    public List<String> calcular(String origem, String destino) {
        CaminhoBO.Grafo grafo = CaminhoBO.criarGrafoPadrao();
        return grafo.caminhoMaisCurto(origem, destino);
    }
}
