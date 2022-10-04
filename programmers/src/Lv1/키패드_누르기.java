package Lv1;

public class 키패드_누르기 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		long start = System.currentTimeMillis();
		System.out.println("결과 값 :: "+solution(numbers, hand));
		long end = System.currentTimeMillis();
		
		System.out.println("solution :: "+(double)(end-start)/1000+" 초");
		
	}
	
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int left = 0;
		int right = 0;
		int posiL = 0;
		int posiR = 0;
		hand = (hand.equals("right")) ? "R" : "L";
		
		for(int num : numbers) {
			
			if(num == 1 || num == 4 || num == 7) {
				answer += "L";
				left = num;
				posiL = num / 2;  // 1 = 0 , 4 = 2 , 7 = 3
				posiL = (posiL == 0) ? 1 : posiL;
			}else if(num == 3 || num == 6 || num == 9) {
				answer += "R";
				right = num;
				posiR = num / 3;  // 3 = 1 , 6 = 2 , 9 = 3
			}else {
				int center = 0;
				
				if(center == 2) {
					center = 1;
				}
				if(center == 5) {
					center = 2;
				}
				if(center == 8) {
					center = 3;
				}
				if(center == 0) {
					center = 4;
				}
				
				if(center == posiL && center == posiR) {
					if(center == left) {
						answer += "L";
					}else if(center == right) {
						answer += "R";
					}else {
						answer += hand;
					}
					
				}else if(posiL < posiR) {
//					if() {
						
//					}
					
				}else {
					
				}
			}
		}
		
        return answer;
	}
	
}
