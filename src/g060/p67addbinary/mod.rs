use std::cmp::max;

impl Solution {
    pub fn add_binary(a: String, b: String) -> String {
        let mut vec: Vec<u8> = Vec::with_capacity(max(a.len(), b.len()));

        let (ba, bb) = (a.into_bytes(), b.into_bytes());
        let (mut ia, mut ib) = (ba.iter().rev(), bb.iter().rev());

        let mut carry = b'0';
        let mut oa = ia.next();
        let mut ob = ib.next();
        while oa.is_some() && ob.is_some() {
            let (a, b) = (oa.unwrap(), ob.unwrap());
            let sum = (*a - b'0') + (*b - b'0') + carry;
            if sum > b'1' {
                carry = b'1';
                vec.push(b'0');
            } else {
                carry = b'0';
                vec.push(sum);
            }
            oa = ia.next();
            ob = ib.next();
        }

        let (mut ii, mut oi) = if oa.is_some() {
            (ia, oa)
        } else {
            (ib, ob)
        };

        while let Some(n) = oi {
            let sum = (*n - b'0') + carry;
            if sum > b'1' {
                carry = b'1';
                vec.push(b'0');
            } else {
                carry = b'0';
                vec.push(sum)
            }
            oi = ii.next();
        }

        if carry == b'1' {
            vec.push(b'1');
        }
        vec.reverse();
        String::from_utf8(vec).unwrap()
    }
}

struct Solution;

#[cfg(test)]
mod test {
    use crate::g060::p67addbinary::Solution;

    #[test]
    pub fn the_test() {
        assert_eq!("10000", Solution::add_binary("1111".to_string(), "1111".to_string()))
    }
}