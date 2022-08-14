package 프로그래머스.Hash;

/*
    코딩테스트 연습 - 해시 - 포켓몬

 배열을 리스트로
 List list = Arrays.stream(yourArray).boxed().collect(Collectors.toList());

 리스트를 배열로
 Integer wrapper class를 사용한 list를 array로 변환
 int[] intArray = yourList.stream().mapToInt(Integer::intValue).toArray();

*/

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class 포켓몬_스트림풀이 {

    @Test
    void main() {

        //int[] nums = {3, 1, 2, 3};           // 2
        //int[] nums = {3, 3, 3, 2, 2, 4};     // 3
        int[] nums = {3, 3, 3, 2, 2, 2};     // 2

        System.out.println(this.solution(nums));
    }

    public int solution(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(
                Collectors.collectingAndThen(
                    Collectors.toSet(),
                    pocketMonSet -> Integer.min(pocketMonSet.size(), nums.length / 2)
                )
            );
    }
}