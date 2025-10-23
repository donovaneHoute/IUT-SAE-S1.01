class Semaine3 extends Program {

    int lineTurtle = 0;
    int columnTurtle = 0;

    boolean penDown = false;

    String currentImage = color(0, 0, 0);
    String colorPen = "";

    void togglePen() {
        penDown = !penDown;
    }

    boolean within(int min, int max, int value) {
        return value >= min && value <= max;
    }

    boolean inside(int imageSize, int line, int column) {
        return within(0, imageSize - 1, line) && within(0, imageSize - 1, column);
    }

    void setCurrentImage(String image) {
        currentImage = image;
    }

    String set(String image, int line, int column, String color) {
        String newImage = "";
        int imageSize = size(image);
        int idxStart  = line * imageSize * 9 + column * 9;

        newImage += substring(image, 0, idxStart);
        newImage += color;
        newImage += substring(image, idxStart + 9, length(image));

        return newImage;
    }

    void trace() {
        if (penDown) {
            currentImage = set(currentImage, lineTurtle, columnTurtle, colorPen);
        }
    }

    boolean go(int line, int column) {
        boolean condition = inside(size(currentImage), line, column);
        if (condition) {
            lineTurtle = line;
            columnTurtle = column;

            trace();
        }

        return condition;
    }

    void algorithm() {

    }

}
