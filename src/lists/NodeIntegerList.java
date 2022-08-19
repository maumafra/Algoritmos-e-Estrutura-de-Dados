package lists;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class NodeIntegerList {
    
    private int info;
    private NodeIntegerList next;

    public NodeIntegerList(){
        this.setNextNode(null);
    }

    public NodeIntegerList(int value){
        this.setValue(value);
        this.setNextNode(null);
    }

    public void setValue(int value){
        this.info = value;
    }

    public int getValue(){
        return this.info;
    }

    public void setNextNode(NodeIntegerList node){
        this.next = node;
    }

    public NodeIntegerList getNextNode(){
        return this.next;
    }

    @Override
    public String toString(){
        return this.getValue()+"";
    }
}
