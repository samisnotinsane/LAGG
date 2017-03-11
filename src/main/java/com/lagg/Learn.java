package com.lagg;

/**
 * Created by serem on 11/03/2017.
 * A piece of learning material
 */
public class Learn extends ArtefactType {
    private String type;
    private int rank;

    Learn(String type, String rankStr) {
        this.type = type;
        this.rank = Integer.parseInt(rankStr.trim());
    }
}
