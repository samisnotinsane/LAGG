package com.lagg;

import com.lagg.graph.BadInputException;
import com.lagg.graph.TopicGraph;

import java.util.HashSet;

/**
 * Created by serem on 11/03/2017.
 * Parent class for com.lagg.Learn and com.lagg.Test. Every topic has a list of these.
 */
public class Artefact {
    private String name;
    private String link;
    private ArtefactType type;
    private HashSet<Topic> topics;

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public HashSet<Topic> getTopics() {
        return new HashSet<Topic>(topics);
    }

    public boolean isLearn() {
        return(type instanceof Learn);
    }

    public boolean isTest() {
        return(type instanceof Test);
    }

    public Artefact(String base, String topics) throws BadInputException {
            String[] attributes = base.split(",");
            for (String s : attributes)
                s = s.trim();
            name = attributes[0];
            link = attributes[1];
            if(attributes[2] == "Learn")
                type = new Learn(attributes[3], attributes[4]);
            else if (attributes[2] == "Test")
                type = new Test(attributes[3]);
            else throw new BadInputException("wrong artefact type");

            String[] topicNames = topics.split(",");
            for(String s : topicNames) {
                try {
                    s = s.trim();
                    this.topics.add(TopicGraph.getTopicsUniverse().getTopic(s));
                }
                catch(NullPointerException nullpt) {
                    throw new BadInputException("inexistent topic " + s);
                }
            }
    }
}
