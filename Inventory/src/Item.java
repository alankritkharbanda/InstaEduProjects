

/**
 * Item represents an individual Item in an inventory.
 * This includes items such as potions, building materials, and food.
 *
 * Only one of each item can exist--i.e., no two items share the
 * same numeric id.
 */
public abstract class Item{
    private boolean stackable; ///< Indicates whether this Item can placed in an ItemStack larger than 1.

    protected String name; ///< Short title--e.g., HP Potion
    
    /**
     * Default to name = Air and stackable = true
     */
    public Item(){
        this.name      = new String( "Air" );
        this.stackable = true;
    }

    /**
     * Create an Item with a specifiedand name
     *
     * @pre 
     *  - all items that share a name are of the same type
     *  - differences in capitalization denote different items 
     */
    public Item( String name ){
        this.name      = name;
        this.stackable = true;
    }

    /**
     * Create an Item with a specified id and name
     *
     * @param stackable flag that indicates whether duplicates
     *      of this item can be stacked
     *
     * @pre 
     *  - all items that share a name are of the same type
     *  - differences in capitalization denote different items
     */
    public Item( String name, boolean stackable ){
        this.name      = name;
        this.stackable = stackable;
    }

    /**
     * Retrieve name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Update name
     */
    public void setName( String n ){
        this.name = n;
    }

    /**
     * Check for logical equivalence--based on name
     */
    public boolean equals( Object rhs ){
        Item r = (Item)rhs;

        return (this.name).equals(r.name);
    }

    /**
     * Generate a hash code based on name
     */
    public int hashCode(){
        return this.name.hashCode();
    }

    /**
     * Can this item be placed in a stack?
     */
    public boolean isStackable(){
        return this.stackable;
    }
  
    /**
     * Read the item from an input array
     */
    public abstract void read( String entries[] );

    /**
     * Duplicate this item
     */
    public abstract Item clone();

    /**
     * *Print* an Item
     */
    public String toString(){
        return (
            " " + this.name
        );
    }
}


