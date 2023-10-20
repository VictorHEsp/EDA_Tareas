/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package árboles;

/**
 *
 * @author vic
 */
public class LinkedBinarySearchTree <T extends Comparable<T>> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T>{
    
    public void inserta(T elem){
        NodoBin<T> papa=null;
        NodoBin<T> actual=raiz;
        if(actual==null){
            raiz=new NodoBin(elem);
            cont++;
            return;
        }
        while(actual!=null){
            papa=actual;
            if(actual.getElem().compareTo(elem)>0){
                actual=actual.getIzq();
            }
            else{
                actual=actual.getDer();
            }
        }
        NodoBin<T> nuevo=new NodoBin(elem);
        if(elem.compareTo(papa.getElem())<=0){
            papa.setIzq(nuevo);
        }
        else{
            papa.setDer(nuevo);
        }
        nuevo.setPapa(papa);
        cont++;
    }
    
    
    /*
    public void inserta2(T elem){
        NodoBin nuevo=new NodoBin<T>(elem);
        inserta2(raiz,nuevo);
        cont++;
    }
    
    private void inserta2(NodoBin<T> actual, NodoBin<T> nuevo){
        if(actual==null){
            raiz=nuevo;
            return;
        }
        if(nuevo.getElem().compareTo(actual.getElem())<=0){
            
        }
        else{
            if(actual.getDer()==null){
                
            }
        }
    }
    */
    
    public NodoBin<T> busca(T elem){
        NodoBin<T> actual=raiz;
        boolean bandera=false;
        
        while(!bandera && actual!=null){
            if(elem.compareTo(actual.getElem())==0){
            bandera=true;
            }
            else{
                if((elem.compareTo(actual.getElem())<0)){
                    actual=actual.getIzq();
                }
                else{
                    actual=actual.getDer();
                }
            }
        }
        return actual;
    }
    
    
    public void borra(T elem) {
        NodoBin<T> actual=busca(elem);
        if(actual==null){
            return;
        }
        cont--;
        if(actual.getIzq()==null && actual.getDer()==null){
            if(actual==raiz){
                raiz=null;
            }
            else{
                NodoBin<T> papa=actual.getPapa();
                if(papa.getElem().compareTo(actual.getElem())<=0){
                    papa.setDer(null);
                }
                else{
                    papa.setIzq(null);
                }
            }
            return;
        }
        if(actual.getIzq()==null||actual.getDer()==null){
            NodoBin<T> hijo;
            if(actual.getIzq()==null){
                hijo=actual.getDer();
            }
            else{
                hijo=actual.getIzq();
            }
            if(raiz.equals(actual)){
                raiz=hijo;
                hijo.setPapa(null);
            }
            else{
                actual.getPapa().cuelga(hijo);
            }
            return;
        }
        else{
            NodoBin<T> suc=actual.getDer();
            boolean bandera=false;
            while(suc.getIzq()!=null){
                bandera=true;
                suc=suc.getIzq();
            }
            actual.setElem(suc.getElem());
            NodoBin<T> papa=suc.getPapa();
            if(!bandera){
                papa.setDer(null);
            }
            else{
                papa.setIzq(suc.getDer());
            }
        }
    }

    @Override
    public T findMin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T findMax() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
