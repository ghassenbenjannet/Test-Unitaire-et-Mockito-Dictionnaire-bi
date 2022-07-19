package jdd;

import java.util.*;

import javassist.NotFoundException;

public class Dictionary {
	private String nom;
	private int nb;
	//private Map<String, String> LeContenu = new HashMap<String, String>();	
	private Map<String, List<String>> LeContenuMultiple = new HashMap<String, List<String>>();	

	
	
	public Dictionary() {
		nb=0;
	};
	
	public Dictionary(String nom) {
		this.nom=nom;
		nb=0;
	}
	public String getName() {
		return nom;
	}
	
	public int getNb() {
		return nb;
	}
	
	public void addTranslation(String fr, String ang) {
		nb++;
		//LeContenu.put(fr,ang);
		
		ArrayList<String> liste = new ArrayList<String>();
		if (LeContenuMultiple.containsKey(fr) )
            LeContenuMultiple.get(fr).add(ang);
		else {
			liste.add(ang);
			LeContenuMultiple.put(fr, liste);
		}
	}
	
	
	
	 
    
	   
	
	
	
	/*public String getTranslation(String fr) throws NotFoundException {
		for (Map.Entry<String, String> tmp : LeContenu.entrySet()) {
            if(tmp.getKey()==fr)
             return tmp.getValue();
        }
		 throw new NotFoundException("Error404:p");
	}
	*/
	
	
	
	public List<String> getTranslation(String fr) throws NotFoundException {
		ArrayList<String> liste = new ArrayList<String>();
		for (Map.Entry<String, List<String>> tmp : LeContenuMultiple.entrySet()) {
            if(tmp.getKey()==fr)
             return tmp.getValue();
            
            //Bidirectionelle
            else if(Rechercher(tmp.getValue(),fr))
            	{	liste.add(tmp.getKey());
            		return liste;
            	}
            else
    			 throw new NotFoundException("N'existe pas !");
            	
		}
		return liste;
		
	}
	
	
	
	public void setName(String n) {
		this.nom=n;
	}
	
	
	
	public void afficheDictionary(){
        System.out.println("le nom du dictionnaire : "+this.nom);
        for (Map.Entry m : LeContenuMultiple.entrySet()) {
            System.out.print(m.getKey() + "=");
            for(String mot:LeContenuMultiple.get(m.getKey())){
                System.out.print(mot + "|");
            }
            System.out.println("");
        }
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
