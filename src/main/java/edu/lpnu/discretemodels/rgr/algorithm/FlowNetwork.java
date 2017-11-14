package edu.lpnu.discretemodels.rgr.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class FlowNetwork {
	private static final String NEWLINE = System.getProperty("line.separator");

    private final int vertexNumber;
    private int edgeNumber;
    private ArrayList<FlowEdge>[] adjacencyList;
    

    @SuppressWarnings("unchecked")
	public FlowNetwork(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        this.edgeNumber = 0;
        adjacencyList = (ArrayList<FlowEdge>[]) new ArrayList[vertexNumber];
        for (int vertex = 0; vertex < vertexNumber; vertex++)
            adjacencyList[vertex] = new ArrayList<FlowEdge>();
    }

    public FlowNetwork(Scanner in) {
        this(in.nextInt());
        int edgeNumber = in.nextInt();
        for (int i = 0; i < edgeNumber; i++) {
            int firstVertex = in.nextInt();
            int secondVertex = in.nextInt();
            double capacity = in.nextDouble();
            addEdge(new FlowEdge(firstVertex, secondVertex, capacity));
        }
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adjacencyList[v].add(e);
        adjacencyList[w].add(e);
        edgeNumber++;
    }
    
    public Iterable<FlowEdge> adjacencyList(int v) {
        return adjacencyList[v];
    }

    public Iterable<FlowEdge> edges() {
        ArrayList<FlowEdge> list = new ArrayList<FlowEdge>();
        for (int v = 0; v < vertexNumber; v++)
            for (FlowEdge e : adjacencyList(v)) {
                if (e.to() != v)
                    list.add(e);
            }
        return list;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertexNumber + " " + edgeNumber + NEWLINE);
        for (int v = 0; v < vertexNumber; v++) {
            s.append(v + ":  ");
            for (FlowEdge e : adjacencyList[v]) {
                if (e.to() != v) s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/vasyl/Desktop/test/input-lab3.txt"));
    	in.useLocale(Locale.US);
        try {
	        FlowNetwork G = new FlowNetwork(in);
	        System.out.println(G);
        } catch (InputMismatchException e) {
			e.printStackTrace();
		}
    }
}
