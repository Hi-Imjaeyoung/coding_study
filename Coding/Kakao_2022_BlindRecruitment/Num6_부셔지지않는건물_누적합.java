package Kakao_2022_BlindRecruitment;
import java.util.Arrays;
public class Num6_부셔지지않는건물_누적합 {
	public static int sol(int[][] board , int[][] skill) {
		int answer =board.length*(board[1].length);
		int[][] map = new int[board.length+1][board[0].length+1];
		for(int i=0; i<skill.length; i++) {
			if(skill[i][0]==1) {  // [ 1. r1, c1 , r2 , c2 , degree[
				map[skill[i][1]][skill[i][2]] += -1*skill[i][5];
				map[skill[i][3]+1][skill[i][4]+1] += -1*skill[i][5];
				map[skill[i][1]][skill[i][4]+1] += skill[i][5];
				map[skill[i][3]+1][skill[i][2]] += skill[i][5];
			}else {
				map[skill[i][1]][skill[i][2]] += skill[i][5];
				map[skill[i][3]+1][skill[i][4]+1] +=skill[i][5];
				map[skill[i][1]][skill[i][4]+1] += -1*skill[i][5];
				map[skill[i][3]+1][skill[i][2]] += -1*skill[i][5];
			}
		}
		for(int i=0; i<board.length ;i++) {
			for(int j=0; j<board[0].length; j++) {
				map[i][j+1] += map[i][j];
			}
		}
		for(int j=0; j<board[0].length; j++) {
			for(int i=0; i<board.length ;i++) {
				map[i+1][j] += map[i][j];
				if(map[i][j]+board[i][j] <=0) answer --;
			}
			
		}
		return answer;
		}
	public static void main(String[] args) {
		System.out.println(sol(new int[][] {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][] {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}));	
	}

}
