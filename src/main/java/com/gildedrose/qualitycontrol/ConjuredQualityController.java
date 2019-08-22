package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

public class ConjuredQualityController implements QualityController {
    
    private static final int CONJURED_QUALITY_DECREASE = STANDARD_QUALITY_DECREASE * 2;
    
    @Override
    public void updateQualityFor(Item conjuredItem) {
        conjuredItem.quality = conjuredItem.quality - qualityDecreaseFor(conjuredItem);
    }
    
    private int qualityDecreaseFor(Item conjuredItem) {
        
        if(sellInIsPositive(conjuredItem)) {
            return STANDARD_QUALITY_DECREASE;
        } else
            return conjuredItem.sellIn == 0 ? CONJURED_QUALITY_DECREASE : conjuredItem.quality;
        }
        
    private boolean sellInIsPositive(Item conjuredItem) {
        return conjuredItem.sellIn > 0;
    }
}
