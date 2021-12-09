import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveFromList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
				add(5);
			}
		};
		List<Integer> modifiedlist = new ArrayList<Integer>();
		modifiedlist.addAll(list);

		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		ArrayList<Integer> oddNumbers = new ArrayList<Integer>();
		for (Integer integer : list) {
			if (integer % 2 == 0) {
				evenNumbers.add(integer);
			} else {
				oddNumbers.add(integer);
			}
		}
//		System.out.println(" list  = " + list);
//		System.out.println(" modifiedlist  = " + modifiedlist);
//		System.out.println(" oddNumbers  = " + oddNumbers);
//		System.out.println(" evenNumbers  = " + evenNumbers);
//
//		modifiedlist.removeAll(oddNumbers);
//		System.out.println(" modifiedlist  = " + modifiedlist);
		removeFromMaplist();
	}

	private static void removeFromMaplist() {

		try {
			HashMap<String, String> hmMap1 = new HashMap<String, String>();
			hmMap1.put("str1", "str1");
			hmMap1.put("str2", "str2");
			hmMap1.put("str3", "str3");
			System.out.println(" hmMap1  = " + hmMap1);
			HashMap<String, String> hmMap2 = new HashMap<String, String>();
			hmMap2.put("a", "a");
			hmMap2.put("b", "b");
			hmMap2.put("c", "c");
			System.out.println(" hmMap2  = " + hmMap2);
			HashMap<String, String> hmMap3 = new HashMap<String, String>();
			hmMap3.put("z", "z");
			hmMap3.put("x", "x");
			hmMap3.put("qq", "qq");
			System.out.println(" hmMap3  = " + hmMap3);
			ArrayList<Map<String, String>> ml = new ArrayList<Map<String, String>>();
			ml.add(hmMap1);
			ml.add(hmMap2);
			ml.add(hmMap3);
			System.out.println(" ml  = " + ml);
			ArrayList<Map<String, String>> mlMapsToBeRemoved = new ArrayList<Map<String, String>>();
			ArrayList<Map<String, String>> mlFinal = new ArrayList<Map<String, String>>();
			mlFinal.addAll(ml);

			for (Map<String, String> map : ml) {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					String key = entry.getKey();
					if (key != null && key.startsWith("str")) {
						mlMapsToBeRemoved.add(map);
						break;
					}
				}
			}
			System.out.println(" mlMapsToBeRemoved  = " + mlMapsToBeRemoved);
			mlFinal.removeAll(mlMapsToBeRemoved);
			System.out.println(" mlFinal  = " + mlFinal);
		} catch (Exception e) {
			System.out.println("Exception in RemoveFromList:removeFromMaplist" + e.toString());
			e.printStackTrace();
			throw e;
		}

	}
}
