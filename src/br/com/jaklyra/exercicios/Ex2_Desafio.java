package br.com.jaklyra.exercicios;

/*
Faça um programa que simule um lançamento de dados
Lance o dado 100 vezes e armazene
Depois, mostre quenatas vezes cada valor foi inserido
 */

import java.util.*;

public class Ex2_Desafio {

    public static void main(String[] args) {

        List<Integer> numeros = new LinkedList<>() {
            {

                //INSTANCIANDO O GERADOR DE NÚMEROS ALEATÓRIOS
                Random gerador = new Random();

                //FOR QUE FAZER O PREENCHIMENTO AUTOMÁTICO DO MAP
                for (int i = 0; i <= 100; i++) {

                    int num = gerador.nextInt(30);

                    add(num);
                                   }

            }};



        Map<Integer, Integer> numerosIguais = new HashMap<>();
        for (Integer contagemNumerosIguais: numeros) {
            if(numerosIguais.containsKey(contagemNumerosIguais)){
                numerosIguais.put(contagemNumerosIguais, numerosIguais.get(contagemNumerosIguais)+ 1);
            }else{
                numerosIguais.put(contagemNumerosIguais, 1);
            }

        }

        System.out.println(numerosIguais);

        System.out.println("\n Número" + " Quantas vezes aparece na lista: ");
        for(Map.Entry<Integer, Integer> entry : numerosIguais.entrySet()){
            System.out.printf("%3d %10d\n",entry.getKey(), entry.getValue());
        }

    }

}