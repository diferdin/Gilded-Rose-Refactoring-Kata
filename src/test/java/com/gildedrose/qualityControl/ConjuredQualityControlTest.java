package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class ConjuredQualityControlTest {
    
    @Test
    public void qualityShouldDegradeTwiceAsFastAsNormalItems() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Conjured Mana Cake").withSellIn(10).withQuality(30).build());
        gildedRose.updateQuality();
        
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Conjured Mana Cake").withSellIn(9).withQuality(28).build());
        
    }
    
}
