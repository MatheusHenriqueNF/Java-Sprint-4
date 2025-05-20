package br.com.fiap.beans;

import javax.swing.*;
import java.util.*;

public class Caminho {
    // Classe Grafo para representar o mapa
    public static class Grafo {
        private final Map<String, List<String>> adjacencia;

        public Grafo() {
            adjacencia = new HashMap<>();
        }

        public void addEdge(String origem, String destino, int peso) {
            adjacencia.putIfAbsent(origem, new ArrayList<>());
            adjacencia.get(origem).add(destino);
        }

        public List<String> caminhoMaisCurto(String origem, String destino) {
            // Algoritmo de busca em largura (BFS) para encontrar o caminho mais curto
            Queue<String> fila = new LinkedList<>();
            Map<String, String> predecessores = new HashMap<>();
            Set<String> visitados = new HashSet<>();

            fila.add(origem);
            visitados.add(origem);

            while (!fila.isEmpty()) {
                String atual = fila.poll();

                if (atual.equals(destino)) {
                    List<String> caminho = new ArrayList<>();
                    for (String station = destino; station != null; station = predecessores.get(station)) {
                        caminho.add(station);
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
            return Collections.emptyList(); // Se não encontrar o caminho
        }
    }

    // Método para consultar o caminho
    public static void consultarCaminho() {
        String origem = JOptionPane.showInputDialog(null, "Qual estação você está?");
        String destino = JOptionPane.showInputDialog(null, "Qual estação você quer ir?");

        // Criar o grafo e adicionar as arestas
        Grafo grafo = new Grafo();

        // Linha 1 - Azul
        grafo.addEdge("Jabaquara", "Conceição",1);
        grafo.addEdge("Conceição", "Jabaquara",1);

        grafo.addEdge("Conceição", "São Judas",1);
        grafo.addEdge("São Judas", "Conceição",1);

        grafo.addEdge("São Judas", "Saúde",1);
        grafo.addEdge("Saúde", "São Judas",1);

        grafo.addEdge("Saúde", "Praça da Árvore",1);
        grafo.addEdge("Praça da Árvore", "Saúde",1);

        grafo.addEdge("Praça da Árvore", "Santa Cruz",1);
        grafo.addEdge("Santa Cruz", "Praça da Árvore",1);

        grafo.addEdge("Santa Cruz", "Vila Mariana",1);
        grafo.addEdge("Vila Mariana", "Santa Cruz",1);

        grafo.addEdge("Vila Mariana", "Ana Rosa",1);
        grafo.addEdge("Ana Rosa", "Vila Mariana",1);

        grafo.addEdge("Ana Rosa", "Paraíso",1);
        grafo.addEdge("Paraíso", "Ana Rosa",1);

        grafo.addEdge("Paraíso", "Vergueiro",1);
        grafo.addEdge("Vergueiro", "Paraíso",1);

        grafo.addEdge("Vergueiro", "São Joaquim",1);
        grafo.addEdge("São Joaquim", "Vergueiro",1);

        grafo.addEdge("São Joaquim", "Liberdade",1);
        grafo.addEdge("Liberdade", "São Joaquim",1);

        grafo.addEdge("Liberdade", "Sé",1);
        grafo.addEdge("Sé", "Liberdade",1);

        grafo.addEdge("Sé", "São Bento",1);
        grafo.addEdge("São Bento", "Sé",1);

        grafo.addEdge("São Bento", "Luz",1);
        grafo.addEdge("Luz", "São Bento",1);

        grafo.addEdge("Luz", "Tiradentes",1);
        grafo.addEdge("Tiradentes", "Luz",1);

        grafo.addEdge("Tiradentes", "Armênia",1);
        grafo.addEdge("Armênia", "Tiradentes",1);

        grafo.addEdge("Armênia", "Portuguesa-Tietê",1);
        grafo.addEdge("Portuguesa-Tietê", "Armênia",1);

        grafo.addEdge("Portuguesa-Tietê", "Carandiru",1);
        grafo.addEdge("Carandiru", "Portuguesa-Tietê",1);

        grafo.addEdge("Carandiru", "Santana",1);
        grafo.addEdge("Santana", "Carandiru",1);

        grafo.addEdge("Santana", "Jardim São Paulo-Ayrton Senna",1);
        grafo.addEdge("Jardim São Paulo-Ayrton Senna", "Santana",1);

        grafo.addEdge("Jardim São Paulo-Ayrton Senna", "Parada Inglesa",1);
        grafo.addEdge("Parada Inglesa", "Jardim São Paulo-Ayrton Senna",1);

        grafo.addEdge("Parada Inglesa", "Tucuruvi",1);
        grafo.addEdge("Tucuruvi", "Parada Inglesa",1);


        // Linha 2 - Verde
        grafo.addEdge("Vila Prudente", "Tamanduateí", 1);
        grafo.addEdge("Tamanduateí", "Vila Prudente", 1);

        grafo.addEdge("Tamanduateí", "Sacomã", 1);
        grafo.addEdge("Sacomã", "Tamanduateí", 1);

        grafo.addEdge("Sacomã", "Alto do Ipiranga", 1);
        grafo.addEdge("Alto do Ipiranga", "Sacomã", 1);

        grafo.addEdge("Alto do Ipiranga", "Santos-Imigrantes", 1);
        grafo.addEdge("Santos-Imigrantes", "Alto do Ipiranga", 1);

        grafo.addEdge("Santos-Imigrantes", "Chácara Klabin", 1);
        grafo.addEdge("Chácara Klabin", "Santos-Imigrantes", 1);

        grafo.addEdge("Chácara Klabin", "Ana Rosa", 1); // baldeação com Linha Azul
        grafo.addEdge("Ana Rosa", "Chácara Klabin", 1);

        grafo.addEdge("Ana Rosa", "Paraíso", 1); // conexão direta com a Linha Azul
        grafo.addEdge("Paraíso", "Ana Rosa", 1);

        grafo.addEdge("Paraíso", "Brigadeiro", 1);
        grafo.addEdge("Brigadeiro", "Paraíso", 1);

        grafo.addEdge("Brigadeiro", "Trianon-Masp", 1);
        grafo.addEdge("Trianon-Masp", "Brigadeiro", 1);

        grafo.addEdge("Trianon-Masp", "Consolação", 1);
        grafo.addEdge("Consolação", "Trianon-Masp", 1);

        grafo.addEdge("Consolação", "Clínicas", 1);
        grafo.addEdge("Clínicas", "Consolação", 1);

        grafo.addEdge("Clínicas", "Santuário Nossa Senhora de Fátima - Sumaré", 1);
        grafo.addEdge("Santuário Nossa Senhora de Fátima - Sumaré", "Clínicas", 1);

        grafo.addEdge("Santuário Nossa Senhora de Fátima - Sumaré", "Vila Madalena", 1);
        grafo.addEdge("Vila Madalena", "Santuário Nossa Senhora de Fátima - Sumaré", 1);

        // Linha 3 - Vermelha

        grafo.addEdge("Corinthians-Itaquera", "Artur Alvim", 1);
        grafo.addEdge("Artur Alvim", "Corinthians-Itaquera", 1);

        grafo.addEdge("Artur Alvim", "Patriarca", 1);
        grafo.addEdge("Patriarca", "Artur Alvim", 1);

        grafo.addEdge("Patriarca", "Guilhermina-Esperança", 1);
        grafo.addEdge("Guilhermina-Esperança", "Patriarca", 1);

        grafo.addEdge("Guilhermina-Esperança", "Vila Matilde", 1);
        grafo.addEdge("Vila Matilde", "Guilhermina-Esperança", 1);

        grafo.addEdge("Vila Matilde", "Penha", 1);
        grafo.addEdge("Penha", "Vila Matilde", 1);

        grafo.addEdge("Penha", "Carrão", 1);
        grafo.addEdge("Carrão", "Penha", 1);

        grafo.addEdge("Carrão", "Tatuapé", 1);
        grafo.addEdge("Tatuapé", "Carrão", 1);

        grafo.addEdge("Tatuapé", "Belém", 1);
        grafo.addEdge("Belém", "Tatuapé", 1);

        grafo.addEdge("Belém", "Bresser-Mooca", 1);
        grafo.addEdge("Bresser-Mooca", "Belém", 1);

        grafo.addEdge("Bresser-Mooca", "Brás", 1);
        grafo.addEdge("Brás", "Bresser-Mooca", 1);

        grafo.addEdge("Brás", "Pedro II", 1);
        grafo.addEdge("Pedro II", "Brás", 1);

        grafo.addEdge("Pedro II", "Sé", 1);
        grafo.addEdge("Sé", "Pedro II", 1);

        grafo.addEdge("Anhangabaú", "Sé", 1);
        grafo.addEdge("Sé", "Anhangabaú", 1);

        grafo.addEdge("Republica", "Anhangabaú", 1);
        grafo.addEdge("Anhangabaú", "Republica", 1);

        grafo.addEdge("Santa Cecília", "Republica", 1);
        grafo.addEdge("Republica", "Santa Cecília", 1);

        grafo.addEdge("Marechal Deodoro", "Santa Cecília", 1);
        grafo.addEdge("Santa Cecília", "Marechal Deodoro", 1);

        grafo.addEdge("Palmeiras-Barra Funda", "Marechal Deodoro", 1);
        grafo.addEdge("Marechal Deodoro", "Palmeiras-Barra Funda", 1);

        // Linha 4 - Amarela
        grafo.addEdge("Vila Sônia", "São Paulo-Morumbi",1);
        grafo.addEdge("São Paulo-Morumbi", "Vila Sônia",1);

        grafo.addEdge("São Paulo-Morumbi", "Butantã",1);
        grafo.addEdge("Butantã", "São Paulo-Morumbi",1);

        grafo.addEdge("Butantã", "Pinheiros",1);
        grafo.addEdge("Pinheiros", "Butantã",1);

        grafo.addEdge("Pinheiros", "Faria Lima",1);
        grafo.addEdge("Faria Lima", "Pinheiros",1);

        grafo.addEdge("Faria Lima", "Fradique Coutinho",1);
        grafo.addEdge("Fradique Coutinho", "Faria Lima",1);

        grafo.addEdge("Fradique Coutinho", "Oscar Freire",1);
        grafo.addEdge("Oscar Freire", "Fradique Coutinho",1);

        grafo.addEdge("Oscar Freire", "Paulista",1);
        grafo.addEdge("Paulista", "Oscar Freire",1);

        grafo.addEdge("Paulista", "Higienópolis-Mackenzie",1);
        grafo.addEdge("Higienópolis-Mackenzie", "Paulista",1);

        grafo.addEdge("Higienópolis-Mackenzie", "República",1);
        grafo.addEdge("República", "Higienópolis-Mackenzie",1);

        grafo.addEdge("República", "Luz",1);
        grafo.addEdge("Luz", "República",1);

        // Linha 5 - Lilás
        grafo.addEdge("Capão Redondo", "Campo Limpo", 1);
        grafo.addEdge("Campo Limpo", "Capão Redondo", 1);

        grafo.addEdge("Campo Limpo", "Vila das Belezas", 1);
        grafo.addEdge("Vila das Belezas", "Campo Limpo", 1);

        grafo.addEdge("Vila das Belezas", "Giovanni Gronchi", 1);
        grafo.addEdge("Giovanni Gronchi", "Vila das Belezas", 1);

        grafo.addEdge("Giovanni Gronchi", "Santo Amaro", 1);
        grafo.addEdge("Santo Amaro", "Giovanni Gronchi", 1);

        grafo.addEdge("Santo Amaro", "Largo Treze", 1);
        grafo.addEdge("Largo Treze", "Santo Amaro", 1);

        grafo.addEdge("Largo Treze", "Adolfo Pinheiro", 1);
        grafo.addEdge("Adolfo Pinheiro", "Largo Treze", 1);

        grafo.addEdge("Adolfo Pinheiro", "Alto da Boa Vista", 1);
        grafo.addEdge("Alto da Boa Vista", "Adolfo Pinheiro", 1);

        grafo.addEdge("Alto da Boa Vista", "Borba Gato", 1);
        grafo.addEdge("Borba Gato", "Alto da Boa Vista", 1);

        grafo.addEdge("Borba Gato", "Brooklin", 1);
        grafo.addEdge("Brooklin", "Borba Gato", 1);

        grafo.addEdge("Brooklin", "Campo Belo", 1);
        grafo.addEdge("Campo Belo", "Brooklin", 1);

        grafo.addEdge("Campo Belo", "Eucaliptos", 1);
        grafo.addEdge("Eucaliptos", "Campo Belo", 1);

        grafo.addEdge("Eucaliptos", "Moema", 1);
        grafo.addEdge("Moema", "Eucaliptos", 1);

        grafo.addEdge("Moema", "AACD-Servidor", 1);
        grafo.addEdge("AACD-Servidor", "Moema", 1);

        grafo.addEdge("AACD-Servidor", "Hospital São Paulo", 1);
        grafo.addEdge("Hospital São Paulo", "AACD-Servidor", 1);

        grafo.addEdge("Hospital São Paulo", "Santa Cruz", 1);
        grafo.addEdge("Santa Cruz", "Hospital São Paulo", 1);

        grafo.addEdge("Santa Cruz", "Chácara Klabin", 1);
        grafo.addEdge("Chácara Klabin", "Santa Cruz", 1);

        //Linha 7 - Rubi

        grafo.addEdge("Luz", "Palmeiras-Barra Funda",1);
        grafo.addEdge("Palmeiras-Barra Funda", "Luz",1);

        grafo.addEdge("Palmeiras-Barra Funda", "Água Branca",1);
        grafo.addEdge("Água Branca", "Palmeiras-Barra Funda",1);

        grafo.addEdge("Água Branca", "Lapa",1);
        grafo.addEdge("Lapa", "Água Branca",1);

        grafo.addEdge("Lapa", "Piqueri",1);
        grafo.addEdge("Piqueri", "Lapa",1);

        grafo.addEdge("Piqueri", "Pirituba",1);
        grafo.addEdge("Pirituba", "Piqueri",1);

        grafo.addEdge("Pirituba", "Vila Clarice",1);
        grafo.addEdge("Vila Clarice", "Pirituba",1);

        grafo.addEdge("Vila Clarice", "Jaraguá",1);
        grafo.addEdge("Jaraguá", "Vila Clarice",1);

        grafo.addEdge("Jaraguá", "Perus",1);
        grafo.addEdge("Perus", "Jaraguá",1);

        grafo.addEdge("Perus", "Caieiras",1);
        grafo.addEdge("Caieiras", "Perus",1);

        grafo.addEdge("Caieiras", "Franco da Rocha",1);
        grafo.addEdge("Franco da Rocha", "Caieiras",1);

        grafo.addEdge("Franco da Rocha", "Baltazar Fidélis",1);
        grafo.addEdge("Baltazar Fidélis", "Franco da Rocha",1);

        grafo.addEdge("Baltazar Fidélis", "Francisco Morato",1);
        grafo.addEdge("Francisco Morato", "Baltazar Fidélis",1);

        grafo.addEdge("Francisco Morato", "Botujuru",1);
        grafo.addEdge("Botujuru", "Francisco Morato",1);

        grafo.addEdge("Botujuru", "Campo Limpo Paulista",1);
        grafo.addEdge("Campo Limpo Paulista", "Botujuru",1);

        grafo.addEdge("Campo Limpo Paulista", "Várzea Paulista",1);
        grafo.addEdge("Várzea Paulista", "Campo Limpo Paulista",1);

        grafo.addEdge("Várzea Paulista", "Jundiaí",1);
        grafo.addEdge("Jundiaí", "Várzea Paulista",1);

        grafo.addEdge("Júlio Prestes", "Palmeiras-Barra Funda", 1);
        grafo.addEdge("Palmeiras-Barra Funda", "Júlio Prestes", 1);
        grafo.addEdge("Palmeiras-Barra Funda", "Lapa", 1);
        grafo.addEdge("Lapa", "Palmeiras-Barra Funda", 1);
        grafo.addEdge("Lapa", "Domingos de Moraes", 1);
        grafo.addEdge("Domingos de Moraes", "Lapa", 1);
        grafo.addEdge("Domingos de Moraes", "Imperatriz Leopoldina", 1);
        grafo.addEdge("Imperatriz Leopoldina", "Domingos de Moraes", 1);
        grafo.addEdge("Imperatriz Leopoldina", "Presidente Altino", 1);
        grafo.addEdge("Presidente Altino", "Imperatriz Leopoldina", 1);
        grafo.addEdge("Presidente Altino", "Osasco", 1);
        grafo.addEdge("Osasco", "Presidente Altino", 1);
        grafo.addEdge("Osasco", "Comandante Sampaio", 1);
        grafo.addEdge("Comandante Sampaio", "Osasco", 1);
        grafo.addEdge("Comandante Sampaio", "Quitaúna", 1);
        grafo.addEdge("Quitaúna", "Comandante Sampaio", 1);
        grafo.addEdge("Quitaúna", "General Miguel Costa", 1);
        grafo.addEdge("General Miguel Costa", "Quitaúna", 1);
        grafo.addEdge("General Miguel Costa", "Carapicuíba", 1);
        grafo.addEdge("Carapicuíba", "General Miguel Costa", 1);
        grafo.addEdge("Carapicuíba", "Santa Terezinha", 1);
        grafo.addEdge("Santa Terezinha", "Carapicuíba", 1);
        grafo.addEdge("Santa Terezinha", "Antonio João", 1);
        grafo.addEdge("Antonio João", "Santa Terezinha", 1);
        grafo.addEdge("Antonio João", "Barueri", 1);
        grafo.addEdge("Barueri", "Antonio João", 1);
        grafo.addEdge("Barueri", "Jardim Belval", 1);
        grafo.addEdge("Jardim Belval", "Barueri", 1);
        grafo.addEdge("Jardim Belval", "Jardim Silveira", 1);
        grafo.addEdge("Jardim Silveira", "Jardim Belval", 1);
        grafo.addEdge("Jardim Silveira", "Jandira", 1);
        grafo.addEdge("Jandira", "Jardim Silveira", 1);
        grafo.addEdge("Jandira", "Sagrado Coração", 1);
        grafo.addEdge("Sagrado Coração", "Jandira", 1);
        grafo.addEdge("Sagrado Coração", "Engenheiro Cardoso", 1);
        grafo.addEdge("Engenheiro Cardoso", "Sagrado Coração", 1);
        grafo.addEdge("Engenheiro Cardoso", "Itapevi", 1);
        grafo.addEdge("Itapevi", "Engenheiro Cardoso", 1);
        grafo.addEdge("Itapevi", "Amador Bueno", 1);
        grafo.addEdge("Amador Bueno", "Itapevi", 1);


        //Linha 9 - Esmeralda

        grafo.addEdge("Osasco", "Presidente Altino",1);
        grafo.addEdge("Presidente Altino", "Osasco",1);

        grafo.addEdge("Presidente Altino", "Ceasa",1);
        grafo.addEdge("Ceasa", "Presidente Altino",1);

        grafo.addEdge("Ceasa", "Villa Lobos-Jaguaré",1);
        grafo.addEdge("Villa Lobos-Jaguaré", "Ceasa",1);

        grafo.addEdge("Villa Lobos-Jaguaré", "Cidade Universitária",1);
        grafo.addEdge("Cidade Universitária", "Villa Lobos-Jaguaré",1);

        grafo.addEdge("Cidade Universitária", "Pinheiros",1);
        grafo.addEdge("Pinheiros", "Cidade Universitária",1);

        grafo.addEdge("Pinheiros", "Hebraica-Rebouças",1);
        grafo.addEdge("Hebraica-Rebouças", "Pinheiros",1);

        grafo.addEdge("Hebraica-Rebouças", "Cidade Jardim",1);
        grafo.addEdge("Cidade Jardim", "Hebraica-Rebouças",1);

        grafo.addEdge("Cidade Jardim", "Vila Olímpia",1);
        grafo.addEdge("Vila Olímpia", "Cidade Jardim",1);

        grafo.addEdge("Vila Olímpia", "Berrini",1);
        grafo.addEdge("Berrini", "Vila Olímpia",1);

        grafo.addEdge("Berrini", "Morumbi",1);
        grafo.addEdge("Morumbi", "Berrini",1);

        grafo.addEdge("Morumbi", "Granja Julieta",1);
        grafo.addEdge("Granja Julieta", "Morumbi",1);

        grafo.addEdge("Granja Julieta", "Santo Amaro",1);
        grafo.addEdge("Santo Amaro", "Granja Julieta",1);

        grafo.addEdge("Santo Amaro", "Socorro",1);
        grafo.addEdge("Socorro", "Santo Amaro",1);

        grafo.addEdge("Socorro", "Jurubatuba",1);
        grafo.addEdge("Jurubatuba", "Socorro",1);

        grafo.addEdge("Jurubatuba", "Autódromo",1);
        grafo.addEdge("Autódromo", "Jurubatuba",1);

        grafo.addEdge("Autódromo", "Primavera-Interlagos",1);
        grafo.addEdge("Primavera-Interlagos", "Autódromo",1);

        grafo.addEdge("Primavera-Interlagos", "Grajaú",1);
        grafo.addEdge("Grajaú", "Primavera-Interlagos",1);

        grafo.addEdge("Grajaú", "Bruno Covas/Mendes-Vila Natal",1);
        grafo.addEdge("Bruno Covas/Mendes-Vila Natal", "Grajaú",1);

        grafo.addEdge("Bruno Covas/Mendes-Vila Natal", "Varginha",1);
        grafo.addEdge("Varginha", "Bruno Covas/Mendes-Vila Natal",1);

        //Linha 10 - Turquesa

        grafo.addEdge("Juventus-Mooca", "Ipiranga",1);
        grafo.addEdge("Ipiranga", "Juventus-Mooca",1);

        grafo.addEdge("Ipiranga", "Tamanduateí",1);
        grafo.addEdge("Tamanduateí", "Ipiranga",1);

        grafo.addEdge("Tamanduateí", "São Caetano do Sul-Prefeito Walter Braido",1);
        grafo.addEdge("São Caetano do Sul-Prefeito Walter Braido", "Tamanduateí",1);

        grafo.addEdge("São Caetano do Sul-Prefeito Walter Braido", "Utinga",1);
        grafo.addEdge("Utinga", "São Caetano do Sul-Prefeito Walter Braido",1);

        grafo.addEdge("Utinga", "Prefeito Saladino",1);
        grafo.addEdge("Prefeito Saladino", "Utinga",1);

        grafo.addEdge("Prefeito Saladino", "Prefeito Celso Daniel-Santo André",1);
        grafo.addEdge("Prefeito Celso Daniel-Santo André", "Prefeito Saladino",1);

        grafo.addEdge("Prefeito Celso Daniel-Santo André", "Capuava",1);
        grafo.addEdge("Capuava", "Prefeito Celso Daniel-Santo André",1);

        grafo.addEdge("Capuava", "Mauá",1);
        grafo.addEdge("Mauá", "Capuava",1);

        grafo.addEdge("Mauá", "Guapituba",1);
        grafo.addEdge("Guapituba", "Mauá",1);

        grafo.addEdge("Guapituba", "Ribeirão Pires-Antônio Bespalec",1);
        grafo.addEdge("Ribeirão Pires-Antônio Bespalec", "Guapituba",1);

        grafo.addEdge("Ribeirão Pires-Antônio Bespalec", "Rio Grande da Serra",1);
        grafo.addEdge("Rio Grande da Serra", "Ribeirão Pires-Antônio Bespalec",1);

        // Linha 11 - Coral

        grafo.addEdge("Luz", "Brás",1);
        grafo.addEdge("Brás", "Luz",1);

        grafo.addEdge("Brás", "Tatuapé",1);
        grafo.addEdge("Tatuapé", "Brás",1);

        grafo.addEdge("Tatuapé", "Corinthians-Itaquera",1);
        grafo.addEdge("Corinthians-Itaquera", "Tatuapé",1);

        grafo.addEdge("Corinthians-Itaquera", "Dom Bosco",1);
        grafo.addEdge("Dom Bosco", "Corinthians-Itaquera",1);

        grafo.addEdge("Dom Bosco", "José Bonifácio",1);
        grafo.addEdge("José Bonifácio", "Dom Bosco",1);

        grafo.addEdge("José Bonifácio", "Guaianases",1);
        grafo.addEdge("Guaianases", "José Bonifácio",1);

        grafo.addEdge("Guaianases", "Antônio Gianetti Neto",1);
        grafo.addEdge("Antônio Gianetti Neto", "Guaianases",1);

        grafo.addEdge("Antônio Gianetti Neto", "Ferraz de Vasconcelos",1);
        grafo.addEdge("Ferraz de Vasconcelos", "Antônio Gianetti Neto",1);

        grafo.addEdge("Ferraz de Vasconcelos", "Poá",1);
        grafo.addEdge("Poá", "Ferraz de Vasconcelos",1);

        grafo.addEdge("Poá", "Calmon Viana",1);
        grafo.addEdge("Calmon Viana", "Poá",1);

        grafo.addEdge("Calmon Viana", "Suzano",1);
        grafo.addEdge("Suzano", "Calmon Viana",1);

        grafo.addEdge("Suzano", "Jundiapeba",1);
        grafo.addEdge("Jundiapeba", "Suzano",1);

        grafo.addEdge("Jundiapeba", "Braz Cubas",1);
        grafo.addEdge("Braz Cubas", "Jundiapeba",1);

        grafo.addEdge("Braz Cubas", "Mogi das Cruzes",1);
        grafo.addEdge("Mogi das Cruzes", "Braz Cubas",1);

        grafo.addEdge("Mogi das Cruzes", "Estudantes",1);
        grafo.addEdge("Estudantes", "Mogi das Cruzes",1);

        //Linha 12 - Safira

        grafo.addEdge("Brás", "Tatuapé",1);
        grafo.addEdge("Tatuapé", "Brás",1);

        grafo.addEdge("Tatuapé", "Engenheiro Goulart",1);
        grafo.addEdge("Engenheiro Goulart", "Tatuapé",1);

        grafo.addEdge("Engenheiro Goulart", "USP Leste",1);
        grafo.addEdge("USP Leste", "Engenheiro Goulart",1);

        grafo.addEdge("USP Leste", "Comendador Ermelino",1);
        grafo.addEdge("Comendador Ermelino", "USP Leste",1);

        grafo.addEdge("Comendador Ermelino", "São Miguel Paulista",1);
        grafo.addEdge("São Miguel Paulista", "Comendador Ermelino",1);

        grafo.addEdge("São Miguel Paulista", "Jardim Helena-Vila Mara",1);
        grafo.addEdge("Jardim Helena-Vila Mara", "São Miguel Paulista",1);

        grafo.addEdge("Jardim Helena-Vila Mara", "Itaim Paulista",1);
        grafo.addEdge("Itaim Paulista", "Jardim Helena-Vila Mara",1);

        grafo.addEdge("Itaim Paulista", "Jardim Romano",1);
        grafo.addEdge("Jardim Romano", "Itaim Paulista",1);

        grafo.addEdge("Jardim Romano", "Engenheiro Manoel Feio",1);
        grafo.addEdge("Engenheiro Manoel Feio", "Jardim Romano",1);

        grafo.addEdge("Engenheiro Manoel Feio", "Itaquaquecetuba",1);
        grafo.addEdge("Itaquaquecetuba", "Engenheiro Manoel Feio",1);

        grafo.addEdge("Itaquaquecetuba", "Aracaré",1);
        grafo.addEdge("Aracaré", "Itaquaquecetuba",1);

        grafo.addEdge("Aracaré", "Calmon Viana",1);
        grafo.addEdge("Calmon Viana", "Aracaré",1);

        //Linha 13 - Jade

        grafo.addEdge("Engenheiro Goulart", "Guarulhos-Cecap",1);
        grafo.addEdge("Guarulhos-Cecap", "Engenheiro Goulart",1);

        grafo.addEdge("Guarulhos–Cecap", "Aeroporto–Guarulhos",1);
        grafo.addEdge("Aeroporto–Guarulhos", "Guarulhos–Cecap",1);

        //Linha 15 - Prata

        grafo.addEdge("Ipiranga", "Vila Prudente",1);
        grafo.addEdge("Vila Prudente", "Ipiranga",1);

        grafo.addEdge("Vila Prudente", "Oratório",1);
        grafo.addEdge("Oratório", "Vila Prudente",1);

        grafo.addEdge("Oratório", "São Lucas",1);
        grafo.addEdge("São Lucas", "Oratório",1);

        grafo.addEdge("São Lucas", "Camilo Haddad",1);
        grafo.addEdge("Camilo Haddad", "São Lucas",1);

        grafo.addEdge("Camilo Haddad", "Vila Tolstói",1);
        grafo.addEdge("Vila Tolstói", "Camilo Haddad",1);

        grafo.addEdge("Vila Tolstói", "Vila União",1);
        grafo.addEdge("Vila União", "Vila Tolstói",1);

        grafo.addEdge("Vila União", "Jardim Planalto",1);
        grafo.addEdge("Jardim Planalto", "Vila União",1);

        grafo.addEdge("Jardim Planalto", "Sapopemba",1);
        grafo.addEdge("Sapopemba", "Jardim Planalto",1);

        grafo.addEdge("Sapopemba", "Fazenda da Juta",1);
        grafo.addEdge("Fazenda da Juta", "Sapopemba",1);

        grafo.addEdge("Fazenda da Juta", "São Mateus",1);
        grafo.addEdge("São Mateus", "Fazenda da Juta",1);

        grafo.addEdge("São Mateus", "Jardim Colonial",1);
        grafo.addEdge("Jardim Colonial", "São Mateus",1);

        grafo.addEdge("Jardim Colonial-IGT", "Boa Esperança-BEP",1);
        grafo.addEdge("Boa Esperança-BEP", "Jardim Colonial-IGT",1);

        grafo.addEdge("Boa Esperança-BEP", "Jacu-Pêssego-JPS",1);
        grafo.addEdge("Jacu-Pêssego-JPS", "Boa Esperança-BEP",1);

        grafo.addEdge("Jacu-Pêssego-JPS", "Jardim Marilu",1);
        grafo.addEdge("Jardim Marilu", "Jacu-Pêssego-JPS",1);

        grafo.addEdge("Jardim Marilu", "Jardim Pedra Branca",1);
        grafo.addEdge("Jardim Pedra Branca", "Jardim Marilu",1);

        grafo.addEdge("Jardim Pedra Branca", "Cidade Tiradentes",1);
        grafo.addEdge("Cidade Tiradentes", "Jardim Pedra Branca",1);

        grafo.addEdge("Cidade Tiradentes", "Hospital Cidade Tiradentes",1);
        grafo.addEdge("Hospital Cidade Tiradentes", "Cidade Tiradentes",1);


        // Encontrar o caminho mais curto
        List<String> caminhoMaisCurto = grafo.caminhoMaisCurto(origem, destino);

        // Exibir o caminho
        if (caminhoMaisCurto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o caminho entre as estações.");
        } else {
            JOptionPane.showMessageDialog(null, "Caminho mais curto: " + caminhoMaisCurto);
        }
    }
    public static void consultarCaminhoConsole(Scanner scanner) {
        System.out.print("Digite a estação de origem: ");
        String origem = scanner.nextLine();

        System.out.print("Digite a estação de destino: ");
        String destino = scanner.nextLine();

        Grafo grafo = new Grafo();
        // Linha 1 - Azul
        grafo.addEdge("Jabaquara", "Conceição",1);
        grafo.addEdge("Conceição", "Jabaquara",1);

        grafo.addEdge("Conceição", "São Judas",1);
        grafo.addEdge("São Judas", "Conceição",1);

        grafo.addEdge("São Judas", "Saúde",1);
        grafo.addEdge("Saúde", "São Judas",1);

        grafo.addEdge("Saúde", "Praça da Árvore",1);
        grafo.addEdge("Praça da Árvore", "Saúde",1);

        grafo.addEdge("Praça da Árvore", "Santa Cruz",1);
        grafo.addEdge("Santa Cruz", "Praça da Árvore",1);

        grafo.addEdge("Santa Cruz", "Vila Mariana",1);
        grafo.addEdge("Vila Mariana", "Santa Cruz",1);

        grafo.addEdge("Vila Mariana", "Ana Rosa",1);
        grafo.addEdge("Ana Rosa", "Vila Mariana",1);

        grafo.addEdge("Ana Rosa", "Paraíso",1);
        grafo.addEdge("Paraíso", "Ana Rosa",1);

        grafo.addEdge("Paraíso", "Vergueiro",1);
        grafo.addEdge("Vergueiro", "Paraíso",1);

        grafo.addEdge("Vergueiro", "São Joaquim",1);
        grafo.addEdge("São Joaquim", "Vergueiro",1);

        grafo.addEdge("São Joaquim", "Liberdade",1);
        grafo.addEdge("Liberdade", "São Joaquim",1);

        grafo.addEdge("Liberdade", "Sé",1);
        grafo.addEdge("Sé", "Liberdade",1);

        grafo.addEdge("Sé", "São Bento",1);
        grafo.addEdge("São Bento", "Sé",1);

        grafo.addEdge("São Bento", "Luz",1);
        grafo.addEdge("Luz", "São Bento",1);

        grafo.addEdge("Luz", "Tiradentes",1);
        grafo.addEdge("Tiradentes", "Luz",1);

        grafo.addEdge("Tiradentes", "Armênia",1);
        grafo.addEdge("Armênia", "Tiradentes",1);

        grafo.addEdge("Armênia", "Portuguesa-Tietê",1);
        grafo.addEdge("Portuguesa-Tietê", "Armênia",1);

        grafo.addEdge("Portuguesa-Tietê", "Carandiru",1);
        grafo.addEdge("Carandiru", "Portuguesa-Tietê",1);

        grafo.addEdge("Carandiru", "Santana",1);
        grafo.addEdge("Santana", "Carandiru",1);

        grafo.addEdge("Santana", "Jardim São Paulo-Ayrton Senna",1);
        grafo.addEdge("Jardim São Paulo-Ayrton Senna", "Santana",1);

        grafo.addEdge("Jardim São Paulo-Ayrton Senna", "Parada Inglesa",1);
        grafo.addEdge("Parada Inglesa", "Jardim São Paulo-Ayrton Senna",1);

        grafo.addEdge("Parada Inglesa", "Tucuruvi",1);
        grafo.addEdge("Tucuruvi", "Parada Inglesa",1);

        // Linha 2 - Verde
        grafo.addEdge("Vila Prudente", "Tamanduateí", 1);
        grafo.addEdge("Tamanduateí", "Vila Prudente", 1);

        grafo.addEdge("Tamanduateí", "Sacomã", 1);
        grafo.addEdge("Sacomã", "Tamanduateí", 1);

        grafo.addEdge("Sacomã", "Alto do Ipiranga", 1);
        grafo.addEdge("Alto do Ipiranga", "Sacomã", 1);

        grafo.addEdge("Alto do Ipiranga", "Santos-Imigrantes", 1);
        grafo.addEdge("Santos-Imigrantes", "Alto do Ipiranga", 1);

        grafo.addEdge("Santos-Imigrantes", "Chácara Klabin", 1);
        grafo.addEdge("Chácara Klabin", "Santos-Imigrantes", 1);

        grafo.addEdge("Chácara Klabin", "Ana Rosa", 1); // baldeação com Linha Azul
        grafo.addEdge("Ana Rosa", "Chácara Klabin", 1);

        grafo.addEdge("Ana Rosa", "Paraíso", 1); // conexão direta com a Linha Azul
        grafo.addEdge("Paraíso", "Ana Rosa", 1);

        grafo.addEdge("Paraíso", "Brigadeiro", 1);
        grafo.addEdge("Brigadeiro", "Paraíso", 1);

        grafo.addEdge("Brigadeiro", "Trianon-Masp", 1);
        grafo.addEdge("Trianon-Masp", "Brigadeiro", 1);

        grafo.addEdge("Trianon-Masp", "Consolação", 1);
        grafo.addEdge("Consolação", "Trianon-Masp", 1);

        grafo.addEdge("Consolação", "Clínicas", 1);
        grafo.addEdge("Clínicas", "Consolação", 1);

        grafo.addEdge("Clínicas", "Santuário Nossa Senhora de Fátima - Sumaré", 1);
        grafo.addEdge("Santuário Nossa Senhora de Fátima - Sumaré", "Clínicas", 1);

        grafo.addEdge("Santuário Nossa Senhora de Fátima - Sumaré", "Vila Madalena", 1);
        grafo.addEdge("Vila Madalena", "Santuário Nossa Senhora de Fátima - Sumaré", 1);

        // Linha 3 - Vermelha

        grafo.addEdge("Corinthians-Itaquera", "Artur Alvim", 1);
        grafo.addEdge("Artur Alvim", "Corinthians-Itaquera", 1);

        grafo.addEdge("Artur Alvim", "Patriarca", 1);
        grafo.addEdge("Patriarca", "Artur Alvim", 1);

        grafo.addEdge("Patriarca", "Guilhermina-Esperança", 1);
        grafo.addEdge("Guilhermina-Esperança", "Patriarca", 1);

        grafo.addEdge("Guilhermina-Esperança", "Vila Matilde", 1);
        grafo.addEdge("Vila Matilde", "Guilhermina-Esperança", 1);

        grafo.addEdge("Vila Matilde", "Penha", 1);
        grafo.addEdge("Penha", "Vila Matilde", 1);

        grafo.addEdge("Penha", "Carrão", 1);
        grafo.addEdge("Carrão", "Penha", 1);

        grafo.addEdge("Carrão", "Tatuapé", 1);
        grafo.addEdge("Tatuapé", "Carrão", 1);

        grafo.addEdge("Tatuapé", "Belém", 1);
        grafo.addEdge("Belém", "Tatuapé", 1);

        grafo.addEdge("Belém", "Bresser-Mooca", 1);
        grafo.addEdge("Bresser-Mooca", "Belém", 1);

        grafo.addEdge("Bresser-Mooca", "Brás", 1);
        grafo.addEdge("Brás", "Bresser-Mooca", 1);

        grafo.addEdge("Brás", "Pedro II", 1);
        grafo.addEdge("Pedro II", "Brás", 1);

        grafo.addEdge("Pedro II", "Sé", 1);
        grafo.addEdge("Sé", "Pedro II", 1);

        grafo.addEdge("Anhangabaú", "Sé", 1);
        grafo.addEdge("Sé", "Anhangabaú", 1);

        grafo.addEdge("Republica", "Anhangabaú", 1);
        grafo.addEdge("Anhangabaú", "Republica", 1);

        grafo.addEdge("Santa Cecília", "Republica", 1);
        grafo.addEdge("Republica", "Santa Cecília", 1);

        grafo.addEdge("Marechal Deodoro", "Santa Cecília", 1);
        grafo.addEdge("Santa Cecília", "Marechal Deodoro", 1);

        grafo.addEdge("Palmeiras-Barra Funda", "Marechal Deodoro", 1);
        grafo.addEdge("Marechal Deodoro", "Palmeiras-Barra Funda", 1);

        // Linha 4 - Amarela
        grafo.addEdge("Vila Sônia", "São Paulo-Morumbi",1);
        grafo.addEdge("São Paulo-Morumbi", "Vila Sônia",1);

        grafo.addEdge("São Paulo-Morumbi", "Butantã",1);
        grafo.addEdge("Butantã", "São Paulo-Morumbi",1);

        grafo.addEdge("Butantã", "Pinheiros",1);
        grafo.addEdge("Pinheiros", "Butantã",1);

        grafo.addEdge("Pinheiros", "Faria Lima",1);
        grafo.addEdge("Faria Lima", "Pinheiros",1);

        grafo.addEdge("Faria Lima", "Fradique Coutinho",1);
        grafo.addEdge("Fradique Coutinho", "Faria Lima",1);

        grafo.addEdge("Fradique Coutinho", "Oscar Freire",1);
        grafo.addEdge("Oscar Freire", "Fradique Coutinho",1);

        grafo.addEdge("Oscar Freire", "Paulista",1);
        grafo.addEdge("Paulista", "Oscar Freire",1);

        grafo.addEdge("Paulista", "Higienópolis-Mackenzie",1);
        grafo.addEdge("Higienópolis-Mackenzie", "Paulista",1);

        grafo.addEdge("Higienópolis-Mackenzie", "República",1);
        grafo.addEdge("República", "Higienópolis-Mackenzie",1);

        grafo.addEdge("República", "Luz",1);
        grafo.addEdge("Luz", "República",1);


        // Linha 5 - Lilás
        grafo.addEdge("Capão Redondo", "Campo Limpo", 1);
        grafo.addEdge("Campo Limpo", "Capão Redondo", 1);

        grafo.addEdge("Campo Limpo", "Vila das Belezas", 1);
        grafo.addEdge("Vila das Belezas", "Campo Limpo", 1);

        grafo.addEdge("Vila das Belezas", "Giovanni Gronchi", 1);
        grafo.addEdge("Giovanni Gronchi", "Vila das Belezas", 1);

        grafo.addEdge("Giovanni Gronchi", "Santo Amaro", 1);
        grafo.addEdge("Santo Amaro", "Giovanni Gronchi", 1);

        grafo.addEdge("Santo Amaro", "Largo Treze", 1);
        grafo.addEdge("Largo Treze", "Santo Amaro", 1);

        grafo.addEdge("Largo Treze", "Adolfo Pinheiro", 1);
        grafo.addEdge("Adolfo Pinheiro", "Largo Treze", 1);

        grafo.addEdge("Adolfo Pinheiro", "Alto da Boa Vista", 1);
        grafo.addEdge("Alto da Boa Vista", "Adolfo Pinheiro", 1);

        grafo.addEdge("Alto da Boa Vista", "Borba Gato", 1);
        grafo.addEdge("Borba Gato", "Alto da Boa Vista", 1);

        grafo.addEdge("Borba Gato", "Brooklin", 1);
        grafo.addEdge("Brooklin", "Borba Gato", 1);

        grafo.addEdge("Brooklin", "Campo Belo", 1);
        grafo.addEdge("Campo Belo", "Brooklin", 1);

        grafo.addEdge("Campo Belo", "Eucaliptos", 1);
        grafo.addEdge("Eucaliptos", "Campo Belo", 1);

        grafo.addEdge("Eucaliptos", "Moema", 1);
        grafo.addEdge("Moema", "Eucaliptos", 1);

        grafo.addEdge("Moema", "AACD-Servidor", 1);
        grafo.addEdge("AACD-Servidor", "Moema", 1);

        grafo.addEdge("AACD-Servidor", "Hospital São Paulo", 1);
        grafo.addEdge("Hospital São Paulo", "AACD-Servidor", 1);

        grafo.addEdge("Hospital São Paulo", "Santa Cruz", 1);
        grafo.addEdge("Santa Cruz", "Hospital São Paulo", 1);

        grafo.addEdge("Santa Cruz", "Chácara Klabin", 1);
        grafo.addEdge("Chácara Klabin", "Santa Cruz", 1);

        //Linha 7 - Rubi

        grafo.addEdge("Luz", "Palmeiras-Barra Funda",1);
        grafo.addEdge("Palmeiras-Barra Funda", "Luz",1);

        grafo.addEdge("Palmeiras-Barra Funda", "Água Branca",1);
        grafo.addEdge("Água Branca", "Palmeiras-Barra Funda",1);

        grafo.addEdge("Água Branca", "Lapa",1);
        grafo.addEdge("Lapa", "Água Branca",1);

        grafo.addEdge("Lapa", "Piqueri",1);
        grafo.addEdge("Piqueri", "Lapa",1);

        grafo.addEdge("Piqueri", "Pirituba",1);
        grafo.addEdge("Pirituba", "Piqueri",1);

        grafo.addEdge("Pirituba", "Vila Clarice",1);
        grafo.addEdge("Vila Clarice", "Pirituba",1);

        grafo.addEdge("Vila Clarice", "Jaraguá",1);
        grafo.addEdge("Jaraguá", "Vila Clarice",1);

        grafo.addEdge("Jaraguá", "Perus",1);
        grafo.addEdge("Perus", "Jaraguá",1);

        grafo.addEdge("Perus", "Caieiras",1);
        grafo.addEdge("Caieiras", "Perus",1);

        grafo.addEdge("Caieiras", "Franco da Rocha",1);
        grafo.addEdge("Franco da Rocha", "Caieiras",1);

        grafo.addEdge("Franco da Rocha", "Baltazar Fidélis",1);
        grafo.addEdge("Baltazar Fidélis", "Franco da Rocha",1);

        grafo.addEdge("Baltazar Fidélis", "Francisco Morato",1);
        grafo.addEdge("Francisco Morato", "Baltazar Fidélis",1);

        grafo.addEdge("Francisco Morato", "Botujuru",1);
        grafo.addEdge("Botujuru", "Francisco Morato",1);

        grafo.addEdge("Botujuru", "Campo Limpo Paulista",1);
        grafo.addEdge("Campo Limpo Paulista", "Botujuru",1);

        grafo.addEdge("Campo Limpo Paulista", "Várzea Paulista",1);
        grafo.addEdge("Várzea Paulista", "Campo Limpo Paulista",1);

        grafo.addEdge("Várzea Paulista", "Jundiaí",1);
        grafo.addEdge("Jundiaí", "Várzea Paulista",1);

        grafo.addEdge("Júlio Prestes", "Palmeiras-Barra Funda", 1);
        grafo.addEdge("Palmeiras-Barra Funda", "Júlio Prestes", 1);
        grafo.addEdge("Palmeiras-Barra Funda", "Lapa", 1);
        grafo.addEdge("Lapa", "Palmeiras-Barra Funda", 1);
        grafo.addEdge("Lapa", "Domingos de Moraes", 1);
        grafo.addEdge("Domingos de Moraes", "Lapa", 1);
        grafo.addEdge("Domingos de Moraes", "Imperatriz Leopoldina", 1);
        grafo.addEdge("Imperatriz Leopoldina", "Domingos de Moraes", 1);
        grafo.addEdge("Imperatriz Leopoldina", "Presidente Altino", 1);
        grafo.addEdge("Presidente Altino", "Imperatriz Leopoldina", 1);
        grafo.addEdge("Presidente Altino", "Osasco", 1);
        grafo.addEdge("Osasco", "Presidente Altino", 1);
        grafo.addEdge("Osasco", "Comandante Sampaio", 1);
        grafo.addEdge("Comandante Sampaio", "Osasco", 1);
        grafo.addEdge("Comandante Sampaio", "Quitaúna", 1);
        grafo.addEdge("Quitaúna", "Comandante Sampaio", 1);
        grafo.addEdge("Quitaúna", "General Miguel Costa", 1);
        grafo.addEdge("General Miguel Costa", "Quitaúna", 1);
        grafo.addEdge("General Miguel Costa", "Carapicuíba", 1);
        grafo.addEdge("Carapicuíba", "General Miguel Costa", 1);
        grafo.addEdge("Carapicuíba", "Santa Terezinha", 1);
        grafo.addEdge("Santa Terezinha", "Carapicuíba", 1);
        grafo.addEdge("Santa Terezinha", "Antonio João", 1);
        grafo.addEdge("Antonio João", "Santa Terezinha", 1);
        grafo.addEdge("Antonio João", "Barueri", 1);
        grafo.addEdge("Barueri", "Antonio João", 1);
        grafo.addEdge("Barueri", "Jardim Belval", 1);
        grafo.addEdge("Jardim Belval", "Barueri", 1);
        grafo.addEdge("Jardim Belval", "Jardim Silveira", 1);
        grafo.addEdge("Jardim Silveira", "Jardim Belval", 1);
        grafo.addEdge("Jardim Silveira", "Jandira", 1);
        grafo.addEdge("Jandira", "Jardim Silveira", 1);
        grafo.addEdge("Jandira", "Sagrado Coração", 1);
        grafo.addEdge("Sagrado Coração", "Jandira", 1);
        grafo.addEdge("Sagrado Coração", "Engenheiro Cardoso", 1);
        grafo.addEdge("Engenheiro Cardoso", "Sagrado Coração", 1);
        grafo.addEdge("Engenheiro Cardoso", "Itapevi", 1);
        grafo.addEdge("Itapevi", "Engenheiro Cardoso", 1);
        grafo.addEdge("Itapevi", "Amador Bueno", 1);
        grafo.addEdge("Amador Bueno", "Itapevi", 1);

        //Linha 9 - Esmeralda

        grafo.addEdge("Osasco", "Presidente Altino",1);
        grafo.addEdge("Presidente Altino", "Osasco",1);

        grafo.addEdge("Presidente Altino", "Ceasa",1);
        grafo.addEdge("Ceasa", "Presidente Altino",1);

        grafo.addEdge("Ceasa", "Villa Lobos-Jaguaré",1);
        grafo.addEdge("Villa Lobos-Jaguaré", "Ceasa",1);

        grafo.addEdge("Villa Lobos-Jaguaré", "Cidade Universitária",1);
        grafo.addEdge("Cidade Universitária", "Villa Lobos-Jaguaré",1);

        grafo.addEdge("Cidade Universitária", "Pinheiros",1);
        grafo.addEdge("Pinheiros", "Cidade Universitária",1);

        grafo.addEdge("Pinheiros", "Hebraica-Rebouças",1);
        grafo.addEdge("Hebraica-Rebouças", "Pinheiros",1);

        grafo.addEdge("Hebraica-Rebouças", "Cidade Jardim",1);
        grafo.addEdge("Cidade Jardim", "Hebraica-Rebouças",1);

        grafo.addEdge("Cidade Jardim", "Vila Olímpia",1);
        grafo.addEdge("Vila Olímpia", "Cidade Jardim",1);

        grafo.addEdge("Vila Olímpia", "Berrini",1);
        grafo.addEdge("Berrini", "Vila Olímpia",1);

        grafo.addEdge("Berrini", "Morumbi",1);
        grafo.addEdge("Morumbi", "Berrini",1);

        grafo.addEdge("Morumbi", "Granja Julieta",1);
        grafo.addEdge("Granja Julieta", "Morumbi",1);

        grafo.addEdge("Granja Julieta", "Santo Amaro",1);
        grafo.addEdge("Santo Amaro", "Granja Julieta",1);

        grafo.addEdge("Santo Amaro", "Socorro",1);
        grafo.addEdge("Socorro", "Santo Amaro",1);

        grafo.addEdge("Socorro", "Jurubatuba",1);
        grafo.addEdge("Jurubatuba", "Socorro",1);

        grafo.addEdge("Jurubatuba", "Autódromo",1);
        grafo.addEdge("Autódromo", "Jurubatuba",1);

        grafo.addEdge("Autódromo", "Primavera-Interlagos",1);
        grafo.addEdge("Primavera-Interlagos", "Autódromo",1);

        grafo.addEdge("Primavera-Interlagos", "Grajaú",1);
        grafo.addEdge("Grajaú", "Primavera-Interlagos",1);

        grafo.addEdge("Grajaú", "Bruno Covas/Mendes-Vila Natal",1);
        grafo.addEdge("Bruno Covas/Mendes-Vila Natal", "Grajaú",1);

        grafo.addEdge("Bruno Covas/Mendes-Vila Natal", "Varginha",1);
        grafo.addEdge("Varginha", "Bruno Covas/Mendes-Vila Natal",1);

        //Linha 10 - Turquesa

        grafo.addEdge("Juventus-Mooca", "Ipiranga",1);
        grafo.addEdge("Ipiranga", "Juventus-Mooca",1);

        grafo.addEdge("Ipiranga", "Tamanduateí",1);
        grafo.addEdge("Tamanduateí", "Ipiranga",1);

        grafo.addEdge("Tamanduateí", "São Caetano do Sul-Prefeito Walter Braido",1);
        grafo.addEdge("São Caetano do Sul-Prefeito Walter Braido", "Tamanduateí",1);

        grafo.addEdge("São Caetano do Sul-Prefeito Walter Braido", "Utinga",1);
        grafo.addEdge("Utinga", "São Caetano do Sul-Prefeito Walter Braido",1);

        grafo.addEdge("Utinga", "Prefeito Saladino",1);
        grafo.addEdge("Prefeito Saladino", "Utinga",1);

        grafo.addEdge("Prefeito Saladino", "Prefeito Celso Daniel-Santo André",1);
        grafo.addEdge("Prefeito Celso Daniel-Santo André", "Prefeito Saladino",1);

        grafo.addEdge("Prefeito Celso Daniel-Santo André", "Capuava",1);
        grafo.addEdge("Capuava", "Prefeito Celso Daniel-Santo André",1);

        grafo.addEdge("Capuava", "Mauá",1);
        grafo.addEdge("Mauá", "Capuava",1);

        grafo.addEdge("Mauá", "Guapituba",1);
        grafo.addEdge("Guapituba", "Mauá",1);

        grafo.addEdge("Guapituba", "Ribeirão Pires-Antônio Bespalec",1);
        grafo.addEdge("Ribeirão Pires-Antônio Bespalec", "Guapituba",1);

        grafo.addEdge("Ribeirão Pires-Antônio Bespalec", "Rio Grande da Serra",1);
        grafo.addEdge("Rio Grande da Serra", "Ribeirão Pires-Antônio Bespalec",1);

        // Linha 11 - Coral

        grafo.addEdge("Luz", "Brás",1);
        grafo.addEdge("Brás", "Luz",1);

        grafo.addEdge("Brás", "Tatuapé",1);
        grafo.addEdge("Tatuapé", "Brás",1);

        grafo.addEdge("Tatuapé", "Corinthians-Itaquera",1);
        grafo.addEdge("Corinthians-Itaquera", "Tatuapé",1);

        grafo.addEdge("Corinthians-Itaquera", "Dom Bosco",1);
        grafo.addEdge("Dom Bosco", "Corinthians-Itaquera",1);

        grafo.addEdge("Dom Bosco", "José Bonifácio",1);
        grafo.addEdge("José Bonifácio", "Dom Bosco",1);

        grafo.addEdge("José Bonifácio", "Guaianases",1);
        grafo.addEdge("Guaianases", "José Bonifácio",1);

        grafo.addEdge("Guaianases", "Antônio Gianetti Neto",1);
        grafo.addEdge("Antônio Gianetti Neto", "Guaianases",1);

        grafo.addEdge("Antônio Gianetti Neto", "Ferraz de Vasconcelos",1);
        grafo.addEdge("Ferraz de Vasconcelos", "Antônio Gianetti Neto",1);

        grafo.addEdge("Ferraz de Vasconcelos", "Poá",1);
        grafo.addEdge("Poá", "Ferraz de Vasconcelos",1);

        grafo.addEdge("Poá", "Calmon Viana",1);
        grafo.addEdge("Calmon Viana", "Poá",1);

        grafo.addEdge("Calmon Viana", "Suzano",1);
        grafo.addEdge("Suzano", "Calmon Viana",1);

        grafo.addEdge("Suzano", "Jundiapeba",1);
        grafo.addEdge("Jundiapeba", "Suzano",1);

        grafo.addEdge("Jundiapeba", "Braz Cubas",1);
        grafo.addEdge("Braz Cubas", "Jundiapeba",1);

        grafo.addEdge("Braz Cubas", "Mogi das Cruzes",1);
        grafo.addEdge("Mogi das Cruzes", "Braz Cubas",1);

        grafo.addEdge("Mogi das Cruzes", "Estudantes",1);
        grafo.addEdge("Estudantes", "Mogi das Cruzes",1);

        //Linha 12 - Safira

        grafo.addEdge("Brás", "Tatuapé",1);
        grafo.addEdge("Tatuapé", "Brás",1);

        grafo.addEdge("Tatuapé", "Engenheiro Goulart",1);
        grafo.addEdge("Engenheiro Goulart", "Tatuapé",1);

        grafo.addEdge("Engenheiro Goulart", "USP Leste",1);
        grafo.addEdge("USP Leste", "Engenheiro Goulart",1);

        grafo.addEdge("USP Leste", "Comendador Ermelino",1);
        grafo.addEdge("Comendador Ermelino", "USP Leste",1);

        grafo.addEdge("Comendador Ermelino", "São Miguel Paulista",1);
        grafo.addEdge("São Miguel Paulista", "Comendador Ermelino",1);

        grafo.addEdge("São Miguel Paulista", "Jardim Helena-Vila Mara",1);
        grafo.addEdge("Jardim Helena-Vila Mara", "São Miguel Paulista",1);

        grafo.addEdge("Jardim Helena-Vila Mara", "Itaim Paulista",1);
        grafo.addEdge("Itaim Paulista", "Jardim Helena-Vila Mara",1);

        grafo.addEdge("Itaim Paulista", "Jardim Romano",1);
        grafo.addEdge("Jardim Romano", "Itaim Paulista",1);

        grafo.addEdge("Jardim Romano", "Engenheiro Manoel Feio",1);
        grafo.addEdge("Engenheiro Manoel Feio", "Jardim Romano",1);

        grafo.addEdge("Engenheiro Manoel Feio", "Itaquaquecetuba",1);
        grafo.addEdge("Itaquaquecetuba", "Engenheiro Manoel Feio",1);

        grafo.addEdge("Itaquaquecetuba", "Aracaré",1);
        grafo.addEdge("Aracaré", "Itaquaquecetuba",1);

        //Linha 13 - Jade

        grafo.addEdge("Engenheiro Goulart", "Guarulhos-Cecap",1);
        grafo.addEdge("Guarulhos-Cecap", "Engenheiro Goulart",1);

        grafo.addEdge("Guarulhos–Cecap", "Aeroporto–Guarulhos",1);
        grafo.addEdge("Aeroporto–Guarulhos", "Guarulhos–Cecap",1);

        //Linha 15 - Prata

        grafo.addEdge("Ipiranga", "Vila Prudente",1);
        grafo.addEdge("Vila Prudente", "Ipiranga",1);

        grafo.addEdge("Vila Prudente", "Oratório",1);
        grafo.addEdge("Oratório", "Vila Prudente",1);

        grafo.addEdge("Oratório", "São Lucas",1);
        grafo.addEdge("São Lucas", "Oratório",1);

        grafo.addEdge("São Lucas", "Camilo Haddad",1);
        grafo.addEdge("Camilo Haddad", "São Lucas",1);

        grafo.addEdge("Camilo Haddad", "Vila Tolstói",1);
        grafo.addEdge("Vila Tolstói", "Camilo Haddad",1);

        grafo.addEdge("Vila Tolstói", "Vila União",1);
        grafo.addEdge("Vila União", "Vila Tolstói",1);

        grafo.addEdge("Vila União", "Jardim Planalto",1);
        grafo.addEdge("Jardim Planalto", "Vila União",1);

        grafo.addEdge("Jardim Planalto", "Sapopemba",1);
        grafo.addEdge("Sapopemba", "Jardim Planalto",1);

        grafo.addEdge("Sapopemba", "Fazenda da Juta",1);
        grafo.addEdge("Fazenda da Juta", "Sapopemba",1);

        grafo.addEdge("Fazenda da Juta", "São Mateus",1);
        grafo.addEdge("São Mateus", "Fazenda da Juta",1);

        grafo.addEdge("São Mateus", "Jardim Colonial",1);
        grafo.addEdge("Jardim Colonial", "São Mateus",1);

        grafo.addEdge("Jardim Colonial-IGT", "Boa Esperança-BEP",1);
        grafo.addEdge("Boa Esperança-BEP", "Jardim Colonial-IGT",1);

        grafo.addEdge("Boa Esperança-BEP", "Jacu-Pêssego-JPS",1);
        grafo.addEdge("Jacu-Pêssego-JPS", "Boa Esperança-BEP",1);

        grafo.addEdge("Jacu-Pêssego-JPS", "Jardim Marilu",1);
        grafo.addEdge("Jardim Marilu", "Jacu-Pêssego-JPS",1);

        grafo.addEdge("Jardim Marilu", "Jardim Pedra Branca",1);
        grafo.addEdge("Jardim Pedra Branca", "Jardim Marilu",1);

        grafo.addEdge("Jardim Pedra Branca", "Cidade Tiradentes",1);
        grafo.addEdge("Cidade Tiradentes", "Jardim Pedra Branca",1);

        grafo.addEdge("Cidade Tiradentes", "Hospital Cidade Tiradentes",1);
        grafo.addEdge("Hospital Cidade Tiradentes", "Cidade Tiradentes",1);

        List<String> caminhoMaisCurto = grafo.caminhoMaisCurto(origem, destino);

        if (caminhoMaisCurto.isEmpty()) {
            System.out.println("❌ Não foi possível encontrar um caminho entre as estações.");
        } else {
            System.out.println("✅ Caminho mais curto:");
            for (int i = 0; i < caminhoMaisCurto.size(); i++) {
                System.out.print(caminhoMaisCurto.get(i));
                if (i < caminhoMaisCurto.size() - 1) System.out.print(" → ");
            }
            System.out.println();
        }
    }
}