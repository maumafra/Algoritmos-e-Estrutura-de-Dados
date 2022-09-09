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
        this.info[limite -1 - tamanho] = valor;
        tamanho++;
    }

    @Override
    public T pop() {
        if(tamanho == 0) throw new PilhaVaziaException();
        tamanho--;
        return this.info[limite -1 -tamanho];
    }

    @Override
    public T peek() {
        if(tamanho == 0) throw new PilhaVaziaException();
        return this.info[limite -tamanho];
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
        for (int i = 0; i < tamanho; i++){
            if(i != 0) text = ","+text;
            text = info[limite - 1 -i].toString()+text;
        }
        return text;
    }

    public void concatenar(PilhaVetor<T> p){
        if(this.limite < this.tamanho + p.tamanho) throw new RuntimeException();

        T[] aux = (T[]) new Object[p.tamanho];
        int outroTamanho = p.tamanho;

        for(int i = 0; i < outroTamanho; i++){
            aux[outroTamanho - 1 -i] = p.pop();
        }
        for(int i = 0; i < outroTamanho; i++){
            this.push(aux[i]);
            p.push(aux[i]);
        }
    }
    
}
