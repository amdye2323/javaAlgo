package kakaoEnter;
import java.io.*;
import java.util.*;

public class Test01 {
    static ArrayList<hintInfo> hintList = new ArrayList<>();
    public static class hintInfo{
        int x;
        int y;
        int data;
        hintInfo(int x,int y,int data){
            this.x = x;
            this.y = y;
            this.data = data;
        }
    }

    static int startX = 0;
    static int startY = 0;

    public static int solution(int m){
        int answer = 0;

        int x = startX;
        int y = startY;

        for(int i = 1;i<=m;i++){
            for(int j = 0;j<m-1;j++){
                if(hintList.get(j).data == i){
                    int plusX = (hintList.get(j).x - x)<0?(hintList.get(j).x - x)*-1:(hintList.get(j).x - x);
                    int plusY = (hintList.get(j).y - y)<0?(hintList.get(j).y - y)*-1:(hintList.get(j).y - y);
                    answer +=  plusX;
                    answer +=  plusY;

                    x = hintList.get(j).x;
                    y = hintList.get(j).y;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Scanner kb = new Scanner(System.in);
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);

        int[][] arr=new int[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                int data = Integer.valueOf(line[j]);
                arr[i][j]=data;
                if(data!=0){
                    if(data==1){
                        startX = i;
                        startY = j;
                    } else {
                        hintInfo info = new hintInfo(i,j,data);
                        hintList.add(info);
                    }

                }
            }
        }

        System.out.print(solution(m));

    }
}
