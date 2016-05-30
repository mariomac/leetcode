package g000.g10.p12inttoroman;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public String intToRoman(int num) {
		Map<Integer,String> digits = new TreeMap<>((o1,o2)->-o1.compareTo(o2));
		digits.put(1000,"M");
		digits.put(900,"CM");
		digits.put(500,"D");
		digits.put(400,"CD");
		digits.put(100,"C");
		digits.put(90,"XC");
		digits.put(50,"L");
		digits.put(40,"XL");
		digits.put(10,"X");
		digits.put(9,"IX");
		digits.put(5,"V");
		digits.put(4,"IV");
		digits.put(1,"I");
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer,String> digit : digits.entrySet()) {
			while(num >= digit.getKey()) {
				sb.append(digit.getValue());
				num -= digit.getKey();
			}
		}
		return sb.toString();
	}
}
