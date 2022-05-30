package applicationV1.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import applicationV1.Box;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

	private int width, height;
//	private int [][] map;
	private ObservableList<Integer> listeDeTuiles;
	private Perso personnage;


	public Environnement(int width, int height) {
		personnage = new Perso(this,100,100);
		this.width = width;
		this.height = height;
//		this.map = new int[height][width];
		this.listeDeTuiles = FXCollections.observableArrayList();
		try {
			readMap () ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// méthode qui permet de lire ma map. On crée un objet de type File et on le lit grace au BufferReader qui
	// lit ligne par ligne les caractères du tableau de buffer
	public void readMap () throws IOException {
        File file = new File("src/map_simpliste.csv");
        BufferedReader bfr = null;
        try {
            bfr = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // erreur d'ouverture
        }
        String ligne;
        String[] all_Line;
        try {
            int i = 0;
            // tant que la ligne n'est pas vide
            while ((ligne = bfr.readLine()) != null) {
//           	System.out.println(ligne);
                all_Line = ligne.split(","); // divise une chaîne en sous-chaînes à l'aide de séparateur (",").
                							// La méthode recueille ces sous-chaînes dans un tableau qui devient la valeur de retour.
                for(int j =0 ; j< all_Line.length; j++) {
//                    this.map[i][j] = Integer.parseInt(all_Line[j].trim()); // on donne au tableau les id et supprime tous les caractères de code numérique inférieur ou égal à 32,
//                    													// placés en tête ou en fin de la chaîne
                	String nombre = all_Line[j];
                	this.listeDeTuiles.add(Integer.parseInt(nombre));
                }
                i++;
            }
         
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
			// TODO Auto-generated catch block
		}
        try {
			bfr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
//	
//	public int idTuile(int i,int j) {
//		return map[i][j];
//	}

	//récupérer
	public int idTuile(int indice) {
		return listeDeTuiles.get(indice);
	}
	
	public int tailleListe() {
		return listeDeTuiles.size();
	}
	
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
//	public int getCase(int x, int y) {
//		return this.map[y][x];
//	}

	public Perso getPerso() {
		return this.personnage;
	}
	
	
//	public int positionBloc(int x, int y) {
//		x = this.personnage.getXProperty().getValue();
//		y = this.personnage.getYProperty().getValue();
//		return map[y][x];
//	}
//	
//	public ArrayList<Integer> blocsEntourantPerso(int x,int y, int width, int height){
//		ArrayList<Integer> listeDesBlocs = new ArrayList<>();
//		
//		width = x + 16;
//		height = y - 16;
//		
//		int positionInitialPersonnage = positionBloc(x,y);
//		int positionBlocADroite = positionBloc(width, y);
//		int positionBlocEnBas = positionBloc(height, y);
//		return listeDesBlocs;
//	}
//	
//	public boolean collision(ArrayList<Integer> liste) {
//		boolean entreEnCollision = false;
//		for(int i =0; i < liste.size(); i++) {
//			if(liste.get(i) !=0 )
//				entreEnCollision = true;
//		}
//		return entreEnCollision;
//	}
	
	
	
}
