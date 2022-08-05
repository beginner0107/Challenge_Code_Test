package com.example.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KNum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1, right = k;

        while(left<=right){
            long mid = (left + right) / 2;
            // mid = 4
            // mid = 6
            // mid = 5
            int cnt = 0;
            for(int i=1;i<=n;i++){
                cnt += Math.min(mid/i, n);
            }
            // 합이 k와 같거나 크면
            // cnt = 3 + 2 + 1 = 6
            // cnt = 3 + 3 + 2 = 8
            // cnt = 3 + 2 + 1 = 6
            if(cnt>=k){
                right = mid - 1;
                // right = 5
            }else{
                left = mid + 1;
                // left = 5
                // left = 6 out->
            }
        }
        System.out.println(left);
    }
}
