/**
 * 
 */
package a01_b;

//import a01.Elem;
//import a01.Stop;

/**
 * @author kallotti
 *
 */
public class ContainerB<T> {
  
  /**
   * 
   */
  private T content;
  
  /*
   * 
   */
  protected int previousIndex;
  
  /**
   * 
   */
  protected int nextIndex;
  
  //---------------------------------------------------------------------------
  //public ContainerB(){
  //  this(null, -1, -1);
  //}
  /**
   * 
   * @param content
   * @param previous
   * @param next
   */
  public ContainerB(T content, int previous, int next){
    this.content=content;
    previousIndex=previous;
    nextIndex=next;
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
  public int getPreviousIndex(){
    return previousIndex;
  }
  
  /**
   * 
   * @return
   */
  public int getNextIndex(){
    return nextIndex;
  }
  
  /**
   * 
   * @param previousIndex
   */
  public void setPreviousIndex(int previousIndex){
    this.previousIndex = previousIndex;
  }
  
  /**
   * 
   * @param nextIndex
   * @return 
   */
  public void setNextIndex(int nextIndex){
    this.nextIndex = nextIndex;
  }
}
