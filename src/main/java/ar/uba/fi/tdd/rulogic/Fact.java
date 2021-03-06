package ar.uba.fi.tdd.rulogic.model;

public class Fact extends Query {
	
	private String query;
	
	public Fact(String query){
		
		this.query = query.replaceAll("^\\s*","");
	}

	boolean queryInDB(FindQuery db){
		return db.queryInDB(this);
	}
	
	public String getQuery(){
		return this.query;
	}

}
