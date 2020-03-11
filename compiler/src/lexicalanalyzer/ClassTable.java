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
public class ClassTable {
    String Name;
    String Type;
    String AM;
    String Static;
    String Category;
    String Extends;
    String Implements;
    String Link;
    public ClassTable()
    {
        this.Name=null;
        this.Category="general";
        this.Static="No";
        this.Type=null;
        this.AM=null;
        this.Extends="No";
        this.Implements="No";
    }
    public ClassTable(String N,String T,String AM,String Static,String Category,String Extends,String Implements)
    {
        this.Name=N;
        this.AM=AM;
        this.Category=Category;
        this.Extends=Extends;
        this.Implements=Implements;
        this.Static=Static;
        this.Type=T;
        
    }
    public String getname()
    {
        return this.Name;
    }
     public String getImplements()
    {
        return this.Implements;
    }
     public String getType()
    {
        return this.Type;
    }
      public String getCategory()
    {
        return this.Category;
    }
       public String getExtends()
    {
        return this.Extends;
    }
        public String getStatic()
    {
        return this.Static;
    }
         public String getAM()
    {
        return this.AM;
    }
     public String getLink()
    {
        return this.Link;
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
public void setLink(String Link)
{
   this.Link=Link;
}
public void setExtends(String Extends)
{
   this.Extends=Extends;
}
public void setImplements(String Imp)
{
   this.Implements=Imp;
}
}
    

