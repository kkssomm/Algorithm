package beakjoon;

import java.util.Scanner;

public class B9571_ILoveCroatia {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
	       
		   int start = sc.nextInt();
		   int end =start;
		   int n = sc.nextInt();
           int total = 0;
		   
           for(int i=0;i<n;i++) {
        	   String s = sc.nextLine();
        	   int sec = s.charAt(0);
        	   char answer = s.charAt(1);
        	   
        	   total+=sec;
        	   
        	   
        	   if(answer=='T') {
        		   end++;
        	   }
        	   
        	   if(total>210) {
        		   if(answer=='T') {
        			   end--;
        		   }
        		   break;
        	   }
        	   
        	   if(end>8) {
        		   end = end%8; 
        	   }
        	   
        	   System.out.println(i+": sec="+total+"bomb="+end);
        	   
        	  
           }
           
           System.out.println(end);
	        sc.close();
	    }
	}

