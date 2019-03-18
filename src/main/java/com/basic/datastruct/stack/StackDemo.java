package com.basic.datastruct.stack;

public class StackDemo {

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		stack.push(999);
		stack.push(888);
		stack.push(777);
		stack.push(666);
		System.out.println(stack);
		
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
		
		System.out.println(stack);
		
		System.out.println(stack.getCapacity());
		
		System.out.println(stack.getSize());
		
		System.out.println(validate("{}{}[[]]({}){{[[]]}}()"));
		
	}
	
	public static boolean validate(String str) {
		ArrayStack<Character> stack = new ArrayStack<>();
		int length = str.length();
		for(int i = length - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if(c == '}' || c == ']' || c == ')') {
				stack.push(str.charAt(i));
			} else {
				if(stack.isEmpty()) {
					return false;
				}
				
				Character pop = stack.pop();
				if(c == '{' && '}' != pop) {
					return false;
				}
				
				if(c == '[' && ']' != pop) {
					return false;
				}
				
				if(c == '(' && ')' != pop) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
}
