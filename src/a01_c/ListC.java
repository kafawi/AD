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
  
  private ContainerC<T> first;
  
  //---------------------------------------------------------------------------
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
    int elemAnz=0;
    for (T elem : elems){
      if (elem != null)
        elemAnz++;
    }
    if (elemAnz == 0){
      first = (StopC<T>) new StopC<Object>();
    } else {
      first = (ContainerC<T>) new ContainerC<Object>(elems[0]);
      if (elemAnz == 1){
        first.setNextElem( (StopC<T>) new StopC<Object>());
      } else {
        T[] notNullElems = (T[]) new Object[elemAnz];
        int i=0;
        for (T elem : elems){
          if (elem != null){
            notNullElems[i] = elem;
            i++;
          }
        }
        ContainerC<T> tmpContainer = 
            (ContainerC<T>) new ContainerC<Object>(notNullElems[1]);
        first.setNextElem(tmpContainer);
        if (elemAnz > 1){
          for (int j=2; j < elemAnz; j++){
            ContainerC<T> nextContainer = 
                (ContainerC<T>) new ContainerC<Object>(notNullElems[j]);
            tmpContainer.setNextElem(nextContainer);
            tmpContainer = nextContainer;
          }
        }
        tmpContainer.setNextElem((StopC<T>) new StopC<Object>());
      }
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public void insert(int pos, T elem) throws IndexOutOfBoundsException {
    if (pos < 0 || pos > size()){
      throw new IndexOutOfBoundsException();
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

  @Override
  public void concat(List<T> list) {
    // TODO Auto-generated method stub
    
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
  
  //---------------------------------------------------------------------------
  
  
  //---------------------------------------------------------------------------
  

}
