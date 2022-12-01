package mapaDispersao;

public class NoMapa<T> {

    private int chave;
    private T info;

    public int getChave(){
        return this.chave;
    }

    public void setChave(int value){
        this.chave = value;
    }

    public T getInfo(){
        return this.info;
    }

    public void setInfo(T value){
        this.info = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        NoMapa<T> outro = (NoMapa<T>) obj;
        if(chave != outro.getChave()) return false;
        return true;
    }
    
}
