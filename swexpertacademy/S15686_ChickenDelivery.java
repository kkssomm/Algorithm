package swexpertacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S15686_ChickenDelivery {
	
	static int ans = 987654321;
	static List<Pairs> c = new ArrayList<>();
	static List<Pairs> h = new ArrayList<>();
	static boolean[] check = new boolean[14];
	
	public static int solution(int n,int m,int[][] city) {
		int answer =0;
		
		// 리스트 초기화 : c->치킨집 / h->집 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(city[i][j]==1) h.add(new Pairs(j,i));
				if(city[i][j]==2) c.add(new Pairs(j,i));
			}
		}
		
//		while(!c.isEmpty()) {
//			Pairs cc = c.poll();
//			System.out.println(cc.y+" "+cc.x);
//		}
		dfs(0,0,m);
		
		return ans;
	}
	
	public static void dfs(int x, int num, int m) {
		System.out.println("x"+x+" num"+num);
		// x->현재치킨집수 / num->
		if(num>m) return;
		if(x>=c.size()) {
			int total = 0;
			for(int i = 0;i<h.size();i++) {
				int temp = 987654321;
				for(int j=0;j<c.size();j++) {
					if(check[j]) {
						temp = Math.min(temp,
								Math.abs(c.get(j).x-h.get(i).x)+Math.abs(c.get(j).y-h.get(i).y));
					}
				}
				total = temp;
			}
			ans = Math.min(ans, total);
			System.out.println(ans);
			return;
		}
		dfs(x+1,num,m);
		check[x] =true;
		dfs(x+1,num+1,m);
		check[x] = false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int answer = 0;
		int[][] city = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				city[i][j] = sc.nextInt();
			}
		}

		System.out.println(solution(n, m, city));
	}

}
