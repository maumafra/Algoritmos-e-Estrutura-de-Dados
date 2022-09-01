package tests;

import lists.StaticList;
import listsPtBr.ListaEncadeada;
import lists.DynamicIntegerList;
import lists.DynamicList;
import lists.StaticIntegerList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testStaticListInvert(){
        StaticList<String> list = new StaticList<>();

        list.add("001");
        list.add("002");
        list.add("003");
        list.add("004");
        list.add("005");
        list.add("006");
        list.add("007");

        list.show();

        list.reverse();

        list.show();

        assertEquals("001", list.getLastElement());
        assertEquals("004", list.getValue(3));
        assertEquals("003", list.getValue(4));
    }

    @Test
    public void testStaticListLenght(){
        StaticList<String> list = new StaticList<>();

        for(int i = 0; i<100; i++){
            list.add(""+i);
        }

        list.show();
        assertEquals("99", list.getLastElement());
    }

    @Test
    public void testDynamicIntegerListPutRemove(){
        DynamicIntegerList list = new DynamicIntegerList();

        list.put(3);
        assertEquals(3, list.getFirst().getValue());
        list.put(5);
        assertEquals(5, list.getFirst().getValue());
        list.put(7);
        assertEquals(7, list.getFirst().getValue());

        list.show();

        assertEquals(list.getElement(3), list.getElementByIndex(2));
        assertEquals(list.getElement(5), list.getElementByIndex(1));
        assertEquals(list.getElement(7), list.getElementByIndex(0));

        assertEquals(false, list.isEmpty());
        assertEquals(3, list.getLength());

        list.remove(9);
        assertEquals(3, list.getLength());

        list.remove(7);
        assertEquals(list.getElement(5), list.getElementByIndex(0));
        assertEquals(2, list.getLength());
        assertEquals(5, list.getFirst().getValue());

        list.remove(3);
        list.remove(5);
        assertEquals(true, list.isEmpty());
        assertEquals(null, list.getFirst());
        assertEquals(0, list.getLength());

        list.show();
    }

    @Test
    public void testDynamicListPutRemoveIntegers(){
        DynamicList<Integer> list = new DynamicList<>();

        list.put(3);
        assertEquals(3, list.getFirst().getValue());
        list.put(5);
        assertEquals(5, list.getFirst().getValue());
        list.put(7);
        assertEquals(7, list.getFirst().getValue());

        list.show();

        assertEquals(list.getElement(3), list.getElementByIndex(2));
        assertEquals(list.getElement(5), list.getElementByIndex(1));
        assertEquals(list.getElement(7), list.getElementByIndex(0));

        assertEquals(false, list.isEmpty());
        assertEquals(3, list.getLength());

        list.remove(9);
        assertEquals(3, list.getLength());

        list.remove(7);
        assertEquals(list.getElement(5), list.getElementByIndex(0));
        assertEquals(2, list.getLength());
        assertEquals(5, list.getFirst().getValue());

        list.remove(3);
        list.remove(5);
        assertEquals(true, list.isEmpty());
        assertEquals(null, list.getFirst());
        assertEquals(0, list.getLength());

        list.show();
    }

    @Test
    public void testDynamicListPutRemoveStrings(){
        DynamicList<String> list = new DynamicList<>();

        list.put("OLAAAAA");
        assertEquals("OLAAAAA", list.getFirst().getValue());
        list.put("TESTE");
        assertEquals("TESTE", list.getFirst().getValue());
        list.put("VASCO");
        assertEquals("VASCO", list.getFirst().getValue());

        list.show();

        assertEquals(list.getElement("OLAAAAA"), list.getElementByIndex(2));
        assertEquals(list.getElement("TESTE"), list.getElementByIndex(1));
        assertEquals(list.getElement("VASCO"), list.getElementByIndex(0));

        assertEquals(false, list.isEmpty());
        assertEquals(3, list.getLength());
        assertEquals(null, list.getElement("OL"));
        list.remove("9");
        assertEquals(3, list.getLength());

        list.remove("VASCO");
        assertEquals(null, list.getElement("VASCO"));
        assertEquals(list.getElement("TESTE"), list.getElementByIndex(0));
        assertEquals(2, list.getLength());
        assertEquals("TESTE", list.getFirst().getValue());
        list.show();
        list.remove("OLAAAAA");
        list.show();
        list.remove("TESTE");
        assertEquals(true, list.isEmpty());
        assertEquals(null, list.getFirst());
        assertEquals(0, list.getLength());
        assertThrows(IndexOutOfBoundsException.class, () -> list.getElementByIndex(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getElementByIndex(10));
        list.show();
    }

    @Test
    public void testListaEncadeadaPutRemoveStrings(){
        ListaEncadeada<String> list = new ListaEncadeada<>();

        list.inserir("OLAAAAA");
        assertEquals("OLAAAAA", list.getPrimeiro().getInfo());
        list.inserir("TESTE");
        assertEquals("TESTE", list.getPrimeiro().getInfo());
        list.inserir("VASCO");
        assertEquals("VASCO", list.getPrimeiro().getInfo());

        list.exibir();

        assertEquals(list.buscar("OLAAAAA"), list.obterNo(2));
        assertEquals(list.buscar("TESTE"), list.obterNo(1));
        assertEquals(list.buscar("VASCO"), list.obterNo(0));

        assertEquals(false, list.estaVazia());
        assertEquals(3, list.obterComprimento());
        assertEquals(null, list.buscar("OL"));
        list.retirar("9");
        assertEquals(3, list.obterComprimento());

        list.retirar("VASCO");
        assertEquals(null, list.buscar("VASCO"));
        assertEquals(list.buscar("TESTE"), list.obterNo(0));
        assertEquals(2, list.obterComprimento());
        assertEquals("TESTE", list.getPrimeiro().getInfo());
        list.exibir();
        list.retirar("OLAAAAA");
        list.exibir();
        list.retirar("TESTE");
        assertEquals(true, list.estaVazia());
        assertEquals(null, list.getPrimeiro());
        assertEquals(0, list.obterComprimento());
        assertThrows(IndexOutOfBoundsException.class, () -> list.obterNo(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.obterNo(10));
        list.exibir();
    }
}
