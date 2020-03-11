/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

/**
 *
 */
public class ClassDataTable {
    String Name;
    String Type;
    String Category;
    String Static;
      String AM;
    String Assigned;
    String CurClass;
     int dimensionNo;
 String arrdimension;
    
    
     public ClassDataTable()
    {
        this.Name=null;
        this.Category="general";
        this.Static="No";
        this.Type=null;
        this.AM=null;
        this.Assigned="No";
        this.CurClass=null;
    }
      public ClassDataTable(String N,String T,String AM,String Static,String Category,String Assigned,String CurClass)
    {
        this.Name=N;
        this.AM=AM;
        this.Category=Category;
        this.Assigned=Assigned;
        this.Static=Static;
        this.Type=T;
        this.CurClass=CurClass;
         
        //this.CurClass=Cclass;
        
    }
      
      public void setdimNo(int Dno)
{
   this.dimensionNo=Dno;
}
public String getarrdimension()
    {
        return this.arrdimension;
    }
  public int getdimensionNo()
    {
        return this.dimensionNo;
    }
  
public void setarrdim(String adim)
{
   this.arrdimension=adim;
}
    public String getname()
    {
        return this.Name;
    }
 
     public String getType()
    {
        return this.Type;
    }
      public String getCategory()
    {
        return this.Category;
    }
      
        public String getStatic()
    {
        return this.Static;
    }
         public String getAM()
    {
        return this.AM;
    }
            public String getAssigned()
    {
        return this.Assigned;
    }
               public String getCC()
    {
        return this.CurClass;
    }
    
public void setname(String N)
{
   this.Name=N;
}
public void setType(String T)
{
   this.Type=T;
}
public void setCategory(String cat)
{
   this.Category=cat;
}
public void setAM(String AM)
{
   this.AM=AM;
}
public void setAssigned(String Assigned)
{
   this.Assigned=Assigned;
}
public void setCC(String CC)
{
   this.CurClass=CC;
}

}
