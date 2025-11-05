class Semaine3 extends Program {

    int lineTurtle = 0;
    int columnTurtle = 0;

    boolean penDown = false;

    String currentImage = "";
    String colorPen = color(0, 0, 255);

    final int[] NORTH = {-1, 0};
    final int[] SOUTH = {1, 0};
    final int[] EAST = {0, 1};
    final int[] WEST = {0, -1};

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

    boolean move(int[] direction) {
        int line = lineTurtle + direction[0];
        int column = columnTurtle + direction[1];
        
        return go(line, column);
    }

    void algorithm() {
        String image = generate(5, 128, 128, 128, 0, 0, 0);
        setCurrentImage(image);
        penDown = true;
        colorPen = color(0,0,0);
        go(3, 3);
        show(currentImage);
        move(NORTH);
        show(currentImage);
        move(SOUTH);
        show(currentImage);
        move(EAST);
        show(currentImage);
        move(WEST);
        show(currentImage);
    }

}
