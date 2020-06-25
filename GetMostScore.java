import java.util.Scanner;

public class GetMostScore {
    public static void getMostScore() {
        Integer totalTime = 120;
        Scanner in = new Scanner(System.in);
        Integer numberOfQuestion = in.nextInt();

        int[] partTime = new int[numberOfQuestion];
        int[] fullTime = new int[numberOfQuestion];
        int[] partScore = new int[numberOfQuestion];
        int[] fullScore = new int[numberOfQuestion];

        for (int i = 0; i < numberOfQuestion; ++i) {
            partTime[i] = in.nextInt();
            partScore[i] = in.nextInt();
            fullTime[i] = in.nextInt();
            fullScore[i] = in.nextInt();
        }

        int[][] dp = new int[numberOfQuestion + 1][totalTime + 1];

        for (int i = 0; i < dp.length; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; ++i) {
            dp[0][i] = 0;
        }

        for (int ques = 1; ques <= numberOfQuestion; ++ques) {
            for (int time = 1; time < totalTime; ++time) {
                //Problem
                if (partTime[ques - 1] <= time || fullTime[ques - 1] <= time) {
                    Integer pass = dp[ques - 1][time];
                    Integer ps = partScore[ques - 1] + dp[ques - 1][time - partTime[ques - 1]];
                    Integer fs = fullScore[ques - 1] + dp[ques - 1][time - fullTime[ques - 1]];
                    Integer max = 0;
                    if (pass > max) max = pass;
                    if (ps > max) max = ps;
                    if (fs > max) max = fs;
                    dp[ques][time] = max;
                } else {
                    dp[ques][time] = dp[ques - 1][time];
                }
            }
        }

        System.out.println(dp[numberOfQuestion][totalTime]);
    }
}
