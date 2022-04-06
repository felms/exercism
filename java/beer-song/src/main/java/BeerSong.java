public class BeerSong{

    private String verse;
    private String penultimateVerse;
    private String finalVerse;

    public BeerSong() {
        this.verse = "%d bottles of beer on the wall, %d bottles of beer.\n" +
                        "Take one down and pass it around, %d %s of beer on the wall.\n\n";
        this.penultimateVerse = "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
        this.finalVerse = "No more bottles of beer on the wall, no more bottles of beer.\n" + 
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
    }

    public String sing(int bottle, int numberOfVerses) {

        StringBuilder sb = new StringBuilder();

        for(int i = bottle; i > bottle - numberOfVerses; i--) {
            if (i == 1) {
                sb.append(penultimateVerse);
            } else if (i == 0) {
                sb.append(finalVerse);
            } else {
                String actualVerse = String.format(verse, i, i, 
                                        i - 1, (i > 2 ? "bottles" : "bottle"));
                sb.append(actualVerse);
            }
        }

        return sb.toString();
    }

    public String singSong() {
        return sing(99, 100);
    }
}
