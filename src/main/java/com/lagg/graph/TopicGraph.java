package com.lagg.graph;

/**
 * Created by serem on 11/03/2017.
 * The universe of all topics
 */
public class TopicGraph {
    private TopicGraph universe;

    private TopicGraph() {

    }

    public TopicGraph getTopicsUniverse() {
        if(universe == null) {
            universe = new TopicGraph();
            return universe;
        }
        else return universe;
    }

}
