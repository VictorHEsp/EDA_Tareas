/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package árboles;

import java.util.Iterator;

/**
 *
 * @author vic
 */
public interface BinaryTreeADT<T> {
    
    public boolean isEmpty();
    public int size();
    public boolean find(T elem);
    public Iterator<T> preOrden();
    public Iterator<Object> levelOrder();
}
