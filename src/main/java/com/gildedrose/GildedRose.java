package com.gildedrose;

import com.gildedrose.qualitycontrol.QualityControlFactory;
import com.gildedrose.qualitycontrol.QualityController;
import com.gildedrose.sellincontrol.SellInController;

import java.util.List;

public class GildedRose {
    
    private SellInController sellinController;
    private QualityControlFactory qualityControlFactory;
    
    public GildedRose(SellInController sellinController, QualityControlFactory qualityControlFactory) {
        this.sellinController = sellinController;
        this.qualityControlFactory = qualityControlFactory;
    }
    
    public void updateQualityFor(List<Item> items) {
        
        for(Item item : items) {
            updateQualityFor(item);
            updateSellInFor(item);
        }
    }
    
    private void updateQualityFor(Item item) {
        QualityController qualityController = qualityControlFactory.qualityControlFor(item);
        qualityController.updateQualityFor(item);
    }
    
    private void updateSellInFor(Item item) {
        sellinController.updateSellInFor(item);
    }
}
