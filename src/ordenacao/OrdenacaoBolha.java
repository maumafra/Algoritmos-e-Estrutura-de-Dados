package ordenacao;

public class OrdenacaoBolha <T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    @Override
    public void ordenar() {
        int i,j;
        int n = getInfo().length;
        for(i = n-1; i > 0; i--){
            for(j = 0; j <= i-1; j++){
                int compareValue = getInfo()[j].compareTo(getInfo()[j+1]);
                if(compareValue>0){
                    trocar(j, j+1);
                }
            }
        }
    }

    public void ordenarDecrescente(){
        int i,j;
        int n = getInfo().length;
        for(i = n-1; i > 0; i--){
            for(j = 0; j <= i-1; j++){
                int compareValue = getInfo()[j].compareTo(getInfo()[j+1]);
                if(compareValue<0){
                    trocar(j, j+1);
                }
            }
        }
    }
}
