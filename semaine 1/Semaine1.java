class Semaine1 extends Program {

    // Semaine 1 : couleurs
    // On représente une couleur par trois primaryColors numériques
    // correspondant au trois intensité de red, green et blue
    // Ces intensités varient entre 0 et 255.
    // Ainsi, une couleur peut-être représenté par : "255044138"
    // pour red = 255, green = 044 et blue = 138 (le 0 est important!)
    
    final int RED    = 0;
    final int GREEN  = 1;
    final int BLUE   = 2;

    int charToInt(char digit) {
        int resultat = (char) (digit-'0');

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

    String color(int red, int green, int blue) {
        String resultat = toString(red) + toString(green) + toString(blue);

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

    String set(String color, int primaryColor, int value) {
        String resultat = "";

        String debut = substring(color, 0, primaryColorIndex(primaryColor));
        String fin = substring(color, primaryColorIndex(primaryColor) + 3, length(color));
        resultat += debut + toString(value) + fin;

        return resultat;
    }

    

    void algorithm() {
        
    }

}
