package arvores;

public class ArvoreBinaria <GenericClass> {
    
    private NoArvoreBinaria<GenericClass> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<GenericClass> novaRaiz){
        this.raiz = novaRaiz;
    }

    public boolean estaVazia(){
        return raiz == null;
    }

    public boolean pertence(GenericClass value){
        if(estaVazia()) return false;
        return (this.raiz.getInfo() == value || this.pertence(raiz, value));
    }

    private boolean pertence (NoArvoreBinaria<GenericClass> no ,GenericClass value){
        if(no == null) return false;
        return (no.getInfo() == value || pertence(no.getEsquerda(), value) || pertence(no.getDireita(), value));
    }

    public String toString(){
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<GenericClass> noArvore){
        if(noArvore == null) return "<>";
        return"<"+noArvore.getInfo().toString()+arvorePre(noArvore.getEsquerda())+arvorePre(noArvore.getDireita())+">";
    }

    public int contarNos(){
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<GenericClass> noArvore){
        if(noArvore == null) return 0;
        return contarNos(noArvore.getEsquerda()) + contarNos(noArvore.getDireita()) + 1;
    }
}
