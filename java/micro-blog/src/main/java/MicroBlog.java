class MicroBlog {
    public String truncate(String input) {

        int endPos = input.length() < 5 ? input.length()
            : input.offsetByCodePoints(0, 5);

        return input.substring(0, endPos);
    }
}
