package lists;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class DynamicIntegerList{

    private NodeIntegerList first;
    private int length;

    public DynamicIntegerList(){
        first = null;
        length = 0;
    }

    public int getLength(){
        return this.length;
    }
    
    public void put(int value){
        NodeIntegerList newNode = new NodeIntegerList(value);
        newNode.setNextNode(first);
        this.first = newNode;
        length++;
    }

    public NodeIntegerList getElement(int value){
        NodeIntegerList next = first;
        while(next!=null){
            if(next.getValue() == value){
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
        NodeIntegerList next = first;
        while(next!=null){
            if(next.getNextNode() == null){
                return text += next.toString()+"}";
            }
            text+=next.toString()+", ";
            next = next.getNextNode();
        }
        return text+"}";
    }

    public void remove (int value){
        NodeIntegerList element = first;
        NodeIntegerList prior = null;
        while(element != null && element.getValue() != value){
            prior = element;
            element = prior.getNextNode();
        }
        if(element == null){
            return;
        }
        if(element == first){
            this.first = first.getNextNode();
        } else {
            prior.setNextNode(element.getNextNode());
        }
        this.length--;
    }

    public NodeIntegerList getFirst(){
        return this.first;
    }

    public NodeIntegerList getElementByIndex(int index){
        if(index >= this.length  || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        NodeIntegerList element = first;
        for(int i = 0; i < index; i++){
            element = element.getNextNode(); 
        }
        return element;
    }
}