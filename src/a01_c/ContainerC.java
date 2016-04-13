/**
 * 
 */
package a01_c;


/**
 * @author kallotti
 *
 */
public class ContainerC<T> {
  
  /**
   * 
   */
  private T content;
  
  /**
   * 
   */
  private ContainerC<T> nextElem;
  
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
  public ContainerC<T> getNextElem(){
    return nextElem;
  }
  
  /**
   * 
   * @param nextElem
   */
  public void setNextElem(ContainerC<T> nextElem){
    this.nextElem=nextElem;
  }

}
