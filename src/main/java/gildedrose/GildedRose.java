package gildedrose;

class GildedRose {

    /**
     * All items have a SellIn value which denotes the number of days we have to sell the item
     * All items have a Quality value which denotes how valuable the item is

     * At the end of each day our system lowers both values for every item

     * Once the sell by date has passed, Quality degrades twice as fast

     * The Quality of an item is never negative

     * “Aged Brie” actually increases in Quality the older it gets

     * The Quality of an item is never more than 50

     * “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality

     * “Backstage passes”, like aged brie, increases in Quality as its SellIn value approaches;
         * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
         * Quality drops to 0 after the concert


     * Your Task
     * We have recently signed a supplier of conjured items. This requires an update to our system:

     * “Conjured” items degrade in Quality twice as fast as normal items
     */
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item: items){
            buildUpdateQualityStrategyForItem(item).updateQuality(item);
        }
    }

    private UpdateQualityStrategy buildUpdateQualityStrategyForItem(Item item){
        if (item.name.startsWith("Sulfuras")){
            return new SulfurasItemUpdateQualityStrategy();
        }
        if (item.name.startsWith("Aged Brie")){
            return new AgedBrieItemUpdateQualityStrategy();
        }
        if (item.name.startsWith("Backstage")){
            return new BackstageItemUpdateQualityStrategy();
        }
        if (item.name.startsWith("Conjured")){
            return new ConjuredUpdateQualityStrategy();
        }
        return new RegularItemUpdateQualityStrategy();
    }
}