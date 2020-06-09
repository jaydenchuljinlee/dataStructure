package com.example.MST;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {
    private static int[] parent;
    private static boolean[] visited;


    private static class Graph implements Comparable<Graph>{
        int s;
        int e;
        int v;

        public Graph(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Graph o1) {
            return o1.v >= this.v ? -1 : 1;
        }
    }

    public static int find(int a) {

        if (a == parent[a]) return a;

        parent[a] = find(parent[a]);

        return parent[a];
    }

    public static void union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {

            parent[aRoot] = b;
        } else {

            return;
        }
    }

    public static void solution() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int E = sc.nextInt();

        sc.nextLine();

        parent  = new int[N+1];
        visited = new boolean[N+1];

        int answer = 0;

        PriorityQueue<Graph> pq = new PriorityQueue<>();

        while(E-- > 0) {

            String[] str = sc.nextLine().split(" ");

            pq.add(new Graph(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
        }

        for (int i = 1; i <= N; i++) parent[i] = i;

        while(!pq.isEmpty()) {

            Graph g = pq.poll();

            int start = g.s;
            int end   = g.e;

            int a = find(start);
            int b = find(end);

            if (a == b) continue;

            union(start,end);

            answer += g.v;
        }

        System.out.println(answer);
    }
}
