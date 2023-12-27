package _Theory.Chapter2_Linear.LinearDS_14_2.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice3_ans {

    public static void main(String[] args) {
        // Test code
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);

    }

    public static void solution(String[] genres, int[] plays) {
        // 공부할 점 2가지 블로그에 쓸 것! -> ArrayList Comparator 정렬, Map.Entry

        Map<String, ArrayList<Song>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Song song = new Song(i, plays[i]);
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>(List.of(song)));
            } else {
                ArrayList<Song> songList = map.get(genres[i]);
                int idx = -1;
                for (int j = 0; j < songList.size(); j++) {
                    if (songList.get(j).plays < song.plays ||
                            songList.get(j).plays == song.plays && songList.get(i).id > song.id) {
                        idx = j;
                        break;
                    }

                }
                if (idx == -1) {
                    songList.add(song);
                } else {
                    songList.add(idx, song); // 내림차순
                }
            }
        }

        Map<String, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int sum = sumMap.getOrDefault(genres[i], 0);
            sumMap.put(genres[i], sum + plays[i]);
        }

        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(sumMap.entrySet());
        entryList.sort((x, y) -> y.getValue() - x.getValue());

        for (int i = 0; i < entryList.size(); i++) {
            String genre = entryList.get(i).getKey();
            ArrayList<Song> songList = map.get(genre);
            for (int j = 0; j < 2; j++) {
                System.out.print(songList.get(j).id + " ");
            }
        }

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
