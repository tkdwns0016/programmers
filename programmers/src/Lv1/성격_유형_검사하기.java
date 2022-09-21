package Lv1;

import java.util.Arrays;

public class 성격_유형_검사하기 {
	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		System.out.println(solution(survey, choices));
	}
	

	
	public static String solution(String[] survey, int[] choices) {
		String answer = "";
		int[][] totalScore = new int[4][2];
		int sleng = survey.length;
		
		for(int i = 0; i < sleng; i++) {
			String[] sur = survey[i].split("");
			int choice = choices[i];
			
			String pick = "";
			int score = 0;
			
			
			if(choice < 4) {
				pick = sur[0];
				
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
				pick = sur[1];
				
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
			
			if("R".equals(pick) || "T".equals(pick)) {
				if("R".equals(pick))
					totalScore[0][0] = totalScore[0][0]+score;
				else
					totalScore[0][1] = totalScore[0][1]+score;
			}else if("C".equals(pick) || "F".equals(pick)) {
				if("C".equals(pick))
					totalScore[1][0] = totalScore[1][0]+score;
				else
					totalScore[1][1] = totalScore[1][1]+score;
			}else if("J".equals(pick) || "M".equals(pick)) {
				if("J".equals(pick))
					totalScore[2][0] = totalScore[2][0]+score;
				else
					totalScore[2][1] = totalScore[2][1]+score;
			}else if("A".equals(pick) || "N".equals(pick)) {
				if("A".equals(pick))
					totalScore[3][0] = totalScore[3][0]+score;
				else
					totalScore[3][1] = totalScore[3][1]+score;
			}
			// 계산 방식
			//	A		  N
			//7 6 5 [4] 3 2 1
		}
		
		
		System.out.println(Arrays.deepToString(totalScore));
		
		String KBTI = "";
		
		if(totalScore[0][0] == totalScore[0][1]) {
			KBTI += ("R".charAt(0) < "T".charAt(0)) ? "R" : "T"; // char 형 비교 . A가 제일 낮음.
		}else {
			KBTI += (totalScore[0][0] > totalScore[0][1]) ? "R" : "T"; 
		}
		
		if(totalScore[1][0] == totalScore[1][1]) {
			KBTI += ("C".charAt(0) < "F".charAt(0)) ? "C" : "F"; // char 형 비교 . A가 제일 낮음.
		}else {
			KBTI += (totalScore[1][0] > totalScore[1][1]) ? "C" : "F"; 
		}
		
		if(totalScore[2][0] == totalScore[2][1]) {
			KBTI += ("J".charAt(0) < "M".charAt(0)) ? "J" : "M"; // char 형 비교 . A가 제일 낮음.
		}else {
			KBTI += (totalScore[2][0] > totalScore[2][1]) ? "J" : "M"; 
		}
		
		if(totalScore[3][0] == totalScore[3][1]) {
			KBTI += ("A".charAt(0) < "N".charAt(0)) ? "A" : "N"; // char 형 비교 . A가 제일 낮음.
		}else {
			KBTI += (totalScore[3][0] > totalScore[3][1]) ? "A" : "N"; 
		}
					
		answer = KBTI;
		
//		라이언형(R), 튜브형(T)
//		콘형(C), 프로도형(F)
//		제이지형(J), 무지형(M)
//		어피치형(A), 네오형(N)
		
//		"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
		return answer;
	}
}