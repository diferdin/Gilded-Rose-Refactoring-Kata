package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

public class QualityControlFactory {
    
    public static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE_NAME = "Aged Brie";
    public static final String CONJURED_NAME = "Conjured Mana Cake";
    
    private enum SpecialItemQualityControl {
    
        AGED_BRIE("Aged Brie", new AgedBrieQualityController()),
        CONJURED(CONJURED_NAME, new ConjuredQualityController()),
        BACKSTAGE_PASS(BACKSTAGE_PASS_NAME, new BackstagePassQualityController()),
        SULFURAS(SULFURAS_NAME, new SulfurasQualityController());
    
        private String itemName;
        private QualityController qualityController;
        
        SpecialItemQualityControl(String itemName, QualityController qualityController) {
            this.itemName = itemName;
            this.qualityController = qualityController;
        }
        
        public static QualityController qualityControlFor(Item item) {
            
            for(SpecialItemQualityControl qualityControl : SpecialItemQualityControl.values()) {
                if(qualityControl.itemName.equalsIgnoreCase(item.name)) {
                    return qualityControl.qualityController;
                }
            }
            
            return new DefaultQualityController();
            
        }
    }
    
    public QualityController qualityControlFor(Item item) {
        return SpecialItemQualityControl.qualityControlFor(item);
    }
}
