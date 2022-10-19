class 주식가격 {
    static int a;
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        a = 0;
        for(int i=0;i<prices.length;i++){
            answer[i] = period(prices, i);
            a = 0;
        }
        
        return answer;
    }
    
    public int period(int[]prices, int basic){
        if(basic+1==prices.length) return 0;
        for(int i=basic+1;i<prices.length;i++){
            if(prices[basic]<=prices[i]){
                a++;
            }else if(prices[basic]>prices[i]){
                return a+1;
            }
        }
        return a;
    }
}