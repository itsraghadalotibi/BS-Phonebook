/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phaes2;

/**
 *
 * @author sara
 * @param <T>
 */
public class Node<T> {
    
    public String key;
    public T data;
    public Node<T> left , right ;
    
    
    public Node(String Key , T data){
        this.key = key ;
        this.data = data;
        left=right=null;
        
        
        
    }
    
            }

  