package buscas;

public abstract class ArvoreBinariaAbstract <T> {
    
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract(){
        this.raiz = null;
    }

    protected void setRaiz(NoArvoreBinaria<T> novaRaiz){
        this.raiz = novaRaiz;
    }

    public NoArvoreBinaria<T> getRaiz(){
        return this.raiz;
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    public boolean pertence(T value){
        return buscar(value) != null;
    }

    public String toString(){
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> noArvore){
        if(noArvore == null) return "<>";
        return"<"+noArvore.getInfo().toString()+arvorePre(noArvore.getEsquerda())+arvorePre(noArvore.getDireita())+">";
    }

    public int contarNos(){
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> noArvore){
        if(noArvore == null) return 0;
        return contarNos(noArvore.getEsquerda()) + contarNos(noArvore.getDireita()) + 1;
    }
}
