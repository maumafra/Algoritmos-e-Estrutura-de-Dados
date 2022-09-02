package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import lists.DynamicLinkedList;
import lists.NodeLinkedList;
import listsPtBr.ListaDupla;
import listsPtBr.ListaEncadeada;
import listsPtBr.NoListaDupla;

public class TestsList4 {
    @Test
    public void testLinkedListPut(){
        DynamicLinkedList<String> lista = new DynamicLinkedList<>();

        lista.put("Oi");
        assertEquals("Oi", lista.getFirst().getValue());
    }

    @Test
    public void testLinkedListClear(){
        DynamicLinkedList<Integer> lista = new DynamicLinkedList<>();

        lista.put(5);
        lista.put(10);
        lista.put(15);
        lista.put(20);

        NodeLinkedList<Integer> node5 = lista.getElement(5);
        NodeLinkedList<Integer> node10 = lista.getElement(10);
        NodeLinkedList<Integer> node15 = lista.getElement(15);
        NodeLinkedList<Integer> node20 = lista.getElement(20);

        lista.clear();

        assertEquals(null, node5.getNextNode());
        assertEquals(null, node5.getPreviousNode());

        assertEquals(null, node10.getNextNode());
        assertEquals(null, node10.getPreviousNode());

        assertEquals(null, node15.getNextNode());
        assertEquals(null, node15.getPreviousNode());

        assertEquals(null, node20.getNextNode());
        assertEquals(null, node20.getPreviousNode());
    }

    @Test
    public void testListaDuplaPut(){
        ListaDupla<String> lista = new ListaDupla<>();

        lista.inserir("Oi");
        assertEquals("Oi", lista.getPrimeiro().getInfo());
    }

    @Test
    public void testListaDuplaClear(){
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> node5 = lista.buscar(5);
        NoListaDupla<Integer> node10 = lista.buscar(10);
        NoListaDupla<Integer> node15 = lista.buscar(15);
        NoListaDupla<Integer> node20 = lista.buscar(20);

        assertEquals("{20, 15, 10, 5}", lista.toString());

        lista.liberar();

        assertEquals(null, node5.getProximo());
        assertEquals(null, node5.getAnterior());

        assertEquals(null, node10.getProximo());
        assertEquals(null, node10.getAnterior());

        assertEquals(null, node15.getProximo());
        assertEquals(null, node15.getAnterior());

        assertEquals(null, node20.getProximo());
        assertEquals(null, node20.getAnterior());
    }

    @Test
    public void testForEach(){
        DynamicLinkedList<Integer> lista = new DynamicLinkedList<>();

        lista.put(5);
        lista.put(10);
        lista.put(15);
        lista.put(20);

        int soma = 0;
        for(Integer i:lista){
            soma += i;
        }

        assertEquals(50, soma);
    }

    @Test
    public void teste(){
        ListaEncadeada<Integer> numeros = new ListaEncadeada<>();

        numeros.inserir(70);
numeros.inserir(60);
numeros.inserir(50);
numeros.inserir(40);
numeros.inserir(30);
numeros.inserir(20);
numeros.inserir(10);

ListaEncadeada<Integer> novaLista;
novaLista = numeros.criarSubLista(2,5);
System.out.println(novaLista.toString());
    }
}
