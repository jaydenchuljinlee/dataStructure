package com.example.MST;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
    private static ArrayList<Graph>[] list;
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

    public static int MST() throws Exception{

        int ans = 0;

        PriorityQueue<Graph> pq = new PriorityQueue<>();

        Queue<Integer> q = new Queue<>();

        q.enqueue(1);

        while(!q.isEmpty()) {

            int cur = q.dequeue();

            visited[cur] = true;

            ArrayList<Graph> sub = list[cur];

            for (Graph g : sub) {

                if (!visited[g.e]) {

                    pq.add(g);
                }
            }

            while(!pq.isEmpty()) {

                Graph g = pq.poll();

                if (!visited[g.e]) {

                    visited[g.e] = true;

                    ans += g.v;
                    q.enqueue(g.e);
                    break;
                }
            }
        }


        return ans;
    }

    public static void solution() throws Exception{

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int E = sc.nextInt();

        list = new ArrayList[N+1];

        for (int i = 1; i <= E; i++) list[i] = new ArrayList<>();

        while(E-- > 0) {

            String[] str = sc.nextLine().split(" ");

            list[Integer.parseInt(str[0])].add(new Graph(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));

            list[Integer.parseInt(str[1])].add(new Graph(Integer.parseInt(str[1]),Integer.parseInt(str[0]),Integer.parseInt(str[2])));
        }

        int answer = MST();

        System.out.println(answer);
    }
}
