package Kakao_2022_BlindRecruitment;
import java.util.ArrayList;
import java.util.Arrays;
public class Num7_양과늑대 {
	static int sum_v,answer,max_sheep;
	static int[] info2 , ex_answer, list_orign_size;
	static ArrayList<ArrayList<Integer>> list;
	public static void DFS(int n, int v) {
		if(max_sheep == answer) {return;}
		if(v==sum_v) {
			int she =0 , wolf =0;
			for(int i=0; i<ex_answer.length;i++) {
				if(ex_answer[i]==0) {
					she++;
				}else{
					wolf++;
				}
				if(she>wolf) {
					answer =Math.max(she, answer);
				}else {
					break;
				}
			}
		}else {
			for(int i=0; i<list.get(n).size(); i++){
				int tmp = list.get(n).get(i);
				ex_answer[v+1] = info2[tmp];
				for(int j=0; j<list.get(n).size(); j++) {
					if(tmp != list.get(n).get(j)) list.get(tmp).add(list.get(n).get(j));
					}
				DFS(tmp,v+1);
				while(list_orign_size[tmp] < list.get(tmp).size()) {
					int indx = list.get(tmp).size();
					list.get(tmp).remove(indx-1);
				}
			}	
		}
	}
	public static int sol(int[] info, int[][] edges) {
		ex_answer = new int[info.length]; 
		info2 = info;
		list = new ArrayList<>();
		sum_v = edges.length;
		list_orign_size = new int[info.length];
		answer =0;
		max_sheep =0;
		for(int i=0; i<info.length ; i++) {
			list.add(new ArrayList<Integer>());
			if(info[i]==0) max_sheep +=1;
		}
		for(int i=0;i<edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
			list_orign_size[edges[i][0]] +=1;
		}
		//처음 양추가 배열에
		ex_answer[0] =0;
		DFS(0,0);
		return answer;
	}
	public static void main(String[] args) {
		sol(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}});
		System.out.println(answer);
	}

}
