/**
 * 
 */
package a01_c;

import a01.Elem;

/**
 * @author kallotti
 *
 */
public class ContainerC<T extends Elem> {
  
  /**
   * 
   */
  private T content;
  
  /**
   * 
   */
  private T nextElem;
  
  //---------------------------------------------------------------------------
  
  /**
   * 
   * @param content
   */
  public ContainerC(T content){
    this.content=content;
    nextElem = null;
  }
  
  /**
   * 
   * @return
   */
  public T getContent(){
    return content;
  }
  
  /**
   * 
   * @return
   */
  public T getNextElem(){
    return nextElem;
  }
  
  /**
   * 
   * @param nextElem
   */
  public void setNextElem(T nextElem){
    this.nextElem=nextElem;
  }

}
