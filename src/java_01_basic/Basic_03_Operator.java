package java_01_basic;

public class Basic_03_Operator {

	public static void main(String[] args) {
		/*========Assign========*/
		int time = 10;
		String name = "Ho Thi Thuy";
		boolean value = false;
		System.out.println("Time = " + time);
		System.out.println("Name = " + name);
		System.out.println("Value = " + value);
		
		/*========Math========*/
		
		int a,b = 10, c = 5;
		a= b + c;
		System.out.println("Cong = " + a);
		
		a = b-c;
		System.out.println("Tru = " + a);
		
		a = b*c;
		System.out.println("Nhan = " + a);
		
		a= b/c;
		System.out.println("Chia lay nguyen = " + a);
		
		a= b%c;
		System.out.println("Chia lay du = " + a);
		
		b++;
		System.out.println("Tang len 1= " +b);
		
		c--;
		System.out.println("Giam di 1 = " +c);
		
		/*========Relation(true/false) boolean========*/
		
		int ten = 10;
		int twenty = 20;
		int thirty = 30;
		System.out.println("Lon hon =" + (ten > twenty));
		
		System.out.println("Lon hon or bang =" + (thirty >= twenty));
		
		System.out.println("Nho hon =" + (thirty < twenty));
				
		System.out.println("Nho hon or bang =" + (thirty <= twenty));
		
		System.out.println("bang bang =" + (thirty == twenty + ten));
		
		System.out.println("Khac bang =" + (thirty != twenty + ten));

		/*========Relation(true/false) boolean========*/
		
		boolean value_01 = true;
		boolean value_02 = false;
		
		System.out.println("Ca hai deu dung = " + (value_01 && value_02));
		//false
		
		System.out.println("Mot trong 2 dung = " + (value_01 || value_02));
		//true
		
		System.out.println("Phu dinh = " + (!value_01));
		
		/*========Condition========*/	
		// variable = (expression)? value_true : value_false
		
		int first = 10;
		int second = 20;
		int third = 30;
		boolean bValue;
		int iValue;
		
		bValue = (third == first + second) ? true : false;
		System .out.println("Gia tri = " + bValue);
		//true
		
		iValue = (third == second + first) ? 50 : 100;
		System.out.println("Ket qua = " + iValue);
		//50
		
		iValue = (!(third == second + first)) ? 50 : 100;
		System.out.println("Phu dinh cua ket qua = " + iValue);
		//100
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
