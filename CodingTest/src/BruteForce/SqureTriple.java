package BruteForce;

public class SqureTriple {
	public static void main(String[] args) {
		int n = 10;
		int op = countTriples(n);
		System.out.println(op);

	}

	public static int countTriples(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			System.out.println("i == " + i);
			double target = Math.pow(i, 2);
			for (int j = 1; j < i; j++) {
				System.out.println("j == " + j);
				double substc = Math.pow(j, 2);
				double result = Math.sqrt(target - substc);
				if((result!=0)&&(Math.ceil(result) == Math.floor(result))) {  //제곱근이 정수
					System.out.println(result +"^2 " + j+"^2 " + " = " +i);
					answer++;
				}				
			}
		}
		return answer;
	}

	public static boolean isInteger(double number) {
		return Math.ceil(number) == Math.floor(number);
	}
}
