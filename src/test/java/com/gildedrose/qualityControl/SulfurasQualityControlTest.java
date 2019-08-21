package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasQualityControlTest {
    
    @Test
    public void shouldNotSellOrChangeQuality() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(10).withQuality(30).build());
        gildedRose.updateQuality();
        
        assertThat(gildedRose.getItems()[0].sellIn, is(10));
        assertThat(gildedRose.getItems()[0].quality, is(30));
    }
}
