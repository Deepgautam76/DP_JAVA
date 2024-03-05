//Stock profit question

public class stockProfit {
    public static int bestTimeToBuyAndSellStock(int []prices) {
        // Write your code here.


        int minValue=prices[0];
        int profit=0;

        for(int pri:prices){
            minValue=Math.min(pri,minValue);
            profit=Math.max(profit,pri-minValue);
            System.out.print(profit+" ");
        }
        System.out.println();
        return profit;
    }

    public static void main(String[] args){
        int arr[]={7,1,5,4,3,6};
        int Tprofit=bestTimeToBuyAndSellStock(arr);
        System.out.println(Tprofit);
    }
}