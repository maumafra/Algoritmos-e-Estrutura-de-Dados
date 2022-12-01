package buscas;

public class ArvoreBinariaBusca <T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info){
        NoArvoreBinaria<T> no = new NoArvoreBinaria<T>(info);
        if(estaVazia()){
            setRaiz(no);
            return;
        }
        int compareValue;
        NoArvoreBinaria<T> p = getRaiz(); 
        while (p != null){
            compareValue = info.compareTo(p.getInfo());
            if(compareValue < 0){
                if(p.getEsquerda() == null){
                    p.setEsquerda(no);
                    return;
                }
                p = p.getEsquerda();
            } else {
                if(p.getDireita() == null){
                    p.setDireita(no);
                    return;
                }
                p = p.getDireita();
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        while (p != null && !p.getInfo().equals(info)) {
            int compareValue = info.compareTo(p.getInfo());
            if(compareValue < 0) p = p.getEsquerda();
            else p = p.getDireita();
        }
        return p;
    }

    /* Explicação:
     * O sucessor da raiz é o será o último filho da árvore formada pela esquerda do nó da direita do
     * nó a ser excluído.
     *              48 <- quero excluir
     *          44      89
     *               73     97
     *             59     93 
     *           50 <- sucessor
     * 
     * Existem alguns casos especiais:
     * 1. O filho da direita do nó a ser excluído não tem filho a esquerda
     * 2. O nó a ser removido é a raiz 
     */

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> excluir){
        NoArvoreBinaria<T> p = excluir.getDireita();
        NoArvoreBinaria<T> paiSucessor = excluir;
        NoArvoreBinaria<T> sucessor = excluir;
        while (p != null) {
            paiSucessor = sucessor;
            sucessor = p;
            p = p.getEsquerda();
        }
        if(!sucessor.equals(excluir.getDireita())){
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(excluir.getDireita());
        }
        return sucessor;
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> pai = null;
        NoArvoreBinaria<T> alvo = getRaiz();
        boolean filhoEsquerda = false;
        while (alvo != null && !alvo.getInfo().equals(info)) {
            pai = alvo;
            int compareValue = info.compareTo(alvo.getInfo());
            if(compareValue < 0){
                alvo = alvo.getEsquerda();
                filhoEsquerda = true;
            } else {
                alvo = alvo.getDireita();
                filhoEsquerda = false;
            }
        }
        if(alvo != null){
            if(alvo.getEsquerda() == null && alvo.getDireita() == null){ //filho não tem filho
                if(alvo.equals(getRaiz())){
                    setRaiz(null);
                } else {
                    if(filhoEsquerda) pai.setEsquerda(null); //se o filho está a direita do pai, quer dizer que todos os dados conectados ao filho são menores que o pai
                    else pai.setDireita(null); //se o filho está a direita do pai, quer dizer que todos os dados conectados ao filho são maiores que o pai
                }
            } else if(alvo.getDireita() == null){ //filho tem filho a esquerda
                if(alvo.equals(getRaiz())){
                    setRaiz(alvo.getEsquerda());
                } else {
                    if(filhoEsquerda) pai.setEsquerda(alvo.getEsquerda());
                    else pai.setDireita(alvo.getEsquerda());
                }
            } else if(alvo.getEsquerda() == null){ //filho tem filho a direita
                if(alvo.equals(getRaiz())){
                    setRaiz(alvo.getDireita());
                } else {
                    if(filhoEsquerda) pai.setEsquerda(alvo.getDireita());
                    else pai.setDireita(alvo.getDireita());
                }
            } else { //filho tem filho a direita e a esquerda
                NoArvoreBinaria<T> sucessor = extrairSucessor(alvo);
                if(alvo.equals(getRaiz())){
                    setRaiz(sucessor);
                } else {
                    if(filhoEsquerda) pai.setEsquerda(sucessor);
                    else pai.setDireita(sucessor);
                }
                sucessor.setEsquerda(alvo.getEsquerda());
            }
        }
    }
}
