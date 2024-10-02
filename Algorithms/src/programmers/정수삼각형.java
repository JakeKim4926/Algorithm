package programmers;

public class 정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        answer = dp[0][0];
        for(int i = 0; i < triangle.length-1; i++) {
            for(int j = 0; j <= i+1; j++) {
                int left = 0;
                if(j > 0)
                    left = dp[i][j-1] + triangle[i+1][j];
                int right = dp[i][j] + triangle[i+1][j];

                dp[i+1][j] = Math.max(left, right);
                answer = Math.max(answer, dp[i+1][j]);
            }
        }

        return answer;
    }

//    public int solution(int[][] triangle) {
//        int answer = 0;
//
//        int[][] dp = new int[triangle.length][triangle.length];
//
//        dp[0][0] = triangle[0][0];
//
//        for(int i = 0; i < triangle.length-1; i++) {
//            for(int j = 0; j < triangle[i].length; j++){
//                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
//                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
//            }
//        }
//
//        for(int j = 0; j < triangle.length; j++) {
//            answer = Math.max(dp[triangle.length-1][j], answer);
//        }
//
//        return answer;
//    }
}
