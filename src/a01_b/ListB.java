/**
 * 
 */
package a01_b;

//import a01.Elem;
import a01.Stop;
import a01.List;

/**
 * @author kallotti
 *
 */
public class ListB<T> implements List<T> {
  
  /**
   * 
   */
  private ContainerB<T>[] array=null;
  
  /**
   * 
   */
  private int len;
  
  //---------------------------------------------------------------------------
  @SuppressWarnings("unchecked")
  public ListB(int len){
    this.len= (len > 10 )? len : 10 ;
    array=new ContainerB[this.len];
    array[0]=(ContainerB<T>) new ContainerB<Object>(new Stop(), -1, -1);
  }
  
  @SuppressWarnings("unchecked")
  public ListB(int len, T ... elems ){
    this.len= (len > 10 )? len : 10 ;
    array=new ContainerB[elems.length+1];
    array[0]=
        (ContainerB<T>) new ContainerB<Object>(new Stop(), elems.length-2, -1);
    for (int i =0; i< elems.length; i++){
      array[i+1]=(ContainerB<T>) new ContainerB<Object>(elems[i], i-1, i+1);
    }
   
  }
  
  
  
  @Override
  public void insert(int pos, T elem) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(int pos) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int find(T elem) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public T retrieve(int pos) {
    // TODO Auto-generated method stub
    return null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void concat(List<T> list) {
    int newSize= size() + list.size() + 1;
    int listIndex=0;
    ContainerB<T>[] tmpArray = new ContainerB[newSize];
    // Stop-Element
    tmpArray[listIndex]=
        (ContainerB<T>) new ContainerB<Object>(new Stop(), newSize-2, -1);
    listIndex++;
    // origin List copy
    ContainerB<T> tmpContainer = findFirstElement();
    while( !(tmpContainer.getContent() instanceof Stop) ){
      tmpArray[listIndex]=array[tmpContainer.getNextIndex()];
    }
    
    // list copy
    
  }

  @Override
  public int size() {
    int counter=0;
    ContainerB<T> tmpContainer = findFirstElement();
    while( !(tmpContainer.getContent() instanceof Stop) ){
      counter++;
      tmpContainer=array[tmpContainer.getNextIndex()];
    }
    return counter;
  }
  
  
  private ContainerB<T> findFirstElement(){
    ContainerB<T> first = null;
    int i = 0;
    while(first == null || i == array.length){
      if (array[i].getPreviousIndex() == -1 
          && array[i].getContent() != null){
        first = array[i];
      }
      i++;
    }
    return first;
  }
  
  /**
   * 
   * @param elems
   */
  /**
  @SafeVarargs
  public ListB(int len, T ... elems){
    if (len < 1){
      len = 20;
    }
    int initLen = 0;
    if( len < elems.length ){
      initLen = elems.length;
    } else {
      initLen = len;
    }
    array = new Elem[initLen];
    for ( int i=0 ; i < len ; i++ ){
      array[i]=elems[i];
    }
    this.len=len;
  }
  */
  //---------------------------------------------------------------------------


}
