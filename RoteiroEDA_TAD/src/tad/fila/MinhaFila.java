package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 */
public class MinhaFila implements FilaIF<Integer> {

    private int tamanho = 10;
    private int cauda = 0;
    private int cabeca = 0;
    private Integer[] meusDados = null;

    public MinhaFila(int tamanhoInicial) {
        tamanho = tamanhoInicial + 1; // Adicionando +1 ao tamanho para evitar confusão entre fila vazia e cheia
        meusDados = new Integer[tamanho];
    }

    public MinhaFila() {
        meusDados = new Integer[tamanho];
    }

    public void enfileirar(Integer item) throws FilaCheiaException {
        if (isFull()) {
            throw new FilaCheiaException();
        }

        meusDados[cauda] = item;
        cauda = (cauda + 1) % tamanho;
    }

    public Integer desenfileirar() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException();
        }

        Integer item = meusDados[cabeca];
        meusDados[cabeca] = null;
        cabeca = (cabeca + 1) % tamanho;

        return item;
    }

    public Integer verificarCauda() {
        if (isEmpty()) {
            return null;
        }

        int indiceCauda = (cauda - 1 + tamanho) % tamanho;
        return meusDados[indiceCauda];
    }

    public Integer verificarCabeca() {
        if (isEmpty()) {
            return null;
        }

        return meusDados[cabeca];
    }

    public boolean isEmpty() {
        return cabeca == cauda;
    }

    public boolean isFull() {
        return (cauda + 1) % tamanho == cabeca;
    }
}
