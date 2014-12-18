import java.util.Scanner;

public class Q1 {
  
  public static int insert(int N, int M, int i, int j) {
   
    // Sequence of all 1s 
    int mask = ~0;
    
    // Create a sequence of j - i 1s
    mask = ~(mask << (j - i + 1));

    // Apply the mask to M
    M = M & mask;

    // Shift M left i bits
    M = M << i;

    // Move the mask left and complement it
    mask = ~(mask << i);
 
    N = N & mask;
    return M | N; 
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    int i = sc.nextInt();
    int j = sc.nextInt();
    int ans = insert(N, M, i, j);
    System.out.println(Integer.toBinaryString(N));
    System.out.println(Integer.toBinaryString(M));
    System.out.println(Integer.toBinaryString(ans));
    sc.close();
  }

}
