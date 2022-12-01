package buscas;

public class BuscaTeste {

    public static int numTeste = 1;

    public static void main(String[] args) {
        testeArvore();
    }

    public static void testeArvore(){
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();

        String teste1="<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>";
        String teste2="<50<30<25<><>><>><>>";
        String teste3="<80<52<48<><>><63<><67<><>>>><90<><>>>";
        String teste4="<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>";

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);
        arvore.inserir(60);
        
        testarEquals(arvore.toString(), teste1);

        arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(25);
        arvore.inserir(40);
        arvore.retirar(40);

        testarEquals(arvore.toString(), teste2);

        arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(80);
        arvore.inserir(52);
        arvore.inserir(90);
        arvore.inserir(48);
        arvore.inserir(71);
        arvore.inserir(63);
        arvore.inserir(67);
        arvore.retirar(71);

        testarEquals(arvore.toString(), teste3);

        arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(250);
        arvore.inserir(38);
        arvore.inserir(26);
        arvore.inserir(72);
        arvore.inserir(55);
        arvore.inserir(90);
        arvore.inserir(41);
        arvore.inserir(60);
        arvore.inserir(43);
        arvore.inserir(78);
        arvore.inserir(92);
        arvore.inserir(74);
        arvore.retirar(38);

        testarEquals(arvore.toString(), teste4);

    }

    public static void testeLista(){
        int num = 0;

        ListaOrdenada<Integer> lista = new ListaOrdenada<>();

        lista.inserir(100);
        lista.inserir(20);
        lista.inserir(70);
        lista.inserir(1);

        testar(lista.toString());
        lista.liberar();
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);num = num+10;
        lista.inserir(num);
        testar(((Integer) lista.buscar(20)).toString());
        testar(((Integer) lista.buscar(40)).toString());
        testar(((Integer) lista.buscar(70)).toString());
        testar(((Integer) lista.buscar(100)).toString());
        testar(((Integer) lista.buscar(85)).toString());
    }

    public static void testar(String msg){
        System.out.println("Teste "+numTeste+": "+msg);
        numTeste++;
    }

    public static void testarEquals(String msg, String esperado){
        System.out.println("Teste "+msg.equals(esperado));
        numTeste++;
    }
}
