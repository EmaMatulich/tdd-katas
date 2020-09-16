package gildedrose;

public class AgedBrieItemUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public void updateQuality(Item agedBrieItem) {
        if (agedBrieItem.quality < 50) {
            agedBrieItem.quality = agedBrieItem.quality + 1;
        }
        agedBrieItem.sellIn = agedBrieItem.sellIn - 1;
        if (agedBrieItem.sellIn < 0 && agedBrieItem.quality < 50) {
            agedBrieItem.quality = agedBrieItem.quality + 1;
        }

    }
}

