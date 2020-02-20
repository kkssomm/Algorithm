package cos;

class Solution1_02 {
    public int solution(int n) {
        // Write code here.
    	int answer = 0;
    	
    	int[][] map = new int[n][n];
    	int count = 1 ;
    	int delta = 1;
    	int p = 0;
    	int q = -1;
    	int k = n;
    	
    	while(true) {
    		for(int i=0;i<k;i++) {
    			q+= delta;
    			//System.out.println(p+" "+q);
    			map[p][q] = count;
    			count++;
    		}
    		
    		k--;
    		if(k<0) {
    			break;
    		}

    		for(int i=0;i<k;i++) {
    			p +=delta;
    			//System.out.println(p+" "+q);
    			map[p][q] = count;
    			count++;
    		}
    		
    		delta= -delta;
    	}
    	
//    	for(int i=0;i<n;i++) {
//    		for(int j = 0;j<n;j++) {
//    			System.out.print(map[i][j]);
//    		}
//    		System.out.println();
//    	}
    	
    	for(int i=0;i<n;i++) {
    		answer+=map[i][i];
    	}
    	
    	return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1_02 sol = new Solution1_02();
        int n1 = 3;
        int ret1 = sol.solution(n1);

        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");
        
        int n2 = 2;
        int ret2 = sol.solution(n2);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}

//#����2
//������ ���� n x n ũ���� ���ڿ� 1���� n x n������ ���� �ϳ��� �ֽ��ϴ�.
//![image](http://res.cloudinary.com/sgc109/image/upload/c_scale,w_300/v1517462270/%EA%B7%B8%EB%A6%BC1_qysbr6.png)
//�̶� ���� ������ ���� ������ ��ġ�Ǿ��ִٸ� �̰��� n-�ҿ뵹�� ����� �θ��ϴ�.
//![image](http://res.cloudinary.com/sgc109/image/upload/c_scale,w_300/v1517462270/%EA%B7%B8%EB%A6%BC2_ol8snc.png)
//�ҿ뵹�� ������ 1�� 1������ n �� n ������ �밢���� �����ϴ� ������ ���� ���ؾ� �մϴ�.
//![image](http://res.cloudinary.com/sgc109/image/upload/c_scale,w_300/v1517462270/%EA%B7%B8%EB%A6%BC3_cbcdg3.png)
//���� ������ �밢���� �����ϴ� ���� ���� 15�Դϴ�.
//������ ũ�� n�� �־��� �� n-�ҿ뵹�� ���� �밢���� �����ϴ� ������ ���� return �ϵ��� solution �޼ҵ带 �ϼ����ּ���.
//
//---
//##### �Ű����� ����
//������ ũ�� n�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//
//* n�� 1 �̻� 100 ������ �ڿ����Դϴ�.
//
//---
//##### return �� ����
//n-�ҿ뵹�� ���� �밢���� �����ϴ� ������ ���� return ���ּ���.
//
//---
//##### ����
//
//| n 	| return 	|
//|---	|--------	|
//| 3 	| 15     	|
//| 2 	| 4      	|
//
//##### ���� ����
//���� #1
//������ ���� �����ϴ�.
//
//���� #2
//![image](http://res.cloudinary.com/sgc109/image/upload/c_scale,w_300/v1517462270/%EA%B7%B8%EB%A6%BC4_astq7q.png)
//1�� 3�� ���Ͽ� 4�� �˴ϴ�.

