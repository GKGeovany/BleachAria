package applicationV1.vue;

import javafx.scene.shape.Rectangle;
import applicationV1.modele.Environnement;
import applicationV1.modele.Perso;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class VuePersonnage {
	
	private Pane pane;
	private Perso personage; 
	private Image imgPersonnage;
	private ImageView imgVuePersonnage;
	
	public VuePersonnage(Pane pane, Perso personnage) {
		this.pane = pane;
		this.personage = personnage;
		this.imgPersonnage = new Image("/ressources/perso1.png");
		this.imgVuePersonnage = new ImageView(imgPersonnage);
//		Rectangle rect = new Rectangle(16,16);
//		rect.setFill(Color.RED);
		affichagePersonnage(); 
		this.imgVuePersonnage.xProperty().bind(personage.getXProperty()); // on lie l'image aux coordonnées pour pouvoir voir les déplacements côté vu
		this.imgVuePersonnage.yProperty().bind(personage.getYProperty());
	}

	public void affichagePersonnage(){
		this.pane.getChildren().add(imgVuePersonnage); // on ajoute l'image au pane pour pouvoir voir l'image  
	}

}
