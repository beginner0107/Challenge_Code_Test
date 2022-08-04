package com.example.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarLessons {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int []a = new int[n];
        long sum = 0, left = -1;
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
            left = Math.max(left, a[i]);
        }
        long right = sum;

        while(left <= right){
            long cnt = 0, tempSum = 0;
            long mid = (left + right) /2;

            for(int i=0;i<n;i++){
               
                if(tempSum + a[i] > mid){
                    tempSum = 0;
                    cnt += 1;
                }
                tempSum += a[i];
            }
            if(tempSum!=0) cnt +=1;
            if(cnt<=m){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left);

    }
}
