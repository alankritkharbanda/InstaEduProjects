/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atran
 */
public class Element {
    // Data Member
    private String name;
    private int    number;
    private String symbol;
    private double mass;
    private int    period;
    private int    group;

    // Constructor
    public Element()
    {
    	name=symbol=null;
    	number=period=group=0;
    	mass=0;
    	
    }
    public Element(String elementName, int elementNumber, String elementSymbol,
	double elementMass, int elementPeriod, int elementGroup) 
    {

	name   = elementName;
	number = elementNumber;
        symbol = elementSymbol;
	mass   = elementMass;
	period = elementPeriod;
	group  = elementGroup;
    }

    // Returns the element's name
    public String getName() 
    {
	return name;
    }

    // Returns the element's atomic number
    public int getNumber() 
    {
	return number;
    }

    // Returns the element's 2-letter symbol
    public String getSymbol() 
    {
	return symbol;
    }

    // Returns the element's atomic mass
    public double getMass() 
    {
	return mass;
    }

    // Returns the element's period
    public int getPeriod() 
    {
        return period;
    }

    // Returns the element's group
    public int getGroup() 
    {
	return group;
    }
    public String toString()
    {
    	return "Name :"+name+" Symbol: "+symbol+" Atomic Number: "+number+" Atomic weight:  "+mass;
    	
    }
    
}