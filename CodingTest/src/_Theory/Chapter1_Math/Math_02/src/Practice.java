package _Theory.Chapter1_Math.Math_02.src;// Practice
// ArrayList를 사용한 집합 구현 실습 (집합 관련 연산 사용 X)

import java.util.ArrayList;

class MySet {
    // ArrayList
    ArrayList<Integer> list;


    // 생성자1
    MySet() {
        this.list = new ArrayList<>();
    }

    // 생성자 2
    MySet(int[] arr) {
        this.list = new ArrayList<>();
        for (int n : arr){
            list.add(n);
        }
    }

    // 원소 추가 (중복 X)
    public void add(int num) {
        for (int ele : list) {
            if (num == ele) {
                return;
            }
        }
        list.add(num);
    }

    // 교집합
    public MySet retainAll(MySet set) {
        MySet resultSet = new MySet();
        for (int i = 0; i < this.list.size(); i++) {
            for (int j = 0; j < set.list.size(); j++) {
                if (this.list.get(i) == set.list.get(j)) {
                    resultSet.add(i);
                }
            }
        }
        return resultSet;
    }


    // 합집합
    public MySet addAll(MySet set) {
        MySet resultSet = new MySet();
        for (int n : this.list) {
            resultSet.add(n);
        }
        for (int n : set.list) {
            resultSet.add(n);
        }
        return resultSet;
    }


    // 차집합
    public MySet removeAll(MySet set) {
        MySet resultSet = new MySet();

        for (int i = 0; i < this.list.size(); i++) {
            boolean flag = false;
            for (int j = 0; j < set.list.size(); j++) {
                if(this.list.get(i) == set.list.get(j)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                resultSet.list.add(this.list.get(i));
            }
        }

        return resultSet;
    }
}

public class Practice {
    public static void main(String[] args) {

//      Test code
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list);

        result = a.addAll(b);
        System.out.println("합집합: " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list);
    }
}
