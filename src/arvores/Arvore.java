package arvores;

public class Arvore<T> {
    
    private NoArvore<T> raiz;

    public Arvore(){
        this.raiz = null;
    }

    public void setRaiz(NoArvore<T> raiz){
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz(){
        return this.raiz;
    }

    @Override
    public String toString(){
        return obterRepresentacaoTextual(getRaiz());
    }

    private String obterRepresentacaoTextual(NoArvore<T> no){
        if(no == null) return "";
        String text = "<"+no.getInfo();
        NoArvore<T> p = no.getPrimeiro();
        while(p != null){
            text += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }
        return text+">";
    }

    public boolean pertence(T info){
        if(getRaiz()==null) return false;
        return getRaiz().getInfo() == info || pertence(getRaiz(), info); 
    }

    private boolean pertence(NoArvore<T> no, T info){
        if(no == null) return false;  
        if(no.getInfo() == info) return true;
        NoArvore<T> p = no.getPrimeiro();
        while(p != null){
            if(pertence(p, info)) return true;
            p = p.getProximo();
        }
        return false;
    }

    public int contarNos(){
        return contarNos(getRaiz());
    }

    private int contarNos(NoArvore<T> no){
        if(no == null) return 0;
        NoArvore<T> p = no.getPrimeiro();
        int count = 1;
        while (p != null) {
            count += contarNos(p);
            p = p.getProximo();
        }
        return count;
    }
}
