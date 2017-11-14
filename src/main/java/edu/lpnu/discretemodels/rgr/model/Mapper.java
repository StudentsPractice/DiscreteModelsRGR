package edu.lpnu.discretemodels.rgr.model;

import java.util.ArrayList;

import edu.lpnu.discretemodels.rgr.algorithm.FlowEdge;
import edu.lpnu.discretemodels.rgr.algorithm.FlowNetwork;

public class Mapper {
	
	public static String[][] graphArrayToTable(int[][] array) {
		int nodeAmount = array.length;
		
		String[][] table = new String[nodeAmount + 1][nodeAmount + 1];
		table[0][0] = "";
		for (int i = 0; i < nodeAmount; i++) {
			table[i + 1][0] = i + 1 + "";
			table[0][i + 1] = i + 1 + "";
			for (int j = 0; j < nodeAmount; j++) {
				table[i+1][j+1] = array[i][j] + "";
			}
		}
		return table;
	}
	
	public static String networkToJson(FlowNetwork graph) {
		StringBuilder result = new StringBuilder("{\"nodes\": [");
		
		ArrayList<Node> nodes = new ArrayList<>(graph.getVertexNumber());
		ArrayList<Edge> edges = new ArrayList<>(graph.getVertexNumber());
		int edgeNum = 0;
		for (int i = 0; i < graph.getVertexNumber(); i++) {
			Node node = new Node();
			node.setId("" + i);
			node.setLabel("" + i);
			nodes.add(node);
			
			for (FlowEdge flowEdge : graph.adjacencyList(i)) {
				if (flowEdge.othersideVertex(i) >= i) {
					Edge edge = new Edge("e" + edgeNum, "" + i, "" + flowEdge.othersideVertex(i), flowEdge.flow() + "/" + flowEdge.capacity());
					edges.add(edge);
					edgeNum++;
				}
			}
		}
		for (Node node: nodes) {
			result.append(node.getJsonString()).append(',');
		}
		result.deleteCharAt(result.length() - 1);
		result.append("],").append("\"edges\": [");
		
		for (Edge edge : edges) {
			result.append(edge.getJsonString()).append(',');
		}
		result.deleteCharAt(result.length()-1);
		result.append(" ]}");
		
		return result.toString();
	}
	
	
}
