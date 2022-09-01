package listsPtBr;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class NoListaDupla<GenericClass> {
    private GenericClass info;
    private NoListaDupla<GenericClass> next;
    private NoListaDupla<GenericClass> previous;

    public NoListaDupla(){
        this.setProximo(null);
        this.setAnterior(null);
    }

    public NoListaDupla(GenericClass value){
        this.setInfo(value);
        this.setProximo(null);
        this.setAnterior(null);
    }

    public void setInfo(GenericClass value){
        this.info = value;
    }

    public GenericClass getInfo(){
        return this.info;
    }

    public void setProximo(NoListaDupla<GenericClass> node){
        this.next = node;
    }

    public void setAnterior(NoListaDupla<GenericClass> node){
        this.previous = node;
    }

    public NoListaDupla<GenericClass> getProximo(){
        return this.next;
    }

    public NoListaDupla<GenericClass> getAnterior(){
        return this.previous;
    }

    @Override
    public String toString(){
        return this.info.toString();
    }
}
