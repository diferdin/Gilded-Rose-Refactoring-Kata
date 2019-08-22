package com.gildedrose.qualityControl;

import com.gildedrose.Item;
import com.gildedrose.qualitycontrol.ConjuredQualityController;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.qualitycontrol.QualityControlFactory.CONJURED_NAME;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConjuredQualityControllerTest {
    
    private ConjuredQualityController qualityControl = new ConjuredQualityController();
    
    @Test
    public void qualityShouldDegradeAsFastAsNormalItems() {
    
        Item conjured = newItem().withName(CONJURED_NAME).withSellIn(1).withQuality(4).build();
        qualityControl.updateQualityFor(conjured);
    
        assertThat(conjured.quality, is(3));
    }
    
    @Test
    public void qualityShouldDegradeTwiceAsFastWhenSellInIsZero() {
        Item conjured = newItem().withName(CONJURED_NAME).withSellIn(0).withQuality(3).build();
        qualityControl.updateQualityFor(conjured);
    
        assertThat(conjured.quality, is(1));
    }
    
    @Test
    public void qualityShouldBeZeroedWhenSellInIsNegative() {
        Item conjured = newItem().withName(CONJURED_NAME).withSellIn(-2).withQuality(3).build();
        qualityControl.updateQualityFor(conjured);
        
        assertThat(conjured.quality, is(0));
    }
}
