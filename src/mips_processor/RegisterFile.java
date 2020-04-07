package mips_processor;
public class RegisterFile 
{
      static Register[] RegFile = new Register[32] ;
      
      private int RegWrite;
      private int ReadReg1; 
      private int ReadReg2; 
      private int WriteReg; 
      private int WriteData; 
      private int ReadData1; 
      private int ReadData2;
      
      public RegisterFile()
      {
        RegWrite = 0;
        ReadReg1 = 0; 
        ReadReg2 = 0; 
        WriteReg = 0; 
        WriteData = 0; 
        ReadData1 = 0; 
        ReadData2 = 0;
        
        for(int i =0; i<32; i++)
            RegFile[i]=new Register();
        RegFile[29].Write(56);
      } 
      
      public void setReadData1(int Data){ReadData1 = Data;} 
      public void setReadData2(int Data){ReadData2 = Data;}
      public void setReadRegister1(int Source){ReadReg1 = Source;}
      public void setReadRegister2(int Target){ReadReg2 = Target;}
      public void setWriteRegister(int Destination){WriteReg = Destination;}
      public void setRegWrite(int RegWrite){this.RegWrite = RegWrite;}
      
      public int getReadData1(){return ReadData1;} 
      public int getReadData2(){return ReadData2;}
      public int getWriteData(){return WriteData;}
      public int getReadRegister1(){return ReadReg1;}
      public int getReadRegister2(){return ReadReg2;}
      public int getWriteRegister(){return WriteReg;}
            
      public void WriteData(int Data)
      {
          WriteData = Data;
        if(RegWrite == 1 && WriteReg!=0)
        {
            RegFile[WriteReg].Write(Data);
        }       
      }
      
      public int ReadData(int RegNum){return RegFile[RegNum].Read();}
      
}
