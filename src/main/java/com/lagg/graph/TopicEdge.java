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
            this.source = TopicGraph.getTopicsUniverse().getTopic(source);
            this.dest = TopicGraph.getTopicsUniverse().getTopic(dest);
            this.weight = wt;
        }
        catch(NullPointerException nullpt) {
            throw new BadInputException("Encoutered when building edge. No such node");
        }
    }
}
