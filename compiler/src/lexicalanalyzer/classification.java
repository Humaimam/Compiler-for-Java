/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.util.Objects;

/**
 *
 * @author Huma Imam
 */
public class classification {
    String[] dt={"int","char","float","double","long","short","boolean"};
    String string(char[] s){
       String classpart="";
        return classpart;
    
    }
    
    
    String Character(char[] s){
       String classpart="";
        return classpart;
    }
    
    
    String Keyword(String s){
       String temp="";
           temp=String.valueOf(s);
       for(int j=0;j<dt.length;j++){
           if(Objects.equals(temp,dt[j])){
               return "datatype";
       }
      }
       if(Objects.equals(temp,"String"))
           return "String";
        if(Objects.equals(temp,"this"))
           return "this";
         if(Objects.equals(temp,"new"))
           return "new";
       else  if(Objects.equals(temp,"void"))
           return "void";
       else  if(Objects.equals(temp,"for"))
           return "for";
       else  if(Objects.equals(temp,"while"))
           return "while";
       else  if(Objects.equals(temp,"if"))
           return "if";
       else  if(Objects.equals(temp,"else"))
           return "else";
       else  if(Objects.equals(temp,"switch"))
           return "switch";
       else  if(Objects.equals(temp,"case"))
           return "case";
       else  if(Objects.equals(temp,"default"))
           return "default";
       else  if(Objects.equals(temp,"break"))
           return "break";
       else  if(Objects.equals(temp,"continue"))
           return "continue";
       else  if(Objects.equals(temp,"return"))
           return "return";
       else  if(Objects.equals(temp,"boolean"))
           return "boolean";
       else  if(Objects.equals(temp,"true"))
           return "boolconstant";
       else  if(Objects.equals(temp,"false"))
           return "boolconstant";
       else  if(Objects.equals(temp,"public"))
           return "public";
       else  if(Objects.equals(temp,"private"))
           return "private";
          else  if(Objects.equals(temp,"import"))
           return "import";
       else  if(Objects.equals(temp,"args"))
           return "args";
       else  if(Objects.equals(temp,"main"))
           return "main";
       else  if(Objects.equals(temp,"protected"))
           return "protected";
       else  if(Objects.equals(temp,"interface"))
           return "interface";
         else  if(Objects.equals(temp,"Fore"))
           return "Fore";
       else  if(Objects.equals(temp,"class"))
           return "class";
       else  if(Objects.equals(temp,"static"))
           return "static";
       else  if(Objects.equals(temp,"final"))
           return "final"; 
         else  if(Objects.equals(temp,"do"))
           return "do";
          else  if(Objects.equals(temp,"enum"))
           return "enum"; 
     
     return null;}
    
    boolean floatingpoint(char[] s){
       boolean a=false;
        return a;
    }
    
    boolean digit(char[] s){
       boolean a=false;
        return a;
    }
    
}
