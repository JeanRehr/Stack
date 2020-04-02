public class Main
{

	public static void main(String[] args)
	{
		StaticStack<Character> s1 = new StaticStack<Character>(10);
		s1.push('(');
		s1.push(')');
		s1.push('A');
		s1.push('+');
		s1.push('B');
		s1.push('(');
		s1.push(')');

		System.out.println(s1.checkBrackets1(s1));
	}
}