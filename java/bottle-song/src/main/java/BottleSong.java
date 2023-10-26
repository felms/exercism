class BottleSong {

    String recite(int startBottles, int takeDown) {
        StringBuilder verses = new StringBuilder();

        for (int i = startBottles; i > startBottles - takeDown; i--) {

            verses.append("\n");
            verses.append(getVerse(i));
            verses.append("\n");
        }

        return verses.toString().stripLeading();
    }


    private String getVerse(int startBottles) {

        String startBottlesStr = getBottles(startBottles);
        String endBottlesStr = getBottles(startBottles - 1).toLowerCase();

        String sBottle = startBottles > 1 ? "bottles" : "bottle";
        String eBottle = startBottles - 1 == 1 ? "bottle" : "bottles";

        return String.format(
                "%s green %s hanging on the wall,\n" +
                "%s green %s hanging on the wall,\n" +
                "And if one green bottle should accidentally fall,\n" +
                "There'll be %s green %s hanging on the wall.",
                startBottlesStr, sBottle,
                startBottlesStr, sBottle,
                endBottlesStr, eBottle);
    }

    private String getBottles(int bottles) {

        return switch (bottles) {
            case 10 -> "Ten";
            case 9 -> "Nine";
            case 8 -> "Eight";
            case 7 -> "Seven";
            case 6 -> "Six";
            case 5 -> "Five";
            case 4 -> "Four";
            case 3 -> "Three";
            case 2 -> "Two";
            case 1 -> "One";
            case 0 -> "No";
            default -> throw new IllegalArgumentException();
        };
    }


}
