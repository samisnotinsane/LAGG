package com.lagg.graph;

import com.lagg.Topic;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Created by serem on 11/03/2017.
 * A subgraph of the topic graph
 */
public class TopicSubgraph {
    private HashSet<TopicEdge> edges;
    private HashMap<String, Topic> topics;

    public HashSet<TopicEdge> getEdges() {
        return new HashSet<TopicEdge>(edges);
    }

    public HashMap<String, Topic> getTopics() {
        return new HashMap<String, Topic>(topics);
    }

    protected TopicSubgraph(HashMap<String, Topic> t, HashSet<TopicEdge> e) {
        topics = t;
        edges = e;
    }
}
