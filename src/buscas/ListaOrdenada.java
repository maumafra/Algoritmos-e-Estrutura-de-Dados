package buscas;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T>{

    @Override
    public void inserir(T value) {
        T[] infoAux = getInfo();
        if(infoAux.length == getTamanho()){
            this.redimensionar();
        }
        T aux1 = value;
        T aux2 = null;
        setTamanho(getTamanho()+1);
        for(int i = 0; i < getTamanho(); i++){
            int compareValue = value.compareTo(infoAux[i]);
            if(compareValue <= 0){
                aux2 = infoAux[i];
                infoAux[i] = aux1;
                aux1 = aux2;
            }
        }
    }

    @Override
    public int buscar(T value) {
        int tam = getInfo().length;
        int inicio = 0;
        int fim = tam - 1;
        T[] infoAux = getInfo();
        while(inicio <= fim){
            int meio = (inicio + fim)/2;
            int compareValue = value.compareTo(infoAux[meio]);
            if(compareValue < 0) fim = meio-1;
            else {
                if(compareValue > 0) inicio = meio + 1;
                else return meio;
            }
        }
        return -1;
    }
    
}
