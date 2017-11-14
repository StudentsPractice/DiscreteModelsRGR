package edu.lpnu.discretemodels.rgr.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxFlowSolver {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;
  

    public MaxFlowSolver(FlowNetwork network, int source, int target) {
        // while there exists an increasing path, use it
        while (hasIncreasingPath(network, source, target)) {
            double minResidualCapacity = Double.POSITIVE_INFINITY;
            for (int v = target; v != source; v = edgeTo[v].othersideVertex(v)) {
                minResidualCapacity = Math.min(minResidualCapacity, edgeTo[v].residualCapacityTo(v));
            }
            
            // increase flow
            for (int v = target; v != source; v = edgeTo[v].othersideVertex(v)) {
                edgeTo[v].addResidualFlowTo(v, minResidualCapacity); 
            }
            value += minResidualCapacity;
        }
    }

    public double getMaximumFlowValue()  {
        return value;
    }

    private boolean hasIncreasingPath(FlowNetwork network, int source, int target) {
        edgeTo = new FlowEdge[network.getVertexNumber()];
        marked = new boolean[network.getVertexNumber()];

        // breadth-first search
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        marked[source] = true;
        while (!queue.isEmpty() && !marked[target]) {
            int firstVertex = queue.remove();

            for (FlowEdge edge : network.adjacencyList(firstVertex)) {
                int secondVertex = edge.othersideVertex(firstVertex);

                // if there is more capacity from v to w
                if (edge.residualCapacityTo(secondVertex) > 0) {
                    if (!marked[secondVertex]) {
                        edgeTo[secondVertex] = edge;
                        marked[secondVertex] = true;
                        queue.add(secondVertex);
                    }
                }
            }
        }
        return marked[target];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/vasyl/Desktop/test/input-lab3.txt"));
        FlowNetwork network = new FlowNetwork(in); 
        int vertexNumber = network.getVertexNumber(); 
        int source = 0;
        int target = vertexNumber - 1;

        MaxFlowSolver maxflow = new MaxFlowSolver(network, source, target);
        System.out.println("Max flow from " + source + " to " + target);
        for (int vertex = 0; vertex < network.getVertexNumber(); vertex++) {
            for (FlowEdge edge : network.adjacencyList(vertex)) {
                if (vertex == edge.from() && edge.flow() > 0) {
                	System.out.println("\t" + edge);
                }
            }
        }
        
        System.out.println();
        System.out.println("Max flow value = " +  maxflow.getMaximumFlowValue());
    }
}
