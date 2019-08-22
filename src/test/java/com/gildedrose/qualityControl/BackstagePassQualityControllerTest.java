package com.gildedrose.qualityControl;

import com.gildedrose.Item;
import com.gildedrose.qualitycontrol.BackstagePassQualityController;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.qualitycontrol.QualityControlFactory.BACKSTAGE_PASS_NAME;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BackstagePassQualityControllerTest {
    
    private static final int TWENTY_DAYS = 20;
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;
    private static final int ZERO_DAYS = 0;
    
    private BackstagePassQualityController qualityControl = new BackstagePassQualityController();
    
    @Test
    public void shouldIncreaseQualityAsDaysPass() {
    
        Item backstagePass = newItem().withName(BACKSTAGE_PASS_NAME).withSellIn(TWENTY_DAYS).withQuality(10).build();
        qualityControl.updateQualityFor(backstagePass);
    
        assertThat(backstagePass.quality, is(11));
        
    }
    
    @Test
    public void qualityIncreaseShouldDoubleWhenSellInIsLessThanElevenDays() {
    
        Item backstagePass =  newItem().withName(BACKSTAGE_PASS_NAME).withSellIn(TEN_DAYS).withQuality(10).build();
        qualityControl.updateQualityFor(backstagePass);
    
        assertThat(backstagePass.quality, is(12));
        
    }
    
    @Test
    public void qualityIncreaseShouldTripleWhenSellInIsLessThanSixDays() {
    
        Item backstagePass = newItem().withName(BACKSTAGE_PASS_NAME).withSellIn(FIVE_DAYS).withQuality(10).build();
        qualityControl.updateQualityFor(backstagePass);
        
        assertThat(backstagePass.quality, is(13));
        
    }
    
    @Test
    public void qualityShouldDropToZeroAfterConcert() {
    
        Item backstagePass = newItem().withName(BACKSTAGE_PASS_NAME).withSellIn(ZERO_DAYS).withQuality(10).build();
        qualityControl.updateQualityFor(backstagePass);
    
        assertThat(backstagePass.quality, is(0));
        
    }
    
    @Test
    public void qualityShouldNotExceedFifty() {
    
        Item backstagePass = newItem().withName(BACKSTAGE_PASS_NAME).withSellIn(TEN_DAYS).withQuality(50).build();
        qualityControl.updateQualityFor(backstagePass);
    
        assertThat(backstagePass.quality, is(50));
        
    }
    
}
