/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package árboles;

/**
 *
 * @author vic
 */
public class NodoBin<T extends Comparable<T>> {
    private T elem;
    private int FE;
    private NodoBin<T> izq, der, papa;
    
    public NodoBin(){
        this.elem=null;
        this.izq=null;
        this.der=null;
        this.papa=null;
        this.FE=0;
    }
   
    public NodoBin(T dato){
        this.elem=dato;
    }
    
    public T getElem(){
        return this.elem;
    }
    
    public NodoBin getIzq(){
        return this.izq;
    }
    
    public NodoBin getDer(){
        return this.der;
    }
    
    public NodoBin getPapa(){
        return this.papa;
    }
    
    public int getFE(){
        return this.FE;
    }
    
    public void setIzq(NodoBin<T> nodIzq){
        this.izq=nodIzq;
    }
    
    public void setDer(NodoBin<T> nodDer){
        this.der=nodDer;
    }
    
    public void setPapa(NodoBin<T> nodPapa){
        this.papa=nodPapa;
    }
    
    public void setFE(int FE){
        this.FE = FE;
    }
    
    public void setElem(T elemt){
        this.elem=elemt;
    }
    
    
    public int numDescendientes(){
        int cont=0;
        if(izq!=null){
            cont=izq.numDescendientes()+1;
        }
        if(der!=null){
            cont+=der.numDescendientes();
        }
        return cont;
    }
    
    public String toString(){
        return elem + " ";
    }
    
    public void cuelga(NodoBin<T> n){
        if(n==null){
            return; 
        }
        if(n.getElem().compareTo(elem)<=0){
            izq=n;
        }
        else{
            der=n;
        }
        n.setPapa(this);
    }
    
    public void cuelga2(NodoBin<T> n, char direccion){
        if(direccion=='I'){
            izq=n;
        }
        else{
            if(direccion=='D'){
                der=n;
            }
        }
        if(n!=null){
            n.setPapa(this);
        }
    }
    
}
