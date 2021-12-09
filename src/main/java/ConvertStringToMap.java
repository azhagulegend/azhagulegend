import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ConvertStringToMap {

	public static void main(String[] args) throws Exception {
		String sTypeMap = "SA=S A|CP=C P |Die=Die";
		
		
		ConvertStringToMap obj = new ConvertStringToMap();
		Map<String, String> displayValueMap = obj.getDisplayValueMap(sTypeMap);
		String key = "";
		String val = "";
		for (Entry<String, String> entry : displayValueMap.entrySet()) {
			key = entry.getKey();
			val = entry.getValue();
			System.out.println(" key  = " + key);
			System.out.println(" val  = " + val);
		}
	}
	
	
	private Map<String, String> getDisplayValueMap(String sRangeValueMapping) throws Exception {
		Map<String, String> sTypeMapping = new HashMap<String, String>();
		try {
			
			String aTypes[] = sRangeValueMapping.split("\\|");
			String aEachMapSplit[];
			String sKey = "";
			String sValue = "";
			for (String eachMap : aTypes) {
				aEachMapSplit = eachMap.split("=");
				sKey = aEachMapSplit[0].trim();
				sValue = aEachMapSplit[1].trim();
				sTypeMapping.put(sKey, sValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sTypeMapping;
		
	}
}
