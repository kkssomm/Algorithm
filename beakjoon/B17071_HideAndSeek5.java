package beakjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17071_HideAndSeek5 {
	
	private static int n, k;
	private static int[][] visit = new int[2][500001];
	
	public static int solution() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		int size, mod, time = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			time++;
			mod = time %2; // 짝 -> 0 / 홀 -> 1   
//			System.out.println("time: "+time);
			
			// {2} 시작점에서 BFS를 수행하며  visit의 sb 위치에 time 초에 방문
			for(int i=0;i<size;i++) {
				int sb = q.poll();
//				System.out.println("sb: "+sb);
				
				if(sb-1 >= 0 ) {
					if(visit[mod][sb-1]==-1) {
						q.add(sb-1);
						visit[mod][sb-1] = time;
					}
				}
				if(sb+1 <=500000) {
					if(visit[mod][sb+1]==-1) {
						q.add(sb+1);
						visit[mod][sb+1] = time;
					}
				}
				if(sb*2<=500000) {
					if(visit[mod][sb*2]==-1) {
						q.add(sb*2);
						visit[mod][sb*2] =time;
					}
				}
//				System.out.println(q);
			}
			
			// {3} 수빈과 동생의 방문 시간의 홀, 짝이 같다면 => 수빈이 -1, +1을 반복하며 만남 가능
			int br = getBr(time); // 동생의 위치
			if(br > 500000) break; // 동생이 500000 초과일때 -1
			if(visit[mod][br] != -1) return time; //동생 위치에 수빈이 있다면 time 반환
			
			// {4} 맞는 시간이 없다면 만남이 불가능하므로 계속 탐색 수행
		}
		return -1;
	}
	
	private static int getBr(int t) {
		return k + (t*(t+1)/2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		
		// {1} visit 배열을 -1로 초기화 하고 수빈이 이동할 경로 저장
 		Arrays.fill(visit[0], -1);
		Arrays.fill(visit[1], -1);
		visit[0][n] = 0;
		
		if(n==k) System.out.println(0);
		else System.out.println(solution());
		sc.close();
	}

}
