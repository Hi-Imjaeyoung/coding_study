package studt;
import java.util.*;
 class ex1{
	int num;
	String name;
	public ex1(int num, String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		if(!(o instanceof ex1))
			return false;
		ex1 tmp = (ex1)o;
		return num == tmp.num &&
			Objects.equals(name, tmp.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(num, name);
	}
}
public class note {
	 public static List<Integer> solution(int money) {
	        List<Integer> answer = Collections.emptyList();
	        answer = new LinkedList<Integer>();
	        int[] money_list = {50000,10000,5000,1000,500,100,50,10,1};
	        for(int i=0; i<money_list.length; i++) {
	        	answer.add(money/money_list[i]);
	        	money = money - (money/money_list[i])*money_list[i];
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		HashSet<ex1> set = new HashSet<>();
		ex1 tmp1 = new ex1(1,"재영");
		ex1 tmp2 = new ex1(2,"준영");
		ex1 tmp3 = new ex1(3,"재영");
		set.add(tmp1);
		System.out.println(set.size());
		set.add(tmp2);
		System.out.println(set.size());
		set.add(tmp3);
		System.out.println(set.size());
		System.out.println(tmp1.equals(tmp3));
		String tmp4 = "hi";
		System.out.println(tmp4.length());
		System.out.println();
	}

}
