package edu.lpnu.discretemodels.rgr.algorithm;

public class FlowEdge {

    private final int vertexFrom;
    private final int vertexTo;
    private final double capacity;
    private double flow;

    public FlowEdge(int firstVertex, int secondVertex, double capacity) {
        this.vertexFrom = firstVertex;
        this.vertexTo = secondVertex;  
        this.capacity = capacity;
        this.flow = 0.0;
    }

   
    public FlowEdge(int firstVertex, int secondVertex, double capacity, double flow) {
        this.vertexFrom = firstVertex;
        this.vertexTo = secondVertex;  
        this.capacity = capacity;
        this.flow = flow;
    }

    public int from() {
        return vertexFrom;
    }  

    public int to() {
        return vertexTo;
    }  

    public double capacity() {
        return capacity;
    }

    public double flow() {
        return flow;
    }

    public int othersideVertex(int vertex) {
        if (vertex == vertexFrom) {
        	return vertexTo;
        } else if (vertex == vertexTo) {
        	return vertexFrom;
        } else {
        	throw new IllegalArgumentException("invalid endpoint");
        }
    }

    public double residualCapacityTo(int vertex) {
        if (vertex == vertexFrom) {
        	return flow;              // backward edge
        } else if (vertex == vertexTo) {
        	return capacity - flow;   // forward edge
        } else {
        	throw new IllegalArgumentException("invalid endpoint");
        }
    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (!(delta >= 0.0)) {
        	throw new IllegalArgumentException("Delta must be nonnegative");
        }

        if (vertex == vertexFrom) {
        	flow -= delta;           // backward edge
        } else if (vertex == vertexTo)   {
        	flow += delta;           // forward edge
        } else {
        	throw new IllegalArgumentException("invalid endpoint");
        }
    }


    public String toString() {
        return vertexFrom + " - " + vertexTo + "  " + flow + "/" + capacity;
    }
}
