package listsPtBr;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class ListaEncadeada<GenericClass> {
    private NoLista<GenericClass> first;
    private int length;

    public ListaEncadeada(){
        first = null;
        length = 0;
    }

    public int obterComprimento(){
        return this.length;
    }
    
    public void inserir(GenericClass value){
        NoLista<GenericClass> newNode = new NoLista<>(value);
        newNode.setProximo(first);
        this.first = newNode;
        length++;
    }

    public NoLista<GenericClass> buscar(GenericClass value){
        NoLista<GenericClass> next = first;
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
    
    public void exibir(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String text = "{";
        NoLista<GenericClass> next = first;
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
        NoLista<GenericClass> element = first;
        NoLista<GenericClass> previous = null;
        while(element != null && !element.getInfo().equals(value)){
            previous = element;
            element = previous.getProximo();
        }
        if(element == null){
            return;
        }
        if(element == first){
            this.first = first.getProximo();
        } else {
            previous.setProximo(element.getProximo());
        }
        this.length--;
    }

    public NoLista<GenericClass> getPrimeiro(){
        return this.first;
    }

    public NoLista<GenericClass> obterNo (int index){
        if(index >= this.length || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        NoLista<GenericClass> element = first;
        for(int i = 0; i < index; i++){
            element = element.getProximo(); 
        }
        return element;
    }

    /* getElement method without using the length attribute as the question asks */
    public NoLista<GenericClass> obterNoSemTamanho (int index){
        if(index < 0) throw new IndexOutOfBoundsException("Index out of bounds.");
        NoLista<GenericClass> element = first;
        while ((element!=null) && (index > 0)) {
            index--;
            element = element.getProximo();
        }
        if (element == null) throw new IndexOutOfBoundsException("Index out of bounds.");
        return element;
    }
}
