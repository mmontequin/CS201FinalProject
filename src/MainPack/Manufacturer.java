/* 
 * Matt Montequin
 * CS 201 - 01
 * Final Project
 * working with Cosmin Lungu
 */

package MainPack;

public class Manufacturer {
	// Instance variables
	public String company;
	public String country;
	public String manufacturingDate;	// accepted format MM/DD/YYYY
	
	// Default constructor
	public Manufacturer () {
		company = "N/A";
		country = "N/A";
		manufacturingDate = "01/01/2000";
	}
	
	// Nondefault constructor
	public Manufacturer (String aCompany, String aCountry, String aDate) {
		company = aCompany;
		country = aCountry;
		manufacturingDate = aDate;
	}
	
	// Accessors
	public String getCompany() {
		return company;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getDate() {
		return manufacturingDate;
	}
	
	// Mutators
	public void setCompany (String aCompany) {
		company = aCompany;
	}
	
	public void setCountry (String aCountry) {
		country = aCountry;
	}
	
	public void setDate (String aDate) {
		if (isADate(aDate) == true) {
			manufacturingDate = aDate;
		}
		else {
			System.out.println("Invalid date formula. Must follow MM/DD/YYYY");
		}
	}
	
	// Equals
	public boolean equals (Manufacturer aManufacturer) {
		if (company.equals(aManufacturer.company)) {
			if (country.equals(aManufacturer.country)) {
				if (manufacturingDate.equals(aManufacturer.manufacturingDate)) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}
	
	// To String
	public String toString() {
		return company + ';' + country + ';' + manufacturingDate;
	}
	
	// Class Methods
	// isADate : boolean
	// returns true if in MM/DD/YYYY formula
	private static boolean isADate (String aDate) {
		if (aDate.length() != 10) {
			return false;
		}
		else if (aDate.charAt(2) != '/') {
			return false;
		}
		else if (aDate.charAt(5) != '/') {
			return false;
		}
		else return true;
	}
}