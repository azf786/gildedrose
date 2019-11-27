package fr.unilim.iut.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.Assert.assertEquals;

public class InnTest {
    @Test
    public void test_update_qualité_sellin_diminue_de_1_pour_les_produit_normaux() {
      Inn inn = new Inn();
      inn.updateQuality();

      assertEquals(9, inn.getItems().get(0).getSellIn());
      assertEquals(19, inn.getItems().get(0).getQuality());
    }
  @Test
  public void test_update_qualité_diminue_de_2_apres_peremption_pour_les_produit_normaux() {
    Inn inn = new Inn();

    for(int i = 0; i<10; i++){
      inn.updateQuality();
    }

    inn.updateQuality();
    assertEquals(-1, inn.getItems().get(0).getSellIn());
    assertEquals(8, inn.getItems().get(0).getQuality());
  }

  @Test
  public void test_update_qualité_n_est_jamais_negative() {
    Inn inn = new Inn();

    for(int i = 0; i<15; i++){
      inn.updateQuality();
    }

    inn.updateQuality();
    assertEquals(-6, inn.getItems().get(0).getSellIn());
    assertEquals(0, inn.getItems().get(0).getQuality());
  }

  @Test
  public void test_qualite_brie_augmente_si_le_temps_passe() {
    Inn inn = new Inn();

    inn.updateQuality();
    assertEquals(1, inn.getItems().get(1).getSellIn());
    assertEquals(1, inn.getItems().get(1).getQuality());
  }

  @Test
  public void test_qualite_ne_depasse_pas_50() {
    Inn inn = new Inn();
    for(int i = 0; i<53; i++){
      inn.updateQuality();
    }
    assertEquals(-51, inn.getItems().get(1).getSellIn());
    assertEquals(50, inn.getItems().get(1).getQuality());
  }

  @Test
  public void test_sulfuras_perd_pas_qualite_et_pas_date_premeption() {
    Inn inn = new Inn();
    inn.updateQuality();
    assertEquals(0, inn.getItems().get(3).getSellIn());
    assertEquals(80, inn.getItems().get(3).getQuality());
  }

  @Test
  public void test_backstage_pass() {
    Inn inn = new Inn();
    inn.updateQuality();
    assertEquals(14, inn.getItems().get(4).getSellIn());
    assertEquals(21, inn.getItems().get(4).getQuality());

    for(int i = 0; i<5; i++){
      inn.updateQuality();
    }

    assertEquals(9, inn.getItems().get(4).getSellIn());
    assertEquals(27, inn.getItems().get(4).getQuality());

    for(int i = 0; i<5; i++){
      inn.updateQuality();
    }

    assertEquals(4, inn.getItems().get(4).getSellIn());
    assertEquals(38, inn.getItems().get(4).getQuality());

    for(int i = 0; i<5; i++){
      inn.updateQuality();
    }

    assertEquals(-1, inn.getItems().get(4).getSellIn());
    assertEquals(0, inn.getItems().get(4).getQuality());
  }
}
