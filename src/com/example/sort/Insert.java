package com.example.sort;

public class Insert {

    public static void sort(int[] arr) {

        int len = arr.length;

        for (int i = 1; i < len; i++) {

            int cur = arr[i];//기준

            int idx = i-1;//비교할 대상

            while (idx >= 0 && cur < arr[idx]) {

                arr[idx+1] = arr[idx];// 비교 대상이 큰 경우 오른쪽으로 밀어냄

                idx--;
            }

            arr[idx+1] = cur;
        }
    }
}
