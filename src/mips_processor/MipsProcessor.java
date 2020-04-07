package mips_processor;

public class MipsProcessor
{
    ALU ALU;
    ALUControlUnit ALUControlUnit;
    JumpRegisterDetector JRDetect;
    ControlUnit ControlUnit;
    DataMemory DataMem;
    InstructionMemory InstructionMem;
    RegisterFile RegFile;
    Register PC;
    int ClockCycles;
    
    public MipsProcessor()
    {
        ALU = new ALU();
        ALUControlUnit = new ALUControlUnit();
        JRDetect = new JumpRegisterDetector();
        ControlUnit = new ControlUnit();
        DataMem = new DataMemory();
        InstructionMem = new InstructionMemory();
        RegFile = new RegisterFile();
        PC = new Register();
        ClockCycles = 0;
    }
    
    private int Multiplexer(int r1 , int r2 , int r3 , int r4 ,  int Selection)
    {
        if(Selection==0)
            return r1;
        if(Selection ==1)
            return r2;
        if(Selection == 2)
            return r3;
        if(Selection ==-1)
            return r1;
        return 0;
    }
    
    public void Run()
    {
        PC.Write(InstructionMem.getInitialAddress());
        while(PC.Read()/4 < InstructionMem.Imem.size())
        {
            ExecuteInstruction(PC.Read());
            ClockCycles++;
        }
    }   
    
    public void ExecuteInstruction(int PCAddress)
    {
       Instruction I = InstructionMem.FetchInstruction(PCAddress);
       JRDetect.setJumpRegisterFlag(I.getFnCode());
       ControlUnit.ControlSignal(I.getOPCode() , JRDetect.getJumpRegisterFlag());
       RegFile.setRegWrite(ControlUnit.getRegWriteSignal());
       RegFile.setReadRegister1(I.getSource());
       RegFile.setReadRegister2(I.getTarget());
       int Mux_1 = Multiplexer(I.getTarget(),I.getDestination(),31,0,ControlUnit.getRegDstSignal());
       RegFile.setWriteRegister(Mux_1);
       RegFile.setReadData1(RegFile.ReadData(RegFile.getReadRegister1()));
       RegFile.setReadData2(RegFile.ReadData(RegFile.getReadRegister2()));
       int Mux_2 = Multiplexer(RegFile.getReadData2(),I.getOffset(),0,0,ControlUnit.getALUSrcSignal());
       
       int ALUControlSignal = ALUControlUnit.getALUControlSignal(I.getFnCode(), ControlUnit.getALUOpSignal());
       ALU.setALUControlSignal(ALUControlSignal);
       ALU.Operate(RegFile.getReadData1(), Mux_2, ALUControlSignal, I.getShiftAmount());
       
       DataMem.setMemWrite(ControlUnit.getMemWriteSignal());
       DataMem.setMemRead(ControlUnit.getMemReadSignal());
       DataMem.setAddress(ALU.getResult());
       DataMem.setWriteData(RegFile.getReadData2());
       DataMem.Write(DataMem.getAddress());
       DataMem.Read(DataMem.getAddress());
       int Mux_3 = Multiplexer(ALU.getResult(),DataMem.getReadData(),PC.Read()+4,0,ControlUnit.getMemtoRegSignal());
       RegFile.WriteData(Mux_3);
       
       int Address_1 = PC.Read()+4;
       int Address_2 = I.getOffset()*4 + Address_1;
       int Address_3 = I.getAddress()*4;
       
       int Mux_4 = Multiplexer(Address_1,Address_2,0,0,ControlUnit.getBranchSignal()&ALU.getZeroFlag());
       int Mux_5 = Multiplexer(Mux_4,Address_3,0,0,ControlUnit.getJumpSignal());
       int Mux_6 = Multiplexer(Mux_5,RegFile.getReadData1(),0,0,ControlUnit.getJumpRegisterSignal());
       PC.Write(Mux_6);
       System.out.println("--------------------------------");
       System.out.println("End of Cycle "+ClockCycles);
       System.out.println("--------------------------------");
       DisplayWires();
    }
    
    public void DisplayWires()
    {
        System.out.println("Number of Clock Cycles: "+ClockCycles);
        //PC Wires
        System.out.print("Instruction: ");
        InstructionMem.FetchInstruction(PC.Read()-4).printInstruction();
        System.out.println("PC Address: "+(PC.Read()-4));
        System.out.println("PC Address+4: "+(PC.Read()));
        
        //Register File Wires
        System.out.println("Read Register 1: "+RegFile.getReadRegister1());
        System.out.println("Read Register 2: "+RegFile.getReadRegister2());
        System.out.println("Write Register: "+RegFile.getWriteRegister());
        System.out.println("Read Data 1: "+RegFile.getReadData1());
        System.out.println("Read Data 2: "+RegFile.getReadData2());
        System.out.println("Write Data: "+RegFile.getWriteData());
        System.out.println("Offset: "+InstructionMem.FetchInstruction(PC.Read()-4).getOffset());
        System.out.println("Function Code: "+ALUControlUnit.getFnCode());
        
        //ALU Wires
        System.out.println("ALU Operand 1: "+ALU.getOperand1());
        System.out.println("ALU Operand 2: "+ALU.getOperand2());
        System.out.println("ALU Resullt: "+ALU.getResult());
        System.out.println("ALU Zero Flag: "+ALU.getZeroFlag());
        
        //Data Memory Wires
        System.out.println("Data Memory Address: "+DataMem.getAddress());
        System.out.println("Data Memory Write Data: "+DataMem.getWriteData());
        System.out.println("Data Memory Address Read Data: "+DataMem.getReadData());
        
        //Upper circuit
        System.out.println("Offset shifted left 2: "+InstructionMem.FetchInstruction(PC.Read()-4).getOffset()*4);
        System.out.println("Jump Address: "+ InstructionMem.FetchInstruction(PC.Read()-4).getAddress());
        System.out.println("Jump Address shifted left 2: "+ InstructionMem.FetchInstruction(PC.Read()-4).getAddress()*4);
        
        //Control Signals
        System.out.println("RegDst Signal: "+ControlUnit.getRegDstSignal());
        System.out.println("Jump Signal: "+ControlUnit.getJumpSignal());
        System.out.println("Branch Signal: "+ControlUnit.getBranchSignal());
        System.out.println("JumpRegister Signal: "+ControlUnit.getJumpRegisterSignal());
        System.out.println("MemRead Signal: "+ControlUnit.getMemReadSignal());
        System.out.println("MemtoReg Signal: "+ControlUnit.getMemtoRegSignal());
        System.out.println("ALUOp Signal: "+ControlUnit.getALUOpSignal());
        System.out.println("MemWrite Signal: "+ControlUnit.getMemWriteSignal());
        System.out.println("ALUSrc Signal: "+ControlUnit.getALUSrcSignal());
        System.out.println("RegWrite Signal: "+ControlUnit.getRegWriteSignal());
        System.out.println("JumpRegister Flag: "+JRDetect.getJumpRegisterFlag());
        //ALU Control Signal
        System.out.println("ALU Control Signal: "+ALUControlUnit.getALUControlSignal(ALUControlUnit.getFnCode(), ControlUnit.getALUOpSignal()));
        
    }
    
    public void DisplayRegisters()
    {
        System.out.print("$zero: "+RegFile.RegFile[0].Read()+"\t");
        System.out.println("$at: "+RegFile.RegFile[1].Read()+"\t");
        System.out.print("$v0: "+RegFile.RegFile[2].Read()+"\t\t");
        System.out.println("$v1: "+RegFile.RegFile[3].Read()+"\t\t");
        System.out.print("$a0: "+RegFile.RegFile[4].Read()+"\t\t");
        System.out.println("$a1: "+RegFile.RegFile[5].Read()+"\t\t");
        System.out.print("$a2: "+RegFile.RegFile[6].Read()+"\t\t");
        System.out.println("$a3: "+RegFile.RegFile[7].Read()+"\t\t");
        System.out.print("$t0: "+RegFile.RegFile[8].Read()+"\t\t");
        System.out.println("$t1: "+RegFile.RegFile[9].Read()+"\t\t");
        System.out.print("$t2: "+RegFile.RegFile[10].Read()+"\t\t");
        System.out.println("$t3: "+RegFile.RegFile[11].Read()+"\t\t");
        System.out.print("$t4: "+RegFile.RegFile[12].Read()+"\t\t");
        System.out.println("$t5: "+RegFile.RegFile[13].Read()+"\t\t");
        System.out.print("$t6: "+RegFile.RegFile[14].Read()+"\t\t");
        System.out.println("$t7: "+RegFile.RegFile[15].Read()+"\t\t");
        System.out.print("$s0: "+RegFile.RegFile[16].Read()+"\t\t");
        System.out.println("$s1: "+RegFile.RegFile[17].Read()+"\t\t");
        System.out.print("$s2: "+RegFile.RegFile[18].Read()+"\t\t");
        System.out.println("$s3: "+RegFile.RegFile[19].Read()+"\t\t");
        System.out.print("$s4: "+RegFile.RegFile[20].Read()+"\t\t");
        System.out.println("$s5: "+RegFile.RegFile[21].Read()+"\t\t");
        System.out.print("$s6: "+RegFile.RegFile[22].Read()+"\t\t");
        System.out.println("$s7: "+RegFile.RegFile[23].Read()+"\t\t");
        System.out.print("$t8: "+RegFile.RegFile[24].Read()+"\t\t");
        System.out.println("$t9: "+RegFile.RegFile[25].Read()+"\t\t");
        System.out.print("$k0: "+RegFile.RegFile[26].Read()+"\t\t");
        System.out.println("$k1: "+RegFile.RegFile[27].Read()+"\t\t");
        System.out.print("$gp: "+RegFile.RegFile[28].Read()+"\t\t");
        System.out.println("$sp: "+RegFile.RegFile[29].Read()+"\t\t");
        System.out.print("$fp: "+RegFile.RegFile[30].Read()+"\t\t");
        System.out.println("$ra: "+RegFile.RegFile[31].Read()+"\t\t");
        System.out.println("-------------------------------------------");
    }
    
    public void DisplayMemory()
    {
        for(int i=0 ; i < DataMem.DataMem.size() ; i++)
        {
            //Register r = DataMem.DataMem.get(i);
            //if(r == null)
             //    System.out.println(i*4+": "+"null");
            //else
                System.out.println(i*4+": "+DataMem.DataMem.get(i));
        }
    }
}