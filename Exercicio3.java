public class Exercicio3
{
	static StaticStack<Integer> s1 = new StaticStack<Integer>(20);

	public static void enche()
	{
		for (int i = 0; i < 10; i++) {
			s1.push(i);
		}
	}

	public static Integer[] itemsExcept(int number, Stack<Integer> p)
	{
		int a1 = 0;
		StaticStack<Integer> aux1 = new StaticStack<Integer>(p.numElements());
		Integer[] i1 = new Integer[p.numElements()];
		while (!p.isEmpty())
			aux1.push(p.pop());

		int i = 0;
		while (!aux1.isEmpty()) {
			a1 = aux1.pop();

			if (a1 != number) {
				i1[i] = a1;
				i++;
			}

			p.push(a1);
		}

		for (int j = 0; j < i1.length; j++) {
			System.out.println(i1[j]);
		}

		return i1;
	}

	public static void main(String[] args)
	{
		enche();
		System.out.println(s1);
		System.out.println();
		itemsExcept(5, s1);
		System.out.println();
		System.out.println(s1);
	}
}