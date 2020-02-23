package cos;

class Solution1_03 {
    public int Solution1_3(String pos) {
        // Write code here.
        int answer = 0;
        
        int[] dx = {-2,-1,1,2,1,2,-1,-2};
        int[] dy = {-1,-2,-2,-1,2,1,2,1};
        
        int x = pos.charAt(0)-'A';
        int y = pos.charAt(1)-'0'-1;

        for(int i=0;i<8;i++) {
        	int idx = x+dx[i];
        	int idy = y+dy[i];
        	if(idx>=0&&idx<8&&idy>=0&&idy<8) {
        		answer++;
        	}
        }
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1_03 sol = new Solution1_03();
        String pos = "A7";
        int ret = sol.Solution1_3(pos);

        // Press Run button to receive output. 
        System.out.println("Solution1_3: return value of the method is " + ret + " .");
    }
}

//#����3
//ü������ ����Ʈ(knight)�� �Ʒ� �׸��� ���� ���׶�̷� ǥ�õ� 8���� ������ �� ������ �� ���� �̵��� �����մϴ�.
//
//![image](https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/challengeable-imgs/20180315_knight.png)
//
//��, ����Ʈ�� ü���� �����δ� �̵��� �� �����ϴ�.
//
//ü������ �� ĭ�� ��ġ�� ������ ���� ǥ���մϴ�.
//![image](https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/challengeable-imgs/20180315_knight2.png)
//���� ���, A���ٰ� 1������ ��ġ�� �κ��� 'A1'�̶�� �մϴ�.
//
//����Ʈ�� ��ġ pos�� �Ű������� �־��� ��, ����Ʈ�� �� �� �������� �̵��� �� �ִ� ĭ�� ����� return �ϵ��� solution �޼ҵ带 �ϼ����ּ���.
//
//---
//
//#####�Ű����� ����
//����Ʈ�� ��ġ pos�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//* pos�� A���� H������ �빮�� ���ĺ� �ϳ��� 1 �̻� 8������ ���� �ϳ��� �̷���� �� ���� ���ڿ��Դϴ�.
//* �߸��� ��ġ�� �־����� ���� �����ϴ�.
//
//---
//
//#####return �� ����
//����Ʈ�� �� �� �������� �̵��� �� �ִ� ĭ�� ������ return ���ּ���.
//
//---
//#####����
//
//| pos  | return |
//|------|--------|
//| "A7" | 3      |
//
//#####���� ����
//����Ʈ�� A7 ��ġ�� ������ �Ʒ� �׸��� ���� �������δ� �̵����� ���ϰ�, ���������δ� �� ���� ������ ������ �� ĭ���� �̵� �����մϴ�. 
//![image](https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/challengeable-imgs/20180315_knight3.png)
//����, 3�� return �ϸ� �˴ϴ�.
