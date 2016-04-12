/**
 * 
 */
package a01_b;

//import a01.Elem;
import a01.List;

/**
 * @author Alexander Mendel & kafawi
 *
 */
public class ListB<T> implements List<T> {
  
  /**
   * Array, welches die Elemente Verwaltet
   */
  private ContainerB<T>[] array=null;
  
  /**
   * Verlängerungsvariable für die Arrayverlängerung
   */
  private int len;
  
  //---------------------------------------------------------------------------
  @SuppressWarnings("unchecked")
  public ListB(int len){
    this.len= (len > 10 )? len : 10 ;
    array=new ContainerB[this.len];
    array[0]=(StopB<T>) new StopB<Object>(-1);;
  }
  
  @SuppressWarnings("unchecked")
  public ListB(int len, T ... elems ){
    this.len= (len > 0 )? len : 10 ;
    
     // entferne alle Nuller
    int elemAnz=0;
    for (T elem : elems){
      if (elem != null){
        elemAnz++;
      }
    }
    array=new ContainerB[elemAnz+1];
    int j = 0;
    for (int i =0; i< elems.length; i++){
      if (elems[i] != null){
        array[j]=(ContainerB<T>) new ContainerB<Object>(elems[i], j-1, j+1);
        j++;
      }
    }
    array[elemAnz]=
        (StopB<T>) new StopB<Object>(elemAnz-1);  
  }
  
  
  @SuppressWarnings("unchecked")
  @Override
  public void insert(int pos, T elem) throws IndexOutOfBoundsException {
    if (pos < 0 || pos > size() ){
      throw new IndexOutOfBoundsException();
    }
    int insertIndex= array.length-1; 
    // Array vergrößern?
    if(array[array.length-1] != null ){
      ContainerB<T>[] tmpArray = new ContainerB[array.length+len];
      for (int i = 0; i < array.length; i++){
        tmpArray[i] = array[i]; 
      }
    insertIndex=array.length;
    array=tmpArray;
    } else {
    //berechne position im Array, (letzte freie stelle hinten.) 
      while (array[insertIndex-1] == null){
        insertIndex--;
      }
    }
    
    
    ContainerB<T> nextContainer = findFirstElement(); 
    for(int i=0; i < pos; i++){
      nextContainer=array[nextContainer.getNextIndex()];
    }
    
    // save Position for new one
    int previousIndex= nextContainer.getPreviousIndex();
    int nextIndex = array[nextContainer.getPreviousIndex()].getNextIndex();
    
    array[nextContainer.getPreviousIndex()].setNextIndex(insertIndex);
    nextContainer.setPreviousIndex(insertIndex);

    array[insertIndex] = 
        (ContainerB<T>) new ContainerB<Object>(
            elem,
            previousIndex,// previousIndex
            nextIndex // nextIndex
        );
  }

  @Override
  public void delete(int pos) throws IndexOutOfBoundsException {
    if (pos < 0 || pos >= size() ){
      throw new IndexOutOfBoundsException();
    }
    
    ContainerB<T> delContainer = findFirstElement(); 
    for(int i=0; i < pos; i++){
      delContainer=array[delContainer.getNextIndex()];
    }
    
    
    int previousIndex= delContainer.getPreviousIndex();
    int nextIndex = delContainer.getNextIndex();
    int thisIndex = array[nextIndex].getPreviousIndex();
    
    // umhängen
    array[previousIndex].setNextIndex(nextIndex);
    array[nextIndex].setPreviousIndex(previousIndex);
    
    // aus listze löschen.
    array[thisIndex] = null;
  }

  @Override
  public int find(T elem) {
    int counter=0;
    ContainerB<T> tmpContainer = findFirstElement();
    while( !(tmpContainer instanceof StopB<?>)){
      if (tmpContainer.getContent().equals(elem)){
        return counter;
      }
      counter++;
      tmpContainer=array[tmpContainer.getNextIndex()];
      //System.out.println("" + counter + tmpContainer.getNextIndex() );
    }
    return -1;
  }


  @SuppressWarnings("unchecked")
  @Override
  public void concat(List<T> list) {
    int newSize= array.length + list.size();
    // Stoppvariablen
    ContainerB<T> stopContainer = null;
    int stopIndex = -1;
    // neues Array
    ContainerB<T>[] tmpArray = new ContainerB[newSize];
    // Elemente Umschreiben
    for (int i=0; i< array.length; i++){
      tmpArray[i]= array[i];
      // catch the stop-Element
      if (tmpArray[i] instanceof StopB<?>){
        stopContainer = tmpArray[i];
        stopIndex=i;
      }
    }
    
    //list copy (deep copy of Containers, flat copy of Elements)
    for (int i = array.length; i < newSize; i++){
      tmpArray[i]=(ContainerB<T>) new ContainerB<Object>(
          list.retrieve(i-array.length),
          i-1,
          i+1
       ); 
    }
    
    
    
    //conecting the joins;
  //first new -> last old: Nextvalue of the last old
    int lastOld = stopContainer.getPreviousIndex();
    int firstNew = array.length;
    // StopPrev to last 
    stopContainer.setPreviousIndex(newSize-1);
    // LastNex to Stop
    tmpArray[newSize-1].setNextIndex(stopIndex);
    
    //first new -> last old
    tmpArray[firstNew].setPreviousIndex(lastOld);
    tmpArray[lastOld].setNextIndex(firstNew);
   
    array=tmpArray;
    
  }
  
  @Override
  public T retrieve(int pos) throws IndexOutOfBoundsException {
    if (pos < 0 || pos >= size() ){
      throw new IndexOutOfBoundsException();
    }
    ContainerB<T> tmpContainer = findFirstElement();
    for(int i=0; i < pos; i++){
      tmpContainer=array[tmpContainer.getNextIndex()];
    }
    return tmpContainer.getContent();
  }

  @Override
  public int size() {
    int counter=0;
    ContainerB<T> tmpContainer = findFirstElement();
    while( !(tmpContainer instanceof StopB<?>) ){
      counter++;
      tmpContainer=array[tmpContainer.getNextIndex()];
    }
    return counter;
  }
  
  // --------------------------------------------------------------------------
  
  
  private ContainerB<T> findFirstElement(){
    ContainerB<T> first = null;
    int i = 0;
    while(first == null && i < array.length){
      if (array[i].getPreviousIndex() == -1 ){
        first = array[i];
      }
      i++;
    }
    return first;
  }
  
  public void printArray(){
    for (int i=0; i < array.length ; i++){
      if (array[i] instanceof ContainerB<?>){
        System.out.println( "" + i + " " + array[i].getContent() +  " " + array[i].getPreviousIndex()+ " " + array[i].getNextIndex());
      } else {
        System.out.println("" + i + " nullinull");
      }
    }
    
  }
  
  //---------------------------------------------------------------------------


}
