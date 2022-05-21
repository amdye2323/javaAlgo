public class yogiTest01 {

    public static void main(String[] args) {
        double aa =solution(1);
        System.out.println((int)aa);
    }

    public static double solution(int A) {
        String n = String.valueOf(A);
        int wi = n.length() -1;

        double wwZ = Math.pow(10,wi);

        double dobA = Double.valueOf(A);

        int result = 0;

        if (dobA ==  wwZ) {
            result = (int) Math.floor(dobA);
        } else {
            double count = dobA % wwZ;
            result = (int) Math.floor(dobA - count);
        }
        return result;
    }


}
