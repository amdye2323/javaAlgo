package infrearn.array;

public class subject11 {

    public int solution1(int n , int arr[][]){
        int answer = 0;
        int[] answerList = new int[n];

        for(int row = 0 ;row<n;row++){
            int count = 0;
            for(int j=0;j<n;j++){

                for(int i = 0;i<n;i++){
                    int rowNumber = arr[row][j];

                }
            }
            answerList[row] = count;
        }

        return answer;
    }

    public int solution(int n, int[][] arr){

        int answer=0, max=Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            int cnt=0;
            for(int j=1; j<=n; j++){
                for(int k=1; k<=5; k++){
                    if(arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max=cnt;
                answer=i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        subject11 sub = new subject11();

        int[][] list = new int[][]
        {
                {0,0,0,0,0,0},
                {0,2,3,1,7,3},
                {0,4,1,9,6,8},
                {0,5,5,2,4,4},
                {0,6,5,2,6,7},
                {0,8,4,2,2,2}
        };

        System.out.println(sub.solution(5,list));
    }
}
