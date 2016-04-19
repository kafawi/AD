package quicksort;

public class Sort {

  
  
  
  static private long nVergleich; 
  
  static private long nSchreib;
  
  static private long nAufwand;
  
  
  
  private static void swap(Element<?>[] array, int i, int j){
    Element<?> tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  
  /**
   * put the median from [left, center, right]at the end of the the List (pivotposition) 
   * @param array
   * @param iStart
   * @param iEnd
   */
  private static void medianOf3(Element<?>[] array, int iStart, int iEnd){
    int iCenter = iStart + (iEnd-iStart)/2;
    // order the first and the middle 
    if (array[iStart].getWert() > array[iCenter].getWert()){
      swap(array, iStart, iCenter);
    }
    // oder the first and the last 
    if (array[iStart].getWert() > array[iEnd].getWert()){
      swap(array, iStart, iEnd);
    // oder the last with the middle
    } else if (array[iEnd].getWert() > array[iCenter].getWert()) {
      swap(array, iCenter, iEnd);
    }
  }
  
  private static int[] partition(Element<?>[] array, int iStart, int iEnd){
    int i = iStart;
    int j = iEnd;
    long pivot = array[iEnd].getWert();
    while(i <= j){
      while (array[i].getWert() < pivot) {
        i++;
      }
      while (array[j].getWert() > pivot) {
        j--;
      }
      if(i <=j){
        swap(array, i, j);
        i++;
        j--;
      }
    }
    return new int[]{j,i};
  }
  
  
  public static void qsortMedian(Element<?>[] array, int iStart, int iEnd){
    //berechne pivotindex
    // place the pivot to the end
    if(iEnd-iStart > 3){
      medianOf3(array,iStart, iEnd);
    }
    if(iStart < iEnd){
      int[] iBoundsJI = partition(array,iStart,iEnd);
      // call qsort recursively
      qsortMedian(array, iStart, iBoundsJI[0]);
      qsortMedian(array, iBoundsJI[1], iEnd);
    }
  }

  
  public static void qsortEnd(Element<?>[] array, int iStart, int iEnd){
    /**
     * Pivot is the middle of the array
     */
    if(iStart < iEnd){
      int[] iBoundsJI = partition(array,iStart,iEnd);
      // call qsort recursively
      qsortMedian(array, iStart, iBoundsJI[0]);
      qsortMedian(array, iBoundsJI[1], iEnd);
    }
  }
  
public static void qsortRandom(Element<?>[] array, int iStart, int iEnd){
    /**
     * Pivot is the middle of the array
     */
    swap(array, iStart+(int)(Math.random()*(iEnd-iStart+1)), iEnd); 
    if(iStart < iEnd){
      int[] iBoundsJI = partition(array,iStart,iEnd);
      // call qsort recursively
      qsortMedian(array, iStart, iBoundsJI[0]);
      qsortMedian(array, iBoundsJI[1], iEnd);
    }
  }
  
  @SuppressWarnings("rawtypes")
  public static void main(String a[]){
    Element[] input1 = {
      new Element<String>(24L),
      new Element<String>(2L),
      new Element<String>(45L),
      new Element<String>(20L),
      new Element<String>(56L),
      new Element<String>(75L),
      new Element<String>(2L),
      new Element<String>(56L),
      new Element<String>(99L),
      new Element<String>(53L),
      new Element<String>(12L)
    };
  
  
    Element[] bestinput1 = {
      new Element<String>(0L),
      new Element<String>(1L),
      new Element<String>(2L),
      new Element<String>(3L),
      new Element<String>(4L),
      new Element<String>(5L),
      new Element<String>(6L),
      new Element<String>(7L),
      new Element<String>(8L),
      new Element<String>(9L)
    };
  
    Sort.qsortMedian(input1, 0 , input1.length-1);
  
    Element[] input2= input1.clone();
    Element[] input3= input1.clone();
    
 
    Sort.qsortMedian(input1, 0 , input1.length-1);
    for(Element el:input1){
      System.out.print(el.getWert());
      System.out.print(" ");
    }
    System.out.print("\n");
    Sort.qsortEnd(input2, 0 , input2.length-1);
    for(Element el:input2){
      System.out.print(el.getWert());
      System.out.print(" ");
    }
    for(int i=0; i<10000; i++){
      System.out.print("\n");
      Sort.qsortRandom(input3, 0 , input3.length-1);
      for(Element el:input3){
        System.out.print(el.getWert());
        System.out.print(" ");
      }
    }
    Element[] inputleer=new Element[0];
    Sort.qsortMedian(inputleer, 0 , inputleer.length-1);
    for(Element el:inputleer){
      System.out.print(el.getWert());
      System.out.print(" ");
    }
    
  }
  
  
  
  
}
