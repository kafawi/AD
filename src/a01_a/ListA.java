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
   * wenn null: leere Liste
   */
  private T[] array;
  //---------------------------------------------------------------------------
  
  /**
   * leere liste
   */
  @SuppressWarnings("unchecked")
  public ListA(){
    array = (T[]) new Object[0];
  }
  
  /**
   * 
   * @param elems
   */
  @SuppressWarnings("unchecked")
  public ListA(T ... elems){
    // count all elements without null
    int len = 0;
    for (int i=0; i < elems.length ; i++){
      if (!(elems[i]==null)){
        len++;
      }
    }
    array = (T[]) new Object[len];
    int j = 0;
    for ( int i=0 ; i < elems.length ; i++ ){
      if (!(elems[i] == null)) {
        array[j]=elems[i];  
        j++;
      }
    }
  }
  //---------------------------------------------------------------------------

  @SuppressWarnings("unchecked")
  @Override
  public void insert(int pos, T elem) throws IndexOutOfBoundsException {
    if (!(elem == null)){
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
    if (!(array == null)){
      for (int i=0; i < size(); i++){
        tmpArray[i]= array[i];
      }
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
