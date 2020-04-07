package mips_processor;
import java.util.*;

public class DataMemory 
{         
    ArrayList <Integer> DataMem = new ArrayList<Integer>(); 
    private int Address;
    private int WriteData; 
    private int ReadData; 
    private int MemRead; 
    private int MemWrite; 
    
    public DataMemory()
    {
        Address = 0; 
        WriteData = 0;
        ReadData = 0;
        MemRead = 0;
        MemWrite = 0;
        for(int i=0; i< 15 ; i++)
            DataMem.add(0);
    }
    
    public void setWriteData(int Data){WriteData = Data;}
    public void setMemRead(int MemRead){this.MemRead = MemRead;}
    public void setMemWrite(int MemWrite){this.MemWrite = MemWrite;}
    public void setAddress(int address){this.Address = address;}
    public int getReadData(){return ReadData;}
    public int getWriteData(){return WriteData;}
    public int getAddress(){return Address;}
    
    public void Write(int Address , int Data , boolean Flag)
    {
        this.Address = Address;
        
        if(Address/4 <= DataMem.size())
        {
            if(MemWrite == 1 || Flag == true)
            {   
                if(Address/4 < DataMem.size())
                {
                    DataMem.remove(Address/4);
                    DataMem.add(Address/4,Data);
                    //Register r = new Register();
                    //r.Write(Data);
                    //DataMem.remove(Address/4);
                    //DataMem.add(Address/4 , r);
                }
                    
                else if(Address/4 == DataMem.size())
                {
                    DataMem.add(Data);
                    //Register r = new Register();
                    //r.Write(Data);
                    //DataMem.add(r);
                }
            }
        }
        
        else if(Address/4 > DataMem.size())
        {
            if(MemWrite == 1 || Flag == true)
            {
                if(DataMem.isEmpty())
                {
                    for(int i=0 ; i< Address/4 ; i++)
                        DataMem.add(0);
                        //DataMem.add(null);
                }
                
                else
                {
                    for(int i=DataMem.size() ; i< Address/4 ; i++)
                    {
                        DataMem.add(0);
                        //Register r = DataMem.get(i);
                            //if(r != null)
                               // continue;
                            //else
                            //{
                                //DataMem.remove(i);
                                //DataMem.add(null);
                            //}
                    }
                }        
            //Register r = new Register();
            //r.Write(Data);
            //DataMem.add(r);
            DataMem.add(Data);
            }
        }
        //RegisterFile.RegFile[29].Write((DataMem.size())*4);
    }
    
    public void Write(int Address)
    {
        Write(Address,WriteData,false);
    }

    
    public int Read(int Address)
    {
        this.Address = Address;
        if(Address/4 < DataMem.size())
        {
            if(MemRead == 1)
            {
                //Register r = DataMem.get(Address/4); 
                //if(r != null)
                //{
                    //ReadData = r.Read();
                    //return ReadData; 
                  ReadData = DataMem.get(Address/4);
                  return ReadData;
            }
        }
        return ReadData;
    }          
}