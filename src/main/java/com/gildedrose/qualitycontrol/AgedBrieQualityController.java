package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class AgedBrieQualityController implements QualityController {
    @Override
    public void updateQualityFor(Item item) {
        item.quality = qualityFor(item);
    }
    
    private int qualityFor(Item item) {
        return min(item.quality + STANDARD_QUALITY_INCREASE, MAX_QUALITY);
    }
}
