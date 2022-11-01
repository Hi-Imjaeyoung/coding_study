package Woteco;

public class week1_P2 {
	public static String solution(String cryptogram) {
        String answer = "";
        char[] arr = cryptogram.toCharArray();
        for(int i=0; i<arr.length-1; i++) {
        	if(arr[i]==arr[i+1] && arr[i]!='0') {
        		arr[i]='0';
        		arr[i+1]='0';
        		find_other_combo(i-1, i+1, arr);
        	}
        }
        for(int i=0; i<arr.length;i++) {
        	if(arr[i]!='0') {
        		answer +=arr[i];
        	}
        }
        return answer;
    }
    public static void find_other_combo(int L, int R, char[]arr){
    	if(L<0 || R >=arr.length) {return;}
    	// 앞애 이미 '0'으로 만든 index는 뛰어넘어 주어야한다. 
    	while(arr[L]=='0' || arr[R]=='0') {
    		if(arr[L]=='0') {
    			L--;
    			if(L<0) return;
    		}
    		if(arr[R]=='0') {
    			R++;
    			if(R>=arr.length) return;
    		}
    	}
    	if(arr[L]==arr[R]) {
    		arr[L] = arr[R] = '0';
    		find_other_combo(L-1,R+1,arr);
    	}
    }
	public static void main(String[] args) {
		//System.out.println(solution("browoanoommnaon"));
		System.out.println(solution("zyelleyz"));

	}

}
