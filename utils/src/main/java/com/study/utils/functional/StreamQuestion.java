package com.study.utils.functional;

import com.study.utils.entity.Album;
import com.study.utils.entity.Artist;
import com.study.utils.entity.Dog;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
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

    public static void SortTest() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog(3, "qq"));
        list.add(new Dog(20, "www"));
        list.add(new Dog(1, "ee"));

        System.out.println(list);
        list.sort((d1, d2) ->
                d2.getAge() - d1.getAge()
        );
        System.out.println(list);
        list.sort(Comparator.comparingInt(Dog::getAge));
        System.out.println(list);
    }

    public static void computedAges() {

        List<Dog> list =
                Arrays.asList(new Dog(3, "qq"), new Dog(20, "www"), new Dog(1, "ee"));
//        int computedAges1 = list.stream().reduce(0, (init, dog) -> init + dog.getAge());
        int computedAges = list.stream().reduce(0, (init, dog) -> init + dog.getAge(), Integer::sum);

    }

    public static <I, O> List<O> mapUsingReduce(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, x) -> {
            acc.add(mapper.apply(x));
            return acc;
        }, (ArrayList<O> left, ArrayList<O> right) -> {
            // We are copying left to new list to avoid mutating it.
            left.addAll(right);
            return left;
        });
    }

    public static <I> List<I> filterUsingReduce(Stream<I> stream, Predicate<I> predicate) {
        return stream.reduce(new ArrayList<>(), (acc, x) -> {
                    if (predicate.test(x)) {
                        acc.add(x);
                    }
                    return acc;
                }, (ArrayList<I> left, ArrayList<I> right) -> {
                    left.addAll(right);
                    return left;
                }
        );
    }

}
