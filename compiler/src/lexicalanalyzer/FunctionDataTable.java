/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

/**
 *
 * 
 */
public class FunctionDataTable {
     String Name;
     String Type;
      String Static;
      String AM;
    String Assigned;
    String CurClass;
 int dimensionNo;
 String arrdimension;
     int Scope;
     
      public FunctionDataTable()
    {
         this.Name=null;
       
        this.Static="No";
        this.Type=null;
        this.AM=null;
        this.Assigned="No";
        this.CurClass=null;
        this.Scope=0;
       
    }
       public FunctionDataTable(String N,String T,String AM,String Static,String Assigned,String CurClass,int Scope)
    {
       this.Name=N;
        this.AM=AM;
        
        this.Assigned=Assigned;
        this.Static=Static;
        this.Type=T;
        this.CurClass=CurClass;
        this.Scope=Scope;
        
        
    }
        public String getarrdimension()
    {
        return this.arrdimension;
    }
  public int getdimensionNo()
    {
        return this.dimensionNo;
    }
  
 
       
    public String getname()
    {
        return this.Name;
    }
 
     public String getType()
    {
        return this.Type;
    }
     
            public String getAssigned()
    {
        return this.Assigned;
    }
              public int getScope()
    {
        return this.Scope;
    }
               public String getStatic()
    {
        return this.Static;
    }
         public String getAM()
    {
        return this.AM;
    }
    
public void setname(String N)
{
   this.Name=N;
}
public void setdimNo(int Dno)
{
   this.dimensionNo=Dno;
}

public void setarrdim(String adim)
{
   this.arrdimension=adim;
}

public void setType(String T)
{
   this.Type=T;
}
public void setScope(int Scope)
{
   this.Scope=Scope;
}
public void setAssigned(String Assigned)
{
   this.Assigned=Assigned;
}
  public String getCC()
    {
        return this.CurClass;
    }
  
  public void setAM(String AM)
{
   this.AM=AM;
}
  
  public void setCC(String CC)
{
   this.CurClass=CC;
}
}
