package com.lagg.graph;

import com.lagg.Artefact;
import com.lagg.Topic;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by serem on 11/03/2017.
 * The universe of all topics. This is a singleton class
 */
public class TopicGraph implements TopicsGraphInterface {
    private static TopicGraph universe; // the singleton

    private HashMap<String, Topic> topics;
    private HashSet<TopicEdge> edges;
    private HashMap<String, Artefact> artefacts;

    private TopicGraph() throws BadInputException {
        try {
            loadTopics("Topics.in");
            loadEdges("Edges.in");
            loadArtefacts("Artefacts.in");
        }
        catch(IOException notfound) {
            notfound.printStackTrace();
        }


    }

    public static TopicGraph getTopicsUniverse() {
        if(universe == null) {
            try {
                universe = new TopicGraph();
                return universe;
            }
            catch(BadInputException bie) {
                bie.printStackTrace();
                return null;
            }
        }
        else return universe;
    }

    public Topic getTopic(String name) {
        return topics.get(name);
    }

    private void loadTopics(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));

        //load topics from a file
        String line = in.readLine();

        while(line != null) {
            String[] fields = line.split(",");
            for(String s : fields)
                s = s.trim();
            topics.put(fields[0], new Topic(fields[0], fields[1]));
            line = in.readLine();
        }
        in.close();
    }

    private void loadEdges(String filename) throws IOException, BadInputException {
        BufferedReader in = new BufferedReader(new FileReader(filename));

        //load edges from a file
        String line = in.readLine();

        while(line != null) {
            String[] fields = line.split(",");
            for(String s : fields)
                s = s.trim();
            addEdge(new TopicEdge(fields[0], fields[1], Integer.parseInt(fields[2])));
            line = in.readLine();
        }
        in.close();
    }

    private void loadArtefacts(String filename) throws IOException, BadInputException {
        BufferedReader in = new BufferedReader(new FileReader(filename));

        //load artefacts from file
        String line = in.readLine();
        while(line != null) {
            String[] fields = line.split(";");
            for(String s : fields)
                s = s.trim();
            addArtefact(new Artefact(fields[0], fields[1]));
            line = in.readLine();
        }
    }

    private void addEdge(TopicEdge e) {
        edges.add(e);
        e.getDestination().addInboundEdge(e);
        e.getSource().addOutboundEdge(e);
    }

    public void addArtefact(Artefact a) {
        artefacts.put(a.getName(), a);
        for(Topic t : a.getTopics())
            t.addArtefact(a);
    }

    public TopicSubgraph getTopics(String subfield) {
        return null;
    }
}
