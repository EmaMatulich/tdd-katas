package gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

    @Test
    public void GivenRegularItemWithQualityZeroWhenUpdateQualityThenQualityIsZero(){
        Item fooItem =  new Item("foo", 3, 0);
        GildedRose app = new GildedRose(new Item[] { fooItem });
        app.updateQuality();
        assertEquals(0, fooItem.quality);
        assertEquals(2, fooItem.sellIn);
    }

    @Test
    public void GivenRegularItemWithQualityAndSellInZeroWhenUpdateQualityThenQualityIsZeroAndSellInNegative(){
        Item fooItem =  new Item("foo", 0, 0);
        GildedRose app = new GildedRose(new Item[] { fooItem });
        app.updateQuality();
        assertEquals(0, fooItem.quality);
        assertTrue(fooItem.sellIn < 0);
    }

    @Test
    public void GivenRegularItemWithQualityAndSellpositiveWhenUpdateQualityThenQualityAndSellInPositive(){
        Item fooItem =  new Item("foo", 3, 3);
        GildedRose app = new GildedRose(new Item[] { fooItem });
        app.updateQuality();
        assertEquals(2, fooItem.quality);
        assertEquals(2, fooItem.sellIn);
    }

    @Test
    public void GivenRegularItemWithSellByDateExpriedWhenUpdateQualityThenQualityReduceBy2(){
        Item fooItem =  new Item("foo", 0, 3);
        GildedRose app = new GildedRose(new Item[] { fooItem });
        app.updateQuality();
        assertEquals(1, fooItem.quality);
        assertEquals(-1, fooItem.sellIn);
    }

    @Test
    public void GivenSulfurasItemWhenUpdateQualityThenQualityAndSellInNotModified(){
        Item sulfurasItem =  new Item("Sulfuras, Hand of Ragnaros", 3, 3);
        GildedRose app = new GildedRose(new Item[] { sulfurasItem });
        app.updateQuality();
        assertEquals(3, sulfurasItem.quality);
        assertEquals(3, sulfurasItem.sellIn);
    }

    @Test
    public void GivenAgedBrieItemWhenUpdateQualityThenQualityIncremented(){
        Item AgedBrie =  new Item("Aged Brie", 3, 3);
        GildedRose app = new GildedRose(new Item[] { AgedBrie });
        app.updateQuality();
        assertEquals(4, AgedBrie.quality);
        assertEquals(2, AgedBrie.sellIn);
    }

    @Test
    public void GivenAgedBrieExpiredItemWhenUpdateQualityThenQualityIncrementedBy2(){
        Item AgedBrie =  new Item("Aged Brie", 0, 3);
        GildedRose app = new GildedRose(new Item[] { AgedBrie });
        app.updateQuality();
        assertEquals(5, AgedBrie.quality);
        assertEquals(-1, AgedBrie.sellIn);
    }

    @Test
    public void GivenAgedBrieItemWithMaxOfQualityWhenUpdateQualityThenQualityNotIncrementedBy(){
        Item AgedBrie =  new Item("Aged Brie", 3, 50);
        GildedRose app = new GildedRose(new Item[] { AgedBrie });
        app.updateQuality();
        assertEquals(50, AgedBrie.quality);
        assertEquals(2, AgedBrie.sellIn);
    }

    @Test
    public void GivenBackstageItemWithMoreThan10SellinWhenUpdateQualityThenQualityIncrementedBy1(){
        Item backstageitem =  new Item("Backstage passes to a TAFKAL80ETC concert", 14, 14);
        GildedRose app = new GildedRose(new Item[] { backstageitem });
        app.updateQuality();
        assertEquals(15, backstageitem.quality);
        assertEquals(13, backstageitem.sellIn);
    }

    @Test
    public void GivenBackstageItemWithin10And6SellInWhenUpdateQualityThenQualityIncrementedBy2(){
        Item backstageitem =  new Item("Backstage passes to a TAFKAL80ETC concert", 8, 14);
        GildedRose app = new GildedRose(new Item[] { backstageitem });
        app.updateQuality();
        assertEquals(16, backstageitem.quality);
        assertEquals(7, backstageitem.sellIn);
    }

    @Test
    public void GivenBackstageItemWith5OrLessSellInWhenUpdateQualityThenQualityIncrementedBy3(){
        Item backstageitem =  new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5);
        GildedRose app = new GildedRose(new Item[] { backstageitem });
        app.updateQuality();
        assertEquals(8, backstageitem.quality);
        assertEquals(3, backstageitem.sellIn);
    }

    @Test
    public void GivenBackstageItemWithSellInExpiredWhenUpdateQualityThenQualityIsZero(){
        Item backstageitem =  new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);
        GildedRose app = new GildedRose(new Item[] { backstageitem });
        app.updateQuality();
        assertEquals(0, backstageitem.quality);
        assertEquals(-1, backstageitem.sellIn);
    }

    @Test
    public void GivenConjuredItemWithQualityZeroWhenUpdateQualityThenQualityIsZero(){
        Item conjuredItem =  new Item("Conjured peelio", 3, 0);
        GildedRose app = new GildedRose(new Item[] { conjuredItem });
        app.updateQuality();
        assertEquals(0, conjuredItem.quality);
        assertEquals(2, conjuredItem.sellIn);
    }

    @Test
    public void GivenConjuredItemWithQualityAndSellInZeroWhenUpdateQualityThenQualityIsZeroAndSellInNegative(){
        Item conjuredItem =  new Item("Conjured peelio", 0, 0);
        GildedRose app = new GildedRose(new Item[] { conjuredItem });
        app.updateQuality();
        assertEquals(0, conjuredItem.quality);
        assertEquals(conjuredItem.sellIn , -1);
    }

    @Test
    public void GivenConjuredItemWithQualityAndSellpositiveWhenUpdateQualityThenQualityDecrementedBy2(){
        Item conjuredItem =  new Item("Conjured foo", 3, 3);
        GildedRose app = new GildedRose(new Item[] { conjuredItem });
        app.updateQuality();
        assertEquals(1, conjuredItem.quality);
        assertEquals(2, conjuredItem.sellIn);
    }

    @Test
    public void GivenConjuredItemWithSellByDateExpriedWhenUpdateQualityThenQualityReduceBy4(){
        Item conjuredItem =  new Item("Conjured foo", 0, 5);
        GildedRose app = new GildedRose(new Item[] { conjuredItem });
        app.updateQuality();
        assertEquals(1, conjuredItem.quality);
        assertEquals(-1, conjuredItem.sellIn);
    }



}
