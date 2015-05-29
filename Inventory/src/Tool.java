
  
/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 *
 * Tools may not be stacked. Allructors must initialize Item::stackable
 * to false.
 */
public class Tool extends Item{

    protected double durability; ///< decreases each time the tool is used
    protected double speed;      ///< base harvest/mine speed
    protected String material;   ///< material out of which the tool is composed 
    protected String modifier;   ///< one of efficiency, fortune, or unbreaking
    protected int modifer_level; ///< modifier level in the range 1 to 5

    /**
     * Default to a tool with an empty name
     */
    public Tool(){
        super( "", false );

        this.durability    = 0;      
        this.speed         = 0;
        this.material      = new String();  
        this.modifier      = new String();   
        this.modifer_level = 1;   
    }

    /**
     * Copy Constructor
     */
    public Tool( Tool src ){
        super( src.name, false );

        this.durability    = src.durability;      
        this.speed         = src.speed;        
        this.material      = src.material;  
        this.modifier      = src.modifier;   
        this.modifer_level = src.modifer_level;      
    }

    /**
     * Retrieve tool durability
     */
    public double getDurability(){
        return this.durability;
    }

    /**
     * Set tool durability
     */
    public void setDurability( double durability ){
        this.durability = durability;
    }

    /**
     * Retrieve tool speed
     */
    public double getSpeed(){
        return this.speed;
    }

    /**
     * Set tool speed
     */
    public void setSpeed( double speed ){
        this.speed = speed;
    }

    /**
     * Retrieve tool Material
     */
    public String getMaterial(){
        return this.material;
    }

    /**
     * Set tool Material
     */
    public void setMaterial( String m ){
        this.material = m;
    }

    /**
     * Retrieve tool Modifier
     */
    public String getModifier(){
        return this.modifier;
    }

    /**
     * Set tool Modifier
     */
    public void setModifier( String m ){
        this.modifier = m;
    }

    /**
     * Retrieve tool Modifier Level
     */
    public int getModiferLevel(){
        return this.modifer_level;
    }

    /**
     * Set tool Modifier Level
     */
    public void setModiferLevel( int level ){
        this.modifer_level = level;
    }

    /**
     * Read Tool attributes from an input array
     */
    public void read( String entries[] ){
        super.name    = entries[0];

        material      = entries[1];
        durability    = Double.parseDouble( entries[2] );
        speed         = Double.parseDouble( entries[3] );
        modifier      = entries[4];
        modifer_level = Integer.parseInt( entries[5] );

    }

    /**
     * Clone--i.e., copy--this Tool
     */
    public Item clone(){
        return new Tool( this );
    }

    /**
     * *Print* a Tool
     */
    public String toString(){        
        return (
            "  Nme: " + super.name + "\n" +
            "  Dur: " + durability + "\n" +
            "  Spd: " + speed      + "\n" +
            "  Mtl: " + material   + "\n" +
            "  Mdr: " + modifier   + " (Lvl " + modifer_level + ")" + "\n"
        ) ;        
    }
    
}