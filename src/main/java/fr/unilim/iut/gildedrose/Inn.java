package fr.unilim.iut.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {
    private List<Item> items;

    public Inn() {
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            if (!isAged_brie(i) && !isBackStagePasses(i) && !isSulfuras(i)) {
                diminuer_qualite_de_1(i);
            } else {
                if (qualite_inferieure_a_50(i)) {
                    augmenter_qualite_de_1(i);

                    if (isBackStagePasses(i)) {
                        if (items.get(i).getSellIn() < 11) {
                            augmenter_qualite_de_1(i);
                        }

                        if (items.get(i).getSellIn() < 6) {
                            augmenter_qualite_de_1(i);
                        }
                    }
                }
            }

            if (!isSulfuras(i)) {
                diminuer_sellin_de_1(i);
            }

            if (produit_perimer(i)) {
                if (!isAged_brie(i)) {
                    if (!isBackStagePasses(i)) {
                        if (!isSulfuras(i)) {
                            diminuer_qualite_de_1(i);
                        }
                    } else {
                        remettre_Qualite_A_0(i);
                    }
                } else {
                    augmenter_qualite_de_1(i);
                }
            }
        }

    }

    private boolean produit_perimer(int i) {
        return items.get(i).getSellIn() < 0;
    }

    private void diminuer_qualite_de_1(int i) {
        if (qualite_superieure_a_0(i)) {
            items.get(i).setQuality(items.get(i).getQuality() - 1);
        }
    }

    private void diminuer_sellin_de_1(int i) {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
    }

    private void augmenter_qualite_de_1(int i) {
        if (qualite_inferieure_a_50(i)) {
            items.get(i).setQuality(items.get(i).getQuality() + 1);
        }
    }

    private void remettre_Qualite_A_0(int i) {
        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
    }

    private boolean qualite_inferieure_a_50(int i) {
        return items.get(i).getQuality() < 50;
    }

    private boolean isSulfuras(int i) {
        return items.get(i).getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean qualite_superieure_a_0(int i) {
        return items.get(i).getQuality() > 0;
    }

    private boolean isBackStagePasses(int i) {
        return items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAged_brie(int i) {
        return items.get(i).getName().equals("Aged Brie");
    }


}