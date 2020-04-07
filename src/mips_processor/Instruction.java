package mips_processor;
import java.util.Arrays;

public class Instruction
{
    private int bits[] = new int[32];
    private String Label;
    private String JumpLabel;
    
    public Instruction()
    {
        Arrays.fill(bits, 0);
        Label = "";
        JumpLabel = "";
    }
    
    public void printInstruction()
    {
        for(int i=0 ; i < 32 ; i++)
            System.out.print(bits[i]);
        System.out.println();
    }
    
    public int[] getContent(){return bits;}
    
    public int getOPCode(){return InstructionSet.BinaryToDecimal(bits,0,6);}
    public int getSource(){return InstructionSet.BinaryToDecimal(bits,6,11);}
    public int getTarget(){return InstructionSet.BinaryToDecimal(bits,11,16);}
    public int getDestination(){return InstructionSet.BinaryToDecimal(bits,16,21);}
    public int getShiftAmount(){return InstructionSet.BinaryToDecimal(bits,21,26);}
    public int getFnCode(){return InstructionSet.BinaryToDecimal(bits,26,32);}
    public int getOffset(){return InstructionSet.BinaryToDecimal(bits,16,32);}
    public int getAddress(){return InstructionSet.BinaryToDecimal(bits,6,32);}
    public String getLabel (){return Label;}
    public String getJumpLabel(){return JumpLabel;}          
    
    public void setOPCode(int x){InstructionSet.DecimalToBinary(bits,x,0,6);}
    public void setSource(int x){InstructionSet.DecimalToBinary(bits,x,6,11);}
    public void setTarget(int x){InstructionSet.DecimalToBinary(bits,x,11,16);}
    public void setDestination(int x){InstructionSet.DecimalToBinary(bits,x,16,21);}
    public void setShiftAmount(int x){InstructionSet.DecimalToBinary(bits,x,21,26);}
    public void setFnCode(int x){InstructionSet.DecimalToBinary(bits,x,26,32);}
    public void setOffset(int x){InstructionSet.DecimalToBinary(bits,x,16,32);}
    public void setAddress(int x){InstructionSet.DecimalToBinary(bits,x,6,32);}
    public void setLabel (String L){Label =L;}   
    public void setJumpLabel (String L){ JumpLabel = L;}
}