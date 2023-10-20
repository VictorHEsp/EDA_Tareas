/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package árboles;

/**
 *
 * @author vic
 */
public class AVLTree <T extends Comparable<T>> extends LinkedBinarySearchTree<T> implements BinarySearchTreeADT<T>{
    
    public void Insertar(T elem){
        inserta(elem);
        NodoBin<T> insertado=busca(elem);
        ChecarFEInsertar(insertado);
    }
    
    public void ChecarFEInsertar(NodoBin<T> actual){
        NodoBin<T> papa;
        boolean termine=false;
        while(!termine && actual!=raiz){
            papa=actual.getPapa();
            if(actual.equals(papa.getIzq())){
                papa.setFE(papa.getFE()-1);
            }
            else{
                papa.setFE(papa.getFE()+1);
            }
            if(Math.abs(papa.getFE())==2){
                papa=rota(papa);
                termine=true;
            }
            else{
                if(Math.abs(papa.getFE())==0){
                    termine=true;
                }
            }
            actual=papa;
        }
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
                ChecarFEEliminar(actual);
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
            ChecarFEEliminar(actual);
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
            ChecarFEEliminar(suc);
        }
    }
    
    public void ChecarFEEliminar(NodoBin<T> actual){
        NodoBin<T> papa;
        boolean termine=false;
        
        while(!termine && actual!=raiz){
            papa=actual.getPapa();
            if(actual.getElem().compareTo(papa.getElem())<0){
                papa.setFE(papa.getFE()+1);
            }
            else{
                papa.setFE(papa.getFE()-1);
            }
            if(Math.abs(papa.getFE())==2){
                papa=rota(papa);
            }
            else{
                if(Math.abs(papa.getFE())==1){
                   termine=true;
                }
            }
            actual=papa;
        }
    }
    
    /*public void ChecarFEEliminar(NodoBin<T> actual){
        NodoBin<T> papa;
        boolean termine=false;
        
        while(!termine && actual!=raiz){
            papa=actual.getPapa();
            if(actual.equals(papa.getIzq())){
                papa.setFE(papa.getFE()+1);
            }
            else{
                papa.setFE(papa.getFE()-1);
            }
            if(Math.abs(papa.getFE())==2){
                papa=rota(papa);
            }
            else{
                if(Math.abs(papa.getFE())==1){
                   termine=true;
                }
            }
            actual=papa;
        }
    }
    */
    
    public NodoBin<T> rota(NodoBin<T> n){
        //System.out.println("roto");
        if((n.getFE()==-2 && n.getIzq().getFE()==-1)||(n.getFE()==-2 && n.getIzq().getFE()==0)){
           return rotaIzquierdaIzquierda(n);  
        }
        if((n.getFE()==2 && n.getDer().getFE()==1)||(n.getFE()==2 && n.getDer().getFE()==0)){
           return rotaDerechaDerecha(n); 
           
        }
        if((n.getFE()==-2 && n.getIzq().getFE()==1)){
           return rotaIzquierdaDerecha(n);    
        }
        if((n.getFE()==2 && n.getDer().getFE()==-1)){
           return rotaDerechaIzquierda(n);   
        }
        else{
            return null;
        }
    }
    
    public NodoBin<T> rotaIzquierdaIzquierda(NodoBin<T> n){
        NodoBin<T> papa=n.getPapa();
        NodoBin<T> alpha=n;
        NodoBin<T> beta=n.getIzq();
        NodoBin<T> D=n.getDer();
        NodoBin<T> gamma=beta.getIzq();
        NodoBin<T> C=beta.getDer();
        NodoBin<T> A=gamma.getIzq();
        NodoBin<T> B=gamma.getDer();
           
        gamma.cuelga2(A, 'I');
        gamma.cuelga2(B, 'D');
        beta.cuelga2(gamma, 'I');
        beta.cuelga2(alpha, 'D');
        alpha.cuelga2(D, 'D');
        alpha.cuelga2(C, 'I');
        if(papa==null){
            raiz=beta;
        }
        else{
            papa.cuelga(beta);
        }
        gamma.setFE(this.altura(B)-this.altura(A));
        alpha.setFE(this.altura(D)-this.altura(C));
        beta.setFE(this.altura(alpha)-this.altura(gamma));
        return beta;
    }
    
    public NodoBin<T> rotaDerechaDerecha(NodoBin<T> n){
        NodoBin<T> papa=n.getPapa();
        NodoBin<T> alpha=n;
        NodoBin<T> A=n.getIzq();
        NodoBin<T> beta=n.getDer();
        NodoBin<T> B=beta.getIzq();
        NodoBin<T> gamma=beta.getDer();
        NodoBin<T> C=gamma.getIzq();
        NodoBin<T> D=gamma.getDer();
        
        gamma.cuelga2(C, 'I');
        gamma.cuelga2(D, 'D');
        alpha.cuelga2(A, 'I');
        alpha.cuelga2(B, 'D');
        beta.cuelga2(alpha, 'I');
        beta.cuelga2(gamma, 'D');
        if(papa==null){
            raiz=beta;
        }
        else{
            papa.cuelga(beta);
        }
        gamma.setFE(this.altura(D)-this.altura(C));
        alpha.setFE(this.altura(B)-this.altura(A));
        beta.setFE(this.altura(gamma)-this.altura(alpha));
        return beta;
    }
    
    public NodoBin<T> rotaIzquierdaDerecha(NodoBin<T> n){
        NodoBin<T> papa=n.getPapa();
        NodoBin<T> alpha=n;
        NodoBin<T> beta=n.getIzq();
        NodoBin<T> D=n.getDer();
        NodoBin<T> gamma=beta.getDer();
        NodoBin<T> C=gamma.getDer();
        NodoBin<T> A=beta.getIzq();
        NodoBin<T> B=gamma.getIzq();
        
        alpha.cuelga2(C, 'I');
        alpha.cuelga2(D, 'D');
        beta.cuelga2(A, 'I');
        beta.cuelga2(B, 'D');
        gamma.cuelga2(beta, 'I');
        gamma.cuelga2(alpha, 'D');
        if(papa==null){
            raiz=gamma;
        }
        else{
            papa.cuelga(gamma);
        }
        beta.setFE(this.altura(B)-this.altura(A));
        alpha.setFE(this.altura(D)-this.altura(C));
        gamma.setFE(this.altura(alpha)-this.altura(beta));
        return gamma;
    }
    
    public NodoBin<T> rotaDerechaIzquierda(NodoBin<T> n){
        //System.out.println("di");
        NodoBin<T> papa=n.getPapa();
        NodoBin<T> alpha=n;
        NodoBin<T> A=n.getIzq();
        NodoBin<T> beta=n.getDer();
        NodoBin<T> D=beta.getDer();
        NodoBin<T> gamma=beta.getIzq();
        NodoBin<T> B=gamma.getIzq();
        NodoBin<T> C=gamma.getDer();
        
        alpha.cuelga2(A,'I');
        alpha.cuelga2(B, 'D');
        beta.cuelga2(C, 'I');
        beta.cuelga2(D, 'D');
        gamma.cuelga2(alpha, 'I');
        gamma.cuelga2(beta, 'D');
        if(papa==null){
            raiz=gamma;
        }
        else{
            papa.cuelga(gamma);
        }
        beta.setFE(this.altura(D)-this.altura(C));
        alpha.setFE(this.altura(B)-this.altura(A));
        gamma.setFE(this.altura(beta)-this.altura(alpha));
        return gamma;
    }
    
    
}
