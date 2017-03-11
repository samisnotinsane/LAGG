package com.lagg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serem on 11/03/2017.
 * Node in the com.lagg.Topic Graph
 */
public class Topic {
    private String subfield;
    private String name;
    private List<Artefact> artefacts;

    public Topic(String base) {
    }

    public String getSubfield() {
        return subfield;
    }

    private String getName() {
        return name;
    }
}
