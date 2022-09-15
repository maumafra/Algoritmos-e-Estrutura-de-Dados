package pilhas;

public class PilhaVetor <T> implements Pilha<T>{

    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite){
        this.limite = limite;
        this.info = (T[]) new Object[limite];
    }

    @Override
    public void push(T valor) {
        if(tamanho == limite) throw new PilhaCheiaException();
        this.info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public T pop() {
        T valor = peek();
        tamanho--;
        info[tamanho] = null;
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia()) throw new PilhaVaziaException();
        return this.info[tamanho -1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
    }

    public String toString(){
        String text = "";
        for (int i = tamanho -1; i >= 0; i--){
            text += info[i].toString();
            if(i>0)text += ",";
        }
        return text;
    }

    public void concatenar(PilhaVetor<T> p){
        for(int i = 0; i<p.tamanho; i++){
            this.push(p.info[i]);
        }
    }
    
}
