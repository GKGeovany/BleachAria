package applicationV1.controleur;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import applicationV1.modele.Environnement;
import applicationV1.modele.Perso;
import applicationV1.vue.VueMap;
import applicationV1.vue.VuePersonnage;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controleur implements Initializable{
	
	private Environnement env;
	private VueMap vueMap;
	private VuePersonnage vuePerso;
	private Perso personnage;
	
	@FXML
    private TilePane tilePane;
	@FXML
	private Pane pane;
    
	@FXML
	private Rectangle shapeDanger;
	
	@FXML
	private Rectangle rect1;
	
	private Timeline gameLoop;
	
	private int temps;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.env = new Environnement(30, 20);
		this.personnage = this.env.getPerso();
		initAnimation();
		// demarre l'animation
		gameLoop.play();
		lancement();
	}
	
	// cette méthode permet de controler les mouvements du personnage selon les clés UP,DOWN,RIGHT, et LEFT affiche "Tu ne peux plus avancer" en cas d'erreur.
	@FXML
	public void mouvements(KeyEvent k) {
//		System.out.println("test");

		try {
			switch (k.getCode()) {
				case UP	:
					personnage.setY(personnage.getY()-8);
					break;
				
				
				case RIGHT	:
					personnage.setX(personnage.getX()+8);

					break;
					
				case LEFT	:
					personnage.setX(personnage.getX()-8);
					break;
					
				default:
					break;
			
			}
		}catch(Exception e) {
			System.out.println("Tu ne peux plus avancer");
		}
	}
	
	
	
	public void lancement() {
		try {
			this.vueMap = new VueMap(env, tilePane);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.vuePerso = new VuePersonnage(pane, env.getPerso());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}

	}
	
	private void initAnimation() {
		gameLoop = new Timeline();
		temps=0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.017), 
				// on définit ce qui se passe à chaque frame 
				// c'est un eventHandler d'ou le lambda
				(ev ->{
					if(personnage.estEnLAir()==true){
						personnage.setYProperty(-1);
						personnage.estEnLAir();
					}
					else {
						try {
							personnage.setY(env.getPerso().getY());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					temps++;
				})
				);
		gameLoop.getKeyFrames().add(kf);
	}
	

	

	
	
	
	


}
