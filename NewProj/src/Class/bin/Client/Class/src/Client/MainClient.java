package Class.bin.Client.Class.src.Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import Class.bin.Client.Class.src.Logic.*;	
public class MainClient {

	private JFrame frame;
	private JTextField Height;
	private JTextField Width;
	private JTextField Angle;
	float tX,tY,temptX, temptY;
	String ht,wt,tempht,tempwt;
	int h,w,temph,tempw;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JColorChooser chooser;
    private Color color;
    private JButton button;
    private String hex="";
    private String temphex="";
    int ang,tempang;
    private String angle="";
    private JLabel lblNewLabel_2;
    private JButton btnNewButton;
    final SpriteField mSprite = new SpriteField();
    final SpriteField mSprite1 = new SpriteField();
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    public EllipseShape es;
    int type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClient window = new MainClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainClient() {
		es=new EllipseShape();
		type=1;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final SpriteField mSpritepanel = es.sp;
		es.sp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			tX = e.getX();
			tY = e.getY();
			
			ht = Height.getText(); //Fetching Text Field Details
			wt = Width.getText(); //Fetching TextFieldDetails
			
			angle = Angle.getText(); //Fetching angle from textfield
			
			if(ht.equals("") || wt.equals("")){
				h = 0;
				w = 0;
			}//Here if textField is empty we are setting height and width to 0 so we will use out default size given in RoundSprite
			else{			
				h = Integer.parseInt(ht);
				w = Integer.parseInt(wt);
			}//in else if text field has some value we are converting it into int
			
			if(angle.equals(""))
				ang = 0;
			else
				ang = Integer.parseInt(angle);
			
			//mLogic.CreateObjectAt(tX,tY); for hw2
			es.sp.CreateSpriteAt(tX,tY,h,w,hex,ang,type); //We are passing height and width fetched from textfield to SpriteClass
			temptX = tX;
			temptY = tY;
			temph = h;
			tempw = w;
			temphex = hex;
			tempang = ang;
              
			}
		});
		es.sp.setBackground(Color.GRAY);
		es.sp.setBounds(91, 13, 329, 227);
		frame.getContentPane().add(mSpritepanel);
		
		Height = new JTextField();
		Height.setBounds(27, 274, 86, 20);
		frame.getContentPane().add(Height);
		Height.setColumns(10);
		
		Width = new JTextField();
		Width.setBounds(145, 274, 86, 20);
		frame.getContentPane().add(Width);
		Width.setColumns(10);
		
		lblNewLabel = new JLabel("Height");
		lblNewLabel.setBounds(27, 310, 86, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Width");
		lblNewLabel_1.setBounds(145, 298, 86, 44);					
		frame.getContentPane().add(lblNewLabel_1);
		
		Angle = new JTextField();
		Angle.setBounds(278, 274, 86, 20);
		frame.getContentPane().add(Angle);
		Angle.setColumns(10);
		
		
		chooser = new JColorChooser();
		chooser.setBounds(47, 350, 126, 50);
		frame.getContentPane().add(chooser);
		chooser.setVisible(false);
		
		button = new JButton("Show color Palette");
		button.setBounds(50,360,140,60);
		frame.getContentPane().add(button);
		
		button.setActionCommand("");
		
		lblNewLabel_2 = new JLabel("Angle (Degrees)");
		lblNewLabel_2.setBounds(288, 310, 126, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnNewButton = new JButton("UNDO");
		btnNewButton.setBounds(437, 24, 200, 50);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setActionCommand("");
		
		btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBounds(437, 102, 200, 50);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBounds(437, 169, 200, 50);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.setBounds(462, 243, 108, 34);
		frame.getContentPane().add(btnRectangle);
		
		JButton btnEllipse = new JButton("Ellipse");
		btnEllipse.setBounds(612, 243, 95, 34);
		frame.getContentPane().add(btnEllipse);
		
		btnRectangle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {				
				type=2;
				es.sp.CreateSpriteAt(temptX,temptY,temph,tempw,"#7E7E7E",tempang,type); //We are passing height and width fetched from textfield to SpriteClass
			}
                
		});
		btnEllipse.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {				
			type=1;
				es.sp.CreateSpriteAt(temptX,temptY,temph,tempw,"#7E7E7E",tempang,type); //We are passing height and width fetched from textfield to SpriteClass
			}
                
		});
		
		//On Pressing Undo Button Removing the previous ellipse
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {				
			
				es.sp.CreateSpriteAt(temptX,temptY,temph,tempw,"#7E7E7E",tempang,type); //We are passing height and width fetched from textfield to SpriteClass
			}
                
		});
		
		//On Pressing + button rotate angle by 15 degreee
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {				
			
				es.sp.CreateSpriteAt(temptX,temptY,temph,tempw,"#7E7E7E",tempang,type); //We are passing height and width fetched from textfield to SpriteClass
				es.sp.CreateSpriteAt(temptX,temptY,temph,tempw,temphex,tempang+15,type); 
				tempang = tempang + 15;
			}
                
		});
		
		//On Pressing - button rotate angle by -15 degrees
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {				
			
				es.sp.CreateSpriteAt(temptX,temptY,temph,tempw,"#7E7E7E",tempang,type); //We are passing height and width fetched from textfield to SpriteClass
				es.sp.CreateSpriteAt(temptX,temptY,temph,tempw,temphex,tempang-15,type);
				tempang = tempang - 15;
			}
                
		});
		
		//On Pressing Color Swatch is loaded to select colors for Ellipse
        button.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent ae) {
                color = chooser.showDialog(chooser, "SHOW THE COLOR",
                        chooser.getColor());
                {
                    if (color != null) {
                        hex = Integer.toHexString(color.getRGB() & 0xffffff);
                        hex = "#" + hex;                        
                    }
                }
            }
        });
		
		
	}	
}