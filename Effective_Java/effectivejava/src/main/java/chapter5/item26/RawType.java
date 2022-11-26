/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright ⓒ2021 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package chapter5.item26;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RawType {

  public static void main(String[] args) {

    List<String> strings = new ArrayList<>();
    unsafeAdd(strings, Integer.valueOf(42));
//    String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.
  }

  private static void unsafeAdd(List list, Object o) {
    list.add(o);
  }

  static int numElementsInCommon(Set s1, Set s2) {
    int result = 0;
    for (Object o1 : s1)
      if (s2.contains(o1))
        result++;
    return result;
  }

}
