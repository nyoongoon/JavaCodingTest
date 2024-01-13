package _Theory.Chapter2_Linear._14_선형자료구조_연습문제_2.src;

import java.util.*;

public class Practice3_ans_try {
    public static void solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>(List.of(i)));
            } else {
                map.get(genres[i]).add(i);
            }
        }

        while (!map.isEmpty()) {
            List<Song> maxSongList = new LinkedList<>();
            String maxGenre = "";
            int max = 0;
            for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
                List<Song> songList = new LinkedList<>();
                ArrayList<Integer> idList = entry.getValue();
                int sum = 0;

                for (int id : idList) {
                    sum += plays[id];
                    songList.add(new Song(id, plays[id]));
                }
                if (max < sum) {
                    max = sum;
                    maxGenre = entry.getKey();
                    maxSongList = songList;
                }
            }
            map.remove(maxGenre);

            maxSongList.sort((x, y) -> y.plays - x.plays);
            for (int i = 0; i < 2; i++) {
                System.out.print(maxSongList.get(i).id + " ");
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);

    }

    static class Song {
        int id;
        int plays;

        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
}
