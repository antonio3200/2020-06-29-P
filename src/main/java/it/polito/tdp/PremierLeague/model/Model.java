package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private PremierLeagueDAO dao;
	private SimpleWeightedGraph<Match,DefaultWeightedEdge> grafo;
	private List<Match> vertici;
	private Map<Integer,Match> idMap;
	
	public Model() {
		dao= new PremierLeagueDAO();
		this.vertici= new ArrayList<>();
		this.idMap= new HashMap<>();
	}
	
	public void creaGrafo(Integer mese,Integer minuti) {
		this.grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.vertici=this.dao.getMatches(mese,this.idMap);
		//aggiungo vertici
		Graphs.addAllVertices(this.grafo,this.vertici);
		// aggiungo archi
		List<Arco> archi = this.dao.getArco(minuti, mese, this.idMap);
		for(Arco a : archi) {
			Graphs.addEdgeWithVertices(this.grafo, a.getM1(), a.getM2(), a.getPeso());
		}
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Match> getVertici(){
		return this.vertici;
	}
	
	public List<Arco> getArchiMaggiori(Integer mese,Integer minuti){
		List<Arco> archi= this.dao.getArco(minuti, mese, idMap);
		List<Arco> result= new ArrayList<Arco>();
		int max=0;
		for(Arco a : archi) {
			if(a.getPeso()>max) {
				max=a.getPeso();
			}
		}
		
		for(Arco a : archi) {
			if(a.getPeso()==max) {
				result.add(a);
			}
		}
		return result;
	}
}
