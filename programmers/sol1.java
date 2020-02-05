package programmers;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

class sol1 {
	public static void solution(int N, String[] cards) {
		int total = cards.length;
		int pair = 0;
		boolean first =true;
		boolean flag = true;
		String check="Y";
		HashMap<String, Integer> map = new HashMap<>();

		for (String s : cards) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		TreeMap<String,Integer> tmap = new TreeMap<String,Integer>(map);
		System.out.println(tmap);
		
		for(String key :tmap.keySet()) {
			//System.out.println(map.get(key));			
			if(first) {
				pair = tmap.get(key);
				first=false;
				continue;
			}
			if (pair == tmap.get(key)) {
				continue;
			}
			//카드 추가
			else if((pair==tmap.get(key)+1)&&flag) {
					total++;
					flag = false;
			}
			
			else {
				check="N";
				total=cards.length;
				break;
			}
		}
		System.out.println(check);
		System.out.println(total);
		System.out.println(tmap.size());
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] cards = new String[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.next();
		}
		solution(N,cards);
		sc.close();
	}
}