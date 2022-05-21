package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class TestClass {
    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    @Test
    public void exampleTest() {
        Version version = new Version(null);
    }

    @Test
    public void exampleTest2() {
        Version version = new Version("3.8.0-SNAPSHOT");
        Version newVersion = new Version("3.7.9");
        switch (version.compareTo(newVersion)){
            case 0 : {

            }break;
            case 1 : {

            } break;
        }
    }

    @Test
    public void exampleTest3() {
        Version version = new Version("2,3");
    }

    class Version implements Comparable<Version>{
        private String version ;
        private int x;
        private int y;
        private int z;
        Version(String version) {
            String pattern = "\\d+(\\.\\d+){0,2}(-SNAPSHOT)?.";
            if (version == null || version.length() == 0) {
                throw new IllegalArgumentException(errorVersionMustNotBeNull);
            } else if (version.matches(pattern)) {
                throw new IllegalArgumentException(errorVersionMustMatchPattern);
            }
            this.version = version;
            this.x = Integer.parseInt(version.substring(0,1));
            this.y = Integer.parseInt(version.substring(2,3));
            this.z = Integer.parseInt(version.substring(4,5));
        }

        @Override
        public int compareTo(Version o) {
            if (o == null) {
                throw new IllegalArgumentException(errorOtherMustNotBeNull);
            }

            if (this.x > o.x) { // x 분기
                return 1;
            } else if(this.x < o.x){
                return -1;
            } else { // y분기
                if(this.y > o.y) {
                    return 1;
                } else if(this.y < o.y){
                    return -1;
                } else {// z 분기
                    if(this.z > o.z) {
                        return 1;
                    } else if(this.z < o.z){
                        return -1;
                    } else { // 값이 전부 같을때
                        if (this.isSnapshot() && !o.isSnapshot()) {
                            return -1;
                        } else if (!this.isSnapshot() && o.isSnapshot()){
                            return 1;
                        }
                        else {
                            return 0;
                        }
                    }
                }
            }
        }

        boolean isSnapshot() {
            String snapShot = this.version.substring(this.version.length()-9,this.version.length());
            if (snapShot.equals("-SNAPSHOT")) {
                return true;
            }
            return false;
        }
    }
}
