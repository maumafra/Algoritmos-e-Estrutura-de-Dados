package buscas;

public class NoArvoreBinaria <T> {
 
    private T info;
    private NoArvoreBinaria<T> direita;
    private NoArvoreBinaria<T> esquerda;

    public NoArvoreBinaria(T value){
        setInfo(value);
    }

    public NoArvoreBinaria(T value, NoArvoreBinaria<T> noEsquerda, NoArvoreBinaria<T> noDireita){
        setInfo(value);
        this.esquerda = noEsquerda;
        this.direita = noDireita;
    }

    public void setInfo(T value){
        this.info = value;
    }

    public T getInfo(){
        return this.info;
    }

    public void setEsquerda(NoArvoreBinaria<T> esq){
        this.esquerda = esq;
    }

    public NoArvoreBinaria<T> getEsquerda(){
        return this.esquerda;
    }

    public void setDireita(NoArvoreBinaria<T> dir){
        this.direita = dir;
    }

    public NoArvoreBinaria<T> getDireita(){
        return this.direita;
    }

}
