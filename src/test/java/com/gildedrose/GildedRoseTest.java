package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {
    
    private static final String GENERAL_ITEM_NAME = "eneral item";
    
    @Test
    public void qualityShouldNotDecreaseBelowZero() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName(GENERAL_ITEM_NAME).withSellIn(0).withQuality(0).build());
        gildedRose.updateQuality();
        
        assertThat(gildedRose.getItems()[0].quality, is(0));
    }
    
    @Test
    public void qualityShouldDecreaseWhenSellInDecreases() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName(GENERAL_ITEM_NAME).withSellIn(13).withQuality(10).build());
        gildedRose.updateQuality();
        
        assertThat(gildedRose.getItems()[0].quality, is(9));
    }
    
    @Test
    public void qualityShouldDecreaseFasterWhenSellInExpires() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName(GENERAL_ITEM_NAME).withSellIn(0).withQuality(10).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(8));
    }
}
