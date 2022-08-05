package com.example.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Searcher {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]a = new int[N];
        input(a, st, N);
        Arrays.sort(a);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[]b = new int[M];
        input(b, st, M);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            long fNum = b[i];
            sb.append(binarySearch(a, fNum)).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] a, long fn) {
        int left = 1, right = a.length-1;
        while(left<=right){
            int mid = (int)((left + right)/2);

            if(a[mid]>fn){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        if(a[left-1]==fn){
            return 1;
        }
        
        return 0;
    }

    public static void input(int[]arr, StringTokenizer st, int n){
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
