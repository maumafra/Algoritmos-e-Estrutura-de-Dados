package buscas;

public abstract class ListaAbstract <GenericClass>{
    private GenericClass[] info;
    private int tamanho;

    public ListaAbstract() {
        info = (GenericClass[]) new Object[10];
    }

    public ListaAbstract(int size) {
        info = (GenericClass[]) new Object[size];
    }

    abstract void inserir (GenericClass value);

    protected void redimensionar() {
        int newBound = info.length + ((int)(50/info.length) == 0? 1 : (int)(50/info.length));
        GenericClass[] newArray = (GenericClass[]) new Object[newBound];
        for(int i = 0; i < info.length; i++){
            newArray[i] = info[i];
        }
        info = newArray;
    }

    public void liberar() {
        info = (GenericClass[]) new Object[10];
        this.tamanho = 0;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void exibir(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        String text = "{";
        int finalIndex = this.getTamanho();
        for(int i = 0; i < finalIndex; i++){
            if(i == finalIndex-1){
                return text += info[i].toString()+"}";
            }
            text += info[i].toString()+", ";
        }
        return "";
    }

    abstract int buscar(GenericClass value);

    public void retirar(GenericClass value){
        int index = this.buscar(value);
        if(index == -1){
            return;
        }
        this.tamanho--;
        for(int i = index; i < info.length; i++){
            if(i == info.length-1){
                info[i] = null;
                return;
            }
            info[i] = info[i+1];
        }
    }

    public GenericClass obterElemento(int index){
        if(index >= this.getTamanho()){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return info[index];
    }

    public boolean estaVazia(){
        return this.getTamanho() == 0;
    }

    public GenericClass obterUltimoElemento(){
        if(this.getTamanho() < 1){
            return null;
        }
        return this.obterElemento(this.getTamanho()-1);
    }

    public void inverter(){
        int numberOfChanges = (int) this.getTamanho()/2;
        GenericClass element;

        for(int i = 0; i<numberOfChanges;  i++){
            element = this.obterElemento(i);
            this.info[i] = this.obterElemento(this.getTamanho()-1-i);
            this.info[this.getTamanho()-1-i] = element;
        }
    }

    protected GenericClass[] getInfo(){
        return this.info;
    }

    protected void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }
}
