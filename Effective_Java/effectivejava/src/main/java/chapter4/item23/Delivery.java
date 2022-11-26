package chapter4.item23;

import java.util.ArrayList;
import java.util.List;

public interface Delivery {

  List<String> itemList = new ArrayList<>();

  static void addItem(String item) {
    itemList.add(item);
  }

}
