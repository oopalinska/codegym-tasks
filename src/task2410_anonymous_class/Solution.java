package task2410_anonymous_class;

import java.util.LinkedList;
import java.util.List;

/*
Refactoring, anonymous classes

*/

public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int itemCount;

    public Iterator getIterator(final String name) {
        return new Iterator() {
            @Override
            public Iterator next() {
                // To get next, we just need to call getIterator method on the same object,
                // with the same argument.
                return Solution.this.getIterator(name);
            }
            // This is my anonymous class's "constructor":
            {
                itemCount++;
                System.out.println(name + " item " + itemCount);
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}

