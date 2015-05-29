import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.lang.StringBuilder;



/**
 * An Inventory GUI
 */
public class ItemGui extends JFrame implements ActionListener{
    /**
     * This class handles all logic pertaining to button clicks
     */
    private class ItemController{
        /**
         * Discard the current Inventory and create an new
         * empty inventory 
         * <p>
         * Reset the Inventory view (log_area)
         *
         */
        public void resetInventory(){
            inventory = new Inventory();
            clear();

            add_button.setEnabled( true );
        }

        /**
         * Add the item to *inventory*. If no inventory exists,
         * create one.
         */
        public void addItem(){
            String item_line;

            item_line = (
                (String)item_box.getSelectedItem() + 
                " " +
                to_gen_field.getText()
            );

            if( inventory == null ){
                inventory = new Inventory();
            }

            // Add the new item to the the inventory. If an input error occurs,
            // display an error message
            try{
                inventory.addItems( 
                    new ItemStack(
                        ItemFactory.parseItemLine( item_line )
                    )
                );

                log_area.setText( inventory.toString() );
            }
            catch( ArrayIndexOutOfBoundsException | NumberFormatException  e ){
                // Handle malformed input
                JOptionPane.showMessageDialog( null, "Error: Malformed Input", "Input Error", JOptionPane.ERROR_MESSAGE );
            }

            if( inventory.isFull() ){
                add_button.setEnabled( false );
            }

            // Clear the input field
            to_gen_field.setText("");
        }        
    }

    // Interface Elements
    private JPanel input_panel;         ///< Panel containing all input elements
    private JPanel reset_panel;         ///< Panel containing the reset button   

    private JTextField to_gen_field;    ///< Input Field - item to add
    
    private JTextArea log_area;         ///< Output - inventory display
        
    private JButton add_button;         ///< Add - add an item to the inventory
    private JButton empty_button;       ///< Reset - discard the current inventory and create a new one

    private JComboBox<String> item_box; ///< Item type selection 

    // Controller
    ItemController controller;

    // Data--i.e., the current inventory
    Inventory inventory;

    public ItemGui() {
        super( "Item Generator" );
        //setLocation( 50, 75 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
        
        Container cp = getContentPane();
        
        // Initialize Interface Elements
        input_panel   = new JPanel();
        reset_panel   = new JPanel();        

        to_gen_field  = new JTextField( 20 );

        add_button    = new JButton( "Add" );
        empty_button  = new JButton( "Reset Inventory" );        
        
        // Initialize Text Area
        log_area      = new JTextArea( "", 20, 20 ); 
        
        log_area.setEditable( false );        
        JScrollPane log_pane = new JScrollPane(
            log_area,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        //Initialize Drop-down (Item Type Section) menu
        item_box = new JComboBox<String>( ItemFactory.getKnownItemsList() );

        // Set Panel Layouts
        input_panel.setLayout( new FlowLayout() );
        reset_panel.setLayout( new FlowLayout() );
        
        // Populate the Input Panel  
        input_panel.add( new JLabel( "Enter Item: " ) );
        input_panel.add( item_box );        
        input_panel.add( to_gen_field );
        input_panel.add( add_button );     
        reset_panel.add( empty_button );
        
        // Populate the reset panel - add the inventory reset button
           

        // Setup Item Controller
        controller = new ItemController();

        //Add Action Listeners to the Buttons
        // Add add button Listener]
        add_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addItem();
				
			}
		});
        
        // Add reset button Listener
        empty_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.resetInventory();
				
			}
		});
        //empty_button.addActionListener(l);
        
        // Setup and add to the Main Container         
        cp.setLayout( new BorderLayout() );
        
        cp.add( input_panel, BorderLayout.NORTH   );
        cp.add( reset_panel, BorderLayout.SOUTH );        
        cp.add( log_pane, BorderLayout.CENTER );
        
        // Package Everything
        pack();  
        setLocationRelativeTo( null );        
    }    

    /**
     * Clear previous output
     */
    void clear(){
        log_area.setText( new String() );
    }

    /**
     * Main function
     */
    public static void main( String args[] ){
        new ItemGui().setVisible( true );
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
        
		
	}
}