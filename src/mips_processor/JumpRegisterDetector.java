package mips_processor;

public class JumpRegisterDetector
{
    private int JumpRegisterFlag;
    
    public JumpRegisterDetector()
    {
        JumpRegisterFlag = 0;
    }
    
    public void setJumpRegisterFlag(int FnCode)
    {
        if(FnCode == InstructionSet.jr)
            JumpRegisterFlag = 1;
        
        else
            JumpRegisterFlag = 0;
    }
    
    public int getJumpRegisterFlag(){return JumpRegisterFlag;}
}
