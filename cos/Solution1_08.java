package cos;

import java.util.ArrayList;
import java.util.Iterator;

//DeliveryStore interface, Food and PizzaStore class are written as Inner Class. Read the code below and fill in the blank.
class Solution1_08 {
    interface DeliveryStore{
        public void setOrderList(String[] orderList);
        public int getTotalPrice();
    }
    
    class Food{
        public String name;
        public int price;
        public Food(String name, int price){
            this.name = name;
            this.price = price;
        }
    }
    
    class PizzaStore implements DeliveryStore  {
        private ArrayList<Food> menuList;
        private ArrayList<String> orderList;
        
        public PizzaStore(){
            //init menuList
            menuList = new ArrayList<Food>();
            String[] menuNames = {"Cheese", "Potato", "Shrimp", "Pineapple", "Meatball"};
            int[] menuPrices = {11100, 12600, 13300, 21000, 19500};
            for(int i = 0; i < 5; i++)
                menuList.add(new Food(menuNames[i], menuPrices[i]));
            
            //init orderList
            orderList = new ArrayList<String>();
        }
        
        public void setOrderList(String[] orderList) {
            for(int i = 0; i < orderList.length; i++)
                this.orderList.add(orderList[i]);
        }
        
        public int getTotalPrice(){
            int totalPrice = 0;
            Iterator<String> iter = orderList.iterator();
            while (iter.hasNext()) {
                String order = iter.next();
                for(int i = 0; i < menuList.size(); i++)
                    if(order.equals(menuList.get(i).name))
                        totalPrice += menuList.get(i).price;
            }
            return totalPrice;
        }
    }
    
    public int Solution1_8(String[] orderList) {
        DeliveryStore deliveryStore = new PizzaStore();
        
        deliveryStore.setOrderList(orderList);
        int totalPrice = deliveryStore.getTotalPrice();
        
        return totalPrice;
    }
    
    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution1_08 sol = new Solution1_08();
        String[] orderList = {"Cheese", "Pineapple", "Meatball"};
        int ret = sol.Solution1_8(orderList);
        
        // Press Run button to receive output. 
        System.out.println("Solution1_8: return value of the method is " + ret + " .");
    }
}

//#����8
//������� ������ ��� ���� ������ ���� DeliveryStore �������̽���  PizzaStore, Food Ŭ������ �ۼ��߽��ϴ�.
//
//![image](https://s3.ap-northeast-2.amazonaws.com/grepp-cloudfront/programmers_imgs/challengeable-imgs/20180316_deli_java1.png)
//
//* DeliveryStore :
//  * DeliveryStore�� ��� �������� �������̽��Դϴ�.
//  * ��� �������� setOrderList�� getTotalPrice �޼ҵ带 �����ؾ� �մϴ�.
//  * setOrderList �޼ҵ�� �ֹ� �޴��� ����Ʈ�� �Ű������� �޾� �����մϴ�.
//  * getTotalPrice �޼ҵ�� �ֹ����� ���� ������ ������ return �մϴ�.
//
//* Food : 
//  * Food�� ������ ��Ÿ���� Ŭ�����Դϴ�.
//  * ������ �̸�(name)�� ����(price)���� �����Ǿ��ֽ��ϴ�.
//
//* PizzaStore
//  * PizzaStore�� ���� ��� �������� ��Ÿ���� Ŭ�����̸� DeliveryStore �������̽��� �����մϴ�.
//  * menuList�� ���� ��� ���������� �ֹ� �� �� �ִ� ������ ����Ʈ�� �����մϴ�.
//  * orderList�� �ֹ� ���� ���ĵ��� �̸��� �����մϴ�.
//  * setOrderList �޼ҵ�� �ֹ� �޴��� �޾� orderList�� �����մϴ�.
//  * getTotalPrice �޼ҵ�� orderList�� ����ִ� ���� ������ ������ return �մϴ�.
//
//�ֹ� �޴��� ����ִ� �迭 orderList�� �Ű������� �־��� ��, �ֹ��� �޴��� ��ü ������ return �ϵ��� solution �޼ҵ带 �ۼ��Ϸ��� �մϴ�. ���� Ŭ���� ������ �����Ͽ� �־��� �ڵ��� ��ĭ�� ������ ä�� ��ü �ڵ带 �ϼ����ּ���.
//
//---
//##### �Ű����� ����
//�ֹ� �޴��� ����ִ� �迭 orderList�� solution �޼ҵ��� �Ű������� �־����ϴ�.
//
//* orderList�� ���̴� 1 �̻� 5�����Դϴ�.
//* orderList���� �ֹ��Ϸ��� �޴��� �̸����� ���ڿ� ���·� ����ֽ��ϴ�.
//  * orderList���� ���� �޴��� �̸��� �ߺ��ؼ� ������� �ʽ��ϴ�.
//* �޴��� �̸��� ������ PizzaStore�� �����ڿ��� �ʱ�ȭ���ݴϴ�.
//
//---
//##### return �� ����
//�ֹ��� �޴��� ��ü ������ return ���ּ���.
//
//---
//##### ����
//
//| orderList                          | return |
//|-------------------------------------|--------|
//| ["Cheese", "Pineapple", "Meatball"] | 51600  |
