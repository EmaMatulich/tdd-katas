package gildedrose;

public class ConjuredUpdateQualityStrategy implements UpdateQualityStrategy{
    @Override
    public void updateQuality(Item conjuredItem) {
        if (conjuredItem.quality > 0) {
            conjuredItem.quality = conjuredItem.quality - 2;
        }
        conjuredItem.sellIn = conjuredItem.sellIn - 1;
        if (conjuredItem.sellIn < 0 && conjuredItem.quality > 0){
            conjuredItem.quality = conjuredItem.quality - 2;
        }
    }
}
