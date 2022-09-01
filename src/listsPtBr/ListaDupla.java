package listsPtBr;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class ListaDupla<GenericClass> {
    private NoListaDupla<GenericClass> first;
    private int length;

    public ListaDupla(){
        first = null;
        length = 0;
    }

    public int getTamanho(){
        return this.length;
    }
    
    public void inserir(GenericClass value){
        NoListaDupla<GenericClass> newNode = new NoListaDupla<>(value);
        newNode.setProximo(first);
        if (first != null)first.setAnterior(newNode);
        this.first = newNode;
        length++;
    }

    public NoListaDupla<GenericClass> buscar(GenericClass value){
        NoListaDupla<GenericClass> next = first;
        while(next!=null){
            if(next.getInfo().equals(value)){
                return next;
            }
            next = next.getProximo();
        }
        return null;
    }

    public boolean estaVazia(){
        return this.first == null;
    }
    
    public void show(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String text = "{";
        NoListaDupla<GenericClass> next = first;
        while(next!=null){
            if(next.getProximo() == null){
                return text += next.toString()+"}";
            }
            text+=next.toString()+", ";
            next = next.getProximo();
        }
        return text+"}";
    }

    public void retirar (GenericClass value){
        NoListaDupla<GenericClass> element = buscar(value);

        if(element == null) return;
        
        if(element == first){
            this.first = first.getProximo();
        } else {
            element.getAnterior().setProximo(element.getProximo());
        }

        if(element.getProximo() == null) return;

        element.getProximo().setAnterior(element.getAnterior());

        this.length--;
    }

    public NoListaDupla<GenericClass> getPrimeiro(){
        return this.first;
    }

    public NoListaDupla<GenericClass> getElementByIndex(int index){
        if(index >= this.length || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        NoListaDupla<GenericClass> element = first;
        for(int i = 0; i < index; i++){
            element = element.getProximo(); 
        }
        return element;
    }

    /* getElement method without using the length attribute as the question asks */
    public NoListaDupla<GenericClass> getElementByIndexWithoutLength(int index){
        if(index < 0) throw new IndexOutOfBoundsException("Index out of bounds.");
        NoListaDupla<GenericClass> element = first;
        while ((element!=null) && (index > 0)) {
            index--;
            element = element.getProximo();
        }
        if (element == null) throw new IndexOutOfBoundsException("Index out of bounds.");
        return element;
    }

    public void liberar (){
        NoListaDupla<GenericClass> element = first;
        while( element != null ){
            element.setAnterior(null);
            element = element.getProximo();
            if(element != null) element.getAnterior().setProximo(null);
        }
    }
}
