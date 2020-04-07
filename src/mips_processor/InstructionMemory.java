package mips_processor;
import java.util.*;

public class InstructionMemory
{
    ArrayList <Instruction> Imem = new ArrayList <Instruction>();
    int InitialAddress;
    
    public void setAddress(int InitialAddress)
    {
        for(int i=0; i<InitialAddress/4 ;i++)
            Imem.add(null);
        this.InitialAddress = InitialAddress;
  
    }
    
    public void addInstruction(Instruction I)
    {
        Imem.add(I);
    }
    
    public int getInitialAddress(){return InitialAddress;}
    
    public Instruction FetchInstruction(int PCAddress)
    {
        //this.InitialAddress = PCAddress;
        Instruction I;
        if(PCAddress/4 < Imem.size())
        {
           I =Imem.get(PCAddress/4);
           if(I.getOPCode() == InstructionSet.beq)
               for(int i=InitialAddress/4; i<Imem.size();i++)
               {
                   if(Imem.get(i).getLabel().trim().equals(I.getJumpLabel().trim()))
                   {
                       if(i>=(PCAddress+4)/4)
                           I.setOffset(i-(PCAddress+4)/4);
                       else if (i<=(PCAddress+4)/4)
                           I.setOffset(i-(PCAddress+4)/4); 
                   }
               }
           
           if(I.getOPCode() == InstructionSet.j || I.getOPCode() == InstructionSet.jal)
           {
               for(int i=InitialAddress/4 ; i < Imem.size() ; i++)
               {
                   if(Imem.get(i).getLabel().trim().equals(I.getJumpLabel().trim()))
                       I.setAddress(i);
               }
           }
          
           return I;
        }
        else
            return null;
    }
}