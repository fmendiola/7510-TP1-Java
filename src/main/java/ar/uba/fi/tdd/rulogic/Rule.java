package ar.uba.fi.tdd.rulogic.model;

public class Rule extends Query {
	
	private String query;
	
	public Rule(String query){
		this.query = query.replaceAll("^\\s*","");
	}

	boolean queryInDB(FindQuery db){
		return db.queryInDB(this);
	}
	
	public String getQuery(){
		return this.query;
	}

}
