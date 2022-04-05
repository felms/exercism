class Proverb {

    private String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {

        if (words.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        String want;
        String lost;

        for (int i = 0; i < words.length - 1; i++) {
            want = words[i];
            lost = words[i + 1];
            result.append(String.format("For want of a %s the %s was lost.\n", want, lost));

        }

        return result.append("And all for the want of a " + words[0] + ".").toString();
    }

}
