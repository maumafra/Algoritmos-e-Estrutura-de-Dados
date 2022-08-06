package listsPtBr;

/*
 * 
 * autor: Maurício Mafra Monnerat
 */

public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new int[10];
    }

    public ListaEstatica(int size) {
        info = new int[size];
    }

    public void inserir (int value) {
        if(info.length == this.getTamanho()){
            this.redimensionar();
        }
        info[tamanho] = value;
        this.tamanho++;
    }

    public void redimensionar() {
        int newBound = info.length + ((int)(info.length/2) == 0? 1 : (int)(info.length/2));
        int[] newArray = new int[newBound];
        for(int i = 0; i < info.length; i++){
            newArray[i] = info[i];
        }
        info = newArray;
    }

    public void liberar() {
        info = new int[10];
        this.tamanho = 0;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void exibir(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String text = "{";
        for(int i = 0; i < this.getTamanho(); i++){
            if(i == this.getTamanho()-1){
                return text += info[i]+"}";
            }
            text += info[i]+", ";
        }
        return "";
    }

    public int buscar(int value){
        for(int i = 0; i < info.length; i++){
            if(info[i] == value){
                return i;
            }
        }
        return -1;
    }

    public void retirar(int value){
        int index = this.buscar(value);
        if(index == -1){
            return;
        }
        this.tamanho--;
        for(int i = index; i < info.length; i++){
            if(i == info.length-1){
                info[i] = 0;
                return;
            }
            info[i] = info[i+1];
        }
    }

    public int obterElemento(int index){
        if(index >= this.getTamanho()){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return info[index];
    }

    public boolean estaVazia(){
        return this.getTamanho() == 0;
    }
}
