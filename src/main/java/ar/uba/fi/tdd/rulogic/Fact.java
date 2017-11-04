package ar.uba.fi.tdd.rulogic.model;

public class Fact extends Query {
	
	private String query;
	
	public Fact(String query){
		this.query = query;
	}

	boolean queryInDB(){
		return true;
	}

}
