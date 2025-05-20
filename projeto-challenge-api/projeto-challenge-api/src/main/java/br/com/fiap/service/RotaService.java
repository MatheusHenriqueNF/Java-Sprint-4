package br.com.fiap.service;

import br.com.fiap.beans.Grafo;
import java.util.List;

public class RotaService {

    public List<String> calcularRota(String origem, String destino) {
        Grafo grafo = new Grafo();

        //Linha 1 - Azul
        grafo.adicionarAresta("Jabaquara", "Conceição");
        grafo.adicionarAresta("Conceição", "Jabaquara");

        grafo.adicionarAresta("Conceição", "São Judas");
        grafo.adicionarAresta("São Judas", "Conceição");

        grafo.adicionarAresta("São Judas", "Saúde");
        grafo.adicionarAresta("Saúde", "São Judas");

        grafo.adicionarAresta("Saúde", "Praça da Árvore");
        grafo.adicionarAresta("Praça da Árvore", "Saúde");

        grafo.adicionarAresta("Praça da Árvore", "Santa Cruz");
        grafo.adicionarAresta("Santa Cruz", "Praça da Árvore");

        grafo.adicionarAresta("Santa Cruz", "Vila Mariana");
        grafo.adicionarAresta("Vila Mariana", "Santa Cruz");

        grafo.adicionarAresta("Vila Mariana", "Ana Rosa");
        grafo.adicionarAresta("Ana Rosa", "Vila Mariana");

        grafo.adicionarAresta("Ana Rosa", "Paraíso");
        grafo.adicionarAresta("Paraíso", "Ana Rosa");

        grafo.adicionarAresta("Paraíso", "Vergueiro");
        grafo.adicionarAresta("Vergueiro", "Paraíso");

        grafo.adicionarAresta("Vergueiro", "São Joaquim");
        grafo.adicionarAresta("São Joaquim", "Vergueiro");

        grafo.adicionarAresta("São Joaquim", "Liberdade");
        grafo.adicionarAresta("Liberdade", "São Joaquim");

        grafo.adicionarAresta("Liberdade", "Sé");
        grafo.adicionarAresta("Sé", "Liberdade");

        grafo.adicionarAresta("Sé", "São Bento");
        grafo.adicionarAresta("São Bento", "Sé");

        grafo.adicionarAresta("São Bento", "Luz");
        grafo.adicionarAresta("Luz", "São Bento");

        grafo.adicionarAresta("Luz", "Tiradentes");
        grafo.adicionarAresta("Tiradentes", "Luz");

        grafo.adicionarAresta("Tiradentes", "Armênia");
        grafo.adicionarAresta("Armênia", "Tiradentes");

        grafo.adicionarAresta("Armênia", "Portuguesa-Tietê");
        grafo.adicionarAresta("Portuguesa-Tietê", "Armênia");

        grafo.adicionarAresta("Portuguesa-Tietê", "Carandiru");
        grafo.adicionarAresta("Carandiru", "Portuguesa-Tietê");

        grafo.adicionarAresta("Carandiru", "Santana");
        grafo.adicionarAresta("Santana", "Carandiru");

        grafo.adicionarAresta("Santana", "Jardim São Paulo-Ayrton Senna");
        grafo.adicionarAresta("Jardim São Paulo-Ayrton Senna", "Santana");

        grafo.adicionarAresta("Jardim São Paulo-Ayrton Senna", "Parada Inglesa");
        grafo.adicionarAresta("Parada Inglesa", "Jardim São Paulo-Ayrton Senna");

        grafo.adicionarAresta("Parada Inglesa", "Tucuruvi");
        grafo.adicionarAresta("Tucuruvi", "Parada Inglesa");

        // Linha 2 - Verde
        grafo.adicionarAresta("Vila Prudente", "Tamanduateí");
        grafo.adicionarAresta("Tamanduateí", "Vila Prudente");

        grafo.adicionarAresta("Tamanduateí", "Sacomã");
        grafo.adicionarAresta("Sacomã", "Tamanduateí");

        grafo.adicionarAresta("Sacomã", "Alto do Ipiranga");
        grafo.adicionarAresta("Alto do Ipiranga", "Sacomã");

        grafo.adicionarAresta("Alto do Ipiranga", "Santos-Imigrantes");
        grafo.adicionarAresta("Santos-Imigrantes", "Alto do Ipiranga");

        grafo.adicionarAresta("Santos-Imigrantes", "Chácara Klabin");
        grafo.adicionarAresta("Chácara Klabin", "Santos-Imigrantes");

        grafo.adicionarAresta("Chácara Klabin", "Ana Rosa"); // baldeação com Linha Azul
        grafo.adicionarAresta("Ana Rosa", "Chácara Klabin");

        grafo.adicionarAresta("Ana Rosa", "Paraíso"); // conexão direta com a Linha Azul
        grafo.adicionarAresta("Paraíso", "Ana Rosa");

        grafo.adicionarAresta("Paraíso", "Brigadeiro");
        grafo.adicionarAresta("Brigadeiro", "Paraíso");

        grafo.adicionarAresta("Brigadeiro", "Trianon-Masp");
        grafo.adicionarAresta("Trianon-Masp", "Brigadeiro");

        grafo.adicionarAresta("Trianon-Masp", "Consolação");
        grafo.adicionarAresta("Consolação", "Trianon-Masp");

        grafo.adicionarAresta("Consolação", "Clínicas");
        grafo.adicionarAresta("Clínicas", "Consolação");

        grafo.adicionarAresta("Clínicas", "Santuário Nossa Senhora de Fátima - Sumaré");
        grafo.adicionarAresta("Santuário Nossa Senhora de Fátima - Sumaré", "Clínicas");

        grafo.adicionarAresta("Santuário Nossa Senhora de Fátima - Sumaré", "Vila Madalena");
        grafo.adicionarAresta("Vila Madalena", "Santuário Nossa Senhora de Fátima - Sumaré");

        // Linha 3 - Vermelha

        grafo.adicionarAresta("Corinthians-Itaquera", "Artur Alvim");
        grafo.adicionarAresta("Artur Alvim", "Corinthians-Itaquera");

        grafo.adicionarAresta("Artur Alvim", "Patriarca");
        grafo.adicionarAresta("Patriarca", "Artur Alvim");

        grafo.adicionarAresta("Patriarca", "Guilhermina-Esperança");
        grafo.adicionarAresta("Guilhermina-Esperança", "Patriarca");

        grafo.adicionarAresta("Guilhermina-Esperança", "Vila Matilde");
        grafo.adicionarAresta("Vila Matilde", "Guilhermina-Esperança");

        grafo.adicionarAresta("Vila Matilde", "Penha");
        grafo.adicionarAresta("Penha", "Vila Matilde");

        grafo.adicionarAresta("Penha", "Carrão");
        grafo.adicionarAresta("Carrão", "Penha");

        grafo.adicionarAresta("Carrão", "Tatuapé");
        grafo.adicionarAresta("Tatuapé", "Carrão");

        grafo.adicionarAresta("Tatuapé", "Belém");
        grafo.adicionarAresta("Belém", "Tatuapé");

        grafo.adicionarAresta("Belém", "Bresser-Mooca");
        grafo.adicionarAresta("Bresser-Mooca", "Belém");

        grafo.adicionarAresta("Bresser-Mooca", "Brás");
        grafo.adicionarAresta("Brás", "Bresser-Mooca");

        grafo.adicionarAresta("Brás", "Pedro II");
        grafo.adicionarAresta("Pedro II", "Brás");

        grafo.adicionarAresta("Pedro II", "Sé");
        grafo.adicionarAresta("Sé", "Pedro II");

        grafo.adicionarAresta("Anhangabaú", "Sé");
        grafo.adicionarAresta("Sé", "Anhangabaú");

        grafo.adicionarAresta("Republica", "Anhangabaú");
        grafo.adicionarAresta("Anhangabaú", "Republica");

        grafo.adicionarAresta("Santa Cecília", "Republica");
        grafo.adicionarAresta("Republica", "Santa Cecília");

        grafo.adicionarAresta("Marechal Deodoro", "Santa Cecília");
        grafo.adicionarAresta("Santa Cecília", "Marechal Deodoro");

        grafo.adicionarAresta("Palmeiras-Barra Funda", "Marechal Deodoro");
        grafo.adicionarAresta("Marechal Deodoro", "Palmeiras-Barra Funda");

        // Linha 4 - Amarela
        grafo.adicionarAresta("Vila Sônia", "São Paulo-Morumbi");
        grafo.adicionarAresta("São Paulo-Morumbi", "Vila Sônia");

        grafo.adicionarAresta("São Paulo-Morumbi", "Butantã");
        grafo.adicionarAresta("Butantã", "São Paulo-Morumbi");

        grafo.adicionarAresta("Butantã", "Pinheiros");
        grafo.adicionarAresta("Pinheiros", "Butantã");

        grafo.adicionarAresta("Pinheiros", "Faria Lima");
        grafo.adicionarAresta("Faria Lima", "Pinheiros");

        grafo.adicionarAresta("Faria Lima", "Fradique Coutinho");
        grafo.adicionarAresta("Fradique Coutinho", "Faria Lima");

        grafo.adicionarAresta("Fradique Coutinho", "Oscar Freire");
        grafo.adicionarAresta("Oscar Freire", "Fradique Coutinho");

        grafo.adicionarAresta("Oscar Freire", "Paulista");
        grafo.adicionarAresta("Paulista", "Oscar Freire");

        grafo.adicionarAresta("Paulista", "Higienópolis-Mackenzie");
        grafo.adicionarAresta("Higienópolis-Mackenzie", "Paulista");

        grafo.adicionarAresta("Higienópolis-Mackenzie", "República");
        grafo.adicionarAresta("República", "Higienópolis-Mackenzie");

        grafo.adicionarAresta("República", "Luz");
        grafo.adicionarAresta("Luz", "República");

        // Linha 5 - Lilás
        grafo.adicionarAresta("Capão Redondo", "Campo Limpo");
        grafo.adicionarAresta("Campo Limpo", "Capão Redondo");

        grafo.adicionarAresta("Campo Limpo", "Vila das Belezas");
        grafo.adicionarAresta("Vila das Belezas", "Campo Limpo");

        grafo.adicionarAresta("Vila das Belezas", "Giovanni Gronchi");
        grafo.adicionarAresta("Giovanni Gronchi", "Vila das Belezas");

        grafo.adicionarAresta("Giovanni Gronchi", "Santo Amaro");
        grafo.adicionarAresta("Santo Amaro", "Giovanni Gronchi");

        grafo.adicionarAresta("Santo Amaro", "Largo Treze");
        grafo.adicionarAresta("Largo Treze", "Santo Amaro");

        grafo.adicionarAresta("Largo Treze", "Adolfo Pinheiro");
        grafo.adicionarAresta("Adolfo Pinheiro", "Largo Treze");

        grafo.adicionarAresta("Adolfo Pinheiro", "Alto da Boa Vista");
        grafo.adicionarAresta("Alto da Boa Vista", "Adolfo Pinheiro");

        grafo.adicionarAresta("Alto da Boa Vista", "Borba Gato");
        grafo.adicionarAresta("Borba Gato", "Alto da Boa Vista");

        grafo.adicionarAresta("Borba Gato", "Brooklin");
        grafo.adicionarAresta("Brooklin", "Borba Gato");

        grafo.adicionarAresta("Brooklin", "Campo Belo");
        grafo.adicionarAresta("Campo Belo", "Brooklin");

        grafo.adicionarAresta("Campo Belo", "Eucaliptos");
        grafo.adicionarAresta("Eucaliptos", "Campo Belo");

        grafo.adicionarAresta("Eucaliptos", "Moema");
        grafo.adicionarAresta("Moema", "Eucaliptos");

        grafo.adicionarAresta("Moema", "AACD-Servidor");
        grafo.adicionarAresta("AACD-Servidor", "Moema");

        grafo.adicionarAresta("AACD-Servidor", "Hospital São Paulo");
        grafo.adicionarAresta("Hospital São Paulo", "AACD-Servidor");

        grafo.adicionarAresta("Hospital São Paulo", "Santa Cruz");
        grafo.adicionarAresta("Santa Cruz", "Hospital São Paulo");

        grafo.adicionarAresta("Santa Cruz", "Chácara Klabin");
        grafo.adicionarAresta("Chácara Klabin", "Santa Cruz");

        //Linha 7 - Rubi

        grafo.adicionarAresta("Luz", "Palmeiras-Barra Funda");
        grafo.adicionarAresta("Palmeiras-Barra Funda", "Luz");

        grafo.adicionarAresta("Palmeiras-Barra Funda", "Água Branca");
        grafo.adicionarAresta("Água Branca", "Palmeiras-Barra Funda");

        grafo.adicionarAresta("Água Branca", "Lapa");
        grafo.adicionarAresta("Lapa", "Água Branca");

        grafo.adicionarAresta("Lapa", "Piqueri");
        grafo.adicionarAresta("Piqueri", "Lapa");

        grafo.adicionarAresta("Piqueri", "Pirituba");
        grafo.adicionarAresta("Pirituba", "Piqueri");

        grafo.adicionarAresta("Pirituba", "Vila Clarice");
        grafo.adicionarAresta("Vila Clarice", "Pirituba");

        grafo.adicionarAresta("Vila Clarice", "Jaraguá");
        grafo.adicionarAresta("Jaraguá", "Vila Clarice");

        grafo.adicionarAresta("Jaraguá", "Perus");
        grafo.adicionarAresta("Perus", "Jaraguá");

        grafo.adicionarAresta("Perus", "Caieiras");
        grafo.adicionarAresta("Caieiras", "Perus");

        grafo.adicionarAresta("Caieiras", "Franco da Rocha");
        grafo.adicionarAresta("Franco da Rocha", "Caieiras");

        grafo.adicionarAresta("Franco da Rocha", "Baltazar Fidélis");
        grafo.adicionarAresta("Baltazar Fidélis", "Franco da Rocha");

        grafo.adicionarAresta("Baltazar Fidélis", "Francisco Morato");
        grafo.adicionarAresta("Francisco Morato", "Baltazar Fidélis");

        grafo.adicionarAresta("Francisco Morato", "Botujuru");
        grafo.adicionarAresta("Botujuru", "Francisco Morato");

        grafo.adicionarAresta("Botujuru", "Campo Limpo Paulista");
        grafo.adicionarAresta("Campo Limpo Paulista", "Botujuru");

        grafo.adicionarAresta("Campo Limpo Paulista", "Várzea Paulista");
        grafo.adicionarAresta("Várzea Paulista", "Campo Limpo Paulista");

        grafo.adicionarAresta("Várzea Paulista", "Jundiaí");
        grafo.adicionarAresta("Jundiaí", "Várzea Paulista");



        // Conexões da Linha 8-Diamante
        grafo.adicionarAresta("Júlio Prestes", "Palmeiras-Barra Funda");
        grafo.adicionarAresta("Palmeiras-Barra Funda", "Júlio Prestes");

        grafo.adicionarAresta("Palmeiras-Barra Funda", "Lapa");
        grafo.adicionarAresta("Lapa", "Palmeiras-Barra Funda");

        grafo.adicionarAresta("Lapa", "Domingos de Moraes");
        grafo.adicionarAresta("Domingos de Moraes", "Lapa");

        grafo.adicionarAresta("Domingos de Moraes", "Imperatriz Leopoldina");
        grafo.adicionarAresta("Imperatriz Leopoldina", "Domingos de Moraes");

        grafo.adicionarAresta("Imperatriz Leopoldina", "Presidente Altino");
        grafo.adicionarAresta("Presidente Altino", "Imperatriz Leopoldina");

        grafo.adicionarAresta("Presidente Altino", "Osasco");
        grafo.adicionarAresta("Osasco", "Presidente Altino");

        grafo.adicionarAresta("Osasco", "Comandante Sampaio");
        grafo.adicionarAresta("Comandante Sampaio", "Osasco");

        grafo.adicionarAresta("Comandante Sampaio", "Quitaúna");
        grafo.adicionarAresta("Quitaúna", "Comandante Sampaio");

        grafo.adicionarAresta("Quitaúna", "General Miguel Costa");
        grafo.adicionarAresta("General Miguel Costa", "Quitaúna");

        grafo.adicionarAresta("General Miguel Costa", "Carapicuíba");
        grafo.adicionarAresta("Carapicuíba", "General Miguel Costa");

        grafo.adicionarAresta("Carapicuíba", "Santa Terezinha");
        grafo.adicionarAresta("Santa Terezinha", "Carapicuíba");

        grafo.adicionarAresta("Santa Terezinha", "Antonio João");
        grafo.adicionarAresta("Antonio João", "Santa Terezinha");

        grafo.adicionarAresta("Antonio João", "Barueri");
        grafo.adicionarAresta("Barueri", "Antonio João");

        grafo.adicionarAresta("Barueri", "Jardim Belval");
        grafo.adicionarAresta("Jardim Belval", "Barueri");

        grafo.adicionarAresta("Jardim Belval", "Jardim Silveira");
        grafo.adicionarAresta("Jardim Silveira", "Jardim Belval");

        grafo.adicionarAresta("Jardim Silveira", "Jandira");
        grafo.adicionarAresta("Jandira", "Jardim Silveira");

        grafo.adicionarAresta("Jandira", "Sagrado Coração");
        grafo.adicionarAresta("Sagrado Coração", "Jandira");

        grafo.adicionarAresta("Sagrado Coração", "Engenheiro Cardoso");
        grafo.adicionarAresta("Engenheiro Cardoso", "Sagrado Coração");

        grafo.adicionarAresta("Engenheiro Cardoso", "Itapevi");
        grafo.adicionarAresta("Itapevi", "Engenheiro Cardoso");

        grafo.adicionarAresta("Itapevi", "Amador Bueno");
        grafo.adicionarAresta("Amador Bueno", "Itapevi");

        //Linha 9 - Esmeralda

        grafo.adicionarAresta("Osasco", "Presidente Altino");
        grafo.adicionarAresta("Presidente Altino", "Osasco");

        grafo.adicionarAresta("Presidente Altino", "Ceasa");
        grafo.adicionarAresta("Ceasa", "Presidente Altino");

        grafo.adicionarAresta("Ceasa", "Villa Lobos-Jaguaré");
        grafo.adicionarAresta("Villa Lobos-Jaguaré", "Ceasa");

        grafo.adicionarAresta("Villa Lobos-Jaguaré", "Cidade Universitária");
        grafo.adicionarAresta("Cidade Universitária", "Villa Lobos-Jaguaré");

        grafo.adicionarAresta("Cidade Universitária", "Pinheiros");
        grafo.adicionarAresta("Pinheiros", "Cidade Universitária");

        grafo.adicionarAresta("Pinheiros", "Hebraica-Rebouças");
        grafo.adicionarAresta("Hebraica-Rebouças", "Pinheiros");

        grafo.adicionarAresta("Hebraica-Rebouças", "Cidade Jardim");
        grafo.adicionarAresta("Cidade Jardim", "Hebraica-Rebouças");

        grafo.adicionarAresta("Cidade Jardim", "Vila Olímpia");
        grafo.adicionarAresta("Vila Olímpia", "Cidade Jardim");

        grafo.adicionarAresta("Vila Olímpia", "Berrini");
        grafo.adicionarAresta("Berrini", "Vila Olímpia");

        grafo.adicionarAresta("Berrini", "Morumbi");
        grafo.adicionarAresta("Morumbi", "Berrini");

        grafo.adicionarAresta("Morumbi", "Granja Julieta");
        grafo.adicionarAresta("Granja Julieta", "Morumbi");

        grafo.adicionarAresta("Granja Julieta", "Santo Amaro");
        grafo.adicionarAresta("Santo Amaro", "Granja Julieta");

        grafo.adicionarAresta("Santo Amaro", "Socorro");
        grafo.adicionarAresta("Socorro", "Santo Amaro");

        grafo.adicionarAresta("Socorro", "Jurubatuba");
        grafo.adicionarAresta("Jurubatuba", "Socorro");

        grafo.adicionarAresta("Jurubatuba", "Autódromo");
        grafo.adicionarAresta("Autódromo", "Jurubatuba");

        grafo.adicionarAresta("Autódromo", "Primavera-Interlagos");
        grafo.adicionarAresta("Primavera-Interlagos", "Autódromo");

        grafo.adicionarAresta("Primavera-Interlagos", "Grajaú");
        grafo.adicionarAresta("Grajaú", "Primavera-Interlagos");

        grafo.adicionarAresta("Grajaú", "Bruno Covas/Mendes-Vila Natal");
        grafo.adicionarAresta("Bruno Covas/Mendes-Vila Natal", "Grajaú");

        grafo.adicionarAresta("Bruno Covas/Mendes-Vila Natal", "Varginha");
        grafo.adicionarAresta("Varginha", "Bruno Covas/Mendes-Vila Natal");

        //Linha 10 - Turquesa

        grafo.adicionarAresta("Juventus-Mooca", "Ipiranga");
        grafo.adicionarAresta("Ipiranga", "Juventus-Mooca");

        grafo.adicionarAresta("Ipiranga", "Tamanduateí");
        grafo.adicionarAresta("Tamanduateí", "Ipiranga");

        grafo.adicionarAresta("Tamanduateí", "São Caetano do Sul-Prefeito Walter Braido");
        grafo.adicionarAresta("São Caetano do Sul-Prefeito Walter Braido", "Tamanduateí");

        grafo.adicionarAresta("São Caetano do Sul-Prefeito Walter Braido", "Utinga");
        grafo.adicionarAresta("Utinga", "São Caetano do Sul-Prefeito Walter Braido");

        grafo.adicionarAresta("Utinga", "Prefeito Saladino");
        grafo.adicionarAresta("Prefeito Saladino", "Utinga");

        grafo.adicionarAresta("Prefeito Saladino", "Prefeito Celso Daniel-Santo André");
        grafo.adicionarAresta("Prefeito Celso Daniel-Santo André", "Prefeito Saladino");

        grafo.adicionarAresta("Prefeito Celso Daniel-Santo André", "Capuava");
        grafo.adicionarAresta("Capuava", "Prefeito Celso Daniel-Santo André");

        grafo.adicionarAresta("Capuava", "Mauá");
        grafo.adicionarAresta("Mauá", "Capuava");

        grafo.adicionarAresta("Mauá", "Guapituba");
        grafo.adicionarAresta("Guapituba", "Mauá");

        grafo.adicionarAresta("Guapituba", "Ribeirão Pires-Antônio Bespalec");
        grafo.adicionarAresta("Ribeirão Pires-Antônio Bespalec", "Guapituba");

        grafo.adicionarAresta("Ribeirão Pires-Antônio Bespalec", "Rio Grande da Serra");
        grafo.adicionarAresta("Rio Grande da Serra", "Ribeirão Pires-Antônio Bespalec");

        // Linha 11 - Coral

        grafo.adicionarAresta("Luz", "Brás");
        grafo.adicionarAresta("Brás", "Luz");

        grafo.adicionarAresta("Brás", "Tatuapé");
        grafo.adicionarAresta("Tatuapé", "Brás");

        grafo.adicionarAresta("Tatuapé", "Corinthians-Itaquera");
        grafo.adicionarAresta("Corinthians-Itaquera", "Tatuapé");

        grafo.adicionarAresta("Corinthians-Itaquera", "Dom Bosco");
        grafo.adicionarAresta("Dom Bosco", "Corinthians-Itaquera");

        grafo.adicionarAresta("Dom Bosco", "José Bonifácio");
        grafo.adicionarAresta("José Bonifácio", "Dom Bosco");

        grafo.adicionarAresta("José Bonifácio", "Guaianases");
        grafo.adicionarAresta("Guaianases", "José Bonifácio");

        grafo.adicionarAresta("Guaianases", "Antônio Gianetti Neto");
        grafo.adicionarAresta("Antônio Gianetti Neto", "Guaianases");

        grafo.adicionarAresta("Antônio Gianetti Neto", "Ferraz de Vasconcelos");
        grafo.adicionarAresta("Ferraz de Vasconcelos", "Antônio Gianetti Neto");

        grafo.adicionarAresta("Ferraz de Vasconcelos", "Poá");
        grafo.adicionarAresta("Poá", "Ferraz de Vasconcelos");

        grafo.adicionarAresta("Poá", "Calmon Viana");
        grafo.adicionarAresta("Calmon Viana", "Poá");

        grafo.adicionarAresta("Calmon Viana", "Suzano");
        grafo.adicionarAresta("Suzano", "Calmon Viana");

        grafo.adicionarAresta("Suzano", "Jundiapeba");
        grafo.adicionarAresta("Jundiapeba", "Suzano");

        grafo.adicionarAresta("Jundiapeba", "Braz Cubas");
        grafo.adicionarAresta("Braz Cubas", "Jundiapeba");

        grafo.adicionarAresta("Braz Cubas", "Mogi das Cruzes");
        grafo.adicionarAresta("Mogi das Cruzes", "Braz Cubas");

        grafo.adicionarAresta("Mogi das Cruzes", "Estudantes");
        grafo.adicionarAresta("Estudantes", "Mogi das Cruzes");

        //Linha 12 - Safira

        grafo.adicionarAresta("Brás", "Tatuapé");
        grafo.adicionarAresta("Tatuapé", "Brás");

        grafo.adicionarAresta("Tatuapé", "Engenheiro Goulart");
        grafo.adicionarAresta("Engenheiro Goulart", "Tatuapé");

        grafo.adicionarAresta("Engenheiro Goulart", "USP Leste");
        grafo.adicionarAresta("USP Leste", "Engenheiro Goulart");

        grafo.adicionarAresta("USP Leste", "Comendador Ermelino");
        grafo.adicionarAresta("Comendador Ermelino", "USP Leste");

        grafo.adicionarAresta("Comendador Ermelino", "São Miguel Paulista");
        grafo.adicionarAresta("São Miguel Paulista", "Comendador Ermelino");

        grafo.adicionarAresta("São Miguel Paulista", "Jardim Helena-Vila Mara");
        grafo.adicionarAresta("Jardim Helena-Vila Mara", "São Miguel Paulista");

        grafo.adicionarAresta("Jardim Helena-Vila Mara", "Itaim Paulista");
        grafo.adicionarAresta("Itaim Paulista", "Jardim Helena-Vila Mara");

        grafo.adicionarAresta("Itaim Paulista", "Jardim Romano");
        grafo.adicionarAresta("Jardim Romano", "Itaim Paulista");

        grafo.adicionarAresta("Jardim Romano", "Engenheiro Manoel Feio");
        grafo.adicionarAresta("Engenheiro Manoel Feio", "Jardim Romano");

        grafo.adicionarAresta("Engenheiro Manoel Feio", "Itaquaquecetuba");
        grafo.adicionarAresta("Itaquaquecetuba", "Engenheiro Manoel Feio");

        grafo.adicionarAresta("Itaquaquecetuba", "Aracaré");
        grafo.adicionarAresta("Aracaré", "Itaquaquecetuba");

        grafo.adicionarAresta("Aracaré", "Calmon Viana");
        grafo.adicionarAresta("Calmon Viana", "Aracaré");

        //Linha 13 - Jade

        grafo.adicionarAresta("Engenheiro Goulart", "Guarulhos-Cecap");
        grafo.adicionarAresta("Guarulhos-Cecap", "Engenheiro Goulart");

        grafo.adicionarAresta("Guarulhos–Cecap", "Aeroporto–Guarulhos");
        grafo.adicionarAresta("Aeroporto–Guarulhos", "Guarulhos–Cecap");

        //Linha 15 - Prata

        grafo.adicionarAresta("Ipiranga", "Vila Prudente");
        grafo.adicionarAresta("Vila Prudente", "Ipiranga");

        grafo.adicionarAresta("Vila Prudente", "Oratório");
        grafo.adicionarAresta("Oratório", "Vila Prudente");

        grafo.adicionarAresta("Oratório", "São Lucas");
        grafo.adicionarAresta("São Lucas", "Oratório");

        grafo.adicionarAresta("São Lucas", "Camilo Haddad");
        grafo.adicionarAresta("Camilo Haddad", "São Lucas");

        grafo.adicionarAresta("Camilo Haddad", "Vila Tolstói");
        grafo.adicionarAresta("Vila Tolstói", "Camilo Haddad");

        grafo.adicionarAresta("Vila Tolstói", "Vila União");
        grafo.adicionarAresta("Vila União", "Vila Tolstói");

        grafo.adicionarAresta("Vila União", "Jardim Planalto");
        grafo.adicionarAresta("Jardim Planalto", "Vila União");

        grafo.adicionarAresta("Jardim Planalto", "Sapopemba");
        grafo.adicionarAresta("Sapopemba", "Jardim Planalto");

        grafo.adicionarAresta("Sapopemba", "Fazenda da Juta");
        grafo.adicionarAresta("Fazenda da Juta", "Sapopemba");

        grafo.adicionarAresta("Fazenda da Juta", "São Mateus");
        grafo.adicionarAresta("São Mateus", "Fazenda da Juta");

        grafo.adicionarAresta("São Mateus", "Jardim Colonial");
        grafo.adicionarAresta("Jardim Colonial", "São Mateus");

        grafo.adicionarAresta("Jardim Colonial-IGT", "Boa Esperança-BEP");
        grafo.adicionarAresta("Boa Esperança-BEP", "Jardim Colonial-IGT");

        grafo.adicionarAresta("Boa Esperança-BEP", "Jacu-Pêssego-JPS");
        grafo.adicionarAresta("Jacu-Pêssego-JPS", "Boa Esperança-BEP");

        grafo.adicionarAresta("Jacu-Pêssego-JPS", "Jardim Marilu");
        grafo.adicionarAresta("Jardim Marilu", "Jacu-Pêssego-JPS");

        grafo.adicionarAresta("Jardim Marilu", "Jardim Pedra Branca");
        grafo.adicionarAresta("Jardim Pedra Branca", "Jardim Marilu");

        grafo.adicionarAresta("Jardim Pedra Branca", "Cidade Tiradentes");
        grafo.adicionarAresta("Cidade Tiradentes", "Jardim Pedra Branca");

        grafo.adicionarAresta("Cidade Tiradentes", "Hospital Cidade Tiradentes");
        grafo.adicionarAresta("Hospital Cidade Tiradentes", "Cidade Tiradentes");








        return grafo.encontrarCaminho(origem, destino);
    }
}
