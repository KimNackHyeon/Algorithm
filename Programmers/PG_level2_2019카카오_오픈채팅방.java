package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PG_level2_2019카카오_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		solution(record);
	}
	
	public static String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String, String> user = new HashMap<>();
        Queue<String[]> room = new LinkedList<>();
        
        for (int i = 0; i < record.length; i++) {
			String[] split = record[i].split(" ");
			
			if(split[0].equals("Enter")) {
				room.add(new String[] {split[1],"E"});
				user.put(split[1], split[2]);
			} else if(split[0].equals("Leave")) {
				room.add(new String[] {split[1],"L"});
			} else if(split[0].equals("Change")) {
				user.put(split[1], split[2]);
			}
			
		}
        
        System.out.println(user);
        answer = new String[room.size()];
        
        int idx = 0;
        while(!room.isEmpty()) {
        	StringBuilder sb = new StringBuilder();
        	
        	String uid = room.peek()[0];
        	String mv = room.peek()[1];
        	
        	room.poll();
        	
        	if(mv.equals("E")) {
        		sb.append(user.get(uid)).append("님이 들어왔습니다.");
        	}else if(mv.equals("L")) {
        		sb.append(user.get(uid)).append("님이 나갔습니다.");
        	}
        	answer[idx++] = sb.toString();
        }
        
        System.out.println(Arrays.toString(answer));
        
        
        return answer;
    }
}
