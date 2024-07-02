# Search an array for a value and return the index.
#
# + array - a sorted array of integers
# + value - the integer item to find
# + return - the index of the value, or nil if the value is not found
public function find(int[] array, int value) returns int? {

    int left = 0;
    int right = array.length() - 1;

    while (left <= right) {
        int middle = (left + right) / 2;

        if (array[middle] == value) {
            return middle;
        }

        if (array[middle] < value) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
}
