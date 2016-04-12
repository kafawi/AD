/**
 * 
 */
package a01_c;

import a01.Elem;
import a01.List;

/**
 * @author kallotti
 *
 */
public class ListC<T extends Elem> implements List<T> {
  
  private ContainerC<T> first;
  
  //---------------------------------------------------------------------------
  
  //public ListC(T){
    
    
  //}
  
  
  //---------------------------------------------------------------------------
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

}
