package mips_processor;

public class ControlUnit
{
    private int RegDst;
    private int Jump;
    private int Branch;
    private int JumpRegister;
    private int MemRead;
    private int MemtoReg;
    private int ALUOp;
    private int MemWrite;
    private int ALUSrc;
    private int RegWrite;
    private int OPCode;
    
    public ControlUnit()
    {
      RegDst = 0;
      Jump = 0;
      Branch = 0;
      JumpRegister = 0;
      MemRead = 0;
      MemtoReg = 0;
      ALUOp = 0;
      MemWrite = 0;
      ALUSrc = 0;
      RegWrite = 0;
    }
    private void SetSignals(int RegDst ,int Jump, int Branch, int JumpRegister , int MemRead ,int MemtoReg,int ALUOp,int MemWrite ,int ALUSrc , int RegWrite)
    {
      this.RegDst = RegDst;
      this.Jump = Jump;
      this.Branch = Branch;
      this.JumpRegister = JumpRegister;
      this.MemRead = MemRead;
      this.MemtoReg = MemtoReg;
      this.MemWrite = MemWrite;
      this.ALUOp =  ALUOp;
      this.ALUSrc = ALUSrc;
      this.RegWrite = RegWrite;
    }
    public void ControlSignal(int Signal , int JumpRegisterFlag)
    {
        this.OPCode = Signal;
        if(JumpRegisterFlag == 1 && Signal == 0)
            SetSignals(-1,0,0,1,0,-1,-1,0,-1,0);
            
        else
        {
            switch(Signal)
            {
                case 0:
                    SetSignals(1,0,0,0,0,0,2,0,0,1);
                    break;
                case 2:
                    SetSignals(-1,1,0,0,0,-1,-1,0,-1,0);
                    break;
                case 3:
                    SetSignals(2,1,0,0,0,2,-1,0,-1,1);
                    break;
                case 4:
                    SetSignals(-1,0,1,0,0,-1,1,0,0,0);
                    break;
                case 8:
                    SetSignals(0,0,0,0,0,0,3,0,1,1);
                    break;
                case 12:
                    SetSignals(0,0,0,0,0,0,4,0,1,1);
                    break;
                case 13:
                    SetSignals(0,0,0,0,0,0,5,0,1,1);
                    break;
                case 35:
                    SetSignals(0,0,0,0,1,1,0,0,1,1);
                    break;
                case 43:
                    SetSignals(-1,0,0,0,0,-1,0,1,1,0);
                    break;
            }
        }
    }
    
    public int getRegDstSignal(){return RegDst;}
    public int getJumpSignal(){return Jump;}
    public int getBranchSignal(){return Branch;}
    public int getMemReadSignal(){return MemRead;}
    public int getMemtoRegSignal(){return MemtoReg;}
    public int getMemWriteSignal(){return MemWrite;}
    public int getALUOpSignal(){return ALUOp;}
    public int getALUSrcSignal(){return ALUSrc;}
    public int getRegWriteSignal(){return RegWrite;}
    public int getJumpRegisterSignal(){return JumpRegister;}
}
