package gildedrose;

public class Item {

    public String name;

    //number of days we have to sell the item
    public int sellIn;

    // how valuable the item is
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
