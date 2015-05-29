package Client;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Ellipse
{
	float mX;
	float mY;
	int mWidth = 50;
	int mHeight = 30;
	int ht,wt;
	String col = "#000";
	int angle;
	
	public void DrawSprite(Graphics2D g2){
		AffineTransform tOldTransform = g2.getTransform();
		
		//If no color is selected we use default color as black
		if(col.equals("")){
			g2.setColor(Color.decode("#000"));
		}
		else
			g2.setColor(Color.decode(col));
		
		//If height and width is not given then using default height and width
		if(ht == 0 || wt == 0){
			ht = mHeight;
			wt = mWidth;
		}
		
		g2.translate(mX , mY );
		g2.rotate(Math.toRadians(angle));
		g2.translate(ht/-2, wt/-2);
		g2.draw(new Ellipse2D.Double(0,0,ht,wt));			
		g2.setTransform(tOldTransform);
		
		
	}
	
	//height, width, color hex code and angle from SpriteField class is set to local Variables
	public void SetPosition(float tX, float tY, int h, int w, String c, int ang) {
		// TODO Auto-generated method stub
		
		mX = tX;
		mY = tY;
		ht = h;
		wt = w;
		col = c;
		angle = ang;
		
		
	}
		


}
	

