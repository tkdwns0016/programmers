package Lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 성격_유형_검사하기 {
	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		System.out.println(solution(survey, choices));
	}
	
	public static String solution(String[] survey, int[] choices) {
		String answer = "";
		int sleng = survey.length;
		List<Map<String, Integer>> surveyMap = new ArrayList<Map<String,Integer>>();
		Map<String, Integer> pickedMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < sleng; i++) {
			String[] sur = survey[i].split("");
			int choice = choices[i];
			
			String pick = "";
			int score = 0;
			
			
			if(choice < 4) {
				pick = sur[1];
				
				switch (choice) {
				case 1:
					score = 3;
					break;
				case 2:
					score = 2;
					break;
				case 3:
					score = 1;
					break;

				default:
					System.out.println("in default :: "+choice);
					break;
				}
			}else if(choice > 4) {
				pick = sur[0];
				
				switch (choice) {
				case 7:
					score = 3;
					break;
				case 6:
					score = 2;
					break;
				case 5:
					score = 1;
					break;

				default:
					System.out.println("in default :: "+choice);
					break;
				}
			}
			pickedMap.put(pick, score);
			
			surveyMap.add(pickedMap);	
			
			
			
			// 계산 방식
			//	A		  N
			//7 6 5 [4] 3 2 1
		}
//		"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
		return answer;
	}
}
