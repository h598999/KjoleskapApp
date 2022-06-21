package Entiteter;

import HjelpeKlasser.Ingredients_translation;
import HjelpeKlasser.NameTranslations;
import HjelpeKlasser.Origin_translation;
import HjelpeKlasser.Product_Nutrient_Object;
import HjelpeKlasser.Product_Nutrients_Object;
import HjelpeKlasser.image;

public class Product {
	
	private int id;
	private String barcode;
	private NameTranslations nameTranslation;
	private HjelpeKlasser.displayNameTranslation displayNameTranslation;
	private NameTranslations Ingredients;
	private Origin_translation origins;
	private String status;
	private double quantity;
	private String unit;
	private double portion_quantity;
	private String portion_unit;
	private String hundred_unit;
	private double alcohol_by_volume;
	private image images;
	private String created_at;
	private String updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public NameTranslations getNameTranslation() {
		return nameTranslation;
	}
	public void setNameTranslation(NameTranslations nameTranslation) {
		this.nameTranslation = nameTranslation;
	}
	public HjelpeKlasser.displayNameTranslation getDisplayNameTranslation() {
		return displayNameTranslation;
	}
	public void setDisplayNameTranslation(HjelpeKlasser.displayNameTranslation displayNameTranslation) {
		this.displayNameTranslation = displayNameTranslation;
	}
	public NameTranslations getIngredients() {
		return Ingredients;
	}
	public void setIngredients(NameTranslations ingredients) {
		Ingredients = ingredients;
	}
	public Origin_translation getOrigins() {
		return origins;
	}
	public void setOrigins(Origin_translation origins) {
		this.origins = origins;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPortion_quantity() {
		return portion_quantity;
	}
	public void setPortion_quantity(double portion_quantity) {
		this.portion_quantity = portion_quantity;
	}
	public String getPortion_unit() {
		return portion_unit;
	}
	public void setPortion_unit(String portion_unit) {
		this.portion_unit = portion_unit;
	}
	public String getHundred_unit() {
		return hundred_unit;
	}
	public void setHundred_unit(String hundred_unit) {
		this.hundred_unit = hundred_unit;
	}
	public double getAlcohol_by_volume() {
		return alcohol_by_volume;
	}
	public void setAlcohol_by_volume(double alcohol_by_volume) {
		this.alcohol_by_volume = alcohol_by_volume;
	}
	public image getImages() {
		return images;
	}
	public void setImages(image images) {
		this.images = images;
	}

	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	

}
