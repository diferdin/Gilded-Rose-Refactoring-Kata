package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

public interface QualityController {
    
    int MAX_QUALITY = 50;
    int STANDARD_QUALITY_DECREASE = 1;
    int STANDARD_QUALITY_INCREASE = 1;
    int DOUBLE_QUALITY_INCREASE = 2;
    
    void updateQualityFor(Item item);
    
}
