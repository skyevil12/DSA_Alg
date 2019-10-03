/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		List<MovieStaffData> movieDataList = new ArrayList<>();

		Map<String,ActorGraphNode> nameNodeMap = createActorConnection(movieDataList);

		ActorGraphNode baconNode = nameNodeMap.get("Bacon");
		baconNode.setBaconNumber(0);

		ActorGraphNode targetNode = nameNodeMap.get("Lisa");

		int baconNumber = findBaconNumber(baconNode,targetNode);

	}
	
	private static class MovieStaffData {
		private List<ActorGraphNode> actorList = new ArrayList<>();

		public void addActor(ActorGraphNode node) {
			actorList.add(node);
		}

		public List<ActorGraphNode> getActorList() {
			return actorList;
		}
	}

	private static class ActorGraphNode {
		private String name;

		private Set<ActorGraphNode> connectedSet = new HashSet<>();
		private int baconNumber = -1;

		public ActorGraphNode(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setBaconNumber(int baconNumber) {
			this.baconNumber = baconNumber;
		}

		public int getBaconNumber() {
			return baconNumber;
		}

		public void addConnection(ActorGraphNode node) {
			connectedSet.add(node);
		}

		public Set<ActorGraphNode> getConnectedSet() {
			return connectedSet;
		}
	}
	
	private static Map<String,ActorGraphNode> createActorConnection(List<MovieStaffData> movieDataList) {
		Map<String,ActorGraphNode> nameNodeMap = new HashMap<>();
		for(MovieStaffData data:movieDataList) {

			for(int i=0; i<data.getActorList().size(); i++) {
				ActorGraphNode node = data.getActorList().get(i);
				if(!nameNodeMap.containsValue(node)) {
					nameNodeMap.put(node.getName(),node);
				}

				for(int j=i+1; j<data.getActorList().size(); j++) {
					ActorGraphNode nodeToAdd = data.getActorList().get(j);
					node.addConnection(nodeToAdd);
					nodeToAdd.addConnection(node);
				}
			}
		}

		return nameNodeMap;
	}

	private static int findBaconNumber(ActorGraphNode baconNode,ActorGraphNode targetNode) {

		Set<ActorGraphNode> nextSetpSet = new HashSet<>();
		nextSetpSet.add(baconNode.getConnectedSet);
		return findBaconNumber(0,nextSetpSet,targetNode);
	}

	private static int findBaconNumber(int step,Set<ActorGraphNode> nodeSet,ActorGraphNode targetNode) {
		Set<ActorGraphNode> nextSetpSet = new HashSet<>();
		for(ActorGraphNode node:nodeSet) {

			if(node.getBaconNumber()!=-1) {
				continue;
			}

			node.setBaconNumber(step +1);
			if(node.equals(targetNode)) {
				return node.getBaconNumber();
			}

			nextSetpSet.addAll(node.getConnectedSet());
		}
		return findBaconNumber(++step,stnextSetpSet,targetNode);
	}

}