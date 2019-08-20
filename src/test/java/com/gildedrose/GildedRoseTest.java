package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class GildedRoseTest {
    
    @Test
    public void sellInDateShouldIncreaseButQualityShouldBeZero() {
        GildedRose app = new GildedRose(new Item("foo", 0, 0));
        
        app.updateQuality();
        
        assertItemEquals(app.getItems()[0], new Item("foo", -1, 0));
    }
    
    @Test
    public void qualityShouldDecreaseWhenSellInDecreases() {
        GildedRose app = new GildedRose(new Item("foo", 10, 10));
        
        app.updateQuality();
        
        assertItemEquals(app.getItems()[0], new Item("foo", 9, 9));
    }
    
    @Test
    public void qualityShouldDecreaseFasterWhenSellInExpires() {
        GildedRose app = new GildedRose(new Item("foo", 0, 10));
        
        app.updateQuality();
        
        assertItemEquals(app.getItems()[0], new Item("foo", -1, 8));
    }
}
