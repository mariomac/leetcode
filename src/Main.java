import g000.g10.p10regexp.*;
@SuppressWarnings("PointlessBooleanExpression")
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        assert s.isMatch("aa","a") == false;
        assert s.isMatch("aa","aa")  ==  true;
        assert s.isMatch("aaa","aa")  ==  false;
        assert s.isMatch("aa", "a*")  ==  true;
        assert s.isMatch("aa", ".*")  ==  true;
        assert s.isMatch("ab", ".*")  ==  true;
        assert s.isMatch("aab", "c*a*b")  ==  true;
        assert s.isMatch("ab", ".*c")  ==  false;
        assert s.isMatch("a", "ab*")  ==  true;
        assert s.isMatch("aaa", "a.a")  ==  true;
        assert s.isMatch("aaa", "a*a")  ==  true;
        assert s.isMatch("aaa", "ab*a*c*a")  ==  true;

    }
}
