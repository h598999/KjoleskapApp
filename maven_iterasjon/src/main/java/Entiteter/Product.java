package Entiteter;

import HjelpeKlasser.Ingredients_translation;
import HjelpeKlasser.NameTranslations;
import HjelpeKlasser.Origin_translation;
import HjelpeKlasser.Product_nutrients;
import HjelpeKlasser.image;

public class Product {
	
	private int id;
	private String barcode;
	private NameTranslations nameTranslation;
	private HjelpeKlasser.displayNameTranslation displayNameTranslation;
	private Ingredients_translation Ingredients;
	private Origin_translation origins;
	private String status;
	private double quantity;
	private String unit;
	private double portion_quantity;
	private String portion_unit;
	private String hundred_unit;
	private double alcohol_by_volume;
	private image images;
	private Product_nutrients nutriens;
	private String created_at;
	private String updated_at;
	
	
	
	

}
