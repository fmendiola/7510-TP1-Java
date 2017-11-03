package ar.uba.fi.tdd.rulogic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KnowledgeBase {

	public boolean answer(String query) {
	
		try{
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/rules.db"));
			String sCurrentLine;
			
			while((sCurrentLine = br.readLine()) != null){
				System.out.println(sCurrentLine);
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
		return true;
	}

}
