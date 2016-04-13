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
    first =(ContainerC<T>) new ContainerC<Object>(start);
    first.setNextElem( (StopC<T>) new StopC<Object>());
  }
  
  @SuppressWarnings("unchecked")
  public ListC(T ... elems){
    int elemAnz=0;
    for (T elem : elems){
      if (elem != null)
        elemAnz++;
    }
    if (elemAnz == 0){
      first = null;
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
        ContainerC<T> tmpContainer = (ContainerC<T>) new ContainerC<Object>(notNullElems[1]);
        first.setNextElem(tmpContainer);
        if (elemAnz > 1){
          for (int j=2; j < elemAnz; j++){
            ContainerC<T> nextContainer = (ContainerC<T>) new ContainerC<Object>(notNullElems[j]);
            tmpContainer.setNextElem(nextContainer);
            tmpContainer = nextContainer;
          }
        }
        tmpContainer.setNextElem((StopC<T>) new StopC<Object>());
      }
    }
    
    first = (ContainerC<T>) new ContainerC<Object>(elems[0]);
    if (elems.length > 1){
      first.setNextElem( (StopC<T>) new StopC<Object>());
    } else
      first.setNextElem( (StopC<T>) new StopC<Object>());
  }

  @Override
  public void insert(int pos, T elem) throws IndexOutOfBoundsException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(int pos) throws IndexOutOfBoundsException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int find(T elem) {
    int foundCounter=-1;
    T tmp = first.getContent();
    while(tmp!=null){
      if(tmp==elem){
        return foundCounter;
      }else {
        foundCounter++;
//        tmp=first.getNextElem();
      }
    }
    return foundCounter;
  }

  @Override
  public T retrieve(int pos) throws IndexOutOfBoundsException {
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
  
  //---------------------------------------------------------------------------
  
  
  //---------------------------------------------------------------------------
  

}
