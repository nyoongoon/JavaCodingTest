package _0_Theory.Chapter2_Linear._01_배열.src;// Practice
// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;

class MyArray {

    int[] arr;
    int cursor = 0;

    //  배열의 초기 사이즈 설정
    MyArray(int size) {
        this.arr = create(size);
    }

    public int[] create(int size) {
        return new int[size];
    }

    public int[] copy(int[] origin, int[] target) {
        for (int i = 0; i < origin.length; i++) {
            target[i] = origin[i];
        }
        return target;
    }

    //  배열에 데이터 삽입

    public void insertData(int idx, int value) {
        if(idx < 0 || idx >= this.arr.length){
            System.out.println("Index Error");
            return;
        }
        int[] newArr = new int[this.arr.length + 1];
        for (int i = 0; i < idx; i++) {
            newArr[i] = this.arr[i];
        }
        newArr[idx] = value;
        for (int i = idx; i < this.arr.length; i++) {
            newArr[i + 1] = this.arr[i];
        }
        this.arr = newArr;
    }

    public void removeData(int value) {
        int delIdx = -1;
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] == value) {
                delIdx = i;
            }
        }
        if (delIdx == -1) {
            System.out.println("지우려는 값 없음");
            return;
        }
        int[] newArr = new int[this.arr.length - 1];

        for (int i = 0; i < delIdx; i++) {
            newArr[i] = arr[i];
        }
        for (int i = delIdx; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }
        this.arr = newArr;
    }


}

public class Practice {
    public static void main(String[] args) {

//      Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));   // [1, 2, 3, 4, 5]

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 3, 4, 5]

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5]

        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5, 60]

        myArray.insertData(-1, 0);  // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 5, 60]

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 60]

        myArray.removeData(99); // 해당 데이터가 없습니다.
    }
}
