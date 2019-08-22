package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class AgedBrieQualityController implements QualityController {
    @Override
    public void updateQualityFor(Item agedBrie) {
        agedBrie.quality = qualityFor(agedBrie);
    }
    
    private int qualityFor(Item agedBrie) {
        
        if(sellInIsNegative(agedBrie)) {
            return min(agedBrie.quality + DOUBLE_QUALITY_INCREASE, MAX_QUALITY);
        } else {
            return min(agedBrie.quality + STANDARD_QUALITY_INCREASE, MAX_QUALITY);
        }
    }
    
    private boolean sellInIsNegative(Item agedBrie) {
        return agedBrie.sellIn <= 0;
    }
}
