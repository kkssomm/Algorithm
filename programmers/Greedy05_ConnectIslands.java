package programmers;

public class Greedy05_ConnectIslands {
	
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int[][] graph = new int[n][n];
		int[] connected = new int[n];
		for (int i = 0; i < costs.length; i++) {
			graph[costs[i][0]][costs[i][1]] = costs[i][2];
			graph[costs[i][1]][costs[i][0]] = costs[i][2];
		}
//		for(int i=0;i<graph.length;i++) {
//			for(int j=0;j<graph.length;j++) {
//				System.out.print(graph[i][j]);
//			}
//			System.out.println();
//		}

		connected[2] = 1;
		answer =  prim(graph, connected, 0, 1);
		return answer;
	}

	public static int prim(int[][] graphs, int[] connected, int value, int count) {
		// 모든 노드를 방문하면 종료
		if (count == connected.length)
			return value;
		for(int i:connected) System.out.print(i+" ");
		System.out.println();
		
		int to = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < connected.length; i++) {
			// 현재 간선이 연결되어 있으면 처리
			if (connected[i] == 1) { 
				// 현재 연결된 간선들과 연결된 노드중 최소값을 가지는 간선을 연결해 트리 확장
				for (int j = 0; j < graphs.length; j++) { 
					if (connected[j] == 0 && graphs[i][j] != 0 && min > graphs[i][j]) {
						to = j;
						min = graphs[i][j];
						// System.out.println("i"+i+" to"+to+" min"+min);
					}
				}
			}
		}
		connected[to] = 1; // 최소값 간선을 선택
		value += min; // 최소값 추가
		count++; // 연결된 간선 개수 추가
		return prim(graphs, connected, value, count);
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n, costs));

	}

}
