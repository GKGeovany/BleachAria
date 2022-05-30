package applicationV1.vue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import applicationV1.modele.Environnement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.geometry.*;

public class VueMap {
	
	private TilePane tilePain;
	private Environnement env; 
	private Image imgTile;
	private ImageView imgView;
	
	public VueMap(Environnement terrain, TilePane tileP) throws FileNotFoundException{
		this.env = terrain;
		this.tilePain = tileP;
		initTerrain();
	}


	private void initTerrain() throws FileNotFoundException{
		// TODO Auto-generated method stub
		// lecture de flux d'octets bruts tels que des données d'image. lis des flux de caractères
		FileInputStream tuile = null;
		try {
			tuile = new FileInputStream("src/ressources/tuiles2.jpeg"); // crée un flux de fichier d'entrée à lire à partir de l'objet .
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.imgTile = new Image(tuile);
		
		// on va parcourir toute la map et affichage avec une boucle imbriquée itérant sur les colonnes et les lignes.
		for(int i=0; i < this.env.tailleListe(); i++) {
				imgView = new ImageView(this.imgTile);
				afficherMap(imgView, this.env.idTuile(i));
			}
		}
	
	
	// méthode qui permet de découper l'image et attribue des indices à hauteur et largeur après découpage  
    public void afficherMap(ImageView img, int indice) {
        int width, height;

        width = indice % ((int)imgTile.getWidth()/16);
        width = width * 16; // 16 = les pixels
        height = indice / ((int)imgTile.getHeight()/16);
        height = height*8;
        
        img.setViewport(new Rectangle2D(width,height, 16, 16));
        this.tilePain.getChildren().add(img);
    }
    
    

}
