package com.example.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallTheRouter {

    public static int[] house;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집의 개수
        int n = Integer.parseInt(st.nextToken());
        // 공유기의 개수
        long c = Integer.parseInt(st.nextToken());

        house = new int[n];

        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1, right = house[n-1] - house[0] + 1;

        while(left<=right){
            int mid = (left + right) / 2;

            int lastLocate = house[0];
            int cnt = 1;
            for(int i=1;i<n;i++){
                int locate = house[i];
                if(lastLocate + mid < house[i]){
                    lastLocate = locate;
                    cnt++;
                }
            }
            if(cnt>=c){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
