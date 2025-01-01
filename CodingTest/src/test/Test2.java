package test;

public class Test2 {
    public static void main(String[] args) {

//        System.out.println(solution(2, "1A 2F 1C")); //2
//        System.out.println(solution(1, "")); //2
        System.out.println(solution(22, "1A 3C 2B 20G 5A")); //41
    }

    public static int solution(int N, String S) {
        if(S.equals("")){
            return N * 2;
        }


        // Implement your solution here

        int[][] arr = new int[N][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1;
            }
        }

        reserved(arr, S); // [N][2]


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int count = 0;
        for (int[] seat : arr) {
            count += countSeat(seat);
        }

        return count;
//        return 0;
    }


    //"1A 3C 2B 20G 5A"
    private static void reserved(int[][] arr, String s) {
        String[] strs = s.split(" ");

        for (int i = 0; i < strs.length; i++) { //row가 10의 자리 넘었을 경우
            String str = strs[i];
            int digitIdx = 0;
            while(Character.isDigit(str.charAt(digitIdx))){
                digitIdx++;
            }

            int row = Integer.parseInt(str.substring(0, digitIdx)) - 1;
            int col = str.charAt(digitIdx) == 'K' ? 9 : (int) str.charAt(digitIdx) - 65;

//            System.out.println("row == " + row);
//            System.out.println("col == " + col);
            arr[row][col] = 0; //예약되면 0
        }

    }

    private static int countSeat(int[] seat) {
        int result = 0;
        int tmp = 0;

        for (int i = 0; i < seat.length; i++) {
            if(seat[i] == 0){
                tmp = 0;
            }else{
                tmp += 1;
                if(tmp == 4){
                    result += 1;
                    tmp = 0;
                }
            }
        }

        System.out.println(result);
        return result;
    }

}
