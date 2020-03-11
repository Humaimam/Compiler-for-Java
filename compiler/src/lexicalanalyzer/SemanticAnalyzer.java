/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 *
 */
public class SemanticAnalyzer {
    int i=0;
ArrayList<ClassTable> CT;
ArrayList<ClassDataTable> CDT;
ArrayList<FunctionDataTable> FDT;
 ClassDataTable CDTable=new ClassDataTable();
FunctionDataTable FDTable=new FunctionDataTable();
 Stack s=new Stack();
public SemanticAnalyzer()
{
    this.CT=new ArrayList<ClassTable>();
    this.CDT=new ArrayList<ClassDataTable>();
    this.FDT=new ArrayList<FunctionDataTable>();
}
public void insertclassDef(String N,String T,String AM,String Static,String Category,String Extends,String Implements) throws IOException
{
     String Type=lookupClass(N,T);
     if(Type==null)
     {
         ClassTable CTable=new ClassTable(N,T,AM,Static,Category,Extends,Implements);
         this.CT.add(CTable);
        ClassDataTable CDTable=new  ClassDataTable();
         FileWriter fw = new FileWriter("ClassTable111.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    try (PrintWriter writer = new PrintWriter(bw)) {
                        writer.println();
                        writer.append(CTable.Name+", "+CTable.Type+", "+CTable.AM+",  "+CTable.Static+", "+CTable.Category+", "+CTable.Extends+", "+CTable.Implements);
                        writer.close();
                           CDTable.setCC(N);
     }
     }
     else
     {
         System.out.println("x ERROR : Class "+N+" has already defined");
}
}


public void insertfunctionData(String N,String T,String AM,String Static,int Scope,String Assigned,String CurClass,int dimNo,String Arrdim) throws IOException
{
   
     String Type=lookupFunctionData(N,Scope,CurClass);
   
      
     if(Type==null)
     {
        FunctionDataTable FDTable=new FunctionDataTable(N,T,AM,Static,Assigned,CurClass,Scope);
         this.FDT.add(FDTable);
         this.FDTable.setarrdim(Arrdim);
         this.FDTable.setdimNo(dimNo);
        
          
          
           FileWriter fw = new FileWriter("FunctionDataTable111.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    try (PrintWriter writer = new PrintWriter(bw)) {
                        writer.println();
                        
                        writer.append(FDTable.Name+", "+FDTable.Type+", "+FDTable.AM+",  "+FDTable.Static+", "+FDTable.Assigned+", "+FDTable.CurClass+", "+FDTable.Scope);
                    
                    }     
     }  
     else
     {
         System.out.println("x ERROR : Variable "+N+" has already defined");
}
}

public void insertclassData(String N,String T,String AM,String Static,String Category,String Assigned,String CurClass,int dimNo,String arrdim) throws IOException
{
   
     String Type=lookupClassData(N,CurClass);
   
      
     if(Type==null)
     {
         
         ClassDataTable CDTable=new ClassDataTable(N,T,AM,Static,Category,Assigned,CurClass);
         this.CDT.add(CDTable);
        this.CDTable.setarrdim(arrdim);
        this.CDTable.setdimNo(dimNo);
          
          
           FileWriter fw = new FileWriter("ClassDataTable.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    try (PrintWriter writer = new PrintWriter(bw)) {
                        writer.println();
                        
                        writer.append(CDTable.Name+","+CDTable.Type+","+CDTable.AM+","+CDTable.Static+","+CDTable.Category+","+CDTable.Assigned+","+CDTable.CurClass);
                    
                    }     
     }  
     else
     {
         System.out.println("x ERROR : Variable "+N+" has already defined");
}
}

public String lookupClass(String Name,String Type) throws IOException
{
    for(int i=0;i<CT.size();i++)
    {
  if(CT.get(i).Name.equals(Name) && CT.get(i).Type.equals(Type))
  {
    
      return CT.get(i).Type;
  }
    }
    return null;
    
}
public String lookupClassData(String Name,String CurClass) throws FileNotFoundException, IOException
{
 
       
//    for(int i=0;i<CDT.size();i++)
//    {
//      System.out.println("Type"+CDT.get(i).Type+"\t\tline#"); 
//     //   System.out.println(Name+"\t\t\t\t\t\t"+CurClass+"\n");
//  if(CDT.get(i).Name.equals(Name) && CDT.get(i).CurClass.equals(CurClass))
//  {
//     
//      return CDT.get(i).Type;
//  }
//    }
//    return null;
    
    String str;
             int line=0;
             int k=0;
            FileReader fr = new FileReader("ClassDataTable.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = null;
            
            String[][] splitStr=new String[1000][7];
            if(br==null)
            {
                System.out.println("file not found");
            }
            else
            while((str=br.readLine())!=null){
               // System.out.println("\t\t"+splitStr[0][6]);
                    splitStr[k]= str.split(",");
                    
//            System.out.println(splitStr[k][0]+"->"+Name+"\t\t"+splitStr[k][6]+"->"+CurClass);
             if ((Name.equals(splitStr[k][0])) && (CurClass.equals(splitStr[k][6]))) {
                    System.out.println("\n\n"+Name+"\tIS ALREADY EXISTED\n\n");
                    return splitStr[k][1];
                }

    
            k++;}
    return null;
}
  public String lookupFunctionData(String Name,int scope,String CurClass)
{
 
       
    for(int i=0;i<this.FDT.size();i++)
    {
  if(FDT.get(i).Name.equals(Name)&& FDT.get(i).Scope==scope && FDT.get(i).CurClass.equals(CurClass))
  {
     
        
      
      return this.FDT.get(i).Type;
  }
      
    }
    
    return null;
    
}
public void createScope() 
{
    


if(s.size==0)
{
   
  s.push(1);
 
 
}
else
{ s.push(++this.s.arr[this.s.size]);
}      
s.display();
   
                           
   
                    }



public void destroyScope()
{
  //  Stack stack=new Stack();
 s.display();
   if(!s.isEmpty()==true)
   {
    s.pop();
}
   s.display();
}
public String IsAssigned(String Name,String Type,String CurClass)
{
     for(int i=0;i<this.CDT.size();i++)
    {
  if(CDT.get(i).Name.equals(Name) && CDT.get(i).Type.equals(Type) && CDT.get(i).CurClass.equals(CurClass))
  {
   
      return this.CDT.get(i).Assigned;
  }
    }
    
    return "No";
    
    
}

public String IsAssignedFunc(String Name,String Type,String CurClass,int scope)
{
     for(int i=0;i<this.FDT.size();i++)
    {
  if(FDT.get(i).Name.equals(Name) && FDT.get(i).Type.equals(Type) && FDT.get(i).CurClass.equals(CurClass) && FDT.get(i).Scope==scope)
  {
   
      return this.FDT.get(i).Assigned;
  }
    }
    
    return "No";
    
    
}
public boolean Isint(String Name,String CurClass)
{
     for(int i=0;i<this.CDT.size();i++)
    {
  if(CDT.get(i).Name.equals(Name) && CDT.get(i).CurClass.equals(CurClass))
  {
   
      if(!this.CDT.get(i).Type.equals("int")){
        
      System.out.println("x Error incompatibile type ,possible lossy conversion from "+this.CDT.get(i).Type+" to int");
  
      return false;}
    }
    }   
    return true;
    
    
}
public int dimension(String name,String CurClass,int scope)
{
    if(scope==1)
    {
        for(int i=0;i<this.CDT.size();i++)
    {
  if(CDT.get(i).Name.equals(name) && CDT.get(i).CurClass.equals(CurClass))
  {
   String type=CDT.get(i).Type;
    if(type.endsWith("[0-9]+"))
    {
        int dimension=type.lastIndexOf(type);
    return dimension;
  }
    }
}
    }
    else
       for(int i=0;i<this.FDT.size();i++)
    {
  if(FDT.get(i).Name.equals(name) && FDT.get(i).CurClass.equals(CurClass) && FDT.get(i).Scope==scope)
  {
    
   String type=FDT.get(i).Type;
     
   if(type.contains("->"))
    {
            
        int dimension=type.charAt(type.length()-1);
      return dimension;  
}}
    }
    return -1;
    
}}