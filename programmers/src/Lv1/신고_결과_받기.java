package Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class 신고_결과_받기 {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
int[] answer = new int[id_list.length];
		
		Map<String, Integer> map1 = new HashMap<String, Integer>(); // 신고확정 횟수
		Map<String, Integer> map2 = new HashMap<String, Integer>(); // 신고당한 횟수
		Map<String, String> map3 = new HashMap<String, String>();	// 각각의 신고자(From)
		Map<String, Integer> map4 = new HashMap<String, Integer>(); // 중복방지용 map
		
		for(String id : id_list) {
			map1.put(id, 0);
		}
		
		
		for(String each : report) {
			map4.put(each, null);
		}
			
		// report횟수 count 및 report참여자
		Iterator<String> iter1 = map4.keySet().iterator();
		while(iter1.hasNext()) {
			String key = iter1.next();
			String[] rep = key.split(" ");
					
			map2.put(rep[1], (map2.get(rep[1])==null) ? 1 : map2.get(rep[1])+1);  // 본인 신고당한 횟수
				
			map3.put(rep[1], (map3.get(rep[1]) == null) ? rep[0] : map3.get(rep[1])+" "+rep[0]); // 후자를 신고한 사람들
			
		}
		
		Iterator<Entry<String, Integer>> iter2 = map2.entrySet().iterator();
		
		while(iter2.hasNext()) {
			Entry<String, Integer> ent = iter2.next();
			
			int val = ent.getValue();
			String key = ent.getKey();
			
			if(val >= k) {
				String users = map3.get(key);
				String[] ids = users.split(" ");
				
				for(String id : ids) {
					map1.put(id, map1.get(id)+1);
				}
				
			}
			
		}
		
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = map1.get(id_list[i]);
		}
		
		return answer;
	}
}
