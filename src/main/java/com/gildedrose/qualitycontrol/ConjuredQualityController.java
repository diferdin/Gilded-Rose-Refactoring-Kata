package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

public class ConjuredQualityController implements QualityController {
    
    private static final int CONJURED_QUALITY_DECREASE = STANDARD_QUALITY_DECREASE * 2;
    private static final int CONJURED_ZERO_DECREASE = 0;
    
    @Override
    public void updateQualityFor(Item conjuredItem) {
        conjuredItem.quality = conjuredItem.quality - qualityDropFor(conjuredItem);
    }
    
    private int qualityDropFor(Item conjuredItem) {
        
        if(sellInIsZero(conjuredItem)) {
            return CONJURED_QUALITY_DECREASE;
        } else if(sellInIsNegative(conjuredItem)) {
            return conjuredItem.quality;
        } else {
            return STANDARD_QUALITY_DECREASE;
        }
        
        
    }
    
    private boolean sellInIsNegative(Item conjuredItem) {
        return conjuredItem.sellIn < 0;
    }
    
    private boolean sellInIsZero(Item conjuredItem) {
        return conjuredItem.sellIn == 0;
    }
}
