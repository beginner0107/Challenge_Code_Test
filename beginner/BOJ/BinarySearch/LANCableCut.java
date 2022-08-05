package com.example.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LANCableCut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(br.readLine());
            max = Math.max(a[i], max);
        }

        long left = 1, right = max;

        while(left<=right){
            long mid = (left + right)/2;
            long cnt = 0;
            for(int i=0;i<n;i++){
                if(mid<=a[i]){
                    long ans = a[i] / mid;
                    cnt += ans;
                }
            }

            if(cnt>=m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            System.out.println("left = " + left + "  right = " + right);
        }
        System.out.println(left-1);
    }
}
