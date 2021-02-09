import java.util.Scanner;

public class Part1 {
	
	static Scanner input = new Scanner(System.in);
	static String data= "";
	static String pattern = "(?<=[\\(\\)\\+\\%\\$\\_\\#\\@\\&\\;\\!\\{\\}\\[\\]\\<\\>\\?\\.\\\"\\'\\-*\\/\\^A-Za-z])|(?=[\\(\\)\\+\\%\\$\\_\\#\\@\\&\\;\\!\\{\\}\\[\\]\\<\\>\\?\\.\\\"\\'\\-*\\/\\^A-Za-z])";
	static String[] dataNums = data.replace(" ","").split(pattern);
	static int chances = 3;
	static boolean isFirstTime = true;
	static boolean cont = true;
	static boolean validNum = true;
	
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
	
	static void operatorCheck(String operator, int num1, int num2) {
		if(operator.equals("+")) AddSubtract.add1(num1, num2);
		else if(operator.equals("-")) AddSubtract.subtract1(num1, num2);
		else if(operator.equals("*")) MultiplyDivide.multiply1(num1, num2);
		else if(operator.equals("/")) MultiplyDivide.divide1(num1, num2);
	}
	
	public static void main(String[] args) {
		askForInput(isFirstTime);
		int num1 = 0;
		int num2 = 0;
		String operator = null;
		while(true && cont) {
			if(dataNums.length == 5 && (!dataNums[0].equals("+") && dataNums[dataNums.length - 2].equals("-"))) {
				num1 = Integer.parseInt(dataNums[0] + dataNums[1]);
				num2 = Integer.parseInt(dataNums[dataNums.length - 2] + dataNums[dataNums.length - 1]);
				operator = dataNums[2];
				if(num1 > 1000 || num2 > 1000) {isFirstTime = false; askForInput(isFirstTime);}
				else if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") ) cont =false;
				else {isFirstTime = false; askForInput(isFirstTime);}
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
				if(dataNums.length == 5) { operatorCheck(operator,num1,num2); }
				else if(dataNums.length == 4) { operatorCheck(operator,num1,num2); }
				else if(dataNums.length == 3) { operatorCheck(operator,num1,num2); }
		}
	}
}

class AddSubtract {
	static void add1(int a, int b) {
		System.out.println("adding...");
		System.out.print("("+a+")" + "+" + "("+b+")" + " = " + (a+b));
	}
	static void subtract1(int a, int b) {
		System.out.println("subtracting...");
		System.out.print("("+a+")" + "-" + "("+b+")" + " = " + (a-b));
	}
}

class MultiplyDivide {
	static void multiply1(int a, int b) {
		System.out.println("multiplying...");
		double ans =a*b;
		System.out.print(a + " * " + b + " = " + ans);
	}
	static void divide1(int a, int b) {
		System.out.println("dividing...");
		double ans =a/b;
		System.out.print(a + "/" + b + " = " + ans);
	}
}