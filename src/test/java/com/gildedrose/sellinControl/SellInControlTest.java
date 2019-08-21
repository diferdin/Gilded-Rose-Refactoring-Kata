package com.gildedrose.sellinControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SellInControlTest {
    
    @Test
    public void shouldNotDecreaseForSulfuras() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(10).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].sellIn, is(10));
        
    }
    
    @Test
    public void shouldDecreaseSellInByOne() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("General item").withSellIn(10).build());
        gildedRose.updateQuality();
        
        assertThat(gildedRose.getItems()[0].sellIn, is(9));
        
    }
    
}
