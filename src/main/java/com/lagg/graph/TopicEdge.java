package com.lagg.graph;

import com.lagg.Topic;

/**
 * Created by serem on 11/03/2017.
 * Edge for the com.lagg.Topic Graph
 */
public class TopicEdge {
    private Topic source;
    private Topic dest;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public Topic getSource() {
        return source;
    }

    public Topic getDestination() {
        return dest;
    }

    TopicEdge(String source, String dest, int wt) throws BadInputException {
        try {
            this.source = TopicGraph.getTopic(source);
            this.dest = TopicGraph.getTopic(dest);
            this.weight = wt;
        }
        catch(NullPointerException nullpt) {
            throw new BadInputException("Encoutered when building edge. No such node");
        }
    }

    public TopicEdge getReverse() {
        for(TopicEdge topicEdge : getDestination().getOutbound())
            if(topicEdge.getDestination() == source)
                return topicEdge;
        return null;
    }

    @Override
    public String toString() {
        return "TopicEdge{" +
                source.getName() +
                ", " + dest.getName() +
                ", " + weight +
                '}';
    }
}
