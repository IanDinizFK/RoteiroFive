package tad.pilha;

import java.util.Arrays;
import tad.pilha.PilhaCheiaException;

public class MinhaPilha implements PilhaIF<Integer> {

    private int tamanho = 10;
    private Integer[] meusDados;
    private int topo;

    public MinhaPilha(int tamanho) {
        this.tamanho = tamanho;
        this.meusDados = new Integer[tamanho];
        this.topo = -1;
    }

    public MinhaPilha() {
        this.meusDados = new Integer[tamanho];
        this.topo = -1;
    }

    @Override
    public void empilhar(Integer item) throws PilhaCheiaException {
        if (topo == tamanho - 1) {
            throw new PilhaCheiaException();
        }
        topo++;
        meusDados[topo] = item;
    }

    @Override
    public Integer desempilhar() throws PilhaVaziaException {
        if (isEmpty()) {
            throw new PilhaVaziaException("A pilha está vazia");
        }
        Integer item = meusDados[topo];
        meusDados[topo] = null;
        topo--;
        return item;
    }

    @Override
    public Integer topo() {
        if (isEmpty()) {
            return null;
        }
        return meusDados[topo];
    }

    @Override
    public PilhaIF<Integer> multitop(int k) {
        if (isEmpty() || k <= 0 || k > tamanho) {
            throw new IllegalArgumentException("Parâmetro inválido");
        }

        if (topo >= tamanho - k) {
            throw new PilhaCheiaException();
        }

        PilhaIF<Integer> pilhaMultitop = new MinhaPilha(k);
        for (int i = topo; i > topo - k; i--) {
            try {
                pilhaMultitop.empilhar(meusDados[i]);
            } catch (PilhaCheiaException e) {
                throw new PilhaCheiaException();
            }
            topo--;
        }
        return pilhaMultitop;
    }

    @Override
    public boolean isEmpty() {
        return topo == -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MinhaPilha outraPilha = (MinhaPilha) obj;
        if (topo != outraPilha.topo) {
            return false;
        }
        for (int i = 0; i <= topo; i++) {
            if (!meusDados[i].equals(outraPilha.meusDados[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(meusDados);
        result = 31 * result + topo;
        return result;
    }
}