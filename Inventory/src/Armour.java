

/**
 * This class represents one piece of armour--as found in most video games. This includes
 * boots and helmets.
 *
 * Armour may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
public class Armour extends Item{ 
    
    protected double durability; ///< decreases each time the armour is used
    protected double defense;    ///< damage that is blocked
    protected String material;   ///< material out of which the armour is composed 
    protected String modifier;   ///< one of protection, feather_falling, or unbreaking
    protected int modifer_level; ///< modifier level in the range 1 to 3
    protected String element;    ///< associated element--e.g., ice, fire, and lightning.

    /**
     * Default to a armour with an empty name
     */
    public Armour(){
        super( "", false ); 

        this.durability    = 0;      
        this.defense       = 0;
        this.material      = new String(); 
        this.modifier      = new String();  
        this.modifer_level = 1;     
    }

    /**
     * Copy Constructor
     */
    public Armour( Armour src ){
        super( src.name, false );

        this.durability    = src.durability;      
        this.defense       = src.defense;        
        this.material      = src.material;  
        this.modifier      = src.modifier;   
        this.modifer_level = src.modifer_level;      
        this.element       = src.element;   
    }
    /**
     * Retrieve armour durability
     */
    public double getDurability(){
        return this.durability;
    }
    /**
     * Set armour durability
     */
    public void setDurability( double durability ){
        this.durability = durability;
    }

    /**
     * Retrieve armour defense
     */
    public double getDefense(){
        return this.defense;
    }

    /**
     * Set armour defense
     */
    public void setDefense( double defense ){
        this.defense = defense;
    }         

    /**
     * Retrieve armour Material
     */
    public String getMaterial(){
        return this.material;
    }

    /**
     * Set armour Material
     */
    public void setMaterial( String m ){
        this.material = m;
    }

    /**
     * Retrieve armour Modifier
     */
    public String getModifier(){
        return this.modifier;
    }

    /**
     * Set armour Modifier
     */
    public void setModifier( String m ){
        this.modifier = m;
    }

    /**
     * Retrieve armour Modifier Level
     */
    public int getModiferLevel(){
        return this.modifer_level;
    }

    /**
     * Set armour Modifier Level
     */
    public void setModiferLevel( int level ){
        this.modifer_level = level;
    }

    /**
     * Retrieve armour Element
     */
    public String getElement(){
        return this.element;
    }

    /**
     * Set armour Element
     */
    public void setElement( String e ){
        this.element = e;
    }

    /**
     * Read Armour attributes from an input array
     */
    public void read( String[] entries ){
        super.name = entries[0];

        material      = entries[1];
        durability    = Double.parseDouble( entries[2] );
        defense       = Double.parseDouble( entries[3] );
        modifier      = entries[4];
        modifer_level = Integer.parseInt( entries[5] );
        element       = entries[6];
    }

    /**
     * Clone--i.e., copy--this Armour
     */
    public Item clone(){
        return new Armour( this );
    }

    /**
     * *Print* one Armour
     */
    public String toString(){
        return (
            "  Nme: " + super.name + "\n" +
            "  Dur: " + durability + "\n" +
            "  Def: " + defense    + "\n" +
            "  Mtl: " + material   + "\n" +
            "  Mdr: " + modifier   + " (Lvl " + modifer_level + ")" + "\n" +
            "  Emt: " + element    + "\n"
        );
    }
}




