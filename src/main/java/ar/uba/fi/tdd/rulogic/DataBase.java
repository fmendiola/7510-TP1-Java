package ar.uba.fi.tdd.rulogic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataBase implements SearchPatternQuery, FindQuery {
	
	ArrayList<String> DB = new ArrayList<String>();
	
	public DataBase(){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/rules.db"));
			String sCurrentLine;
			
			while((sCurrentLine = br.readLine()) != null){
				DB.add(sCurrentLine);
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public boolean isAFact(String query){
		Iterator<String> iterator = this.DB.iterator();
		String delims = "[ ,.()]+";
		String[] q_tokens = query.split(delims);
		
		while(iterator.hasNext()){
			String element = iterator.next();

			String[] elem_tokens = element.split(delims);
			if( q_tokens[0].equals(elem_tokens[0]) ){
				
				for(int i=0; i< elem_tokens.length; i++){
					if( elem_tokens[i].equals("X") || elem_tokens[i].equals("Y") || elem_tokens[i].equals("Z") ){
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean isARule(String query){
		Iterator<String> iterator = this.DB.iterator();
		String delims = "[ ,.()]+";
		String[] q_tokens = query.split(delims);
		
		while(iterator.hasNext()){
			String element = iterator.next();

			String[] elem_tokens = element.split(delims);
			if( q_tokens[0].equals(elem_tokens[0]) ){
				
				for(int i=0; i< elem_tokens.length; i++){
					if( elem_tokens[i].equals("X") || elem_tokens[i].equals("Y") || elem_tokens[i].equals("Z") ){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean queryInDB(Fact fact){
		Iterator<String> iterator = this.DB.iterator();
		String delims = "[ ,.()]+";
		String[] fact_aux = fact.getQuery().split(delims);
		ArrayList<String> fact_tokens = new ArrayList<String>();

		for(int i=0; i< fact_aux.length ; i++){
			fact_tokens.add(fact_aux[i]);
		}
		
		while(iterator.hasNext()){
			String element = iterator.next();
			String[] elem_aux = element.split(delims);
			ArrayList<String> elem_tokens = new ArrayList<String>();
			
			for(int i=0; i< elem_aux.length ; i++){
				elem_tokens.add(elem_aux[i]);
			}
			
			if( elem_tokens.size() == fact_tokens.size() ){
				if( fact_tokens.containsAll( elem_tokens ) == true ){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean queryInDB(Rule rule){
		Iterator<String> iterator = this.DB.iterator();
		String delims = "[ ,.()]+";
		String[] rule_aux = rule.getQuery().split(delims);
		ArrayList<String> rule_tokens = new ArrayList<String>();

		for(int i=0; i< rule_aux.length ; i++){
			rule_tokens.add(rule_aux[i]);
		}
		
		while(iterator.hasNext()){
			String element = iterator.next();
			element = element.replaceAll("X", rule_tokens.get(1));
			element = element.replaceAll("Y", rule_tokens.get(2));

			if( rule_tokens.size() == 4 ){
				element = element.replaceAll("Z", rule_tokens.get(3));
			}
			
			String[] rule_aux2 = element.split("(:-)+");
			String[] rule_name = rule_aux2[0].split("[ ,.()]+");
			String[] facts;
			
			if( rule_aux2.length > 1 && rule_tokens.get(0).equals(rule_name[0]) ){
				facts = rule_aux2[1].split("(\\),)+");
				boolean[] facts_in_db = new boolean[facts.length];
				
				for(int i=0; i<facts.length; i++){
					Fact fact = new Fact(facts[i]);
					facts_in_db[i] = fact.queryInDB(this);
				}
				for(int i=0; i<facts_in_db.length; i++){
					if(! facts_in_db[i] ){
						return false;
					}
				}
				return true;
			}
			
		}
		return false;
	}

}
