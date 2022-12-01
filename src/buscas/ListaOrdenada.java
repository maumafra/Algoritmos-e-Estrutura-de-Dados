package buscas;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T>{

    @Override
    public void inserir(T value) {
        Object[] infoAux = getInfo();
        int tamanho = getTamanho();
        if(infoAux.length == tamanho){
            this.redimensionar();
            infoAux = getInfo();
        }
        T aux1 = value;
        T aux2 = null;
        tamanho++;
        
        for(int i = 0; i < tamanho; i++){
            if(infoAux[i] == null){
                infoAux[i] = aux1;
                break;
            }
            int compareValue = value.compareTo((T) infoAux[i]);
            if(compareValue <= 0){
                aux2 = (T) infoAux[i];
                infoAux[i] = aux1;
                aux1 = aux2;
            }
        }
        setTamanho(tamanho);
    }

    @Override
    public int buscar(T value) {
        Object[] infoAux = getInfo();
        int tam = getTamanho();
        int inicio = 0;
        int fim = tam - 1;
        while(inicio <= fim){
            int meio = (inicio + fim)/2;
            int compareValue = value.compareTo((T) infoAux[meio]);
            if(compareValue < 0) fim = meio-1;
            else {
                if(compareValue > 0) inicio = meio + 1;
                else return meio;
            }
        }
        return -1;
    }
    
}
