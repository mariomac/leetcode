package g200.g260.p263uglynumber;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public boolean isUgly(int num) {
		if(num == 0) return false;
		if(num == 1) return true;
		int operations;
		do {
			operations = 0;
			if(num%2==0) { num /= 2; operations = 1; }
			if(num%3==0) { num /= 3; operations = 1; }
			if(num%5==0) { num /= 5; operations = 1; }
		} while(operations > 0);
		return num == 1;
	}
}