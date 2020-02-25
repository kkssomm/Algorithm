package beakjun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1922_ConnectNetwork {
	
	static int[] parents;
	
	static class Edge {
		int v1;
		int v2;
		int w;

		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}

	public static int kruskal(int n, Edge[] e) {
		// 모든 간선을 가중치에 따라 오름차순 정렬
		Arrays.sort(e, new Comparator<Edge>(){
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.w - e2.w;
			}
		});
		
		// 부모노드 초기화
		parents = new int[n+1];
		for(int i=1;i<=n;i++) {
			parents[i] = i;
		}
		
		int cost = 0;
		for(Edge i : e) {
			// System.out.println("v1="+i.v1+" v2="+i.v2+" w="+i.w);
			if(!isCycle(i)) {
				// 가장 가중치가 작은 간선을 제거
				addEdge(i);
				cost+=i.w;
				// System.out.println("연결 - cost ="+cost);
			}
		}
		return cost;
	}
	
	
	// 연결하는 함수 (Union)
	public static void addEdge(Edge e) {
		int v1Root = findRoot(e.v1);
		int v2Root = findRoot(e.v2);
		
		parents[v1Root] = v2Root;
	}
	
	// 해당 간선을 그래프에 추가할 때 사이클 체크
	public static boolean isCycle(Edge e) {
		return findRoot(e.v1) == findRoot(e.v2)?true:false;
	}
	
	// 부모를 찾는 함수(Find)
	public static int findRoot(int v) {
		if(parents[v]==v)return v;
		
		parents[v] = findRoot(parents[v]);
		return parents[v];
 	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		Edge[] e = new Edge[m];
		int v1, v2, w;
		for (int i = 0; i < m; i++) {
				v1 = sc.nextInt();
				v2 = sc.nextInt();
				w = sc.nextInt();
				e[i] = new Edge(v1,v2,w);
		}
		
		int answer = kruskal(n,e);
		System.out.println(answer);
	}

}
