package com.study.utils.functional.chapter9;

import java.util.function.Consumer;

public interface ArtistAnalyzer {

    void isLargerGroup(String artistName,
                       String otherArtistName,
                       Consumer<Boolean> handler);
}
