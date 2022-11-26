/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright ⓒ2021 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package chapter5.item26;

import java.util.ArrayList;
import java.util.Collection;

public class Generic {


    // Stamp 인스턴스 취급한다
//    private static final Collection stamps = new ArrayList();

    // 제네릭으로 개선된 collection
//    private static final Collection<Stamp> stamps = new ArrayList();

    private static final Collection<?> c = new ArrayList<>();

    public static void main(String[] args) {

        c.add(null);

        // 실수로 동전을 넣는다
//        stamps.add(new Coin()); // unchecked call 경고를 던짐

//        for (Iterator i = stamps.iterator(); i.hasNext(); ) {
//            Stamp stamp = (Stamp) i.next();
//            stamp.cancel();
//        }
    }


}
