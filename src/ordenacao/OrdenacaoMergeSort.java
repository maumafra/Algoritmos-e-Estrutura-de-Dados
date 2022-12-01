package ordenacao;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int n = getInfo().length-1;
        mergeSort(0, n);
    }

    private void mergeSort(int inicio, int fim){
        if(inicio < fim){
            int meio = Math.round((inicio+fim)/2);
            mergeSort(inicio, meio);
            mergeSort(meio+1, fim);
            merge(inicio, fim, meio);
        }
    }

    private void merge(int inicio, int fim, int meio){
        int tamEsquerda = meio-inicio+1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for(int i = 0; i < tamEsquerda; i++){
            esquerda[i] = getInfo()[inicio + i]; //Popula o primeiro vetor
        }
        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for(int i = 0; i < tamDireita; i++){
            direita[i] = getInfo()[meio+1+i]; //Popula o segundo vetor
        }
        int cEsq = 0;
        int cDir = 0;
        int i;
        for(i = inicio; i <= fim; i++){
            if(cEsq < tamEsquerda && cDir < tamDireita){
                if(esquerda[cEsq].compareTo(direita[cDir]) < 0){
                    getInfo()[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    getInfo()[i] = direita[cDir];
                    cDir++;
                }
            } else {
                break;
            }
        }
        while(cEsq < tamEsquerda){
            getInfo()[i] = esquerda[cEsq];
            cEsq++;
            i++;
        }
        while(cDir < tamDireita){
            getInfo()[i] = direita[cDir];
            cDir++;
            i++;
        }
    }
}
