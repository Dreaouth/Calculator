/*
������ϵͳ���ܹ�ʵ�ֱ��ʽ��ֵ�������ʵ��˼���ǣ����������׺���ʽת��Ϊ��׺���ʽ��Ȼ��Ժ�׺���ʽ��ֵ
*/
import java.util.Scanner;

public class Calculate {

	public static boolean isNumber(char a) {                  //�жϸ��ַ��Ƿ�Ϊ���ֵĺ���
		if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8'
				|| a == '9'||a=='.')
			return true;
		else
			return false;
	}

	public static boolean isOpenParentheses(char a) {          //�ж��Ƿ�Ϊ������
		if (a == '(')
			return true;
		else
			return false;
	}

	public static boolean isCloseParentheses(char a) {         //�ж��Ƿ�Ϊ������
		if (a == ')')
			return true;
		else
			return false;
	}

	public static boolean IsOperator(char a) {                  //�ж��Ƿ�Ϊ�����
		if (a == '+' || a == '-' || a == '*' || a == '/' || a == '^' || a == '%' || a == '^')
			return true;
		else
			return false;
	}

	public static int Priority(char a) {                       //�ֱ��������������ȼ������ز�ͬ��ֵ
		if (a == '^')
			return 3;
		else if (a == '*' || a == '/' || a == '%')
			return 2;
		else if (a == '+' || a == '-')
			return 1;
		else
			return 0;
	}

	public static String ConvertTopostfix(String expression) throws Exception {    //����׺���ʽת��Ϊ��׺���ʽ
		LinkStack stack = new LinkStack();
		String postfix = new String();
		try {
			for (int i = 0; i < expression.length() && expression != null; i++) {
			char c = expression.charAt(i);                                         //���ַ��������ÿ���ַ�
			if (' ' != c) {
				if (isOpenParentheses(c)) {                                        //�����ַ�Ϊ������ʱ��ѹջ
					stack.push(c);
				} else if (isCloseParentheses(c)) {                                //�����ַ�Ϊ������ʱ���ֱ�ȡ��ջ��Ԫ�أ�������ŵ��������
					char ac = (Character) stack.pop();
					while (!isOpenParentheses(ac)) {
						postfix = postfix.concat(String.valueOf(ac));
						postfix = postfix.concat(" ");
						ac = (Character) stack.pop();
					}
				} else if (IsOperator(c)) {           //�����ַ�Ϊ�����ʱ����ջ�ǿ�&&ջ�����ǿ�����&&ջ����������ȼ����ڵ��ڸ��ַ�ʱ��
					if (!stack.IsEmpty()) {           //�ֱ�ջ��Ԫ�س�ջ���ŵ���������У�Ȼ�󽫸������ѹջ
						while (!stack.IsEmpty() && !isOpenParentheses((Character) stack.peek())
								&& Priority((Character) stack.peek()) >= Priority(c)) {
							postfix = postfix.concat(String.valueOf((Character) stack.pop()));
							postfix = postfix.concat(" ");
						}
						stack.push(c);
					} else
						stack.push(c);
				} else {                              //�����ַ�Ϊ����ʱ��ֱ�ӽ���ŵ���������У����ÿո�ÿ�����ַָ�������λ��֮�䣩
					postfix = postfix.concat(String.valueOf(c));
					if (i + 1 != expression.length()) { 
						if (!isNumber(expression.charAt(i + 1))) {  //��������ĺ�һ������������ʱ��������λ����һ�������У��ÿո��������ֿ�
							postfix = postfix.concat(" ");
						}
					}
					else
						postfix = postfix.concat(" ");
				}
			}
		}
		while (!stack.IsEmpty()) {                   //���ַ���������Ϻ�ջ�ǿգ��ֱ�ջ��Ԫ�طŵ����������
			postfix = postfix.concat(String.valueOf(stack.pop()));
			postfix = postfix.concat(" ");
		}
		} catch (Exception e) {
			return "����!����ĸ�ʽ����ȷ	";
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
	public static String numberCalculate(String postfix) {   //�Ժ�׺���ʽ������ֵ
		if(postfix=="����!����ĸ�ʽ����ȷ")
			return postfix;
		LinkStack stack = new LinkStack();
		try {
			for (int i = 0; i < postfix.length() && postfix != null; i++) {
			char c = postfix.charAt(i);                      //���ַ��������ÿ���ַ�
			if (IsOperator(c)) {                             //�����ַ�Ϊ�����ʱ���ֱ𵯳�ջ������Ԫ�ؽ������㣬�����õ��Ľ����ջ
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
			} else if(c!=' ') {               //���ַ��е����ֽ�ջ���������в�ͬλ�����������ϵ�һ��
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
			return "����!����ĸ�ʽ����ȷ";
		}
		
		return  stack.pop().toString();
	}

	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(System.in);
		String A=new String();
		System.out.println("��������ı��ʽ");
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
