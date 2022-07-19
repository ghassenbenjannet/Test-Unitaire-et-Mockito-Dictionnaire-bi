package jdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import javassist.NotFoundException;


public class DictionaryTest {
	private Dictionary dic;
	
	@Before
	public void setUp() throws Exception {
		this.dic = new Dictionary();
	}
	
	@Test 
	public void testDictionaryName(){ 
		Dictionary dic = new Dictionary("UnNom"); 
		assertEquals(dic.getName(), "UnNom");
	}
	
	@Test 
	public void testVide(){ 
		assertTrue(dic.getNb()==0);
	}
	
	
	@Test 
	public void TestTranslation() { 
		try {
		dic.addTranslation("Salut", "Hi"); 
		assertTrue(Rechercher(dic.getTranslation("Salut"), "Hi"));

		}
		catch (NotFoundException e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test 
	public void TestMultipleTranslation() throws NotFoundException  { 
		try {
		dic.addTranslation("Salut", "Hi");		
		dic.addTranslation("Salut", "Hello");
		assertTrue(Rechercher(dic.getTranslation("Salut"), "Hi"));
		assertTrue(Rechercher(dic.getTranslation("Salut"), "Hello"));
		assertFalse(Rechercher(dic.getTranslation("Salut"), "Big"));
		//bidirectionelle 
		assertTrue(Rechercher(dic.getTranslation("Hi"), "Salut"));
		assertTrue(Rechercher(dic.getTranslation("Hello"), "Salut"));

		


		}
		catch (NotFoundException e) {
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
