import java.sql.SQLException;
import java.util.Scanner;

/**
String[] ans = context.split("\\#");
String a1 = ans[0];
String a2 = ans[1];
String a3 = ans[2];
String a4 = ans[3];
String a5 = ans[4];
String a6 = ans[5];
String a7 = ans[6];
String a8 = ans[7];
String a8 = ans[8];
String a9 = ans[9];
System.out.println("s1 = " + s1);
System.out.println("s2 = " + s2);
System.out.println("s3 = " + s3);
System.out.println("s4 = " + s4);
System.out.println("s5 = " + s5);*/
public class Main {
	public static void main(String arg[]){
		String context;
		int Id[] = new int[10];
		int cont[]=new int[10];
		int result = 0;
		Scanner in = new Scanner(System.in);
		//System.out.println("璇疯緭鍏ラ鐩彿:");
		//for(int k=0;k<10;k++)
		//	cont[k]=in.nextInt();
		cont = randomCommon(1, 21, 10);
		try {
			for (int k=0;k<10;k++){
				exam e = DataProcessing.searchQT(cont[k]);
				context = e.getAllContext();
				Id[k] = e.getId();
				System.out.println(k+1+"."+context);
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int k=0;k<10;k++)
			System.out.print(Id[k]+"*");
		System.out.println();
		System.out.print("锟斤拷锟斤拷锟斤拷锟�");
		String r[] = new String[10];
		for(int k=0;k<10;k++)
			r[k]=in.next();
		int ans[]=new int[10];
		for(int i=0;i<10;i++){
			if(r[i].equals("A"))
				ans[i]=1;
			else if(r[i].equals("B"))
				ans[i]=2;
			else if(r[i].equals("C"))
				ans[i]=3;
			else if(r[i].equals("D"))
				ans[i]=4;
			else ans[i] = -1;
		}

		try {
			result = DataProcessing.Calc(Id, ans);
			System.out.println("锟斤拷锟侥得凤拷为"+result+"锟斤拷");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int[] randomCommon(int min, int max, int n){  
	    if (n > (max - min + 1) || max < min) {  
	           return null;  
	       }  
	    int[] result = new int[n];  
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	            result[count] = num;  
	            count++;  
	        }  
	    }  
	    return result;  
	}  
}
