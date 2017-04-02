/*
计算器系统，能够实现表达式求值，其具体实现思想是，将输入的中缀表达式转化为后缀表达式，然后对后缀表达式求值
*/
import java.util.Scanner;

public class Calculate {

	public static boolean isNumber(char a) {                  //判断该字符是否为数字的函数
		if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8'
				|| a == '9'||a=='.')
			return true;
		else
			return false;
	}

	public static boolean isOpenParentheses(char a) {          //判断是否为开括号
		if (a == '(')
			return true;
		else
			return false;
	}

	public static boolean isCloseParentheses(char a) {         //判断是否为闭括号
		if (a == ')')
			return true;
		else
			return false;
	}

	public static boolean IsOperator(char a) {                  //判断是否为运算符
		if (a == '+' || a == '-' || a == '*' || a == '/' || a == '^' || a == '%' || a == '^')
			return true;
		else
			return false;
	}

	public static int Priority(char a) {                       //分辨出该运算符的优先级并返回不同的值
		if (a == '^')
			return 3;
		else if (a == '*' || a == '/' || a == '%')
			return 2;
		else if (a == '+' || a == '-')
			return 1;
		else
			return 0;
	}

	public static String ConvertTopostfix(String expression) throws Exception {    //将中缀表达式转化为后缀表达式
		LinkStack stack = new LinkStack();
		String postfix = new String();
		try {
			for (int i = 0; i < expression.length() && expression != null; i++) {
			char c = expression.charAt(i);                                         //将字符串分离出每个字符
			if (' ' != c) {
				if (isOpenParentheses(c)) {                                        //当该字符为开括号时，压栈
					stack.push(c);
				} else if (isCloseParentheses(c)) {                                //当该字符为闭括号时，分别取出栈顶元素，并将其放到输出序列
					char ac = (Character) stack.pop();
					while (!isOpenParentheses(ac)) {
						postfix = postfix.concat(String.valueOf(ac));
						postfix = postfix.concat(" ");
						ac = (Character) stack.pop();
					}
				} else if (IsOperator(c)) {           //当该字符为运算符时，当栈非空&&栈顶不是开括号&&栈顶运算符优先级大于等于该字符时，
					if (!stack.IsEmpty()) {           //分别将栈顶元素出栈并放到输出序列中，然后将该运算符压栈
						while (!stack.IsEmpty() && !isOpenParentheses((Character) stack.peek())
								&& Priority((Character) stack.peek()) >= Priority(c)) {
							postfix = postfix.concat(String.valueOf((Character) stack.pop()));
							postfix = postfix.concat(" ");
						}
						stack.push(c);
					} else
						stack.push(c);
				} else {                              //当该字符为数字时，直接将其放到输出序列中，并用空格将每个数字分隔开（多位数之间）
					postfix = postfix.concat(String.valueOf(c));
					if (i + 1 != expression.length()) { 
						if (!isNumber(expression.charAt(i + 1))) {  //当这个数的后一个数不是数字时，即这两位不在一个数字中，用空格将她们区分开
							postfix = postfix.concat(" ");
						}
					}
					else
						postfix = postfix.concat(" ");
				}
			}
		}
		while (!stack.IsEmpty()) {                   //当字符串遍历完毕后，栈非空，分别将栈中元素放到输出序列中
			postfix = postfix.concat(String.valueOf(stack.pop()));
			postfix = postfix.concat(" ");
		}
		} catch (Exception e) {
			return "错误!输入的格式不正确	";
		}
		
		return postfix;
	}

	/**
	 * @param postfix
	 * @return
	 */
	/**
	 * @param postfix
	 * @return
	 */
	public static String numberCalculate(String postfix) {   //对后缀表达式进行求值
		if(postfix=="错误!输入的格式不正确")
			return postfix;
		LinkStack stack = new LinkStack();
		try {
			for (int i = 0; i < postfix.length() && postfix != null; i++) {
			char c = postfix.charAt(i);                      //将字符串分离出每个字符
			if (IsOperator(c)) {                             //当该字符为运算符时，分别弹出栈顶两个元素进行运算，并将得到的结果进栈
				double num1 = Double.valueOf(stack.pop().toString());
				double num2 = Double.valueOf(stack.pop().toString());
				double num = 0;
				if ('+' == c)
					num = num1 + num2;
				else if ('-' == c)
					num = num2 - num1;
				else if ('*' == c)
					num = num1 * num2;
				else if ('/' == c)
					num = num2 / num1;
				else if ('^' == c)
					num = Math.pow(num2, num1);
				else if ('%' == c)
					num = num2 % num1;
				stack.push(num);
			} else if(c!=' ') {               //将字符中的数字进栈，并将其中不同位数的数字整合到一起
				String a=new String();
				a=a.concat(String.valueOf(c));
				int b=i+1;
				char s=postfix.charAt(b);
				while(s!=' '){
					a=a.concat(String.valueOf(s));
					s=postfix.charAt(++b);
					i++;
				}
				stack.push(a);
			}
		}
		} catch (Exception e) {
			// TODO: handle exception
			return "错误!输入的格式不正确";
		}
		
		return  stack.pop().toString();
	}

	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(System.in);
		String A=new String();
		System.out.println("请输入你的表达式");
		A=in.nextLine();
		A=ConvertTopostfix(A);
		System.out.println(A);
		String B=numberCalculate(A);
		System.out.println(B);
		System.out.println(ConvertTopostfix("23+(34*45)/(5+6+7)"));
		System.out.println(ConvertTopostfix("3.5*2.1"));
		System.out.println(numberCalculate(ConvertTopostfix("(2^6)")));
	}

}
