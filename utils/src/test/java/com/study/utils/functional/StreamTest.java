package com.study.utils.functional;

import com.study.utils.entity.Album;
import com.study.utils.entity.Artist;
import com.study.utils.entity.Track;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StreamTest {

    @Test
    public void addUp() {
        List<Integer> list = List.of(1, 2, 3, 6);
        int i = StreamQuestion.addUp(list);
        System.out.println(i);
        assertEquals(12, i);
    }

    @Test
    public void getNamesAndOrigins() {
        List<Artist> list = List.of(new Artist("ww", "ll"), new Artist("ll", "ll"));
        System.out.println(StreamQuestion.getNamesAndOrigins(list));
    }

    @Test
    public void getAlbumsWithAtMostThreeTracks() {
        List<Track> trackLists = List.of(new Track("ww"), new Track("ll"), new Track("mm"));
        List<Track> tracks = List.of(new Track("ww"), new Track("ll"), new Track("mm"), new Track("dfs"));
        Album album = new Album();
        album.setTrackList(trackLists);

        Album album1 = new Album();
        album1.setTrackList(tracks);

        List<Album> albums = new ArrayList<>();
        albums.add(album);
        albums.add(album1);

        System.out.println(StreamQuestion.getAlbumsWithAtMostThreeTracks(albums));


    }

    @Test
    public void SortTest(){
        StreamQuestion.SortTest();
    }

}
