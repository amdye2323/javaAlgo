package infrearn.recursive;

public class subject02 {

    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n/2);
            System.out.print(n%2+" ");
        }
    }

    public static void main(String[] args) {
        subject02 sub = new subject02();
        sub.DFS(11);
    }
}
