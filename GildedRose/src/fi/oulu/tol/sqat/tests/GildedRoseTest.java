package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void zeroQuality() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 3));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for Dexterity Vest", 0, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for Dexterity Vest", 0, quality);
	}
	
	@Test
	public void testSellIn() {
		//create an inn, add an item, and simulate five days
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 5, 3));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//access a list of items
		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		//assert sellIn has decreased by five
		assertEquals("Failed SellIn for Dexterity Vest", 0, sellIn);
		
		inn.oneDay();
		
		//access a list of items
		items = inn.getItems();
		sellIn = items.get(0).getSellIn();
		
		//assert SellIn has decreased by one
		assertEquals("Failed SellIn for Dexterity Vest", -1, sellIn);
	}
	
	@Test
	public void testQualityWhenSellInIsNegative() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", -1, 10));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for Dexterity Vest", 8, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for Dexterity Vest", 6, quality);
	}
	
	@Test
	public void testAgedBrie() {
		String itemName = "Aged Brie";
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item(itemName, 2, 46));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for " + itemName, 47, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 48, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 50, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName + 
				"Quality increased over 50", 50, quality);
	}
	
	@Test
	public void testSulfuras() {
		String itemName = "Sulfuras, Hand of Ragnaros";
		//create an inn, add an item, and simulate six days
		GildedRose inn = new GildedRose();
		inn.setItem(new Item(itemName, 0, 80));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for " + itemName, 80, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 80, quality);
	}
	
	@Test
	public void testSulfurasNegativeSellIn() {
		String itemName = "Sulfuras, Hand of Ragnaros";
		//create an inn, add an item, and simulate six days
		GildedRose inn = new GildedRose();
		inn.setItem(new Item(itemName, -1, 80));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		int SellIn = items.get(0).getSellIn();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for " + itemName, 80, quality);
		assertEquals("Failed SellIn for " + itemName, -1, SellIn);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
	    SellIn = items.get(0).getSellIn();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 80, quality);
		assertEquals("Failed SellIn for " + itemName, -1, SellIn);
	}
	
	@Test
	public void testSulfurasPostiveSellIn() {
		String itemName = "Sulfuras, Hand of Ragnaros";
		//create an inn, add an item, and simulate six days
		GildedRose inn = new GildedRose();
		inn.setItem(new Item(itemName, 1, 80));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		int SellIn = items.get(0).getSellIn();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for " + itemName, 80, quality);
		assertEquals("Failed SellIn for " + itemName, 1, SellIn);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
	    SellIn = items.get(0).getSellIn();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 80, quality);
		assertEquals("Failed SellIn for " + itemName, 1, SellIn);
	}
		
	@Test
	public void testBackstage() {
		String itemName = "Backstage passes to a TAFKAL80ETC concert";
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item(itemName, 11, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for " + itemName, 21, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 23, quality);
		
		inn = new GildedRose();
		inn.setItem(new Item(itemName, 5, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for " + itemName, 23, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 26, quality);
		
		inn = new GildedRose();
		inn.setItem(new Item(itemName, 1, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality has decreased to zero
		assertEquals("Failed quality for " + itemName, 23, quality);
		
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		items = inn.getItems();
		quality = items.get(0).getQuality();
		
		//assert quality is not negative
		assertEquals("Failed quality for " + itemName, 0, quality);
	}
	
	@Test
	public void testMain() {
		GildedRose.main(new String[0]);
	}
}
