package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class AgedBrieQualityControlTest {
    
    @Test
    public void shouldIncreaseQualityAsItGetsOlder() {
        GildedRose gildedRose = new GildedRose(newItem().withName("Aged Brie").withSellIn(10).withQuality(10).build());
        gildedRose.updateQuality();
        
        
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Aged Brie").withSellIn(9).withQuality(11).build());
    }
    
    @Test
    public void qualityShouldNotExceedFifty() {
        GildedRose gildedRose = new GildedRose(newItem().withName("Aged Brie").withSellIn(10).withQuality(50).build());
        gildedRose.updateQuality();
    
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Aged Brie").withSellIn(9).withQuality(50).build());
        
    }
    
}
