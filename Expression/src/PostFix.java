import dataStructures.stack.ArrayStack;
import dataStructures.stack.Stack;

public class PostFix {
	

	public static void main(String[] args) {
		Item [] sample = {
				new Data(5),
				new Data(6),
				new Data(2),
				new Dif(),
				new Data(3),
				new Mul(),
				new Add() };
		System.out.println(evaluate(sample));

	}
	
	static int evaluate(Item[] exprList){
		Stack<Integer> s =  new ArrayStack<Integer>();
		for(int i = 0; i < exprList.length; i++){
			if(exprList[i].isData()){
				s.push(exprList[i].getValue());
			}if(exprList[i].isOperation()){
				int a = s.top();
				s.pop();
				int b = s.top();
				s.pop();
				
				int c = exprList[i].evaluate(b, a);
				s.push(c);
			}
		}
		
		return s.top();
	}

}
