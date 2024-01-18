package _Theory.Chapter3_NonLinear._11_우선순위큐.src;// Practice 1
// 자바 기본 PriorityQueue 응용
// 나이 순으로 오름차순 또는 내림차순 출력


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        // 오름차순
        // o는 this의 이전 인덱스로 생각하기 !
        // 오름차순 -> this가 더 크므로 this - o는 양수 !
        return this.age - o.age >= 0 ? 1 : -1;
    }
}

public class Practice1 {
    public static void solution(String[] name, int[] age) {
        // 1. Comparable 방식 !
        PriorityQueue<Person> pq = new PriorityQueue<>();
        IntStream.range(0, name.length)
                .forEach((i) -> pq.add(new Person(name[i], age[i])));
        int size = pq.size();
        while (!pq.isEmpty()) {
            System.out.print(pq.poll().name + " ");
        }
        System.out.println();
        // 2. Comparator 방식 ! -> 정렬 로직은 같다..
        PriorityQueue<Person> pq2 = new PriorityQueue<>((x, y) -> x.age - y.age >= 0 ? 1 : -1);
        IntStream.range(0, name.length)
                .forEach((i) -> pq2.add(new Person(name[i], age[i])));
        while (!pq2.isEmpty()) {
            System.out.print(pq2.poll().name + " ");
        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

    }
}
