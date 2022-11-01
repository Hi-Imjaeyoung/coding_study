package Woteco;

public class week1_P3 {
	  public static int solution(int number) {
	        int answer = 0;
	        for(int i=1; i<=number ; i++) {
	        	answer += is_clap(i);
	        }
	        return answer;
	    }
	    public static int is_clap(int i) {
	    	int answer = 0;
	    	String tmp = Integer.toString(i);
	    	for(int j=0; j<tmp.length(); j++) {
	    		char now_num = tmp.charAt(j);
	    		if(now_num=='3'||now_num =='6' || now_num=='9') {
	    			answer ++;
	    		}
	    	}
	    	return answer;
	    }
	public static void main(String[] args) {
		System.out.println(solution(13));
		System.out.println(solution(33));
	}

}
