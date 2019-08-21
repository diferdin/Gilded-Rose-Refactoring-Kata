package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

import static java.lang.Math.min;

public class BackstagePassQualityController implements QualityController {
    
    private static final int NO_INCREASE = 0;
    private static final int DOUBLE_INCREASE = 2;
    private static final int STANDARD_QUALITY_INCREASE = 1;
    
    private static final int ELEVEN_DAYS = 11;
    private static final int FIVE_DAYS = 5;
    
    @Override
    public void updateQualityFor(Item backstagePass) {
        backstagePass.quality = qualityFor(backstagePass);
    }
    
    private int qualityFor(Item backstagePass) {
        return backstagePass.sellIn > 0 ? min(backstagePass.quality + increaseFor(backstagePass), MAX_QUALITY) : 0;
    }
    
    private int increaseFor(Item backstagePass) {
        return STANDARD_QUALITY_INCREASE + extraQualityFor(backstagePass);
    }
    
    private int extraQualityFor(Item backstagePass) {
        if(concertWithinSixToTenDays(backstagePass)) {
            return STANDARD_QUALITY_INCREASE;
        } else if(concertIsInFiveDaysOrLess(backstagePass)) {
            return DOUBLE_INCREASE;
        }
        
        return NO_INCREASE;
    }
    
    private boolean concertIsInFiveDaysOrLess(Item backstagePass) {
        return backstagePass.sellIn <= FIVE_DAYS;
    }
    
    private boolean concertWithinSixToTenDays(Item backstagePass) {
        return backstagePass.sellIn <= ELEVEN_DAYS;
    }
    
    
}
