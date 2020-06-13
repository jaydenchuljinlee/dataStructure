package com.example.sort;

public class Heap {

    private static void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void heapify(int[] arr, int n, int i) {

        int p = i;
        int l = i*2 + 1;
        int r = i*2 + 2;

        if (l < p && arr[p] < arr[l]) {

            p = l;
        }

        if (r < p && arr[p] < arr[r]) {

            p = r;
        }

        if (p != i) {
            swap(arr,p,i);
            heapify(arr,n,p);
        }
    }

    public static void sort(int[] arr) {

        int n = arr.length;

        for (int i = n/2 - 1; i >= 0; i--) {

            heapify(arr,n,i);
        }

        for (int i = n-1;i > 0; i--) {
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
}
