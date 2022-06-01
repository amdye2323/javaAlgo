package infrearn.recursive;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}

public class subject07 {
    Node root;

    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L+" : ");
            for (int i = 0;i<len;i++){
                Node cur = Q.poll();
                System.out.print(cur.data+ " ");

            }
        }
    }

    public static void main(String[] args) {
        subject07 sub = new subject07();
        sub.root = new Node(1);
        sub.root.lt = new Node(2);
        sub.root.rt = new Node(3);
        sub.root.lt.lt = new Node(4);
        sub.root.lt.rt = new Node(5);
        sub.root.rt.lt = new Node(6);
        sub.root.lt.rt = new Node(7);
        sub.BFS(sub.root);
    }
}
