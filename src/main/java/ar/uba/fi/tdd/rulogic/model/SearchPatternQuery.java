package ar.uba.fi.tdd.rulogic.model;

public interface SearchPatternQuery {

	public boolean isAFact(String query);
	public boolean isARule(String query);

}
