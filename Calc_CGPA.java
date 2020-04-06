import java.lang.*;
import java.io.*;
import java.util.Scanner;

interface Exam
{
	void cgpa_cal();
}
class Student
{
	String name, matric;
	int totalSubject, cHour[],totalChour;
	char grade[];
	Student(String name,String matric,int totalSubject,int cHour[],char grade[],int totalChour)
	{
		this.name = name;
		this.matric = matric;
		this.totalSubject = totalSubject;
		this.cHour = cHour;
		this.grade = grade;
		this.totalChour = totalChour;

	}
	void display()
	{
		System.out.println (" ");
		System.out.println ("================================================================");
		System.out.println ("");
		System.out.println ("Name of Student: "+name);
		System.out.println ("Matric No. of Student: "+matric);
		System.out.println ("Total Subject taken: "+totalSubject);
		System.out.println ("Total Credit Hour taken: "+totalChour);

		for (int i=0;i<totalSubject;i++)
		{
			System.out.println ("Credit Hour for Subject "+(i+1)+ " :"+cHour[i] );
			System.out.println ("Grade for Subject: "+(i+1)+ " :"+grade[i]);
		}

	}
}
class Result extends Student implements Exam
{
	Result(String name, String matric, int totalSubject, int cHour[], char grade[], int totalChour)
	{
		super(name,matric,totalSubject,cHour,grade,totalChour);
	}
	public void cgpa_cal()
	{
		double sum=0;
		double cgpa;
		double pointer[] = new double[totalSubject];

		for(int i=0;i<grade.length;i++)
		{
			if (grade[i] == 'A' || grade[i] == 'a')
				pointer[i] = 4.0;
			else if (grade[i] == 'B' || grade[i] == 'b')
				pointer[i] = 3.0;
			else if (grade[i] == 'C' || grade[i] == 'c')
				pointer[i] = 2.0;
			else if (grade[i] == 'D' || grade[i] == 'd')
				pointer[i] = 1.0;
			else if (grade[i] == 'E' || grade[i] == 'e')
				pointer[i] = 0;
		}


		  double grade[]=new double[pointer.length];
		  for(int i=0;i<pointer.length;i++)
		  {
			grade[i]=(pointer[i] * cHour[i]) ;
		  }
		  for(int i=0;i<pointer.length;i++)
		  {
		   sum+=grade[i];
		  }

		  cgpa=sum/totalChour;

		  System.out.println ("CGPA: "+cgpa);
	}

	void display()
	{
		super.display();
	}
}
class Calc_CGPA
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);

		String Name;
		String MatricNo;

		System.out.println("Enter Your Name:");
		Name = sc.next();

		System.out.println("Enter your Matric No.");
		MatricNo = sc.next();

		System.out.println("Enter number of subjects");
		int n=sc.nextInt();

		char Grade[] = new char[n];
		double[] pointer = new double[n];
		double[] marks=new double[n];
		int[] cHour=new int[n];
		int totalChour = 0;

		System.out.println("Enter Credit hour");
		for(int i=0;i<n;i++)
		{
		   cHour[i]=sc.nextInt();
		   totalChour += cHour[i];
		}

		System.out.println("Enter Grades");
		for(int i=0;i<n;i++)
		{
		   Grade[i]=sc.next().charAt(0);
		   //assert marks[i] >= 0 : "Value cannot be negative";
		}


		Result R = new Result(Name,MatricNo,n,cHour,Grade,totalChour);
		R.display();
		R.cgpa_cal();


	}
}