package com.lagg;

import com.lagg.graph.TopicEdge;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by serem on 11/03/2017.
 * Node in the com.lagg.Topic Graph
 */
public class Topic {
    private String subfield;
    private String name;
    private HashSet<Artefact> artefacts;
    private HashSet<TopicEdge> outbound, inbound;

    public Topic(String name, String subfield, Set<Artefact> artefactSet) {
        this.name = name;
        this.subfield = subfield;
        artefacts = new HashSet<Artefact>(artefactSet);
        outbound = new HashSet<>();
        inbound = new HashSet<>();
    }

    public Topic(String name, String subfield) {
        this.name = name;
        this.subfield = subfield;
        artefacts = new HashSet<Artefact>();
        outbound = new HashSet<>();
        inbound = new HashSet<>();
    }

    public HashSet<Artefact> getArtefacts() {
        return artefacts;
    }

    public HashSet<TopicEdge> getOutbound() {
        return outbound;
    }

    public HashSet<TopicEdge> getInbound() {
        return inbound;
    }

    public String getSubfield() {
        return subfield;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", subfield='" + subfield + '\'' +
                '}';
    }

    public void addArtefact(Artefact a) {
        artefacts.add(a);
    }

    public void addInboundEdge(TopicEdge e) {
        inbound.add(e);
    }

    public void addOutboundEdge(TopicEdge e) {
        outbound.add(e);
    }

}
