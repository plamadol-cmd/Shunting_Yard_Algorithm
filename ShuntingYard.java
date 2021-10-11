package p_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ShuntingYard {
	//Associativity and precedence for operators +, -, *, /, ^
	private ArrayList<Character> operators = 
			new ArrayList<Character>(Arrays.asList('+', '-', '*', '/', '^'));
	private ArrayList<String> associativity = 
			new ArrayList<String>(Arrays.asList("left", "left", "left", "left", "right"));
	private ArrayList<Integer> precedence = 
			new ArrayList<Integer>(Arrays.asList(11, 11, 12, 12, 13));
	private Deque<String> postfixedForm = new LinkedList<String>();
	//stack for operators
	private Deque<Character> oprStack = new LinkedList<Character>();
	//stack for evaluation
		private Deque<Integer> evalStack = new LinkedList<Integer>();
	//expression's iterator
	private int i;
	
	//o1 - current digit or current operator
	//o2 - first element of the stack
	Character o1;
	Character o2;
	
	public String checkDigits(String mathExpression) {
		String stringNumber = "" + mathExpression.charAt(i);
		while (Character.isDigit(mathExpression.charAt(i + 1))) {
			stringNumber += mathExpression.charAt(i + 1);
			i++;
		}
		return stringNumber;
	}
	
	public Deque<String> getPostfixedForm(String mathExpression) {
		for (i = 0; i < mathExpression.length(); i++) {
			//iterate and read every digit or operator
			o1 = mathExpression.charAt(i);
			//o1 is a digit
			if (Character.isDigit(o1)) {
				//check if next character is also a digit
				String wholeNumber = checkDigits(mathExpression);
				//digits go directly to the post-fixed form
				postfixedForm.add(wholeNumber);
			} else {
				//o1 is an operator
				if (o1.equals('(')) {
					oprStack.push(o1);
				} else if (o1.equals(')')) {
					o2 = oprStack.peek();
					
					while (o2 != null && !o2.equals('(')) {
						o2 = oprStack.pop();
						postfixedForm.add(Character.toString(o2));
						o2 = oprStack.peek();
					}
					if (oprStack.isEmpty()) {
						System.out.println("Error. Mismatched parentheses.");
						return null;
					}
					if (o2.equals('(')) {
						oprStack.pop();
					}
				} else {
					o2 = oprStack.peek();
					if (o2 != null && !o2.equals('(')) {
						int iO1 = operators.indexOf(o1);
						int iO2 = operators.indexOf(o2);
							
						int precedenceO1 = precedence.get(iO1);
						int precedenceO2 = precedence.get(iO2);
							
						String associativityO2 = associativity.get(iO2);
							
						while (!oprStack.isEmpty() && !o2.equals('(') && (precedenceO1 < precedenceO2 ||
								precedenceO1 == precedenceO2 && associativityO2.equals("left"))) {
							o2 = oprStack.pop();
							postfixedForm.add(Character.toString(o2));
							// function to check o2
							o2 = oprStack.peek();
							if (o2 != null) {
								iO2 = operators.indexOf(o2);
								precedenceO2 = precedence.get(iO2);
								associativityO2 = associativity.get(iO2);
							}
						}
					}
					oprStack.push(o1);
				}
			}
			//System.out.println("stack: " + oprtStack);
			//System.out.println("pf:    " + postfixedForm);
		}
		
		if (!oprStack.isEmpty()) {
			Iterator<Character> listIt = oprStack.iterator();
			while (listIt.hasNext()) {
				postfixedForm.add(Character.toString(listIt.next()));
			}
		}
		return postfixedForm;
	}
	
	public Integer evaluatePostfixedForm(Deque<String> postfixedForm) {
		int result = 0;
		while (postfixedForm.peek() != null) {
			String strO = postfixedForm.poll();
			//System.out.println(strO);
			char ch = strO.charAt(0);
			if (Character.isDigit(ch)) {
				int o = Integer.valueOf(strO);
				evalStack.push(o);
				//System.out.println(o);
			} else {
				Integer o3 = evalStack.pop();
				Integer o4 = evalStack.pop();
				//System.out.println(o3 + " " + o4);
				if (o3 == null || o4 == null) {
					System.out.println("Error, incorrect post-fixed form");
					return null;
				}
				
				switch(strO) {
				case "+":
					result = o4 + o3;
					break;
				case "-":
					result = o4 - o3;
					break;
				case "*":
					result = o4 * o3;
					break;
				case "/":
					result = o4 / o3;
					break;
				case "^":
					result = (int) Math.pow(o4, o3);
					break;
				default:
					System.out.println("Error, undefined operator");
					return null;
				}
				//System.out.println("res: " + result);
				evalStack.push(result);
			}
			//System.out.println("eval: " + evalStack);
		}
		
		return result;
	}
	
}
