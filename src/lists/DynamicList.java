package lists;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class DynamicList<GenericClass> {
    private NodeList<GenericClass> first;
    private int length;

    public DynamicList(){
        first = null;
        length = 0;
    }

    public int getLength(){
        return this.length;
    }
    
    public void put(GenericClass value){
        NodeList<GenericClass> newNode = new NodeList<>(value);
        newNode.setNextNode(first);
        this.first = newNode;
        length++;
    }

    public NodeList<GenericClass> getElement(GenericClass value){
        NodeList<GenericClass> next = first;
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
        NodeList<GenericClass> next = first;
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
        NodeList<GenericClass> element = first;
        NodeList<GenericClass> previous = null;
        while(element != null && !element.getValue().equals(value)){
            previous = element;
            element = previous.getNextNode();
        }
        if(element == null){
            return;
        }
        if(element == first){
            this.first = first.getNextNode();
        } else {
            previous.setNextNode(element.getNextNode());
        }
        this.length--;
    }

    public NodeList<GenericClass> getFirst(){
        return this.first;
    }

    public NodeList<GenericClass> getElementByIndex(int index){
        if(index >= this.length || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        NodeList<GenericClass> element = first;
        for(int i = 0; i < index; i++){
            element = element.getNextNode(); 
        }
        return element;
    }

    /* getElement method without using the length attribute as the question asks */
    public NodeList<GenericClass> getElementByIndexWithoutLength(int index){
        if(index < 0) throw new IndexOutOfBoundsException("Index out of bounds.");
        NodeList<GenericClass> element = first;
        while ((element!=null) && (index > 0)) {
            index--;
            element = element.getNextNode();
        }
        if (element == null) throw new IndexOutOfBoundsException("Index out of bounds.");
        return element;
    }
}
