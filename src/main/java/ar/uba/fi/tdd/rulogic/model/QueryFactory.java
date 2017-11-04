package ar.uba.fi.tdd.rulogic.model;

public class QueryFactory {

	public Query create(String query, SearchPatternQuery db){
		if( db.isAFact(query) ){
			return new Fact(query);
		}
		return null;
	}

}
