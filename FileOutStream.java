import java.io.FileOutputStream;
import java.util.Scanner;
class FileOutStream
{
public static void main(String[] args)
{
try
{
FileOutputStream fout=new FileOutputStream("D:\\ MyFile.txt");
Scanner sc=new Scanner(System.in);
int s_rollno=sc.nextInt();
String s_name=sc.next();
int s_mob=sc.nextInt();
fout.write(s_rollno);
fout.write(s_mob);
byte[] bs_name=s_name.getBytes();
fout.write(bs_name);

fout.close();
System.out.println("Success...");
}
catch(Exception e)
{
System.out.println(e);
}
}
}