package jdd;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javassist.NotFoundException;





public class FileParser  {
	
	
	
	public Dictionary ChargerFichier(BufferedReader buff) throws IOException, NotFoundException    {
        
			int j=0;
            
            // BufferedReader
            String ligne;
            
            //Nom dictionnaire
            Dictionary dic = new Dictionary(buff.readLine());            
            // traductions
            while((ligne = buff.readLine())!=null)
            {	
            	j++;
                if(j>0){
                    String [] section = ligne.split(";");

                    for(int i=1; i<section.length;i++) {
                    	System.out.println(section[i]);
                        dic.addTranslation(section[0], section[i]);
                    }
                }
            }
          

           //dic.afficheDictionary();
    
	return dic;

}
	
	//utile 
	public boolean Rechercher(List<String> lis, String mot) {
		boolean test=false;
		for(int i=0;i<lis.size();i++)
			if(lis.get(i)==mot)
				test= true;
		return test;
	}
	
}
