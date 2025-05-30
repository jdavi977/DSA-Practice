
public class Demo {
	
	public static int factorial(int x) {
		int result = 1;
		for (int i = x; i > 0; i --) {
			result *= i;
		}
		return result;
	}
	
	public static int recursiveFactorial(int x) {
		if (x == 1) {
			return 1;
		} else {
			return x * recursiveFactorial(x - 1);
		}
	}
	
	public static void main(String args[]) {
		System.out.println(factorial(10));
		System.out.println(recursiveFactorial(10));
	}
}
