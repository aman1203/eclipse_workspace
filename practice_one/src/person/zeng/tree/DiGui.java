package person.zeng.tree;

public class DiGui {
	static int count=1;
	static int max;
	static boolean flag = false;
	public static void main(String[] args) {
		printNum(8);
	}
	
	public static void printNum(int i) {
	  if(!flag) {
	    max = i;
	    flag = true;
	  }
		if(count==max) {
			System.out.println(count);
		}else {
			System.out.println(count);
			count++;
			printNum(count+1);
		}
	}
}
