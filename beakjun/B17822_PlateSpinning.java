package beakjun;
// n/x 번원판 돌리기 -> rotate + delete - > t번 반복
public class B17822_PlateSpinning {
	public static int solution(int n, int m, int t, int[][] plates, int x, int d, int k) {
		int answer = 0;
		
		// t번 반복
		for(int i=1;i<=t;i++) {
			// j번째 원판 돌리기
			for(int j=x;j<=n;) {
				System.out.println(j);
				j=j*x;
			}
			//delete();
		}
		
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		int n= 6;
		int m= 4;
		int t= 1;
		int x = 2;
		int d = 0;
		int k = 1;
		int[][] plates = {{1,1,2,3},{5,2,4,2},{3,1,3,5},{2,1,3,2}};
		
		int answer = solution(n,m,t,plates,x,d,k);
		System.out.println(answer);
	}

}
