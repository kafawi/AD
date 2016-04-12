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
  }
  
  @Test
  public void testInsert() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testFind() {
    ListA<String> listA = makeAlphListA();
    
    assertEquals(0, listA.find("a"));
    assertEquals(-1, listA.find("z"));
    assertEquals(listA.size()-1, listA.find("i"));
  }
  
  @Test
  public void testRetrieve() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testConcat() {
    fail("Not yet implemented");
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
