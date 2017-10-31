/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema5;

/**
 *
 * @author lam_m
 */
public class ArrayStack<E> implements Stack<E>{

    public static final int CAPACITY=3;
    private E[] data;
    private int size=0;
    
    public ArrayStack(){
        this(CAPACITY);
    }
    
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
        
    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0;  }

    protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int k=0; k < size; k++)
			temp[k] = data[k];
		data = temp;
	}
    
    @Override
    public void push(E e) {
        if(size==data.length)
        {
            resize(2*size);
          
            
		data[size] = e; 
		size++;
        }
        else 
        {
            data[size] = e;
            size++;
        }
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[size-1];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
		E response = data[size];
		data[size] = null;
		size--;
		return response;
    }
    
     
    
}
