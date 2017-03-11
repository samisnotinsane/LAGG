package com.lagg;

/**
 * Created by serem on 11/03/2017.
 * A test hosted in a com.lagg.Topic.
 */
public class Test extends ArtefactType {
    private int difficulty;

    Test(String diff) {
        difficulty = Integer.parseInt(diff.trim());
    }
}
