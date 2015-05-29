

import java.util.*;
import java.lang.StringBuilder;

/**
 * An Inventory is composed of n slots. Each slot may store only
 * one type of item--specified by *slots*. 
 * <p>
 * Once all slots are filled, no additional Item types may be
 * stored. Individual slots may contain any number of the same 
 * Item--if the Item is stackable.
 */
public class Inventory{
    private List<ItemStack> slots;  ///< Individual item slots--each ItemStack represents one slot
    private int capacity;           ///< Maximum inventory size

    /**
     * Default to 10 slots
     */
    public Inventory(){
        this.slots    = new ArrayList<ItemStack>();
        this.capacity = 10;
    }

    /**
     * Create an inventory with n slots
     *
     * @pre n > 0
     */
    public Inventory( int n ){
        this.slots    = new ArrayList<ItemStack>();
        this.capacity = n;
    }

    /**
     * Add one or more items to the inventory list
     *
     * @return true if *stack* was added and false otherwise
     */
    public boolean addItems( ItemStack stack ){   
        int loc = slots.indexOf( stack );

        // If no match was found and the capacity has not
        // yet been reached, store the Item
        if( (loc == -1) && (slots.size() != capacity) ){
            slots.add( stack );

            return true;
        }

        // if a match was found  
        if( loc >= 0 ){ 
            // If the Item is stackable, add it to the ItemStack
            // If the item is not stackable and the Inventory is not full
            // store the Item in a new slot
            if( slots.get(loc).permitsStacking() ){
                slots.get(loc).addItems( stack.size() );    

                return true;
            }
            else if( slots.size() < capacity ){
                slots.add( stack );
                return true;
            }
        }
        
        return false;
    }

    /**
     * Specify wheterh the inventory is full
     */
    public boolean isFull(){
        return slots.size() == capacity;
    }


    /**
     * *Print* a Summary of the Inventory and all Items contained within
     */
    public String toString(){
        StringBuilder str_bld = new StringBuilder();

        // Compute % full rounded to nearest whole number
        int percent_filled = (int)Math.round( (100.0 * slots.size() / capacity ) );

        // Print the usage summary
        str_bld.append( 
            String.format( " -Used %3d%% of %d slots\n", percent_filled, capacity )
        );

        // Print the Items
        for( ItemStack slot : slots ){
            str_bld.append( slot + "\n" );
        }

        return str_bld.toString();
    }
};
