package studt;

import java.util.Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;



class Info implements Comparable<Info>{
	String name;
	int score;
	Info(String name, int score){
		this.name = name;
		this.score = score;
	}
	@Override
	public int compareTo(Info o){
		if(o.score == this.score) {
			if(this.name.compareTo(o.name)>0) {
				return 1;
			}else {
				return -1;
			}
		}else {
			return o.score-score;
		}
		
	}
}
	/*@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Info))
			return false;
		Info info =(Info)o;
		return indx != info.indx && // 제이이이이이이슨 >> 여기서'이이' 는 두번쨰 '이이'와 중복판단 x
				Objects.equals(token, info.token);
	}
	@Override
	public int hashCode() {
		return Objects.hash(indx,token);
	}*/

public class note2 {
	static int indx = 0;
	static List<String> id = new LinkedList<>();
	static List<List<Integer>> graph = new LinkedList<>();
	static HashMap<String,Integer> map = new HashMap<>();
	public static List<String> calculate_Score(List<String> visitors){
		int[] score = new int[30001];
		///Arrays.fill(score,0);
		for(String x: visitors) {
			int f1 = convert_Indx(x);
			score[f1] += 1;
		}
		
		for(int x:graph.get(0)) {
			score[x] =-1;
			for(int y:graph.get(x)) {
				if(score[y]!=-1) {
					score[y] +=10;
				}
			}
		}
		List<Info> list = new LinkedList<>();
		for(int i=1; i<indx ; i++) {
			if(score[i]>0) {
				list.add(new Info(id.get(i),score[i]));
			}
		}
		Collections.sort(list);
		List<String> answer = new LinkedList<>();
		for(Info o : list) {
			answer.add(o.name);
		}
		return answer;
	}
	public static int convert_Indx(String name) {
		if(map.containsKey(name)) {
			return map.get(name);
		}else {
			id.add(name);
			graph.add(new LinkedList<Integer>());
			map.put(name,indx);
		}  
		return indx++;
	}
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        convert_Indx(user);
        for(int i=0 ; i<friends.size(); i++) {
        	int f1 = convert_Indx(friends.get(i).get(0));
        	int f2 = convert_Indx(friends.get(i).get(1));
        	graph.get(f1).add(f2);
        	graph.get(f2).add(f1);
        }
        answer = calculate_Score(visitors);
        return answer;
    }

	public static void main(String[] args) {
		List<List<String>> forms = new LinkedList<>();
		List<String> vi =  new LinkedList<>();
		for(int i=0; i<6; i++) {
			forms.add(new LinkedList<String>());
		}
		forms.get(0).add("donut");
		forms.get(0).add("zndole");
		forms.get(1).add("donut");
		forms.get(1).add("jun");
		forms.get(2).add("donut");
		forms.get(2).add("mrko");
		forms.get(3).add("shakevan");
		forms.get(3).add("zndole");
		forms.get(4).add("shakevan");
		forms.get(4).add("jun");
		forms.get(5).add("shakevan");
		forms.get(5).add("mrko");
		vi.add("zedi");
		vi.add("zedi");
		vi.add("donut");
		vi.add("zedi");
		vi.add("shakevan");
		vi.add("bedi");
		vi.add("bedi");
		vi.add("bedi");
		System.out.println(solution("mrko",forms,vi).toString());
	}

}
