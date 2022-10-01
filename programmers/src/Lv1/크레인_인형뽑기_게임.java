package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class 크레인_인형뽑기_게임 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		long start = System.currentTimeMillis();
		System.out.println("결과 값 :: "+solution(board, moves));
		long end = System.currentTimeMillis();
		
		System.out.println("solution :: "+(double)(end-start)/1000+" 초");
	}
	
	
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		// 타인이 짠 코드에는 Stack클래스를 사용하였음.
		// Stack클래스를 사용하려고 하였으나, 사용하지 않았음. List가 익숙하기 때문..
		// 다음에 쓸 기회가 있다면 Stack 사용해 보기.
		
		List<Integer> stack = new ArrayList<Integer>(); // 뽑힌 인형 저장
		
		for (int i = 0; i < moves.length; i++) { // 움직임 for
			int move = moves[i];
			int value = 0;
			for (int j = 0; j < board.length; j++) { // 보드 체크 for
				value = board[j][move-1]; // move는 1~5 이고, 배열의 시작점 0이므로 -1 해준다.
				
				if(value != 0) {
					board[j][move-1] = 0;
					stack.add(value);
					break;
				}
			}
			
			System.out.println(stack);
			if(stack.size() > 1) {
				System.out.println(stack.get(stack.size()-2) == value);
				System.out.println(stack.get(stack.size()-2));
				System.out.println(value);
			}
			System.out.println("=======================");
			if(stack.size() > 1 && stack.get(stack.size()-2) == value) {
				stack.remove(stack.size()-1); // 뽑은 인형 삭제
				stack.remove(stack.size()-1); // 뽑은 인형과 동일한 마지막 인형 삭제
				answer += 2;
			}
		}
		
		return answer;
	}
}
