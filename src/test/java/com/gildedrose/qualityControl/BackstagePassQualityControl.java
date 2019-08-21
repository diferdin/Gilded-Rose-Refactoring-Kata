package com.gildedrose.qualityControl;

import com.gildedrose.GildedRose;
import org.junit.Test;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BackstagePassQualityControl {
    
    private static final int TWENTY_DAYS = 20;
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;
    private static final int ZERO_DAYS = 0;
    
    @Test
    public void shouldIncreaseQualityAsDaysPass() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(TWENTY_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(11));
        
    }
    
    @Test
    public void qualityIncreaseShouldDoubleWhenSellInIsLessThanElevenDays() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(TEN_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(12));
        
    }
    
    @Test
    public void qualityIncreaseShouldTripleWhenSellInIsLessThanSixDays() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(FIVE_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
        
        assertThat(gildedRose.getItems()[0].quality, is(13));
        
    }
    
    @Test
    public void qualityShouldDropToZeroAfterConcert() {
        
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(ZERO_DAYS).withQuality(10).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(0));
        
    }
    
    @Test
    public void qualityShouldNotExceedFifty() {
    
        GildedRose gildedRose = new GildedRose(newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(TEN_DAYS).withQuality(50).build());
        gildedRose.updateQuality();
    
        assertThat(gildedRose.getItems()[0].quality, is(50));
        
    }
    
}
