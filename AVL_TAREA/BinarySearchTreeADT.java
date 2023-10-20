/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package árboles;

/**
 *
 * @author vic
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T>{
    
    public void inserta(T elem);
    public void borra(T elem);
    public T findMin();
    public T findMax();
}
