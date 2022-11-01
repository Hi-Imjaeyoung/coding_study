package Kakao_2022_BlindRecruitment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

class shot implements Comparable<shot>{
	int score;
	int arrow;
	int ef;
	int index;
	shot(int score, int arrow, int index){
		this.score = score;
		this.arrow = arrow;
		this.index = index;
		double Ef = (double)score/(double)arrow;
		Ef = Ef*100;
		this.ef = (int)Ef;
	}
	@Override
	public int compareTo(shot oj) {
		if(oj.ef == this.ef) {
			return oj.index - this.index;
		}
		return oj.ef - this.ef;
	}
}
public class Num4_양궁대회 {
	public static int[] sol(int n , int[] info) {
		ArrayList<shot> list = new ArrayList<>();
		int apeach_score =0 , rayon_score =0;
		for(int i=0; i<11; i++) {
			if(info[i]==0) {
				list.add(new shot(10-i,1,i));
			}else {
				list.add(new shot((10-i)*2,info[i]+1,i));
				apeach_score += 10-i;
			}
		}
		Collections.sort(list);
		int[] aws = new int[11];
		int remain_arrow = n;
		Iterator<shot> it = list.iterator();
		while(it.hasNext()) {
			shot tmp = it.next();
			if(remain_arrow-tmp.arrow < 0) continue;
			remain_arrow = remain_arrow-tmp.arrow;
			aws[tmp.index] = tmp.arrow;
			if(tmp.index == 10-tmp.score) {
				rayon_score += (10-tmp.index);
			}else {
				apeach_score -=(10-tmp.index);
				rayon_score += (10-tmp.index);
			}
			if(remain_arrow==0) break;
		}
		if(apeach_score>=rayon_score) {
			return new int[]{-1};
		}
		if(remain_arrow != 0) {
			aws[10] = remain_arrow;
		}
		return aws;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sol(0,new int[]{0,0,0,0,0,0,0,0,0,0,0})));
	}

}
