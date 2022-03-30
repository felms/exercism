import java.util.ArrayList;
import java.util.List;

class BinarySearch{

    private List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    public int indexOf(Integer item) throws ValueNotFoundException {
        
        int l = 0;
        int h = this.list.size() - 1;
        
        while (l <= h) {
            int m = l + (h - l) / 2;
     
            
            if (list.get(m).compareTo(item) == 0) {
                return m;
            }
            
            if (list.get(m).compareTo(item) < 0) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        throw new ValueNotFoundException("Value not in array");
    }

    
}