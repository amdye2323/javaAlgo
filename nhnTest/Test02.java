package nhnTest;
import java.util.*;

public class Test02 {

    public static class pointInfo {
        String owner;
        int point;
        pointInfo(String owner , int point){
            this.owner = owner;
            this.point = point;
        }
    }

    public static class person {
        int name;

        ArrayList<pointInfo> tranList;

        person(int name , int cache){
            this.name = name;
            pointInfo po = new pointInfo(name+"",cache);

            this.tranList = new ArrayList<>();
            tranList.add(po);
        }
    }

    public static void main(String[] args) {
        int[] balance = {30, 30, 30, 30};
        int[][] transaction = {
                {1, 2, 10},
                {2, 3, 20},
                {3, 4, 5},
                {3, 4, 30},
        };

        int[] abnormal = {1};

        int[] answer = new int[balance.length];

        ArrayList<person> list = new ArrayList<>();

        for(int i = 0;i< balance.length;i++){ // 보유 재화 체크
            int name = i+1;
            int cache = balance[i];

            person per = new person(name,cache);

            list.add(per);
        }

        for(int i = 0;i< transaction.length;i++){ // 재화 이동
            int point = transaction[i][2];
            for(person s:list){
                if(s.name == transaction[i][0]){ // 감소 대상

                    for(int p = s.tranList.size()-1;p>=0;p--){ // 보유 리스트 끝자락 부터
                        if(point>=1){
                            if(s.tranList.get(p).point>=point){ // 포인트 완 처리 가능한경우

                                for(person as:list){
                                    if(as.name == (transaction[i][1])){
                                        int plusPoint = point;
                                        String owner = s.tranList.get(p).owner;
                                        pointInfo po = new pointInfo(owner,plusPoint);
                                        as.tranList.add(po);
                                    }
                                }
                                s.tranList.get(p).point = s.tranList.get(p).point - point;

                                point = 0;

                            }else if(s.tranList.get(p).point>=1 || point >s.tranList.get(p).point){

                                for(person as:list){
                                    if(as.name == (transaction[i][1])){
                                        int plusPoint = s.tranList.get(p).point;
                                        String owner = s.tranList.get(p).owner;
                                        pointInfo po = new pointInfo(owner,plusPoint);
                                        as.tranList.add(po);
                                    }
                                }

                                point = point - s.tranList.get(p).point;
                                s.tranList.get(p).point = 0;
                            }
                        } else {
                            break;
                        }
                    }

                }

            }
        }

        for(int i = 0;i< abnormal.length;i++){ // 잘못 재화 제거
            int count = 0;
            for(person p :list){
                int totalPoint = 0;
                for(pointInfo info : p.tranList){
                    if(info.owner.equals(String.valueOf(abnormal[i]))){
                        info.point = 0;
                    }
                    totalPoint = totalPoint + info.point;
                }

                answer[count]= totalPoint;
                count++;
            }

        }


        System.out.println("체크");
    }
}
