package lists;

public class NodeList<GenericClass> {
    private GenericClass info;
    private NodeList<GenericClass> next;

    public NodeList(){
        this.setNextNode(null);
    }

    public NodeList(GenericClass value){
        this.setValue(value);
        this.setNextNode(null);
    }

    public void setValue(GenericClass value){
        this.info = value;
    }

    public GenericClass getValue(){
        return this.info;
    }

    public void setNextNode(NodeList<GenericClass> node){
        this.next = node;
    }

    public NodeList<GenericClass> getNextNode(){
        return this.next;
    }

    @Override
    public String toString(){
        return this.info.toString();
    }
}
