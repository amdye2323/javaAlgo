import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class kakaoTest01 {

    public static class person {
        String name ;
        ArrayList<String> reportList ;
        ArrayList<String> stopList;

        person(String name, ArrayList<String> reportList , ArrayList<String> stopList ) {
            this.name = name;
            this.reportList = reportList;
            this.stopList = stopList;
        }
    }
    public static void main(String[] args) {
        String[] idList = new String[4];

        String[] report = new String[5];
        int count = 2;

        idList[0] = "muzi";
        idList[1] = "frodo";
        idList[2] = "apeach";
        idList[3] = "neo";

        report[0] = "muzi frodo";
        report[1] = "apeach frodo";
        report[2] = "frodo neo";
        report[3] = "muzi neo";
        report[4] = "apeach muzi";

        solution(idList, report , count);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        List<String> reportList = new ArrayList<String>(Arrays.asList(report)).parallelStream().distinct().collect(Collectors.toList());

        // 유저 리스트
        List<person> perList = new ArrayList<person>();

        // 정지 리스트
        HashMap<String,Integer> has = new HashMap<String,Integer>();

        for(String item: reportList) {
            // 신고자 
            String name = item.split(" ")[0];

            // 신고 당한 사람
            String stopName = item.split(" ")[1];

            // 새로 넣는게 아닌지 체크
            boolean action = false;

            // 중복 된다면 카운트 업
            for (int i = 0 ; i<perList.size(); i++){
                if (perList.get(i).name.equals(name)) {

                    // 리포트 대상 이름 추가
                    perList.get(i).reportList.add(stopName);

                    action = true;
                }
            }

            // 중복 아니라면 유저 리스트 업
            if (action == false) {

                // 리포트 대상 이름 추가
                ArrayList<String> addStopList = new ArrayList<String>();
                addStopList.add(stopName);

                ArrayList<String> newList = new ArrayList<String>();
                
                person per = new person(name, addStopList, newList);

                perList.add(per);
            }

            // 신고 리스트 업
            int hasCount = (int) has.getOrDefault(stopName, 0) + 1;
            has.put(stopName, hasCount);
        }

        // 신고 리스트 중 정지 된 리스트 만

        System.out.println(reportList);
        System.out.println("\n");

        for(person p : perList) {
            System.out.println(p.name +" : "+ p.reportList + " : " + p.stopList);
        }

        System.out.println("\n");
        System.out.println(has);

        System.out.printf("---------------------------------\n");

        has.forEach((strKey,strValue) -> {
            // 정지가 된 사람 일 경우
            if (strValue>=k) {
                for(person p : perList) {
                    // 유저가 신고한 ID 중에 정리 이름이 있는 경우
                    if (p.reportList.contains(strKey)){
                        p.stopList.add(strKey);
                    }
                }
            }
        });

        int[] answer = new int[id_list.length];

        for (int i = 0 ;i<id_list.length;i++) {
            for(person p : perList) {
                if (p.name.equals(id_list[i])) {
                    answer[i] = p.stopList.size();
                }
            }
        }

        for(person p : perList) {
            System.out.println(p.name +" : "+ p.reportList + " : " + p.stopList);
        }

        for(int ab : answer){
            System.out.println(ab);
        }

        return answer;
    }

    public int[] solutionOther(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
