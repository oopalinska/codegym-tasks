package task3403_recursion;

/*
Factorization using recursion

*/

public class Solution {
    public void recurse(int n) {
        if (n <= 1) return;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;   //if we didn't add break, we would also print all the factors
                         // for all of the "middle" numbers (the outer loop would go on)
            }
        }
    }
}