package br.com.fiap.beans;

import java.util.*;

public class Grafo {

    private final Map<String, List<String>> adjacencia;

    public Grafo() {
        this.adjacencia = new HashMap<>();
    }

    public void adicionarAresta(String origem, String destino) {
        adjacencia.putIfAbsent(origem, new ArrayList<>());
        adjacencia.get(origem).add(destino);
    }

    public List<String> encontrarCaminho(String origem, String destino) {
        Queue<String> fila = new LinkedList<>();
        Map<String, String> predecessores = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            String atual = fila.poll();

            if (atual.equals(destino)) {
                List<String> caminho = new ArrayList<>();
                for (String estacao = destino; estacao != null; estacao = predecessores.get(estacao)) {
                    caminho.add(estacao);
                }
                Collections.reverse(caminho);
                return caminho;
            }

            for (String vizinho : adjacencia.getOrDefault(atual, new ArrayList<>())) {
                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                    predecessores.put(vizinho, atual);
                }
            }
        }

        return Collections.emptyList(); // Nenhum caminho encontrado
    }
}