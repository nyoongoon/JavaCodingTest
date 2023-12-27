package _Theory.Chapter2_Linear.LinearDS_14_2.src;

import java.util.*;

public class Practice3 {
    public static void solution(String[] genres, int[] plays) {
        List<Integer> list = new LinkedList<>();
        Map<String, Genres> map = new HashMap<>(); // set -> map-
        for (int i = 0; i < genres.length; i++) {
            Genres genre;
            Song song = new Song(i, plays[i]);
            if (!map.containsKey(genres[i])) {
                genre = new Genres(genres[i]);
                map.put(genres[i], genre);
            } else {
                genre = map.get(genres[i]);
            }
            genre.total += plays[i];
            genre.setSongs(song);
        }

        PriorityQueue<Genres> queue = new PriorityQueue<>();


        for (String s : map.keySet()) {
            queue.add(map.get(s));
        }

        while (!queue.isEmpty()) {
            Genres resultGenre = queue.poll();

            System.out.println("songs size == " + resultGenre.songs.size());

            list.add(resultGenre.getSong().id);
            list.add(resultGenre.getSong().id);
        }

        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String[] args) {
        // Test code
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);

    }

    static class Song implements Comparable<Song> {
        int id;
        int playTimes;

        Song(int id, int playTimes) {
            this.id = id;
            this.playTimes = playTimes;
        }

        @Override
        public int compareTo(Song song) {
            if (this.playTimes > song.playTimes) {
                return -1;
            } else if (this.playTimes < song.playTimes) {
                return 1;
            } else {

                if(this.id > song.id){
                    return 1;
                }else if(this.id < song.id){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

    static class Genres implements Comparable {
        PriorityQueue<Song> songs = new PriorityQueue<>();
        String name;
        int total;

        Genres(String name) {
            this.name = name;
        }

        public void setSongs(Song song) {
            songs.add(song);
        }

        public Song getSong() {
            return songs.poll();
        }

        @Override
        public int compareTo(Object o) {
            if (this.total > ((Genres) o).total) {
                return -1;
            } else if (this.total < ((Genres) o).total) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
