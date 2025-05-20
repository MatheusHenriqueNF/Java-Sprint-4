package br.com.fiap.dto;

import java.util.List;

public class RotaDTO {
    private List<String> caminho;

    public RotaDTO() {}
    public RotaDTO(List<String> caminho) {
        this.caminho = caminho;
    }

    public List<String> getCaminho() { return caminho; }
    public void setCaminho(List<String> caminho) { this.caminho = caminho; }
}