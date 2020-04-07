package mips_processor;

import java.util.Arrays;

public class Register
{
    private int Data;
    
    public Register(){Data = 0;}
    
    public int Read(){return Data;}
    
    public void Write(int Data){this.Data = Data;}
    
    
    
}