/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package árboles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author vic
 */
public class LinkedBinaryTree <T extends Comparable<T>> implements BinaryTreeADT<T> {

    protected NodoBin<T> raiz;
    protected int cont;
    
    public LinkedBinaryTree(){
        this.raiz=null;
        this.cont=0;
    }
    
    public LinkedBinaryTree(T dato){
        this.raiz=new NodoBin(dato);
        cont++;
    }
    
    public LinkedBinaryTree(NodoBin<T> nodo){
        this.raiz=nodo;
        cont++;
    }
    
    public boolean isEmpty() {
        return cont==0;
    }

    public int size() {
        return cont;
    }

    public boolean find(T elem) {
        return find(elem,raiz)!=null;
    }
    
    private NodoBin<T> find(T elem, NodoBin<T> actual){
        if(actual==null){
            return null;
        }
        if(actual.getElem().equals(elem)){
            return actual;
        }
        NodoBin<T> res=find(elem,actual.getIzq());
        if(res==null){
            res=find(elem,actual.getDer());
        }
        return res;
    }

    private void preOrden(NodoBin<T> actual, ArrayList<T> lista){
        if(actual==null){
            return;
        }
        lista.add(actual.getElem());
        preOrden(actual.getIzq(),lista);
        preOrden(actual.getDer(),lista);
    }
    
    public Iterator<T> preOrden() {
        ArrayList<T> lista=new ArrayList<T>();
        preOrden(raiz,lista);
        return lista.iterator();
    }
    
    private void inOrden(NodoBin<T> actual, ArrayList<T> lista){
        if(actual==null){
            return;
        }
        inOrden(actual.getIzq(),lista);
        lista.add(actual.getElem());       
        inOrden(actual.getDer(),lista);
    }
    
    public Iterator<T> inOrden() {
        ArrayList<T> lista=new ArrayList<T>();
        inOrden(raiz,lista);
        return lista.iterator();
    }

    public Iterator<T> preOrden2(){
        Stack<NodoBin> pila=new Stack();
        ArrayList<T> lista=new ArrayList();
        
        pila.push(raiz);
        NodoBin<T> aux=raiz;
        
        while(!pila.isEmpty()){
            aux=pila.pop();
            lista.add(aux.getElem());
            if(aux.getDer()!=null){
                pila.push(aux.getDer());
            }
            if(aux.getIzq()!=null){
                pila.push(aux.getIzq());
            }
        }
        return lista.iterator();
    }
    

    public Iterator<Object> levelOrder() {
        Queue<NodoBin> cola=new LinkedList<NodoBin>();
        ArrayList<Object> lista=new ArrayList();
        
        cola.add(raiz);
        NodoBin<T> aux=raiz;
        
        while(!cola.isEmpty()){
            aux=cola.remove();
            lista.add(aux.getElem());
            lista.add("("+aux.getFE()+")");
            if(aux.getIzq()!=null){
                cola.add(aux.getIzq());
            }
            if(aux.getDer()!=null){
                cola.add(aux.getDer());
            }
        }
        return lista.iterator();
    }
    
    public int altura(){
        return altura(raiz,0);
    }
    
    public int altura(NodoBin<T> actual){
        return altura(actual,0);
    }
    
    private int altura(NodoBin<T> actual, int cont){
        if(actual==null){
            return cont;
        }
        int a1=altura(actual.getIzq(), cont+1);
        int a2=altura(actual.getDer(), cont+1);
        return Math.max(a1, a2);
    }
    
    
}
