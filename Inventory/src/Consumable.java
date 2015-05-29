

/**
 * This class represents one Consumable Item--as found in most video games. This includes
 * food.
 *
 * Consumable Items must be stackable. All Constructors must initialize Item::stackable
 * to true.
 */
public class Consumable extends Item{
    protected String effect; ///< effect recieved by using the Item  
    protected int uses;      ///< number of times this Item can be used   

    /**
     * Default to a Comsumable Item with an empty name
     */
    public Consumable(){
        super( "", true );

        this.effect = new String();
        this.uses   = 0;
    }

    /**
     * Copy Constructor
     */
    public Consumable( Consumable src ){
        super( src.name, true );

        this.effect = src.effect;    
        this.uses  = src.uses;
    }
    
    /**
     * Retrieve effect
     */
    public String getEffect(){
        return this.effect;
    }

    /**
     * Set effect
     */
    public void setEffect( String effect ){
        this.effect = effect;
    }

    /**
     * Retrieve number of uses
     */
    public int getNumberOfUses(){
        return this.uses;
    }

    /**
     * Set number of uses
     */
    public void setNumberOfUses( int u ){
        this.uses = u;
    }

    /**
     * Read Consumable Item attributes from an input array
     */
    public void read( String[] entries ){
        super.name = entries[0];

        effect     = entries[1];
        uses       = Integer.parseInt( entries[2] );       
    }

    /**
     * Clone--i.e., copy--this Consumable Item
     */
    public Item clone(){
        return new Consumable( this );
    }

    /**
     * *Print* the Consumable Item
     */
    public String toString(){
        return (
            "  Nme: " + super.name + "\n" +
            "  Eft: " + effect     + "\n" +
            "  Use: " + uses       + "\n"
        );
    }
};