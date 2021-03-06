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
	

	
//	 vérifie si en dessous du joueur il y a une tuille dont l'id est égal à 102 (air).

    public boolean estEnLAir() {
        int getAddress= env.idTuile((y.getValue()+16) /16 * 30 + (x.getValue()) / 16) ;
        switch (getAddress) {
        case 102:
            return true;
        case 10:
            return true;
        case 64:
            return true;
        case 65:
            return true;
        case 29:
            return true;

        default:
            return false;
        }
      }
	

	// Permet d'avoir la position côté modele 
	public int CaseX() {
		return this.getX()/16;
	}
	public int CaseY() {
		return this.getY()/16;
	}

	


}
