package com.gildedrose.qualityControl;

import com.gildedrose.Item;
import com.gildedrose.qualitycontrol.SulfurasQualityController;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SulfurasQualityControllerTest {
    
    private SulfurasQualityController qualityControl = new SulfurasQualityController();
    
    @Test
    public void shouldNotSellOrChangeQuality() {
        
        Item sulfuras = newItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(10).withQuality(30).build();
        qualityControl.updateQualityFor(sulfuras);
        
        assertThat(sulfuras.quality, is(30));
    }
}
