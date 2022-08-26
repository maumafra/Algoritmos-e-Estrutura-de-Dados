package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import lists.DynamicLinkedList;
import lists.NodeLinkedList;

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
}
