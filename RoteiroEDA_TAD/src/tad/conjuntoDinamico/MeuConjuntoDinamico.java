package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

    private Integer[] meusDados = null;
    private int posInsercao = 0;

    @Override
    public void inserir(Integer item) {
        if (meusDados == null) {
            meusDados = new Integer[1];
            meusDados[0] = item;
        } else {
            if (posInsercao >= meusDados.length) {
                meusDados = aumentarArray();
            }
            meusDados[posInsercao] = item;
        }
        posInsercao++;
    }

    private Integer[] aumentarArray() {
        int novoTamanho = meusDados.length * 2;
        Integer[] arrayMaior = new Integer[novoTamanho];
        System.arraycopy(meusDados, 0, arrayMaior, 0, meusDados.length);
        return arrayMaior;
    }

    @Override
    public Integer remover(Integer item) {
        if (meusDados != null) {
            for (int i = 0; i < posInsercao; i++) {
                if (meusDados[i] != null && meusDados[i].equals(item)) {
                    Integer valorRemovido = meusDados[i];
                    meusDados[i] = null;
                    rearranjarArray();
                    posInsercao--;
                    return valorRemovido;
                }
            }
        }
        // Lançar exceção quando o item não é encontrado
        throw new UnsupportedOperationException("Implementar");
    }

    private void rearranjarArray() {
        for (int i = 0; i < posInsercao; i++) {
            if (meusDados[i] == null) {
                for (int j = i; j < posInsercao - 1; j++) {
                    meusDados[j] = meusDados[j + 1];
                }
                meusDados[posInsercao - 1] = null;
            }
        }
    }

    @Override
    public Integer predecessor(Integer item) {
        int existe = 0;
        for(int i = 0; i < posInsercao; i++){
            if(item == meusDados[i]){
                existe = existe + 1;
            }
        }
        if (meusDados == null || meusDados.length == 0 || existe == 0) {
            throw new UnsupportedOperationException("Conjunto vazio");
        } else {
            Integer sucessor = null;
            for (int i = 0; i < posInsercao; i++) {
                if (item == meusDados[i]) {
                    if (i == 0) {
                        sucessor = null;
                    } else {
                        sucessor = meusDados[i - 1];
                    }
                    break;
                }
            }
            return sucessor;
        }
    }

    @Override
    public Integer sucessor(Integer item) {

        if (meusDados == null || meusDados.length == 0) {
            throw new UnsupportedOperationException("Conjunto vazio");
        } else {
            Integer sucessor = null;
            for (int i = 0; i < posInsercao; i++) {
                if (item == meusDados[i]) {
                    if (i == meusDados.length - 1) {
                        sucessor = null;
                    } else {
                        sucessor = meusDados[i + 1];
                    }
                    break;
                }
            }
            return sucessor;
        }
    }

    @Override
    public int tamanho() {
        return posInsercao;
    }

    @Override
    public Integer buscar(Integer item) {
        if (meusDados != null) {
            for (int i = 0; i < posInsercao; i++) {
                if (meusDados[i] != null && meusDados[i].equals(item)) {
                    return meusDados[i];
                }
            }
        }
        throw new IllegalArgumentException("Item não encontrado");
    }

    @Override
    public Integer minimum() {
        if (meusDados != null && posInsercao > 0) {
            Integer minimum = meusDados[0];
            for (int i = 1; i < posInsercao; i++) {
                if (meusDados[i] != null && meusDados[i] < minimum) {
                    minimum = meusDados[i];
                }
            }
            return minimum;
        }
        throw new UnsupportedOperationException("Conjunto vazio");
    }

    @Override
    public Integer maximum() {
        if (meusDados != null && posInsercao > 0) {
            Integer maximum = meusDados[0];
            for (int i = 1; i < posInsercao; i++) {
                if (meusDados[i] != null && meusDados[i] > maximum) {
                    maximum = meusDados[i];
                }
            }
            return maximum;
        }
        throw new UnsupportedOperationException("Conjunto vazio");
    }
}
