package chapter1.item5_Injection;

import java.util.Objects;

public class SpellChecker {

    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

//    public static boolean isValid(String word) { ... }
//    public static List<String> suggestions(String typo) { ... }

}
