import java.util.*;
class Rail{
 int height;
 String Encryption(String text,int height)throws Exception
 {
  int r=height,len=text.length();
  int c=len/height;
  char mat[][]=new char[r][c];
  int k=0;
  
  String cipher="";
  
  for(int i=0;i< c;i++)
  {
   for(int j=0;j< r;j++)
   {
    if(k!=len)
     mat[j][i]=text.charAt(k++);
    else
     mat[j][i]='X';
   }
  }
  for(int i=0;i< r;i++)
  {
   for(int j=0;j< c;j++)
   {
    cipher+=mat[i][j];
   }
  }
  return cipher;
 }
 
 
 String Decryption(String cipher,int height)throws Exception
 {
  int r=height,len=cipher.length();
  int c=len/height;
  char mat[][]=new char[r][c];
  int k=0;
  
  String text="";
  
  
  for(int i=0;i< r;i++)
  {
   for(int j=0;j< c;j++)
   {
    mat[i][j]=cipher.charAt(k++);
   }
  }
  for(int i=0;i< c;i++)
  {
   for(int j=0;j< r;j++)
   {
    text+=mat[j][i];
   }
  }
  
  return text;
 }


 public static void main(String args[])throws Exception
 {
  Rail a=new Rail();
                Scanner in=new Scanner(System.in);
                int height;
  
                String text,cipher,d;
                
               
                System.out.println("Enter plain text:");
                text=in.nextLine();
                
                
                System.out.println("Enter height for Encryption:");
                height=in.nextInt();
                
  cipher=a.Encryption(text,height);
  System.out.println("Encrypted text is:\n"+cipher);
                
                d=a.Decryption(cipher, height);
                
  System.out.println("Decrypted text is:\n"+d);
  
 }
}
