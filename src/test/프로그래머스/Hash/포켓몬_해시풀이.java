package 프로그래머스.Hash;

/*
    코딩테스트 연습 - 해시 - 포켓몬
*/

import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class 포켓몬_해시풀이 {

    @Test
    void main() {

        //int[] nums = {3, 1, 2, 3};           // 2
        int[] nums = { 3, 3, 3, 2, 2, 4};     // 3
        //int[] nums = { 3, 3, 3, 2, 2, 2};     // 2

        System.out.println(this.solution(nums));
    }

    public int solution(int[] nums) {

        // 중복 제거를 위해 HashSet
        HashSet<Integer> pocketMonHashSet = new HashSet<>();

        // 중복이 제거된 채로 저장
        for (int num : nums) {
            pocketMonHashSet.add(num);
        }

        // 디폴트 최소값 설정
        int defaultMinCnt = nums.length / 2;

        // 포켓몬의 종류 수와 디폴트 최소값 중 작은값 리턴
        return Integer.min(defaultMinCnt, pocketMonHashSet.size());
    }

}