import java.util.ArrayList;


public class KakaoTest03 {

    public static class shootList {
        int amount ;
        ArrayList<Integer> list ;
        shootList(int amount , ArrayList<Integer> list){
            this.amount = amount;
            this.list = list;
        }
    }

    public static int sumList(int[] list) {
        int apAmount = 0;
        for (int a = 10, i = 0;a>=0;a--,i++) {
            if (list[i]>=1) {
                apAmount = apAmount + a;
            }
        }
        return apAmount;
    }

    public static int sumArrList(ArrayList<Integer> list) {
        int apAmount = 0;
        for (int a = 10, i = 0;a>=0;a--,i++) {
            if (list.get(i)>=1) {
                apAmount = apAmount + a;
            }
        }
        return apAmount;
    }

    public static void main(String[] args) {
        int n = 9;
        int[] info = new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        solution(n , info);
    }

    public static int[] solution(int n, int[] info) {
        //int apAmount = sumList(info); //어피치 총합

        ArrayList<shootList> arrList = new ArrayList<>();

        for (int i = 0; i<info.length; i++) {
            int count = n;

            ArrayList<Integer> arr = new ArrayList<>();

            for (int e = 0 ;e<i;e++) { // 왼쪽은 0으로 채워넣음
                arr.add(0);
            }

            for(int j = i;j<info.length;j++) {
                if (count>=info[j]+1) { // 어피치 만큼 쏠수 있는 경우
                    count = count - (info[j]+1);
                    arr.add(info[j]+1);
                }else {
                    arr.add(0);
                }
            }

            int liAmount = sumArrList(arr);

            shootList shot = new shootList(liAmount,arr);

            arrList.add(shot);

        }


        int checkCount = 0;
        boolean check = false;
        int exSum = 0;

        for(int i = 0;i<arrList.size();i++){
            ArrayList<Integer> cList = arrList.get(i).list;
            int[] cIntList = info.clone();

            for (int c = 0;c<cList.size();c++) {
                if (cList.get(c)>=1) {
                    cIntList[c] = 0;
                }
            }

            int aMount = sumList(cIntList);

            if (aMount<arrList.get(i).amount && exSum <= arrList.get(i).amount) {
                check = true;
                exSum = arrList.get(i).amount;
                checkCount = i;
            }
        }

        if (check == false) {
            return new int[]{-1};
        }

        return arrList.get(checkCount).list.stream().mapToInt(i -> i).toArray();

    }
}
