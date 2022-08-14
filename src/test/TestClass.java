import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    void main() {

//        String Seq1 = "ATTGAT";
//        String Seq2 = "ACTGAA";
//        String Seq1 = "AGATAGATAGAATGATT";
        //String Seq2 = "AA";
        String Seq1 = "CTTGGTACACGGAACGTTCTGAAAAGAGCTATGAATTGCAGACACCTTTTGAAATTAAATTGGCAAAGAA"
            + "ATTTGACACCTTCAATGGGGAATGTCCAAATTTTGTATTTCCCTTAAATTCCATAATCAAGACTATTCAA"
            + "CCAAGGGTTGAAAAGAAAAAGCTTGATGGCTTTATGGGTAGAATTCGATCTGTCTATCCAGTTGCGTCAC"
            + "CAAATGAATGCAACCAAATGTGCCTTTCAACTCTCATGAAGTGTGATCATTGTGGTGAAACTTCATGGCA"
            + "GACGGGCGATTTTGTTAAAGCCACTTGCGAATTTTGTGGCACTGAGAATTTGACTAAAGAAGGTGCCACT"
            + "ACTTGTGGTTACTTACCCCAAAATGCTGTTGTTAAAATTTATTGTCCAGCATGTCACAATTCAGAAGTAG"
            + "GACCTGAGCATAGTCTTGCCGAATACCATAATGAATCTGGCTTGAAAACCATTCTTCGTAAGGGTGGTCG"
            + "CACTATTGCCTTTGGAGGCTGTGTGTTCTCTTATGTTGGTTGCCATAACAAGTGTGCCTATTGGGTTCCA"
            + "CGTGCTAGCGCTAACATAGGTTGTAACCATACAGGTGTTGTTGGAGAAGGTTCCGAAGGTCTTAATGACA"
            + "ACCTTCTTGAAATACTCCAAAAAGAGAAAGTCAACATCAATATTGTTGGTGACTTTAAACTTAATGAAGA"
            + "GATCGCCATTATTTTGGCATCTTTTTCTGCTTCCACAAGTGCTTTTGTGGAAACTGTGAAAGGTTTGGAT"
            + "TATAAAGCATTCAAACAAATTGTTGAATCCTGTGGTAATTTTAAAGTTACAAAAGGAAAAGCTAAAAAAG"
            + "GTGCCTGGAATATTGGTGAACAGAAATCAATACTGAGTCCTCTTTATGCATTTGCATCAGAGGCTGCTCG"
            + "TGTTGTACGATCAATTTTCTCCCGCACTCTTGAAACTGCTCAAAATTCTGTGCGTGTTTTACAGAAGGCC";
        String Seq2 = "AGATGCG";

        this.solution(Seq1, Seq2);
    }

    @Test
    void solution(String Seq1, String Seq2) {

        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int i = 0; i <= Seq1.length() - Seq2.length(); i++) {
            int diffCnt = this.getDiffStringCnt(Seq1, Seq2, i);
            //System.out.println("DIFF CNT :: " + diffCnt);
            cntMap.put(i + 1, diffCnt);
        }

        // value 최소값
        Integer minValue = Collections.min(cntMap.values());

        cntMap.forEach((key, value) -> {
            if (Objects.equals(value, minValue)) {
                System.out.println(key);
            }
        });
    }

    // 다른 문자 개수 알려주는 함수;
    int getDiffStringCnt(String str1, String str2, int startIndex) {

        for (int i = 0; i < startIndex; i++) {
            str2 = "%" + str2;
        }

        int diffCnt = 0;
        String[] Seq1Array = str1.split("");
        String[] Seq2Array = str2.split("");

        // startIndex부터 비교
        for (int i = startIndex; i < Seq1Array.length; i++) {
            // 인덱스 없으면 비교 안함
            if (Seq2Array.length <= i) {
                break;
            }
            // 같은 인덱스의 문자가 다르거나 || 두번째 문자열이 짧아서 해당 인덱스에 값이 존재하지 않으면 다름으로 인정
            if (!Seq1Array[i].equals(Seq2Array[i])) {
                diffCnt++;
            }
        }
        return diffCnt;
    }
}