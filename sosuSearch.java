import java.util.*;

public class sosuSearch {
    static int maxNumber = 100000;
    static int[] a = new int[100001];

    static ArrayList<Integer> sosuNumbers = new ArrayList<>();

    static void primNumberSieve(){
        // 1. 배열을 생성하여 초기화
        for (int i = 2;i<=maxNumber;i++){
            a[i] = i;
        }

        // 2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운ㄷ.
        // (지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다)
        for (int i =2; i<=maxNumber;i++){
            if(a[i] == 0) continue; // 이미 지워진 수라면 건너뛰기

            // 이미 지워진 숫자가 아니라면, 그 배수부터 출발하여, 가능한 모든 숫자 지우기
            for (int j = 2*i;j<=maxNumber;j+=i) {
                a[j] = 0;
            }
        }

        // 3. 2부터 시작하여 남아있는 모든 수를 출력한다.
        for(int i = 2;i<=maxNumber;i++){
            if(a[i]!=0) {
                System.out.printf("%d",a[i]);
                sosuNumbers.add(a[i]);
            }
        }
    }

    public static void main(String[] args) {
        String numbers = "011";

        String[] splNumbers  = numbers.split("");

        primNumberSieve();

//        for(int a:sosuNumbers){
//            System.out.println(a);
//        }

        int aa =solution("011");

        System.out.printf("%d",aa);

    }

    public static int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }


}
