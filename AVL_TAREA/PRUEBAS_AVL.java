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
public class PRUEBAS_AVL {
    public static void imprimir(AVLTree<Integer> avl1){
        Iterator<Object> it=avl1.levelOrder();
        while(it.hasNext()){
            System.out.print("  "+it.next());
        }
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
          
        AVLTree<Integer> arb1=new AVLTree();
        
        arb1.Insertar(8);
        arb1.Insertar(3);
        arb1.Insertar(17);
        arb1.Insertar(-4);
        arb1.Insertar(370);
        arb1.Insertar(13);
        arb1.Insertar(111);
        arb1.Insertar(5);
        arb1.Insertar(18);
        arb1.Insertar(48);
        arb1.Insertar(26);
        arb1.Insertar(500);
        arb1.Insertar(-1);
        imprimir(arb1);
        
        
        arb1.borra(-1);
        imprimir(arb1);
        arb1.borra(18);
        imprimir(arb1);
        arb1.borra(26);
        imprimir(arb1);
        /*
        arb1.borra(50);
        imprimir(arb1);
        System.out.println("\n");
        arb1.borra(80);
        imprimir(arb1);
        */
    
    }
}
