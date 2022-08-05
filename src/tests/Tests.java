package tests;

import lists.StaticIntegerList;

public class Tests {
    public static void main(String[] args) {
        StaticIntegerList lista = new StaticIntegerList();

        lista.add(2);
        lista.add(-4);
        lista.add(-9);
        lista.add(444444);


        System.out.println("=========================================================");
        System.out.print("Valores: "); 
        lista.show();
        System.out.println("Tamanho: "+lista.getLength());
        System.out.println("Tem o valor 2? "+ (lista.hasValue(2) == -1? "Não":"Sim, na posição "+lista.hasValue(2)));
        System.out.println("Qual número temos no idex 2? " + lista.getValue(2));
        System.out.println("Está vazio? "+ (lista.isEmpty()? "Sim":"Não"));

        lista.remove(-9);

        System.out.println("=========================================================");
        System.out.print("Valores: "); 
        lista.show();
        System.out.println("Tamanho: "+lista.getLength());
        System.out.println("Tem o valor -9? "+ (lista.hasValue(-9) == -1? "Não":"Sim, na posição "+lista.hasValue(-9)));
        System.out.println("Qual número temos no idex 2? " + lista.getValue(2));
        System.out.println("Está vazio? "+ (lista.isEmpty()? "Sim":"Não"));

        lista.clear();

        System.out.println("=========================================================");
        System.out.print("Valores: "); 
        lista.show();
        System.out.println("Tamanho: "+lista.getLength());
        System.out.println("Tem o valor 2? "+ (lista.hasValue(2) == -1? "Não":"Sim, na posição "+lista.hasValue(2)));
        System.out.println("Está vazio? "+ (lista.isEmpty()? "Sim":"Não"));


        System.out.println("=========================================================");
    }
}
