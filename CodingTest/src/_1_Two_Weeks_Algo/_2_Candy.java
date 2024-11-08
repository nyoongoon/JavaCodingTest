package _1_Two_Weeks_Algo;

import java.util.Scanner;

//2015, 2016년에 이어 2017년에도 연세대학교 교내 프로그래밍 경시대회가 열린다.
//
//택희, 영훈이, 남규는 열심히 문제를 만들었고, 이에 대한 보상으로 과사로부터 사탕 N개를 받았다.
//
//N개의 사탕을 적절히 나눠 가지기 위해 토론한 결과, 아래와 같은 방식으로 사탕을 나누기로 결정하였다.
//
//남는 사탕은 없어야 한다.
//남규A는 영훈B이보다 2개 이상 많은 사탕을 가져야 한다.
//셋 중 사탕을 0개 받는 사람은 없어야 한다.
//택희C가 받는 사탕의 수는 홀수개가 되어서는 안 된다.
//이제 사탕을 적절히 나누어 집에 돌아가던 중, 택희는 위와 같은 규칙을 만족하도록 세 명에게 사탕을 나누어 주는 방법의 수가 궁금해졌다.
//
//사탕의 개수 N이 주어지면, 사탕을 세 사람에게 분배하는 서로 다른 경우의 수를 세 보자.
public class _2_Candy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int candy = scanner.nextInt();

        int result = 0;
        for (int i = 2; i <= candy; i += 2) {
            int restOf = candy - i; //남은 것이 홀수 짝수
//            a에게 하나 빼고 다 주고 하나씩 뺴기
            int a = restOf - 1;
            int b = 1;
            while (true) {
                if (a >= b + 2) {
                    result++;
                    a -= 1;
                    b += 1;
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
