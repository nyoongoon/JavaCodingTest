package _0_Theory.Chapter4_Algorithm._09_그리디.src;// 알고리즘 - 그리디 알고리즘
// Activity Selection Problem

import java.util.ArrayList;
import java.util.Comparator;

class Activity {
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void selectActivity(ArrayList<Activity> list) {
        ArrayList<String> result = new ArrayList<>();
        // 종료시간 기준 오름차순 정렬
        list.sort(Comparator.comparingInt(x -> x.end));
        int curTime = 0;
        for(Activity activity : list){
            if(curTime <= activity.start){
                curTime = activity.end;
                result.add(activity.name);
            }
        }

        result.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        // Test code
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity("A", 1, 5));
        list.add(new Activity("B", 4, 5));
        list.add(new Activity("C", 2, 3));
        list.add(new Activity("D", 4, 7));
        list.add(new Activity("E", 6, 10));
        selectActivity(list);
    }
}
