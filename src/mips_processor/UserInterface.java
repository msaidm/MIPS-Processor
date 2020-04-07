package mips_processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInterface
{
    static String Function="" , RS="" , RT="" , RD="" , Offset="" , JumpLabel="" , ShiftAmt="";
    public static void DisplayMenu()
    {
        System.out.println("Instructions:");
        System.out.println("--------------"); 
        System.out.print("1)and\t\t");
        System.out.print("2)or\t\t");
        System.out.println("3)nor\t\t");
        System.out.print("4)addi\t\t");
        System.out.print("5)andi\t\t");
        System.out.println("6)ori\t\t");
        System.out.print("7)add\t\t");
        System.out.print("8)sll\t\t");
        System.out.println("9)slt\t\t");
        System.out.print("10)lw\t\t");
        System.out.print("11)sw\t\t");
        System.out.println("12)beq\t\t");
        System.out.print("13)j\t\t");
        System.out.print("14)jr\t\t");
        System.out.println("15)jal\t\t");
        System.out.println("---------------------------------------------");
        System.out.println("Registers:");
        System.out.println("-----------");
        System.out.print("1)$zero\t\t");
        System.out.print("2)$at\t\t");
        System.out.print("3)$v0\t\t");
        System.out.print("4)$v1\t\t");
        System.out.print("5)$a0\t\t");
        System.out.print("6)$a1\t\t");
        System.out.print("7)$a2\t\t");
        System.out.println("8)$a3\t\t");
        System.out.print("9)$t0\t\t");
        System.out.print("10)$t1\t\t");
        System.out.print("11)$t2\t\t");
        System.out.print("12)$t3\t\t");
        System.out.print("13)$t4\t\t");
        System.out.print("14)$t5\t\t");
        System.out.print("15)$t6\t\t");
        System.out.println("16)$t7\t\t");
        System.out.print("17)$s0\t\t");
        System.out.print("18)$s1\t\t");
        System.out.print("19)$s2\t\t");
        System.out.print("20)$s3\t\t");
        System.out.print("21)$s4\t\t");
        System.out.print("22)$s5\t\t");
        System.out.print("23)$s6\t\t");
        System.out.println("24)$s7\t\t");
        System.out.print("25)$t8\t\t");
        System.out.print("26)$t9\t\t");
        System.out.print("27)$k0\t\t");
        System.out.print("28)$k1\t\t");
        System.out.print("29)$gp\t\t");
        System.out.print("30)$sp\t\t");
        System.out.print("31)$fp\t\t");
        System.out.println("32)$ra\t\t");        
    }
    
    public static void SelectOperation(Instruction I , int Choice)
    {
        switch(Choice)
        {
            case 1:
                I.setOPCode(0);
                I.setFnCode(InstructionSet.and);
                break;
            
            case 2:
                I.setOPCode(0);
                I.setFnCode(InstructionSet.or);
                break;
                
            case 3:
                I.setOPCode(0);
                I.setFnCode(InstructionSet.nor);
                break;
                
            case 4:
                I.setOPCode(InstructionSet.addi);
                break;
                
            case 5:
                I.setOPCode(InstructionSet.andi);
                break;
                
            case 6:
                I.setOPCode(InstructionSet.ori);
                break;
            
            case 7:
                I.setOPCode(0);
                I.setFnCode(InstructionSet.add);
                break;
                
            case 8:
                I.setOPCode(0);
                I.setFnCode(InstructionSet.sll);
                break;
                
            case 9:
                I.setOPCode(0);
                I.setFnCode(InstructionSet.slt);
                break;
                
            case 10:
                I.setOPCode(InstructionSet.lw);
                break;
                
            case 11:
                I.setOPCode(InstructionSet.sw);
                break;
                
            case 12:
                I.setOPCode(InstructionSet.beq);
                break;
                
            case 13:
                I.setOPCode(InstructionSet.j);
                break;
                
            case 14:
                I.setOPCode(0);
                I.setFnCode(InstructionSet.jr);
                break;
                
            case 15:
                I.setOPCode(InstructionSet.jal);
                break;
        }
    }
    
    public static void SelectSource(Instruction I , int RS)
    {
        switch(RS)
        {
            case 1:
                I.setSource(InstructionSet.$zero);
                break;
            
            case 2:
                I.setSource(InstructionSet.$at);
                break;
                
            case 3:
                I.setSource(InstructionSet.$v0);
                break;
                
            case 4:
                I.setSource(InstructionSet.$v1);
                break;
                
            case 5:
                I.setSource(InstructionSet.$a0);
                break;
                
            case 6:
                I.setSource(InstructionSet.$a1);
                break;
            
            case 7:
                I.setSource(InstructionSet.$a2);
                break;
                
            case 8:
                I.setSource(InstructionSet.$a3);
                break;
                
            case 9:
                I.setSource(InstructionSet.$t0);
                break;
                
            case 10:
                I.setSource(InstructionSet.$t1);
                break;
                
            case 11:
                I.setSource(InstructionSet.$t2);
                break;
                
            case 12:
                I.setSource(InstructionSet.$t3);
                break;
                
            case 13:
                I.setSource(InstructionSet.$t4);
                break;
                
            case 14:
                I.setSource(InstructionSet.$t5);
                break;
                
            case 15:
                I.setSource(InstructionSet.$t6);
                break;
                
            case 16:
                I.setSource(InstructionSet.$t7);
                break;
            
            case 17:
                I.setSource(InstructionSet.$s0);
                break;
                
            case 18:
                I.setSource(InstructionSet.$s1);
                break;
                
            case 19:
                I.setSource(InstructionSet.$s2);
                break;
                
            case 20:
                I.setSource(InstructionSet.$s3);
                break;
                
            case 21:
                I.setSource(InstructionSet.$s4);
                break;
            
            case 22:
                I.setSource(InstructionSet.$s5);
                break;
                
            case 23:
                I.setSource(InstructionSet.$s6);
                break;
                
            case 24:
                I.setSource(InstructionSet.$s7);
                break;
                
            case 25:
                I.setSource(InstructionSet.$t8);
                break;
                
            case 26:
                I.setSource(InstructionSet.$t9);
                break;
                
            case 27:
                I.setSource(InstructionSet.$k0);
                break;
                
            case 28:
                I.setSource(InstructionSet.$k1);
                break;
                
            case 29:
                I.setSource(InstructionSet.$gp);
                break;
                
            case 30:
                I.setSource(InstructionSet.$sp);
                break;                
                
            case 31:
                I.setSource(InstructionSet.$fp);
                break;
                
            case 32:
                I.setSource(InstructionSet.$ra);
                break;   
        }
        
    }
    
    public static void SelectTarget(Instruction I , int RT)
    {
        switch(RT)
        {
            case 1:
                I.setTarget(InstructionSet.$zero);
                break;
            
            case 2:
                I.setTarget(InstructionSet.$at);
                break;
                
            case 3:
                I.setTarget(InstructionSet.$v0);
                break;
                
            case 4:
                I.setTarget(InstructionSet.$v1);
                break;
                
            case 5:
                I.setTarget(InstructionSet.$a0);
                break;
                
            case 6:
                I.setTarget(InstructionSet.$a1);
                break;
            
            case 7:
                I.setTarget(InstructionSet.$a2);
                break;
                
            case 8:
                I.setTarget(InstructionSet.$a3);
                break;
                
            case 9:
                I.setTarget(InstructionSet.$t0);
                break;
                
            case 10:
                I.setTarget(InstructionSet.$t1);
                break;
                
            case 11:
                I.setTarget(InstructionSet.$t2);
                break;
                
            case 12:
                I.setTarget(InstructionSet.$t3);
                break;
                
            case 13:
                I.setTarget(InstructionSet.$t4);
                break;
                
            case 14:
                I.setTarget(InstructionSet.$t5);
                break;
                
            case 15:
                I.setTarget(InstructionSet.$t6);
                break;
                
            case 16:
                I.setTarget(InstructionSet.$t7);
                break;
            
            case 17:
                I.setTarget(InstructionSet.$s0);
                break;
                
            case 18:
                I.setTarget(InstructionSet.$s1);
                break;
                
            case 19:
                I.setTarget(InstructionSet.$s2);
                break;
                
            case 20:
                I.setTarget(InstructionSet.$s3);
                break;
                
            case 21:
                I.setTarget(InstructionSet.$s4);
                break;
            
            case 22:
                I.setTarget(InstructionSet.$s5);
                break;
                
            case 23:
                I.setTarget(InstructionSet.$s6);
                break;
                
            case 24:
                I.setTarget(InstructionSet.$s7);
                break;
                
            case 25:
                I.setTarget(InstructionSet.$t8);
                break;
                
            case 26:
                I.setTarget(InstructionSet.$t9);
                break;
                
            case 27:
                I.setTarget(InstructionSet.$k0);
                break;
                
            case 28:
                I.setTarget(InstructionSet.$k1);
                break;
                
            case 29:
                I.setTarget(InstructionSet.$gp);
                break;
                
            case 30:
                I.setTarget(InstructionSet.$sp);
                break;                
                
            case 31:
                I.setTarget(InstructionSet.$fp);
                break;
                
            case 32:
                I.setTarget(InstructionSet.$ra);
                break;   
        }
    }
    
    public static void SelectDestination(Instruction I , int RD)
    {
        switch(RD)
        {
            case 1:
                I.setDestination(InstructionSet.$zero);
                break;
            
            case 2:
                I.setDestination(InstructionSet.$at);
                break;
                
            case 3:
                I.setDestination(InstructionSet.$v0);
                break;
                
            case 4:
                I.setDestination(InstructionSet.$v1);
                break;
                
            case 5:
                I.setDestination(InstructionSet.$a0);
                break;
                
            case 6:
                I.setDestination(InstructionSet.$a1);
                break;
            
            case 7:
                I.setDestination(InstructionSet.$a2);
                break;
                
            case 8:
                I.setDestination(InstructionSet.$a3);
                break;
                
            case 9:
                I.setDestination(InstructionSet.$t0);
                break;
                
            case 10:
                I.setDestination(InstructionSet.$t1);
                break;
                
            case 11:
                I.setDestination(InstructionSet.$t2);
                break;
                
            case 12:
                I.setDestination(InstructionSet.$t3);
                break;
                
            case 13:
                I.setDestination(InstructionSet.$t4);
                break;
                
            case 14:
                I.setDestination(InstructionSet.$t5);
                break;
                
            case 15:
                I.setDestination(InstructionSet.$t6);
                break;
                
            case 16:
                I.setDestination(InstructionSet.$t7);
                break;
            
            case 17:
                I.setDestination(InstructionSet.$s0);
                break;
                
            case 18:
                I.setDestination(InstructionSet.$s1);
                break;
                
            case 19:
                I.setDestination(InstructionSet.$s2);
                break;
                
            case 20:
                I.setDestination(InstructionSet.$s3);
                break;
                
            case 21:
                I.setDestination(InstructionSet.$s4);
                break;
            
            case 22:
                I.setDestination(InstructionSet.$s5);
                break;
                
            case 23:
                I.setDestination(InstructionSet.$s6);
                break;
                
            case 24:
                I.setDestination(InstructionSet.$s7);
                break;
                
            case 25:
                I.setDestination(InstructionSet.$t8);
                break;
                
            case 26:
                I.setDestination(InstructionSet.$t9);
                break;
                
            case 27:
                I.setDestination(InstructionSet.$k0);
                break;
                
            case 28:
                I.setDestination(InstructionSet.$k1);
                break;
                
            case 29:
                I.setDestination(InstructionSet.$gp);
                break;
                
            case 30:
                I.setDestination(InstructionSet.$sp);
                break;                
                
            case 31:
                I.setDestination(InstructionSet.$fp);
                break;
                
            case 32:
                I.setDestination(InstructionSet.$ra);
                break;   
        }
    }
    
    public static void InitializeMemoryAndAddress(MipsProcessor MIPS)
    {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String Choice;
        int value , address;
        System.out.print("Please enter the starting address: ");
        int StartingAddress = sc.nextInt();
        while(StartingAddress%4 !=0)
        {
            System.out.print("The starting address should be a multiple of 4, please re-enter: ");
            StartingAddress = sc.nextInt();
        }
        MIPS.InstructionMem.setAddress(StartingAddress);
        
        
        System.out.print("Initialize memory first? (Y/N) ");
        Choice = sc2.nextLine();
        while(!(Choice.equalsIgnoreCase("y")) && !(Choice.equalsIgnoreCase("n")))
        {
            System.out.print("Invalid choice , re-enter: ");
            Choice = sc2.nextLine();
        }
        
        if(Choice.equalsIgnoreCase("y"))
        {
            while(true)
            {
                System.out.print("Enter a value: ");
                value = sc.nextInt();
                System.out.print("Enter a memory address(multiple of 4): ");
                address = sc.nextInt();
                while(address%4 !=0)
                {
                    System.out.print("Invalid Memory Address, re-enter: ");
                    address = sc.nextInt();
                }
                
                System.out.print("Initialize again? (Y/N) ");
                Choice = sc2.nextLine();
                while(!(Choice.equalsIgnoreCase("y")) && !(Choice.equalsIgnoreCase("n")))
                {
                    System.out.print("Invalid choice , re-enter: ");
                    Choice = sc2.nextLine();
                }
                
                if(Choice.equalsIgnoreCase("y"))
                    MIPS.DataMem.Write(address, value,true);
                
                else
                {
                    MIPS.DataMem.Write(address, value,true);   
                    break;
                }
            }      
        }             
    }
    
    public static boolean WriteInstruction_FileReader(FileReader f , BufferedReader f2) 
    {   
        String WrittenInstruction = "";
        boolean Flag = true;
        Scanner sc = new Scanner(System.in);
        try {
            WrittenInstruction = f2.readLine();
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] SplitInstruction = WrittenInstruction.split(",");
        if(SplitInstruction[0].trim().equals(InstructionSet.Functions[7]))
        {
            if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
            
            for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RD = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
            
            if(Flag == true)
                {
                    System.out.print("Invalid Destination Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
            
            for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                if(InstructionSet.isInteger(SplitInstruction[3].trim()))
                {
                    ShiftAmt = SplitInstruction[3].trim();
                    if(Integer.parseInt(ShiftAmt) > 32 || Integer.parseInt(ShiftAmt) < 0)
                    {
                        System.out.print("Invalid Shift amount , re-enter: ");
                        return true;
                    }
                    
                    return false;
                }
                
                else
                    return true;
        }
        
        else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[0]) ||SplitInstruction[0].trim().equals(InstructionSet.Functions[1]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[2]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[6]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[8]))
            { 
                if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RD = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Destination Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Source Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[3].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[3].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                return false;
            }
                
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[3]) ||SplitInstruction[0].trim().equals(InstructionSet.Functions[4]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[5]))
            {
                if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag  == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }                    
                }                       

                if(Flag == true)
                {
                    System.out.print("Invalid Source Register , re-enter: ");
                    return true;
                }
                
                if(InstructionSet.isInteger(SplitInstruction[3].trim()))
                {
                    Offset = SplitInstruction[3].trim();
                    if(Integer.parseInt(Offset) > 32767 || Integer.parseInt(Offset) < -32768)
                    {
                        System.out.print("Offset is out of range , re-enter: ");
                        return true;
                    }
                    
                    return false;
                }
                
                else
                {
                    System.out.print("Invalid Offset , re-enter: ");
                    return true;
                }
             }
        
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[12]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[14]))
            {
                if(SplitInstruction.length > 2)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }   
                else
                {
                    Function = SplitInstruction[0].trim();
                    JumpLabel = SplitInstruction[1].trim();
                    return false;
                }
            }
            
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[13]))
            {
                if(SplitInstruction.length > 2)
                {
                    System.out.print("Invalid Instruction Syntax, re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag  == true)
                {
                    System.out.print("Invalid Source Register, re-enter: ");
                    return true;
                }
                             
                return false;
            }
            
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[9]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[10]))
            {
                if(SplitInstruction.length > 3)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Traget Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                String str;
                if(SplitInstruction[2].trim().endsWith(")"))
                {
                    str = SplitInstruction[2].trim().substring(SplitInstruction[2].trim().indexOf("(")+1 , SplitInstruction[2].trim().indexOf(")"));
                    RS = str.trim();
                }
                
                else
                {
                    System.out.print("Invalid Instruction Syntax, re-enter: ");
                    return true;
                }
                
                str = SplitInstruction[2].trim().substring(0, SplitInstruction[2].trim().indexOf("("));
                if(!(InstructionSet.isInteger(str.trim())))
                {
                    System.out.print("Invalid Offset(Must be an integer) , re-enter: ");
                    return true;
                }
                
                Offset = str.trim();
                if(Integer.parseInt(Offset)%4 != 0)
                {
                    System.out.print("Invalid Offset(must be a multiple of 4 , re-enter: ");
                    return true;
                }
                
                return false;
            }
        
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[11]))
            {
                if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Source Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }                  
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                JumpLabel = SplitInstruction[3].trim();
                return false;
            }
        System.out.print("Invalid Instruction , re-enter: ");
        return true;        
        } 
    
    public static void InputProgram_FileReader(MipsProcessor MIPS)
    {
        boolean Flag;
        FileReader f = null;
        BufferedReader f2 = null;
        try {
            f= new FileReader("program 6_FileReader.txt"); //Insert test file name here
            f2 = new BufferedReader(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner sc = new Scanner(System.in);
        String Choice ="";
        while(true)
        {
            Instruction I = new Instruction();
            System.out.print("Write a MIPS Instruction separated by a comma: ");
            Flag = WriteInstruction_FileReader(f,f2);
            while(Flag)
            {
                Flag = WriteInstruction_FileReader(f,f2);
            }
            
            if(Function.equals(InstructionSet.Functions[7]))
            {
                SelectOperation(I,8);
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                if(RD.equals(InstructionSet.Registers[i]))
                {
                    SelectDestination(I,i+1);
                    //RD="";
                    break;
                }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                if(RT.equals(InstructionSet.Registers[i]))
                {
                    SelectTarget(I,i+1);
                    //RS="";
                    break;
                }
                
                I.setShiftAmount(Integer.parseInt(ShiftAmt.trim()));
                I.setSource(0);
            }   
                
            
            else if(Function.equals(InstructionSet.Functions[0]) ||Function.equals(InstructionSet.Functions[1]) || Function.equals(InstructionSet.Functions[2]) || Function.equals(InstructionSet.Functions[6]) || Function.equals(InstructionSet.Functions[8]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ;i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RD.equals(InstructionSet.Registers[i]))
                    {
                        SelectDestination(I,i+1);
                        //RD="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setShiftAmount(0);
                
            }
            
            else if(Function.equals(InstructionSet.Functions[3]) ||Function.equals(InstructionSet.Functions[4]) || Function.equals(InstructionSet.Functions[5]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ;i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setOffset(Integer.parseInt(Offset));
            }
            
            else if(Function.equals(InstructionSet.Functions[12]) || Function.equals(InstructionSet.Functions[14]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ; i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                

                I.setJumpLabel(JumpLabel);
            }
            
            else if(Function.equals(InstructionSet.Functions[9]) || Function.equals(InstructionSet.Functions[10]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ;i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setOffset(Integer.parseInt(Offset));
            }
            
            else if(Function.equals(InstructionSet.Functions[13]))
            {
                SelectOperation(I,14);
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
            }
            
            else if(Function.equals(InstructionSet.Functions[11]))
            {
                SelectOperation(I,12);
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setJumpLabel(JumpLabel);
            }

            System.out.print("Do you want to add a label?(Y/N) ");
            try {
                Choice = f2.readLine();
            } catch (IOException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(!(Choice.equalsIgnoreCase("y")) && !(Choice.equalsIgnoreCase("n")))
            {
                System.out.print("Invalid choice , re-enter: ");
                Choice = sc.nextLine();
            }
                
            if(Choice.equalsIgnoreCase("y"))
            {
                System.out.print("Enter the name of the label: ");
                try {
                    Choice = f2.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                I.setLabel(Choice);
            }

            System.out.print("Do you want to keep writing instructions:(Y/N) ");
            try {
                Choice = f2.readLine();
            } catch (IOException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(!(Choice.equalsIgnoreCase("y")) && !(Choice.equalsIgnoreCase("n")))
            {
                System.out.print("Invalid choice , re-enter: ");
                Choice = sc.nextLine();
            }
                
            if(Choice.equalsIgnoreCase("y"))
                MIPS.InstructionMem.addInstruction(I);
                            
            else
            {
                MIPS.InstructionMem.addInstruction(I);
                break;
            }
        }
    }
    
    public static boolean WriteInstruction()
    {
        String WrittenInstruction = "";
        boolean Flag = true;
        Scanner sc = new Scanner(System.in);
        WrittenInstruction = sc.nextLine();
        String[] SplitInstruction = WrittenInstruction.split(",");
        if(SplitInstruction[0].trim().equals(InstructionSet.Functions[7]))
        {
            if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
            
            for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RD = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
            
            if(Flag == true)
                {
                    System.out.print("Invalid Destination Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
            
            for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                if(InstructionSet.isInteger(SplitInstruction[3].trim()))
                {
                    ShiftAmt = SplitInstruction[3].trim();
                    if(Integer.parseInt(ShiftAmt) > 32 || Integer.parseInt(ShiftAmt) < 0)
                    {
                        System.out.print("Invalid Shift amount , re-enter: ");
                        return true;
                    }
                    
                    return false;
                }
                
                else
                    return true;
        }
        
        else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[0]) ||SplitInstruction[0].trim().equals(InstructionSet.Functions[1]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[2]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[6]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[8]))
            { 
                if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RD = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Destination Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Source Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[3].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[3].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                return false;
            }
                
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[3]) ||SplitInstruction[0].trim().equals(InstructionSet.Functions[4]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[5]))
            {
                if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag  == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }                    
                }                       

                if(Flag == true)
                {
                    System.out.print("Invalid Source Register , re-enter: ");
                    return true;
                }
                
                if(InstructionSet.isInteger(SplitInstruction[3].trim()))
                {
                    Offset = SplitInstruction[3].trim();
                    if(Integer.parseInt(Offset) > 32767 || Integer.parseInt(Offset) < -32768)
                    {
                        System.out.print("Offset is out of range , re-enter: ");
                        return true;
                    }
                    
                    return false;
                }
                
                else
                {
                    System.out.print("Invalid Offset , re-enter: ");
                    return true;
                }
             }
        
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[12]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[14]))
            {
                if(SplitInstruction.length > 2)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }   
                else
                {
                    Function = SplitInstruction[0].trim();
                    JumpLabel = SplitInstruction[1].trim();
                    return false;
                }
            }
            
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[13]))
            {
                if(SplitInstruction.length > 2)
                {
                    System.out.print("Invalid Instruction Syntax, re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag  == true)
                {
                    System.out.print("Invalid Source Register, re-enter: ");
                    return true;
                }
                             
                return false;
            }
            
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[9]) || SplitInstruction[0].trim().equals(InstructionSet.Functions[10]))
            {
                if(SplitInstruction.length > 3)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Traget Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                String str;
                if(SplitInstruction[2].trim().endsWith(")"))
                {
                    str = SplitInstruction[2].trim().substring(SplitInstruction[2].trim().indexOf("(")+1 , SplitInstruction[2].trim().indexOf(")"));
                    RS = str.trim();
                }
                
                else
                {
                    System.out.print("Invalid Instruction Syntax, re-enter: ");
                    return true;
                }
                
                str = SplitInstruction[2].trim().substring(0, SplitInstruction[2].trim().indexOf("("));
                if(!(InstructionSet.isInteger(str.trim())))
                {
                    System.out.print("Invalid Offset(Must be an integer) , re-enter: ");
                    return true;
                }
                
                Offset = str.trim();
                if(Integer.parseInt(Offset)%4 != 0)
                {
                    System.out.print("Invalid Offset(must be a multiple of 4 , re-enter: ");
                    return true;
                }
                
                return false;
            }
        
            else if(SplitInstruction[0].trim().equals(InstructionSet.Functions[11]))
            {
                if(SplitInstruction.length > 4)
                {
                    System.out.print("Invalid Instruction Syntax , re-enter: ");
                    return true;
                }
                
                else
                    Function = SplitInstruction[0].trim();
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[1].trim().equals(InstructionSet.Registers[j]))
                    {
                        RS = SplitInstruction[1].trim();
                        Flag = false;
                        break;
                    }
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Source Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                for(int j=0 ; j < InstructionSet.Registers.length ; j++)
                {
                    if(SplitInstruction[2].trim().equals(InstructionSet.Registers[j]))
                    {
                        RT = SplitInstruction[2].trim();
                        Flag = false;
                        break;
                    }                  
                }
                
                if(Flag == true)
                {
                    System.out.print("Invalid Target Register , re-enter: ");
                    return true;
                }
                
                else
                    Flag = true;
                
                JumpLabel = SplitInstruction[3].trim();
                return false;
            }
        System.out.print("Invalid Instruction , re-enter: ");
        return true; 
    }
    
    public static void InputProgram(MipsProcessor MIPS)
    {
        boolean Flag;
        Scanner sc = new Scanner(System.in);
        String Choice ="";
        while(true)
        {
            Instruction I = new Instruction();
            System.out.print("Write a MIPS Instruction separated by a comma: ");
            Flag = WriteInstruction();
            while(Flag)
            {
                Flag = WriteInstruction();
            }
            
            if(Function.equals(InstructionSet.Functions[7]))
            {
                SelectOperation(I,8);
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                if(RD.equals(InstructionSet.Registers[i]))
                {
                    SelectDestination(I,i+1);
                    //RD="";
                    break;
                }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                if(RT.equals(InstructionSet.Registers[i]))
                {
                    SelectTarget(I,i+1);
                    //RS="";
                    break;
                }
                
                I.setShiftAmount(Integer.parseInt(ShiftAmt.trim()));
                I.setSource(0);
            }   
                
            
            else if(Function.equals(InstructionSet.Functions[0]) ||Function.equals(InstructionSet.Functions[1]) || Function.equals(InstructionSet.Functions[2]) || Function.equals(InstructionSet.Functions[6]) || Function.equals(InstructionSet.Functions[8]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ;i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RD.equals(InstructionSet.Registers[i]))
                    {
                        SelectDestination(I,i+1);
                        //RD="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setShiftAmount(0);
                
            }
            
            else if(Function.equals(InstructionSet.Functions[3]) ||Function.equals(InstructionSet.Functions[4]) || Function.equals(InstructionSet.Functions[5]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ;i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setOffset(Integer.parseInt(Offset));
            }
            
            else if(Function.equals(InstructionSet.Functions[12]) || Function.equals(InstructionSet.Functions[14]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ; i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                

                I.setJumpLabel(JumpLabel);
            }
            
            else if(Function.equals(InstructionSet.Functions[9]) || Function.equals(InstructionSet.Functions[10]))
            {
                for(int i=0 ; i < InstructionSet.Functions.length ;i++)
                    if(Function.equals(InstructionSet.Functions[i]))
                    {
                        SelectOperation(I,i+1);
                        //Function="";
                        break;
                    }
                
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setOffset(Integer.parseInt(Offset));
            }
            
            else if(Function.equals(InstructionSet.Functions[13]))
            {
                SelectOperation(I,14);
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
            }
            
            else if(Function.equals(InstructionSet.Functions[11]))
            {
                SelectOperation(I,12);
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RS.equals(InstructionSet.Registers[i]))
                    {
                        SelectSource(I,i+1);
                        //RS="";
                        break;
                    }
                               
                for(int i=0 ; i < InstructionSet.Registers.length ; i++)
                    if(RT.equals(InstructionSet.Registers[i]))
                    {
                        SelectTarget(I,i+1);
                        //RT="";
                        break;
                    }
                I.setJumpLabel(JumpLabel);
            }

            System.out.print("Do you want to add a label?(Y/N) ");
            Choice = sc.nextLine();
            while(!(Choice.equalsIgnoreCase("y")) && !(Choice.equalsIgnoreCase("n")))
            {
                System.out.print("Invalid choice , re-enter: ");
                Choice = sc.nextLine();
            }
                
            if(Choice.equalsIgnoreCase("y"))
            {
                System.out.print("Enter the name of the label: ");
                Choice = sc.nextLine();
                I.setLabel(Choice);
            }

            System.out.print("Do you want to keep writing instructions:(Y/N) ");
                Choice = sc.nextLine();
            while(!(Choice.equalsIgnoreCase("y")) && !(Choice.equalsIgnoreCase("n")))
            {
                System.out.print("Invalid choice , re-enter: ");
                Choice = sc.nextLine();
            }
                
            if(Choice.equalsIgnoreCase("y"))
                MIPS.InstructionMem.addInstruction(I);
                            
            else
            {
                MIPS.InstructionMem.addInstruction(I);
                break;
            }
        }
    }
}