package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgedBrieQualityControlTest {
    
    @Test
    public void shouldIncreaseQualityAsItGetsOlder() {
        GildedRose gildedRose = new GildedRose(newItem().withName("Aged Brie").withSellIn(10).withQuality(10).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(11));
    }
    
    @Test
    public void qualityShouldNotExceedFifty() {
        GildedRose gildedRose = new GildedRose(newItem().withName("Aged Brie").withSellIn(10).withQuality(50).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(50));
        
    }
    
}
