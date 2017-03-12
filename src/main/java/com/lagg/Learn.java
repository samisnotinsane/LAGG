package com.lagg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serem on 11/03/2017.
 * A piece of learning material
 */
public class Learn extends ArtefactType {
    private String type;
    private int rank;
    private List<User> likedBy;

    Learn(String type, String rankStr) {
        this.type = type;
        this.rank = Integer.parseInt(rankStr.trim());
        likedBy = new ArrayList<>();
    }

    public void addLikedBy(User u){
        likedBy.add(u);
    }

    public List<User> getLikedBy() {
        return new ArrayList<>(likedBy);
    }
}
