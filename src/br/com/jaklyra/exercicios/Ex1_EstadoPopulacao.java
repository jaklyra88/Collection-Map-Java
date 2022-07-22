package br.com.jaklyra.exercicios;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça

    Estado = PE , População = 9.616.621
     Estado = AL, População = 3.351.543
      Estado = CE , População = 9.187.103
       Estado = RN, População = 3.534.265

       Crie um dicionário e relacione os estados e suas popolações
       Substitua a população do estado do RN por 3.534.165
       Confira se o estado da PB está no dicionário, caso não adicione : PB 4.039.277
       Exiba a população de PE;
       Exiba todos os estados e suas populações na ordem em que foi informado
       Exiba os estados e suas populações e sua ordem alfabetica
       Exiba o Estado com a menor população e sua quantidade
       Exiba o Estado com a maior população e sua quantidade
       Exiba a soma da população desses estados
       Exiba a média da população deste dicionario de estados
       Remova os estados com a população menor que 4.000.000
       Apague o dicionario de estados
       Confira se o dicionario está vazio
 */


import java.util.*;

public class Ex1_EstadoPopulacao {

    public static void main(String[] args){

       //CRIANDO UM DICIONARIO COM HASHMAP ADICIONANDO OS ELEMENTOS EM ORDEM ALEATÓRIA
       Map<String, Double> populacaoEstados = new HashMap<>(){{
           put("PE" , 9616621.00);
           put("AL" , 3351543.00);
           put("CE" , 9187103.00);
           put("RN" , 3534265.00);
       }};

        System.out.println(" ");
        System.out.println("Dicionário Criado: ");
        System.out.println(populacaoEstados);

        //ALTERANDO OS DADOS dDE UM DOS ELEMENTOS DO DICIONÁRIO - SOBRESCREVENDO AS INFORMAÇÕES NO DICIONÁRIO
        System.out.println(" ");
        populacaoEstados.put("RN", 3534165.00);
        System.out.println("Dicionário com a população de RN alterada: ");
        System.out.println(populacaoEstados);

        //VERIFICAÇÃO ATRAVÉS DO CONSTAIN KEY - VERIFICANDO SE O DICIONÁRIO POSSUI A CHAVE PROCURADA
        System.out.println(" ");
        System.out.println("Verificando se PB está no dicionário: ");
        System.out.println("O dicionário possui o estado de PB? " + populacaoEstados.containsKey("PB"));

        //COMO A INFORMAÇÃO NÃO CONSTA NO DICIONÁRIO, IREMOS INCLUIR
        System.out.println("");
        System.out.println("Adicionando o Estado de PB no dicionário: ");
        populacaoEstados.put("PB" , 4039277.00);
        System.out.println("");
        System.out.println("Verificação do dicionário após a inclusão do Estado: ");
        System.out.println(populacaoEstados);

        //EXIBINDO TODOS OS ESTADOS NA ORDEM EM QUE FOI INCLUÍDO - CRIADO NOVO DICIONÁRIO
        //RECEBENDO OS ELEMENTOS ATRAVÉS DO LINKEDHASHMAP ( MANTÉM A ORDEM DE INSERÇÃO);
        System.out.println(" ");

        Map<String, Double> populacaoEstados1 = new LinkedHashMap<>(){{
            put("PE" , 9616621.00);
            put("AL" , 3351543.00);
            put("CE" , 9187103.00);
            put("RN" , 3534165.00);
            put("PB" , 4039277.00);
        }};

        //CRIANDO UM NOVO DICIONÁRIO RECEBENDO OS DADOS DO DICIONÁRIO CRIADO ANTERIORMENTE
        //CRIADO VIA TREEMAP QUE RECEBE OS ELEMENTOS NA ORDEM NATURAL - ORDÉM ALFABÉTICA
        System.out.println(" ");
        System.out.println("Novo dicionário criado recebendo os itens na ordem que foram incluídos: ");
        System.out.println(populacaoEstados1);

        Map<String , Double> populacaoEstados2 = new TreeMap<>(populacaoEstados);

        System.out.println(populacaoEstados2);

        //CRIANDO UM SET PARA RECEBER OS ESTADOS
        System.out.println("");
        System.out.println("Set dos Estados: ");
        Set<String> estados = populacaoEstados.keySet();
        System.out.println(estados);

        //CRIANDO UM  COLLECTION PARA RECEBER A POPULAÇÃO DOS ESTADOS
        System.out.println("");
        System.out.println("Collection da população dos estados: ");
        Collection<Double> populacao = populacaoEstados.values();
        System.out.println(populacao);

        //COMO CRIAMOS A COLLECTION DE POPULAÇÃO, ONDE IREMOS BUSCAR A MENOR POLULAÇÃO
        Double menorPopulacao = Collections.min(populacaoEstados.values());


        System.out.println("");

        //CRIANDO UM SET COM AS INFORMAÇÕES DO DICIONÁRIO
        Set<Map.Entry<String, Double>> entries = populacaoEstados.entrySet();

        //CRIANDO A VARIÁVEL DE CONTROLE
        String estadoMenorPopulacao = " ";

        //FOR PARA LEITURA DO SET MAP.ENTRY
        for(Map.Entry<String, Double> entry: entries){

            //SE PARA COMPARAR AS INFORMAÇÕES DE CHAVE DO SET PARA SELECIONAR O ESTADO
            //QUE TEM A QUANTIDADE IGUAL AO DA VARIÁVEL QUE POSSUI O VALOR COM A MENOR POPULAÇÃO
            if(entry.getValue().equals(menorPopulacao)){
                estadoMenorPopulacao = entry.getKey();

                System.out.println("Estado com a menor população: " + estadoMenorPopulacao);
                System.out.println("Número de habitantes: " + menorPopulacao);
            }
        }

        System.out.println("");

        Double maiorPopulacao = Collections.max(populacaoEstados.values());

        String estadoMaiorPopulacao = " ";

        for(Map.Entry<String, Double> entry : entries){

            if(entry.getValue().equals(maiorPopulacao)){
                estadoMaiorPopulacao = entry.getKey();

                System.out.println("Estado com a maior população: " + estadoMaiorPopulacao);
                System.out.println("Número de habitantes: " + maiorPopulacao);
            }
        }

        // EXIBINDO A SOMA DA POPULAÇÃO DOS ESTADOS
        System.out.println(" ");
        System.out.println("Exiba a soma da população desses estados: ");

        Iterator< Double> iterator = populacaoEstados.values().iterator();

        Double soma = 0d;

        while(iterator.hasNext()){

            soma += iterator.next();

        }
        System.out.println("");
        System.out.println("A soma da população dos estados: " + soma);

        //SOMA DA MÉDIA DA POPULAÇÃO DOS ESTADOS
        System.out.println("");
        System.out.println("A média da população dos estados: " + (soma/populacaoEstados.size()));

        //REMOVANDO OS ESTADOS COM POPULAÇÃO MENOR QUE 4.000.000
        Iterator<Double> iterator1 = populacaoEstados.values().iterator();

        while(iterator1.hasNext()){

            Double next = iterator1.next();

            if( next < 4000000.0 ){
                iterator1.remove();
            }

        }

        System.out.println("");
        System.out.println("Exibindo o dicionário após a remoção dos estados com menos de 4.000.000");
        System.out.println(populacaoEstados);

        System.out.println("");
        System.out.println("Apagando o Dicionário e exibindo: ");
        populacaoEstados.clear();

        System.out.println("");
        System.out.println("O dicionário esta vazio? " + populacaoEstados.isEmpty());




    }
}

class Estado{

    private String estado;
    private Double populacao;

    public Estado(String estado, Double populacao) {
        this.estado = estado;
        this.populacao = populacao;
    }

    public String getEstado() {
        return estado;
    }

    public Double getPopulacao() {
        return populacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado1 = (Estado) o;
        return estado.equals(estado1.estado) && populacao.equals(estado1.populacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado, populacao);
    }

    @Override
    public String toString() {
        return "{" +
                "estado='" + estado + '\'' +
                ", populacao=" + populacao +
                '}';
    }
}