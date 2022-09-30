package arvores;

public class ArvoreTeste {
    public static void main(String[] args) {

        NoArvore<Integer> no1 = new NoArvore<Integer>(1);
        NoArvore<Integer> no2 = new NoArvore<Integer>(2);
        NoArvore<Integer> no3 = new NoArvore<Integer>(3);
        NoArvore<Integer> no4 = new NoArvore<Integer>(4);
        NoArvore<Integer> no5 = new NoArvore<Integer>(5);
        NoArvore<Integer> no6 = new NoArvore<Integer>(6);
        NoArvore<Integer> no7 = new NoArvore<Integer>(7);
        NoArvore<Integer> no8 = new NoArvore<Integer>(8);
        NoArvore<Integer> no9 = new NoArvore<Integer>(9);
        NoArvore<Integer> no10 = new NoArvore<Integer>(10);

        Arvore<Integer> arvore = new Arvore<>();
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
        
        no3.inserirFilho(no8);

        no4.inserirFilho(no10);
        no4.inserirFilho(no9);
        
        arvore.setRaiz(no1);

        System.out.println(arvore.toString());

        System.out.println("Teste 1) "+"<1<2<5><6><7>><3<8>><4<9><10>>>".equals(arvore.toString()));
        System.out.println("Teste 2) "+arvore.pertence(7));
        System.out.println("Teste 3) "+!arvore.pertence(72));
        System.out.println("Teste 4) "+(arvore.contarNos()==10));
    }
}
