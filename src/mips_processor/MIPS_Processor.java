package mips_processor;

public class MIPS_Processor
{
    public static void main(String[] args) 
    {
        MipsProcessor MIPS = new MipsProcessor();
             
        UserInterface.InitializeMemoryAndAddress(MIPS);
        MIPS.DisplayMemory();
        UserInterface.DisplayMenu();
        UserInterface.InputProgram_FileReader(MIPS);

        
        for(int i=MIPS.InstructionMem.getInitialAddress()/4 ; i < MIPS.InstructionMem.Imem.size(); i++)
            MIPS.InstructionMem.Imem.get(i).printInstruction();
        
        MIPS.Run();
        MIPS.DisplayRegisters();
        MIPS.DisplayMemory();
       // MIPS.DisplayWires();
//        int Choice, RS,RT,RD,ShiftAmt,Offset,LB;
//        String LBL;
//        Scanner LCL = new Scanner(System.in);
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Please enter the starting address: ");
//        int StartingAddress = sc.nextInt();
//        while(StartingAddress%4 !=0)
//        {
//            System.out.print("The starting address should be a multiple of 4, please re-enter: ");
//            StartingAddress = sc.nextInt();
//        }
//        MIPS.InstructionMem.setAddress(StartingAddress);
//            
//        UserInterface.DisplayMenu();
//        
//        while(true)
//        {
//            Instruction I = new Instruction();
//            System.out.print("Choose an operation: ");
//            Choice = sc.nextInt();
//            while(Choice > 15)
//            {
//                System.out.print("Wrong choice , re-enter: ");
//                Choice = sc.nextInt();  
//            }  
//            UserInterface.SelectOperation(I, Choice);
//            //R-Format If Condition    
//            if(Choice == 1 || Choice == 2 || Choice == 3 || Choice == 7 || Choice == 8 || Choice == 9 || Choice == 14)
//            {
//                //jr If Condition
//                if(Choice == 14)
//                {
//                    System.out.print("Enter Register to jump to: ");
//                    RS = sc.nextInt();
//                    while(RS > 32)
//                    {
//                        System.out.print("Wrong choice , re-enter: ");
//                        RS = sc.nextInt();
//                    }
//                    UserInterface.SelectSource(I, RS);
//                    I.setTarget(0);
//                    I.setDestination(0);
//                }
//
//                System.out.print("Enter the Source Register: ");
//                RS = sc.nextInt();
//                while(RS > 32)
//                {
//                    System.out.print("Wrong choice , re-enter: ");
//                    RS = sc.nextInt();  
//                }
//                UserInterface.SelectSource(I, RS);
//
//                System.out.print("Enter the Second Source Register: ");
//                RT = sc.nextInt();
//                while(RT > 32)
//                {
//                    System.out.print("Wrong choice , re-enter: ");
//                    RT = sc.nextInt();  
//                }
//                UserInterface.SelectTarget(I, RT);
//
//                System.out.print("Enter the Destination Register: ");
//                RD = sc.nextInt();
//                while(RD > 32)
//                {
//                    System.out.print("Wrong choice , re-enter: ");
//                    RD = sc.nextInt();  
//                }
//                UserInterface.SelectDestination(I, RD);
//
//                //sll If Condition
//                if(Choice == 8)
//                {
//                    System.out.print("Enter Shift amount: ");
//                    ShiftAmt = sc.nextInt();
//                    while(ShiftAmt > 32 || ShiftAmt < 0)
//                    {
//                        System.out.print("Invalid Shift amount , re-enter: ");
//                        ShiftAmt = sc.nextInt();    
//                    }
//                    I.setSource(0);                          
//                    I.setShiftAmount(ShiftAmt);
//                }
//                else
//                    I.setShiftAmount(0);
//            }
//            
//            //I-Format If Condition
//            if(Choice == 4 || Choice == 5 || Choice == 6 || Choice == 10 || Choice == 11 || Choice == 12)
//            {
//                if(Choice == 4 || Choice == 5 || Choice == 6 || Choice == 10)
//                {
//                    System.out.print("Enter the Source Register: ");
//                    RS = sc.nextInt();
//                    while(RS > 32)
//                    {
//                        System.out.print("Wrong choice , re-enter: ");
//                        RS = sc.nextInt();
//                    }
//                    UserInterface.SelectSource(I, RS);
//                    
//                    System.out.print("Enter the Destination Register: ");
//                    RT = sc.nextInt();
//                    while(RT > 32)
//                    {
//                        System.out.print("Wrong choice , re-enter: ");
//                        RT = sc.nextInt();
//                    }
//                    UserInterface.SelectTarget(I, RT);
//                    
//                    System.out.print("Enter the Constant value(from -32,768 to 32,767): ");
//                    Offset = sc.nextInt();
//                    while(Offset > 32767 || Offset < -32768)
//                    {
//                        System.out.print("Offset is out of range , re-enter: ");
//                        Offset = sc.nextInt();
//                    }
//                    I.setOffset(Offset);
//                }    
//                
//                //sw If Condition
//                if(Choice == 11)
//                {
//                    System.out.print("Enter the Source Register: ");
//                    RS = sc.nextInt();
//                    while(RS > 32)
//                    {
//                        System.out.print("Wrong choice , re-enter: ");
//                        RS = sc.nextInt();
//                    }
//                    UserInterface.SelectSource(I, RS);
//                    
//                    System.out.print("Enter the Second Source Register: ");
//                    RT = sc.nextInt();
//                    while(RT > 32)
//                    {
//                        System.out.print("Wrong choice , re-enter: ");
//                        RT = sc.nextInt();
//                    }
//                    UserInterface.SelectTarget(I, RT);
//                    
//                    System.out.print("Enter the Constant value(from -32,768 to 32,767): ");
//                    Offset = sc.nextInt();
//                    while(Offset > 32767 || Offset < -32768)
//                    {
//                        System.out.print("Offset is out of range , re-enter: ");
//                        Offset = sc.nextInt();
//                    }
//                    I.setOffset(Offset);
//                }
//                
//                //beq If Condition
//                if(Choice == 12)
//                {
//                    System.out.print("Enter the Source Register: ");
//                    RS = sc.nextInt();
//                    while(RS > 32)
//                    {
//                        System.out.print("Wrong choice , re-enter: ");
//                        RS = sc.nextInt();
//                    }
//                    UserInterface.SelectSource(I, RS);
//                    
//                    System.out.print("Enter the Second Source Register: ");
//                    RT = sc.nextInt();
//                    while(RT > 32)
//                    {
//                        System.out.print("Wrong choice , re-enter: ");
//                        RT = sc.nextInt();
//                    }
//                    UserInterface.SelectTarget(I, RT);
//                    
//                    System.out.print("Enter Branch Label: ");
//                    LBL = LCL.nextLine();
//                    I.setJumpLabel(LBL);
//                }
//            }
//            
//            //J-Format If Condition
//            if(Choice == 13 || Choice == 15)
//            {
//                System.out.print("Enter Jump label: ");
//                LBL = LCL.nextLine();
//                I.setJumpLabel(LBL);
//            }
//            
//            
//            System.out.print("Do you want to add a label?(Y/N) ");
//            LBL = LCL.nextLine();
//            while(!(LBL.equalsIgnoreCase("y")) && !(LBL.equalsIgnoreCase("n")))
//            {
//                System.out.print("Invalid choice , re-enter: ");
//                LBL = LCL.nextLine();
//            }
//                
//            if(LBL.equalsIgnoreCase("y"))
//            {
//                System.out.print("Enter the name of the label: ");
//                LBL = LCL.nextLine();
//                I.setLabel(LBL);
//            }
//
//            System.out.print("Do you want to keep writing instructions:(Y/N) ");
//            LBL = LCL.nextLine();
//            while(!(LBL.equalsIgnoreCase("y")) && !(LBL.equalsIgnoreCase("n")))
//            {
//                System.out.print("Invalid choice , re-enter: ");
//                LBL = LCL.nextLine();
//            }
//                
//            if(LBL.equalsIgnoreCase("y"))
//                MIPS.InstructionMem.addInstruction(I);
//                
//            else
//            {
//                MIPS.InstructionMem.addInstruction(I);
//                break;
//            }
//        }    
//        
//        for(int i=0 ; i < MIPS.InstructionMem.Imem.size(); i++)
//            MIPS.InstructionMem.Imem.get(i).printInstruction();
//        
//        MIPS.Run();
//        System.out.println(MIPS.DataMem.DataMem.get(0).Read());
//        MIPS.DisplayWires();
//        MIPS.DisplayRegisters();
//        
    }
}
                