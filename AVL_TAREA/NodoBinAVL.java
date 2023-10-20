/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package árboles;

/**
 *
 * @author vic
 */
public class NodoBinAVL <T extends Comparable<T>> extends NodoBin<T>{
    private int FE;
    private T elem;
    private NodoBinAVL<T> izq, der, papa;
    
    
    public NodoBinAVL(){
        this.elem=null;
        this.izq=null;
        this.der=null;
        this.papa=null;
        this.FE=0;
    }

    public int getFE() {
        return FE;
    }

    public void setFE(int FE) {
        this.FE = FE;
    }
    
    public NodoBinAVL getIzq(){
        return this.izq;
    }
    
    public NodoBinAVL getDer(){
        return this.der;
    }
    
    public NodoBinAVL getPapa(){
        return this.der;
    }
    
    public void setIzq(NodoBinAVL<T> nodIzq){
        this.izq=nodIzq;
    }
    
    public void setDer(NodoBinAVL<T> nodDer){
        this.der=nodDer;
    }
    
    public void setPapa(NodoBinAVL<T> nodPapa){
        this.papa=nodPapa;
    }
    
}
