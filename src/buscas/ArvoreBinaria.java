package buscas;

public class ArvoreBinaria <T> extends ArvoreBinariaAbstract<T> {

    public void setRaiz(NoArvoreBinaria<T> raiz){
        super.setRaiz(raiz);
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }
    
    private NoArvoreBinaria<T> buscar (NoArvoreBinaria<T> no, T info){
        if(no == null) return null;
        if(no.getInfo().equals(info)) return no;
        if(buscar(no.getEsquerda(), info) != null) return no.getEsquerda();
        if(buscar(no.getDireita(), info) != null) return no.getDireita();
        return null; 
    }
}
