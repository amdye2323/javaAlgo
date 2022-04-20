import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KakaoTest02 {

    public static class carIO {
        String carName;
        int time;
        String inOut;

        carIO(String carName , int time, String inOut) {
            this.carName = carName;
            this.time = time;
            this.inOut = inOut;
        }
    }
    public static void main(String[] args) {
        int[] fees = new int[]{120, 0, 60, 591};
        String[] records = new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        solution(fees,records);
    }

    public static int[] solution(int[] fees, String[] records) {

        ArrayList<carIO> carIOArrayList = new ArrayList<>();

        for (String item :  records) {
            String carName = item.split( " ")[1];
            String time = item.split( " ")[0];
            String inOut = item.split( " ")[2];

            String[] ls = time.split(":");

            int min = Integer.parseInt(time.split(":")[0]) * 60;
            int sec = Integer.parseInt(time.split(":")[1]);

            carIO car = new carIO(carName,(min+sec),inOut);

            carIOArrayList.add(car);
        }



        for (carIO car : carIOArrayList) {
            System.out.println(car.carName + " : " + car.time +" : " + car.inOut);
        }

        HashMap<String,Integer> has = new HashMap<>();

        for (int i = 0; i<carIOArrayList.size();i++) {
            if (carIOArrayList.get(i).inOut.equals("IN")) { // 만약 이게 들어온 차라면
                boolean fal = false;
                for (int j = i; j<carIOArrayList.size();j++) { // OUT을 찾아야 함
                    if (carIOArrayList.get(i).carName.equals(carIOArrayList.get(j).carName) && carIOArrayList.get(j).inOut.equals("OUT")) {
                        String carName = carIOArrayList.get(j).carName;
                        int regTime = (carIOArrayList.get(j).time-carIOArrayList.get(i).time);
                        has.put(carName,has.getOrDefault(carName,0)+regTime);
                        fal = true;
                        break;
                    }
                }

                if (fal == false) {// IN 인데 못 찾았을시
                    String carName = carIOArrayList.get(i).carName;
                    int regTime = (1439-carIOArrayList.get(i).time);
                    has.put(carName,has.getOrDefault(carName,0)+regTime);
                }
            }
        }
        int[] answer = new int[has.size()];

        Object[] mapKey = has.keySet().toArray();
        Arrays.sort(mapKey);

        int count = 0;

        for (Object name:mapKey) {
            int fir = fees[0];
            int sec = fees[1];
            int thi = fees[2];
            int forth = fees[3];
            int getTime = has.get(name) - fir;

            if (getTime>=1) {
                float add = (float) ( ( getTime ) / (double)thi );

                answer[count] = (int) (sec+ ( Math.ceil(add) * forth ));
            }else {
                answer[count] = sec;
            }
            count++;
        }
        for (int a : answer) {
            System.out.println(a);
        }

        return answer;
    }
}
