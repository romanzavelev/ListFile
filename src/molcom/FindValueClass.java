package molcom;

public class FindValueClass {
	
	public static boolean findValue(String[] arg,String testStr){
		for (String str : arg) {
			if (str == testStr) {
				return true;
			}
		}
		
		return false;	
	}

}
