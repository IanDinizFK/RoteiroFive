package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;


import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {

    private ListaEncadeadaIF<Integer> fila;

    public FilaListaEncadeada() {
        fila = new ListaEncadeadaImpl<>();
    }

    @Override
    public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
        fila.insert(item.getChave());
    }

    @Override
    public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
        if (fila.isEmpty()) {
            throw new FilaVaziaException("A fila está vazia. Não é possível desenfileirar.");
        }
        NodoListaEncadeada<Integer> nodoRemovido = fila.remove(((FilaListaEncadeada) fila).verificarCabeca().getChave());
        return nodoRemovido;
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCauda() {
        NodoListaEncadeada<Integer> cauda = null;
        if (!fila.isEmpty()) {
            cauda = fila.predecessor(((FilaListaEncadeada) fila).verificarCabeca().getChave());
        }
        return cauda;
    }

    @Override
    public NodoListaEncadeada<Integer> verificarCabeca() {
        return ((FilaListaEncadeada) fila).verificarCabeca();
    }

    @Override
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false; // A lista encadeada não possui um limite máximo de elementos, portanto a fila nunca está cheia
    }
}
