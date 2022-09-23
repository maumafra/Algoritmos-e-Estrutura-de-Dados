package filas;

public class FilaVetor<T> implements Fila<T>{

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite){
        this.limite = limite;
        tamanho = 0;
        inicio = 0;
        info = (T[])new Object[limite];
    }

    @Override
    public void inserir(T valor) {
        if(tamanho == limite) throw new FilaCheiaException();
        int posInserir = (inicio + tamanho)%limite;
        info[posInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho==0;
    }

    @Override
    public T peek() {
        if(estaVazia()) throw new FilaVaziaException();
        return info[inicio];
    }

    @Override
    public T retirar() {
        T valor = peek();
        tamanho--;
        info[inicio] = null;
        inicio = (inicio + 1)%limite;
        return valor;
    }

    @Override
    public void liberar() {
        tamanho = 0;
        info = (T[])new Object[limite];
    }

    public FilaVetor<T> criarFilaConcatenada (FilaVetor<T> fila2){
        FilaVetor<T> fila3 = new FilaVetor<>(limite + fila2.limite);
        int auxInicio = inicio;
        
        for(int i = 0; i < tamanho; i++){
            fila3.inserir(info[auxInicio]);
            auxInicio = (auxInicio + 1)%limite;
        }

        auxInicio = fila2.inicio;

        for(int i = 0; i < fila2.tamanho; i++){
            fila3.inserir(fila2.info[auxInicio]);
            auxInicio = (auxInicio + 1)%fila2.limite;
        }

        return fila3;
    }

    @Override
    public String toString(){
        String text = "";
        int auxInicio = inicio;

        for(int i = tamanho - 1; i >= 0; i--){
            text += info[auxInicio];
            if(i>0) text += ",";
            auxInicio = (auxInicio + 1)%limite;
        }
        return text;
    }

    public int getLimite(){
        return this.limite;
    }
    
}
