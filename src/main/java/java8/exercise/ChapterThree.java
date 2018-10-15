package main.java.java8.exercise;

import main.java.java8.entity.Album;
import main.java.java8.entity.Artist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChapterThree {
    public static int sum(Stream<Integer> numbers){
        return numbers.reduce(0,(acc,x) -> acc + x);
    }

    public static List<String> getNameAndOrigin(List<Artist> artists){
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(),artist.getNationality()))
                .collect(Collectors.toList());
    }
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }
    public static Long getArtistMembersLessThanThree(List<Artist> artistList) {
        return artistList.stream().filter(artist -> artist.getMembers().count() <= 3).count();
    }
    public static int countBandMembersInternal(List<Artist> artists) {
        // NB: readers haven't learnt about primitives yet, so can't use the sum() method
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum)
                .intValue();

        //return (int) artists.stream().flatMap(artist -> artist.getMembers()).count();
    }
    public static void main(String[] args) {
//       System.out.println( sum(Arrays.asList(1,3,4,6).stream()));
//       System.out.println(getNameAndOrigin(Arrays.asList(new Artist("春风","中国"),new Artist("子光","美国"),new Artist("陈根","法国"))));
         Map<String,String> map = new HashMap<>();
         map.put("aa","aaa");
         map.put("bb","bbb");
         System.out.println(map);
    }



}
