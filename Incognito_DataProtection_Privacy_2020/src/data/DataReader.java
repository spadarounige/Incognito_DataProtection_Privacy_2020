package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import incognito.Table;
import incognito.Node;

public class DataReader {
	private LinkedList<Table> t;
	private LinkedList<Node> C;
	private HashMap<Node,LinkedList<Node>> E;
	private HashMap<String, Integer> connectorBirthday;
	private HashMap<String, Integer> connectorSex;
	private HashMap<String, Integer> connectorZipcode;
	private HashMap<String, Integer> connectorFigli;
	private HashMap<String, Integer> connectorStipendio;
	private HashMap<String, Integer> connectorTitoloStudio;
	private HashMap<String, Integer> connectorProfessione;
	private HashMap<String, Integer> connectorNazionalita;
	private HashMap<String, Integer> connectorStatoCivile;
	private HashMap<String, LinkedList<String>> dependencyTree;
	
	public DataReader(int Qi) {
		this.connectorBirthday = new HashMap<String, Integer>();
		this.connectorSex = new HashMap<String, Integer>();
		this.connectorZipcode = new HashMap<String, Integer>();
		this.connectorFigli = new HashMap<String, Integer>();
		this.connectorStipendio = new HashMap<String, Integer>();
		this.connectorTitoloStudio = new HashMap<String, Integer>();
		this.connectorProfessione = new HashMap<String, Integer>();
		this.connectorNazionalita = new HashMap<String, Integer>();
		this.connectorStatoCivile = new HashMap<String, Integer>();
		this.dependencyTree = new HashMap<String, LinkedList<String>>();
		this.C = new LinkedList<Node>();
		this.E = new HashMap<Node, LinkedList<Node>>();
		this.t = readTable(Qi);
	}
	
	public HashMap<String, LinkedList<String>> getDependencyTree(){
		return dependencyTree;
	}
	
	public void generateDependencyTree(int Qi) {
		FileReader fl;
		String[] paths= {};
		if(Qi == 9) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Figli", "Stipendio", "TitoloStudio", "Professione","Nazionalita","StatoCivile"};
			paths = temp;
		}
		if(Qi == 8) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Figli","TitoloStudio", "Professione","Nazionalita","StatoCivile"};
			paths = temp;
		}
		if(Qi == 7) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Figli","TitoloStudio", "Nazionalita","StatoCivile"};
			paths = temp;
		}
		if(Qi == 6) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Figli","Nazionalita","StatoCivile"};
			paths = temp;
		}
		if(Qi == 5) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Figli","Nazionalita"};
			paths = temp;
		}
		if(Qi == 4) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Nazionalita"};
			paths = temp;
		}
		if(Qi == 3) {
			String[] temp = {"Birthday", "Sex", "Zipcode"};
			paths = temp;
		}
		if(Qi == 2) {
			String[] temp = {"Birthday", "Sex"};
			paths = temp;
		}
		if(Qi == 1) {
			String[] temp = {"Birthday"};
			paths = temp;
		}
		for(String path : paths) {
			try {
				fl = new FileReader(new File("../incognitoBackup/src/data/GH_"+path+".csv"));
				Scanner s = new Scanner(fl);
				while(s.hasNext()) {
					LinkedList<String> tempValues = new LinkedList<String>();
					String[] line = s.nextLine().split(",");
					for(int i = 1; i < line.length; i++) {
						tempValues.add(line[i]);
					}
					dependencyTree.put(line[0], tempValues);
				}
				s.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void generateNodesAndEdges(int Qi) {
		if(Qi == 9) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int zs = getMaxLv(connectorZipcode);
			int ss = getMaxLv(connectorSex);
			int fs = getMaxLv(connectorFigli);
			int es = getMaxLv(connectorStipendio);
			int ts = getMaxLv(connectorTitoloStudio);
			int ps = getMaxLv(connectorProfessione);
			int ns = getMaxLv(connectorNazionalita);
			int cs = getMaxLv(connectorStatoCivile);
			for(int b = 0; b <= bs; b++)
				for(int z = 0; z <= zs;z++)
					for(int s = 0; s <= ss; s++)
						for(int f = 0; f <= fs; f++)
							for(int e = 0; e <= es; e++)
								for(int t = 0; t <= ts; t++)
									for(int p = 0; p <= ps; p++)
										for(int n = 0; n <= ns; n++)
											for(int c = 0; c <= cs; c++){
												Node node = new Node(i, b, s, z, n, f, c, t, p, e);
												i++;
												C.add(node);
											}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	+1) ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()	+1	&&
							n2.getTitoloStudio()== n.getTitoloStudio()	) ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()		+1	&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()	+1	&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()			+1	&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()	+1	&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()		+1	&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1	&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getStipendio() 	== n.getStipendio()			&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						//Edge e = new Edge(n, n2);
						//E.add(e);
					}
				}
			}
		}
		if(Qi == 8) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int zs = getMaxLv(connectorZipcode);
			int ss = getMaxLv(connectorSex);
			int fs = getMaxLv(connectorFigli);
			int ts = getMaxLv(connectorTitoloStudio);
			int ps = getMaxLv(connectorProfessione);
			int ns = getMaxLv(connectorNazionalita);
			int cs = getMaxLv(connectorStatoCivile);
			for(int b = 0; b <= bs; b++)
				for(int z = 0; z <= zs;z++)
					for(int s = 0; s <= ss; s++)
						for(int f = 0; f <= fs; f++)
							for(int t = 0; t <= ts; t++)
								for(int p = 0; p <= ps; p++)
									for(int n = 0; n <= ns; n++)
										for(int c = 0; c <= cs; c++){
											Node node = new Node(i, b, s, z, n, f, c, t, p);
											i++;
											C.add(node);
										}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	+1) ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getProfessione()	== n.getProfessione()	+1	&&
							n2.getTitoloStudio()== n.getTitoloStudio()	) ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()	+1	&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()			+1	&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()	+1	&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()		+1	&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1	&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getProfessione()	== n.getProfessione()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*Edge e = new Edge(n, n2);
						E.add(e);
						*/
					}
				}
			}
		}
		if(Qi == 7) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int zs = getMaxLv(connectorZipcode);
			int ss = getMaxLv(connectorSex);
			int fs = getMaxLv(connectorFigli);
			int ts = getMaxLv(connectorTitoloStudio);
			int ns = getMaxLv(connectorNazionalita);
			int cs = getMaxLv(connectorStatoCivile);
			for(int b = 0; b <= bs; b++)
				for(int z = 0; z <= zs;z++)
					for(int s = 0; s <= ss; s++)
						for(int f = 0; f <= fs; f++)
							for(int t = 0; t <= ts; t++)
								for(int n = 0; n <= ns; n++)
									for(int c = 0; c <= cs; c++){
										Node node = new Node(i, b, s, z, n, f, c, t);
										i++;
										C.add(node);
									}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	+1) ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()	+1	&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()			+1	&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()	+1	&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()		+1	&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1	&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   ||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()		&&
							n2.getTitoloStudio()== n.getTitoloStudio()	)   
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*
						Edge e = new Edge(n, n2);
						E.add(e);*/
					}
				}
			}
		}
		if(Qi == 6) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int zs = getMaxLv(connectorZipcode);
			int ss = getMaxLv(connectorSex);
			int fs = getMaxLv(connectorFigli);
			int ns = getMaxLv(connectorNazionalita);
			int cs = getMaxLv(connectorStatoCivile);
			for(int b = 0; b <= bs; b++)
				for(int z = 0; z <= zs;z++)
					for(int s = 0; s <= ss; s++)
						for(int f = 0; f <= fs; f++)
							for(int n = 0; n <= ns; n++)
								for(int c = 0; c <= cs; c++){
									Node node = new Node(i, b, s, z, n, f, c);
									i++;
									C.add(node);
								}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()	+1) ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()			+1	&&
							n2.getStatoCivile()	== n.getStatoCivile())	   ||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()	+1	&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile()) 		||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()		+1	&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile())		||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1	&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile())		||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()				&&
							n2.getStatoCivile()	== n.getStatoCivile())   
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*
						Edge e = new Edge(n, n2);
						E.add(e);
						*/
					}
				}
			}
		}
		if(Qi == 5) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int zs = getMaxLv(connectorZipcode);
			int ss = getMaxLv(connectorSex);
			int fs = getMaxLv(connectorFigli);
			int ns = getMaxLv(connectorNazionalita);
			for(int b = 0; b <= bs; b++)
				for(int z = 0; z <= zs;z++)
					for(int s = 0; s <= ss; s++)
						for(int f = 0; f <= fs; f++)
							for(int n = 0; n <= ns; n++){
								Node node = new Node(i, b, s, z, n, f);
								i++;
								C.add(node);
							}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli()			+1)	||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()	+1	&&
							n2.getFigli() 		== n.getFigli()) 			||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()		+1	&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli())			||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1	&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli())			||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()		&&
							n2.getFigli() 		== n.getFigli())   
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*
						Edge e = new Edge(n, n2);
						E.add(e);
						*/
					}
				}
			}
		}
		if(Qi == 4) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int zs = getMaxLv(connectorZipcode);
			int ss = getMaxLv(connectorSex);
			int ns = getMaxLv(connectorNazionalita);
			for(int b = 0; b <= bs; b++)
				for(int z = 0; z <= zs;z++)
					for(int s = 0; s <= ss; s++)
						for(int n = 0; n <= ns; n++){
							Node node = new Node(i, b, s, z, n);
							i++;
							C.add(node);
						}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita()	+1)	||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()		+1	&&
							n2.getNazionalita()	== n.getNazionalita())		||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1	&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita())		||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()			&&
							n2.getNazionalita()	== n.getNazionalita())   
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*
						Edge e = new Edge(n, n2);
						E.add(e);
						*/
					}
				}
			}
		}
		if(Qi == 3) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int zs = getMaxLv(connectorZipcode);
			int ss = getMaxLv(connectorSex);
			for(int b = 0; b <= bs; b++)
				for(int z = 0; z <= zs;z++)
					for(int s = 0; s <= ss; s++){
						Node node = new Node(i, b, s, z);
						i++;
						C.add(node);
					}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode()		+1)	||
						   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1	&&
							n2.getZipcode() 	== n.getZipcode())			||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()				&&
							n2.getZipcode() 	== n.getZipcode())   
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*
						Edge e = new Edge(n, n2);
						E.add(e);
						*/
					}
				}
			}
		}
		if(Qi == 2) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			int ss = getMaxLv(connectorSex);
			for(int b = 0; b <= bs; b++)
				for(int s = 0; s <= ss; s++){
					Node node = new Node(i, b, s);
					i++;
					C.add(node);
				}
			for(Node n : C) {
				for(Node n2 : C) {
					if(	   (n2.getBirthday() 	== n.getBirthday()			&&
							n2.getSex() 		== n.getSex()			+1)	||
						   (n2.getBirthday() 	== n.getBirthday()		+1	&&
							n2.getSex() 		== n.getSex()) 
							){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*
						Edge e = new Edge(n, n2);
						E.add(e);
						*/
					}
				}
			}
		}
		if(Qi == 1) {
			int i = 0;
			int bs = getMaxLv(connectorBirthday);
			for(int b = 0; b <= bs; b++){
					Node node = new Node(i, b);
					i++;
					C.add(node);
			}
			for(Node n : C) {
				for(Node n2 : C) {
					if(n2.getBirthday() 	== n.getBirthday() +1){
						if(E.containsKey(n)) {
							if(!E.get(n).contains(n2))
								E.get(n).add(n2);
						}
						else {
							E.put(n, new LinkedList<Node>());
							E.get(n).add(n2);
						}
						/*
						Edge e = new Edge(n, n2);
						E.add(e);
						*/
					}
				}
			}
		}
	}
	
	private int getMaxLv(HashMap<String, Integer> myMap) {
		int max = -1;
		Set<String> keys = myMap.keySet();
		for(String key : keys) {
			if(myMap.get(key).intValue()>max)
				max = myMap.get(key).intValue();
		}
		return max;
	}
	
	public HashMap<Node, LinkedList<Node>> getEdges(){
		return E;
	}
	public LinkedList<Node> getNodes(){
		return C;
	}
	
	public LinkedList<Table> getTable(){
		return t;
	}
	public void generateTable(int Qi){
		t = readTable(Qi);
	}
	public static LinkedList<Table> getOriginalT(int Qi){
		return readTable(Qi);
	}
	
	private static LinkedList<Table> readTable(int Qi){
		LinkedList<Table> t = new LinkedList<Table>();
		FileReader fl;
		try {
			fl = new FileReader(new File("../incognitoBackup/src/data/Table.csv"));
			Scanner scan = new Scanner(fl);
			while(scan.hasNext()) {
				String[] line = scan.nextLine().split(",");
				Table temp = null;
				if(Qi == 9)
					temp = new Table(line[0],line[1],line[2],line[3],line[4],line[5],line[6],line[7],line[8]);
				if(Qi == 8)
					temp = new Table(line[0],line[1],line[2],line[3],line[4],line[5],line[6],line[7]);
				if(Qi == 7)
					temp = new Table(line[0],line[1],line[2],line[3],line[4],line[5],line[6]);
				if(Qi == 6)
					temp = new Table(line[0],line[1],line[2],line[3],line[4],line[5]);
				if(Qi == 5)
					temp = new Table(line[0],line[1],line[2],line[3],line[4]);
				if(Qi == 4)
					temp = new Table(line[0],line[1],line[2],line[3]);
				if(Qi == 3)
					temp = new Table(line[0],line[1],line[2]);
				if(Qi == 2)
					temp = new Table(line[0],line[1]);
				if(Qi == 1)
					temp = new Table(line[0]);
				t.add(temp);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	public void generateConvGraph(int Qi) {
		FileReader fl;
		String[] paths= {};
		if(Qi == 9) {
			String[] temp = {"Birthday", "Sex", "Zipcode","Nazionalita", "Figli","StatoCivile", "TitoloStudio", "Professione", "Stipendio"};
			paths = temp;
		}
		if(Qi == 8) {
			String[] temp = {"Birthday", "Sex", "Zipcode","Nazionalita", "Figli", "StatoCivile", "TitoloStudio", "Professione"};
			paths = temp;
		}
		if(Qi == 7) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Nazionalita","Figli","StatoCivile", "TitoloStudio"};
			paths = temp;
		}
		if(Qi == 6) {
			String[] temp = {"Birthday", "Sex", "Zipcode","Nazionalita", "Figli","StatoCivile"};
			paths = temp;
		}
		if(Qi == 5) {
			String[] temp = {"Birthday", "Sex", "Zipcode","Nazionalita", "Figli"};
			paths = temp;
		}
		if(Qi == 4) {
			String[] temp = {"Birthday", "Sex", "Zipcode", "Nazionalita"};
			paths = temp;
		}
		if(Qi == 3) {
			String[] temp = {"Birthday", "Sex", "Zipcode"};
			paths = temp;
		}
		if(Qi == 2) {
			String[] temp = {"Birthday", "Sex"};
			paths = temp;
		}
		if(Qi == 1) {
			String[] temp = {"Birthday"};
			paths = temp;
		}
		for(String path : paths) {
			try {
				fl = new FileReader(new File("../incognitoBackup/src/data/GH_"+path+".csv"));
				Scanner s = new Scanner(fl);
				while(s.hasNext()) {
					String[] line = s.nextLine().split(",");
					int lv = 0;
					for(String temp : line) {
						switch(path) {
							case "Birthday":
								this.connectorBirthday.put(temp, lv);
								break;
							case "Sex":
								this.connectorSex.put(temp, lv);
								break;
							case "Zipcode":
								this.connectorZipcode.put(temp, lv);
								break;
							case "Figli":
								this.connectorFigli.put(temp, lv);
								break;
							case "Stipendio":
								this.connectorStipendio.put(temp, lv);
								break;
							case "TitoloStudio":
								this.connectorTitoloStudio.put(temp, lv);
								break;
							case "Professione":
								this.connectorProfessione.put(temp, lv);
								break;
							case "Nazionalita":
								this.connectorNazionalita.put(temp, lv);
								break;
							case "StatoCivile":
								this.connectorStatoCivile.put(temp, lv);
								break;
						}
						lv++;
					}
				}
				s.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	//----------------------------------------------------------------------
	//-------------------------- Genera dati -------------------------------
	//----------------------------------------------------------------------
	
	public static void generaFiles(int N) {
		LinkedList<String[]> zipcodes = new LinkedList<String[]>();
		LinkedList<String> birthday = new LinkedList<String>();
		LinkedList<String> sex = new LinkedList<String>();
		LinkedList<String> nazionalita = new LinkedList<String>();
		LinkedList<String> statoCivile = new LinkedList<String>();
		LinkedList<String> titoloStudio = new LinkedList<String>();
		LinkedList<String> professione = new LinkedList<String>();
		LinkedList<String[]> figli = new LinkedList<String[]>();
		LinkedList<String[]> stipendio = new LinkedList<String[]>();
		
		for(int i = 0; i < N; i++) {
			String[] zips = generaZ();
			String[] stips= generaStip();
			String[] figlis = generaF();
			Table t = new Table(generaB(),generaS(),zips[0],generaN(),figlis[0],generaSC(),generaTS(),generaP(),stips[0]);	
			if(!birthday.contains(t.getBirthday())) {
		    	birthday.add(t.getBirthday());
		    }
			if(!nazionalita.contains(t.getNazionalita())) {
		    	nazionalita.add(t.getNazionalita());
		    }
			if(!statoCivile.contains(t.getStatoCivile())) {
		    	statoCivile.add(t.getStatoCivile());
		    }
			if(!titoloStudio.contains(t.getTitoloStudio())) {
		    	titoloStudio.add(t.getTitoloStudio());
		    }
			if(!professione.contains(t.getProfessione())) {
		    	professione.add(t.getProfessione());
		    }
			if(!sex.contains(t.getSex())) {
		    	sex.add(t.getSex());
		    }
			boolean contiene = false;
			for(String[] s : figli) {
				if(s[0].compareTo(figlis[0])==0) {
					contiene = true;
				}
			}
			if(!contiene)
				figli.add(figlis);
			contiene = false;
			for(String[] s : stipendio) {
				if(s[0].compareTo(stips[0])==0) {
			    	contiene = true;
			    }
			}
			if(!contiene)
				stipendio.add(stips);
			contiene = false;
			for(String[] s : zipcodes) {
				if(s[0].compareTo(zips[0])==0) {
			    	contiene = true;
			    }
			}
			if(!contiene) {
				zipcodes.add(zips);
			}
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/Table.csv", true));
			    out.write(t.toFileRecord());
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		for(String[] zips : zipcodes) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_Zipcode.csv", true));
			    out.write(zips[0]+","+zips[1]+","+zips[2]+","+zips[3]+"\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		
		for(String[] figlis : figli) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_Figli.csv", true));
			    out.write(figlis[0]+","+figlis[1]+","+figlis[2]+"\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		
		for(String[] stips : stipendio) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_Stipendio.csv", true));
			    out.write(stips[0]+","+stips[1]+","+stips[2]+"\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		for(String s : titoloStudio) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_TitoloStudio.csv", true));
			    out.write(s+",*"+"\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		for(String s : professione) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_Professione.csv", true));
			    out.write(s+",*\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		
		for(String s : nazionalita) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_Nazionalita.csv", true));
			    out.write(s+",*"+"\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		for(String s : statoCivile) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_StatoCivile.csv", true));
			    out.write(s+",*\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		for(String s : birthday) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_Birthday.csv", true));
			    out.write(s+",*"+"\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
		for(String s : sex) {
			try {
				BufferedWriter out = null;
			    out = new BufferedWriter(new FileWriter("../incognitoBackup/src/data/GH_Sex.csv", true));
			    out.write(s+",Person\n");
			    out.close();
			} catch (IOException e) {
			    // errore
			}
		}
	}
	private static String generaB() {
		int gg = (int)(Math.random()*(28-1)+1);
		int mm = (int)(Math.random()*(12-1)+1);
		int aa = (int)(Math.random()*(1990-1970)+1970);
		return gg+"/"+mm+"/"+aa;
	}
	private static String generaS() {
		if((int)(Math.random()*100+1) %2==0)
			return "M";
		else
			return "F";
	}
	private static String generaSC() {
		switch((int)(Math.random()*3+1)) {
			case 1:
				return "m";
			case 2:
				return "nm";
			case 3:
				return "d";
			default:
				return "w";
		}
	}
	private static String generaP() {
		switch((int)(Math.random()*4+1)) {
			case 1:
				return "D";
			case 2:
				return "DS";
			case 3:
				return "L";
			case 4:
				return "DIS";
			default:
				return "S";
		}
	}
	private static String generaTS() {
		switch((int)(Math.random()*3+1)) {
			case 1:
				return "MED";
			case 2:
				return "SUP";
			case 3:
				return "LAU";
			default:
				return "LM";
		}
	}
	private static String generaN() {
		switch((int)(Math.random()*13+1)) {
			case 1:
				return "Italy";
			case 2:
				return "France";
			case 3:
				return "Germany";
			case 4:
				return "Spain";
			case 5:
				return "Portugal";
			case 7:
				return "GreatBritain";
			case 8:
				return "Poland";
			case 9:
				return "Greece";
			case 10:
				return "Austria";
			case 11:
				return "Hungary";
			case 12:
				return "Ireland";
			case 13:
				return "Denmark";
			default:
				return "Finland";
		}
	}
	private static String[] generaZ() {
		String[] zips = new String[4];
		zips[0] = (int)(Math.random()*(99999-90000)+90000)+"";
		zips[1] = zips[0].substring(0, 2)+"***";
		zips[2] = zips[0].substring(0, 1)+"****";
		zips[3] = "*";
		return zips;
	}
	private static String[] generaStip() {
		String[] stips = new String[3];
		stips[0] = (int)(Math.random()*(80000-10000)+10000)+"";
		stips[1] = stips[0].substring(0, 1)+"****";
		stips[2] = "*";
		return stips;
	}
	private static String[] generaF() {
		String[] figli = new String[3];
		figli[0] = (int)(Math.random()*(9-0)+0)+"";
		figli[1] = "y";
		if(Integer.parseInt(figli[0]) == 0)
			figli[1] = "n";
		figli[2] = "*";
		return figli;
	}
	
}
