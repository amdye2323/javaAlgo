public class programmerTest02 {
    public static int answer=0;
    public static int[] table = {1, 0};

    public static int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return answer;
    }

    public static void dfs(int depth,int sum,int[] numbers,int target){
        if(depth==numbers.length){

            if(sum==target){
                answer++;
            }
            return;
        }

        for(int i=0;i<2;i++){
            int num = table[i];
            if(num==1){
                sum+=numbers[depth];
            }else {
                sum-=numbers[depth];
            }

            dfs(depth+1,sum,numbers,target);

            if(num==1){
                sum-=numbers[depth];
            }else {
                sum+=numbers[depth];
            }

        }
    }

    public static void main(String[] args) {
        int[] number = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        solution(number, target);
    }
}
