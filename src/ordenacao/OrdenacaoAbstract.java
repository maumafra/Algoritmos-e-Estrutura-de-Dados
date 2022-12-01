package ordenacao;

public abstract class OrdenacaoAbstract <T extends Comparable<T>>{

    private T[] info;

    public T[] getInfo(){
        return this.info;
    }

    public void setInfo(T[] array){
        this.info = array;
    }

    public void trocar(int a, int b){
        T value = this.info[a];
        this.info[a] = info[b];
        this.info[b] = value;
    }

    public abstract void ordenar();
    
}
