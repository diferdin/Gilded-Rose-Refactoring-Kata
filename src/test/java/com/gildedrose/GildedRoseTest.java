package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class GildedRoseTest {
    
    @Test
    public void sellInDateShouldIncreaseButQualityShouldBeZero() {
        GildedRose app = new GildedRose(newItem().withName("myItem").withSellIn(0).withQuality(0).build());
        
        app.updateQuality();
        
        assertItemEquals(app.getItems()[0], newItem().withName("myItem").withSellIn(-1).withQuality(0).build());
    }
    
    @Test
    public void qualityShouldDecreaseWhenSellInDecreases() {
        GildedRose app = new GildedRose(newItem().withName("myItem").withSellIn(10).withQuality(10).build());
        
        app.updateQuality();
        
        assertItemEquals(app.getItems()[0], newItem().withName("myItem").withSellIn(9).withQuality(9).build());
    }
    
    @Test
    public void qualityShouldDecreaseFasterWhenSellInExpires() {
        GildedRose app = new GildedRose(newItem().withName("myItem").withSellIn(0).withQuality(10).build());
        
        app.updateQuality();
        
        assertItemEquals(app.getItems()[0], newItem().withName("myItem").withSellIn(-1).withQuality(8).build());
    }
}
