package Kakao_2022_BlindRecruitment;

import java.util.Arrays;

public class Num6_부셔지지않는건물 {
	public static int sol(int[][] board, int[][] skill) {
		int answer =0;
		int c = board[0].length;
		int r = board.length;
		answer = (r)*(c);
		for(int i=0; i<skill.length; i++) {
			if(skill[i][0]==1) {
				for(int j= skill[i][1]; j<=skill[i][3]; j++) {
					for(int k= skill[i][2]; k<=skill[i][4]; k++) {
						if(board[j][k]>0 && board[j][k] - skill[i][5]<=0) {answer--;}
						board[j][k] -= skill[i][5];
					}
				}
			}else {
				for(int j= skill[i][1]; j<=skill[i][3]; j++) {
					for(int k= skill[i][2]; k<=skill[i][4]; k++) {
						if(board[j][k]<0 && board[j][k] + skill[i][5]>0) {answer++;}
						board[j][k] += skill[i][5];
					}
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {

	}

}
