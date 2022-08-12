package tests;

import lists.StaticList;
import lists.StaticIntegerList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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

    @Test
    public void testListsLength(){
        StaticIntegerList lista = new StaticIntegerList();

        lista.add(2);
        lista.add(-4);
        lista.add(-9);
        lista.add(444444);
        assertEquals(4, lista.getLength());
    }

    @Test
    public void testStaticListGetValue(){
        StaticList<String> list = new StaticList<>();

        list.add("TESTE");
        list.add("TESTE2");

        assertEquals("TESTE2", list.getValue(1));
    }

    @Test
    public void testStaticListHasValue(){
        StaticList<String> list = new StaticList<>();

        list.add("TESTE");
        list.add("TESTE2");

        String test = "TESTE2";

        list.show();

        assertEquals(1, list.hasValue(test));
    }
}
