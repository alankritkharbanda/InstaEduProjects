public class Person2 implements Comparable<Person2> {
	
	private String name;

    private int birthYear;

    /**
     * Constructs a Person object.
     * @param name Name of the Person
     * @param birthYear Year of birth
     */
    public Person2(String name, int birthYear) {

        this.name = name;
        this.birthYear = birthYear;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {

        return name;
    }

    /**
     * @return Returns the birthYear.
     */
    public int getBirthYear() {

        return birthYear;
    }

    /**
     * Returns a string representation of the object.
     * @see java.lang.Object#toString()
     */
    public String toString() {

        return "Person[name=" + name + ",birthYear=" + birthYear + "]";
    }

	public int compareTo(Person2 arg0) {
		// TODO Auto-generated method stub
		return birthYear-arg0.getBirthYear();
		
	}

	

	
}