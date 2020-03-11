/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

/**
 *
 */
public class Stack {
 int top = -1;
	 int size = 0;
         int[] arr=new int[100];
         public int pop() {
		if(this.size == 0){
			return 0;
		}
 
		this.size--;
		int Scope = this.arr[top];
		this.arr[top] = -1;//prevent memory leaking
		this.top--;
 
		
		return Scope;
	}
         public int peek() {
		if(this.size == 0){
			return 0;
		}
 
		
		int Scope = this.arr[top];
		//this.arr[top] = -1;//
 
		
		return Scope;
	}
         public void push(int scope) {
		
 if (isFull()==false)
 {	
     System.out.println("Stack is full");
         
         
         }
 else
 
		this.size++;
		this.arr[++top] = scope;
 

	}
         public boolean isFull() {
		if (this.size == 100)
                {	return false;
                }
                return true;
	}
         
         public boolean isEmpty()
         {
             if (this.size == 0)
             {	return false;
             }
		return true;
         }
  public void display()
  {
      if(size==0)
      {
          System.out.println("stack is empty");
      }
      for(int i=0;i<size;i++)
      {
          System.out.println("Current Scope"+arr[i]);
      }
      }
  }

