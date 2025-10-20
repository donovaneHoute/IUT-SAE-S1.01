class Semaine2 extends Program {

    final int RED    = 0;
    final int GREEN  = 1;
    final int BLUE   = 2;

    // Semaine 1:

    int charToInt(char digit) {
        int resultat = (char) (digit-'0');

        return resultat;
    }

    int primaryColorToInt(String primaryColor) {
        int resultat = 0;

        for (int idx = 0; idx < length(primaryColor); idx++) {
            resultat = resultat * 10 + charToInt(charAt(primaryColor, idx));
        }

        return resultat;
    }

    int primaryColorIndex(int primaryColor) {
        return primaryColor * 3;
    }

    int get(String color, int primaryColor) {
        String stockage = "";
        int resultat = 0;

        stockage = substring(color, primaryColorIndex(primaryColor), primaryColorIndex(primaryColor) + 3);
        resultat = primaryColorToInt(stockage);

        return resultat;
    }

    String toString(int primaryColor) {
        String resultat = "";
        String stockage = "" + primaryColor;

        for (int idx = length(stockage); idx < 3; idx++) {
            resultat += "0";
        }

        resultat += stockage;

        return resultat;
    }

    // Semaine 2:

    int size(String image) {
        int resultat = length(image) / 9;
        return sqrt(resultat);
    }

    String get(String image, int line, int column) {
        int taillePixel = 9;
        int tailleImage = size(image);
        int tailleLine = tailleImage * taillePixel;

        int debut = line * tailleLine + column * taillePixel;
        return substring(image, debut, debut + taillePixel);
    }

    String generate(int size, int red, int green, int blue, int stepR, int stepG, int stepB) {
        String image = "";

        for (int line = 1; line <= size; line++) {
            red = (red + stepR) % 255;
            green = (green + stepG) % 255;
            blue = (blue + stepB) % 255;

            for (int column = 1; column <= size; column++) {
                image += toString(red) + toString(green) + toString(blue);
            }
        }

        return image;
    }

    void show(String image) {
        int size = size(image);

        for (int line = 0; line < size; line++) {
            for (int column = 0; column < size; column++) {
                String pixel = get(image, line, column);
                
                int red = get(pixel, RED);
                int green = get(pixel, GREEN);
                int blue = get(pixel, BLUE);

                print(rgb(red, green, blue, false) + " ");
            }
            println(RESET);
        }
    }

    void algorithm() {
        String image = generate(5, 200, 255, 155, -20, -30, -15);
        println(rgb(255,125,75, false) + image + RESET);
        show(image);
        image = generate(10, 0, 0, 0, 25, 40, 55);
        println(rgb(255,125,75, true) + image + RESET);
        show(image);
    }
}