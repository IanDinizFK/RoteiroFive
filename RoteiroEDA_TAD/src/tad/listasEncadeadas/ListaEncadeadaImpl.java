package tad.listasEncadeadas;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T> {

	NodoListaEncadeada<T> cabeca;
	NodoListaEncadeada<T> cauda;

	public ListaEncadeadaImpl() {
		cabeca = new NodoListaEncadeada<>();
		cauda = new NodoListaEncadeada<>();
		cabeca.setProximo(cauda);
	}

	@Override
	public boolean isEmpty() {
		return cabeca.getProximo() == cauda;
	}

	@Override
	public int size() {
		int count = 0;
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		while (corrente != cauda) {
			count++;
			corrente = corrente.getProximo();
		}
		return count;
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		while (corrente != cauda) {
			if (corrente.getChave().equals(chave)) {
				return corrente;
			}
			corrente = corrente.getProximo();
		}
		return null;
	}

	@Override
	public void insert(T chave) {
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<T>(chave);

		if (cabeca.getProximo() == cauda) {
			cabeca.setProximo(novoNo);
			novoNo.setProximo(cauda);
		} else {
			NodoListaEncadeada<T> corrente = cabeca.getProximo();
			while (corrente.getProximo() != cauda) {
				corrente = corrente.getProximo();
			}
			corrente.setProximo(novoNo);
			novoNo.setProximo(cauda);
		}
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		NodoListaEncadeada<T> anterior = cabeca;
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		while (corrente != cauda) {
			if (corrente.getChave().equals(chave)) {
				anterior.setProximo(corrente.getProximo());
				return corrente;
			}
			anterior = corrente;
			corrente = corrente.getProximo();
		}

		return null;
	}

	@Override
public T[] toArray(Class<T> clazz) {
    int count = size();
    T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, count);

    NodoListaEncadeada<T> corrente = cabeca.getProximo();
    int index = 0;
    while (corrente != cauda) {
        array[index++] = corrente.getChave();
        corrente = corrente.getProximo();
    }

    return array;
}

	

	@Override
	public String imprimeEmOrdem() {
		StringBuilder valores = new StringBuilder();
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		while (corrente != cauda) {
			valores.append(corrente.getChave()).append(", ");
			corrente = corrente.getProximo();
		}

		if (valores.length() > 2) {
			valores.setLength(valores.length() - 2);
		}

		return valores.toString();
	}

	@Override
	public String imprimeInverso() {
		StringBuilder valores = new StringBuilder();
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		NodoListaEncadeada<T> anterior = cabeca;

		while (corrente != cauda) {
			valores.append(corrente.getChave()).append(", ");
			anterior = corrente;
			corrente = corrente.getProximo();
		}

		if (valores.length() > 2) {
			valores.setLength(valores.length() - 2);
		}

		return valores.reverse().toString();
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		while (corrente != cauda) {
			if (corrente.getChave().equals(chave)) {
				NodoListaEncadeada<T> sucessor = corrente.getProximo();
				if (sucessor != cauda) {
					return sucessor;
				} else {
					break;
				}
			}
			corrente = corrente.getProximo();
		}

		return null;
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		NodoListaEncadeada<T> anterior = cabeca;
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		while (corrente != cauda) {
			if (corrente.getChave().equals(chave)) {
				return anterior;
			}
			anterior = corrente;
			corrente = corrente.getProximo();
		}

		return null;
	}

	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Precisa implementar!");
	}
}
