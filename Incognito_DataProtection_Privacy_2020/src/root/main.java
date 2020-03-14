package root;

import java.util.HashMap;
import java.util.LinkedList;

import data.DataReader;
import incognito.Table;
import incognito.Incognito;
import incognito.Node;

public class main {

	public static void main(String[] args) {
		/*
		System.out.println("iniziato");
		DataReader.generaFiles(500000);
		System.out.println("terminato");
		*/
		
		int Qi = 8;
		int k = 5;
		DataReader data = new DataReader(Qi);
		data.generateConvGraph(Qi);
		data.generateNodesAndEdges(Qi);
		data.generateDependencyTree(Qi);
		LinkedList<Table> table = data.getTable();
		HashMap<Node,LinkedList<Node>> Ei = data.getEdges();
		LinkedList<Node> Ci = data.getNodes();
		
		Incognito inc = new Incognito(table, Ei, Ci, k, Qi, data);
		inc.anonymize(Qi);
		
	}

}
