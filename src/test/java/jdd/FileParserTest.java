package jdd;

import org.junit.Before;
import static org.mockito.Mockito.*;
import org.junit.Test;

import javassist.NotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;




public class FileParserTest {
	
	private FileParser fp;
	
	@Before
	public void setUp() throws Exception {
		this.fp = new FileParser();
	}
	
	
	
	
	@Test
	public void FichierValideNom() {
		
			BufferedReader bufferedReader = mock(BufferedReader.class);

			try { 
			    when(bufferedReader.readLine()).thenReturn("NomDic")
			    .thenReturn(null);
				Dictionary dic=fp.ChargerFichier(bufferedReader);
			    assertTrue(dic.getNb()==0);
				assertEquals(dic.getName(),"NomDic");

			}		
			 
			catch (IOException e) {
				fail(e.getMessage());
			} catch (NotFoundException e) {
				fail(e.getMessage());
			} 	
			
			 
		
	}
	
	
	
	
	@Test
	public void FichierValideAll() {
		
			BufferedReader bufferedReader = mock(BufferedReader.class);
			Dictionary dic =new Dictionary();


			try { 
				when(bufferedReader.readLine()).thenReturn("NomDic")
			    .thenReturn("Salut;Hi;Hello")
			    .thenReturn(null);
				 dic=fp.ChargerFichier(bufferedReader);
			    assertTrue(dic.getNb()!=0);
				assertEquals(dic.getName(),"NomDic");

				assertTrue(Rechercher(dic.getTranslation("Salut"), "Hi"));
				assertTrue(Rechercher(dic.getTranslation("Salut"), "Hi"));
				assertTrue(Rechercher(dic.getTranslation("Salut"), "Hello"));
				assertFalse(Rechercher(dic.getTranslation("Salut"), "Big"));
				//bidirectionelle 
				assertTrue(Rechercher(dic.getTranslation("Hi"), "Salut"));
				assertTrue(Rechercher(dic.getTranslation("Hello"), "Salut"));
				

			}	
			
			 
			catch (IOException e) {
				fail(e.getMessage());
			}
			catch (NotFoundException e) {
				System.out.println("Erreur myster");
				dic.afficheDictionary();

			}
	}
	

	
	@Test
	public void FichierVIDE() {
		
			BufferedReader bufferedReader = mock(BufferedReader.class);
			try {
				
				when(bufferedReader.readLine()).thenReturn(null);
				assertTrue(fp.ChargerFichier(bufferedReader).getNb()==0);
				
			}
			catch (Exception e) {
				fail(e.getMessage());

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
