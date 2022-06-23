package it.polito.tdp.PremierLeague.model;

public class Arco {
	
	Match m1;
	Match m2;
	int peso;
	public Arco(Match m1, Match m2, int peso) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.peso = peso;
	}
	public Match getM1() {
		return m1;
	}
	public void setM1(Match m1) {
		this.m1 = m1;
	}
	public Match getM2() {
		return m2;
	}
	public void setM2(Match m2) {
		this.m2 = m2;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "["+this.getM1().getMatchID()+"] "+this.m1.getTeamHomeNAME()+" vs "+this.m1.teamAwayNAME+" - "+"["+this.getM2().getMatchID()+"] "+this.m2.getTeamHomeNAME()+" vs "+this.m2.teamAwayNAME+" ("+this.peso+")";
	}
	
	

}
