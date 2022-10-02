package Lv1;

public class 신규_아이디_추천 {
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		
		
		long start = System.currentTimeMillis();
		System.out.println("결과 값 :: "+solution(new_id));
		long end = System.currentTimeMillis();
		
		System.out.println("solution :: "+(double)(end-start)/1000+" 초");
	}
	
	
	public static String solution(String new_id) {
		String answer = "";
        new_id = new_id.toLowerCase();
        
        String match1 = "[^\uAC00-\uD7A30-9a-z-_.]";
        new_id = new_id.replaceAll(match1,"");
        
        String match2 = "[.]{2,}";
        new_id = new_id.replaceAll(match2,".");
        
        
        String first = new_id.substring(0,1);
        String last = new_id.substring((new_id.length()-1));
        if(".".equals(first)){
            new_id = new_id.substring(1);
        }
        if("".equals(new_id)){
            new_id = "a";
        }
        if(".".equals(last)){
            new_id = new_id.substring(0,(new_id.length()-1));
        }
        if("".equals(new_id)){
            new_id = "a";
        }
        
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
        }
        
        last = new_id.substring((new_id.length()-1));
        if(".".equals(last)){
            new_id = new_id.substring(0,(new_id.length()-1));
        }
        
        if(new_id.length() <= 2){
            String lastChar = new_id.substring(new_id.length()-1);
            while(new_id.length() < 3){
                new_id += lastChar;
            }
        }
        
        answer = new_id;
                
        return answer;
	}
}
