package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class BackstagePassQualityControl {
    
    private static final int TWENTY_DAYS = 20;
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;
    private static final int ZERO_DAYS = 0;
    
    @Test
    public void shouldIncreaseQualityAsDaysPass() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(TWENTY_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
        
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(19).withQuality(11).build());
        
    }
    
    @Test
    public void qualityIncreaseShouldDoubleWhenSellInIsLessThanElevenDays() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(TEN_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
    
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(9).withQuality(12).build());
        
    }
    
    @Test
    public void qualityIncreaseShouldTripleWhenSellInIsLessThanSixDays() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(FIVE_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
        
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(4).withQuality(13).build());
        
    }
    
    @Test
    public void qualityShouldDropToZeroAfterConcert() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(ZERO_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
        
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(-1).withQuality(0).build());
        
    }
    
    @Test
    public void qualityShouldNotExceedFifty() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(TEN_DAYS).withQuality(50).build());
        gildedRose.updateQuality();
    
        assertItemEquals(gildedRose.getItems()[0], newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(9).withQuality(50).build());
        
    }
    
}
