package kakao2017;

public class pedestrianParadise {

	static int MOD = 20170805;

	public static int solution(int m, int n, int[][] cityMap) {
		int[][] rightway = new int[m+1][n+1];
		int[][] downway = new int[m+1][n+1];
		
		rightway[1][1] =1;
		downway[1][1] =1;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				//모든 방향
				if(cityMap[i-1][j-1]==0) {
					rightway[i][j]+=(rightway[i][j-1]+downway[i-1][j])%MOD;
					downway[i][j]+=(rightway[i][j-1]+downway[i-1][j])%MOD;
				}
				//직진만
				else if(cityMap[i-1][j-1]==2) {
					rightway[i][j]+=rightway[i][j-1]%MOD;
					downway[i][j]+=downway[i-1][j]%MOD;
				}
				//통행불가
				else {
					continue;
				}
			}
		}
		return rightway[m][n-1]+downway[m-1][n];
	}

	public static void main(String[] args) {
//		int m = 3;
//		int n = 3;
//		int[][] city_map = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		int m =3;
		int n = 6;
		int[][] city_map = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		
		System.out.println(solution(m, n, city_map));

	}

}
