package java_01_basic;

public class Basic_06_Array {

	public static void main(String[] args) {
		/* ================I- Init Array ==========
		 * ArrayType [] arrayName = new ArrayType [size]; ArrayType = int/string/...
		 * */ 
		String[] testingPart = new String [4];
		testingPart[0] = "Automation Testing";
		testingPart[1] = "Manual Testing";
		testingPart[2] = "Performance Testing";
		testingPart[3] = "Security Testing";
		
		String[] testing = {"Automation Testing", "Manual Testing", "Performace Testing", "Security Testing"};
		
		/*=========II - Access value in Array=======*/
		int iLength = testing.length;
		System.out.println("Do dai cua Array = " + iLength);
		//4
		
		String auto = testing[0];
		System.out.println("Gia tri dau tien = " + auto );
		//Automation
		
		String security = testing[iLength - 1];
		System.out.println("Gia tri cuoi cung = " + security);
		//Security Testing
		System.out.println("---------------");
		
		//for(int i = 0; i<= iLength -1; i++) {
		//	System.out.println("Phan tu thu [" + i + "] trong Array = " + testing[i]);
		//}
		//System.out.println("----------------");
		
		//For-each
		//for (String test : testing) {
		//	System.out.println("Gia tri = " + test);
		//}
	//	System.out.println("------------------");
		parse_Array_To_Method(testing);
		
		String[] newArray = jobRoles();
		for(String array : newArray) {
			System.out.println("In tat ca gia tri trong mang = " + array);
		}
	}
public static void parse_Array_To_Method(String[] array) {
	for (int i = 0; i<= array.length - 1; i++) {
		System.out.println( array[i] );
	}
}
// return mang
public static String[] jobRoles() {
	String[] aArray = {"Developer", "Tester", "Businss Analysist", "Product Owner"};
	return aArray;
}
}
 