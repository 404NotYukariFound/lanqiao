import java.util.Scanner;
public class MethodTest
{
	public static void main(String[] args)
	{
		String userName;
		String passWord;
		Scanner in=new Scanner(System.in);
		for (; ; )
		{
			userName=in.nextLine();
			passWord=in.nextLine();
			if(check(userName,passWord))
			{
				welcome();
				break;
			}
			else
				again();
			}
		
	}

	public static void welcome()
	{
		System.out.println("��ӭ��");
	}

	public static void again()
	{
		System.out.println("�û������������");
	}


	public static boolean check(String userName,String passWord)
	{
		if(userName.equals("zs")&&passWord.equals("123456"))
			return true;
		else
			return false;
	}
}