package ordenacao;

public class TesteOrdenacao {

    public static int numTeste = 1;

    public static void main(String[] args) {
        testeOrdenacaoBolha();
        testeOrdenacaoQuickSort();
        testeOrdenacaoMergeSort();
        testeOrdenacaoDecrescenteBolha();
    }

    public static void testeOrdenacaoBolha(){
        Integer[] vetor = {70,2,88,15,90,30};
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(vetor);
        bolha.ordenar();
        testarEquals(arrayToString(bolha.getInfo()), "[2,15,30,70,88,90]");

        vetor = null;

        Integer[] vetor2 = {70,2,88,15,90,30};
        OrdenacaoBolhaOtimizada<Integer> bolha2 = new OrdenacaoBolhaOtimizada<>();
        bolha2.setInfo(vetor2);
        bolha2.ordenar();
        testarEquals(arrayToString(bolha2.getInfo()), "[2,15,30,70,88,90]");
    }

    public static void testeOrdenacaoQuickSort(){
        Integer[] vetor = {70,2,88,15,90,30};
        OrdenacaoQuickSort<Integer> bolha = new OrdenacaoQuickSort<>();
        bolha.setInfo(vetor);
        bolha.ordenar();
        testarEquals(arrayToString(bolha.getInfo()), "[2,15,30,70,88,90]");
    }

    public static void testeOrdenacaoMergeSort(){
        Integer[] vetor = {70,2,88,15,90,30};
        OrdenacaoMergeSort<Integer> bolha = new OrdenacaoMergeSort<>();
        bolha.setInfo(vetor);
        bolha.ordenar();
        testarEquals(arrayToString(bolha.getInfo()), "[2,15,30,70,88,90]");
    }

    public static void testeOrdenacaoDecrescenteBolha(){
        Integer[] vetor = {70,2,88,15,90,30};
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>();
        bolha.setInfo(vetor);
        bolha.ordenarDecrescente();
        testarEquals(arrayToString(bolha.getInfo()), "[90,88,70,30,15,2]");
        System.out.println(arrayToString(bolha.getInfo()));
    }

    public static void testar(String msg){
        System.out.println("Teste "+numTeste+": "+msg);
        numTeste++;
    }

    public static void testarEquals(String msg, String esperado){
        System.out.println("Teste "+numTeste+": "+msg.equals(esperado));
        numTeste++;
    }

    public static String arrayToString(Integer[] array){
        String msg = "[";
        for(Integer value : array){
            msg +=  ","+value.toString();
        }
        msg += "]";
        return msg.replaceFirst(",", "");
    }
}
