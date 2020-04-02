public class Exercicio5 {
	static StaticStack<Integer> s1 = new StaticStack<Integer>(20);
	static StaticStack<Integer> s2 = new StaticStack<Integer>(10);

	public static void enche() {
		for (int i = 0; i < 10; i++) {
			s1.push(i);
			s2.push(i);
		}
	}

	public static void prependStack(Stack<Integer> s1, Stack<Integer> s2) {
		StaticStack<Integer> aux1 = new StaticStack<Integer>(s2.numElements());
		StaticStack<Integer> aux2 = new StaticStack<Integer>(s2.numElements());

		while (!s1.isEmpty())
			aux1.push(s1.pop());
		while (!s2.isEmpty())
			aux2.push(s2.pop());
		int a1 = 0;
		while(!aux2.isEmpty()) {
			a1 = aux2.pop();
			s1.push(a1);
			s2.push(a1);
		}
		while(!aux1.isEmpty())
			s1.push(aux1.pop());
	}

	public static void main(String[] args) {
		enche();
		prependStack(s1, s2);
		System.out.println(s1);
	}
}