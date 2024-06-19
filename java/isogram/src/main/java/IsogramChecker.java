class IsogramChecker {

    boolean isIsogram(String phrase) {
        String cleanedPhrase = phrase.toLowerCase().replaceAll("[^a-z]", "");

        return cleanedPhrase.chars().distinct().count() == cleanedPhrase.length();
    }

}
