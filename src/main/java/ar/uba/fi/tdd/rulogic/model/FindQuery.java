package ar.uba.fi.tdd.rulogic.model;

public interface FindQuery {

	public boolean queryInDB(Fact fact);
	public boolean queryInDB(Rule rule);

}
