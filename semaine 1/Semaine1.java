class Semaine1 extends Program {
    
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
