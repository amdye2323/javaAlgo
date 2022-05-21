public class favonachi {
    public static void main(String[] args) {
        hanoi(3,1,2,3);
        return ;
    }

    public static int favo (int n) {
        if (n == 1 || n ==2) return 1;
        else return favo(n-1) + favo(n-2);
    }

    public static void move(int from , int to) {
        System.out.printf("%d => %d\n",from,to);
    }

    public static void hanoi(int n, int from, int by, int to){
        /**
         * 기둥 1에서 N개의 원반을 기둥2를 이요하여 기둥3으로 옮기는 알고리즘
         * 1. 기둥1에서 N-1개의 원반을 기둥3을 이용하여 기둥2로 옮긴다
         * 2. 기둥에서 1개의 원반을 기둥3으로 옮긴다
         * 3. 기둥2에서 N-1 개의 원반을 기둥1을 이용하여 기둥3으로 옮긴다
         */
        if(n == 1){
            move(from, to);
        }else{
            hanoi(n-1 , from , to ,by);
            move(from , to);
            hanoi(n-1,by,from,to);
        }
    }
}
