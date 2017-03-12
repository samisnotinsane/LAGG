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

    public HashSet<Topic> findEntryPoints() {
        HashSet<Topic> entryPoints = new HashSet<>();
        for(Map.Entry<String, Topic> topicEntry : topics.entrySet()) {
            if(topicEntry.getValue().getActiveIn().isEmpty())
                entryPoints.add(topicEntry.getValue());
        }
        return entryPoints;
    }

    public HashSet<Topic> findChildren(Topic topic) {
        HashSet<Topic> result = new HashSet<>();
        for(TopicEdge te : topic.getActiveOut()) {
            if(topics.containsValue(te.getDestination()))
                result.add(te.getDestination());
        }
        return result;
    }

    public HashSet<Topic> findPrerequisites(Topic topic) {
        HashSet<Topic> result = new HashSet<>();
        for(TopicEdge te : topic.getActiveIn()) {
            if(topics.containsValue(te.getSource()))
                result.add(te.getSource());
        }
        return result;
    }

    protected TopicSubgraph(HashMap<String, Topic> t, HashSet<TopicEdge> e) {
        topics = t;
        edges = e;

        for(TopicEdge te : e) {
            te.getSource().activateOut(te);
            te.getDestination().activateIn(te);
        }
    }

    public void print() {
        for(Map.Entry<String, Topic> topicEntry : topics.entrySet())
            System.out.println(topicEntry.getValue().toString());

        System.out.println("\n\n");

        for(TopicEdge te : edges)
            System.out.println(te.toString());
    }
}
