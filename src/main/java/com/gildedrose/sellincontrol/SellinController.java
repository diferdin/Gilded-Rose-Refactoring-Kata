package com.gildedrose.sellincontrol;

import com.gildedrose.Item;

import static com.gildedrose.qualitycontrol.QualityControlFactory.SULFURAS_NAME;

public class SellinController {
    
    private final static int DEFAULT_DECREASE = 1;
    private final static int NO_DECREASE = 0;
    
    public void updateSellInFor(Item item) {
        
        item.sellIn = item.sellIn - sellInDecreaseFor(item);
        
    }
    
    private int sellInDecreaseFor(Item item) {
        
        return item.name.equalsIgnoreCase(SULFURAS_NAME) ? NO_DECREASE : DEFAULT_DECREASE;
        
    }
}
