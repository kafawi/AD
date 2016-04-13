/**
 * 
 */
package a01_test;

import static org.junit.Assert.*;

import org.junit.Test;

import a01.Elem;
import a01_b.ListB;
import a01_c.ListC;

/**
 * @author kallotti
 *
 */
public class ListCTest {

  @Test
  public void testKonstruktor() {
    assertNotNull(new ListB<Elem>(0));
    assertNotNull(makeAlphListA());
    ListC<Elem> list = new ListC<Elem>(null, new Elem(), null);
    assertNotNull( list );
    ListC<Elem> listE = new ListC<Elem>(null, null, null);
    assertNotNull( listE );
    assertEquals(1, list.size());
    assertEquals(0, listE.size());
  }
  
  @Test
  public void testInsert() {
    ListC<String> listA = makeAlphListA();
    listA.insert(4, "T");
    assertEquals("T", listA.retrieve(4));
  
    listA.insert(1, "BB");
    assertEquals("BB", listA.retrieve(1));
    
    listA.insert(1, null);
    assertEquals("BB", listA.retrieve(1));
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testDelete() {
    ListC<String> listA = makeAlphListA();
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
    // delet 2 leere liste
    ListC<String> listC = new ListC<String>(null, "stirng");
    listC.delete(1);
    assertEquals(0,listC.size());
  }
  
  @Test
  public void testFind() {
    ListC<String> listA = makeAlphListA();
    assertEquals(0, listA.find("a"));
    assertEquals(-1, listA.find("z"));
    assertEquals(listA.size()-1, listA.find("i"));
    
    listA.insert(9, "Test");
    assertEquals("Test", listA.retrieve(9));
    
    assertEquals(-1, listA.find(null));
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testRetrieve() {
    ListC<String> listA = makeAlphListA();  
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
    ListC<String> listA = makeAlphListA();
    ListC<String> listB = makeAlphListA();
    listA.concat(listB);
    assertEquals(18, listA.size());
    assertEquals("a", listA.retrieve(0));
    assertEquals("i", listA.retrieve(17));
    // leere liste
    ListC<String> listC = new ListC<String>();
    listC.concat(listB);
    assertEquals(9, listC.size());
    ListC<String> listD = new ListC<String>();
    listB.concat(listD);
    assertEquals(9, listB.size());
    
  }
  
  @Test
  public void testSize() {
    ListC<String> listA = makeAlphListA();    
    assertEquals(9, listA.size());
    //-- leere Lsite
    ListC<String> listB = new ListC<String>();
    assertEquals(0,listB.size());
    
    
  }
  
  private ListC<String> makeAlphListA(){
    return new ListC<String>("a", "b", "c", "d", "e", "f", "g", "h", "i");
  }

}
