package java_01_basic;

public class Basic_04_Condition_Statement {

	public static void main(String[] args) {
		/*=======If=======*/
		boolean value = true;
		if(value = true) {
			System.out.println("Value = " + value);
		}
		
		if(value) {
			System.out.println("Value = " + value);
		}
		System.out.println("=====================");
		
		int diem = 10;
		if(diem == 10) {
			System.out.println("Hoc sinh xuat sac");
		}
		System.out.println("==============");
	
		/*=======If Else If=======*/
		// Khong dung qua 5 dk => dung switch case => tang performance
	
		String browser = "ie";
		if(browser == "chrome") {
			System.out.println("Khoi to trinh duyet CHROME");
		} else if (browser == "firefox") {
			System.out.println("Khoi tao trinh duyet FIREFOX");
		} else {
			System.out.println("Khoi tao trinh duyet IE");
		}
		System.out.println("===================");
	
	/*=======Switch case =======*/
	String browser_ = "chrome";
	switch (browser_) {
	case "chrome": 
		System.out.println("Khoi tao trinh duyet CHROME");
		break;
	case "firefox":
		System.out.println("Khoi tao trinh duyet FIREFOX");
		break;
	case "ie":
	System.out.println("Khoi tao trinh duyet IE");
	break;
	default:
		System.out.println("Khoi tao trinh duyet SAFARI");
		break;
	}
	System.out.println("========================");
	
	int number = 15;
	switch(number) {
	case 10 :
		System.out.println(" 10 ");
	case 15:
		System.out.println(" 15 ");
		break;
	} 
	
	System.out.println("==================");
	
	String page = "Home Page";
	switch (page) {
		case "New Customer":
			System.out.println("Open New Customer page");
			break;
		case "Edit Customer":
			System.out.println("Open Edit Customer page");
			break;
		case "Delete Customer":
			System.out.println("Open Delete Customer page");
			break;
			default: 
				System.out.println("Open Home Page");
				break;
	}
		}
}
		
