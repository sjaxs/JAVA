package wellBalanced;

import dataStructures.stack.*;

public class WellBalanced {

	private final static String OPEN_PARENTHESES = "{[(";
	private final static String CLOSED_PARENTHESES = "}])";

	public static void main(String[] args) {
		String s = "vv(hg(jij)hags{ss[dd]dd})";
		String s1 = "())";
		Stack<Character> stack = new LinkedStack <Character>();
		System.out.println(wellBalanced(s,stack));
		System.out.println(wellBalanced(s1,stack));

	}

	public static boolean wellBalanced(String exp, Stack<Character> stack) {

		
		int i = 0;
		while(i < exp.length() ){
			char c = exp.charAt(i);
			if(isOpenParentheses(c)){
				stack.push(c);
				
			}else if (isClosedParentheses(c) && stack.isEmpty()){
				return false;
			}else if (isClosedParentheses(c)){
				
				char d = stack.top();
				
				if(match(c,d)){
					stack.pop();
				}
			}
			i++;
		}
		return stack.isEmpty();
		
	}

	public static boolean isOpenParentheses(char c) {
		
		return OPEN_PARENTHESES.indexOf(new Character(c).toString()) >= 0;
	}

	public static boolean isClosedParentheses(char c) {
		
		return CLOSED_PARENTHESES.indexOf(new Character(c).toString()) >= 0;
	}

	public static boolean match(char x, char y) {
		
		return OPEN_PARENTHESES.indexOf(new Character(x).toString()) == CLOSED_PARENTHESES
				.indexOf(new Character(y).toString());
	}
}
