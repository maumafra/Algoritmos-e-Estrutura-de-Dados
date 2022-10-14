package buscas;

public class ListaEstatica<T> extends ListaAbstract<T>{

    @Override
    public void inserir(T value) {
        T[] infoAux = getInfo();
        if(infoAux.length == getTamanho()){
            this.redimensionar();
        }
        infoAux[getTamanho()] = value;
        setTamanho(getTamanho()+1);
    }

    @Override
    public int buscar(T value) {
        T[] infoAux = getInfo();
        for(int i = 0; i < infoAux.length; i++){
            if(infoAux[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
}
