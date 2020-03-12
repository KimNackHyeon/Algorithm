package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
 
public class Solution_D4_7701_¿°¶ó´ë¿ÕÀÇÀÌ¸§Á¤·Ä {
 
    static TreeSet<String> tree;
    static ArrayList<String> names;
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(in.readLine());
        tree = new TreeSet<>();
        names = new ArrayList<>();
        for (int test_case = 1; test_case <= T; test_case++) {
            tree.clear();
            names.clear();
 
            int N = Integer.parseInt(in.readLine());
 
            for (int i = 0; i < N; i++) {
                tree.add(in.readLine());
            }
 
            Iterator<String> iter = tree.iterator();
            while (iter.hasNext()) {
                names.add(iter.next());
            }
 
            names.sort(new NC());
            System.out.println("#" + test_case);
            for(String s : names) {
                System.out.println(s);
            }
 
        }
    }
    public static class NC implements Comparator<String> {
 
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        }
 
    }
}
