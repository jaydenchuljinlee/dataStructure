package com.example.sort;

public class Selection {

    public static void sort(int[] arr) {

        int len = arr.length;
        int min = 0;//최솟값을 가진 인덱스를 저장
        int temp =0;

        for (int i = 0; i < len-1; i++) {//마지막 요소는 정렬됨

            min = i;

            for (int j = 1; j < len; j++) {

                if (arr[min] > arr[j]) {

                    min = j;
                }
            }

            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = min;
        }
    }
}
