package edu.mum.domain;

import java.io.Serializable;

public class Item  implements Serializable {

	  
	  
     private Long id = null;

     private int version = 0;

      private String name;

 
     private String description;
     
     private double price;

     public Item() {
    	 
     }
 
     public Item(String name, String description, double price) {
    	 this.name = name;
    	 this.description = description;
    	 this.price = price;
    	 
     }
 
    // ********************** Accessor Methods ********************** //

    public Long getId() { return id; }
    public int getVersion() { return version; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

 
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

      public void setId(Long id) {
		this.id = id;
	}

    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", version=" + version + ", name=" + name + ", price=" + price + 
				", description=" + description + "]";
	}

	

  
}
