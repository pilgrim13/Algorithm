package 프로그래머스.LEVEL.ONE;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// 2016
public class TWO_THOUSANDS_SIXTEEN {

    @Test
    void main() {

        System.out.println(this.solution(5, 24));

    }

    public String solution(int a, int b) {
        String answer = "";

        int days = b;
        if (a != 1) {
            days += getDaysCount(a - 1);
        }
        days -= 1;
        int pickDay = days % 7;
        //SUN,MON,TUE,WED,THU,FRI,SAT
        switch (pickDay) {
            case 0:
                answer = "FRI";
                break;
            case 1:
                answer = "SAT";
                break;
            case 2:
                answer = "SUN";
                break;
            case 3:
                answer = "MON";
                break;
            case 4:
                answer = "TUE";
                break;
            case 5:
                answer = "WED";
                break;
            case 6:
                answer = "THU";
                break;

        }
        return answer;
    }

    private int getDaysCount(int targetMonth) {

        Map<Integer, Integer> daysMap = new HashMap<>();

        daysMap.put(1, 31);
        daysMap.put(2, 29);
        daysMap.put(3, 31);
        daysMap.put(4, 30);
        daysMap.put(5, 31);
        daysMap.put(6, 30);
        daysMap.put(7, 31);
        daysMap.put(8, 31);
        daysMap.put(9, 30);
        daysMap.put(10, 31);
        daysMap.put(11, 30);
        daysMap.put(12, 31);

        int days = 0;
        for (int indexMonth = 1; indexMonth <= targetMonth; indexMonth++) {
            days += daysMap.get(indexMonth);
        }
        return days;
    }

}