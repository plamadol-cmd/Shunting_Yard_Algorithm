package p_03;

import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		ShuntingYard algorithms = new ShuntingYard();
		String mathExpression = "3+(2+1)*2^3^2-8/(5-1*2/2)";
		Deque<String> postfixedForm = algorithms.getPostfixedForm(mathExpression);
		Integer evaluation = algorithms.evaluatePostfixedForm(postfixedForm);
		
		System.out.println("initial expression: " + mathExpression);
		System.out.println("post-fixed form: " + algorithms.getPostfixedForm(mathExpression)); //?
		System.out.println("evaluation: " + evaluation);
	}

}
