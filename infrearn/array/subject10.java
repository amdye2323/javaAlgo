package infrearn.array;

public class subject10 {

    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};

    public int solution1(int n,int[][] arr){
        int answer =0;
        int[][] arrList = new int[n+2][n+2];

        for(int i= 1;i<n+1;i++) {
            for(int j = 1;j<n+1;j++) {
                arrList[i][j] = arr[i-1][j-1];
            }
        }

        for(int i= 1;i<arrList.length-1;i++){
            for(int j = 1;j<arrList.length-1;j++) {
                if(arrList[i][j]<arrList[i-1][j]) {}
                else if(arrList[i][j]<arrList[i+1][j]) {}
                else if(arrList[i][j]<arrList[i][j-1]) {}
                else if(arrList[i][j]<arrList[i][j+1]){}
                else answer++;
            }
        }

        return answer;
    }

    public int solution(int n, int[][] arr){
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boolean flag=true;
                for(int k=0; k<4; k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]>=arr[i][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        subject10 sub = new subject10();

        int[][] list = new int[][]{
                {5,3,7,2,3} ,
                {3,7,1,6,1} ,
                {7,2,5,3,4} ,
                {4,3,6,4,1} ,
                {8,7,3,5,2}
        };

        System.out.println(sub.solution(5,list));
    }
}
