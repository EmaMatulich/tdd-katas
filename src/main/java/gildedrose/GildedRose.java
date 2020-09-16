package gildedrose;

class GildedRose {

    /**
     * All items have a SellIn value which denotes the number of days we have to sell the item
     * All items have a Quality value which denotes how valuable the item is

     * At the end of each day our system lowers both values for every item --> todo test agregado

     * Once the sell by date has passed, Quality degrades twice as fast --> todo test agregado

     * The Quality of an item is never negative --> todo test agregado

     * “Aged Brie” actually increases in Quality the older it gets -->todo test agregado

     * The Quality of an item is never more than 50 -->todo test agregado

     * “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality --> todo test agregado

     * “Backstage passes”, like aged brie, increases in Quality as its SellIn value approaches; --> todo test agregado
         * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but --> todo test agregado
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
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
