package com.lagg.graph;

import com.lagg.Artefact;
import com.lagg.Topic;

import java.io.*;
import java.util.*;

/**
 * Created by serem on 11/03/2017.
 * The universe of all topics. This is a singleton class
 */
public class TopicGraph implements TopicsGraphInterface {
    private static TopicGraph universe; // the singleton

    private static HashMap<String, Topic> topics;
    private HashSet<TopicEdge> edges;
    private HashMap<String, Artefact> artefacts;

    private TopicGraph() throws BadInputException {
        try {
            loadTopics("src/main/resources/Topics.in");
            loadEdges("src/main/resources/Edges.in");
            loadArtefacts("src/main/resources/Artefacts.in");
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

    public static Topic getTopic(String name) {
        return topics.get(name);
    }

    private void loadTopics(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        topics = new HashMap<>();

        //load topics from a file
        String line = in.readLine();

        while(line != null) {
            String[] fields = line.split(",");
            for(int i = 0; i < fields.length; i++)
                fields[i] = fields[i].trim();
            topics.put(fields[0], new Topic(fields[0], fields[1]));
            line = in.readLine();
        }
        in.close();
    }

    private void loadEdges(String filename) throws IOException, BadInputException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        edges = new HashSet<>();

        //load edges from a file
        String line = in.readLine();

        while(line != null) {
            String[] fields = line.split(",");
            for(int i = 0; i < fields.length; i++)
                fields[i] = fields[i].trim();
            addEdge(new TopicEdge(fields[0], fields[1], Integer.parseInt(fields[2])));
            line = in.readLine();
        }
        in.close();
    }

    private void loadArtefacts(String filename) throws IOException, BadInputException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        artefacts = new HashMap<>();

        //load artefacts from file
        String line = in.readLine();
        while(line != null) {
            String[] fields = line.split(";");
            for(int i = 0; i < fields.length; i++)
                fields[i] = fields[i].trim();
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

    /**
     * Run a Kruskal algorithm on the graph to find the minimum spanning tree
     * of the topics on a particular subfield
     * @param subfield The subfield we are interested in
     * @return A TopicSubgraph object that contains all the topics on a certain topic
     * and the recommended paths through them
     */
    public TopicSubgraph getTopics(String subfield) {
        HashMap<String, Topic> ts = new HashMap<>();
        HashMap<Topic, Integer> subset = new HashMap<>();
        List<TopicEdge> es = new ArrayList<>();
        HashSet<TopicEdge> finalEdges = new HashSet<>();
        int k = -1;

        //iterate through topics to find the ones on this subfield
        //create disjoint sets for kruskal at the same time
        for(Map.Entry<String, Topic> entry : this.topics.entrySet()) {
            if(entry.getValue().getSubfield().equals(subfield))
                ts.put(entry.getKey(), entry.getValue());
                subset.put(entry.getValue(), ++k);
        }

        //iterate through edges to find the ones inside this subset of nodes
        for(TopicEdge te : edges) {
            if(subset.get(te.getDestination()) != null)
                if(subset.get(te.getSource()) != null)
                   es.add(te);
        }

        //sort the list of edges
        Collections.sort(es, (e1, e2) -> {
            if(e1.getWeight() > e2.getWeight())
                return -1;
            else if(e1.getWeight() < e2.getWeight())
                return 1;
            else return 0;
        });

        //from this sorted list add to the final set those that connect disjoint graphs
        for(TopicEdge te : es) {
            if(!subset.get(te.getSource()).equals(subset.get(te.getDestination()))) {
                for(Map.Entry<Topic, Integer> node : subset.entrySet())
                    if(node.getValue().equals(subset.get(te.getDestination())))
                        node.setValue(subset.get(te.getSource()));

                finalEdges.add(te);
            }
        }

        return new TopicSubgraph(ts, finalEdges);
    }
}
