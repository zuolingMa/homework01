package com.mzl.homework01;

public class Tools {
	public static String toBinary(int num) {
        return toOther(num,2);
	}
	public static String toOctal(int num) {
        //add your code here
        return toOther(num,8);
    }
	public static String toHexadecimal(int num) {
        //add your code here
        return toOther(num,16);
    }
	public static String toOther(int num, int d) {
        //add your code here
		final int ARY = d;
		StringBuffer sb = new StringBuffer();
		ArrayStack as = new ArrayStack();
		
		if(num < 0) {
			sb.append('-');
			num = -num;
		}
		
		while(num > 0) {
			as.push(num%ARY+"");
			num = num/ARY;
		}
		
		while(!as.isEmpty()) {
			sb.append(as.pop());
		}
		
        return sb.toString();
    }
	public static char toChar(int n) {
        if ( n >= 0 && n <= 9 ) {
            return (char)('0' + n);
        } else if ( n >= 10 && n <= 15){
            return (char)('A' + n - 10);
        } else {
            throw new IllegalArgumentException();
        }
    }
	public static boolean isMatch(String exp) {
        ArrayStack s = new ArrayStack();
        for (char c : exp.toCharArray()) {
            if ( c == '[' || c == '(') {
                s.push(c);
            } else if ( c == ']' || c == ')') {
                if ( s.isEmpty()) {
                    return false;
                }
                char str = (Character)s.pop();
                if (c == ']' && str != '[') {
                    return false;
                } else if ( c == ')' && str != '(') {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

}
