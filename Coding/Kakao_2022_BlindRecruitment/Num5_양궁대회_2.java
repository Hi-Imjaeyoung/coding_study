package Kakao_2022_BlindRecruitment;

import java.util.Arrays;

public class Num5_양궁대회_2 {
	static int[] ap_shot,answer;
	static int ap_sc , ry_sc, scale;
	static boolean flag;
	public static void DFS(int n, int[] ans, int k) {
		int now_scale = ry_sc - ap_sc;
		if(now_scale>scale) { //n이 10이기 떄문에 DFS로 그냥 매번 실행하였다.
			scale = now_scale;
			flag = true;
			for(int i=0; i<ans.length; i++) {
				answer[i] = ans[i];
			}
			if(n!=0) {answer[10]=n;}
		}
			for(int i=k; i>=0 ;i--) {
				if(ans[i]==0) {
					if(ap_shot[i] >= n) continue;
					ans[i] = (ap_shot[i]+1);
					if(ap_shot[i]==0) {
						ry_sc += (10-i);
					}else {
						ry_sc += (10-i);
						ap_sc -= (10-i);
					}
					DFS(n-(ap_shot[i]+1),ans,k-1);
					if(ap_shot[i]==0) {
						ry_sc -= (10-i);
					}else {
						ry_sc -= (10-i);
						ap_sc += (10-i);
					}
					ans[i] = 0;
				}
			}
	}
	public static int[] sol(int n, int[] info) {
		ap_shot = new int[11];
		answer = new int[11];
		ap_sc =0;
		ry_sc =0;
		scale =0;
		int[] tmp = new int[11];
		for(int i=0; i<11; i++) {
			ap_shot[i] = info[i];
			if(info[i] !=0) ap_sc += (10-i);
		}
		flag = false;
		DFS(n,tmp,10);
		System.out.println(Arrays.toString(answer));
		if(!flag) {return new int[] {-1};}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sol(1,new int[] {1,0,0,0,0,0,0,0,0,0,0})));
	}

}
