package Array;

public class N15_MaxSales_inf {
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] sales = new int [n];
    int k = stdIn.nextInt();
    int max = Integer.MIN_VALUE;

    //k까지 미리 합하기
    int sum = 0;
		for(int i = 0; i<k; i++){
        sum += sales[i];
    }

		System.out.println("0~2" + sum);

		for(int i = k; i<sales.length; i++){
        int tmp = sum + sales[i] - sales[i-k];
        // if(Math.max(tmp, max)) max = tmp; return이 boolean이 아니라, 큰 값 리턴 임.
        max = Math.max(max, tmp);
    }

		System.out.println (max);
}
