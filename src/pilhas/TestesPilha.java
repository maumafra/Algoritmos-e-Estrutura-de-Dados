package pilhas;

public class TestesPilha {
    public static void main(String[] args) {
        PilhaVetor<Integer> pilhaInt = new PilhaVetor<>(10);
        PilhaVetor<Integer> pilhaIntAux = new PilhaVetor<>(10);
        String auxText;
        boolean auxBoolean; 
        
        //1
        System.out.println("1o Teste) "+(pilhaInt.estaVazia()==true));

        //2
        pilhaInt.push(1);
        pilhaInt.push(2);
        pilhaInt.push(3);
        pilhaInt.push(4);
        pilhaInt.push(5);

        System.out.println("2o Teste) "+(pilhaInt.estaVazia()==false));

        //3
        pilhaInt.liberar();
        pilhaInt.push(10);
        pilhaInt.push(20);
        pilhaInt.push(30);
        auxText = pilhaInt.toString();

        System.out.println("3o Teste) "+(pilhaInt.pop()==30 && pilhaInt.pop()==20 && pilhaInt.pop()==10 && pilhaInt.estaVazia())+" - "+auxText);

        //4
        auxBoolean = false;

        try{
            pilhaInt.push(10);
            pilhaInt.push(20);
            pilhaInt.push(30);
            pilhaInt.push(10);
            pilhaInt.push(20);
            pilhaInt.push(30);
            pilhaInt.push(10);
            pilhaInt.push(20);
            pilhaInt.push(30);
            pilhaInt.push(10);
            pilhaInt.push(20);
            pilhaInt.push(30);
        } catch (PilhaCheiaException e){
            auxBoolean = true;
        }

        System.out.println("4o Teste) "+auxBoolean);

        //5
        pilhaInt.liberar();
        auxBoolean = false;

        try{
            pilhaInt.pop();
        } catch (PilhaVaziaException e){
            auxBoolean = true;
        }

        System.out.println("5o Teste) "+auxBoolean);

        //6
        pilhaInt.push(10);
        pilhaInt.push(20);
        pilhaInt.push(30);

        System.out.println("6o Teste) "+(pilhaInt.peek()==30));

        //7
        pilhaInt.liberar();

        System.out.println("7o Teste) "+(pilhaInt.estaVazia()));

        //8
        pilhaInt.push(10);
        pilhaInt.push(20);
        pilhaInt.push(30);
        pilhaIntAux.push(40);
        pilhaIntAux.push(50);

        pilhaInt.concatenar(pilhaIntAux);
        auxText = pilhaInt.toString();

        System.out.println("8o Teste) "+(pilhaInt.toString().equals("50,40,30,20,10"))+" - "+auxText);
    }
}
