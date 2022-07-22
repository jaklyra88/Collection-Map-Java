package br.com.jaklyra.exemplos;
/*
Dado os modelos dos carros e seus respectivos consumos na estrada, faça:

modelo = gol - consumo = 14,4km/l
modelo = uno - consumo = 15,6km/l
modelo = mobi - consumo = 16,1km/l
modelo = hb20 - consumo = 14,5km/l
modelo = kwid - consumo = 15,6km/l

 */

import java.util.*;

public class ExemploMap {

    public static void main(String[] args){

        //Map carrosPopulares2020 = new HashMap();
        //Map<String, Double> carrosPopulares = new HashMap<>();
        //HashMap<String, Double> carrosPopulares = new HasMap<>();
        //Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6,  "mobi" , 16.1,"hb20" , 14.5,  "kwid" , 15.6);


        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        //CRIANDO UM DICIONÁRIO

        // MAP <TIPODACHAVE> nomeMap = new HashMap
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            //NÃO PODEMOS UTILIZAR O MÉTODO ADD
            //PARA O DICIONARIO O MÉTODO PARA ADICIONAR ELEMENTOS É O PUT

            //ADICIONANDO ELEMENTOS NO MDICIONÁRIO
            //PUT( CHAVE , VALOR)
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);


        }};

        System.out.println("");
        System.out.println(carrosPopulares.toString());
        System.out.println(carrosPopulares);

        System.out.println("");
        System.out.println("Substitua o consumo do gol por 15,2km/l: ");
        System.out.println("");

        //UTILIZAMOS O PUT, POIS TEMOS CHAVES DE VALOR ÚNICO, ENTÃO SOBREESCREVEMOS O VALOR
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);
        System.out.println("");

        //BUSCANDO UM OBJETO CHAVE NO DICIONÁRIO
        System.out.println("Confira se o modelo Tucson está no dicionário: " +  carrosPopulares.containsKey("Tucson"));
        System.out.println("");

        //BUSCANDO UMA INFORMAÇÃO DE UM OBJETO, PSSANDO UMA CHAME E RETORNANDO UM VALOR
        System.out.println("Exiba o consumo do Uno: " + carrosPopulares.get("uno"));
        System.out.println("");

        //NÃO TEMOS UM MÉTODO QUE POSSA MOSTRAR
        System.out.println("Exiba o terceiro modelo adicionado: ");
        System.out.println("NÃO É POSSÍVEL");
        System.out.println("");

        //RETORNA O SET COM AS CHAVES CONTIDAS NO DICIONÁRIO
        System.out.println("Exiba os modelos: ");
        Set<String> modelo = carrosPopulares.keySet();
        System.out.println(modelo);
        System.out.println("");

        //RETORNA UM COLLECTION COM OS VALUES CONTIDAS NOS DICIONÁRIOS
        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumo = carrosPopulares.values();
        System.out.println(consumo);
        System.out.println("");

        //RECEBE UMA COLLECTION E UTILIZAMOS O MÉTODO VALUES PARA RETORNAR UMA COLLECTION COM TODOS OS VALORES
        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());

        //MÉTODO ENTRYSET - RETORNA UM SET E OS ELEMENTOS DENTRO DESTE SET SÃO DO TIPO ENTRIE
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

        //VARIÁVEL DE CONTROLE
        String modeloMaiseficiente = "" ;

        //ELEMENTO ENTRY QUE IRÁ RETORNAR DENTRO DO SET DE ENTRIES
        for (Map.Entry<String, Double> entry: entries) {

            //SE O PRIMEIRO ELEMENTO DO ENTRIES E SEU VALOR FOR IGUAL AO CONSUMOMAIS EFICIENTE
            //PODEMOS DIZER QUE O MOEDLO MAIS EFICIENTE É IGUAL A CHAVE REFERENTE A ESTE ENTRY( VALOR)
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaiseficiente = entry.getKey();
                System.out.println("O modelo mais eficiente é o : " + modeloMaiseficiente +
                        " - seu consumo é: " + consumoMaisEficiente +"km/l" );
            }

        }

        System.out.println("");

        //O MÉTODO VALUES RETORNA UMA COLLECTION DE VALORESE O MÉTODO KEY SET RETORNA UM SET DE KEYS
        System.out.println("Exiba o modelo menos econômico e seu consumo: ");

        //RECEBEMOS A COLLECTION EM UMA VARIÁVEL COM OS VALORES DO DICIONÁRIO QUE BUSCAMOS ATRAVÉS DO VALUES
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());

        ///VARIÁVEL DE CONTROLE
        String modeloMenosEficiente = " ";

        //ENTRYSET PARA RETORNAR UM SET E DENTRO DELE PODEMOS MANIPULAR CHAVES E VALORES SEPARADAMENTE
         for (Map.Entry<String, Double> entry: carrosPopulares.entrySet()){

             //SE O ENTRY O VALOR FOR IGUAL A VARIÁVEL CONSUMOMENOSEFICIENTE ( VALUE)
            if(entry.getValue().equals(consumoMenosEficiente)){

                //A CHAVE (KEY) QUE LIGA COM ESSE VALOR TAMBÉM É O VALORMENOSEFICIENTE
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - seu consumo "
                        + consumoMenosEficiente + "km/l" );
            }
        }

         System.out.println("");

         //TRABALHAREMOS COM O SET DOS CONSUMOS E PODEMOS FAZER UM ITERATOR
         System.out.println("Exiba a soma dos consumos: ");

         //POSSÍVEL UTILIZAR POIS O RETORNO DOS CONSUMOS É UM COLLECTION
         Iterator<Double> iterator = carrosPopulares.values().iterator();

         Double soma = 0d;

         while(iterator.hasNext()){

            soma += iterator.next();

         }
                System.out.println("O total dos consumos é: " + soma);

        System.out.println("");
        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println("");
        System.out.println("Dicionário Antes da exclusão dos elementos: ");
        System.out.println(carrosPopulares);
        System.out.println("");
        System.out.println("remova os modelos com o consumo igual a 15,6km/l: ");

        Iterator<Double> iterator1 = carrosPopulares.values().iterator();

        while(iterator1.hasNext()){

            //Double next = iterator1.next();

            //if(next == 15.6){
               //iterator1.remove();
            //}

            //OU

            if(iterator1.next().equals(15.6)){
                iterator1.remove();
            }
        }
        System.out.println("Dicionário após a exclusão dos elementos: ");
        System.out.println(carrosPopulares);
        System.out.println("");

        System.out.println("Exiba todos os carros na ordem em que foram informados: ");

        //UTILIANDO A IMPLEMENTAÇÃO LINKEDHASHMAP
        Map<String,Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);

        }};


        System.out.println(carrosPopulares1.toString());
        System.out.println("");

        //O MODELO É A CHAVE , PARA ORDENAR A CHAVE UTILIZAMOS O TREEMAP
        //ORDEM ALFABETICA PELO MODELO (KEY)
        System.out.println("Exiba o dicionário ordenado pelo modelo: ");

        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);

        System.out.println(carrosPopulares2.toString());
        System.out.println("");

        System.out.println("Apague o dicionário de carros:");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);
        System.out.println("");

        System.out.println("Confira se o dicionário esta vazio");
        System.out.println(carrosPopulares.isEmpty());







    }
}
