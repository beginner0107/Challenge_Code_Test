class 소수만들기 {
    public int solution(int[] nums) {
        int cnt = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int n=j+1;n<nums.length;n++){
                    int sum = nums[i] + nums[j] + nums[n];
                    if(isPrime(sum)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private boolean isPrime(int sum) {
        if(sum==0||sum==1) return false;
        for(int i=2;i*i<=sum;i++){
            if(sum%i==0) return false;
        }
        return true;
    }
}