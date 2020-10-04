package design.di;

public class AppMain {

    public static void main(String[] args) {
        SpellChecker spellChecker = SpellChecker.create(English::new);
        SpellChecker spellChecker1 = SpellChecker.create(Hindi::new);
        SpellChecker spellChecker2 = SpellChecker.create(Italian::new);
    }
}
