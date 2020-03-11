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
 * 
 */
public class LexicalAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        IdentifierClassification IC=new IdentifierClassification();
        IC.lexicalAnalyzer();
        
        TokenSet ts=new TokenSet();
     
     

      
         ArrayList<TokenSet> tokenset=new ArrayList<>();
         tokenset=IC.tokenset;
         SyntaxAnalyzer SA=new SyntaxAnalyzer(tokenset);
         SemanticWork SW=new SemanticWork(tokenset);
         int lno=SW.S();
         int lineno;
        lineno= SA.S();
if(lineno==-1)
{
    System.out.println("invalid");
}
else
    System.out.println("Grammar is valid at : "+lineno);
       // TokenSet ts=new TokenSet();
        //ts=IC.validation();
       // System.out.println(ts);
    }
    
}
