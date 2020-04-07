package mips_processor;

import java.util.Arrays;

public class InstructionSet 
{
  //R-Format(Function Code , OP Code = 0)
  final static int add = 32;
  final static int and = 36;
  final static int or = 37;
  final static int nor = 39;
  final static int slt = 42;
  final static int sll = 0;
  final static int jr = 8;
  
  //I-Format(OP Code)
  final static int addi = 8;
  final static int lw = 35;
  final static int sw = 43;
  final static int andi = 12;
  final static int ori = 13;
  final static int beq = 4;
  
  //J-Format(OP Code)
  final static int j = 2;
  final static int jal = 3;
  
  //Register numbers
  final static int $zero = 0; 
  final static int $at = 1; 
  final static int $v0 = 2;  
  final static int $v1 = 3; 
  final static int $a0 = 4; 
  final static int $a1 = 5; 
  final static int $a2 = 6; 
  final static int $a3 = 7; 
  final static int $t0 = 8; 
  final static int $t1 = 9; 
  final static int $t2 = 10; 
  final static int $t3 = 11; 
  final static int $t4 = 12; 
  final static int $t5 = 13; 
  final static int $t6 = 14; 
  final static int $t7 = 15;
  final static int $s0 = 16; 
  final static int $s1 = 17; 
  final static int $s2 = 18; 
  final static int $s3 = 19; 
  final static int $s4 = 20; 
  final static int $s5 = 21; 
  final static int $s6 = 22; 
  final static int $s7 = 23; 
  final static int $t8 = 24; 
  final static int $t9 = 25; 
  final static int $k0 = 26; 
  final static int $k1 = 27; 
  final static int $gp = 28;
  final static int $sp = 29; 
  final static int $fp = 30;
  final static int $ra = 31;
  final static String[] Registers = new String[]{"$zero","$at","$v0","$v1","$a0","$a1","$a2","$a3","$t0","$t1","$t2","$t3","$t4","$t5","$t6","$t7","$s0","$s1","$s2","$s3","$s4","$s5","$s6","$s7","$t8","$t9","$k0","$k1","$gp","$sp","$fp","$ra"};
  final static String[] Functions = new String[]{"and","or","nor","addi","andi","ori","add","sll","slt","lw","sw","beq","j","jr","jal"};
    

  private static String D2B(int x , int BitNum)
  {
      int i,e,k;
      String s1 = Integer.toBinaryString(x);
      char[] s2 = new char[BitNum];
      if(s1.length() == 32)
      {
          for(e=BitNum-1 , k=31 ; e >=0; e--,k--)
              s2[e] = s1.toCharArray()[k];
      }
      
      else
      {
          for(i=0 ; i < BitNum-s1.length() ;i++)
              s2[i] ='0';
          for(int j=0 ; i < BitNum ; i++ , j++)
              s2[i] = s1.toCharArray()[j];
      }
      return String.copyValueOf(s2);
  }
  
  private static int B2D_Offset(String x)
  {
      char[] temp = x.toCharArray();
      String s ="";
      if(temp[0] == '0')
          return Integer.parseInt(x,2);
      
      else
      {
          for(int i=0 ; i < temp.length ; i++)
              if(temp[i] == '0')
                  temp[i] = '1';
              else
                  temp[i] = '0';
          
          for(int i=0 ; i < temp.length ; i++)
              s+=Character.toString(temp[i]);
              
          int TwosComplement = Integer.parseInt(s,2)+1 ;
          return -1*TwosComplement;
      }
  }  
 
  private static void FillBits(int[] arr,String s, int start, int end)
  {
      for(int i = start, e = 0; i<end;i++,e++)
          arr[i] = Integer.parseInt(Character.toString(s.charAt(e)));
  }
  
  private static String GetBits(int[] arr , int start , int end)
  {
      String s ="";
      for(int i = start , e = 0 ; i < end ; i++,e++)
          s+=arr[i];

      return s;
  }
  
  public static void DecimalToBinary(int[] arr ,int x, int start , int end)
  {
      String s = D2B(x,end-start);
      FillBits(arr , s , start , end);
  }
  
  public static int BinaryToDecimal(int[] arr , int start , int end)
  {
      String s = GetBits(arr , start , end);
      if(end - start == 16)
          return B2D_Offset(s);
      
      else
          return Integer.parseInt(s,2);
  }
  
    public static boolean isInteger(String s)
    {
        try 
        { 
            Integer.parseInt(s); 
        } 
        catch(NumberFormatException e)
        { 
            return false; 
        }
        catch(NullPointerException e) 
        {
            return false;
        }
        return true;
    }  
}
