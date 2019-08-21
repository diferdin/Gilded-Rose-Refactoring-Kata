package com.gildedrose.qualityControl;

import com.gildedrose.Item;
import com.gildedrose.qualitycontrol.AgedBrieQualityController;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AgedBrieQualityControllerTest {
    
    private AgedBrieQualityController qualityControl = new AgedBrieQualityController();
    
    @Test
    public void shouldIncreaseQualityAsItGetsOlder() {
        Item agedBrie = newItem().withName("Aged Brie").withSellIn(10).withQuality(10).build();
        qualityControl.updateQualityFor(agedBrie);
    
        assertThat(agedBrie.quality, is(11));
    }
    
    @Test
    public void qualityShouldNotExceedFifty() {
        Item agedBrie = newItem().withName("Aged Brie").withSellIn(10).withQuality(50).build();
        qualityControl.updateQualityFor(agedBrie);
    
        assertThat(agedBrie.quality, is(50));
        
    }
    
}
