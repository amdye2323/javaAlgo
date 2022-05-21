import java.util.ArrayList;

public class CodeTest02 {

    public static class person {
        int val;
        int preVal ;
        boolean check;

        person(){
            this.val = 0;
            this.preVal = 0;
            this.check = false;
        }

        void setVal (int val) {
            this.val = val;
        }

        void preVal (int preVal) {
            this.preVal = preVal;
        }

        void check (boolean check) {
            this.check = check;
        }
    }

    public static void main(String[] args) {
        int[] T = new int[]{0,0,1,2};
        int[] A = new int[]{1,2};

        ArrayList<person> arrayList = new ArrayList<>();

        int count = 0;

        for (int i = 0;i<T.length;i++) {
            person per = new person();

            per.val = i;
            per.preVal = T[i];

            arrayList.add(per);
        }

        for (int i = 0;i<A.length;i++) {
            // boolean flag = false;
            for (person p : arrayList){
                if (p.val == A[i]) {
                    int pre = p.preVal;
                    if (p.check==false){ // 노드에 추가
                        p.check = true;
                        count++;
                    }
                    while (true){

                        person pp = arrayList.get(pre);

                        if (pp.check==false){ // 노드에 추가
                            pp.check = true;
                            count++;
                        }

                        if (pre==0){ // 0이라면
                            break;
                        } else {
                            pre = pp.preVal;
                        }
                    }
                }
            }
        }

        System.out.println(arrayList);
    }

}
