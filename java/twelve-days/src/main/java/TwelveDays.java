class TwelveDays {

    String verse(int verseNumber) {
        StringBuilder verseSB = new StringBuilder();
        String firstPart = "On the %s day of Christmas my true love gave to me: ";
        String[] days = {"", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};
        String[] items = {"", "a Partridge in a Pear Tree.", "two Turtle Doves, ", "three French Hens, ", "four Calling Birds, ",
                            "five Gold Rings, ", "six Geese-a-Laying, ", "seven Swans-a-Swimming, ", "eight Maids-a-Milking, ", 
                            "nine Ladies Dancing, ", "ten Lords-a-Leaping, ", "eleven Pipers Piping, ", "twelve Drummers Drumming, "};

        verseSB.append(String.format(firstPart, days[verseNumber]));

        for (int i = verseNumber; i > 0; i--) {
            if (i == 1 && verseNumber > 1) {
                verseSB.append("and ");
            }         

            verseSB.append(items[i]);
        }

        verseSB.append("\n");

        return verseSB.toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder versesSB = new StringBuilder();

        for (int i = startVerse; i <= endVerse; i++) {
            versesSB.append(verse(i));
            if (i < endVerse) {
                versesSB.append("\n");
            }
        }

        return versesSB.toString();
    }
    
    String sing() {
        return verses(1, 12);
    }
}
