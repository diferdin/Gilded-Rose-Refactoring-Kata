package com.gildedrose.qualitycontrol;

import com.gildedrose.Item;

public class SulfurasQualityController implements QualityController {
    @Override
    public void updateQualityFor(Item item) {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }
}
