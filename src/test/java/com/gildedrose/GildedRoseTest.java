package com.gildedrose;

import com.gildedrose.qualitycontrol.DefaultQualityController;
import com.gildedrose.qualitycontrol.QualityControlFactory;
import com.gildedrose.sellincontrol.SellinController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static com.gildedrose.ItemBuilder.newItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GildedRoseTest {
    
    private static final String GENERAL_ITEM_NAME = "General item";
    
    @Mock private SellinController sellinController;
    @Mock private QualityControlFactory qualityControlFactory;
    @Mock private DefaultQualityController defaultQualityController;
    
    private GildedRose gildedRose;
    private Item generalItem1;
    private Item generalItem2;
    
    @Before
    public void setup() {
        
        when(qualityControlFactory.qualityControlFor(Mockito.any(Item.class))).thenReturn(defaultQualityController);
        
        gildedRose = new GildedRose(sellinController, qualityControlFactory);
        generalItem1 = newItem().build();
        generalItem2 = newItem().build();
    }
    
    @Test
    public void qualityShouldNotDecreaseBelowZero() {
        
        gildedRose.updateQualityFor(Arrays.asList(generalItem1, generalItem2));
        verifyQualityUpdateFor(Arrays.asList(generalItem1, generalItem2));
        
        
        assertThat(gildedRose.getItems()[0].quality, is(0));
    }
    
    @Test
    public void qualityShouldDecreaseFasterWhenSellInExpires() {
    
        
        gildedRose.updateQualityFor(Arrays.asList(generalItem1, generalItem2));
        verifyQualityUpdateFor(Arrays.asList(generalItem1, generalItem2));
        verifySellInUpdateFor(Arrays.asList(generalItem1, generalItem2));
        
    }
    
    private void verifySellInUpdateFor(List<Item> items) {
        
        for(Item item : items) {
            verify(sellinController).updateSellInFor(item);
        }
    }
    
    private void verifyQualityUpdateFor(List<Item> items) {
        
        for(Item item : items) {
            verify(defaultQualityController).updateQualityFor(item);
        }
        
    }
}
