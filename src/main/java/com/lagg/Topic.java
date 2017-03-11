package com.lagg;

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

    public Topic(String name, String subfield, Set<Artefact> artefactSet) {
        this.name = name;
        this.subfield = subfield;
        artefacts = new HashSet<Artefact>(artefactSet);
    }

    public String getSubfield() {
        return subfield;
    }

    private String getName() {
        return name;
    }
}
