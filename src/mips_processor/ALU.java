package mips_processor;

public class ALU 
{   
    private int Operand1;
    private int Operand2;
    private int Result;
    private int ZeroFlag;
    private int ALUControlSignal;
    
    public ALU()
    {
        Operand1 = 0;
        Operand2 = 0;
        Result = 0;
        ZeroFlag = 0;
        ALUControlSignal=0;
    }
    
    public int getResult(){return Result;}
    public int getZeroFlag(){return ZeroFlag;}
    public void setALUControlSignal(int Signal){ALUControlSignal = Signal;}
    
    public int Operate (int r1,int r2,int ALUControlSignal,int ShiftAmount)
    {
        this.ALUControlSignal=ALUControlSignal;
        switch(ALUControlSignal)
        {
            case 1:
                return 
                    subtract(r1,r2);
                
                
            case 2:
                return
                    add(r1,r2);
               
            
            case 3:
                return
                    and(r1,r2);
                
                
            case 4:
                return
                    or(r1,r2);
                
             
            case 5:
                return
                    nor(r1,r2);
                
            
            case 6:
                return
                    LessThan(r1,r2);
                
            
            case 7:
                return
                    ShiftLeft(r1,r2,ShiftAmount);
                     
        }
        return 0;
    }
    
    public int add(int r1 , int r2)
    {
        Operand1 = r1;
        Operand2 = r2;
        Result = r1+r2;
        return Result;
    }
    
    public int subtract(int r1 , int r2)
    {
        Operand1 = r1;
        Operand2 = r2;
        Result = r1-r2;
        if(Result == 0)
            ZeroFlag = 1;
        else
            ZeroFlag = 0;
        return Result;
    }
    
    public int and(int r1 , int r2)
    {
        Operand1 = r1;
        Operand2 = r2;
        Result = r1 & r2;
        return Result;
    }
    
    public int or(int r1 , int r2)
    {
        Operand1 = r1;
        Operand2 = r2;
        Result = r1 | r2;
        return Result;
    }
  
    public int nor(int r1 , int r2)
    {
        Operand1 = r1;
        Operand2 = r2;
        int temp = or(r1,r2);
        Result = or(temp,temp);
        return Result;
    }
    
    public int LessThan(int r1 , int r2)
    {
        Operand1 = r1;
        Operand2 = r2;
        if(r1 < r2)
        {
            Result = 1;
            return Result;
        }
        
        else
        {
            Result = 0;
            return Result;
        }
    }
    
    public int ShiftLeft(int r1 , int r2 , int ShiftAmount)
    {
        Operand1 = r1;
        Operand2 = r2;
        Result = r2*2*ShiftAmount;
        return Result;
    }
    
    public int getOperand1(){return Operand1;}
    public int getOperand2(){return Operand2;}
}
