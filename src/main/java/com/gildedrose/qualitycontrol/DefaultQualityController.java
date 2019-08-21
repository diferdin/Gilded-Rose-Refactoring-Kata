package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

public class DefaultQualityController implements QualityController {
    
    @Override
    public void updateQualityFor(Item item) {
        item.quality = (item.quality - qualityDecreaseFor(item));
    }
    
    private int qualityDecreaseFor(Item item) {
        
        int standardQualityDecrease = standardQualityDecreaseFor(item);
        
        return item.quality - standardQualityDecrease >= 0 ? standardQualityDecrease : item.quality;
        
    }
    
    private int standardQualityDecreaseFor(Item item) {
        
        return item.sellIn < 0 ? STANDARD_QUALITY_DECREASE * 2 : STANDARD_QUALITY_DECREASE;
        
    }
}
