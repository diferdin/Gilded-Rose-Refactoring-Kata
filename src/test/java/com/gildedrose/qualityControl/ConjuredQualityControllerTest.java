package com.gildedrose.qualityControl;

import com.gildedrose.Item;
import com.gildedrose.qualitycontrol.ConjuredQualityController;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredQualityControllerTest {
    
    private ConjuredQualityController qualityControl = new ConjuredQualityController();
    
    @Test
    public void qualityShouldDegradeAsFastAsNormalItems() {
    
        Item conjured = newItem().withName("Conjured Mana Cake").withSellIn(1).withQuality(4).build();
        qualityControl.updateQualityFor(conjured);
    
        assertThat(conjured.quality, is(3));
    }
    
    @Test
    public void qualityShouldDegradeTwiceAsFastAsNormalItems() {
        Item conjured = newItem().withName("Conjured Mana Cake").withSellIn(0).withQuality(3).build();
        qualityControl.updateQualityFor(conjured);
    
        assertThat(conjured.quality, is(1));
    }
    
    @Test
    public void qualityShouldNotBeLessThanZero() {
        Item conjured = newItem().withName("Conjured Mana Cake").withSellIn(-1).withQuality(3).build();
        qualityControl.updateQualityFor(conjured);
        
        assertThat(conjured.quality, is(0));
    }
}
