import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SortMaplist {
	private static final String ME = "ME";
	private static final String FE = "FE";
	private static final String MID = "Middle";

	public static void main(String[] args) {
		SortMaplist sortML = new SortMaplist();
		List<Map<String, String>> mlFinal = new ArrayList<Map<String, String>>();
		int i = 0;
		String str = "";
		HashMap<String, String> hm;
		do {
			if (i == 0) {
				str = MID;
			} else if (i == 1) {
				str = FE;
			} else if (i == 2) {
				str = ME;
			} else if (i == 3) {
				str = "aaaaaa";
			} else if (i == 4) {
				str = "ZZZZZZZ";
			} else {
				str = "value";
			}
			hm = new HashMap<String, String>();
			hm.put("Key1", str);
			hm.put("Key2", genrateRandomString(0));
			hm.put("Key3", genrateRandomString(1));
			hm.put("Key4", genrateRandomString(2));
			mlFinal.add(hm);
			i++;
		} while (i < 3);
		System.out.println(" mlFinal  = " + mlFinal);
		Collections.sort(mlFinal, sortML.new CustomComparator("Key1","ascending"));
		System.out.println(" mlFinal  = " + mlFinal);
		Collections.sort(mlFinal, sortML.new CustomComparator("Key1","null"));
		System.out.println(" mlFinal  = " + mlFinal);
		Collections.sort(mlFinal, sortML.new CustomComparator("Key1","descending"));
		System.out.println(" mlFinal  = " + mlFinal);
	}

	private static String genrateRandomString() {
		String sRetrunStr = "";
		for (int i = 0; i < 5; i++) {
			sRetrunStr = sRetrunStr + (char) (97 + new Random().nextInt(26));
		}
		return sRetrunStr;
	}

	private static String genrateRandomString(int length) {
		String sRetrunStr = "";
		for (int i = 0; i < length; i++) {
			sRetrunStr = sRetrunStr + (char) (97 + new Random().nextInt(26));
		}
		return sRetrunStr;
	}

	/**
	 * @author azhagu.m.manickam Class to sort maplist using custom order
	 *
	 */
	public class CustomComparator implements Comparator<Map<String, String>> {
		private String sortkey;
		private final String sortorder;
		private final List<String> customorder = Arrays.asList(FE, MID, ME);

		public CustomComparator(String sVarToStart, String sortorder) {
			this.sortkey = sVarToStart;
			
			
			if ("descending".equalsIgnoreCase(sortorder)) {
				this.sortorder = sortorder;
			} else {
				this.sortorder = "asdending";
			}
			
		}

		@Override
		public int compare(Map<String, String> o1, Map<String, String> o2) {
			int res=1;
			int o1_index = customorder.indexOf(o1.get(sortkey));
			o1_index = o1_index == -1 ? 0 : o1_index;
			int o2_index = customorder.indexOf(o2.get(sortkey));
			o2_index = o2_index == -1 ? 0 : o2_index;
			
			
			if (this.sortorder.equalsIgnoreCase("descending")) {
				 res = o2_index - o1_index;
			} else {
				 res = o1_index - o2_index;
			}
			
			
			return res;
		}
	}
}
