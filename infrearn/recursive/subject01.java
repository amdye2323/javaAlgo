package infrearn.recursive;

public class subject01 {
    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n-1);
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        subject01 sub = new subject01();

        sub.DFS(3);
    }
}
