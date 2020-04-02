import java.util.Iterator;

public class StaticList<E> implements List<E>, Iterable<E> {
	protected E[] elements;
	protected int numElements;

	public StaticList(int maxSize) {
		elements = (E[])new Object[maxSize];
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}

	public void insert(E element, int pos) {
		if (isFull())
			throw new OverflowException();

		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException("indice invalido");

		for (int i = numElements-1; i >= pos; i--)
			elements[i+1] = elements[i];

		elements[pos] = element;
		numElements++;
	}

	public E remove(int pos) {

		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException("indice invalido");


		E element = elements[pos];

		for (int i = pos; i < numElements-1; i++)
			elements[i] = elements[i+1];

		elements[numElements-1] = null;
		numElements--;

		return element;
	}

	public E get(int pos) {

		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException("indice invalido");

		return elements[pos];
	}

	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;

		return -1;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}

	public boolean remove(E element) {

		int pos = search(element);
		if (pos > -1) {
			remove(pos);
			return true;
		}
		return false;
	}

	public void reverse() {

		for (int i = 0; i < numElements / 2; i++) {
			E temp = elements[numElements - 1 - i];
			elements[numElements - 1 - i] = elements[i];
			elements[i] = temp;
		}
	}

	public void add(E element) {

		insert(element, numElements);
	}

	public int remove(int fromIndex, int toIndex) {

		if (fromIndex > toIndex ||
			fromIndex >= numElements || toIndex >= numElements ||
			fromIndex < 0) {
			throw new IndexOutOfBoundsException("indice invalido");
		}
		for (int i = toIndex; i >= fromIndex; i--) {
			remove(i);
		}
		return toIndex - fromIndex + 1;
	}

	public List<E> split(int pos) {

		if (pos < 0 || pos >= numElements) {
			throw new IndexOutOfBoundsException("indice invalido");
		}

		List<E> aux = new StaticList<>(numElements - pos);
		for (int i = numElements - 1; i >= pos; i--) {
			aux.insert(remove(i), 0);
		}
		return aux;
	}

	public void insert(List<E> lista, int pos) {

		if (pos < 0 || pos > numElements) {
			throw new IndexOutOfBoundsException("indice invalido");
		}

		if (lista.numElements() >  elements.length - numElements) {
			throw new OverflowException();
		}
		for (int i = 0; i < lista.numElements(); i++) {
			insert(lista.get(i), pos + i);
		}
	}

	public void addAll(List<E> l) {

		if (l.numElements() > elements.length - numElements()) {
			throw new OverflowException();
		}
		for (int i = 0; i < l.numElements(); i++) {
			add(l.get(i));
		}
	}

	public List<E> subList(int fromIndex, int toIndex) {
		if (fromIndex > toIndex ||
			fromIndex >= numElements || toIndex >= numElements ||
			toIndex < 0) {
			throw new IndexOutOfBoundsException("indice invalido");
		}

		StaticList<E> aux = new StaticList<>(toIndex - fromIndex + 1);
		for (int i = fromIndex; i <= toIndex; i++) {
			aux.add(get(i));
		}
		return aux;
	}

	@Override
	public boolean equals(Object obj) {
		StaticList other = (StaticList) obj;

		if (numElements() != other.numElements()) {
			return false;
		}

		for (int i = 0; i < numElements(); i++) {
			if (!get(i).equals(other.get(i))) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int current = 0;

			@Override
			public boolean hasNext() {
				return current < numElements;
			}
			@Override
			public E next() {
				if (!hasNext())
					throw new RuntimeException("Lista vazia");
				return elements[current++];
			}
		};
	}
}
