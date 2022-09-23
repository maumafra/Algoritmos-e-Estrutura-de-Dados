package arvores;

public class ArvoreBinariaTestes {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();

        System.out.println("1 - "+arvore.estaVazia());

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<Integer>(5);

        arvore.setRaiz(no5);

        System.out.println("2 - "+!arvore.estaVazia());
        
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<Integer>(4);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<Integer>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(3, no5, no6);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(2, null, no4);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(1, no2, no3);

        arvore.setRaiz(no1);

        System.out.println("3 - "+ arvore.toString());
    }
}
