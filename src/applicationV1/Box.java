package applicationV1;

import applicationV1.modele.Perso;
import javafx.scene.shape.Rectangle;


	
public class Box {
		
		private int x,y,width,height;
		
		
		public Box(int x,int y,int width, int height){
			
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
//		
//		public boolean collisionBox(Box box1,Box box2) {
//			if((box1.x >= box2.x+box2.width) || (box1.x + box1.width <= box2.x) ||
//					(box1.y >= box2.y + box2.height) || (box1.y + box1.width <= box2.y)) {
//				return false;
//			}
//			else {
//				System.out.println("Il y a collisions");
//				return true;
//			}
//
//		}
//
		public void verifCollision(Rectangle rect1, Rectangle rect2) {
//			if(rect1.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
//				System.out.println("Collision");
//			}
			
		}

		
		
		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		public int getWidth() {
			return width;
		}


		public int getHeight() {
			return height;
		}
		
}
