import java.util.*;

public class perfectSearch {
    public static void main(String[] args) {
        int[] answers = new int[]{1,3,2,4,2};

        int[] re = solution(answers);

        System.out.print(re);
    }

    public static int[] solution(int[] answers){
        int[] oneList = new int[]{1, 2, 3, 4, 5};
        int[] twoList = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] threeList = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count = 0;

        int[] answerList = new int[3];

        for (int i = 0;i< answers.length;i++) {

            if (answers[i] == oneList[i % oneList.length]) {
                answerList[0] = answerList[0] +1;
            }
            if (answers[i] == twoList[i % twoList.length]) {
                answerList[1] = answerList[1] +1;
            }
            if(answers[i] == threeList[i % threeList.length]) {
                answerList[2] = answerList[2] +1;
            }
        }

        int maxTotal = Math.max(answerList[0],Math.max(answerList[1],answerList[2]));

        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0;i< answerList.length;i++) {
            if (maxTotal == answerList[i]) {
                arrList.add(i+1);
            }
        }

        return arrList.stream().mapToInt(i -> i).toArray();
    }
}
