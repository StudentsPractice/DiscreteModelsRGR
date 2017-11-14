package edu.lpnu.discretemodels.rgr.service;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.Part;

import org.springframework.stereotype.Service;

import edu.lpnu.discretemodels.rgr.algorithm.FlowEdge;
import edu.lpnu.discretemodels.rgr.algorithm.FlowNetwork;
import edu.lpnu.discretemodels.rgr.algorithm.MaxFlowSolver;
import edu.lpnu.discretemodels.rgr.model.Mapper;

@Service
public class MainService {

	private MaxFlowSolver solver;
	private double maxFlowValue;
	private FlowNetwork network;
	
	public void makeCalculation(Part inputDataFile) throws IOException {
		Scanner scanner = new Scanner(inputDataFile.getInputStream());
		network = new FlowNetwork(scanner);
		solver = new MaxFlowSolver(network, 0, network.getVertexNumber() - 1);
		maxFlowValue = solver.getMaximumFlowValue();
	}

	public Map<String, String> getEdgesFlow() {
		Map<String, String> edgesFlow = new HashMap<>();
		for (FlowEdge edge : network.edges()) {
			edgesFlow.put(edge.from() + " - " + edge.to(), edge.flow() + " / " + edge.capacity());
		}
		return edgesFlow;
	}

	public double getMaxFlowValue() {
		return maxFlowValue;
	}

	public String getJsonForInputMatrix() {
		return Mapper.networkToJson(network);
	}
	
}
