import java.util.HashMap;
import java.util.Map;

public class Offer38 {
    String[] res;
    StringBuilder sb;
    int index = 0;
    Map<String, Integer> map = new HashMap<>();

    public String[] permutation(String s) {
        if (s == null) return new String[0];
        sb = new StringBuilder(s);
        if (s.length() == 1) {
            res[0] = s;
            return res;
        }
        permutationRecur(sb, 0);
        res = new String[map.size()];
        for (String str : map.keySet()) {
            res[index++] = str;
        }
        return res;
    }

    private void permutationRecur(StringBuilder sb, int start) {
        if (start == sb.length() - 1) {
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), 1);
            }
            System.out.println(sb.toString());
            sb = new StringBuilder(sb);
            return;
        }
        for (int i = start; i < sb.length(); i++) {
            swap(i, start, sb);
            permutationRecur(sb, start + 1);
            swap(i, start, sb);
        }
    }

    private void swap(int i, int start, StringBuilder sb) {
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(start));
        sb.setCharAt(start, ch);
    }

    public static void main(String[] args) {
        Offer38 offer38 = new Offer38();
        offer38.permutation("abc");
    }
}
