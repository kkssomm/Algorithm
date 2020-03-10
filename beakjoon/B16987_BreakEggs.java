package beakjoon;

import java.util.Scanner;

public class B16987_BreakEggs {
	static int n;
	static int count = 0;

	static class Egg {
		int weight;
		int duration;

		Egg() {
			weight = 0;
			duration = 0;
		}

		Egg(int d, int w) {
			duration = d;
			weight = w;
		}
	}
	
	static void dfs(int hand, boolean[] check, int c, Egg[] eggs) {
		if(hand==n) {
			count=Math.max(c,count);
		}
		
		if(check[hand]) {
			dfs(hand+1,check,c,eggs);
		}
		
		else {
			boolean flag = true;
			for(int i = 0;i<n;i++) {
				// 칠 수 있는 계란 존재
				if(!check[i]) {
					flag = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		Egg eggs[] = new Egg[10];
		for (int i = 0; i < n; i++) {
			int d = scan.nextInt();
			int w = scan.nextInt();
			eggs[i] = new Egg(d, w);
		}
		boolean check[] = new boolean[10];
		dfs(0, check, 0, eggs);
		System.out.println(count);
	}

}
