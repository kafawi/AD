/**
 * 
 */
package a01;

/**
 * @author kallotti
 *
 */
public interface List<T> {
 
   /**
    * Fuegt ein Element elem in die Liste an der Position pos ein.
    * 
    * insert : LIST x POS x ELEM -> LIST
    * 
    * Nach dieser Operation hat die Liste eine L�nge von +1.
    * Bei pos = Anzahl Elemente: Element wird an die Liste angeh�ngt.
    * @param pos
    *   Position an der das Element elem in der Lsite eingef�gt wird.
    * @param elem
    *   Das einzuf�gende Element
    * @throws IndexOutOfBoundsException
    *   wenn pos < 0 oder pos > Anzahl der Elemente (L�nge der Liste)
    */
  public void insert(int pos, T elem) throws IndexOutOfBoundsException;
  
  /**
   * Entfernt das Element aus der List an der Position pos.
   * 
   * delete : LIST x POS -> List
   * 
   * Nach dieser Operstion hat die Lsite eine L�nge von -1.
   * @param pos
   *   Position in der Liste, an der das zu entfernende Element steht.
   * @throws IndexOutOfBoundsException
   *  Wenn pos < 0 oder pos >= Anzahl der Elemente.
   */
  public void delete(int pos) throws IndexOutOfBoundsException;
  
  /**
   * Such ein Element in der Lsite und gibt die erste Position des
   * zu suchende elemnet wieder.
   * 
   * find : LIST x ELEM -> POS
   * 
   * @param elem
   *   Das zu findene Element.
   * @return wenn elem gefunden: position, sonst: -1 
   */
  public int find(T elem);
  
  
  /**
   * Gibt das Element auf der Position pos in der Liste wieder.
   * 
   * retrieve : LIST x POS -> ELEM
   * 
   * @param pos
   *   Position, dan der sich das wiederzugebnede Element befindet.
   * @return
   *   Element in der Lsite an der Position pos.
   * @throws IndexOutOfBoundsException
   *   Wenn pos < 0 oder pos >= Anzahl der Elemente.
   */
  public T retrieve(int pos) throws IndexOutOfBoundsException;
  
  /**
   * H�ngt eine andere Liste list an diese an.
   * 
   * concat : LIST x LIST -> LIST
   *
   * Wenn list == NULL, macht diese Methode nichts. 
   * @param list
   *   Die anzuh�ngende Liste.
   *   
   */
  public void concat(List<T> list);
  
  /**
   * Anzahl der Elemente der Liste werden wiedergegeben.
   * 
   * size : LIST -> INT
   * 
   * @return
   *   Anzahl der Elemente (L�nge)  der Liste.
   */
  public int size();  
}
