package arvores;

public class NoArvore<T> {
    
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;
    private T info;

    public NoArvore(T info){
        this.info = info;
    }

    public void inserirFilho(NoArvore<T> sa){
        if(getPrimeiro() == null) {
            this.primeiro = sa;
            return;
        }
        sa.proximo = getPrimeiro();
        this.primeiro = sa;
    }

    public NoArvore<T> getPrimeiro(){
        return this.primeiro;
    }

    public NoArvore<T> getProximo(){
        return this.proximo;
    }

    public T getInfo(){
        return this.info;
    }

    public void setInfo(T info){
        this.info = info;
    }
}
