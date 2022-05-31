package infrearn.twoArray;

public class subject04 {
    public int solution(int n, int m, int arr[]){
        int answer = 0;

        int lt = 0,rt=0;

        int compareValue = arr[lt];

        while (true){
            if(compareValue == m){
                answer++;
                rt ++;
            }else if(compareValue > m){
                lt ++;
                compareValue = compareValue - arr[lt-1];
            }else if(compareValue < m){
                rt ++;
                compareValue = compareValue + arr[rt] ;
            }else if(lt==rt){
                rt ++;
                compareValue = compareValue + arr[rt] ;
            }
            if(rt>=m){
                break;
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        subject04 sub = new subject04();

        System.out.println(sub.solution(8,6,new int[]{1,2,1,3,1,1,1,2}));
    }
}
