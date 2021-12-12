
import java.util.Arrays;

public class ArrayToString {

	public static void main(String[] args) {
		String[] strArr = new String[] { "1", "2", "3" };

		String str = Arrays.toString(strArr).replaceAll("\\[", "").replaceAll("\\]", "");
		System.out.println("Java String array to String = " + str);
		
		
		
		
		
	}
}