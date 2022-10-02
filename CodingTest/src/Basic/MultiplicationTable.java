package Basic;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + " x " + j + " = " + String.format("%02d", i * j) + "    ");
            }
            System.out.println();
        }
    }
}
