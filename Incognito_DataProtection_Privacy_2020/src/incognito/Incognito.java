package incognito;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import data.DataReader;

public class Incognito {

	// input
	LinkedList<Table> T = new LinkedList<Table>();
    LinkedList<Table> lockedT = new LinkedList<Table>();
	int Qi; // Qi numbers
	LinkedList<Node> Ci; 
	HashMap<Node,LinkedList<Node>> Ei;
	DataReader data;
	int k;
	
	// output
	LinkedList<Table> kanonymousedT = new LinkedList<Table>();
	
	public Incognito(LinkedList<Table> T, HashMap<Node,LinkedList<Node>> Ei, LinkedList<Node> Ci, int k, int Qi, DataReader data) {
		this.Qi = Qi;
		this.T  = T;
		this.lockedT = new LinkedList<Table>(T);
		this.Ei = Ei;
		this.Ci = Ci;
		this.k = k;
		this.data = data;
	}
	
	// Si,x -> tabella anonimizzatrice 14100 1410* 141** 14*** 1**** *****
	//			genericamente		    Si0   Si1   Si2   Si3   Si4   Si5
	// queue 
	
	public void anonymize(int Qi) {
		LinkedList<Node> goodNodes = new LinkedList<Node>();
		int frequencySet = -1;
		Queue<Node> queue;	
		long start = System.currentTimeMillis();
		//for(int i = 1; i <= Qi; i++) {
		//	LinkedList<Node> Si = new LinkedList<Node>(Ci);
			LinkedList<Node> roots = calculateRootsNodes(Ei.keySet());
			queue = roots; //controllare che la coda sia ordinata per altezza
			queue = orderQueue(queue);
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				//if(!node.isMark()) {
					if(node.isRoot()) {
						frequencySet = computeFrequencySetOfT();
					}
					else {
						frequencySet = computeFrequencySetOfT(node, Qi);
					}
					// Use frequencySet to check k-anonymity with respect to attributes of node
					if(frequencySet >= k) {// if T is k-anonymous with respect to attributes of Node
						queue = markNodes(node, queue);
						//queue = updateQueue(queue);
						orderQueue(queue);
						node.setIsKAnonyminzated(frequencySet);
						if(!goodNodes.contains(node))
							goodNodes.add(node);
					}
					else {
						queue.addAll(directGeneralizationOfNode(node, queue));
						orderQueue(queue);
					}
				//}
			}
		//}
		long end = System.currentTimeMillis();
		
		printResults(start, end, this.k, this.Qi, T.size(), goodNodes);
	}
	
	private Queue<Node> markNodes(Node node, Queue<Node> queue) {
		
		if(Ei.containsKey(node)) {
			for(Node n : Ei.get(node)) {
				Ei.remove(n);
			}
		}
		LinkedList<Node> temp = new LinkedList<Node>(queue);
		for(int i = 0; i < temp.size(); i++)
			if(node.getHeight()<temp.get(i).getHeight())
				temp.remove(i);
		return temp;
	}

	private void printResults(long start, long end, int k, int Qi, int nRecords, LinkedList<Node> goodNodes) {
		String output = "";
		double durata = (end - start);
		output = "----------Incognito----------\n\n";
		output += "++Informations++ \n";
		output += "DB size: "+nRecords+" elements.\nK-anonymize request: "+k+"\n";
		output += "Number of Q-Identifier attributs: "+Qi+"\n\n";
		output += "++Results++\n";
		output += "Processing time: "+(int) durata+"mins\n";
		output += "Better Node/s:\n";
		LinkedList<Node> ordinata = new LinkedList<Node>();
		while(!goodNodes.isEmpty()) {
			int min=goodNodes.get(0).getHeight();
			Node nodeMin = goodNodes.get(0);
			for(Node n : goodNodes) {
				if(min > n.getHeight()) {
					nodeMin = n;
					min = nodeMin.getHeight();
				}
			}
			goodNodes.remove(nodeMin);
			ordinata.add(nodeMin);
		}
		for(Node n : ordinata) {
			output +=n.toString(Qi);
		}
		System.out.println(output);
	}
	

	/**
	 * All nodes in Ci with no edge in Ei directed to them.
	 * @param Ei - LinkedList<Edge>
	 * @param Ci - LinkedList<Node>
	 * @return roots - LinkedList<Node>
	 */
	private LinkedList<Node> calculateRootsNodes(Set<Node> Ci){
		LinkedList<Node> roots = new LinkedList<Node>();
		for(Node n : Ci) {
			if(n.isRoot())
				roots.add(n);
		}
		return roots;
	}
	
	/**
	 * Compute frequency set of T with respect to attributes of node using T.
	 * @return table's original frequency set - int
	 */
	private int computeFrequencySetOfT() {
		
		LinkedList<Table> tempT = new LinkedList<Table>(T);
		HashMap<Table,Integer> counter = new HashMap<Table, Integer>();
		for(Table record : tempT) {
			if(counter.containsKey(record)) {
				counter.replace(record, counter.get(record), counter.get(record)+1);
			}
			else {
				counter.put(record, 1);
			}
		}
		
		LinkedList<Integer> values = new LinkedList<Integer>(counter.values());
		int min = values.get(0);
		for(Integer i : values) {
			if(min > i) {
				min = i;
			}
		}
		return min;
	}
	
	/**
	 * Compute frequency set of T with respect to attributes of node using parent's frequency set.
	 * @param node - Node
	 * @return
	 */
	private int computeFrequencySetOfT(Node node, int Qi) {

		LinkedList<Table> tempT = anonymizeT(node, Qi);
		HashMap<Table,Integer> counter = new HashMap<Table, Integer>();
		for(Table record : tempT) {
			if(counter.containsKey(record)) {
				counter.replace(record, counter.get(record), counter.get(record)+1);
			}
			else {
				counter.put(record, 1);
			}
		}
		LinkedList<Integer> values = new LinkedList<Integer>(counter.values());
		int min = values.get(0);
		for(Integer i : values) {
			if(min > i) {
				min = i;
			}
		}
		
		return min;
	}
	
	private LinkedList<Table> anonymizeT(Node node, int Qi){
		LinkedList<Table> tempT = new LinkedList<Table>(DataReader.getOriginalT(Qi));
		HashMap<String, LinkedList<String>> dependencyTree = new HashMap<String, LinkedList<String>>(data.getDependencyTree());
		LinkedList<Table> outputTable = new LinkedList<Table>();
		for(Table record : tempT) {
			if(node.getBirthday() > 0) {
				String birthday = dependencyTree.get(record.getBirthday()).get(node.getBirthday()-1);
				record.setBirthday(birthday);
			}
			if(node.getSex() > 0) {
				String sex = dependencyTree.get(record.getSex()).get((node.getSex()-1));
				record.setSex(sex);
			}
			if(node.getZipcode()>0) {
				String zipcode = dependencyTree.get(record.getZipcode()).get(node.getZipcode()-1);
				record.setZipcode(zipcode);
			}
			if(node.getNazionalita()>0) {
				String nazionalita = dependencyTree.get(record.getNazionalita()).get(node.getNazionalita()-1);
				record.setNazionalita(nazionalita);
			}
			if(node.getProfessione()>0) {
				String professione = dependencyTree.get(record.getProfessione()).get(node.getProfessione()-1);
				record.setProfessione(professione);
			}
			if(node.getStipendio()>0) {
				String stipendio = dependencyTree.get(record.getStipendio()).get(node.getStipendio()-1);
				record.setStipendio(stipendio);
			}
			if(node.getFigli()>0) {
				String figli = dependencyTree.get(record.getFigli()).get(node.getFigli()-1);
				record.setFigli(figli);
			}
			if(node.getStatoCivile()>0) {
				String statoCivile = dependencyTree.get(record.getStatoCivile()).get(node.getStatoCivile()-1);
				record.setStatoCivile(statoCivile);
			}
			if(node.getTitoloStudio()>0) {
				String titoloStudio = dependencyTree.get(record.getTitoloStudio()).get(node.getTitoloStudio()-1);
				record.setTitoloStudio(titoloStudio);
			}
			outputTable.add(record);
		}
		return outputTable;
	}
	
	/**
	 * order a queue by height
	 */
	private Queue<Node> orderQueue(Queue<Node> queue) {
		Node[] temp = new Node[queue.size()];
		queue.toArray(temp);
		for(int i = 0; i < temp.length - 1; i++ ) {
			int max = temp[i].getHeight();
			int posmax = i;
			for(int j = i+1; j < temp.length; j++) {
				if(temp[i].getHeight()> max) {
					max = temp[i].getHeight();
					posmax = j;
				}
			}
			if(posmax != i) {
				Node tempNode = temp[i];
				temp[i] =  temp[posmax];
				temp[posmax] = tempNode;
			}
		}
		LinkedList<Node> nodesTemp = new LinkedList<Node>();
		for(Node n : temp) {
			nodesTemp.add(n);
		}
		
		Queue<Node> q = nodesTemp; 
		return q;
	}
	
	/**
	 * Search all direct generalization of node from lattice.
	 * @param node - Node
	 * @param Ei - LinkedList<Edge>
	 * @return all direct generalization of node - LinkedList<Node>
	 */
	private LinkedList<Node> directGeneralizationOfNode(Node node, Queue<Node> queue){
		LinkedList<Node> list = new LinkedList<Node>();
		if(Ei.containsKey(node)) {
			for(Node n : Ei.get(node))
				if(!queue.contains(n))
					list.add(n);
		}
		return list;
	}	
}
