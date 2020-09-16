package gildedrose;

public class RegularItemUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public void updateQuality(Item regularItem) {
        if (regularItem.quality > 0) {
            regularItem.quality = regularItem.quality - 1;
        }
        regularItem.sellIn = regularItem.sellIn - 1;
        if (regularItem.sellIn < 0 && regularItem.quality > 0) {
            regularItem.quality = regularItem.quality - 1;
        }
    }
}
