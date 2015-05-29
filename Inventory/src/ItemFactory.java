

/**
 * The Item Creating Wizard
 */
public class ItemFactory{

    /**
     * Name Item Pair 2-tuple( type, model )
     *
     * Simulate a c++ struct by making all attributes public
     */
    private static class ItemPair{            
        public String _type;  ///< Name of the item to clone
        public Item   _model; ///< Model of the item to clone

        /**
         * Default Constructor - Used as sentinel
         */
        public ItemPair(){
            _type  = null;
            _model = null;
        }

        /**
         * Non-Default Constructor
         *
         * @param type the type of anqq item
         * @param item a cloneable item
         */
        public ItemPair( String type, Item item ){
            _type  = type;
            _model = item;
        }
    }

    /**
     * Listing of known items
     */
    private static ItemPair[] _known_items = {
        new ItemPair( "Armour"     , new Armour()     ),
        new ItemPair( "Armor"      , new Armour()     ),
        new ItemPair( "Tool"       , new Tool()       ),
        new ItemPair( "Food"       , new Consumable() ),
        new ItemPair( "Potion"     , new Consumable() ),
        new ItemPair( "Disposable" , new Consumable() ),
    };  

    /**
     * Create a Item
     *
     * @param type the item to be created
     *
     * @return A item with the specified type
     *     or nullptr if no matching item is found
     */
    public static Item createItem( String type ){
        for( ItemPair pair : _known_items ){
            if( (pair._type).equals(type) ){
                return (pair._model).clone();
            }
        }

        return null;
    }

    /**
     * Determine whether a given item is known
     *
     * @param type the item for which to query
     */
    public static boolean isKnown( String type ){
        for( ItemPair pair : _known_items ){
            if( (pair._type).equals(type) ){
                return true;
            }
        }

        return false;
    }

    /**
     * Return an array of known item types
     *
     * @return array of Item type identifiers
     */
    public static String[] getKnownItemsList(){
        String[] known = new String[ _known_items.length ];

        for( int i = 0; i < known.length; i++ ){
            known[i] = _known_items[i]._type;
        } 

        return known;
    }

    /**
     * Create the appropriate Item class--e.g., Tool, Armour or Consumable.
     *
     * How is **inheritance** used?
     */
    public static Item parseItemLine( String line ){
        String[] entries = (line.trim()).split("\\s+");

        Item item = createItem( entries[0] );

        // Remove the keyword (first entry) from the *"tokenized"* line
        String[] pruned = new String[ entries.length - 1 ];
        System.arraycopy( entries, 1, pruned, 0, entries.length-1 );

        // Parse the remainder of the line
        if( item != null ){
            item.read( pruned );
        }

        return item;
    }

}



