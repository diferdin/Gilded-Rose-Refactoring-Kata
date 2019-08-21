package com.gildedrose;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.gildedrose.ItemBuilder.newItem;
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
        
        Item[] items = new Item[]{
        
                newItem().withName("+5 Dexterity Vest").withSellIn(10).withQuality(20).build(),
                newItem().withName("Aged Brie").withSellIn(2).withQuality(0).build(),
                newItem().withName("Elixir of the Mongoose").withSellIn(5).withQuality(7).build(),
                newItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(0).withQuality(80).build(),
                newItem().withName("Sulfuras, Hand of Ragnaros").withSellIn(-1).withQuality(80).build(),
                newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(15).withQuality(20).build(),
                newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(10).withQuality(49).build(),
                newItem().withName("Backstage passes to a TAFKAL80ETC concert").withSellIn(5).withQuality(49).build(),
        
                // this conjured newItem does not work properly yet
                new ItemBuilder().withName("Conjured Mana Cake").withSellIn(3).withQuality(6).build()
        };
        
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
