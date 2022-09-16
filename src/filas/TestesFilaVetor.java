package filas;

import pilhas.PilhaCheiaException;
import pilhas.PilhaVaziaException;

public class TestesFilaVetor {
    public static void main(String[] args) {
        FilaVetor<Integer> filaInt = new FilaVetor<>(5);
        FilaVetor<Integer> filaInt2 = new FilaVetor<>(3);
        String auxText;
        boolean auxBoolean; 

        //1
        System.out.println("1o Teste) "+(filaInt.estaVazia()==true));

        filaInt.inserir(10);

        //2
        System.out.println("2o Teste) "+(filaInt.estaVazia()==false));

        filaInt = new FilaVetor<>(10);
        filaInt.inserir(10);
        filaInt.inserir(20);
        filaInt.inserir(30);

        auxText = filaInt.toString();

        //3
        System.out.println("3o Teste) "+(filaInt.retirar()==10 && filaInt.retirar()==20 && filaInt.retirar()==30 && filaInt.estaVazia())+" - "+auxText);

        filaInt = new FilaVetor<>(3);
        auxBoolean = false;
        try{
            filaInt.inserir(10);
            filaInt.inserir(20);
            filaInt.inserir(30);
            filaInt.inserir(40);
        } catch (FilaCheiaException e){
            auxBoolean = true;
        }

        //4
        System.out.println("4o Teste) "+auxBoolean);

        filaInt.liberar();
        auxBoolean = false;
        try{
            filaInt.retirar();
        } catch (FilaVaziaException e){
            auxBoolean = true;
        }
        //5
        System.out.println("5o Teste) "+auxBoolean);

        filaInt.inserir(10);
        filaInt.inserir(20);
        filaInt.inserir(30);

        //6
        System.out.println("6o Teste) "+(filaInt.peek()==10 && filaInt.retirar()==10));

        filaInt.liberar();

        //7
        System.out.println("7o Teste) "+filaInt.estaVazia());

        filaInt = new FilaVetor<>(5);
        filaInt.inserir(10);
        filaInt.inserir(20);
        filaInt.inserir(30);
        filaInt2.inserir(40);
        filaInt2.inserir(50);

        FilaVetor<Integer> fila3 = filaInt.criarFilaConcatenada(filaInt2);

        //8
        System.out.println("8o Teste) "+("10,20,30,40,50".equals(fila3.toString()) && "10,20,30".equals(filaInt.toString()) && "40,50".equals(filaInt2.toString())) + " - " + fila3.getLimite());

    }
}
