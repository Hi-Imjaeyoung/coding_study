package Woteco;

public class week_P4 {
	 public static String solution(String word) {
	        String answer = "";
	        char[] arr = word.toCharArray();
	        for(int i=0 ; i<arr.length ;i++) {
	        	if(Character.isAlphabetic(arr[i])) {
	        		answer+=conver_char(arr[i]);
	        	}else {
	        		answer +=arr[i];
	        	}
	        	
	        }
	        return answer;
	    }
	    public static char conver_char(char c) {
	    	if(Character.isUpperCase(c)) {
	    		int tmp = c-65;
	    		return (char)(90-tmp);
	    	}else {
	    		int tmp = c-97;
	    		return (char)(122-tmp);
	    	}
	    }
	public static void main(String[] args) {
		System.out.println(solution("I love you"));

	}

}
