package com.gildedrose;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class TexttestFixture {
    
    @Test
    public void checkGoldMasterCompliance() throws IOException {
    
        String goldMasterResultString = new String(Files.readAllBytes(Paths.get("src/test/resources/goldMaster.txt")));
        
        String currentResultString = buildCurrentResult().toString();
        
        assertEquals(goldMasterResultString, currentResultString);
        
    }
    
    private static StringBuilder buildCurrentResult() {
    
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OMGHAI!\n");
        
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };
        
        
        GildedRose gildedRose = new GildedRose(items);
        
        for(int i = 0; i < 31; i++) {
            stringBuilder.append(format("-------- day %s --------%n", i));
            stringBuilder.append(format("%s %s %s%n", "name,", "sellIn,", "quality"));
            for (Item item : items) {
                stringBuilder.append(format("%s, %s, %s%n", item.name, item.sellIn, item.quality));
            }
            if(i != 30) {
                stringBuilder.append(format("%n"));
            }
            
            gildedRose.updateQuality();
        }
        
        return stringBuilder;
    }
}
