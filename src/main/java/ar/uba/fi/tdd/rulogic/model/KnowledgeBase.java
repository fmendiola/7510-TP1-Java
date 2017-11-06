package ar.uba.fi.tdd.rulogic.model;

public class KnowledgeBase {

	public boolean answer(String query) {
	
		DataBase db = new DataBase();
		Query q = new QueryFactory().create(query,db);
		if (q == null){
			return false;
		}else{
			return q.queryInDB(db);
			}
	}
}
