package lists;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class NodeLinkedList<GenericClass> {
    private GenericClass info;
    private NodeLinkedList<GenericClass> next;
    private NodeLinkedList<GenericClass> previous;

    public NodeLinkedList(){
        this.setNextNode(null);
        this.setPreviousNode(null);
    }

    public NodeLinkedList(GenericClass value){
        this.setValue(value);
        this.setNextNode(null);
        this.setPreviousNode(null);
    }

    public void setValue(GenericClass value){
        this.info = value;
    }

    public GenericClass getValue(){
        return this.info;
    }

    public void setNextNode(NodeLinkedList<GenericClass> node){
        this.next = node;
    }

    public void setPreviousNode(NodeLinkedList<GenericClass> node){
        this.previous = node;
    }

    public NodeLinkedList<GenericClass> getNextNode(){
        return this.next;
    }

    public NodeLinkedList<GenericClass> getPreviousNode(){
        return this.previous;
    }

    @Override
    public String toString(){
        return this.info.toString();
    }
}
