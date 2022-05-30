package applicationV1.modele;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;

public class Perso {
	protected Environnement env;
	private IntegerProperty x,y;
	private Box box;
//	private boolean estDansLesAir;

	public Perso(Environnement env, int x, int y){
		this.x = new SimpleIntegerProperty(x);
		this.y =  new SimpleIntegerProperty(y);
		this.env=env;
//		this.estDansLesAir = true;
	} 
	
	public  final int getX() {
		return x.getValue();
	}
	
	public void setX(int n) throws Exception{
		System.out.println("X perso " + this.CaseX());
		System.out.println("env height : " + env.getWidth());
		if(n < 0 || n >= (env.getWidth()-1)*16) 
			throw new Exception();
		else 
					x.setValue(n);

	}
	public final int getY() {
		return y.getValue();
	}
	
	public void setY(int n) throws Exception{
		System.out.println("Y perso " + this.CaseY());
		System.out.println("env width : " + env.getHeight() );
		if(n < 0 || n >= (env.getHeight()-1)*16) 
			throw new Exception();
		else 
			y.setValue(n);;
	}
	
	public final IntegerProperty getXProperty() {
		return x;
	}
	
	public final IntegerProperty getYProperty() {
		return y;
	}
	
	
	public void setXProperty(int n) {
		x.setValue(x.getValue()-n);
	}
	
	public void setYProperty(int n) {
		y.setValue(y.getValue()-n);
	}
	
	
	public boolean gravite() {
		if( this.getY() < env.getHeight()-2)
			return true;
		return false;
	}
	
//	 vérifie si en dessous du joueur il y a une tuille dont l'id est égal à 10 (air)
	public boolean estEnLAir() {
		if (env.idTuile((y.getValue()+16) /16 * 30 + (x.getValue()) / 16) == 102 ) // ne fonctionne que pour cette map
//			this.estDansLesAir = true;
			return true;
		else
			return false ;
	}
//	
//	public boolean retourDansAir() {
//		return estDansLesAir;
//	}
	
	// 
	

	// Permet d'avoir la position côté modele 
	public int CaseX() {
		return this.getX()/16;
	}
	public int CaseY() {
		return this.getY()/16;
	}

	


}
