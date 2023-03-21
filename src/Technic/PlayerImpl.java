package Technic;

import General.Check;
import General.Product;

public class PlayerImpl extends Product implements Check, PlayMusic {

    String title = "Плеер";

    public void check() {
        System.out.println(title + " поверен, работает исправно.");
    }

    public void playMusic() {
        System.out.println(title + " проигрывает музыку.");
    }

    @Override
    public String toString() {
        return title;
    }

}
