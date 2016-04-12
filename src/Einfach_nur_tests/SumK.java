package Einfach_nur_tests;

public class SumK {
  
  public static int recur(int N){
    int s;
    if(N > 1){
      s = recur(N-1);
    } else {
      s = 0;
    }
    s = s + N;
    return s;
  }
  
  public static int iter(int N){
    int s = 0;
    for (int k=1;k<=N;k++){
      s = s + k;
    }
    return s;
  }
  
  public static int gauss(int N){
    return (N*(N+1))/2;
  }
  
  public static Integer[] testNull(int anz){
    return new Integer[anz];
  }
  
  

  public static void main(String[] args) {
    int N = 10;
    
    System.out.println(recur(N));
    System.out.println(iter(N));
    System.out.println(gauss(N));
    Integer[] pp = new Integer[0];
    for (int i =0; i < pp.length; i++){
      System.out.println(pp[i]);
    }
    System.out.println(pp.length);
  }
  

}
