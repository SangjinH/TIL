package chapter1.item5_Injection;

/**
 * 아래와 같은 코딩방식은 사전 이라는 의미를 봤을 때
 *      여러 언어를 지원하지도 않고,
 *      특수 목적이 있는 사전일 경우 또한 대처할 수 없다.
 *
 *      그렇다고 final 예약어를 빼고, 다른 사전으로 교체하는 메서드를 사용하자니,
 *      여러개의 스레드에서 사용할 수 없는 단점이 존재
 */
public class WrongSpellChecker {

    private static final Lexicon dictionary = new Lexicon();

    private WrongSpellChecker() {} // 객체 생성방지

//    public static boolean isValid(String word) { ... }
//    public static List<String> suggestions(String typo) { ... }
}
