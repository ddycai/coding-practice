import java.io.*;

/**
 * Problem Statement:
 * https://code.google.com/codejam/contest/6224486/dashboard#s=p0
 *
 * We keep track of the number of people standing up and the number of people
 * needed. At each shyness level, we check if the number of people standing up
 * plus the number people needed is less than the shyness level. If it is, then
 * we set the number of people needed to the difference between the shyness
 * level and the number of people standing up so far. Then, we add S[i] (the
 * number of people at shyness level i) to the number of people standing up so
 * far.
 */

public class StandingOvation
{

  public static int solve(char[] S) {
    int sofar = 0;
    int needed = 0;
    for(int i = 0; i < S.length; i++) {
      if(S[i] - '0' > 0 && sofar + needed < i)
        needed = i - sofar;
      sofar += S[i] - '0';
    }
    return needed;
  }

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
    int T = Integer.parseInt(line);
    for(int i = 1; i <= T; i++) {
      line = br.readLine();
      String[] tokens = line.split(" ");
      int res = solve(tokens[1].toCharArray());
      System.out.format("Case #%d: %d\n", i, res);
    }
	}
}
