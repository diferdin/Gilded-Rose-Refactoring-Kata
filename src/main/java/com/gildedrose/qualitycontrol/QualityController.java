package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

public interface QualityController {
    
    int MAX_QUALITY = 50;
    int MIN_QUALITY = 0;
    int STANDARD_QUALITY_DECREASE = 1;
    int STANDARD_QUALITY_INCREASE = 1;
    
    void updateQualityFor(Item item);
    
}
