package ar.uba.fi.tdd.rulogic.model;

public class QueryFactory {

	public Query create(String query, SearchPatternQuery db){
		if( db.isAFact(query) ){
			return new Fact(query);
		}else if( db.isARule(query) ){
			return new Rule(query);
		}else{
			return null;
			}
	}
}
