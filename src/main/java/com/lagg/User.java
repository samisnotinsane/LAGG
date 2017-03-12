package com.lagg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by serem on 11/03/2017.
 * Self explanatory
 */
public class User {
    private String username, name;
    private HashMap<Topic, Integer> topicUnderstanding;
    private List<Learn> likedArticles;

    public User(String user, String realName) {
        this.username = user;
        this.name = realName;
        this.likedArticles = new ArrayList<>();
    }

    public void likeArticle(Learn l){
        likedArticles.add(l);
        l.addLikedBy(this);
    }
}
