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
		// ��� ��带 �湮�ϸ� ����
		if (count == connected.length)
			return value;
		for(int i:connected) System.out.print(i+" ");
		System.out.println();
		
		int to = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < connected.length; i++) {
			// ���� ������ ����Ǿ� ������ ó��
			if (connected[i] == 1) { 
				// ���� ����� ������� ����� ����� �ּҰ��� ������ ������ ������ Ʈ�� Ȯ��
				for (int j = 0; j < graphs.length; j++) { 
					if (connected[j] == 0 && graphs[i][j] != 0 && min > graphs[i][j]) {
						to = j;
						min = graphs[i][j];
						// System.out.println("i"+i+" to"+to+" min"+min);
					}
				}
			}
		}
		connected[to] = 1; // �ּҰ� ������ ����
		value += min; // �ּҰ� �߰�
		count++; // ����� ���� ���� �߰�
		return prim(graphs, connected, value, count);
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n, costs));

	}

}
