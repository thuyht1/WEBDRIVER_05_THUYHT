package java_01_basic;

public class Basic_01_DataTypes {

	public static void main(String[] args) {
		/*======Boolean=======*/
		boolean testResult;
		testResult = true;
		System.out.println("Ket qua dung = " + testResult);
		testResult = false;
		System.out.println("Ket qua sai = " + testResult);
		System.out.println("==================");
		
		/*======Int=======*/
		int cart;
		cart = 2;
		System.out.println(" So luong gio hang = " + cart);
		cart = cart + 10;
		System.out.println(" So luong gia hang = " + cart);
		System.out.println("================");
		
		/*======Double=======*/
		double ketqua;
		ketqua = 8.60;
		System.out.println("Ket qua = " + ketqua);
		System.out.println("=================");
		
		/*======String=======*/
		String name, address, city;
		name = "Ho Thi Thuy";
		address = "Dong Anh";
		city = "Ha Noi";
		System.out.println(name);
		System.out.println(address);
		System.out.println(city);
		
		String phone = "0989405610";
		System.out.println(phone);

	}

}
