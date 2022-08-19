package listsPtBr;

/*
 * 
 * author: Maurício Mafra Monnerat
 */

public class ListaEstaticaGenerica <GenericClass> {
    private GenericClass[] info;
    private int length;

    public ListaEstaticaGenerica() {
        info = (GenericClass[]) new Object[10];
    }

    public ListaEstaticaGenerica(int size) {
        info = (GenericClass[]) new Object[size];
    }

    public void inserir (GenericClass value) {
        if(info.length == this.getTamanho()){
            this.redimensionar();
        }
        info[length] = value;
        this.length++;
    }

    public void redimensionar() {
        int newBound = info.length + ((int)(50/info.length) == 0? 1 : (int)(50/info.length));
        GenericClass[] newArray = (GenericClass[]) new Object[newBound];
        for(int i = 0; i < info.length; i++){
            newArray[i] = info[i];
        }
        info = newArray;
    }

    public void liberar() {
        info = (GenericClass[]) new Object[10];
        this.length = 0;
    }

    public int getTamanho(){
        return this.length;
    }

    public void exibir(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String text = "{";
        for(int i = 0; i < this.getTamanho(); i++){
            if(i == this.getTamanho()-1){
                return text += info[i].toString()+"}";
            }
            text += info[i].toString()+", ";
        }
        return "";
    }

    public int buscar(GenericClass value){
        for(int i = 0; i < info.length; i++){
            if(info[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public void retirar(GenericClass value){
        int index = this.buscar(value);
        if(index == -1){
            return;
        }
        this.length--;
        for(int i = index; i < info.length; i++){
            if(i == info.length-1){
                info[i] = null;
                return;
            }
            info[i] = info[i+1];
        }
    }

    public GenericClass obterElemento(int index){
        if(index >= this.getTamanho()){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return info[index];
    }

    public boolean estaVazia(){
        return this.getTamanho() == 0;
    }

    public GenericClass obterUltimoElemento(){
        if(this.getTamanho() < 1){
            return null;
        }
        return this.obterElemento(this.getTamanho()-1);
    }

    public void inverter(){
        int numberOfChanges = (int) this.getTamanho()/2;
        GenericClass element;

        for(int i = 0; i<numberOfChanges;  i++){
            element = this.obterElemento(i);
            this.info[i] = this.obterElemento(this.getTamanho()-1-i);
            this.info[this.getTamanho()-1-i] = element;
        }
    }
}
