package java_01_basic;

public class Basic_07_String {

	public static void main(String[] args) {
	String automation = "Automation Testing";
	
	/*=======Length =======*/
	int length = automation.length();
	System.out.println("Do cai cua chuoi =" + length);
	
	String chuoi = "Automation Testing Tutorials";
	char kitu = chuoi.charAt(0);
	System.out.println("Ki tu =" + kitu);
	//Ki tu A

	/*=======Concate =======*/
	String testing = automation.concat(" Tutorials");
	System.out.println("Noi chuoi = " + testing);
	
	/*=======Equals =======*/
	boolean compareValue = testing.equals(automation);
	System.out.println("So sanh chuoi = " + compareValue );

	compareValue = automation.equals(automation);
	System.out.println("So sanh chuoi = " + compareValue);
	
	/*=======Index =======*/
	int index = testing.indexOf("T");
	System.out.println("Vi tri chuoi = " + index);
	
	/*=======SubString =======*/ 
	// Lay chuoi con ra tu chuoi cha
	//Automation Testing Tutorials
	
	String subStringStart = testing.substring(index);
	System.out.println("chuoi con = " + subStringStart);
	//Testing Tutorials
	
	String subStringStartToEnd = testing.substring(11, 18);
	System.out.println("Chuoi con = " + subStringStartToEnd  );
	//Testing
	
	String money = "100.00";
	money = money.replace("$", "");
	money = money.replace(".00", "");
	System.out.println(money);
	double money_ = Double.parseDouble(money);
	System.out.println("Value Double = " + money_);
	
	/*=======Split =======*/ 
	String text = "View 24 of 1064 results";
	
	String[] subString = text.split(" ");
	for (int i = 0; i < subString.length; i++) {
		System.out.println("Vi tri thu" + i + ":" + subString[i]);
	}
	 System.out.println(extractNumberFromString(text, 1));
	 System.out.println(extractNumberFromString(text, 3));
	 
	 /*=======Upper/Lower =======*/ 
	 // Automation Testing Tutorials
	 String upper = testing.toUpperCase();
	 System.out.println("In hoa = " + upper);
	 
	 String lower = testing.toLowerCase();
	 System.out.println("In thuong = " + lower);
	 
	 /*======= Trim =======*/ 
	 testing = "  \t \n   Automation Testing Tutorials   \n";
	 System.out.println(testing);
	 String trim = testing.trim();
	 System.out.println(" xoa space = " + trim);
	 boolean check = trim.equals("Automation Testing Tutorials");
	 System.out.println("Check equal after Trim = " + check);
	 
	 /*======= Convert String to Int | Double | Float to String =======*/ 
	 int number = 70;
	 String value = String.valueOf(number);
	 System.out.println("Value String = " + value);
	 value = number + "";
	 System.out.println("Value String = " + value);
	 
	 String price = "1000";
	 int price_ = Integer.parseInt(price);
	 System.out.println("Value Integer = " + price_);
	 
	 double price_double = Double.parseDouble(price);
	 System.out.println("Valu Double = " + price_double);
	 
	 float money_second = Float.parseFloat(price);
	 System.out.println("Value Float = " + money_second);
	 
	}
	public static int extractNumberFromString(String text, int number) {
		String[] subString = text.split(" ");
		int result = Integer.parseInt(subString[number]);
		return result;
	}

}
