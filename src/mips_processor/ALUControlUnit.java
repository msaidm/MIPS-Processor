package mips_processor;

public class ALUControlUnit 
{
    int ALUControlSignal;
    int ALUOp;
    int FnCode;
    
    public  ALUControlUnit()
    {
        ALUControlSignal = 0;
        ALUOp = 0;
        FnCode = 0;
    }
    
    public int getFnCode(){return FnCode;}
    
    public int getALUControlSignal(int fnCode , int ALUOp)
    {  
        this.FnCode = fnCode;
        this.ALUOp = ALUOp;
        
        if(ALUOp == 0) //lw-sw
        {
            ALUControlSignal = 2; // ALU add = 2
        }
        
        if(ALUOp == 1) //beq 
        {
            ALUControlSignal = 1; // ALU sub = 1
        }

        if(ALUOp == 3) //addi
        {
            ALUControlSignal = 2; // ALU add = 2
        }

        if(ALUOp == 4) //andi
        {
              ALUControlSignal = 3; // ALU and = 3
        }

        if(ALUOp == 5) //ori
        {
              ALUControlSignal = 4; // ALU or = 4
        }

        if(ALUOp == -1 ) //j-jal-jr
        {
              ALUControlSignal = 4; // ALU or = 4 
        }

        if(ALUOp == 2) //R-Type
        {
            if(fnCode == 32)
                ALUControlSignal =2;
            if(fnCode == 36)
                ALUControlSignal =3; 
            if(fnCode == 37)
                ALUControlSignal =4;
            if(fnCode == 39)
                ALUControlSignal =5; // ALU nor = 5
            if(fnCode == 42)
                ALUControlSignal =6; // ALU slt = 6
            if(fnCode == 0)
                ALUControlSignal =7; //ALU sll = 7    
        }
        
        return ALUControlSignal;
    }
}
