public class Exercicio2 {
	public static void main(String[] args) {
		StaticStack<Integer> p1 = new StaticStack<Integer>(5);
		StaticStack<Integer> p2 = new StaticStack<Integer>(5);
		StaticStack<Integer> p3 = new StaticStack<Integer>(5);

		p1.push(10);
		p1.push(20);
		p1.push(30);
		p1.push(40);

		System.out.println(p1);

		p2.push(p1.pop());
		p2.push(p1.pop());
		p3.push(p1.pop());
		p3.push(p1.pop());
		p1.push(p2.pop());
		p3.push(p2.pop());
		p3.push(p1.pop());

		System.out.println(p3);
	}
}
