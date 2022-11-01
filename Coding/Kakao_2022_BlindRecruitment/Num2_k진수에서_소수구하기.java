package Kakao_2022_BlindRecruitment;
import java.util.Arrays;
public class Num2_k진수에서_소수구하기 {
	public static boolean is_prime(long i) { //소수인지 판별 할 때 그 수의 제곱근 까지만 나누어보면 된다.
		/*int j =2;
		if(i==1) return true;
		while(j <= i/2) {
			if(i%j==0) {
				return true;
			}
			j++;
		}*/
		if(i==1) {return false;}
		if(i==2 || i==5 || i ==7) {return true;}
		if(i%2==0) {return false;} // 내 나름의 최적화
		long j =3; //j도 long을 사용해야 풀림
		while(j*j<=i) { // 제곱근의 값 구하기 Math.sqrt
			if(i%j==0) {return false;}
			j++;
		}
		return true;
	}
	public static int solution(int i, int k) {
		int answer =0;
		String tmp = Integer.toString(i,k);
		String[] arr = tmp.split("0{1,}");
		System.out.println(Arrays.toString(arr));
		for(int j=0; j<arr.length; j++) {
			if(arr[j].equals("")) {continue;}
			long now = Long.parseLong(arr[j]); // parseInt 가 아닌 Long을 받을 떄는 Long을 사용 
			if(is_prime(now)) {
				answer++;
			}
			
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		int x = 16;
		x =(int)Math.sqrt(x);
		System.out.println(x);
	}
}
