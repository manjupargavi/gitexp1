import java.io.FileInputStream;
class FileInStream
{
public static void main(String ar[])
{
try

{
FileInputStream fin=new FileInputStream("D:\\MyFile_1.txt");
int i;
//i=fin.read(); //to read single byte
//System.out.print((char)i);
while((i=fin.read())!=-1) // to read all bytes in file
{
System.out.print((char)i);
}
}
catch(Exception e)
{
System.out.print(e);
}
}
}