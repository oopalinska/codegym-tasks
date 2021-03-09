package task2408_local_classes;

import java.util.List;

/*
How to avoid Copy+Paste

*/

public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<CanSpeak> pets = Util.convertPetToCanSpeak(pet);
        Util.printDialog(pets);
    }
}