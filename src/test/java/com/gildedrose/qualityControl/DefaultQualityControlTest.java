package com.gildedrose.qualityControl;

import com.gildedrose.Item;
import com.gildedrose.qualitycontrol.DefaultQualityController;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DefaultQualityControlTest {
    
    private DefaultQualityController qualityController = new DefaultQualityController();
    
    
    @Test
    public void qualityShouldDecreaseTwiceAsFastWhenSellInIsZero() {
    
        Item standardItem = newItem().withName("Elixir of the Mongoose").withSellIn(0).withQuality(2).build();
        qualityController.updateQualityFor(standardItem);
    
        assertThat(standardItem.quality, is(0));
        
    }
    
}
