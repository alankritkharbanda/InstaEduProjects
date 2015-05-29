package Class.bin.Client.Class.src.Client;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SpriteField extends JPanel {

	Ellipse mLonely;
	public SpriteField(){
		
		repaint();
	}
	
	ArrayList<Ellipse> mSprites = new ArrayList<Ellipse>();
	ArrayList<Rectangle> mSprites1 = new ArrayList<Rectangle>();
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		AffineTransform tOldTransform = g2.getTransform(); 
		//g2.transform(mCamera);
		for (Ellipse tOne: mSprites){
			tOne.DrawSprite(g2);
		}
		for (Rectangle tOne: mSprites1){
			tOne.DrawSprite(g2);
		}
		g2.setTransform(tOldTransform);
			}

	//Sending Height, Width, Color hex code and angle to RoundStripe class
	public void CreateSpriteAt(float tX, float tY, int h, int w, String c, int ang,int type) {
		// TODO Auto-generated method stub
	
		Ellipse tSprite = new Ellipse();
		Rectangle tSprite1 = new Rectangle();
		tSprite.SetPosition(  tX,  tY , h, w, c, ang);
		tSprite1.SetPosition(  tX,  tY , h, w, c, ang);
		if(type==1)
		mSprites.add(tSprite);
		else
			
		mSprites1.add(tSprite1);
		repaint();
	}	
	
	
}
	