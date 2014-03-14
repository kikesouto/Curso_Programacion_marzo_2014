
public class Rational {
	
	private int num, den;
	
	public Rational (int numerad, int denomin){
		this.num=numerad;
		this.den=denomin;
	}
	public Rational (){
		this.num=1;
		this.den=1;
	}
	public Rational (Rational rac){
		this.num=rac.num;
		this.den=rac.den;
	}
	private void canonica(){
		if(this.num>this.den){
			for (int i=this.num/2;i>0;i--){
				if((this.num%i==0)&&(this.den%i==0)){
					this.num=this.num/i;
					this.den=this.den/i;
				}
			}
		}
		else{
			for (int i=this.den/2;i>0;i--){
				if((this.num%i==0)&&(this.den%i==0)){
					this.num=this.num/i;
					this.den=this.den/i;
				}
			}
		}
		return;
	}
	public static Rational prod(Rational rac1, Rational rac2){
		Rational producto= new Rational(rac1.num*rac2.num,rac1.den*rac2.den);
		producto.canonica();
		return producto;
	}
	public boolean equals (Rational rac){
		rac.canonica();
		this.canonica();
		return ((this.num==rac.num)&&(this.den==rac.den));
	}
	public String toString(){
		String salida=""+Integer.valueOf(this.num)+"/"+Integer.valueOf(this.den);
		//salida+=Integer.valueOf(this.num)+"/"+Integer.valueOf(this.den);
		return salida;
	}
	public Rational compareTo(Rational rac){
		Rational sol;
		if(this.num*rac.den-this.den*rac.num>0){
			sol=new Rational(this.num*rac.den-this.den*rac.num,this.den*rac.den);
		}
		else{
			sol=new Rational(this.den*rac.num-this.num*rac.den,this.den*rac.den);
		}
		sol.canonica();
		return sol;
	}
	public Rational clone(){
		Rational aux=new Rational(this);
		return aux;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rational numero = new Rational(10, 50);
		Rational aux1 = new Rational(3,12);
		Rational aux2 = new Rational(2,8);
		Rational aux3=prod(aux1,aux2);
		boolean bool=aux1.equals(aux2);
		String racional=aux1.toString();
		Rational aux4=aux3.clone();
		Rational aux5 = new Rational(8,12);
		Rational aux6 = new Rational(3,7);
		Rational aux7 = new Rational(8,5);
		Rational aux8=aux5.compareTo(aux6);
		Rational aux9=aux5.compareTo(aux7);
		Rational blabla=new Rational();
		Rational bla=new Rational(blabla);
	}

}
