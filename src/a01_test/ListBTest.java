/**
 * 
 */
package a01_test;

import static org.junit.Assert.*;

import org.junit.Test;

import a01.Elem;
import a01_b.ListB;

/**
 * @author kallotti
 *
 */
public class ListBTest {

  @Test
  public void testKonstruktor() {
    assertNotNull(new ListB<Elem>(0));
    assertNotNull(makeAlphListA());
    ListB<Elem> list = new ListB<Elem>(5,null, new Elem(), null);
    assertNotNull( list );
    assertEquals(1, list.size());
  }
  
  @Test
  public void testInsert() {
    ListB<String> listA = makeAlphListA();
    listA.insert(4, "T");
    assertEquals("T", listA.retrieve(4));
  
    listA.insert(1, "BB");
    assertEquals("BB", listA.retrieve(1));
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testDelete() {
    ListB<String> listA = makeAlphListA();
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
    ListB<String> listA = makeAlphListA();
    
    assertEquals(0, listA.find("a"));
    System.out.println("1");
    assertEquals(-1, listA.find("z"));
    System.out.println("1");
    assertEquals(listA.size()-1, listA.find("i"));
    System.out.println("1");
    listA.insert(9, "Test");
    assertEquals("Test", listA.retrieve(9));
    System.out.println("1");
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testRetrieve() {
    ListB<String> listA = makeAlphListA();  
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
    ListB<String> listA = makeAlphListA();
    ListB<String> listB = makeAlphListA();
    listA.concat(listB);
  
    assertEquals(18, listA.size());
    assertEquals("a", listA.retrieve(0));
    assertEquals("i", listA.retrieve(17));
  }
  
  @Test
  public void testSize() {
    ListB<String> listA = makeAlphListA();    
    assertEquals(9, listA.size());
    //-- leere Lsite
    assertEquals(0, new ListB<Elem>(0).size());
    
  }
  
  private ListB<String> makeAlphListA(){
    return new ListB<String>(10,"a", "b", "c", "d", "e", "f", "g", "h", "i");
  }

}
