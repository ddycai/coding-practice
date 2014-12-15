import java.util.*;

/**
 * Question: Write an algorithm using three stacks to simulate the Towers of Hanoi.
 */
class Hanoi {

	static Stack<Integer> a, b, c;

	static int getName(Stack<Integer> stk) {
		if(stk == a)
			return 1;
		if(stk == b)
			return 2;
		return 3;
	}

	static int move(Stack<Integer> src, Stack<Integer> dest, Stack<Integer> in, int n) {
		int sum = 0;
		if(n == 1) {
			int num = src.pop();
			dest.push(num);
			System.out.printf("Moving %d from stack %d to stack %d\n", num, getName(src), getName(dest));
			sum++;
		} else {
			sum += move(src, in, dest, n - 1);
			int num = src.pop();
			dest.push(num);
			System.out.printf("Moving %d from stack %d to stack %d\n", num, getName(src), getName(dest));
			sum++;
			sum += move(in, dest, src, n - 1);
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new Stack<Integer>();
		b = new Stack<Integer>();
		c = new Stack<Integer>();
		for(int i = n; i >= 1; i--) {
			a.push(i);
		}

		System.out.println(move(a, c, b, n));

		while(!c.isEmpty()) {
			System.out.println(c.pop());
		}

	}

}
