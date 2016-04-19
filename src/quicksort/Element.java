package quicksort;

public class Element<T> {
  
  private long wert;
  
  private T data;
  
  public Element(long wert,T data){
    this.data=data;
    this.wert=wert;
  }
  
  public Element(T data){
    this((long)(Math.random()*10), data);
  }
  
  public Element(long wert){
    this(wert, null);
  }
  
  
  
  public long getWert(){
    return wert;
  }
  
  public T getData(){
    return data;
  }
  
  public void setWert(long wert){
    this.wert=wert;
  }
  
  public void setData(T data){
    this.data=data;
  }
}
