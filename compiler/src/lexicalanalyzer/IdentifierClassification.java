  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 */
public class IdentifierClassification  {
   
   char[] operators=new char[]{'+','-','*','/','%','&','|','!','<','>','='};
   char[] punctuator=new char[]{'.',',',':','(',')','{','}',';','?','[',']'};
   classification Classification=new classification();
String Class="";
boolean a=false,opr=false,punc=false,flag2=false,flag1=false;

 ArrayList<TokenSet> tokenset=new ArrayList<>();

// operator checking=======================///
   public boolean isOperator(char o)
   {
       for(int i=0;i<operators.length;i++)
       {
           if(o==operators[i])
                   {
                    return true;   
                   }
          
   }
   return false;
   
       }
   
   ///////===============FILING===================================////
   public void TokenSetFile(TokenSet ts) throws IOException
   {        FileWriter fw = new FileWriter("TokenSet.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    try (PrintWriter writer = new PrintWriter(bw)) {
                        writer.println();
                        writer.append("{"+ts.ClassPart+","+ts.ValuePart+","+ts.lineNo+"}");
                         tokenset.add(ts);
       }
   }
 //////////===============PUNCTUATOR CHECKING===================////
    public boolean isPunctuator(char p)
   {
       for(int i=0;i<punctuator.length;i++)
       {
           if(p==punctuator[i])
                   {
                    return true;   
                   }
          
   }
   return false;
   
       }
    //////////===================INTEGER CHECKING============/////
    /*  public boolean isInteger(char[] arr,int index)
   {
       StringBuilder sb=new StringBuilder(2);
       sb.append(arr[index]);
       sb.append(arr[index+1]);
      String pattern="[+-]?[0-9]+";
      Pattern p;
      Matcher m;
      p=Pattern.compile(pattern);
      m=p.matcher(sb.toString());
           if(m.matches())
                   {
                    return true;   
                   }
          
   else
   return false;
   
       }
*/
      ///////////===========STRING PATTERN CHECKING=====================/////
         public boolean checkPattern(char[] arr,int index)
  {
      if(index+1<arr.length)
      {
          String pattern="\\\\\\\\|\\\\[rbtno'\\\"]";
                StringBuilder sb=new StringBuilder(2);
  
                        sb.append(arr[index]);
                        sb.append(arr[index+1]);
                        Matcher m;
                        Pattern p;
                       p=Pattern.compile(pattern);
                        m=p.matcher(sb.toString());   
       if(m.matches())
       {
           System.out.println(sb.toString());
        return true;
  }
      }
   return false; 
}
         
   /////////========= MAIN FUNCTION===================//////
    public void lexicalAnalyzer() throws IOException
    {
     ArrayList<String> myArray=new ArrayList();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"source.txt"));
			String line = null;
			int i=1;
			myArray.add(reader.readLine());
			while ((line = reader.readLine()) != null) {
				
                                myArray.add(line);
                        }
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
for(int i=0;i<myArray.size();i++)
{
    

		System.out.println("Line"+ i+": "+myArray.get(i));
	
}
 WordBreaker(myArray);

}
    /////////=============WORD BREAKER==============================//////
   // public void WordBreaker(ArrayList<String> myArray) throws IOException
 public void WordBreaker(ArrayList<String> myArray) throws IOException
    {
        
        ArrayList<Character> temp = new ArrayList<>();  
        ArrayList<Character> temp1 = new ArrayList<>();  
        
        String word;
    char current;
        char[] arr;
      for(int i=0;i<myArray.size();i++)  
      {
           arr = myArray.get(i).toCharArray();
            for (int j = 0; j < arr.length; j++) {
                current = arr[j];
        
     if((arr[j]=='.')&&(Character.isDigit(arr[j+1]))){
    if(j-1>=0)
if((arr[j-1]=='+')||(arr[j-1]=='-')){
temp1.add(arr[j-1]);
flag2=true;}
current=arr[j];
temp1.add(current);


j++;
current=arr[j];
if(Character.isDigit(current)){
temp1.add(current);
j++;
current=arr[j];
if((j)!=arr.length)
while(Character.isDigit(current))
{temp1.add(current);
j++;
current=arr[j];
}if((j)!=arr.length)
if(j+1!=arr.length)
if((current=='e')||(current=='E')){
temp1.add(current);
j++;
current=arr[j];
if(Character.isDigit(arr[j+1]))
if((current=='+')||(current=='-')){
    
        temp1.add(current);
    j++;
    current=arr[j];
flag1=true;}

    if(Character.isDigit(current)){
        
 while(Character.isDigit(current))
{
    if(j!=arr.length){
temp1.add(current);
        j++;
current=arr[j];


}
}}
    else
        break;}
while((j!=arr.length))
{
if(j!=arr.length){
current=arr[j];
if(!(isOperator(current))&&((!isPunctuator(current))))
temp1.add(arr[j]);
else if(isOperator(current)||(isPunctuator(current))){
    
    if((j+1!=arr.length)&&((!Character.isDigit(arr[j+1])||(arr[j+1]!='.')))){
    opr=Operator(current,arr[j+1],i);
    punc=punctuator(current, arr[j+1], i);
    j--;
    break;}
}
System.out.println("\n");

j++;


}
else
break;
}


    

word=ToString(temp1, i);
floatConstant(word, i);
temp1=new ArrayList<>();
a=punctuator(current,' ', i);
 if(a)
     break;
 

}
}
else
if(Character.isDigit(current)){
if(j-1>=0)
if((arr[j-1]=='+')||(arr[j-1]=='-')){
temp1.add(arr[j-1]);}
current=arr[j];


while(Character.isDigit(current))
{
    System.out.println(current+"\n");
temp1.add(current);
 j++;
if(j!=arr.length){
current=arr[j];
}
}

if(current=='.'){
current=arr[j];
temp1.add(current);
if(j+1!=arr.length)
j=j+1;
current=arr[j];

if(Character.isDigit(current)){
   
while(Character.isDigit(current)&&(j!=arr.length))
{temp1.add(current);
if(j+1!=arr.length)
{j=j+1;
current=arr[j];
}
else break;}

if((j)!=arr.length)
if(j+1!=arr.length)
if((current=='e')||(current=='E')){
temp1.add(current);
j++;
if(j!=arr.length)
current=arr[j];
    if((current=='+')||(current=='-')){
     
    
        temp1.add(current);
        j++;
        current=arr[j];
   }
if(Character.isDigit(current))

    while((j!=arr.length))
{
if(j!=arr.length){
current=arr[j];
if((!isOperator(current))&&((!isPunctuator(current))))
{temp1.add(arr[j]);
System.out.println("\n");
j=j+1;
}
else
{    
if((j+1!=arr.length)&&(!Character.isDigit(arr[j+1])&&(arr[j+1]!='.'))){
    
    opr=Operator(current,arr[j+1],i);
    punc=punctuator(current, arr[j+1], i);
    if(opr||punc){
        break;}
    else{
    j--;
    break;}}
break;}

}
else
break;

}

}    }
while((j!=arr.length))
{
if(j!=arr.length){
current=arr[j];
if((!isOperator(current))&&((!isPunctuator(current))))
{
  
    temp1.add(arr[j]);
}
else if(isOperator(current)||(isPunctuator(current))){
   
    if((j+1!=arr.length)&&(!Character.isDigit(arr[j+1])&&(arr[j+1]!='.'))){
    opr=Operator(current,arr[j+1],i);
    punc=punctuator(current, arr[j+1], i);
    if(opr||punc){
        break;}
    else{
    j--;
    break;}}
}
System.out.println("\n");




}
else
break;
j++;}}


word=ToString(temp1, i);
floatConstant(word, i);
temp1=new ArrayList<>();
 a=punctuator(current,' ', i);
 if(a)
     break;
 
}

else           
               
                
                
                
                
                ///========= FOR SPACE================////
                if(current==' ')
                {
                   word= ToString(temp,i);
                    checkIdentifier(word, i); 
                  //    boolean signcheck=checkIntegerConstant(word, i,j,arr); 
                    temp = new ArrayList<>();
                }
                
                ///=====================FOR INTEGER================////
               /* else
                    if(isInteger(arr,j)==true || current=='+' || current=='-')
{
temp.add(current);
while(isInteger(arr,j)==true)
{
temp.add(current);
int index=j+1;
if(j<arr.length)
{
temp.add(current);

temp=new ArrayList<>();
} 
else
break;
}
word=ToString(temp,i);
checkIntegerConstant(word,i);
}
*/
            ///////////============ COMMENT LOGIC==================/////////////////////
                else
                 if(arr[j]=='/')
         {
             if(j+1<arr.length)
             {
             if(arr[j+1]=='/')
             {
                 j=arr.length-1;
             }
             
             else
                 if(arr[j+1]=='*')
                 {
                    int index=j+2;
                    if(index>=arr.length)
                    {
                      i++;
                      arr=myArray.get(i).toCharArray();
                      j=0;index=0;
                    }
                     
                     while(index<arr.length)
                     {
                      if(arr[index]=='*' && arr[index+1]=='/')
                      {
                          break;
                      }
                      else
                          index++;
                          j=index;
                      if(index+1==arr.length)
                      {
                          i++;
                          arr=myArray.get(i).toCharArray();
                          j=0;
                          index=0;
                          continue;
                      }
                     }
                     }
                     
                 }
                      }        
                                                         
            ///////====================== FOR PUNCTUATORS==========================////
                  else
                
    
                     
                     if(isPunctuator(current)==true)
                    {
                            
                       
                       boolean isNextUsed;
     
                       word= ToString(temp,i);
                        checkIdentifier(word, i); 
                        temp=new ArrayList<>();
                        if(j+1<arr.length)
                        {
                         isNextUsed= punctuator(current,arr[j+1],i);
                        
                        }
                       
                    
                       else
                        {
                               isNextUsed= punctuator(current,' ',i);
                   
                        }
                        if(isNextUsed==true)
                        {
                            j++;
                          
                        } 
                        }
            ////////================== FOR OPERATORS=============================////
                else
                            
                                     if(isOperator(current)==true)
                    {
                      
  
                            boolean isNextUsed;
                       word= ToString(temp,i);
                        checkIdentifier(word, i); 
                        // boolean signcheck=checkIntegerConstant(word, i,j,arr); 
                        temp=new ArrayList<>();
                        
                        if(j+1<arr.length)
                        {
                         isNextUsed=Operator(current,arr[j+1],i);
                        
                        }
                       
                    
                       else
                        {
                               isNextUsed=Operator(current,' ',i);
                   
                        }
                        if(isNextUsed==true)
                        {
                            j++;
                          
                        } 
                            
                                     
                    } 
                    
           ///////================ FOR STRINGS================/////
                else
                                          if(current=='"')
                {
                     int index=j+1;
                     boolean check=false;
                     boolean string=false;
                    while(index<arr.length)
                    {
                       
                     check=checkPattern(arr,index);
                      if(check==true)
                      {
                       
                          temp.add(arr[index]);
                          temp.add(arr[index+1]);
                          index=index+2;
                          continue;
                      }
                      else
                      {
                          if(arr[index]=='"')
                         
                          { 
                            
                              string =true;
                         break;
                          }
                          
                          else{
                           
                        
                              temp.add(arr[index]);
                          index=index+1;
                          continue;
                          }
                          
                      }
                    }
                      
               
                  if(string==true)
                  {
                   String result= ToString(temp,i);
          
                
                  temp=new ArrayList<>();
                TokenSet ts=new TokenSet("StringConstant",result,i);
                TokenSetFile(ts);
                j=index; 
            
                  } 
                   
                    
                    else
                    {
                 String result= ToString(temp,i);
                  temp=new ArrayList<>();
                  StringBuilder sb=new StringBuilder(2);
                  char r='"';
                sb.append(r);
                sb.append(result);
            
                TokenSet ts=new TokenSet("InvalidToken",sb.toString(),i);
                TokenSetFile(ts);
                j=index; 
                }
                
                }
         //////=================for char=========================///
                                          /* else
                     if(current=='\\'){
                      boolean exceed=false;
                         int index=j+1;
                         while(arr[index]!='\\')
                         {
                             temp.add(arr[index]);
                             index++;
                             if(index<arr.length)
                             {
                                 String result=ToString(temp,i);
                             TokenSet ts=new TokenSet("CharConstant",result,i);
                             TokenSetFile(ts);
                              temp=new ArrayList<>();
                             j=index;
                                 continue;

                             }
                             else
                                 exceed=true;
                                 break;
                         }

                         if(exceed==true)
                       {

                                  String result=ToString(temp,i);
                             TokenSet ts=new TokenSet("invalidToken",result,i);
                             TokenSetFile(ts);
                             j=index; 
                              temp=new ArrayList<>();
                       }

                       if(arr[index]=='\'')
                         {
                             if(arr[index-1]=='\\')
                             {

                             temp.add(arr[index]);
                             index=index+1;
                             if(index==arr.length)
                             {
                                  String result=ToString(temp,i);
                             TokenSet ts=new TokenSet("invalidToken",result,i);
                             TokenSetFile(ts);
                             j=index;
                              temp=new ArrayList<>();
                             }

                             else
                             if(index<arr.length)
                             {
                              while(arr[index]!='\'')
                         {
                             temp.add(arr[index]);
                             index++;
                             if(index<arr.length)
                             {
                                 continue;
                             }
                             else
                                 break; 
                         }
                             if(index==arr.length)
                                {

                                if(arr[index-1]!='\'')
                         {
                              String result=ToString(temp,i);
                             TokenSet ts=new TokenSet("invalidToken",result,i);
                             TokenSetFile(ts);
                              temp=new ArrayList<>();
                             j=index;
                         }
                                else
                                    if(arr[index-1]=='\'')
                                    {
                                        String result=ToString(temp,i);
                             TokenSet ts=new TokenSet("CharConstant",result,i);
                             TokenSetFile(ts);
                              temp=new ArrayList<>();
                             j=index;
                                    }

                             }

                         }
                         
                             }}}       */   
                
      //////===============================================================/////
               else
                {
                    temp.add(current);
                }
      
    }
    }
////////================ FOR CHAR TO STRING CONVERSION==================////
    }  public String ToString (ArrayList<Character> arr,int lineNo) throws IOException {
          String result;
        if (arr.size() != 0) {
            StringBuilder sb = new StringBuilder(arr.size());
            for (char c : arr) {
                sb.append(c);
            }
            result = sb.toString();
            
           System.out.println(result);
             return result;
          
        //  checkIdentifier(result, lineNo); 
       
            
        }
        return "";
      
    }
    ////////==================== FOR IDENTIFIER CHECKING======================/////
     public void  checkIdentifier(String result,int lineNo) throws IOException
     {
          String Identifierpattern="[a-zA-Z0-9_]*[a-zA-Z0-9]|[A-Za-z][a-zA-Z0-9]*";
          Matcher m;
           Pattern p;
           
      p=Pattern.compile(Identifierpattern);
  
       m=p.matcher(result);   
       if(m.matches())
{
    Class= Classification.Keyword(result);
    if(Class!=null){
TokenSet ts=new TokenSet(Class, result,lineNo);
        System.out.println(Class);
    TokenSetFile(ts);}
    else{
    
TokenSet ts=new TokenSet("ID",result,lineNo);
TokenSetFile(ts);
}}

     
     }
     ///////////==============for char checking=====================/////
      public void checkCharConstant(String word, int lineNo) throws IOException
     {
      String charPattern = "\',n,r,t,\\\\,." ;     
      Matcher m;
      Pattern p;
        
      p = Pattern.compile(charPattern);
  
       m = p.matcher(word);   
       if(m.matches())
       {           
           TokenSet ts = new TokenSet("CharConstant",word,lineNo);
           TokenSetFile(ts);
       }
    }
     
     ////////================= FOR OPERATOR ChECKING==================////////////
     public boolean Operator(char current,char next,int lineNo) throws IOException
     {
         boolean isNextUsed=false;
         String AOP,PM,MDM,XOR,ROP,LOP,BOP;
         String INCDEC;
          StringBuilder sb1 = new StringBuilder(1);
         StringBuilder sb = new StringBuilder(2);
         TokenSet ts = null;
     //  switch(current)
          //     {
                   
          // case 1:
         if(current== '+'|| current== '-')
         {
             if(next=='=')
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   AOP=sb.toString();
                    
              ts=new TokenSet("AOP",AOP,lineNo);
              TokenSetFile(ts);
                      //  break;
             }
             
           else  if(next==current)
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                  INCDEC=sb.toString();
                    
              ts=new TokenSet("INCDEC",INCDEC,lineNo);
               TokenSetFile(ts);
                       // break;
             }
             
        
           else{
                sb1.append(current);
              ts=new TokenSet("PM",sb1.toString(),lineNo);
              TokenSetFile(ts);
           }
                       // break;
         }         
       
         
        
               
                  //  case 6:
                  else
                         if(current== '*'|| current== '/'|| current=='%')
         {
             if(next=='=')
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   AOP=sb.toString();
                    
              ts=new TokenSet("AOP",AOP,lineNo);
              TokenSetFile(ts);
                     //   break;
             }
             
            
             
        
        else
             {
                 sb1.append(current);
             
              ts=new TokenSet("MDM",sb1.toString(),lineNo);
              TokenSetFile(ts);
             }        //  break;
                   
         }        else
                       //  case 7:
                              if(current== '=')
         {
             if(next=='=')
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   AOP=sb.toString();
                    
              ts=new TokenSet("ROP",AOP,lineNo);
              TokenSetFile(ts);
                  //      break;
             }
             
             
        
        else
             {   sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                  //      break;
             }        
     }
         
else

         
         
         if(current== '&')
        {
             if(next=='&') 
{
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   LOP=sb.toString();
                    
              ts=new TokenSet("LOP",LOP,lineNo);
              TokenSetFile(ts);
                  //      break;
             }
             
             
        
        else
             { sb1.append(current);
              ts=new TokenSet("BOP",sb1.toString(),lineNo);
              TokenSetFile(ts);
                  //      break;
             }      
}
else
         
 if(current== '|')
        {
             if(next=='|') 
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   LOP=sb.toString();
                    
              ts=new TokenSet("LOP",LOP,lineNo);
              TokenSetFile(ts);
                  //      break;
             }
             
             
        
             else{
                sb1.append(current);
              ts=new TokenSet("BOP",sb1.toString(),lineNo);
              TokenSetFile(ts);
                  //      break;
             } 
           }
else

         if(current=='~'){
          
                   sb1.append(current);
                   
                  
                   sb1.toString();
                    
              ts=new TokenSet("BOP", sb1.toString(),lineNo);
              TokenSetFile(ts);
                  //      break;
             }
         else
             
       
         if(current=='`')
          {
                   sb1.append(current);
                   
                   
                  
                    
              ts=new TokenSet("XOR",sb1.toString(),lineNo);
              TokenSetFile(ts);
                  //      break;
             }    
       
     else
                         if(current== '<'|| current== '>')
         {
             if(next=='=')
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   ROP=sb.toString();
                    
              ts=new TokenSet("ROP",ROP,lineNo);
              TokenSetFile(ts);
                     //   break;
             }
             
            
             
        
        else
             {  sb1.append(current);
              ts=new TokenSet("ROP",sb1.toString(),lineNo);
              TokenSetFile(ts);
                      //  break;
                   
             }      }
                         
 else
                         if(current== '!')
         {
             if(next=='=')
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   ROP=sb.toString();
                    
              ts=new TokenSet("ROP",ROP,lineNo);
              TokenSetFile(ts);
                     //   break;
             }
             
            
             
        
        else
             {  sb1.append(current);
              ts=new TokenSet("ROP",sb1.toString(),lineNo);
              TokenSetFile(ts);
                      //  break;
                   
             }      }
else
if(current== '^')
{
             if(next=='=') 
       
             {
                   sb.append(current);
                   sb.append(next);
                   isNextUsed=true;
                   AOP=sb.toString();
                    
              ts=new TokenSet("AOP",AOP,lineNo);
              TokenSetFile(ts);
                  //      break;
             }
             
             
        
        else
             {  sb1.append(current);
              ts=new TokenSet("^",sb1.toString(),lineNo);
              TokenSetFile(ts);
                  //      break;
             }     
   }
             
            

     
        
                        
     
       return isNextUsed;
     }
     
     ////============= FOR PUNCTUATOR CHECKING========================////
          public boolean punctuator(char current,char next, int lineNo) throws IOException
     {
          boolean isNextUsed=false;
          String CharConstant;
          StringBuilder sb1 = new StringBuilder(1);
          StringBuilder sb = new StringBuilder(2);
           TokenSet ts = null;
           
            if(current==':'){
              if(next==':'){
                   sb1.append(current);
                   sb1.append(next);
                   isNextUsed=true;
                   CharConstant = sb1.toString();
                    
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                      //  break;
             
              }  
              
                  else
             {
                   sb1.append(current);
                   sb.append(next);
                   isNextUsed=true;
                  CharConstant=sb.toString();
                    
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
               TokenSetFile(ts);
                       // break;
             }
           }               
           
           if(current==')')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                      //  break;
               }
               
                 //   case 3:
           else         
          if(current=='(')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               
               }
                  //  case 4:
                  else
                         if(current=='{')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }
  else
                         if(current=='[')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }
                           else
                         if(current==']')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }
               
                
                         else
                  //  case 5:
                         if(current=='}')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               
               }
            else
                  //  case 5:
                         if(current==';')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }
     else
                         if(current=='.')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }
 
           else
                         if(current==',')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }           
  

           else
                         if(current=='?')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }

           else
                         if(current=='$')
               {
                     sb1.append(current);
              ts=new TokenSet(sb1.toString(),sb1.toString(),lineNo);
              TokenSetFile(ts);
                     //   break;
               }            
          return isNextUsed;

     }

     
    
    /*  public void checkIntegerConstant(String word,int lineNo) throws IOException
     {

  String IntegerPattern="[+-]?[0-9]+";   
  Matcher m;
  Pattern p;
          boolean checksign=false; 
        TokenSet ts;
      p=Pattern.compile(IntegerPattern);
  
       m=p.matcher(word);   
       if(m.matches())
       {
                    ts=new TokenSet("IntegerConstant",word,lineNo);
           
            TokenSetFile(ts);
       }
     
}*/
     
public void floatConstant(String word, int lineNo) throws IOException
{
String pattern3="[+-]([0-9])*|([0-9]*)";
String pattern4="([+-]([0-9])*[.]([0-9])+)|(([0-9])*[.]([0-9])+)|(([+-])([0-9])*[.]([0-9])+([eE])([+-])([0-9])+)|(([+-])([0-9])*[.]([0-9])+([eE])([0-9])+)|(([0-9])*[.]([0-9])+[eE]([0-9])+)|(([0-9])*[.]([0-9])+[eE][+-]([0-9])+)";

if(!word.contains(".")){
Matcher m;
Pattern p;


p=Pattern.compile(pattern3);

m=p.matcher(word);   
if(m.matches())
{

TokenSet ts=new TokenSet("integerConstant",word,lineNo);
TokenSetFile(ts);
}
else
{
TokenSet ts=new TokenSet("invalid IntegerConstant",word,lineNo);
TokenSetFile(ts);
}

}
else {
Matcher m;
Pattern p;


p=Pattern.compile(pattern4);

m=p.matcher(word);   
if(m.matches())
{

TokenSet ts=new TokenSet("floatconstant",word,lineNo);
TokenSetFile(ts);
}
else
{
TokenSet ts=new TokenSet("invalid floatCnstant",word,lineNo);
TokenSetFile(ts);
}
}

}

}