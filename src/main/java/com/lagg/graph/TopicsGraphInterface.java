package com.lagg.graph;

import com.lagg.Artefact;

/**
 * Created by serem on 11/03/2017.
 */
public interface TopicsGraphInterface {
    TopicSubgraph getTopics(String subfield);
    void addArtefact(Artefact a);
}
