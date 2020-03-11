/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

/**
 *
 */
public class TokenSet {
    String ClassPart;
    String ValuePart;
    int lineNo;
    
    public TokenSet(String CP,String VP,int lineNo)
    {
    this.ClassPart=CP;
    this.ValuePart=VP;
    this.lineNo=lineNo;
    }

    TokenSet() {
        this.ClassPart=null;
        this.ValuePart=null;
        this.lineNo=0;
        
    }
    public void setCP(String CP)
    {
        this.ClassPart=CP;
    }
     public void setVP(String VP)
    {
        this.ValuePart=VP;
    }
      public void setLno(int lineNo)
    {
        this.lineNo=lineNo;
    }
      public String getCP()
      {
          return ClassPart;
      }
       public String getVP()
      {
          return ValuePart;
      }
        public int getLno()
      {
          return lineNo;
      }
      
    public void displayToken()
    {
        System.out.println("{"+this.ClassPart+","+this.ValuePart+","+this.lineNo+"}");
}
}
