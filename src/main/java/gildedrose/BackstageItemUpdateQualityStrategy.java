package gildedrose;

public class BackstageItemUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public void updateQuality(Item backstageItem) {
        if (backstageItem.quality < 50) {
            backstageItem.quality = backstageItem.quality + 1;
            if (backstageItem.sellIn < 11 && backstageItem.quality < 50) {
                backstageItem.quality = backstageItem.quality + 1;
            }
            if (backstageItem.sellIn < 6 && backstageItem.quality < 50) {
                backstageItem.quality = backstageItem.quality + 1;
            }
        }
        backstageItem.sellIn = backstageItem.sellIn - 1;

        if (backstageItem.sellIn < 0) {
            backstageItem.quality = 0;
        }
    }
}


