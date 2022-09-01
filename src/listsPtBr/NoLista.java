package listsPtBr;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class NoLista<GenericClass>  {
    private GenericClass info;
    private NoLista<GenericClass> next;

    public NoLista(){
        this.setProximo(null);
    }

    public NoLista(GenericClass value){
        this.setInfo(value);
        this.setProximo(null);
    }

    public void setInfo(GenericClass value){
        this.info = value;
    }

    public GenericClass getInfo(){
        return this.info;
    }

    public void setProximo(NoLista<GenericClass> node){
        this.next = node;
    }

    public NoLista<GenericClass> getProximo(){
        return this.next;
    }

    @Override
    public String toString(){
        return this.info.toString();
    }
}
