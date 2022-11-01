package Kakao_2022_BlindRecruitment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
class fee implements Comparable<fee>{
	int num;
	int fee;
	fee(int num, int fee){
		this.num = num;
		this.fee = fee;
	}
	@Override
	public int compareTo(fee f) {
		return this.num - f.num;
	}
}
public class Num3_주차요금계산 {
	public static int cal_fee(int time, int[] fees) {
		int answer =0;
		if(time<=fees[0]) {
			return fees[1];
		}else {
			int time2 = time - fees[0];
			if(time2 % fees[2]==0) {
				answer = (time2/fees[2])*fees[3] + fees[1];
			}else {
				answer = (time2/fees[2])*fees[3] + fees[1] + fees[3];
			}
		}
		return answer;
	}
	public static int cal_time(String in, String out) {
		int answer =0;
		int h_in = Integer.parseInt(in.substring(0,2));
		int m_in = Integer.parseInt(in.substring(3));
		int h_out = Integer.parseInt(out.substring(0,2));
		int m_out = Integer.parseInt(out.substring(3));
		int h = h_out - h_in;
		int m;
		if(m_out > m_in) {
			m = m_out - m_in;
		}else {
			m = (m_out+60) - m_in;
			h--;
		}
		answer = h*60 + m;
		return answer;
	}
	public static int[] sol(int[] fees, String[] records) {
		HashMap<String,String> map = new HashMap<>();
		HashMap<String,Integer> sum_time  = new HashMap<>();
		ArrayList<fee> list = new ArrayList<>(); 
		for(String tmp : records) {
			String[] info = tmp.split(" ");
			if(map.containsKey(info[1])) {
				int time = cal_time(map.get(info[1]),info[0]);
				/*if(sum_time.containsKey(info[1])) { 
					sum_time.put(info[1], sum_time.get(info[1]) + time);
				}else {
					sum_time.put(info[1],time );
				}?-*/
				sum_time.put(info[1],sum_time.getOrDefault(info[1], 0) + time); // map.getOrDefault 를 사용하면 좀더 깔끔하다! 
				map.remove(info[1]);
			}else {
				map.put(info[1],info[0]); // info[2] 필요가 없음 최적화 가능
			}
		}
		if(map.size()!=0) {
			for(String key : map.keySet()) {
				int time = cal_time(map.get(key),"23:59");
				if(sum_time.containsKey(key)) {
					sum_time.put(key, sum_time.get(key) + time);
				}else {
					sum_time.put(key, time);
				}
			}
		}
		for(Map.Entry<String, Integer> ent : sum_time.entrySet()) {
			String car_num = ent.getKey();
			int fee = cal_fee(ent.getValue(),fees);
			list.add(new fee(Integer.parseInt(car_num),fee));
		}
		int[] answer = new int [list.size()];
		Collections.sort(list);
		Iterator<fee> it = list.iterator(); //treemap을 사용헀으면 순서가 자동 정렬.
		int i =0;
		while(it.hasNext()) {
			int tmp = it.next().fee;
			answer[i] = tmp;
			i++;
		}
		return answer;
	}
	public static void main(String[] args) {
		
	}

}
