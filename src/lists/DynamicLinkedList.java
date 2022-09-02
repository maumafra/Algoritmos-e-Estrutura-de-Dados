package lists;

import java.util.Iterator;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class DynamicLinkedList<GenericClass> implements Iterable<GenericClass>{
    private NodeLinkedList<GenericClass> first;
    private int length;

    public DynamicLinkedList(){
        first = null;
        length = 0;
    }

    public int getLength(){
        return this.length;
    }
    
    public void put(GenericClass value){
        NodeLinkedList<GenericClass> newNode = new NodeLinkedList<>(value);
        newNode.setNextNode(first);
        if (first != null)first.setPreviousNode(newNode);
        this.first = newNode;
        length++;
    }

    public NodeLinkedList<GenericClass> getElement(GenericClass value){
        NodeLinkedList<GenericClass> next = first;
        while(next!=null){
            if(next.getValue().equals(value)){
                return next;
            }
            next = next.getNextNode();
        }
        return null;
    }

    public boolean isEmpty(){
        return this.first == null;
    }
    
    public void show(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String text = "{";
        NodeLinkedList<GenericClass> next = first;
        while(next!=null){
            if(next.getNextNode() == null){
                return text += next.toString()+"}";
            }
            text+=next.toString()+", ";
            next = next.getNextNode();
        }
        return text+"}";
    }

    public void remove (GenericClass value){
        NodeLinkedList<GenericClass> element = getElement(value);

        if(element == null) return;
        
        if(element == first){
            this.first = first.getNextNode();
        } else {
            element.getPreviousNode().setNextNode(element.getNextNode());
        }

        if(element.getNextNode() == null) return;

        element.getNextNode().setPreviousNode(element.getPreviousNode());

        this.length--;
    }

    public NodeLinkedList<GenericClass> getFirst(){
        return this.first;
    }

    public NodeLinkedList<GenericClass> getElementByIndex(int index){
        if(index >= this.length || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        NodeLinkedList<GenericClass> element = first;
        for(int i = 0; i < index; i++){
            element = element.getNextNode(); 
        }
        return element;
    }

    /* getElement method without using the length attribute as the question asks */
    public NodeLinkedList<GenericClass> getElementByIndexWithoutLength(int index){
        if(index < 0) throw new IndexOutOfBoundsException("Index out of bounds.");
        NodeLinkedList<GenericClass> element = first;
        while ((element!=null) && (index > 0)) {
            index--;
            element = element.getNextNode();
        }
        if (element == null) throw new IndexOutOfBoundsException("Index out of bounds.");
        return element;
    }

    public void clear (){
        NodeLinkedList<GenericClass> element = first;
        while( element != null ){
            element.setPreviousNode(null);
            element = element.getNextNode();
            if(element != null) element.getPreviousNode().setNextNode(null);
        }
    }

    @Override
    public Iterator<GenericClass> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<GenericClass>{
        private NodeLinkedList<GenericClass> element = first;

        @Override
        public boolean hasNext() {
            return element.getNextNode()!=null;
        }

        @Override
        public GenericClass next() {
            element = element.getNextNode();
            return element.getNextNode() != null ? element.getNextNode().getValue():null;
        }  
    }
}
