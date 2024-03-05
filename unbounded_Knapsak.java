import java.util.*;

public class unbounded_Knapsak {

    // unbounded Knapsak problem using the tabulation method
    public static int knapsakTab(int val[], int wt[],int w){
        
        int n=val.length;
        int[][] dp = new int[n+1][w+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                 int v=val[i-1]; //ith item value
                 int wet=wt[i-1]; //ith item weight
                if(wet<=j){   //valid case
                    // //include condition of the 0-1 kanpsak
                    // int incProfit=v+dp[i-1][j-wet];   
                    //include condition of the unbounded kanpsak simple change dp[i-1]=dp[i] in the only include condition
                    int incProfit=v+dp[i][j-wet];      
                    //exclude
                     int exProfit=dp[i-1][j];      
                    dp[i][j]=Math.max(incProfit, exProfit);
                }else{ //unvalid case
                    dp[i][j]=dp[i-1][j]; 
                }
            }
        }
        return dp[n][w];
    }
    
    public static void main(String args[]){
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        System.out.println(knapsakTab(val, wt, w));
    }
}
