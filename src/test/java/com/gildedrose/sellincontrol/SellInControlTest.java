package com.gildedrose.sellincontrol;

import com.gildedrose.Item;
import org.junit.Before;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.qualitycontrol.QualityControlFactory.SULFURAS_NAME;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SellInControlTest {
    
    private SellInController sellInController;
    
    @Before
    public void setup() {
        sellInController = new SellInController();
    }
    
    @Test
    public void shouldNotDecreaseForSulfuras() {
    
        Item sulfuras = newItem().withName(SULFURAS_NAME).withSellIn(10).build();
        sellInController.updateSellInFor(sulfuras);
    
        assertThat(sulfuras.sellIn, is(10));
        
    }
    
    @Test
    public void shouldDecreaseSellInByOne() {
    
        Item sulfuras = newItem().withName("General item").withSellIn(10).build();
        sellInController.updateSellInFor(sulfuras);
        
        assertThat(sulfuras.sellIn, is(9));
        
    }
    
}
