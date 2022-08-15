package 프로그래머스.Hash;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class 완주하지못한선수 {

    @Test
    void main() {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(this.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 동명이인이 있을수 있기 때문에 인원수 정보까지 포함하는 해시맵으로 선언
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 사람 : 인원수 수집
        for (String person : participant) {
            hashMap.put(person, hashMap.getOrDefault(person, 0) + 1);
        }

        // 도착한사람 이름의 인원수 - 1
        for (String person : completion) {
            hashMap.put(person, hashMap.get(person) - 1);
        }

        // 도착 안한 사람 조회
        for (String person : hashMap.keySet()) {
            if (hashMap.get(person) != 0) {
                answer = person;
            }
        }
        return answer;
    }
}