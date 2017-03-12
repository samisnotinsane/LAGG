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
            for(int i = 0; i < attributes.length; i++)
                attributes[i] = attributes[i].trim();
            name = attributes[0];
            link = attributes[1];
            if(attributes[2].equals("Learn"))
                type = new Learn(attributes[3], attributes[4]);
            else if (attributes[2].equals("Test"))
                type = new Test(attributes[3]);
            else throw new BadInputException("wrong artefact type");

            this.topics = new HashSet<>();

            String[] topicNames = topics.split(",");
            for(int i = 0; i < topicNames.length; i++) {
                try {
                    topicNames[i] = topicNames[i].trim();
                    this.topics.add(TopicGraph.getTopic(topicNames[i]));
                }
                catch(NullPointerException nullpt) {
                    throw new BadInputException("inexistent topic " + topicNames[i]);
                }
            }
    }
}
