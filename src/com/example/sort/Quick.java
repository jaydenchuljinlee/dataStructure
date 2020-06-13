package com.example.sort;

public class Quick {

    public static void sort(int[] arr, int start, int end) {

        if (start >= end) return;

        int pivot = arr[(start+end)/2];
        int s = start;
        int e = end;

        while(start <= end) {

            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end++;

            if (start <= end) {

                int temp = arr[start];

                arr[start] = arr[end];
                arr[end]   = temp;
                start++;
                end--;
            }
        }

        sort(arr,s,end);
        sort(arr,start,e);
    }
}
