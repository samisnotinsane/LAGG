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
public class TopicGraph {
    private static TopicGraph universe; // the singleton

    private HashMap<String, Topic> topics;
    private HashSet<TopicEdge> edges;

    private TopicGraph() throws BadInputException {
        try {
            BufferedReader in = new BufferedReader(new FileReader("Topics.in"));

            //load topics from a file
            String line = in.readLine();

            while(line != null) {
                String[] fields = line.split(",");

                for(String s : fields)
                    s = s.trim();

                int n = Integer.parseInt(fields[fields.length-1].trim()); //number of artefacts to read
                HashSet<Artefact> artefacts = new HashSet<Artefact>(); //make a new set
                line = in.readLine();
                for(int i = 0; i < n && line != null; i++) {
                    artefacts.add(new Artefact(line)); //add all of the artefacts to the
                    line = in.readLine();
                }

                topics.put(fields[0], new Topic(fields[0], fields[1], artefacts));

            }
            in.close();

            in = new BufferedReader(new FileReader("Edges.in"));
            line = in.readLine();
            while(line != null) {
                String[] fields = line.split(",");
                edges.add(new TopicEdge(fields[0].trim(), fields[1].trim(), Integer.parseInt(fields[2].trim())));
            }

            in.close();
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

    Topic getTopic(String name) {
        return topics.get(name);
    }
}
