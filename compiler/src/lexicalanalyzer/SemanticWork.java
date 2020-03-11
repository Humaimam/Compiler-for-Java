/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class SemanticWork {
   
     TokenSet ts=new TokenSet();
     boolean plus=false;
     String cclass=" ";
 int i=0;
 int j=0;
 String Name=null;
   String Type=null;
     String AM=null;
     String Static="No";
     String Category="general";
     String Extends="No";
   String Implements="No";
  String assigned="No";
  String CurrentClass;
  String T1="";
  String T2="";
  String cl="";
  int dimension=0;
  int newdimension=0;
  String arrdimension="";
   String arrinitdimension="";
  boolean forindex=false;
   int dimensionNo=0;
  // String type1; 
//    String type2;
   classification Classification=new classification();
    SemanticAnalyzer SA=new SemanticAnalyzer();
     IdentifierClassification IC=new IdentifierClassification();
     ArrayList<TokenSet> tokenset=new ArrayList<>();
    Stack s=new Stack();
       ArrayList<String> parray=new ArrayList<>();
public SemanticWork( ArrayList<TokenSet> tokenset)
{
    
    this.tokenset=tokenset;
    ts.ClassPart="$";
     ts.ValuePart="$";
   ts.lineNo=-1;
    this.tokenset.add(ts);
   /* for(int i=0;i<this.tokenset.size();i++)
    {
        System.out.println(this.tokenset.get(i).ClassPart);
    }
    */
}
  ////////==========================================Starting Non Terminal=============================================//////
public int S() throws IOException
{
   
         if(this.tokenset.get(i).ValuePart.equals("public"))
         {
             AM="public";
           
             i++;
             
             if(intf_class_func()==true)
             {
                
                 i++;
             }
         }
      else
              
            if(this.tokenset.get(i).ValuePart.equals("class"))
            {
                Type="class";
               //System.out.println(tokenset.get(i).ValuePart);
              if(class_def()==true)
                {
                   System.out.println("Class declaration grammar is valid at :"+tokenset.get(i).lineNo);
                    
                     i++;
                }
            }
            else
              
            if(this.tokenset.get(i).ValuePart.equals("abstract"))
            {
             Category="abstract";
                i++;
              if(this.tokenset.get(i).ValuePart.equals("class"))
            {
                
              if(class_def()==true)
                {
                   System.out.println("Class declaration grammar is valid at :"+tokenset.get(i).lineNo);
                    
                     i++;
                }
            }
            }
               else
              
            if(this.tokenset.get(i).ValuePart.equals("final"))
            {
              Category="final";
                i++;
              if(this.tokenset.get(i).ValuePart.equals("class"))
            {
              
              if(class_def()==true)
                {
                  System.out.println("Class declaration grammar is valid at :"+tokenset.get(i).lineNo);
                    
                     i++;
                }
            }
            }
         else
            if(this.tokenset.get(i).ValuePart.equals("interface"))
            {
                        
//System.out.println(tokenset.get(i).ValuePart);
              if(interface_st()==true)
                {
                    System.out.println("interface declaration grammar is valid at :"+tokenset.get(i).lineNo);
                    
                     i++;
                }
            }
          if(this.tokenset.get(i).ValuePart.equals("class")||this.tokenset.get(i).ValuePart.equals("interface")||this.tokenset.get(i).ValuePart.equals("public")||this.tokenset.get(i).ValuePart.equals("abstract")||this.tokenset.get(i).ValuePart.equals("final"))
          {
              this.resetValues();
              this.CurrentClass=null;
          
              this.S();
          }        if(tokenset.get(i).ValuePart.equals("$"))
                    {
                        
                     return tokenset.get(i-1).lineNo;
                    
                
                
            }
    
    return -1;
}
public void resetValues()
{
      this.Name=null;
              this.AM=null;
              this.Category="general";
              this.Static="No";
              this.Extends="No";
              this.Implements="No";
              this.Type=null;
            this.assigned="No";
            this.dimension=0;
            this.newdimension=0;
            arrdimension="";
            arrinitdimension="";
T1="";
T2="";
cl="";
 this.dimensionNo=0;
}
public boolean intf_class_func() throws IOException
{
    if(this.tokenset.get(i).ValuePart.equals("interface"))
    {
     
        if(interface_st()==true)
        {
             System.out.println("interface declaration grammar is valid at :"+tokenset.get(i).lineNo);
                 
            return true;
        }
    }
    else
      if(this.tokenset.get(i).ValuePart.equals("class"))
      {
         
          if(class_def()==true)
          {
               System.out.println("class declaration grammar is valid at :"+tokenset.get(i).lineNo);
                 
            return true;  
          }
      }
    else
          if(this.tokenset.get(i).ValuePart.equals("abstract"))
      {
          Category="abstract";
          i++;
           if(this.tokenset.get(i).ValuePart.equals("class"))
      {
         
          if(class_def()==true)
          {
            return true;  
          }
      }
      }
      else
          if(this.tokenset.get(i).ValuePart.equals("final"));
      {
          Category="final";
          i++;
           if(this.tokenset.get(i).ValuePart.equals("class"))
      {
          
          if(class_def()==true)
          {
            return true;  
          }
      }
      }
          
       return false;
}
////////////-=================================Class declaration=================================/////////////////////
public boolean class_def() throws IOException
        
{
     if(this.tokenset.get(i).ValuePart.equals("class"))
            {
                Type="class";
          
                i++;
                 if(this.tokenset.get(i).ClassPart.equals("ID"))
                {
                    this.CurrentClass=tokenset.get(i).ValuePart;
                     this.cclass=this.CurrentClass;
                    Name=tokenset.get(i).ValuePart;
                    SA.CDTable.setCC(Name);
                    i++;
                    if(this.tokenset.get(i).ValuePart.equals("extends"))
                    {
                        Extends="Yes";
  
                        if(extend_def()==true)
                    {
                        
                    }
                }
                    
                        if(this.tokenset.get(i).ValuePart.equals("implements"))
                        {
                            Implements="Yes";
                            if(implement()==true)
                            {
                               
                               
                                
                            }
                        }
                    
                 if(tokenset.get(i).ValuePart.equals("{"))
        {
            SemanticAnalyzer SA=new SemanticAnalyzer();
            SA.insertclassDef(Name,Type,AM,Static,Category,Extends,Implements);
            this.createScope();
             
             
            
            i++;
           
             if(classBody()==true)
               {
           
                   // System.out.println("yes");
                  
                   return true;
               }
            
            else
                if(tokenset.get(i).ValuePart.equals("}"))
                {
                   this.destroyScope();
                   
                    return true;
                }
        }
            
                }
            }
            
     return false;
}

public boolean extend_def() throws IOException
{
    if(tokenset.get(i).ValuePart.equals("extends"))
   {   
      i++;
 if(this.tokenset.get(i).ClassPart.equals("ID"))
                {
                   String name=tokenset.get(i).ValuePart;
                   String type=SA.lookupClass(name, "class");
                   if(type==null)
                   {
                       System.out.println("x Error at line no "+tokenset.get(i).lineNo+" Class "+name+" does not exists");
                   }
                    i++;
if(tokenset.get(i).ValuePart.equals(","))
{ 
if(extend_list()==true)
{
    return true;
}
else
    return false;
}
else
    return true;
                }
   }

return false;
     
}
    
public boolean extend_list() throws IOException
{
    if(tokenset.get(i).ValuePart.equals(","))
    {
        i++;
         if(tokenset.get(i).ClassPart.equals("ID"))
            
         
    {
         String name=tokenset.get(i).ValuePart;
                   String type=SA.lookupClass(name, "class");
                   if(type==null)
                   {
                       System.out.println("x Error at line no "+tokenset.get(i).lineNo+" Class "+name+" does not exists");
                   }
         i++;
         
      if(tokenset.get(i).ValuePart.equals(","))
    {
        if(extend_list()==true)
        {
            return true;
        }
    }
      else
          return true;
    }
    }
    return false;
}
    
 public boolean interface_st() throws IOException
 {
        
            if(this.tokenset.get(i).ValuePart.equals("interface"))
            {
               Type="interface";
                i++;
                if(this.tokenset.get(i).ClassPart.equals("ID"))
                {
               this.CurrentClass=tokenset.get(i).ValuePart;
                    Name=tokenset.get(i).ValuePart;
                    i++;
              
               if(this.tokenset.get(i).ValuePart.equals("implements"))
                        {
                           Implements="Yes";
                            if(implement()==true)
                            {
                               
                                
                                
                            }
                        }
                     
                 if(tokenset.get(i).ValuePart.equals("{"))
        {
               
            SA.insertclassDef(Name,Type,AM,Static,Category,Extends,Implements);
          
            SA.createScope();
            i++;
             
             if(interfaceBody()==true)
               {
                   
                // System.out.println("yes");
                   return true;
               }
                  
            
            else
                 
                if(tokenset.get(i).ValuePart.equals("}"))
                {
                  SA.destroyScope();
                    return true;
                }
        }
                }
            }
 

        
            return false;
 }
 
public boolean implement() throws IOException
{
    if(tokenset.get(i).ValuePart.equals("implements"))
    {   i++;
    
     if(tokenset.get(i).ClassPart.equals("ID"))
    {   
         String name=tokenset.get(i).ValuePart;
                   String type=SA.lookupClass(name, "interface");
                   if(type==null)
                   {
                       System.out.println("x Error at line no "+tokenset.get(i).lineNo+" Interface "+name+" does not exists");
                   }
        i++;
         
   // System.out.println(tokenset.get(i).ValuePart);
     if(tokenset.get(i).ValuePart.equals(","))
    {   
    if(this.interface_list()==true)
    {
    
     return true;   
    }
    }
     else
     {
         return true;
     }
    }
    }
              
    
    return false;
 }
/*public boolean interface_list1()
{
    if(tokenset.get(i).ClassPart.equals("ID"))
    {
        i++;
        if(interface_list2()==true)
        {
            return true;
        }}
    return false;
}*/
public boolean interface_list() throws IOException
{
    if(tokenset.get(i).ValuePart.equals(","))
    {
        i++;
        if(tokenset.get(i).ClassPart.equals("ID"))
    {
        String name=tokenset.get(i).ValuePart;
                   String type=SA.lookupClass(name, "interface");
                   if(type==null)
                   {
                       System.out.println("x Error at line no "+tokenset.get(i).lineNo+" interface "+name+" does not exists");
                   }
        i++;
        if(tokenset.get(i).ValuePart.equals(","))
        {
           
        if(interface_list()==true)
        {
    
        return true;}
        }
         
        else
              return true;
    }
    }
    
        
    return false;
}

public boolean interfaceBody()
{
    return false;
    
}
public boolean classBody() throws IOException
{
   
   
    this.resetValues();
         if(tokenset.get(i).ValuePart.equals("public")||tokenset.get(i).ValuePart.equals("private")||tokenset.get(i).ValuePart.equals("protected")||tokenset.get(i).ValuePart.equals("abstract")||tokenset.get(i).ValuePart.equals("static")||tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ValuePart.equals("void")||  tokenset.get(i).ClassPart.equals("String"))
           {
                i++;
                
               if(func_decl_def()==true)
               {
                  System.out.println("\n\n\nhuma\n\n\n");
//           if(classBody()==true)
//                   {
//                       this.resetValues();
//                      return true;
//                  }
//                   else
//                       if(tokenset.get(i).ValuePart.equals("}"))
//                       {
//               return true;
//                       }       
//          
           return true;
           }
              
               }
           
        


    else
    {
         if(tokenset.get(i).ClassPart.equals("ID"))
       {
           
          String type=tokenset.get(i).ValuePart;
          
          String ct=SA.lookupClass(type, this.CurrentClass);
          if(ct==null)
          {
              System.out.println("x Error at "+tokenset.get(i).lineNo+" cannot find class "+type);
          }
           i++;
           
         if(arr()==true)
         {
         }
           if(tokenset.get(i).ClassPart.equals("ID"))
           {
            
           String name=tokenset.get(i).ValuePart;
            String T=SA.lookupClassData(name, this.CurrentClass);
            if(T!=null)
            {
                System.out.println("x Error at "+tokenset.get(i).lineNo+" Variable "+name+" has already defined");
            }
               i++;
               
               if(tokenset.get(i).ValuePart.equals(";"))
                      
       {
           SA.insertclassData(name, type, AM, Static, Category, assigned, this.CurrentClass,this.dimensionNo,this.arrdimension);
      this.arrdimension="";
      this.dimensionNo=0;
           System.out.println("object declaration is valid at: "+tokenset.get(i).lineNo);
           i++;
           if(classBody()==true)
                   {
                       this.resetValues();
                      return true;
                  }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
           
       }
                  else
                      if(tokenset.get(i).ValuePart.equals("="))
                      {
                          assigned="Yes";
                          i++;
                          
                          if(tokenset.get(i).ClassPart.equals("new"))
                          {
                      i++;
                     
                      if(tokenset.get(i).ClassPart.equals("ID"))
                      {
                          if(!type.equals(tokenset.get(i).ValuePart))
                          {
                              System.out.println("x Error at "+tokenset.get(i).lineNo+" cannot find symbol "+tokenset.get(i).ValuePart);
                          }
                          i++;
                         
                          if(ArrayInit(type)==true)
                          {
                          }
                           if(tokenset.get(i).ValuePart.equals("{"))
                           {
                               if(ArrayList()==true)
                               {
                               }
                           }
                           
                          else
                           {  if(tokenset.get(i).ValuePart.equals("("))
                              {
                                  
                                  i++;
                                 
                                  if(C_list()==true)
                                  {
                                     
                                      String type2=type+"->"+cl;
                                      String Class=SA.lookupClass(type,"class");
                                   if(Class!=null)
                                      {
                                      String T_=SA.lookupClassData(type2, this.CurrentClass);
                                      if(T_==null)
                                      {
                                          System.out.println("xError cannot find constructor in class "+type);
                                      }
                                      
                                  }
                                  }
                                  if(tokenset.get(i).ValuePart.equals(")"))
                              {
                                  i++;
                                  }
                              }}
                              
        
        if(tokenset.get(i).ValuePart.equals(";"))
       {
          
           SA.insertclassData(name, type, AM, Static, Category, assigned, cclass,this.dimensionNo,this.arrdimension);
            this.arrdimension="";
      this.dimensionNo=0; 
           System.out.println("object declaration is valid at: "+tokenset.get(i).lineNo);
           i++;
           if(classBody()==true)
                   {
                      return true;
                  }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
           
       }
       }
                          }
                          else
                             
                              if(exp_assign(type)==true)
                              {
                                  
                            if(tokenset.get(i).ValuePart.equals(";"))
       {
            System.out.println("object declaration is valid at: "+tokenset.get(i).lineNo);
           i++;
           if(classBody()==true)
                   {
                      return true;
                  }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
           
       }       
                              }
                      }
             
       
                           if(!tokenset.get(i).ValuePart.equals("$"))
                           {
                               return true;
                           }
           }
           else
               if(tokenset.get(i).ValuePart.equals("="))
               {
                   String n=type;
                  type=SA.lookupClassData(n,this.CurrentClass);
                  if(type==null)
                  {
                      System.out.println("x Error at "+tokenset.get(i).lineNo+" cannot find symbol "+n);
                  }
                   i++;
                   if(exp_assign(type)==true)
                   {
                       if(tokenset.get(i).ValuePart.equals(";"))
       {
            System.out.println("object declaration is valid at: "+tokenset.get(i).lineNo);
           i++;
           if(classBody()==true)
                   {
                       this.resetValues();
                      return true;
                  }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
           
       }       
                   }
               }
   
       }
    }

    
       return false;
   
}
    

 public boolean func_decl_def() throws IOException
{


    if(keyword1()==true)
    {
       
        AM=tokenset.get(i).ValuePart;
        
        i++;
        
        
    }
if(tokenset.get(i).ValuePart.equals("abstract"))
{
    Category=tokenset.get(i).ValuePart;
    i++;
          if(tokenset.get(i).ValuePart.equals("void")||tokenset.get(i).ClassPart.equals("datatype")|| tokenset.get(i).ClassPart.equals("String"))
          {
              Type=tokenset.get(i).ValuePart;
              if(void_Dt()==true)
              {
                  
              if((tokenset.get(i).ClassPart.equals("ID")))
              {
                  Name=tokenset.get(i).ValuePart;
                  i++;
              if(tokenset.get(i).ValuePart.equals("("))
              { 
                  
                  SA.createScope();
                  i++;
                  String pl=null;
              if(Plist(Type,pl)==true)
              {
                 i++;
              }
             
              else{ if(tokenset.get(i).ValuePart.equals(")"))
                  {
                      i++;
                  }
              }
                      if(tokenset.get(i).ValuePart.equals(";"))
                      {
                       
                          SA.destroyScope();
                          SA.insertclassData(Name, Type, AM, Static, Category, assigned,this.CurrentClass,this.dimensionNo,this.arrdimension);
                          this.arrdimension="";
      this.dimensionNo=0;
                          System.out.println("abstract function definition grammar is valid at: "+tokenset.get(i).lineNo);
                          i++;
                      }
                      else
                           System.out.println("abstract function definition grammar is invalid at: "+tokenset.get(i).lineNo);
                  
                            if(classBody()==true)
                   {
                       this.resetValues();
                       return true;
                   }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
                      }       
                  }
              
          }   }
          }
      else
      
{
    if(tokenset.get(i).ValuePart.equals("static"))
    {
                     System.out.println("\n\n\nhumaaaaaaaaaaaaaa123333"+tokenset.get(i).ValuePart);
     Static="Yes";
        i++;
    }
}
       if(tokenset.get(i).ValuePart.equals("void"))
        {
            
            if(void_func()==true)
        {
            return true;
        }
        }
    
    else
    { 
        if(tokenset.get(i).ClassPart.equals("datatype")|| tokenset.get(i).ClassPart.equals("String"))
        {

            
            Type=tokenset.get(i).ValuePart;
            i++;
            
            
          if(single_arr(Type)==true)
          {
               if(classBody()==true)
                   {
                        
                       this.resetValues();
                       return true;
                   }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
          }
        }
        
    }
    
        return false;      
    }
        public boolean keyword1()
{
     if(tokenset.get(i).ValuePart.equals("public")||tokenset.get(i).ValuePart.equals("private")||tokenset.get(i).ValuePart.equals("protected"))  
  {
     
      return true;
  }
     return false;
}
        public boolean void_Dt()
        {
          if(tokenset.get(i).ValuePart.equals("void"))
           {    System.out.println("\n\n\nhumaaaaaaaaa851");
               
               i++;
               return true;
           }
          else
               if(tokenset.get(i).ClassPart.equals("datatype")|| tokenset.get(i).ClassPart.equals("String"))
        {
            i++;
           
            if(arr()==true)
            {
                return true;
            }
            else
                return true;
        }
          return false;
              
        }
        public boolean single_arr(String type) throws IOException
        {              
          if(arr()==true)
          {
                
          }
           
                    if(tokenset.get(i).ClassPart.equals("ID"))
           {
               Name=tokenset.get(i).ValuePart;
         
              
               i++;
            
                if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list(type)==true)
               {
               return true;
           }
           }
                else
                  if(tokenset.get(i).ValuePart.equals("("))
                  {
                      if(return_func(type)==true)
                      {
                          return true;
                      }
                  }
                      
                   
                else
                      
                       if(tokenset.get(i).ValuePart.equals("="))
           {
                 
               assigned="Yes";
             //   SA.insertclassData(Name, type, AM, Static, Category, assigned,CurrentClass);
               i++;

               if(tokenset.get(i).ValuePart.equals("new"))
                 {
                     i++;
                    
                if(tokenset.get(i).ClassPart.equals("datatype")||(tokenset.get(i).ClassPart.equals("String")))
                {
                    i++;
                
                    if(ArrayInit(type)==true)
                    {
                    
                  
                 if(tokenset.get(i).ValuePart.equals("{"))
           {
               if(ArrayList()==true)
               {
                   
               }
           }
                    
                   if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list(type)==true)
               {
               return true;
           }
           }
           }
                }
                 }
               else
                 if(exp(type)==true)
                 {
                     
                     if(this.parray.size()!=0)
                     {
              if(this.parray.get(0)!=null)
              {
                  if(!this.parray.get(0).equals(type))
                  {
                      
                   System.out.println("x Error: incompatible type at "+tokenset.get(i).lineNo);
                  }
                     }
                     }
                     this.parray.removeAll(parray);
                      if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list(type)==true)
               {
               return true;
           }
           }
                 }
           }
           }
          
                             
        return false;
                 
                    
              
        }
        
        public boolean list(String type) throws IOException
{
     
    if(tokenset.get(i).ValuePart.equals(";"))
{
   
        
      
       
      
    
    
    SA.insertclassData(Name, type, AM, Static, Category, assigned,this.CurrentClass,this.dimensionNo,this.arrdimension);
     this.arrdimension="";
      this.dimensionNo=0;
  System.out.println("declaration grammar is valid at:"+tokenset.get(i).lineNo);
 this.resetValues();
  i++;
  
    return true;
   
               }

    else
    if(tokenset.get(i).ValuePart.equals(","))
    {
       SA.insertclassData(Name, type, AM, Static, Category, assigned,this.CurrentClass,this.dimensionNo,this.arrdimension);  
        this.arrdimension="";
      this.dimensionNo=0; 
       assigned="No";
                i++;
        if(tokenset.get(i).ClassPart.equals("ID"))
    {
      
        Name=tokenset.get(i).ValuePart;
        i++;
        
       // if(arrlist()==true)
        if(ArrayInit(type)==true)
        {
            
        }
        if(tokenset.get(i).ValuePart.equals("="))
        {
            assigned="yes";
            
        if(init(type)==true)
        {
            
                return true;
            
        }
    }
      
    
    
    
        else
            if(tokenset.get(i).ValuePart.equals(",")|| tokenset.get(i).ValuePart.equals(";"))
            {
               System.out.println("my declaration"+tokenset.get(i).ValuePart);
                if(list(type)==true)
                {
                    return true;
                }
            } 
        
    }
    }
    //System.out.println("declration grammar is invalid at:"+tokenset.get(i).lineNo);
        return false;
    }
 
public boolean init(String type) throws IOException
{
    if(tokenset.get(i).ValuePart.equals("="))
    {
   
        i++;
      
        if(init2(type)==true)
        {
            return true;
        }
    }
    
    return false;
}

public boolean init2(String type) throws IOException
{
     if(tokenset.get(i).ClassPart.equals("new"))
     {
         i++;
         if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("String"))
         {
             i++; 
             if(tokenset.get(i).ValuePart.equals("("))
         {
          i++;
             if(C_list()==true)
             {
                
             }
             if(tokenset.get(i).ValuePart.equals(")"))
             {i++;
                  if(tokenset.get(i).ValuePart.equals(";")||(tokenset.get(i).ValuePart.equals(",")))
                   {
                       
                       if(list(type)==true)
                       {
                           return true;
                       }
                   }
                   }
         }
         }
     }
     else 
         
         if(exp(type)==true)
                       {
                      if(this.parray.size()!=0)
                     {
              
                  if(!this.parray.get(0).equals(type))
                  {
                      System.out.println("parray value"+this.parray.get(0));
                      System.out.println("type value"+type);
                   System.out.println("x Error: incompatible type at "+tokenset.get(i).lineNo);
                  }
                     }
                     this.parray.removeAll(parray);
                           if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
       {
           
           if(list(type)==true)
           {
               return true;
           }
       }
     else
           return false;
                          
                       }
                 
                   
     return false;
               
             
}
        public boolean Plist(String type,String pl)
        
        {
          
            if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
      {
       pl=pl+tokenset.get(i).ValuePart;
       
          i++;
         
           if(arr()==true)
           {
               
           }
           
          if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("args"))
      {  
          i++;
      
        if(tokenset.get(i).ValuePart.equals(","))
      
        {
      pl=pl+",";
         
            if(Plist2(type,pl)==true)
          {
              return true;
          }
        }
          else
           if(tokenset.get(i).ValuePart.equals(")"))
      {
          
          Type=pl+"->"+type;
          System.out.println(Type);
          return true;
      }
      }
      }
       return false;
      }

public boolean Plist2(String type,String pl)
{
  if(tokenset.get(i).ValuePart.equals(","))
      {
           
               
          i++;
         
          if(Plist(type,pl)==true)
          {
              return true;
          }
      }
  return false;
      }
         public boolean C_list() throws IOException
        {
            String type=""; 
            
             if((tokenset.get(i).ClassPart.equals("this"))||(tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant")))
         {
            
             if(exp(type)==true)
             {
               cl=this.parray.get(0);
                if(tokenset.get(i).ValuePart.equals(","))
                {
       cl=cl+",";
                i++;
                    if(C_list()==true)
                     {
                         return true;
                     }
                 }
                return true;
             }
         }
                 else
         if((tokenset.get(i).ClassPart.equals("new")))
                 {
                    
            i++;
            if((tokenset.get(i).ClassPart.equals("ID")))
                 {
                     
            i++;
           if(tokenset.get(i).ValuePart.equals("("))
                {
                 
                    i++;
                   if(C_list()==true)
                     {
                     }
                   if(tokenset.get(i).ValuePart.equals(")"))
                {
                   
                    i++;
                      if(tokenset.get(i).ValuePart.equals(","))
                {
                    
                i++;
                    if(C_list()==true)
                     {
                         return true;
                     }
                 }
                      return true;
                }
                }
                 }
                 }
                  
       
     return false;
                    }
        

  public boolean void_func() throws IOException
        {
            
             if(tokenset.get(i).ValuePart.equals("void"))
   {
       
 Type= tokenset.get(i).ValuePart;

       i++;
        
       if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("main"))
               {
                 Name=tokenset.get(i).ValuePart;
                   i++;
                   
                   if(tokenset.get(i).ValuePart.equals("("))
                   {
                        this.createScope();
                       i++;
                       if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
      {
          String pl="";
          //System.out.println(tokenset.get(i).ValuePart);
                         if(Plist(Type,pl)==true) 
                         {
                            
                            i++;
                         }
                   }
                       else
                       { if(tokenset.get(i).ValuePart.equals(")"))
                         {
                           
                                      i++;
                         }
                         }
                   }
                              }
                       if(tokenset.get(i).ValuePart.equals("{"))
                       {
                            SA.insertclassData(Name, Type, AM, Static, Category, assigned, this.CurrentClass,this.dimensionNo,this.arrdimension);
                            this.arrdimension="";
      this.dimensionNo=0;
                            i++;
                          
                         if(func_body()==true)
                         {
                             
                         }
                        // System.out.println(tokenset.get(i).ValuePart);
                          if(tokenset.get(i).ValuePart.equals("}"))
                       {  SA.destroyScope();
                          System.out.println("Function definition grammar is valid at:"+tokenset.get(i).lineNo);
                           i++;
                       }
                          else
                           System.out.println(" function definition grammar is invalid at: "+tokenset.get(i).lineNo);
                  
                            if(classBody()==true)
                   {
                       this.resetValues();
                       return true;
                   }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
                           
                  
               
                           
                       }
                         
                       
                       }
                     
 
                       
    return false;
}
  public boolean arr()
        {
            
       
              if(tokenset.get(i).ValuePart.equals("["))
           {
               
           dimensionNo=dimensionNo+1;
               i++; 
                 if(tokenset.get(i).ValuePart.equals("]"))
                     
                 
           {
               arrdimension=arrdimension+"[]";
                i++;
               this.dimension++;
               if(arr()==true)
               {
                  
           
                      
                           return true;
           }
               else 
                   return true;
           }
           }
                       return false;
                  }
                      
  public boolean return_func(String type) throws IOException
        {
           
                     if(tokenset.get(i).ValuePart.equals("("))
                   {
                     this.createScope();
                    System.out.println("my scope checking"+this.s.peek());
                       i++;
                       if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
      {
         String pl="";
                         if(Plist(type,pl)==true)
                         {
                            
                             i++;
                             
                         }
      }
                       else
                       { if(tokenset.get(i).ValuePart.equals(")"))
                         {
                             i++;
                          
                         }
                         }
                       if(tokenset.get(i).ValuePart.equals("{"))
                       {
                             SA.insertclassData(Name, Type, AM, Static, Category, assigned,this.CurrentClass,this.dimensionNo,this.arrdimension);
                            this.arrdimension="";
      this.dimensionNo=0;
                             i++;
                             
                           if(func_body()==true)
                           {
                               
                           }
                          if(tokenset.get(i).ValuePart.equals("return"))
                       { 
                         
                           i++;
                         
                         if(exp(type)==true)
                         {
                       
                             
                         }
                           
                            if(tokenset.get(i).ValuePart.equals(";"))
                       {
                           
                   i++;
                          if(tokenset.get(i).ValuePart.equals("}"))
                       {
                           this.destroyScope();
                         
                           System.out.println("Function definition grammar is valid at:"+tokenset.get(i).lineNo);
                           i++;
                       }
                          else
                          { System.out.println("function definition grammar is invalid at: "+tokenset.get(i).lineNo);
                          }
                           if(classBody()==true)
                   {
                        System.out.println("Semantic checking"+tokenset.get(i).ValuePart);
                      this.resetValues();
                       return true;
                   }
                   else
                       if(tokenset.get(i).ValuePart.equals("}"))
                       {
               return true;
                       }
                   
                       
                          
                       }
                       }
                       }
                   
                   }
    return false;
}
  public boolean func_body() throws IOException
  {
     
       if(MST()==true)
    {
        return true;
    }
return false;}
  
  public boolean MST() throws IOException
{
    if(SST()==true)
    {  System.out.println("object"+tokenset.get(i).ValuePart);
        if(MST()==true)
        {
            return true;
        }
        return true;
    }
return false;
}
  
  
  
  
  
  
  public boolean SST() throws IOException
{
    
 String T="";   
 
     /*if(tokenset.get(i).ClassPart.equals("ID"))
       {
           
                  
                
         
           i++;
           
             if(ArrayInit()==true)
           {
         
            }  
          
           if(tokenset.get(i).ClassPart.equals("INCDEC"))
           {
               i++;
               if(tokenset.get(i).ValuePart.equals(";"))
               {
                   i++;
                   return true;
               }
           }
           else
           if(tokenset.get(i).ValuePart.equals("="))
           {
             
              // i++;
               if(assign()==true)
               { 
                   if(tokenset.get(i).ValuePart.equals(";"))
             {
                    System.out.println("declaration grammar is valid at :"+tokenset.get(i).lineNo);
                 i++;
                   return true;
               }
           }
           }
           else
               if(tokenset.get(i).ClassPart.equals("AOP"))
               {
                  
    
    i++;
                   if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant")))
                   {
                       i++;
                       if(ArrayInit()==true)
                       {
                       }
                       
                       if(tokenset.get(i).ValuePart.equals(";"))
               {
                    i++;
                   return true;
               } 
               }
           }
           else
          
               
              if(func_object()==true)
        {
           
            return true;
        }       
       
       }
     else
     
          if(tokenset.get(i).ClassPart.equals("this"))
       {
           i++;
          
            if(check_func_decl()==true)
           {
               return true;
           }
       }
     
     
     else
*/           if(keyword1()==true)
             {
              AM=tokenset.get(i).ValuePart;   
                 i++;
             }   
         if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
         {
            T=tokenset.get(i).ValuePart;
                   i++;
           
             if(single_array(T)==true)
             {
                 return true;
             }
         }
     else
          
                  if(tokenset.get(i).ValuePart.equals("static")||tokenset.get(i).ValuePart.equals("final"))
                  {
                      i++;
                      if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
         {
             i++;
                      if(single_array(T)==true)
                      {
                          return true;
                      }
                      
                      }
             }
            if(tokenset.get(i).ValuePart.equals("while"))
            {
                //System.out.println("\n\n\n\nhuma123\n\n");
           if(While_st()==true)
           {
               return true;
           }
         }
    
     if(tokenset.get(i).ClassPart.equals("do"))
       {
             
           if(Do_While_st()==true)
           {
               return true;
           }
         }
      if(tokenset.get(i).ValuePart.equals("switch"))
       {
           
           if(switch_st()==true)
           {
               return true;
           }
         }
       if(tokenset.get(i).ValuePart.equals("if"))
       {
           
           if(if_else_st()==true)
           {
               return true;
           }
         }
     
     if(tokenset.get(i).ClassPart.equals("enum")){
           
    if(enumdec()==true)
        return true;    
   }  
         
         /*else
       if(tokenset.get(i).ClassPart.equals("Fore"))
       {
         
           if(Fore_st()==true)
           {
               return true;
           }
       }*/
                  return false;     
}
    public boolean single_array(String type) throws IOException
        {
             String T=" ";
         if(arr()==true)
         {
          T=type;    
         }
         
           
         if(tokenset.get(i).ClassPart.equals("ID"))
           {
               System.out.println("\t\t"+tokenset.get(i).ValuePart);
                String name=tokenset.get(i).ValuePart;
    
               i++;
                if(tokenset.get(i).ValuePart.equals(";"))
           {
              
               SA.insertfunctionData(name, T, AM, Static, this.s.peek(), assigned, cclass,this.dimensionNo,this.arrdimension);
         
                this.arrdimension="";
      this.dimensionNo=0;
               System.out.println("array declaration is valid at:"+tokenset.get(i).lineNo);
               i++;
               return true;
           }
           
                 
                   
                else
                      
                       if(tokenset.get(i).ValuePart.equals("="))
           {
                          assigned="Yes";
               i++;
                
                 if(tokenset.get(i).ClassPart.equals("new"))
                 {
                    
                     i++;
                        
                if(tokenset.get(i).ClassPart.equals("datatype")||(tokenset.get(i).ClassPart.equals("String")))
                {
                  String type2=tokenset.get(i).ValuePart;
                  if(!type.equals(type2))
                  {
                      System.out.println("x Error at "+tokenset.get(i).lineNo+" incompatible type");
                  }
                    i++;
                     
                    if(ArrayInit(type2)==true)
                    {
                     if(this.dimensionNo!=this.newdimension)
                     {
                      System.out.println("x Error at "+tokenset.get(i).lineNo+" "+this.dimensionNo+" dimensional array cannot  be converted to "+this.newdimension+" dimensional array");   
                     }
                        if(tokenset.get(i).ValuePart.equals("{"))
                        {
                            if(ArrayList()==true)
                            {
                            }
                        }
                          
           }
                   if(tokenset.get(i).ValuePart.equals(";"))
           {
                SA.insertfunctionData(name, T, AM, Static, this.s.peek(), assigned, cclass,this.dimensionNo,this.arrdimension);
              this.arrdimension="";
      this.dimensionNo=0;
                System.out.println("array  initialization is valid at:"+tokenset.get(i).lineNo);
               i++;
               return true;
           }
           
           }
                }
                 else
                     if(exp(type)==true)
                     {
                       if(tokenset.get(i).ValuePart.equals(";")||(tokenset.get(i).ValuePart.equals(","))) 
                       {
                           if(list(type)==true)
                           {
                               return true;
                           }
                       }
           
                  }
           }
           }
           
         
                                      
                             
        return false;
           }
    
    
    
    
    
    
  public boolean While_st() throws IOException
{
    
    if(tokenset.get(i).ValuePart.equals("while"))
    {
       
                
i++;
        if(tokenset.get(i).ClassPart.equals("("))
        {    
                i++;
                if(F3()==true)
                {
       
                    i++;
               if(tokenset.get(i).ValuePart.equals(")"))
               {
                   i++;
                   if(SST()==true)
                   { 
       
                       System.out.println("While Single Line Stetement is valid");
                   return true;
                   
                   }if(tokenset.get(i).ValuePart.equals("{"))
                  {
                      
                      i++;
                  if(SST()==true)
                  {  
                      if(tokenset.get(i).ValuePart.equals("}"))
                 {
            System.out.println("While Statement Grammar is valid at:"+tokenset.get(i).lineNo);
              i++;
              return true;
                 }
             
                }}
                 else
                     System.out.println("While Statement Grammar is invalid at:"+tokenset.get(i).lineNo);
               
                   
               
                    
                 }
                 
            }
            }
                }
            return false;
            }

public boolean Do_While_st() throws IOException
{
    if(tokenset.get(i).ValuePart.equals("do"))
    {
       
                
            i++;
                  if(tokenset.get(i).ValuePart.equals("{"))
                  {    
           i++;
           if(SST()==true)
                   {
                            
                            
        if(tokenset.get(i).ValuePart.equals("}"))
                       {
                        
                      
              i++;
                          // System.out.println(tokenset.get(i).ValuePart);
             if(tokenset.get(i).ValuePart.equals("while"))
    {
                
i++;
        if(tokenset.get(i).ClassPart.equals("("))
        {    
                i++;
                
                if(F3()==true)
                {
                    
                i++;
                
               if(tokenset.get(i).ValuePart.equals(")"))
               { 
               i++;
                   
               
                  if(tokenset.get(i).ValuePart.equals(";"))
                  {
                      
       
             i++;
                      System.out.println("Do While Statement Grammar is valid at:"+tokenset.get(i).lineNo);
                      return true;
              }
                else{
                    System.out.println("Do While Statement Grammar is invalid at"+tokenset.get(i).lineNo);
                  return false;}
               }
                }   }
    }
                       }
                   }
                  else{
                     
                  if(tokenset.get(i).ValuePart.equals("}"))
                          {
                          
                              i++;
              if(tokenset.get(i).ValuePart.equals("while"))
    {
       
                
        i++;
        if(tokenset.get(i).ClassPart.equals("("))
        {    
                i++;
                if(F3()==true)
                {
                    
                i++;
               if(tokenset.get(i).ValuePart.equals(")"))
               {
                           
               i++;
                  if(tokenset.get(i).ValuePart.equals(";"))
                  {
    i++;
                  System.out.println("Do While Statement Grammar is valid at"+tokenset.get(i).lineNo);
                  return true;
              }
              
                  else{
                    System.out.println("Do While Statement Grammar is invalid at:  "+tokenset.get(i).lineNo);
                  return false;}
               }}}
              
               }
}
}
}}
                 
                                    
            
    
                
            return false;
                          }
public boolean F3() throws IOException
    {
        String type1="";
        String type2="";
        String isAssigned;
         if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("integerConstant"))
            {

                if( tokenset.get(i).ClassPart.equals("ID"))
                     {
            String name=tokenset.get(i).ValuePart;
            
             if(forindex==true)
       {
           boolean Tindex=SA.Isint(name, this.CurrentClass);
       if(Tindex==true)
       {
           type1="int";
       }}
                       
                         System.out.println("\n\n"+name+"\t\t"+this.cclass+"\t\t"+tokenset.get(i).ValuePart+"\n\n");
            T1=SA.lookupClassData(name,this.cclass);
              isAssigned=SA.IsAssigned(name, type1, this.CurrentClass);
            if(isAssigned==null)
            {
                System.out.println("Error not Assigned value \t"+name);
            }
            else
                System.out.println("Assigned value \t"+name);
              if(T1==null)
            {
                System.out.println("Error not declared ID\t"+name);
            }
              else
                  System.out.println("declared ID\t"+name);
                     }
          
                i++;
                 if(tokenset.get(i).ClassPart.equals("=")||tokenset.get(i).ClassPart.equals("ROP")||tokenset.get(i).ClassPart.equals("LOP")||tokenset.get(i).ClassPart.equals("AOP")||(tokenset.get(i).ClassPart.equals("boolconstant")))
                {
                  
                    i++;
                     if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("integerConstant")))
                {
                    if( tokenset.get(i).ClassPart.equals("ID"))
                     {
            String name2=tokenset.get(i).ValuePart;
             if(forindex==true)
       {
           boolean Tindex=SA.Isint(name2, this.CurrentClass);
       if(Tindex==true)
       {
           type2="int";
       }}
            T1=SA.lookupClassData(name2,this.CurrentClass);
              isAssigned=SA.IsAssigned(name2, type2,this.CurrentClass);
            if(T1==null)
            {
                System.out.println("Error not declared ID\t\t"+name2);
            }
             else
            {
                this.parray.add(T1);
               
            }
            if(isAssigned==null)
            {
                System.out.println("Error not Assigned value ID\t\t"+name2);
            }
            
                }
                
                
                    return  true;
                }
                 
            }
                 return true;
            }
    return false;

        
}


 
public boolean enumdec() throws IOException{
 if(tokenset.get(i).ClassPart.equals("enum")){
         
        i++;
  if(tokenset.get(i).ClassPart.equals("ID")){
     
      
      
      
           String name=tokenset.get(i).ValuePart;
            String T=SA.lookupClassData(name, this.CurrentClass);
            if(T==null)
            {
                     SA.insertclassData(name, "enum", AM, Static, Category, assigned, this.CurrentClass,this.dimensionNo,this.arrdimension);
      }
            else
                System.out.println("x ERROR   Enum "+name+" is already existed");
              
      
      
      
        i++;

   if(tokenset.get(i).ClassPart.equals("{")){
      
        i++;
   
   if(IDlist()==true){
       System.out.println("enum declaration grammar is valid at"+tokenset.get(i).lineNo);
       return true;
   }
   else
        System.out.println("enum declaration grammar is invalid at"+tokenset.get(i).lineNo);
}
  }}
return false;
}

 
 public boolean IDlist()
{
    if(tokenset.get(i).ClassPart.equals("ID"))
      {  
          i++;
        if(tokenset.get(i).ValuePart.equals(","))
      
        {if(IDlist2()==true)
          {
            
              return true;
          }
        }
          else
           if(tokenset.get(i).ValuePart.equals("}"))
      {   
        i++;  
          return true;
      }
      }
      
          return false;
      }

public boolean IDlist2()
{
  if(tokenset.get(i).ValuePart.equals(","))
      {  
          i++;
          if(IDlist()==true)
          {
             
              return true;
          }
      }
  return false;
      }
public boolean switch_st() throws IOException
{
    if(tokenset.get(i).ClassPart.equals("switch"))
    {
        
       i++;
     if(tokenset.get(i).ClassPart.equals("("))
        {    
                i++;
                if(F3()==true)
                {

                    i++;
               if(tokenset.get(i).ValuePart.equals(")"))
               {
                   i++;
     if(tokenset.get(i).ValuePart.equals("{"))
               {
                   i++;
if(switch_body()==true){
    {
       
      if(tokenset.get(i).ValuePart.equals("}"))
               {
                   System.out.println("Switch statement is vaid at"+tokenset.get(i).lineNo);
                i++;
                   return true;
}
}}}}}}}
    
                   System.out.println("InValid Switch statement at"+tokenset.get(i).lineNo);
return false;}

public boolean switch_body() throws IOException{

 if(tokenset.get(i).ClassPart.equals("case"))
               {
                                 i++;
                   
 if((tokenset.get(i).ClassPart.equals("integerConstant"))||(tokenset.get(i).ClassPart.equals("floatconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))||(tokenset.get(i).ClassPart.equals("CharConstant"))||(tokenset.get(i).ClassPart.equals("ID")))
               {

                   i++;
                   if(tokenset.get(i).ValuePart.equals(":"))
               {
                   
                   i++;
                   
                   if(SST()==true){
                      
                  if(tokenset.get(i).ValuePart.equals("break"))
               {
        
                   i++;
                       if(tokenset.get(i).ValuePart.equals(";"))
                       {     
                  i++;
                   if(case_Body()==true){
                       i++;
                       
                       return true;}
                
                   return true;
               }
               }
                   return true;
                   }}}
 
 
                      
               }

return false;}
public boolean case_Body() throws IOException
{
   
        if(switch_body()==true){
      i++;
        return true;}
          else
           if(tokenset.get(i).ValuePart.equals("default"))
      {   
              
          i++;
           if(SST()==true){
                      
                       i++;
                   }
                  if(tokenset.get(i).ValuePart.equals("break"))
               {
                   i++;
                   
                       if(tokenset.get(i).ValuePart.equals(";"))
               {
                 
                 
          return true;}
      }
      }
      
          return false;
      }

public boolean if_else_st() throws IOException
{
    if(tokenset.get(i).ClassPart.equals("if"))
    {
      
                
i++;
        if(tokenset.get(i).ClassPart.equals("("))
        {    
                i++;
                if(F3()==true)
                {
                    
                i++;
               if(tokenset.get(i).ValuePart.equals(")"))
               {
                   i++;
                   if(MST()==true)
                   {
                   if(tokenset.get(i).ValuePart.equals("else"))
                   //{
              
             if(else_st()==true)
             {    System.out.println("If-Else Statement is valid at"+tokenset.get(i).lineNo);
             
           return true;
             }
                   return true;}
                   
                   else if(tokenset.get(i).ValuePart.equals("{"))
                   {
i++;
                    if(MST()==true)
                   {
                      
                   if(tokenset.get(i).ValuePart.equals("}"))
                   {

                       i++;
                                    
                   if(tokenset.get(i).ValuePart.equals("else"))
                   //{
             if(else_st()==true)
             {    System.out.println("If-Else Statement is valid at"+tokenset.get(i).lineNo);
           return true;
             }
                   return true;}
}                    
                   }
               }

//}
                   //else{
                        
}}}
   
return false;}
public boolean else_st() throws IOException{
    
    
 if(tokenset.get(i).ClassPart.equals("else"))
     
 {
     
  i++;
                   if(MST()==true)
                   { 
          return true;
                   }
                  
                                 else if(tokenset.get(i).ValuePart.equals("{"))
                   {
                    i++;
                    if(MST()==true)
                   {
                      
                   if(tokenset.get(i).ValuePart.equals("}"))
                   {

                       i++;
                       return true;}}}
                                    
         
 return false;}
return false;}


    
    
    
    
    
    
    
    
    
  public boolean ArrayInit(String type) throws IOException
        {
            
           
 if(tokenset.get(i).ValuePart.equals("["))
           {
          this.newdimension++;
          
               i++; 
               if(tokenset.get(i).ValuePart.equals("]"))
               {
                   System.out.println("x Error at "+tokenset.get(i).lineNo+" Array dimension is  missing");
               }
          forindex=true;
if(exp_assign("int")==true)
{
 /* if(this.parray.size()!=0)
                     {
              
                  if(!this.parray.get(0).equals(type))
                  {
                     
                   System.out.println("x Error: incompatible type at "+tokenset.get(i).lineNo);
                  }
                     }
                     this.parray.removeAll(parray);*/
   
if(tokenset.get(i).ValuePart.equals("]"))
           {
this.arrinitdimension=this.arrinitdimension+"[]";
               i++;

}
}
if(ArrayInit(type)==true)
{
   
 forindex=false;  
return true;
 
}
else
    forindex=false;
return true;
}


return false;
}
  
    public boolean exp_assign(String type) throws IOException
{
   if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("this"))||(tokenset.get(i).ClassPart.equals("("))|| (tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
  
   {
      
       if(T_assign(type)==true)
       {
            if(tokenset.get(i).ClassPart.equals("PM"))
    {
           if(assignE_(type)==true)
             {
               return true;
           }
       }
            else
            {
                return true;
            }
       } 
   }
   return false;
   }
    public boolean T_assign(String type) throws IOException
{
    if(F_assign(type)==true)
    {
       if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
        if(assignT_(type)==true)
        {
            return true;
        }
    }
       else
       {
           return true;
       }
    }
    return false;
}

public boolean assignT_(String type) throws IOException
{
    if(tokenset.get(i).ClassPart.equals("MDM"))
    {
        i++;
        if(F_assign(type)==true)
        {
           if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
            if(assignT_(type)==true)
            {
                return true;
            }
        }
           else
           {
               return true;
           }
    }
    }
    return false;
}

public boolean assignE_(String type) throws IOException
{
    if(tokenset.get(i).ClassPart.equals("PM"))
            {
                i++;
          if(T_assign(type)==true)
          {
               if(tokenset.get(i).ClassPart.equals("PM"))
    {
          if(assignE_(type)==true)
          {
              return true;
          }
          }
               else
               {
                   return true;
               }
          }
               }
            
    return false;
}

public boolean DOT_assign(String type) throws IOException
{
    if(tokenset.get(i).ValuePart.equals("."))
    {
        i++;
         if(tokenset.get(i).ClassPart.equals("ID"))
    {
        i++;
        if(ArrayInit(type)==true)
        {
        }
       else
            if(tokenset.get(i).ValuePart.equals("("))
            {
                i++;
                if(C_list()==true)
                {
                }
             if(tokenset.get(i).ValuePart.equals(")"))
            {
                i++;
            }
            }
       
    }
         if(tokenset.get(i).ValuePart.equals("."))
    {
        if(DOT_assign(type)==true)
        {
            return true;
        }
    }
        else
            if(tokenset.get(i).ClassPart.equals("PM")||tokenset.get(i).ClassPart.equals("MDM"))
            {
                i++;
                if(exp_assign(type)==true)
                {
                    return true;
                }
            }
            else{
                return true;
            }
    } 
    return false;
}
        public boolean F_assign(String type) throws IOException
{
    String isAssigned="";
    if(tokenset.get(i).ClassPart.equals("ID"))
        {
            String name=tokenset.get(i).ValuePart;
       if(forindex==true)
       {
           boolean Tindex=SA.Isint(name,this.CurrentClass);
       if(Tindex==true)
       {
           type="int";
       }}
       
            
            int scope=s.peek();
          
            
            if(scope==1)
            {
                
           T1=SA.lookupClassData(name,this.CurrentClass);
           isAssigned=SA.IsAssigned(name, type,this.CurrentClass);
           
          
            }
/*            if(isAssigned.equals("No"))
            {
            
                System.out.println("x Error:"+name+" is not assigned at "+tokenset.get(i).lineNo);
            }*/
                if(T1==null)
            {
                System.out.println("x Error:"+name+" Undeclared ID at "+tokenset.get(i).lineNo);
            }
        else
            {
                this.parray.add(T1);
               
            }
        
              
            i++;
               if(this.parray.size()==3)
              {
                  this.compatibility();
              } 
            if(ArrayInit(type)==true)
            {
                
            }
            if(tokenset.get(i).ValuePart.equals("."))
            {
                if(DOT_assign(type)==true)
                {
                   // return true;
                }
            }
             if(tokenset.get(i).ValuePart.equals("="))
       {
           if(assign(type)==true)
           {
               return true;
           }
       }
     else
           return true;
           
            
        }
        else
            if(tokenset.get(i).ClassPart.equals("this"))
            {
               i++;
                if(DOT_assign(type)==true)
                {
                    if(tokenset.get(i).ValuePart.equals("="))
       {
           if(assign(type)==true)
           {
               return true;
           }
       }
     else
           return true;
            }
            }
        else
              if((tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))||(tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
  
   {
       if((type.equals("String") && tokenset.get(i).ClassPart.equals("StringConstant"))|| (type.equals("char") && tokenset.get(i).ClassPart.equals("CharConstant"))||(type.equals("int") && tokenset.get(i).ClassPart.equals("integerConstant"))||(type.equals("float") && tokenset.get(i).ClassPart.equals("floatconstant"))||(type.equals("boolean") && tokenset.get(i).ClassPart.equals("boolconstant")))    
{
    
}
    else
{
    System.out.println("incompatible type at lineNo"+ tokenset.get(i).lineNo);
}
   
       i++;
      return true;
   }
        else
                  if(tokenset.get(i).ValuePart.equals("("))
                  {
                      i++;
                      if(exp_assign(type)==true)
                      {
                        if(tokenset.get(i).ValuePart.equals(")"))
                        {  
                            i++;
                            return true;
                        }
                      }
                  }
        return false;
}

public boolean assign(String type) throws IOException
{
     if(tokenset.get(i).ValuePart.equals("="))
     {
       
         i++;
          System.out.println("exp checking"+tokenset.get(i).ValuePart);
     
    if(tokenset.get(i).ClassPart.equals("new"))
     {
         i++;
         if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("String"))
         {
             i++; 
             if(tokenset.get(i).ValuePart.equals("("))
         {
          i++;
             if(C_list()==true)
             {
                
             }
             if(tokenset.get(i).ValuePart.equals(")"))
             {i++;
                  if(tokenset.get(i).ValuePart.equals(";"))
                   {
                       i++;
                           return true;
                       
                   }
                   }
         }
         }
     }
    /*else
     if(tokenset.get(i).ClassPart.equals("this"))
     {
         i++;
        
         if(tokenset.get(i).ValuePart.equals("."))
         { 
             if(check_func_decl()==true)
             {
               return true;  
             }
            
                   }
         }
     */
    else
       
         if(exp_assign(type)==true)
         {
      
            
               
                 return true;
             
             }
     }return false;
}

   public boolean singlearr()
  {
     return false; 
  }
   public boolean multiarr()
  {
     return false; 
  }
   

  public boolean ArrayList()
        {
              if(tokenset.get(i).ValuePart.equals("{"))
    {
          
        i++;
         
        if(singlearr()==true)
        {
            if(tokenset.get(i).ValuePart.equals("}"))
    {
        i++;
        return true;
        }
    }
        else
            if(tokenset.get(i).ValuePart.equals("{"))
    {
        if(multiarr()==true)
        {
             if(tokenset.get(i).ValuePart.equals("}"))
    {
        i++;
        return true;
        }
    }
       
}
    }
    return false;
}
  
 public boolean exp(String type) throws IOException
        {
            String operandtype=null;
            if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("this"))||(tokenset.get(i).ClassPart.equals("("))|| (tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
  
   {
       
       if(T(type,operandtype)==true)
       {
            if(tokenset.get(i).ClassPart.equals("PM"))
    {
           if(E_(type,operandtype)==true)
             {
               return true;
           }
       }
            else
            {
                return true;
            }
       } 
   }
    return false;
   }
 
 
 
 
 
 
 
 
 
     
            public boolean T(String type,String OperandType) throws IOException
{
    if(F(type,OperandType)==true)
    {
       this.T1=OperandType;
       
       if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
  
        if(T_(type,OperandType)==true)
        {
            return true;
        }
    }
       else
       {
           return true;
       }
    }
    return false;
}
public boolean T_(String type,String OperandType) throws IOException
{
    if(tokenset.get(i).ClassPart.equals("MDM")) 
    {
         this.parray.add(tokenset.get(i).ValuePart);
        i++;
        if(F(type,OperandType)==true)
        {
            this.T2=OperandType;
            
           
           if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
        
            if(T_(type,OperandType)==true)
            {
                return true;
            }
        }
           else
           {
               return true;
           }
    }
    }
    return false;
}
public boolean E_(String type,String OperandType) throws IOException
{
    if(tokenset.get(i).ClassPart.equals("PM"))
            {
                 this.parray.add(tokenset.get(i).ValuePart);
                plus=true;
                 this.T2=OperandType;
           
                i++;
          if(T(type,OperandType)==true)
          {
               if(tokenset.get(i).ClassPart.equals("PM"))
    {
          if(E_(type,OperandType)==true)
          {
              return true;
          }
          }
               else
               {
                   return true;
               }
          }
               }
            
    return false;
}
public boolean DOT(String type) throws IOException
{
     String isAssigned="";
     String name="";
   
    if(tokenset.get(i).ValuePart.equals("."))
    {
        i++;
         if(tokenset.get(i).ClassPart.equals("ID"))
    {
         name=tokenset.get(i).ValuePart;
         
            int scope=s.peek();
       
            if(scope!=1)
            {
           T1=SA.lookupFunctionData(name,scope,this.cclass);
    
            isAssigned=SA.IsAssignedFunc(name, T1, this.cclass,scope);
            }
            else
                
                T1=SA.lookupClassData(name,this.cclass);
            isAssigned=SA.IsAssigned(name, T1, cclass);
      
               if(T1==null)
        {
             System.out.println("x Error at line no "+tokenset.get(i).lineNo+" cannot find symbol "+name);
        }
  
            if(T1!=null)
            {
            if(isAssigned.equals("No"))
            {
                System.out.println("x Error at "+tokenset.get(i).lineNo+" "+name+"  ID is not assigned at ");
           
            }
            if(this.parray.size()==0)
            {
                this.parray.add(T1);
            }
            else
             this.parray.add(this.parray.size()-1, T1);
            }
            
              i++;
        if(ArrayInit(type)==true)
        {
            
        }
       else
            if(tokenset.get(i).ValuePart.equals("("))
            {
               
                i++;
                if(C_list()==true)
                {
                }
             if(tokenset.get(i).ValuePart.equals(")"))
            {
                i++;
            }
            }
       
    }
         if(tokenset.get(i).ValuePart.equals("."))
         {
       
        if(T1==null)
        {
             System.out.println("x Error at line no "+tokenset.get(i).lineNo+" cannot find symbol "+name);
        }
        else
            if(T1.startsWith("String")||T1.equals("char")||T1.equals("String")||T1.equals("int")||T1.equals("boolean"))
            {
                  System.out.println("x Error at line no "+tokenset.get(i).lineNo+" "+T1+" cannot be dereferenced");
            }
        else
        {
        if(SA.lookupClass(T1,"class")==null)
        {
         System.out.println("x Error at line no "+tokenset.get(i).lineNo+": cannot find class to be referenced");   
        }
        else
        {
          // this.parray.add(T1);
            this.cclass=T1;
           
        }
        }
        if(DOT(type)==true)
        {
            return true;
        }
    }
        
         
        else
            if(tokenset.get(i).ClassPart.equals("PM")||tokenset.get(i).ClassPart.equals("MDM"))
            {
                this.cclass=this.CurrentClass;
                i++;
                if(exp(type)==true)
                {
                    this.parray.add(T1);
                    return true;
                }
            }
            else{
                this.cclass=this.CurrentClass;
               //this.parray.add(T1);
                return true;
            }
         
    } 
    return false;
}
            
     
public boolean F(String type,String OperandType) throws IOException
{
    ;
   String isAssigned = "";
    if(tokenset.get(i).ClassPart.equals("ID"))
        {
          
        String name=tokenset.get(i).ValuePart;
         
           
            int scope=s.peek();
          
            
            if(scope==1)
            {
                
           T1=SA.lookupClassData(name,this.CurrentClass);
             
           isAssigned=SA.IsAssigned(name, T1,this.CurrentClass);
           
            
            }
            if(isAssigned.equals("No"))
            {
            
                System.out.println("x Error:"+name+" is not assigned at "+tokenset.get(i).lineNo);
            }
                if(T1==null)
            {
                System.out.println("x Error:"+name+" Undeclared ID at "+tokenset.get(i).lineNo);
            }
        else
            {
                this.parray.add(T1);
                OperandType=T1;
            }
            i++;
           /*   if(this.parray.size()==3)
              {
                  this.compatibility();
              }*/
            if(ArrayInit(type)==true)
            {
                
            }
            if(tokenset.get(i).ValuePart.equals("."))
            {
                
              
                if(DOT(type)==true)
                {
                   return true;
                }
            }
             if(tokenset.get(i).ValuePart.equals("="))
       {
           if(init(type)==true)
           {
               return true;
           }
       }
              if(this.parray.size()==3)
              {
                  this.compatibility();
              }
     else
           return true;
           
            
        }
        else
            if(tokenset.get(i).ClassPart.equals("this"))
            {
               
               i++;
              
                if(DOT(type)==true)
                {
                    if(tokenset.get(i).ValuePart.equals("="))
       {
           if(init(type)==true)
           {
               return true;
           }
       }
     else
           return true;
            }
            }
        else
              if((tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))||(tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
  
   {
if((type.equals("String") && tokenset.get(i).ClassPart.equals("StringConstant"))|| (type.equals("char") && tokenset.get(i).ClassPart.equals("CharConstant"))||(type.equals("int") && tokenset.get(i).ClassPart.equals("integerConstant"))||(type.equals("float") && tokenset.get(i).ClassPart.equals("floatconstant"))||(type.equals("boolean") && tokenset.get(i).ClassPart.equals("boolconstant")))    
{
    
}
    else
{
    System.out.println("incompatible type at lineNo"+ tokenset.get(i).lineNo);
}
    i++;

      return true;
   }
        else
                  if(tokenset.get(i).ValuePart.equals("("))
                  {
                      i++;
        
                      if(exp(type)==true)
                      {
                        if(tokenset.get(i).ValuePart.equals(")"))
                        {  
                            i++;
                            return true;
                        }
                      }
                  }
        return false;
}
public void compatibility()
{
    
    if(this.parray.size()==3)
    {
    String operator=this.parray.get(1);
     //System.out.println("compatibility issue"+operator);
    String type1=this.parray.get(0);
     //System.out.println("compatibility issue"+type1);
    String type2=this.parray.get(2);
     //System.out.println("compatibility issue"+type2);
    if(operator.equals("*")||operator.equals("/")||operator.equals("%"))
    {
        if((type1.equals("String")||type1.equals("char")||type1.equals("boolean"))||(type2.equals("String")||type2.equals("char")||type2.equals("boolean")))
        {
            System.out.println("x Error at "+tokenset.get(i).lineNo+": Bad operands,first operand="+type1+" 2nd operand="+type2);
        }
        else
        {
            if(!type1.equals(type2))
            {
                 System.out.println("x Error at "+tokenset.get(i).lineNo+": Incompatible types ,first operand="+type1+" 2nd operand="+type2);
            }
            else
                if(type1.equals(type2))
                {
                    
            this.parray.removeAll(parray);
            
            this.parray.add(type1);
           
            }}
        }
    
    else
    {
        if(operator.equals("+")||operator.equals("-"))
        {
            if(type1.equals("boolean")||type2.equals("boolean"))
            {
                 System.out.println("x Error at "+tokenset.get(i).lineNo+": Bad operands,first operand="+type1+" 2nd operand="+type2);
        }
            else
                if(operator.equals("+"))
                {
                    if(!type1.equals(type2))
                    {
             System.out.println("x Error at "+tokenset.get(i).lineNo+": Incompatible types ,first operand="+type1+" 2nd operand="+type2);
                       
                    }
                    else
                 if(type1.equals(type2))
                {      
                    this.parray.removeAll(parray);
            this.parray.add(type1);
                }}
            else
                {
                    if(((type1.equals("char"))||(type2.equals("char")))||((type1.equals("String"))||(type2.equals("String"))))
                            {
                                 System.out.println("x Error at "+tokenset.get(i).lineNo+": Bad operands,first operand="+type1+" 2nd operand="+type2);
                            }
                    else
                        if(!type1.equals(type2))
                    {
             System.out.println("x Error at "+tokenset.get(i).lineNo+": Incompatible types ,first operand="+type1+" 2nd operand="+type2);
                       
                    }
                    else
                            
                        
                    this.parray.removeAll(parray);
            this.parray.add(type1);
                }
            }
        }
   
}}
public void createScope() 
{
    


if(s.size==0)
{
   
  s.push(1);
 
 
}
else
{ s.push(this.s.peek()+1);

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







}