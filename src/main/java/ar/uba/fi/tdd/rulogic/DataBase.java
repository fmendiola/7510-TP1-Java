package ar.uba.fi.tdd.rulogic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataBase implements SearchPatternQuery {
	
	ArrayList<String> DB = new ArrayList<String>();
	
	public DataBase(){
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/rules.db"));
			String sCurrentLine;
			
			while((sCurrentLine = br.readLine()) != null){
				//System.out.println(sCurrentLine);
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
			System.out.println(elem_tokens[0]);
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
		return true;
	}

}
