package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredQualityControlTest {
    
    @Test
    public void qualityShouldDegradeTwiceAsFastAsNormalItems() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Conjured Mana Cake").withSellIn(10).withQuality(30).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(28));
        
    }
    
}
