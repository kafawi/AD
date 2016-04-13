/**
 * 
 */
package a01_c;

import a01.List;

/**
 * @author kallotti
 *
 */
public class ListC<T> implements List<T> {
  
  public ContainerC<T> first;
  
  //---------------------------------------------------------------------------
  @SuppressWarnings("unchecked")
  public ListC(){
    first = (StopC<T>) new StopC<Object>();
  }
  
  @SuppressWarnings("unchecked")
  public ListC(T start){
    if (start == null){
      first = (StopC<T>) new StopC<Object>();
    } else {
      first =(ContainerC<T>) new ContainerC<Object>(start);
      first.setNextElem( (StopC<T>) new StopC<Object>());
    }
  }
  
  
  /**
   * Sehr umständlich aber es funker
   * @param elems
   */
  @SuppressWarnings("unchecked")
  public ListC(T ... elems){
    T[] notNullElems = getNotNullElems(elems);
    int elemAnz=notNullElems.length;
    
    if (elemAnz == 0){
      first = (StopC<T>) new StopC<Object>();
    } else {
      ContainerC<T> tmpContainer = 
          (ContainerC<T>) new ContainerC<Object>(notNullElems[0]); 
      ContainerC<T> nextContainer = null; 
      first = tmpContainer;
        for (int i=1; i < elemAnz; i++){
          nextContainer = 
              (ContainerC<T>) new ContainerC<Object>(notNullElems[i]);
          tmpContainer.setNextElem(nextContainer);
          tmpContainer = nextContainer;
        }
      tmpContainer.setNextElem((StopC<T>) new StopC<Object>());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public void insert(int pos, T elem) throws IndexOutOfBoundsException {
    if (pos < 0 || pos > size()){
      throw new IndexOutOfBoundsException();
    }
    if (elem == null ){
      return;
    }
    int posCounter=0;
    ContainerC<T> prevContainer = first;    
    while ( posCounter < pos-1 ){
      prevContainer =  prevContainer.getNextElem(); 
      posCounter++;
    }
    ContainerC<T> insertContainer = 
        (ContainerC<T>) new ContainerC<Object>(elem);
    
    insertContainer.setNextElem(prevContainer.getNextElem());
    prevContainer.setNextElem(insertContainer);
  }

  @Override
  public void delete(int pos) throws IndexOutOfBoundsException {
    if (pos < 0 || pos >= size()){
      throw new IndexOutOfBoundsException();
    }
    int posCounter=0;
    ContainerC<T> prevContainer = first; 
    while ( posCounter < pos-1 ){
      prevContainer =  prevContainer.getNextElem(); 
      posCounter++;
    }
    
    prevContainer.setNextElem(prevContainer.getNextElem().getNextElem());
    
  }

  @Override
  public int find(T elem) {
    int foundCounter=0;
    
    ContainerC<T> tmpContainer = first;
    
    while ( !(tmpContainer instanceof StopC<?>) ){
      if (tmpContainer.getContent().equals(elem)){
        return foundCounter;
      }
      tmpContainer = tmpContainer.getNextElem();
      foundCounter++;
    }
    return -1;
  }

  @Override
  public T retrieve(int pos) throws IndexOutOfBoundsException {
    if (pos < 0 || pos >= size()){
      throw new IndexOutOfBoundsException();
    }
    int posCounter=0;
    ContainerC<T> tmpContainer = first;
    while ( posCounter < pos ){
      tmpContainer = tmpContainer.getNextElem();
      posCounter++;
    }
    return tmpContainer.getContent();
  }

  @SuppressWarnings("unchecked")
  @Override
  public void concat(List<T> list) {
    ContainerC<T> tmpContainer = first;
    ContainerC<T> stop = null;
    int start=0;
    if (first instanceof StopC<?> ){
      stop = first;
      first=(ContainerC<T>) new ContainerC<Object>(list.retrieve(start));
      tmpContainer=first;
      start++;
    } else {
      while ( !(tmpContainer.getNextElem() instanceof StopC<?>) ){
        tmpContainer = tmpContainer.getNextElem();
      } 
       // next Elem is the Stop, lets save it
      stop = tmpContainer.getNextElem();
    }
    
    ContainerC<T> newContainer = null;
    for(int i=start; i < list.size(); i++){
      newContainer=(ContainerC<T>) new ContainerC<Object>(list.retrieve(i));
      tmpContainer.setNextElem(newContainer);
      tmpContainer= newContainer;
    }

    tmpContainer.setNextElem(stop);
  }

  @Override
  public int size() {
    int len = 0;
    ContainerC<T> tmpContainer = first;  
    while ( !(tmpContainer instanceof StopC<?>) ){
      tmpContainer = tmpContainer.getNextElem();
      len++;
    }
    return len;
  }

 //----------------------------------------------------------------------------
  
  private void add(T elem){
    insert(size(), elem);
  }
  
  
  @SuppressWarnings("unchecked")
  private T[] getNotNullElems(T ... elems){
    int elemAnz=0;
    for (T elem : elems){
      if (elem != null){
        elemAnz++;
      }
    }
    T[] arr =(T[]) new Object[elemAnz];
    int i=0;
    for (T elem : elems){
      if (elem != null){
        arr[i] = elem;
        i++;
      }
    }
    return arr; 
  }
}
