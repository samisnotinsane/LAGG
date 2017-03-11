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
    }

    public Topic(String name, String subfield) {
        this.name = name;
        this.subfield = subfield;
        artefacts = new HashSet<Artefact>();
    }

    public String getSubfield() {
        return subfield;
    }

    private String getName() {
        return name;
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
