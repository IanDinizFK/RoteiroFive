package tad.listasEncadeadas;

public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {

	// TODO: implementar o nó cabeça
	// TODO: implementar o nó cauda
	// TODO: implementar as sentinelas

	NodoListaDuplamenteEncadeada<T> cabeca = null; // Estratégia usando marcação sentinela
	NodoListaDuplamenteEncadeada<T> cauda = null;// Estratégia usando marcação sentinela

	public ListaDuplamenteEncadeadaImpl() {// Estratégia usando marcação sentinela
		cabeca = new NodoListaDuplamenteEncadeada<T>();
		cauda = new NodoListaDuplamenteEncadeada<T>();
		cabeca.setProximo(cauda);

		// lista circular
		cabeca.setAnterior(cauda);
		cauda.setAnterior(cabeca);
	}

	@Override
	public boolean isEmpty() {
		return cabeca.getProximo() == cauda;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> search(T chave) {
		
		return null;
	}

	@Override
	public void insert(T chave) {
		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(chave);

		novoNo.setProximo(cabeca.getProximo());
		((NodoListaDuplamenteEncadeada<T>) cabeca.getProximo()).setAnterior(novoNo);
		novoNo.setAnterior(cabeca);
		cabeca.setProximo(novoNo);
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> remove(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
		while (atual != cauda) {
			if (atual.	getChave().equals(chave)) {
				atual.getAnterior().setProximo(atual.getProximo());
				((NodoListaDuplamenteEncadeada<T>) atual.getProximo()).setAnterior(atual.getAnterior());
				return atual;
			}
			atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
		}
		return null;
	}

	@Override
	public String imprimeEmOrdem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imprimeInverso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserePrimeiro(T elemento) {
		// TODO Auto-generated method stub

	}

	@Override
	public NodoListaDuplamenteEncadeada<T> removeUltimo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");

	}

}
