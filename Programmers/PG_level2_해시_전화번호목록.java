package test;

import java.util.Arrays;

public class PG_level2_해시_전화번호목록 {
	public static void main(String[] args) {
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"12","123","1235","567","88"};
		String[] phone_book = {"123","456","789"};
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length-1; i++) {
				if(phone_book[i+1].startsWith(phone_book[i])) {
					return false;
				}
		}
        
        return answer;
    }
}
