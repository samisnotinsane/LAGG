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
    private HashSet<TopicEdge> activeOut, activeIn;

    public Topic(String name, String subfield, Set<Artefact> artefactSet) {
        this.name = name;
        this.subfield = subfield;
        artefacts = new HashSet<Artefact>(artefactSet);
        outbound = new HashSet<>();
        inbound = new HashSet<>();
        activeIn = new HashSet<>();
        activeOut = new HashSet<>();
    }

    public Topic(String name, String subfield) {
        this.name = name;
        this.subfield = subfield;
        artefacts = new HashSet<Artefact>();
        outbound = new HashSet<>();
        inbound = new HashSet<>();
        activeIn = new HashSet<>();
        activeOut = new HashSet<>();
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

    public HashSet<TopicEdge> getActiveIn() {
        return activeIn;
    }

    public HashSet<TopicEdge> getActiveOut() {
        return activeOut;
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

    public void activateIn(TopicEdge e) {
        if(inbound.contains(e))
            activeIn.add(e);
    }

    public void activateOut(TopicEdge e) {
        if(outbound.contains(e))
            activeOut.add(e);
    }

    public void deactivateIn(TopicEdge e) {
        if(activeIn.contains(e))
            activeIn.remove(e);
    }

    public void deactivateOut(TopicEdge e) {
        if(activeOut.contains(e))
            activeOut.remove(e);
    }

}
