package com.study.utils.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Album {

    private List<Track> trackList;
}
