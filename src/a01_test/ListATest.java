/**
 * 
 */
package a01_test;

import static org.junit.Assert.*;

import org.junit.Test;

import a01.Elem;
import a01_a.ListA;

/**
 * @author kallotti
 *
 */
public class ListATest {

  @Test
  public void testKonstruktor() {
    assertNotNull(new ListA<Elem>());
    assertNotNull(makeAlphListA());
    ListA<Elem> list = new ListA<Elem>(null, new Elem(), null);
    assertNotNull( list );
    assertEquals(1, list.size());
  }
  
  @Test
  public void testInsert() {
    ListA<String> listA = makeAlphListA();
	  listA.insert(4, "T");
	  assertEquals("T", listA.retrieve(4));
	
	  listA.insert(1, "BB");
	  assertEquals("BB", listA.retrieve(1));
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testDelete() {
    ListA<String> listA = makeAlphListA();
    //Versuche die letzten drei Elem zu löschen
    listA.delete(listA.size()-1);
    assertEquals(-1, listA.find("i"));
    listA.delete(listA.size()-1);
    assertEquals(-1, listA.find("h"));
    listA.delete(listA.size()-1);
    assertEquals(-1, listA.find("g"));
	
    //verbleibende Größe
    assertEquals(6, listA.size());
	
    try {
      listA.delete(-13);
    }catch(IndexOutOfBoundsException e){
      System.out.println(e);
      throw e;
    }
  }
  
  @Test
  public void testFind() {
    ListA<String> listA = makeAlphListA();
    
    assertEquals(0, listA.find("a"));
    assertEquals(-1, listA.find("z"));
    assertEquals(listA.size()-1, listA.find("i"));
    
    listA.insert(9, "Test");
    assertEquals("Test", listA.retrieve(9));
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testRetrieve() {
    ListA<String> listA = makeAlphListA();  
    assertEquals("a", listA.retrieve(0));
    assertEquals("b", listA.retrieve(1));
    assertEquals("c", listA.retrieve(2));
    assertEquals("i", listA.retrieve(8));
	
    try {
      listA.retrieve(-13);
    }catch(IndexOutOfBoundsException e){
      System.out.println(e);
      throw e;
    }
  }
  
  @Test
  public void testConcat() {
    ListA<String> listA = makeAlphListA();
    ListA<String> listB = makeAlphListA();
    listA.concat(listB);
    
    assertEquals(18, listA.size());
    assertEquals("a", listA.retrieve(0));
    assertEquals("i", listA.retrieve(17));
  }
  
  @Test
  public void testSize() {
    ListA<String> listA = makeAlphListA();    
    assertEquals(9, listA.size());
    //-- leere Lsite
    assertEquals(0, new ListA<Elem>().size());
    
  }
  
  private ListA<String> makeAlphListA(){
    return new ListA<String>("a", "b", "c", "d", "e", "f", "g", "h", "i");
  }

}
