package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class SulfurasQualityControlTest {
    
    @Test
    public void shouldNotSellOrChangeQuality() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(10).withQuality(30).build());
        gildedRose.updateQuality();
        
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(10).withQuality(30).build());
    }
}
