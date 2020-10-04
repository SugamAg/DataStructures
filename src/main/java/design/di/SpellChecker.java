package design.di;

import java.util.function.Supplier;

public class SpellChecker
{

    private Dictionary dictionary;

    private SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public static SpellChecker create(Supplier<? extends Dictionary> dictionarySupplier) {
        return new SpellChecker(dictionarySupplier.get());
    }
}
