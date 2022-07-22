package br.com.jaklyra.exemplos;

/*
    Dadas as seguintes informações sobre livros e seus autores:
    Crie e ordene o dicionario
    Exibindo(nome Autor - Nome Livro)

    Autor = Halking, Stephen, Livro = uma breve historia do Tempo, páginas = 256
     Autor = Duhigg, Charles, Livro = O poder do Hábito, páginas = 408
      Autor = Harari, Vuval Noah, Livro = 21 lições para o século 21, páginas = 432


 */

import java.util.*;

public class ExemploOrdenacaoMap {

    public static void main(String[] args){

        //
        System.out.println("--\tOrdem Aleatória\t--");
        System.out.println("");

        Map<String, Livro> livros = new HashMap<>(){{
            put("Halking, Stephen", new Livro ("Uma breve historia do Tempo", 256));
            put("Duhigg, Charles", new Livro ("O poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro ("21 lições para o século 21", 432));

        }};

        //
        for (Map.Entry<String, Livro> livro:  livros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        }
        System.out.println("");

        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println("");

        Map<String, Livro> livros1 = new LinkedHashMap<>(){{
            put("Halking, Stephen", new Livro ("Uma breve historia do Tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};

        for (Map.Entry<String, Livro> livro: livros1.entrySet()) {
            System.out.println(livro.getKey() +" - "+ livro.getValue().getNome());

        }

        System.out.println("");


        System.out.println("--\tOrdem Alfabética autores\t--");
        Map<String, Livro> livros2 = new TreeMap<>(livros1);

        for (Map.Entry<String, Livro> livro : livros2.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        }

        System.out.println(" ");

        //OS NOMES ESTÃO NO VALOR ( VALUES), PRECISAMOS DO TREESET E COMPARATOR
        System.out.println("--\tOrdem Alfabética nomes dos livros\t--");
        System.out.println("");

        //INCINIALIZANDO O COMPARATOR CRIADO
        Set<Map.Entry<String, Livro>> livros3 = new TreeSet<>(new ComparatorNome());
        System.out.println("");

        //RECEBENDO OS ELEMENTOS DO DICIONÁRIO
        livros3.addAll(livros.entrySet());

        //NÃO NECESSITA DE ENTRYSET , POIS ESTAMOS RODANDO DIRETAMENTE NO SET
        for (Map.Entry<String, Livro> livro: livros3) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        }

        System.out.println("--\tOrdem número de páginas\t--");
        System.out.println("");

        Set<Map.Entry<String, Livro>> livros4 = new TreeSet<>(new ComparatorPagina());
        System.out.println("");

        livros4.addAll(livros.entrySet());

        for (Map.Entry<String, Livro> livro: livros4 ) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome() + " - "
            + livro.getValue().getPaginas());

        }

    }
}

 class Livro{

    private String nome;
    private Integer paginas;

     public Livro(String nome, Integer paginas) {
         this.nome = nome;
         this.paginas = paginas;
     }

     public String getNome() {
         return nome;
     }

     public Integer getPaginas() {
         return paginas;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Livro livro = (Livro) o;
         return nome.equals(livro.nome) && paginas.equals(livro.paginas);
     }

     @Override
     public int hashCode() {
         return Objects.hash(nome, paginas);
     }

     @Override
     public String toString() {
         return "{" +
                 "nome='" + nome + '\'' +
                 ", paginas=" + paginas +
                 '}';
     }
 }

 class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{


     @Override
     public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
         return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
     }
 }

 class ComparatorPagina implements  Comparator<Map.Entry<String, Livro>>{

     @Override
     public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
         return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
     }
 }