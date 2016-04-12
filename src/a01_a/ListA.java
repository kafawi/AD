/**
 * 
 */
package a01_a;

import a01.List;

/**
 * @author kallotti
 *
 */
public class ListA<T> implements List<T> {
  
  
  /**
   * 
   */
  private T[] array;
  //---------------------------------------------------------------------------
  
  /**
   * Sollte nicht für den Test verwendet werden.
   * Blöder Konstruktor.
   * @param anz
   *  
   */
  @SuppressWarnings("unchecked")
  public ListA(int anz){
    array = (T[]) new Object[anz];
  }
  
  /**
   * 
   * @param elems
   */
  @SuppressWarnings("unchecked")
  public ListA(T ... elems){
    array = (T[]) new Object[elems.length];
    for ( int i=0 ; i < array.length ; i++ ){
      array[i]=elems[i];
    }
  }
  //---------------------------------------------------------------------------

  @SuppressWarnings("unchecked")
  @Override
  public void insert(int pos, T elem) throws IndexOutOfBoundsException {
    if ( pos < 0 || pos > size() ){
      throw new IndexOutOfBoundsException();
    } else {
      T[] tmpArray =(T[]) new Object[ size() +1 ];
      for (int i=0; i < pos; i++ ){
        tmpArray[i] = array[i];
      }
      tmpArray[pos] = elem;
      for (int i=pos ;i < size() ;i++){
        tmpArray[i+1]= array[i];
      }
      array=tmpArray;
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public void delete(int pos) throws IndexOutOfBoundsException {
    if ( pos < 0 || pos > size() ){
      throw new IndexOutOfBoundsException();
    } else {
      T[] tmpArray =(T[]) new Object[ size() - 1 ]; 
      for (int i=0; i < pos; i++ ){
        tmpArray[i] = array[i];
      }
      for (int i=pos ;i < size() ;i++){
        tmpArray[i-1]= array[i];
      }
      array=tmpArray;
    }
    
  }

  @Override
  public int find(T elem) {
    for (int i=0; i < size(); i++ ){
      if (array[i].equals(elem)) {
        return i;
      }
    }  
    return -1;
  }

  @Override
  public T retrieve(int pos) throws IndexOutOfBoundsException {
    if ( pos < 0 || pos > size() ){
      throw new IndexOutOfBoundsException();
    } 
    return array[pos];
  }

  @SuppressWarnings("unchecked")
  @Override
  public void concat(List<T> list) {
    
    T[] tmpArray =(T[]) new Object[ size() + list.size() - 1 ];
    for (int i=0; i < size(); i++){
      tmpArray[i]= array[i];
    }
    if (list instanceof ListA<?>){
      for (int i=0; i < list.size(); i++){
        tmpArray[ size()+i ]= array[i];
      }
    } else {
      for (int i = 0; i < list.size(); i++){
        tmpArray[ size()+i ]= list.retrieve(i);
      }
    }
    array = tmpArray;
  }

  @Override
  public int size() {
    return array.length;
  }
 

}
