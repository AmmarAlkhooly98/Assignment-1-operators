import java.util.Arrays;
import java.util.Scanner;

public class Part2 {
	static Scanner input = new Scanner(System.in);
	static String data= "";
	static String pattern = "(?<=[\\(\\)\\+\\%\\$\\_\\#\\@\\&\\;\\!\\{\\}\\[\\]\\<\\>\\?\\.\\\"\\'\\-*\\/\\^A-Za-z])|(?=[\\(\\)\\+\\%\\$\\_\\#\\@\\&\\;\\!\\{\\}\\[\\]\\<\\>\\?\\.\\\"\\'\\-*\\/\\^A-Za-z])";
	static String[] dataNums = data.replace(" ","").split(pattern);
	static int chances = 3;
	static boolean isFirstTime = true;
	static boolean cont = true;
	static boolean validNum = true;
	static boolean twoOperations = false;
	
	static void askForInput(boolean isFirstTime) {
		if(isFirstTime) {
			System.out.println("please enter a operator action");
			data = input.nextLine();
			dataNums = data.replace(" ","").split(pattern);
//			System.out.println(Arrays.toString(dataNums));
		}
		else {
			if(chances <= 1) { System.out.println("Game Over!! Better Luck Next Time..."); cont = false; validNum = false; return;}
			else {
				chances--;
				System.out.println("\nNon valid arithmetic operations or numbers greater than 1000 are not allowed! You have " + chances + " tries left." );
				data = input.nextLine();
				dataNums = data.replace(" ","").split(pattern);
//				System.out.println(Arrays.toString(dataNums));
			}
		}
	}
	
	static void operatorCheck(String operator, int num1, int num2, int num3, String operator2) {
		if(operator.equals("+")) AddSubtractP2.add1(num1, num2, num3, twoOperations, operator, operator2);
		else if(operator.equals("-")) AddSubtractP2.subtract1(num1, num2, num3, twoOperations, operator, operator2);
		else if(operator.equals("*")) MultiplyDivideP2.multiply1(num1, num2, num3, twoOperations, operator, operator2);
		else if(operator.equals("/")) MultiplyDivideP2.divide1(num1, num2, num3, twoOperations, operator, operator2);
	}
	
	public static void main(String[] args) {
		askForInput(isFirstTime);
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		String operator = null;
		String operator2 = null;
		while(true && cont) {
			if(dataNums.length == 8) {
				twoOperations = true;
				num1 = Integer.parseInt(dataNums[0] + dataNums[1]);
				num2 = Integer.parseInt(dataNums[3] + dataNums[4]);
				num3 = Integer.parseInt(dataNums[dataNums.length - 2] + dataNums[dataNums.length - 1]);
				operator = dataNums[2];
				operator2 = dataNums[dataNums.length - 3];
				if(num1 > 1000 || num2 > 1000 || num3 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
				else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) cont =false;
				else {isFirstTime = false; askForInput(isFirstTime);}
			}
			else if(dataNums.length == 7) {
				twoOperations = true;
				num1 = dataNums[0].equals("-") ? Integer.parseInt(dataNums[0] + dataNums[1]) : Integer.parseInt(dataNums[0]);
				num2 = dataNums[0].equals("-") && dataNums[dataNums.length - 2].equals("-") && (dataNums[dataNums.length - 3].equals("+") || dataNums[dataNums.length - 3].equals("-") || dataNums[dataNums.length - 3].equals("*") || dataNums[dataNums.length - 3].equals("/")) ? Integer.parseInt(dataNums[3]) : Integer.parseInt(dataNums[3] + dataNums[4]);
				num3 = dataNums[0].equals("-") && dataNums[3].equals("-") ? Integer.parseInt(dataNums[dataNums.length - 1]) : Integer.parseInt(dataNums[dataNums.length - 2] + dataNums[dataNums.length - 1]);
				operator = dataNums[0].equals("-") ? dataNums[2] : dataNums[1];
				operator2 = dataNums[0].equals("-") && dataNums[3].equals("-") ? dataNums[dataNums.length - 2] : dataNums[dataNums.length - 3];
				if(num1 > 1000 || num2 > 1000 || num3 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
				else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) cont =false;
				else {isFirstTime = false; askForInput(isFirstTime);}
			}
			else if(dataNums.length == 6) {
				twoOperations = true;
				num1 = dataNums[0].equals("-") ? Integer.parseInt(dataNums[0] + dataNums[1]) : Integer.parseInt(dataNums[0]);
				num2 = dataNums[0].equals("-") ? Integer.parseInt(dataNums[3]) : dataNums[dataNums.length - 2].equals("-") && !dataNums[0].equals("-") && !dataNums[2].equals("-") ? Integer.parseInt(dataNums[2]) : Integer.parseInt(dataNums[2] + dataNums[3]);
				num3 = dataNums[0].equals("-") ? Integer.parseInt(dataNums[dataNums.length - 1]) : dataNums[dataNums.length - 2].equals("-") && !dataNums[0].equals("-") && !dataNums[2].equals("-") ? Integer.parseInt(dataNums[dataNums.length - 2] + dataNums[dataNums.length - 1]) : Integer.parseInt(dataNums[dataNums.length - 1]);
				operator = dataNums[0].equals("-") ? dataNums[2] : dataNums[1];
				operator2 = !dataNums[0].equals("-") && dataNums[dataNums.length - 2].equals("-") && (dataNums[dataNums.length - 3].equals("+") || dataNums[dataNums.length - 3].equals("-") || dataNums[dataNums.length - 3].equals("*") || dataNums[dataNums.length - 3].equals("/")) ? dataNums[dataNums.length - 3] : dataNums[dataNums.length - 2];
				if(num1 > 1000 || num2 > 1000 || num3 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
				else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) cont =false;
				else {isFirstTime = false; askForInput(isFirstTime);}	
			}
			else if(dataNums.length == 5 && (!dataNums[0].equals("+") || dataNums[dataNums.length - 2].equals("-"))) {
				if(dataNums[2].equals("+") || dataNums[2].equals("-") || dataNums[2].equals("*") || dataNums[2].equals("/") ) {
					num1 = Integer.parseInt(dataNums[0] + dataNums[1]);
					num2 = Integer.parseInt(dataNums[dataNums.length - 2] + dataNums[dataNums.length - 1]);
					operator = dataNums[2];
					if(num1 > 1000 || num2 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
					else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) cont =false;
					else {isFirstTime = false; askForInput(isFirstTime);}					
				}
				else {
					twoOperations = true;
					num1 = Integer.parseInt(dataNums[0]);
					num2 = Integer.parseInt(dataNums[2]);
					num3 = Integer.parseInt(dataNums[dataNums.length - 1]);
					operator = dataNums[1];
					operator2 = dataNums[3];
					if(num1 > 1000 || num2 > 1000 || num3 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
					else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) cont =false;
					else {isFirstTime = false; askForInput(isFirstTime);}	
				}
			}
			else if(dataNums.length == 4 && (!dataNums[0].equals("+"))) {
				if(dataNums[dataNums.length - 2].equals("-")) {
					operator = dataNums[0].equals("-") ? dataNums[2]: dataNums[1];
					num1 = dataNums[0].equals("-") ? Integer.parseInt(dataNums[0] + dataNums[1]) : Integer.parseInt(dataNums[0]);
					num2 = dataNums[0].equals("-") ? Integer.parseInt(dataNums[dataNums.length - 1]) : Integer.parseInt(dataNums[dataNums.length - 2] + dataNums[dataNums.length - 1]);
					if(num1 > 1000 || num2 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
					else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) cont =false;
					else {isFirstTime = false; askForInput(isFirstTime);}
				}
				else {isFirstTime = false; askForInput(isFirstTime);}
			}
			else if(dataNums.length == 3) {
				operator = dataNums[1];
				num1 = Integer.parseInt(dataNums[0]);
				num2 = Integer.parseInt(dataNums[2]);
				if(num1 > 1000 || num2 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
				else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) cont =false;
				else {isFirstTime = false; askForInput(isFirstTime);}
			}
			else {isFirstTime = false; askForInput(isFirstTime);}
		}
		
		if(validNum) {
			if(dataNums.length == 8) operatorCheck(operator,num1,num2,num3,operator2);
			else if(dataNums.length == 7) operatorCheck(operator,num1,num2,num3,operator2);
			else if(dataNums.length == 6) operatorCheck(operator,num1,num2,num3,operator2);
			else if(dataNums.length == 5) operatorCheck(operator,num1,num2,num3,operator2);
			else if(dataNums.length == 4) operatorCheck(operator,num1,num2,num3,operator2);
			else if(dataNums.length == 3) operatorCheck(operator,num1,num2,num3,operator2);
		}
	}
}

class AddSubtractP2 {
	static void operatorCheck(int a, int b, int c, String operator, String operator2) {
		if(operator2.equals("+") && operator.equals("+")) { System.out.println("adding..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a+b+c)); }
		else if(operator2.equals("+") && operator.equals("-")) { System.out.println("subtracting and adding..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a-b+c)); }
		else if(operator2.equals("-") && operator.equals("+")) { System.out.println("adding and subtracting..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a+b-c)); }
		else if(operator2.equals("-") && operator.equals("-")) { System.out.println("subtracting..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a-b-c)); }
		else if(operator2.equals("*") && operator.equals("+")) { System.out.println("adding and multiplying..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a+b*c)); }
		else if(operator2.equals("*") && operator.equals("-")) { System.out.println("subtracting and multiplying..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a-b*c)); }
		else if(operator2.equals("/") && operator.equals("+")) { System.out.println("adding and dividing..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a+b/c)); }
		else if(operator2.equals("/") && operator.equals("-")) { System.out.println("subtracting and dividing..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a-b/c)); }
	}
	
	static void add1(int a, int b, int c, boolean twoOperations, String operator, String operator2) {
		if(twoOperations)operatorCheck(a,b,c,operator,operator2);
		else {
			System.out.println("adding...");
			System.out.print("("+a+")" + "+" + "("+b+")" + " = " + (a+b));
		}
	}
	
	static void subtract1(int a, int b, int c, boolean twoOperations, String operator, String operator2) {
		if(twoOperations)operatorCheck(a,b,c,operator,operator2);
		else {
			System.out.println("subtracting...");
			System.out.print("("+a+")" + "-" + "("+b+")" + " = " + (a-b));
		}
	}
}

class MultiplyDivideP2 {
	static void operatorCheck(int a, int b, int c, String operator, String operator2) {
		if(operator2.equals("+") && operator.equals("*")) { System.out.println("adding..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a*b+c)); }
		else if(operator2.equals("+") && operator.equals("/")) { System.out.println("dividing and adding..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a/b+c)); }
		else if(operator2.equals("-") && operator.equals("*")) { System.out.println("multiplying and subtracting..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a*b-c)); }
		else if(operator2.equals("-") && operator.equals("/")) { System.out.println("dividing and subtracting..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a/b-c)); }
		else if(operator2.equals("*") && operator.equals("*")) { System.out.println("multiplying..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a*b*c)); }
		else if(operator2.equals("*") && operator.equals("/")) { System.out.println("dividing and multiplying..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a/b*c)); }
		else if(operator2.equals("/") && operator.equals("*")) { System.out.println("multiplying and dividing..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a*b/c)); }
		else if(operator2.equals("/") && operator.equals("/")) { System.out.println("dividing..."); System.out.print("("+a+")" + operator + "("+b+")" + operator2 + "("+c+")" + " = " + (a/b/c)); }
	}
	
	static void multiply1(int a, int b, int c, boolean twoOperations, String operator, String operator2) {
		if(twoOperations)operatorCheck(a,b,c,operator,operator2);
		else {
			System.out.println("multiplying...");
			double ans =a*b;
			System.out.print(a + " * " + b + " = " + ans);			
		}
	}
	
	static void divide1(int a, int b, int c, boolean twoOperations, String operator, String operator2) {
		if(twoOperations)operatorCheck(a,b,c,operator,operator2);
		else {
			System.out.println("dividing...");
			double ans =a/b;
			System.out.print(a + "/" + b + " = " + ans);
		}
	}
}