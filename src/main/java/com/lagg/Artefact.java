package com.lagg;

import com.lagg.graph.BadInputException;

/**
 * Created by serem on 11/03/2017.
 * Parent class for com.lagg.Learn and com.lagg.Test. Every topic has a list of these.
 */
public class Artefact {
    private String name;
    private String link;
    private ArtefactType type;

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public Artefact(String base) throws BadInputException {
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
    }
}
