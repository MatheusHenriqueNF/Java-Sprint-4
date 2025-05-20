package br.com.fiap.bo;

import java.util.*;

public class CaminhoBO {

    // Classe interna representando o grafo
    public static class Grafo {
        private final Map<String, List<String>> adjacencia = new HashMap<>();

        public void addEdge(String origem, String destino) {
            adjacencia.putIfAbsent(origem, new ArrayList<>());
            adjacencia.get(origem).add(destino);
        }

        public List<String> caminhoMaisCurto(String origem, String destino) {
            Queue<String> fila = new LinkedList<>();
            Map<String, String> predecessores = new HashMap<>();
            Set<String> visitados = new HashSet<>();

            fila.add(origem);
            visitados.add(origem);

            while (!fila.isEmpty()) {
                String atual = fila.poll();

                if (atual.equals(destino)) {
                    List<String> caminho = new ArrayList<>();
                    for (String s = destino; s != null; s = predecessores.get(s)) {
                        caminho.add(s);
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

            return Collections.emptyList(); // Se não encontrar caminho
        }
    }

    // Método para criar o grafo padrão da malha ferroviária
    public static Grafo criarGrafoPadrao() {
        Grafo grafo = new Grafo();

        grafo.addEdge("Júlio Prestes", "Palmeiras-Barra Funda");
        grafo.addEdge("Palmeiras-Barra Funda", "Júlio Prestes");
        grafo.addEdge("Palmeiras-Barra Funda", "Lapa");
        grafo.addEdge("Lapa", "Palmeiras-Barra Funda");
        grafo.addEdge("Lapa", "Domingos de Moraes");
        grafo.addEdge("Domingos de Moraes", "Lapa");
        grafo.addEdge("Domingos de Moraes", "Imperatriz Leopoldina");
        grafo.addEdge("Imperatriz Leopoldina", "Domingos de Moraes");
        grafo.addEdge("Imperatriz Leopoldina", "Presidente Altino");
        grafo.addEdge("Presidente Altino", "Imperatriz Leopoldina");
        grafo.addEdge("Presidente Altino", "Osasco");
        grafo.addEdge("Osasco", "Presidente Altino");
        grafo.addEdge("Osasco", "Comandante Sampaio");
        grafo.addEdge("Comandante Sampaio", "Osasco");
        grafo.addEdge("Comandante Sampaio", "Quitaúna");
        grafo.addEdge("Quitaúna", "Comandante Sampaio");
        grafo.addEdge("Quitaúna", "General Miguel Costa");
        grafo.addEdge("General Miguel Costa", "Quitaúna");
        grafo.addEdge("General Miguel Costa", "Carapicuíba");
        grafo.addEdge("Carapicuíba", "General Miguel Costa");
        grafo.addEdge("Carapicuíba", "Santa Terezinha");
        grafo.addEdge("Santa Terezinha", "Carapicuíba");
        grafo.addEdge("Santa Terezinha", "Antonio João");
        grafo.addEdge("Antonio João", "Santa Terezinha");
        grafo.addEdge("Antonio João", "Barueri");
        grafo.addEdge("Barueri", "Antonio João");
        grafo.addEdge("Barueri", "Jardim Belval");
        grafo.addEdge("Jardim Belval", "Barueri");
        grafo.addEdge("Jardim Belval", "Jardim Silveira");
        grafo.addEdge("Jardim Silveira", "Jardim Belval");
        grafo.addEdge("Jardim Silveira", "Jandira");
        grafo.addEdge("Jandira", "Jardim Silveira");
        grafo.addEdge("Jandira", "Sagrado Coração");
        grafo.addEdge("Sagrado Coração", "Jandira");
        grafo.addEdge("Sagrado Coração", "Engenheiro Cardoso");
        grafo.addEdge("Engenheiro Cardoso", "Sagrado Coração");
        grafo.addEdge("Engenheiro Cardoso", "Itapevi");
        grafo.addEdge("Itapevi", "Engenheiro Cardoso");
        grafo.addEdge("Itapevi", "Amador Bueno");
        grafo.addEdge("Amador Bueno", "Itapevi");

        return grafo;
    }
}
