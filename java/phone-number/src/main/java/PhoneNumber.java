class PhoneNumber {

    private String number;

    PhoneNumber(String numberString) {

        if (numberString.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        }

        if (numberString.matches(".*[:punct:].*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        this.number = numberString.replaceAll("\\D", "");

        if (this.number.matches("[^1]\\d{10}")) {
            throw new IllegalArgumentException("11 digits must start with 1");
        }

        if (this.number.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }

        if (this.number.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }

        if (this.number.length() == 11) {
            this.number = this.number.substring(1);
        }

        if (this.number.matches("[01].*")) {
            String message = "area code cannot start with " +
                        (this.number.charAt(0) == '0' ? "zero" : "one");
            throw new IllegalArgumentException(message);
        }

        if (this.number.matches("\\d{3}[01].*")) {
            String message = "exchange code cannot start with " +
                        (this.number.charAt(3) == '0' ? "zero" : "one");
            throw new IllegalArgumentException(message);
        }

    }

    String getNumber() {
        return this.number;
    }

}
