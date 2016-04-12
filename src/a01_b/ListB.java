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
    for (int i =0; i< elems.length; i++){
      array[i]=(ContainerB<T>) new ContainerB<Object>(elems[i], i-1, i+1);
    }
    array[elems.length+1]=
        (ContainerB<T>) new ContainerB<Object>(new Stop(), -1, -1);
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

  @Override
  public void concat(List<T> list) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
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
