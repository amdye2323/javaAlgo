// Station List 클래스 정의
class StationList {
    public String name;
    public int next;
}

// 연결 리스트를 다루는 클래스 정의
public class LinkedList<I extends Number> {
    // 연결 리스트의 실체가 되는 배열(요소 수는 최대 10으로 한다)
    public static StationList[] list = new StationList[10];

    // head 선언
    public static int head;

    // 연결 리스트의 초기 상태를 만드는 함수
    public static void initStationList() {
        // 자바에서는 인스턴스 생성이 필요함
        // 의사 코드 및 c에서는 불필요
        for (int i = 0; i < list.length; i++) {
            list[i] = new StationList();
        }

        // 역 이름과 연결 정보를 설정
        list[0].name = "부산";
        list[0].next = -1;

        list[1].name = "대전";
        list[1].next = 3;

        list[2].name = "서울";
        list[2].next = 4;

        list[3].name = "동대구";
        list[3].next = 0;

        list[4].name = "천안아산";
        list[4].next = 1;

        // 헤더 값 설정
        head = 2;
    }

    // 연결 리스트의 요소를 표시하는 메소드
    public static void printStationList() {
        int idx = head;

        while (idx != -1) {
            System.out.printf("["+ list[idx].name+"] -> ");
            idx = list[idx].next;
        }

        System.out.printf("\n");
    }

    public static void insertStationList(int insIdx, String insName, int prevIdx) {
        list[insIdx].name = insName; // 이름 설정
        list[insIdx].next = list[prevIdx].next; // 이전 링크에서 다음 주소 값 가져옴
        list[prevIdx].next = insIdx; // 이전 링크에 다음 주소값 변경
    }

    public static void deleteStationList(int delInx , int prevIdx) {
        list[prevIdx].next = list[delInx].next;
    }

    // 프로그램 실행의 시작점인 main 메서드
    public static void main(String[] args) {
        // 초기 상태의 연결 리스틀 작성해 표시
        initStationList();
        printStationList();

        // 연결 리스트에 요소를 삽입하여 표시
        insertStationList(5, "괌명" , 2);
        printStationList();

        // 연결 리스트에서 요소를 제거하며 표시
        deleteStationList(5 ,2);
        printStationList();
    }
}
