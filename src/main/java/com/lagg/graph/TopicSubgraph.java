package com.lagg.graph;

import com.lagg.Topic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


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

    public void print() {
        for(Map.Entry<String, Topic> topicEntry : topics.entrySet())
            System.out.println(topicEntry.getValue().toString());

        System.out.println("\n\n");

        for(TopicEdge te : edges)
            System.out.println(te.toString());
    }
}
