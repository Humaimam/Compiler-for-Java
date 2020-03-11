/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class SyntaxAnalyzer {
     TokenSet ts=new TokenSet();
 int i=0;
 int j=0;
   classification Classification=new classification();
   
     IdentifierClassification IC=new IdentifierClassification();
     ArrayList<TokenSet> tokenset=new ArrayList<>();
    
      
public SyntaxAnalyzer( ArrayList<TokenSet> tokenset)
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
public int S()
{
  
         if(this.tokenset.get(i).ValuePart.equals("public"))
         {
             i++;
             if(intf_class_func()==true)
             {
                
                 i++;
             }
         }
      else
              
            if(this.tokenset.get(i).ValuePart.equals("class"))
            {
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
          
              this.S();
          }        if(tokenset.get(i).ValuePart.equals("$"))
                    {
                        
                     return tokenset.get(i-1).lineNo;
                    
                
                
            }
    
    return -1;
}
public boolean intf_class_func()
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
public boolean class_def()
        
{
     if(this.tokenset.get(i).ValuePart.equals("class"))
            {
                i++;
                 if(this.tokenset.get(i).ClassPart.equals("ID"))
                {
                    i++;
                    if(this.tokenset.get(i).ValuePart.equals("extends"))
                    {
                    if(extend_def()==true)
                    {
                        
                    }
                }
                    
                        if(this.tokenset.get(i).ValuePart.equals("implements"))
                        {
                            
                            if(implement()==true)
                            {
                               
                               
                                
                            }
                        }
                    
                 if(tokenset.get(i).ValuePart.equals("{"))
        {
            i++;
             
             if(classBody()==true)
               {
                // System.out.println("yes");
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
public boolean extend_def()
{
    if(tokenset.get(i).ValuePart.equals("extends"))
   {   
      i++;
 if(this.tokenset.get(i).ClassPart.equals("ID"))
                {
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
    
public boolean extend_list()
{
    if(tokenset.get(i).ValuePart.equals(","))
    {
        i++;
         if(tokenset.get(i).ClassPart.equals("ID"))
             i++;
         
    {
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
    
 public boolean interface_st()
 {
        
            if(this.tokenset.get(i).ValuePart.equals("interface"))
            {
               
                i++;
                if(this.tokenset.get(i).ClassPart.equals("ID"))
                {
                   
                    i++;
              
               if(this.tokenset.get(i).ValuePart.equals("implements"))
                        {
                           
                            if(implement()==true)
                            {
                               
                                
                                
                            }
                        }
                     
                 if(tokenset.get(i).ValuePart.equals("{"))
        {
             
            i++;
             
             if(interfaceBody()==true)
               {
                // System.out.println("yes");
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
 
public boolean implement()
{
    if(tokenset.get(i).ValuePart.equals("implements"))
    {   i++;
    
     if(tokenset.get(i).ClassPart.equals("ID"))
    {   
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
public boolean interface_list()
{
    if(tokenset.get(i).ValuePart.equals(","))
    {
        i++;
        if(tokenset.get(i).ClassPart.equals("ID"))
    {
       
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
    if(keyword1()==true)
    {
         
        i++;
        
    }
if(tokenset.get(i).ValuePart.equals("abstract"))
{
    i++;
}
else
{ if(tokenset.get(i).ValuePart.equals("static")||tokenset.get(i).ValuePart.equals("final"))
    {
        i++;
    }}
          if(tokenset.get(i).ValuePart.equals("void")||tokenset.get(i).ClassPart.equals("datatype")|| tokenset.get(i).ClassPart.equals("String"))
          {
              if(void_Dt()==true)
              {
                  
          if(tokenset.get(i).ClassPart.equals("ID"))
          {
              i++;
          
              if(tokenset.get(i).ValuePart.equals("("))
              {   i++;
              if(Plist()==true)
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
                          System.out.println("prototype grammar is valid at: "+tokenset.get(i).lineNo);
                          i++;
                      }
                      else
                           System.out.println("prototype grammar is invalid at: "+tokenset.get(i).lineNo);
                  
                            if(interfaceBody()==true)
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
              
              }}   
          
  return false;  
}
    
//================== CLASS Body=======================////
public boolean classBody()
{
   
 
  /*  if(tokenset.get(i).ValuePart.equals("Fore"))
       {
           
           if(Fore_st()==true)
           {
               return true;
           }       }

    else*/
    if(tokenset.get(i).ValuePart.equals("public")||tokenset.get(i).ValuePart.equals("private")||tokenset.get(i).ValuePart.equals("protected")||tokenset.get(i).ValuePart.equals("abstract")||tokenset.get(i).ValuePart.equals("static")||tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ValuePart.equals("void")||  tokenset.get(i).ClassPart.equals("String"))
           {
             
               if(func_decl_def()==true)
               {
                  
                   return true;
               
           }
           }
    
    else
    {
         if(tokenset.get(i).ClassPart.equals("ID"))
       {
          
           i++;
           
         if(arr()==true)
         {
         }
           if(tokenset.get(i).ClassPart.equals("ID"))
           {
           
               i++;
               
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
                  else
                      if(tokenset.get(i).ValuePart.equals("="))
                      {
                          i++;
                          
                          if(tokenset.get(i).ClassPart.equals("new"))
                          {
                      i++;
                     
                      if(tokenset.get(i).ClassPart.equals("ID"))
                      {
                          i++;
                         
                          if(ArrayInit()==true)
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
                                  }
                                  if(tokenset.get(i).ValuePart.equals(")"))
                              {
                                  i++;
                                  }
                              }}
                              
        
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
                          else
                              if(exp_assign()==true)
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
                   i++;
                   if(exp_assign()==true)
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
   
       }
    }

    
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
public boolean singlearr()
{
    if(exp()==true)
    {
        
      if(tokenset.get(i).ValuePart.equals(","))
    {   
        i++;
        if(singlearr()==true)
        {
            return true;
        }
    }
      else
          return true;
    }
    return false;
}

public boolean multiarr()
{
     if(tokenset.get(i).ValuePart.equals("{"))
    {
        i++;
         
       
        if(singlearr()==true)
        {
         
        }
        
        
            if(tokenset.get(i).ValuePart.equals("}"))
    {
        i++;
        if(tokenset.get(i).ValuePart.equals(","))
        {
            i++;
            if(multiarr()==true)
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
public boolean ArrayInit()
{
     System.out.println("and exp checking"+tokenset.get(i).ValuePart);
 if(tokenset.get(i).ValuePart.equals("["))
           {
          
               i++; 
   System.out.println("rabbiya exp checking"+tokenset.get(i).ValuePart);         
if(exp_assign()==true)
{
 
   
if(tokenset.get(i).ValuePart.equals("]"))
           {
i++;
}
}
if(ArrayInit()==true)
{
return true;
}
else
return true;
}


return false;
}

//===================== SyntaxAnalyzer FOR DECLARATION=============================//
         public boolean arr()
                  {
                      
                       if(tokenset.get(i).ValuePart.equals("["))
           {
               i++; 
                 if(tokenset.get(i).ValuePart.equals("]"))
                     i++;
                 
           {
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
                       
                             
public boolean list()
{
     
    if(tokenset.get(i).ValuePart.equals(";"))
{
  System.out.println("declaration grammar is valid at:"+tokenset.get(i).lineNo);
    i++;
    System.out.println("my init"+tokenset.get(i).ValuePart);
    return true;
   
               }

    else
    if(tokenset.get(i).ValuePart.equals(","))
    {
        
        
                i++;
        if(tokenset.get(i).ClassPart.equals("ID"))
    {
        i++;
        System.out.println("my declaration"+tokenset.get(i).ValuePart);
       // if(arrlist()==true)
        if(ArrayInit()==true)
        {
            
        }
        if(tokenset.get(i).ValuePart.equals("="))
        {
        if(init()==true)
        {
            
                return true;
            
        }
    }
      
    
    
    
        else
            if(tokenset.get(i).ValuePart.equals(",")|| tokenset.get(i).ValuePart.equals(";"))
            {
               System.out.println("my declaration"+tokenset.get(i).ValuePart);
                if(list()==true)
                {
                    return true;
                }
            }
        
    }
    }
    //System.out.println("declration grammar is invalid at:"+tokenset.get(i).lineNo);
        return false;
    }
  
public boolean init()
{
    if(tokenset.get(i).ValuePart.equals("="))
    {
   
        i++;
      
        if(init2()==true)
        {
            return true;
        }
    }
    
    return false;
}

public boolean init2()
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
                        System.out.println("exp checking"+tokenset.get(i).ValuePart);
                       if(list()==true)
                       {
                           return true;
                       }
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
             if(check_func_decl_list()==true)
             {
                
                 return true;
                
             }
             
                
           
                 
                   }
         }
     
    else
     if(tokenset.get(i).ClassPart.equals("ID"))
     {
        
        
         i++;
        if(arrlist()==true) 
        {
            
        }
         if(tokenset.get(i).ValuePart.equals("."))
         { 
             if(check_func_decl_list()==true)
             {
                 return true;
             }
         }
         else
             if(tokenset.get(i).ValuePart.equals("="))
             {
                 if(init()==true)
                 {
                     return true;
                 }
             }
             else
                  if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
                   {
                     
                       if(list()==true)
                       {
                          
                           return true;
                       }
                   }
         
         else
          if(tokenset.get(i).ClassPart.equals("PM")|| tokenset.get(i).ClassPart.equals("MDM"))
          {
            System.out.println("check"+tokenset.get(i).ValuePart);
              if(exp_check()==true)
              {
                  return true;
              }
          }
     
         
          
     }
     
          else
          
               if((tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant")))
         
               {   i++;
        if(tokenset.get(i).ClassPart.equals("PM")|| tokenset.get(i).ClassPart.equals("MDM"))
          {
                 if(exp_check()==true)
              {
                 // System.out.println("declaration grammar is valid at:"+tokenset.get(i).lineNo);
                      return true;
                  }
          }
         
     else
               {
                   if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
                   {
                       if(list()==true)
                       {
                           return true;
                       }
                   }
               }
         }
     else
                   if(tokenset.get(i).ValuePart.equals("("))
                   {
                      
                       if(exp()==true)
                       {
                           return true;
                       }
                   }
     return false;
     
      */           
                 
      else 
         
         if(exp()==true)
                       {
                    
                           if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
       {
           
           if(list()==true)
           {
               return true;
           }
       }
     else
           return false;
                          
                       }
                 
                   
     return false;
               
             
}

public boolean exp_check()
{
     if(tokenset.get(i).ClassPart.equals("PM")|| tokenset.get(i).ClassPart.equals("MDM"))
          {
              i++;
            
              if(exp()==true)
              {
                 
                if(tokenset.get(i).ValuePart.equals(",")||tokenset.get(i).ValuePart.equals(";"))
                {
                    if(list()==true)
                    {
                
                 return true;
              
          
              }
          }
              }
          }
     return false;
              }

public boolean exp_check_assignment()
{
     if(tokenset.get(i).ClassPart.equals("PM")|| tokenset.get(i).ClassPart.equals("MDM"))
          {
              i++;
            
              if(exp()==true)
              {
                  System.out.println("write"+tokenset.get(i).ValuePart);
                if(tokenset.get(i).ValuePart.equals(";"))
                {
                    i++;
                
                 return true;
              
          
              }
          
              }
          }
     return false;
              }
    
    

//////////======================================SyntaxAnalyzer FOR FORE STATEMENT=========================//////
public boolean Fore_st() 
{
    if(tokenset.get(i).ClassPart.equals("Fore"))
    {
      
                
i++;
        if(tokenset.get(i).ValuePart.equals("("))
        {    
            
            i++;
        if(F1()==true)
        {
           
             if(tokenset.get(i).ValuePart.equals(":"))
            {
                i++;
             
            if(tokenset.get(i).ClassPart.equals("ID"))
            {
                i++;
                
                 if(tokenset.get(i).ValuePart.equals(":"))
            {
                i++;
                if(F2()==true)
                {
                    
                  if(tokenset.get(i).ValuePart.equals(":"))
            { 
                i++;
                if(exp()==true)
            {
                if(tokenset.get(i).ValuePart.equals(")"))
               {
                   i++;
                  if(tokenset.get(i).ValuePart.equals("{"))
                  {
                      i++;
                      if(func_body()==true)
                      {
                          
                      }
                  
                 if(tokenset.get(i).ValuePart.equals("}"))
                 {
            System.out.println("Fore Statement Grammar is valid at:"+tokenset.get(i).lineNo);
              i++;
              return true;
              
                 }
                 else
                     System.out.println("Fore Statement Grammar is invalid at:"+tokenset.get(i).lineNo);
               
              
               
                    
                 }
               }
            }
            }
                }
            }
            }
            }
        }
        }
    }
     
     return false;
}
public boolean F1()
{
      if(tokenset.get(i).ClassPart.equals("Datatype")||tokenset.get(i).ClassPart.equals("String"))
            {
                i++;
                if(tokenset.get(i).ClassPart.equals("ID"))
                {
                   
                    i++;
                    return true;
                            }
            }
      return false;
}
    public boolean F2()
    {
         if(tokenset.get(i).ClassPart.equals("ID"))
            {
              
                i++;
                 if(tokenset.get(i).ClassPart.equals("=")||tokenset.get(i).ClassPart.equals("AOP"))
                {
                    if(assign_st()==true)
                    {
                        return true;
                    }
                }
                 else
                 if(tokenset.get(i).ClassPart.equals("INCDEC"))
                {
        if(inc_dec()==true)
        {
            return true;
        }
                }
            }
       
    return false;}
        public boolean inc_dec()
        {
            
           
                if(tokenset.get(i).ClassPart.equals("INCDEC"))
                {
                    i++;
               
                    return true;
            }
                
            
        
             return false;
        
        }
      

        //============ function definition==========////
        public boolean func_decl_def()
{

    if(keyword1()==true)
    {
        i++;
        
    }
if(tokenset.get(i).ValuePart.equals("abstract"))
{
    i++;
          if(tokenset.get(i).ValuePart.equals("void")||tokenset.get(i).ClassPart.equals("datatype")|| tokenset.get(i).ClassPart.equals("String"))
          {
              if(void_Dt()==true)
              {
                  
              if((tokenset.get(i).ClassPart.equals("ID")))
              {i++;
              if(tokenset.get(i).ValuePart.equals("("))
              {   i++;
              if(Plist()==true)
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
                          System.out.println("abstract function definition grammar is valid at: "+tokenset.get(i).lineNo);
                          i++;
                      }
                      else
                           System.out.println("abstract function definition grammar is invalid at: "+tokenset.get(i).lineNo);
                  
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
              
          }   }
          }
      else
      
{
    if(tokenset.get(i).ValuePart.equals("static"))
    {
      
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
            i++;
             System.out.println("my exp checking"+tokenset.get(i).ValuePart);
            
          if(single_arr()==true)
          {
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
    
        return false;      
    }
        
        public boolean void_Dt()
        {
          if(tokenset.get(i).ValuePart.equals("void"))
           {   
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
        public boolean single_arr()
        {
          if(arr()==true)
          {
          }
           
                    if(tokenset.get(i).ClassPart.equals("ID"))
           {  
               i++;
            
                if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list()==true)
               {
               return true;
           }
           }
                else
                  if(tokenset.get(i).ValuePart.equals("("))
                  {
                      if(return_func()==true)
                      {
                          return true;
                      }
                  }
                      
                   
                else
                      
                       if(tokenset.get(i).ValuePart.equals("="))
           {
               i++;

               if(tokenset.get(i).ValuePart.equals("new"))
                 {
                     i++;
                    
                if(tokenset.get(i).ClassPart.equals("datatype")||(tokenset.get(i).ClassPart.equals("String")))
                {
                    i++;
                
                    if(ArrayInit()==true)
                    {
                  
                 if(tokenset.get(i).ValuePart.equals("{"))
           {
               if(ArrayList()==true)
               {
                   
               }
           }
                    
                   if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list()==true)
               {
               return true;
           }
           }
           }
                }
                 }
                 if(exp()==true)
                 {
                      if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list()==true)
               {
               return true;
           }
           }
                 }
           }
           }
          
                             
        return false;
                 
                    
              
        }
           public boolean slist()
           {
                if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
                {
                    
                    i++;
                  if(tokenset.get(i).ValuePart.equals(","))
                  {
                      i++;
                       
                      if(slist()==true)
                      {
                          return true;
                          
                      }
                  }
                  else
                      return true;
                }
                return false;
           }
           
           public boolean multi_arr()
                   
           {
                if(tokenset.get(i).ValuePart.equals("["))
           {
               
           i++;
           if(tokenset.get(i).ValuePart.equals("]"))
           {
               i++; 
                 if(tokenset.get(i).ClassPart.equals("ID"))
           {
               i++;
                 if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list()==true)
               {
               return true;
           }
           }
                 else
                      if(tokenset.get(i).ValuePart.equals("("))
                  {
                      if(return_func()==true)
                      {
                          return true;
                      }
                  }
                     
                 else
                       if(tokenset.get(i).ValuePart.equals("="))
           {
               i++;
                 if(tokenset.get(i).ValuePart.equals("new"))
                 {
                     i++;
                if(tokenset.get(i).ClassPart.equals("datatype")||(tokenset.get(i).ClassPart.equals("Striing")))
                {
                    i++;
                     if(tokenset.get(i).ValuePart.equals("["))
           {
               
           i++;
            if(tokenset.get(i).ClassPart.equals("integerConstant")||(tokenset.get(i).ClassPart.equals("ID")))
                {
           i++;
           if(tokenset.get(i).ValuePart.equals("]"))
           {
               i++; 
                 if(tokenset.get(i).ValuePart.equals("["))
           {
               
           i++;
            if(tokenset.get(i).ClassPart.equals("integerConstant")||(tokenset.get(i).ClassPart.equals("ID")))
                {
           i++;
           if(tokenset.get(i).ValuePart.equals("]"))
           {
               i++; 
                
           if(tokenset.get(i).ValuePart.equals("{"))
           {
               i++;
               if(mlist()==true)
               {
                   
               }
                if(tokenset.get(i).ValuePart.equals("}"))
           {
               i++;
           }
           }
                if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
           {
               if(list()==true)
               {
               return true;
           }
           }
               
           }
               
           }
          
           }
                }
           }
                }
                 }
           }
           }
           }
           }
           }
           return false;}
           
           
           public boolean mlist()
           {
               if(tokenset.get(i).ValuePart.equals("{"))
           {
               i++;
                if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
                {
                    i++;
                  if(tokenset.get(i).ValuePart.equals(","))
                  {
                      i++;
                      if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
                {
                    i++;
                      if(tokenset.get(i).ValuePart.equals("}"))
           {
               i++;
                     if(tokenset.get(i).ValuePart.equals(","))
                  {
                      i++;
                  
                      if(mlist()==true)
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

public boolean void_func()
{
   if(tokenset.get(i).ValuePart.equals("void"))
   {
      
       i++;
        
       if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("main"))
               {
                 
                   i++;
                   
                   if(tokenset.get(i).ValuePart.equals("("))
                   {
                       
                       i++;
                       if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
      {
          //System.out.println(tokenset.get(i).ValuePart);
                         if(Plist()==true) 
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
                           i++;
                          
                         if(func_body()==true)
                         {
                             
                         }
                        // System.out.println(tokenset.get(i).ValuePart);
                          if(tokenset.get(i).ValuePart.equals("}"))
                       {  
                          System.out.println("Function definition grammar is valid at:"+tokenset.get(i).lineNo);
                           i++;
                       }
                          else
                           System.out.println(" function definition grammar is invalid at: "+tokenset.get(i).lineNo);
                  
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
                     
 
                       
    return false;
}
public boolean return_func()
{
                   if(tokenset.get(i).ValuePart.equals("("))
                   {
                      
                       i++;
                       if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
      {
         
                         if(Plist()==true)
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
                          
                              
                           i++;
                           if(func_body()==true)
                           {
                              
                           }
                          if(tokenset.get(i).ValuePart.equals("return"))
                       { 
                          
                           i++;
                         if(exp()==true)
                         {
                            
                             
                         }
                           
                            if(tokenset.get(i).ValuePart.equals(";"))
                       {
                   i++;
                          if(tokenset.get(i).ValuePart.equals("}"))
                       {
                           System.out.println(tokenset.get(i).ValuePart);
                           System.out.println("Function definition grammar is valid at:"+tokenset.get(i).lineNo);
                           i++;
                       }
                          else
                           System.out.println("function definition grammar is invalid at: "+tokenset.get(i).lineNo);
                  
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
                   
                   }
    return false;
}

public boolean Plist()
{
      if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
      {
            i++;
           if(arr()==true)
           {
               
           }
           
          if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("args"))
      {  
          i++;
      
        if(tokenset.get(i).ValuePart.equals(","))
      
        {if(Plist2()==true)
          {
              return true;
          }
        }
          else
           if(tokenset.get(i).ValuePart.equals(")"))
      {   
          
          return true;
      }
      }
      }
       return false;
      }

public boolean Plist2()
{
  if(tokenset.get(i).ValuePart.equals(","))
      {  
          i++;
          if(Plist()==true)
          {
              return true;
          }
      }
  return false;
      }

public boolean exp()
{
   if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("this"))||(tokenset.get(i).ClassPart.equals("("))|| (tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
  
   {
       if(T()==true)
       {
            if(tokenset.get(i).ClassPart.equals("PM"))
    {
           if(E_()==true)
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
    
public boolean exp_assign()
{
   if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("this"))||(tokenset.get(i).ClassPart.equals("("))|| (tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant")))
  
   {
        System.out.println("exp checking"+tokenset.get(i).ValuePart);
       if(T_assign()==true)
       {
            if(tokenset.get(i).ClassPart.equals("PM"))
    {
           if(assignE_()==true)
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
    public boolean T_assign()
{
    if(F_assign()==true)
    {
       if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
        if(assignT_()==true)
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

public boolean T()
{
    if(F()==true)
    {
       if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
        if(T_()==true)
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
public boolean T_()
{
    if(tokenset.get(i).ClassPart.equals("MDM"))
    {
        i++;
        if(F()==true)
        {
           if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
            if(T_()==true)
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
public boolean assignT_()
{
    if(tokenset.get(i).ClassPart.equals("MDM"))
    {
        i++;
        if(F_assign()==true)
        {
           if(tokenset.get(i).ClassPart.equals("MDM"))
    {  
            if(T_()==true)
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
public boolean E_()
{
    if(tokenset.get(i).ClassPart.equals("PM"))
            {
                i++;
          if(T()==true)
          {
               if(tokenset.get(i).ClassPart.equals("PM"))
    {
          if(E_()==true)
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
public boolean assignE_()
{
    if(tokenset.get(i).ClassPart.equals("PM"))
            {
                i++;
          if(T_assign()==true)
          {
               if(tokenset.get(i).ClassPart.equals("PM"))
    {
          if(assignE_()==true)
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
public boolean arrlist()
{

                 if(tokenset.get(i).ValuePart.equals("["))
                     
                 
           {
               i++;
              if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("integerConstant"))
              {
                  i++;
              
           
                      
           {
                i++;
           
               
                 
               
                 if(tokenset.get(i).ValuePart.equals("["))
                 {i++;
                  if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("integerConstant"))
              {
                  i++;
                   if(tokenset.get(i).ValuePart.equals("]"))
                 {i++;
                 
                 
                 return true;
                 }
              }
                 }
                 
                  
                       else
                           return true;
           }
           }
           }
                       return false;
                  }
public boolean DOT_assign()
{
    if(tokenset.get(i).ValuePart.equals("."))
    {
        i++;
         if(tokenset.get(i).ClassPart.equals("ID"))
    {
        i++;
        if(ArrayInit()==true)
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
        if(DOT_assign()==true)
        {
            return true;
        }
    }
        else
            if(tokenset.get(i).ClassPart.equals("PM")||tokenset.get(i).ClassPart.equals("MDM"))
            {
                i++;
                if(exp_assign()==true)
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
                          
public boolean DOT()
{
    if(tokenset.get(i).ValuePart.equals("."))
    {
        i++;
         if(tokenset.get(i).ClassPart.equals("ID"))
    {
        
        i++;
        if(ArrayInit()==true)
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
        if(DOT()==true)
        {
            return true;
        }
    }
        else
            if(tokenset.get(i).ClassPart.equals("PM")||tokenset.get(i).ClassPart.equals("MDM"))
            {
                i++;
                if(exp()==true)
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
            
     
public boolean F()
{
    
    if(tokenset.get(i).ClassPart.equals("ID"))
        {
              
            i++;
              
            if(ArrayInit()==true)
            {
                
            }
            if(tokenset.get(i).ValuePart.equals("."))
            {
                if(DOT()==true)
                {
                   // return true;
                }
            }
             if(tokenset.get(i).ValuePart.equals("="))
       {
           if(init()==true)
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
                if(DOT()==true)
                {
                    if(tokenset.get(i).ValuePart.equals("="))
       {
           if(init()==true)
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
       i++;
      return true;
   }
        else
                  if(tokenset.get(i).ValuePart.equals("("))
                  {
                      i++;
                      if(exp()==true)
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
     
public boolean F_assign()
{
    
    if(tokenset.get(i).ClassPart.equals("ID"))
        {
              
            i++;
              
            if(ArrayInit()==true)
            {
                
            }
            if(tokenset.get(i).ValuePart.equals("."))
            {
                if(DOT_assign()==true)
                {
                   // return true;
                }
            }
             if(tokenset.get(i).ValuePart.equals("="))
       {
           if(assign()==true)
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
                if(DOT_assign()==true)
                {
                    if(tokenset.get(i).ValuePart.equals("="))
       {
           if(assign()==true)
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
       i++;
      return true;
   }
        else
                  if(tokenset.get(i).ValuePart.equals("("))
                  {
                      i++;
                      if(exp_assign()==true)
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

public boolean func_object()
{
   
    if(tokenset.get(i).ValuePart.equals("."))
    {
        
         if(check_func_decl()==true)
           {
               return true;
           }
    }
    else
        if(tokenset.get(i).ClassPart.equals("ID"))
    {
    
        if(Object_Decl()==true)
           {
              
               return true;
           }
    }
    else
            if(tokenset.get(i).ValuePart.equals("="))
            {
           
               i++;
               if(assign()==true)
               {
                   return true; 
               }
            }
    return false;
}
   
      public boolean check_func_decl_list()
      {
          if(tokenset.get(i).ValuePart.equals("."))
    {
        i++;
         System.out.println("what"+tokenset.get(i).ValuePart);
        if(tokenset.get(i).ClassPart.equals("ID"))
        {
            i++;

            if(tokenset.get(i).ValuePart.equals("("))
    { 
        i++;
        if(fun_calling()==true)
        {
            if(exp_check()==true)
            {
                
            }
            if(tokenset.get(i).ValuePart.equals(";"))
                              {
                                System.out.println("function calling is valid at: "+tokenset.get(i).lineNo);
                                  i++;
                                 
                                  
            return true;
        }
            else
            {
                if(tokenset.get(i).ValuePart.equals(","))
                {
                    if(list()==true)
                    {
                        return true;
                    }
                }
                    }
        }   else
                System.out.println("function calling is invalid at: "+tokenset.get(i).lineNo);
    
    }
            else
                  
                 if(arrlist()==true)
            {
                
            }
                if(tokenset.get(i).ValuePart.equals("="))
                 {
                     i++;
                    if(init()==true)
                    {
                        return true;
                    }
                }
            else
        if(tokenset.get(i).ValuePart.equals(";")||tokenset.get(i).ValuePart.equals(","))
        {
            if(list()==true)
            {
            
            return true;
        }
        }
            else
             if(tokenset.get(i).ValuePart.equals("."))
        {
             
            if(check_func_decl_list()==true)
            {
            return true;
        }}
          
             else
                 if(exp_check()==true)
                 {
                     if(tokenset.get(i).ValuePart.equals(",")||tokenset.get(i).ValuePart.equals(";"))
                     {
                         if(list()==true)
                         {
                         return true;
                     }}
                 }
               
                
        }
    }
    
    return false;   
          
      }
public boolean check_func_decl()
{
    if(tokenset.get(i).ValuePart.equals("."))
    {
        
                  
                
        i++;
        if(tokenset.get(i).ClassPart.equals("ID"))
        {
           
            i++;
           
           
             System.out.println("my variable"+tokenset.get(i).ValuePart);
            if(tokenset.get(i).ValuePart.equals("("))
    { 
        i++;
        if(fun_calling()==true)
        {
        
            if(tokenset.get(i).ValuePart.equals(";"))
                              {
                                System.out.println("function calling is valid at: "+tokenset.get(i).lineNo);
                                  i++;
                                 
                                  
            return true;
        }
        }   else
                System.out.println("function calling is invalid at: "+tokenset.get(i).lineNo);
    
    }
           
            
            
            else
                 if(ArrayInit()==true)
            {
                
            }
                if(tokenset.get(i).ValuePart.equals("="))
                 {
            
                    System.out.println("exp checking"+tokenset.get(i).ValuePart);
                 
                    if(assign()==true)
                    {
                        System.out.println("declaration grammar is valid at :"+tokenset.get(i).lineNo);
                  i++;
                        return true;
                    }
                }
            
             else   
            if(tokenset.get(i).ValuePart.equals(";"))
                 {
                     System.out.println("declaration grammar is valid at :"+tokenset.get(i).lineNo);
                 
                   i++;
                 return true;
        }          
            else
             if(tokenset.get(i).ValuePart.equals("."))
        {
            if(check_func_decl()==true)
            {
            return true;
        }}
         else
                 if(exp_check_assignment()==true)
                 {
                     
                         return true;
                     
                 }
                     }
                 }
       
    
    return false;
}

public boolean assign()
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
       
         if(exp_assign()==true)
         {
      
            
               
                 return true;
             
             }
     }return false;
         
    /* if(tokenset.get(i).ClassPart.equals("ID"))
     {
       
         i++;
         if(arrlist()==true)
         {
             
         }
         if(tokenset.get(i).ClassPart.equals("INCDEC"))
     {
         i++;
         if(tokenset.get(i).ValuePart.equals(";"))
         {
             i++;
         }
     }
        
            
             else
         if(tokenset.get(i).ValuePart.equals("."))
         { 
             if(check_func_decl()==true)
             {
                 return true;
             }
            
         }
         else
          if(tokenset.get(i).ClassPart.equals("PM")|| tokenset.get(i).ClassPart.equals("MDM"))
          {
            
              if(exp_check()==true)
              {
                  return true;
              }
          }
     
          else
          
              if(tokenset.get(i).ValuePart.equals("="))
              {
                 i++;
        
                  if(assign()==true)
                  {
                    return true;
                  }
              
           
          else
              if(tokenset.get(i).ValuePart.equals(";"))
                   {
                    
                    if(list()==true)
                       {
                           
                           return true;
                       }
                   }
          
     }}
     
          else
          
               if((tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals("integerConstant"))|| (tokenset.get(i).ClassPart.equals("floatconstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant")))
         
               {   i++;
        if(tokenset.get(i).ClassPart.equals("PM")|| tokenset.get(i).ClassPart.equals("MDM"))
          {
                 if(exp_check()==true)
              {
                      return true;
                  }
          }
         
     else
               {
                   if(tokenset.get(i).ValuePart.equals(";"))
                   {
                       if(list()==true)
                       {
                           return true;
                       }
                   }
               }
         }
     else
                   if(tokenset.get(i).ValuePart.equals("("))
                   {
                      
                       if(exp()==true)
                       {
                           return true;
                       }
                   }
     return false;
     
                 
      */           
}
  public boolean assign_st()
        {
            
                if(tokenset.get(i).ClassPart.equals("="))
                {
                    i++;
                     if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("integerConstant"))
            {
                i++;
                return true;
                
            }
                }
            
        return false;}
    public boolean single_array()
        {
         if(arr()==true)
         {
         }
           
         if(tokenset.get(i).ClassPart.equals("ID"))
           {
                
               i++;
           
                if(tokenset.get(i).ValuePart.equals(";"))
           {
               System.out.println("array declaration is valid at:"+tokenset.get(i).lineNo);
               i++;
               return true;
           }
           
                 
                   
                else
                      
                       if(tokenset.get(i).ValuePart.equals("="))
           {
                          
               i++;
                
                 if(tokenset.get(i).ClassPart.equals("new"))
                 {
                    
                     i++;
                        
                if(tokenset.get(i).ClassPart.equals("datatype")||(tokenset.get(i).ClassPart.equals("String")))
                {
                  
                    i++;
                     
                    if(ArrayInit()==true)
                    {
                          
                        if(tokenset.get(i).ValuePart.equals("{"))
                        {
                            if(ArrayList()==true)
                            {
                            }
                        }
                          
           }
                   if(tokenset.get(i).ValuePart.equals(";"))
           {
             System.out.println("array  initialization is valid at:"+tokenset.get(i).lineNo);
               i++;
               return true;
           }
           
           }
                }
                 else
                     if(exp()==true)
                     {
                       if(tokenset.get(i).ValuePart.equals(";")||(tokenset.get(i).ValuePart.equals(","))) 
                       {
                           if(list()==true)
                           {
                               return true;
                           }
                       }
           
                  }
           }
           }
         
                             
        return false;
                 
                    
              
         }
  public boolean multi_Array()
  {
   if(tokenset.get(i).ValuePart.equals("["))
           {
               
           i++;
           if(tokenset.get(i).ValuePart.equals("]"))
           {
               i++; 
                 if(tokenset.get(i).ClassPart.equals("ID"))
           {
               i++;
                 if(tokenset.get(i).ValuePart.equals(";"))
           {
               System.out.println("multi dimensional array declaration is valid at :"+tokenset.get(i).lineNo);
               i++;
               return true;
           
           }
                 
                     
                 else
                       if(tokenset.get(i).ValuePart.equals("="))
           {
               i++;
                 if(tokenset.get(i).ValuePart.equals("new"))
                 {
                     i++;
                if(tokenset.get(i).ClassPart.equals("datatype")||(tokenset.get(i).ClassPart.equals("String")))
                {
                    i++;
                     if(tokenset.get(i).ValuePart.equals("["))
           {
               
           i++;
            if(tokenset.get(i).ClassPart.equals("integerConstant")||(tokenset.get(i).ClassPart.equals("ID")))
                {
           i++;
           if(tokenset.get(i).ValuePart.equals("]"))
           {
               i++; 
                 if(tokenset.get(i).ValuePart.equals("["))
           {
               
           i++;
            if(tokenset.get(i).ClassPart.equals("integerConstant")||(tokenset.get(i).ClassPart.equals("ID")))
                {
           i++;
           if(tokenset.get(i).ValuePart.equals("]"))
           {
               i++; 
                
           if(tokenset.get(i).ValuePart.equals("{"))
           {
               i++;
               if(mlist()==true)
               {
                   
               }
                if(tokenset.get(i).ValuePart.equals("}"))
           {
               i++;
           }
           }
                if(tokenset.get(i).ValuePart.equals(";"))
           {
                System.out.println("multi dimensional array initialization is valid at :"+tokenset.get(i).lineNo);
               i++;
               return true;
           
           }
               
           }
               
           }
          
           }
                }
           }
                }
                 }
           }
           }
           }
           }
           }
           return false;}
              
  
  
public boolean SST()
{
    
     if(tokenset.get(i).ClassPart.equals("ID"))
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
           if(keyword1()==true)
             {
                 i++;
             }   
         if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
         {
            
                   i++;
           
             if(single_array()==true)
             {
                 return true;
             }
         }
     else
          if(keyword1()==true)
             {
                 i++;
             } 
                  if(tokenset.get(i).ValuePart.equals("static")||tokenset.get(i).ValuePart.equals("final"))
                  {
                      i++;
                      if(tokenset.get(i).ClassPart.equals("datatype")||tokenset.get(i).ClassPart.equals("String"))
         {
             i++;
                      if(single_array()==true)
                      {
                          return true;
                      }
                      
                      }
             }
         
         else
       if(tokenset.get(i).ClassPart.equals("Fore"))
       {
         
           if(Fore_st()==true)
           {
               return true;
           }
       }
                   if(tokenset.get(i).ValuePart.equals("while"))
       {
           
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
    return false;     
}

public boolean MST()
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

public boolean Object_Decl()
{
    String class_name;
   
        
   
         
        if(tokenset.get(i).ClassPart.equals("ID"))
                {
            
                     
                      i++;
                    
              
        if(tokenset.get(i).ValuePart.equals("="))
        {
            i++;
             
            if(tokenset.get(i).ClassPart.equals("new"))
            {   
                i++;
            
            if(tokenset.get(i).ClassPart.equals("ID"))
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
                        }
                     }
                }
            }
            }
        
                 
                    if(tokenset.get(i).ValuePart.equals(";"))
                    {
                         System.out.println("object declaration is valid at: "+tokenset.get(i).lineNo);
                     i++; 
                      return true;  
                    }
                        
                    }
       
                
            
   
                        
        return false;
        
        
    }



public boolean C_list()
{
      
     if((tokenset.get(i).ClassPart.equals("this"))||(tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("boolconstant"))||(tokenset.get(i).ClassPart.equals("StringConstant"))|| (tokenset.get(i).ClassPart.equals(" if(tokenset.get(i).ValuePart.equals(\"while\"))\n" +
"       {\n" +
"           \n" +
"           if(While_st()==true)\n" +
"           {\n" +
"               return true;\n" +
"           }\n" +
"         }\n" +
"    \n" +
"     if(tokenset.get(i).ClassPart.equals(\"do\"))\n" +
"       {\n" +
"             \n" +
"           if(Do_While_st()==true)\n" +
"           {\n" +
"               return true;\n" +
"           }\n" +
"         }\n" +
"     \n" +
"     if(tokenset.get(i).ClassPart.equals(\"enum\")){\n" +
"           \n" +
"    if(enumdec()==true)\n" +
"        return true;    \n" +
"   }  "))|| (tokenset.get(i).ClassPart.equals("floatconstant"))|| (tokenset.get(i).ClassPart.equals("CharConstant")))
         {
            
             if(exp()==true)
             {
               
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

  public boolean fun_calling()
  {
     
           /* if(tokenset.get(i).ValuePart.equals("."))
            {
                i++;
                if(tokenset.get(i).ClassPart.equals("ID"))
                
                    i++;
                   
                   
                    
                      if(tokenset.get(i).ValuePart.equals("("))
                              {
                              i++; */   
                                  
                   if(C_list()==true)
                   {
                       
                   }
                              if(tokenset.get(i).ValuePart.equals(")"))
                              {
                                  i++;
                                  return true;
                                   //if(tokenset.get(i).ValuePart.equals(";"))
                              //{
                                //   System.out.println("function calling is valid at: "+tokenset.get(i).lineNo);
                                  //i++;
                                  //return true;
                              
                              }
                              
      return false;
  }
  
  public boolean func_body()
{
    
    if(MST()==true)
    {
        return true;
    }
return false;}


  public boolean While_st()
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
                  if(MST()==true)
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

public boolean Do_While_st()
{
    if(tokenset.get(i).ValuePart.equals("do"))
    {
       
                
            i++;
                  if(tokenset.get(i).ValuePart.equals("{"))
                  {    
           i++;
           if(MST()==true)
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
public boolean F3()
    {
         if(tokenset.get(i).ClassPart.equals("ID")||tokenset.get(i).ClassPart.equals("integerConstant"))
            {
           
                i++;
                 if(tokenset.get(i).ClassPart.equals("=")||tokenset.get(i).ClassPart.equals("ROP")||tokenset.get(i).ClassPart.equals("LOP")||tokenset.get(i).ClassPart.equals("AOP")||(tokenset.get(i).ClassPart.equals("boolconstant")))
                {
                  
                    i++;
                     if((tokenset.get(i).ClassPart.equals("ID"))||(tokenset.get(i).ClassPart.equals("integerConstant")))
                {
                
          
                    return  true;
                }
                 
            }
                 return true;
            }
    return false;

        
}


 
public boolean enumdec(){
 if(tokenset.get(i).ClassPart.equals("enum")){
         
        i++;
  if(tokenset.get(i).ClassPart.equals("ID")){
     
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
public boolean switch_st()
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

public boolean switch_body(){

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
public boolean case_Body()
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

public boolean if_else_st()
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
public boolean else_st(){
    
    
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


}



       