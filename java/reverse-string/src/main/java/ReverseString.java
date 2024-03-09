class ReverseString {

    String reverse(String inputString) {

        // Poderia simplesmente fazer 'new StringBuilder(inputString).reverse()'
        // mas achei paia.

        StringBuilder r = new StringBuilder(inputString);

        int low = 0;
        int high = r.length() - 1;

        while (low < high) {
            char aux = r.charAt(low);
            r.setCharAt(low, r.charAt(high));
            r.setCharAt(high, aux);
            low++;
            high--;
        }

        return r.toString();
    }
  
}
