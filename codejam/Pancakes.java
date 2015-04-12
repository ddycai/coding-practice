import java.io.*;

/**
 * Problem Statement:
 * https://code.google.com/codejam/contest/6224486/dashboard#s=p1
 * 
 * We check the number of moves required to finish all the pancakes if every
 * pancake stack was broken into chunks of pancakes of size h for h = 1 ..
 * max(P[i]). To do this, we divide every stack that has height, P[i], greater
 * than h into ceil(P[i]/h) pieces. This takes ceil(P[i]/h) - 1 moves and we
 * add this to the time. Then the total time to finish the pancakes is h + the
 * total time to break the pancake stack into pieces. We take the minimum of
 * this time.
 *
 * This method runs in ~O(D*max(P[i])) time which is quadratic in the size of
 * input. However, it runs in time for the large test case.
 */

public class Pancakes
{

  public static int solve(int[] P, int max) {
    int res = Integer.MAX_VALUE;
    for(int h = 1; h <= max; h++) {
      int t = 0;
      for(int p : P) {
        if(p > h) {
          if(p % h == 0)
            t += p/h - 1;
          else
            t += p/h;
        }
      }
      res = Math.min(h + t, res);
    }
    return res;
  }


	public static void main(String[] args) throws IOException
	{  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int t = 1; t <= T; t++) {
      int D = Integer.parseInt(br.readLine());
      int[] P = new int[D];
      String[] tokens = br.readLine().split(" ");
      int max = 0;
      for(int i = 0; i < P.length; i++) {
        P[i] = Integer.parseInt(tokens[i]);
        max = Math.max(P[i], max);
      }
      System.out.format("Case #%d: %d\n", t, solve(P, max));
    }
    br.close();
	}
}
