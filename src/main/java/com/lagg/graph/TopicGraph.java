package com.lagg.graph;

import com.lagg.Topic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

/**
 * Created by serem on 11/03/2017.
 * The universe of all topics. This is a singleton class
 */
public class TopicGraph {
    private TopicGraph universe; // the singleton

    private HashSet<Topic> topics;
    private HashSet<TopicEdge> edges;

    private TopicGraph() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("Topics.in"));
            //load topics from a file


            in = new BufferedReader(new FileReader("Edges.in"));

        }
        catch(FileNotFoundException notfound) {
            notfound.printStackTrace();
        }


    }

    public TopicGraph getTopicsUniverse() {
        if(universe == null) {
            universe = new TopicGraph();
            return universe;
        }
        else return universe;
    }
}
