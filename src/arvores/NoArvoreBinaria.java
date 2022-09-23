package arvores;

public class NoArvoreBinaria <GenericClass> {
    
    private GenericClass info;
    private NoArvoreBinaria<GenericClass> direita;
    private NoArvoreBinaria<GenericClass> esquerda;

    public NoArvoreBinaria(GenericClass value){
        setInfo(value);
    }

    public NoArvoreBinaria(GenericClass value, NoArvoreBinaria<GenericClass> noEsquerda, NoArvoreBinaria<GenericClass> noDireita){
        setInfo(value);
        this.esquerda = noEsquerda;
        this.direita = noDireita;
    }

    public void setInfo(GenericClass value){
        this.info = value;
    }

    public GenericClass getInfo(){
        return this.info;
    }

    public void setEsquerda(NoArvoreBinaria<GenericClass> esq){
        this.esquerda = esq;
    }

    public NoArvoreBinaria<GenericClass> getEsquerda(){
        return this.esquerda;
    }

    public void setDireita(NoArvoreBinaria<GenericClass> dir){
        this.direita = dir;
    }

    public NoArvoreBinaria<GenericClass> getDireita(){
        return this.direita;
    }

}
