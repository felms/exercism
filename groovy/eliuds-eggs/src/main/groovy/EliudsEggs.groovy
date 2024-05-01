class EliudsEggs {

    static eggCount(number) {
        int count = 0;

        while (number > 0) {
            count += (number & 1);
            number >>>= 1;
        }

        return count;
    }

}
