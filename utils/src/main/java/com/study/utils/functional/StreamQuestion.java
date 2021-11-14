package com.study.utils.functional;

import com.study.utils.entity.Album;
import com.study.utils.entity.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestion {

    public static int addUp(List<Integer> list) {
        return list.stream().reduce(0, (acc, x) -> acc + x);
    }

    public static List<String> getNamesAndOrigins(List<Artist> list) {
        return list.stream()
//                .map(artist -> artist.getName() + " " + artist.getNationality())
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> list) {
        return list.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }

    public static long countLowercaseLetters(String s) {
        return s.chars().filter(Character::isLowerCase).count();
    }

    public static Optional<String> mostLowercaseString(List<String> stringList) {
        return stringList.stream()
                .max(Comparator.comparingLong(StreamQuestion::countLowercaseLetters));
    }

}
