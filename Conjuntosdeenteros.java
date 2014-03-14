import java.util.*;
public class Conjuntosdeenteros {
	
	private ArrayList<Integer> conjunto = new ArrayList<>();

	public Conjuntosdeenteros(){
		
	}
	public Conjuntosdeenteros(int n){
		this.conjunto.add(n);
	}
	public Conjuntosdeenteros(int[] a){
		for(int i=0;i<a.length;i++){
			if(!this.conjunto.contains(a[i])){
				this.conjunto.add(a[i]);				
			}
		}
	}
	public Conjuntosdeenteros(Conjuntosdeenteros conj){
		for(int i=0;i<conj.conjunto.size();i++){
			this.conjunto.add(conj.conjunto.get(i));
		}
	}
	public boolean anade(int n){
		if(!this.conjunto.contains(n)){
			this.conjunto.add(n);
			return true;
		}
		return false;
	}
	public boolean eliminar(int n){
		if(this.conjunto.contains(n)){
			this.conjunto.remove(this.conjunto.indexOf(n));
			return true;
		}
		return false;
	}
	public int tamano(){
		return this.conjunto.size();
	}
	public Conjuntosdeenteros union(Conjuntosdeenteros conj){
		if(this.esVacio()){
			return conj;
		}else{
				if(conj.esVacio()){
					return this;
				}
			}
		Conjuntosdeenteros dev=new Conjuntosdeenteros();
		for(int i=0;i<this.conjunto.size();i++){
			dev.anade(this.conjunto.get(i));
		}
		for(int i=0;i<conj.conjunto.size();i++){
			dev.anade(conj.conjunto.get(i));
		}
		return dev;
	}
		
	public boolean esVacio(){
		return this.conjunto.isEmpty();
	}
	public Conjuntosdeenteros interseccion(Conjuntosdeenteros conj){
		Conjuntosdeenteros aux=new Conjuntosdeenteros();
		if((this.esVacio())||(conj.esVacio())){
			return aux;
		}
		for(int i=0;i<this.tamano();i++){
			if(conj.conjunto.contains(this.conjunto.get(i))){
				aux.anade(this.conjunto.get(i));
			}
		}
		return aux;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vector={1,4,2,5,4,5},vector2={8,9,12,24,56,5,4};
		Conjuntosdeenteros aux=new Conjuntosdeenteros(vector);
		Conjuntosdeenteros aux2=new Conjuntosdeenteros(aux);
		Conjuntosdeenteros aux3=new Conjuntosdeenteros(vector2);
		Conjuntosdeenteros aux5=new Conjuntosdeenteros();
		boolean f=aux.anade(1);
		boolean t=aux.anade(6);
		boolean f2=aux.eliminar(0);
		boolean t2=aux.eliminar(6);
		int alfa=aux.tamano();
		Conjuntosdeenteros aux4=aux.union(aux3);
		Conjuntosdeenteros aux6=aux5.union(aux3);
		Conjuntosdeenteros aux7=aux3.union(aux5);
		Conjuntosdeenteros aux8=aux.interseccion(aux5);
	}

}
