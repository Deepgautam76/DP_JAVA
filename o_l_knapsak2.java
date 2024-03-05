import java.util.*;

public class o_l_knapsak2 {

    // print the dp array
    public  static void prinVal(int dp[][]){
        System.out.println("all table of 2D arrays");
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    // 0-1 knapsak tabulation method
    public static int knapsakTab(int val[], int wt[],int w){
        
        int n=val.length;
        int[][] dp = new int[n+1][w+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                 int v=val[i-1]; //ith item value
                 int wet=wt[i-1]; //ith item weight
                if(wet<=j){   //valid case
                    //include
                    int incProfit=v+dp[i-1][j-wet];        
                    //exclude
                     int exProfit=dp[i-1][j];      
                    dp[i][j]=Math.max(incProfit, exProfit);
                }else{ //unvalid case
                    dp[i][j]=dp[i-1][j]; 
                }
            }
        }
        prinVal(dp);
        return dp[n][w];
    }

    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);

        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        int ans=knapsakTab(val, wt, w);
        System.out.println(ans);
    }
    
}
