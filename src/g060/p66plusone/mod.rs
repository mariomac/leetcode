struct Solution;

impl Solution {
    pub fn plus_one(digits: Vec<i32>) -> Vec<i32> {
        let mut carry = 1;
        let mut reverted_plus = Vec::with_capacity(digits.len()+1);
        for n in digits.iter().rev() {
            let mut d = *n + carry;
            if d > 9 {
                d = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            reverted_plus.push(d);
        }
        if carry > 0 {
            reverted_plus.push(1);
        }
        reverted_plus.reverse();
        reverted_plus
    }

}

#[cfg(test)]
mod test {
    use super::Solution;

    #[test]
    pub fn test_plus_one() {
        assert_eq!(vec!(1, 2, 4), Solution::plus_one(vec!(1, 2, 3)));
        assert_eq!(vec!(7, 0, 0), Solution::plus_one(vec!(6, 9, 9)));
    }
}