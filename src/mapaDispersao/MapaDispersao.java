package mapaDispersao;

import listsPtBr.ListaEncadeada;
import listsPtBr.NoLista;

public class MapaDispersao<T>{
    
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho){
        info = (ListaEncadeada<NoMapa<T>>[]) new ListaEncadeada[tamanho];
    }

    private int calcularHash(int chave){
        int tamanho = this.info.length;
        return chave%tamanho;
    }

    public void inserir(int chave, T dado){
        int indice = calcularHash(chave);
        if(info[indice] == null){
            info[indice] = new ListaEncadeada<>();
        }
        NoMapa<T> no = new NoMapa<>();
        no.setChave(chave);
        no.setInfo(dado);
        info[indice].inserir(no);
    }

    public void remover(int chave){
        int indice = calcularHash(chave);
        if(info[indice] != null){
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);
            info[indice].retirar(no);
        }
    }

    public T buscar(int chave){
        int indice = calcularHash(chave);
        if(info[indice] != null){
            NoMapa<T> no = new NoMapa<>();
            no.setChave(chave);
            NoLista<NoMapa<T>> noLista = info[indice].buscar(no);
            if(noLista != null){
                return noLista.getInfo().getInfo();
            }
        }
        return null;
    }
}
