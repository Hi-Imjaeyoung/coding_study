package Woteco;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class week1_P5 {
	 public static List<Integer> solution(int money) {
	        List<Integer> answer = Collections.emptyList(); //왜 이런식으로 표현했을까?
	        answer = new LinkedList<Integer>();
	        int[] money_list = {50000,10000,5000,1000,500,100,50,10,1};
	        for(int i=0; i<money_list.length; i++) {
	        	answer.add(money/money_list[i]);
	        	money = money - (money/money_list[i])*money_list[i];
	        }
	        return answer;
	    }
	 public static void main(String[] args) {
		 List list = List.of();
		 System.out.println(solution(50_237).toString());
	 }
}
