package Homework.QuadTree;

import java.util.NoSuchElementException;

public class QuadTreeNodeImpl implements QuadTreeNode {

    private QuadTreeNodeImpl topLeft = null;
    private QuadTreeNodeImpl topRight = null;
    private QuadTreeNodeImpl bottomLeft = null;
    private QuadTreeNodeImpl bottomRight = null;
    private final int[][] image;
    private final int dimension;

    //                               1
    //             2           2           2           2
    //          3 3 3 3     3 3 3 3

    public QuadTreeNodeImpl(int[][] image, int length) {
        this.image = image;
        this.dimension = length;
        if (isLeaf()) return;

        int[][] topLeftImage = divide(image, 0, 0, dimension / 2);
        int[][] topRightImage = divide(image, 0, dimension / 2, dimension / 2);
        int[][] bottomLeftImage = divide(image, dimension / 2, 0, dimension / 2);
        int[][] bottomRightImage = divide(image, dimension / 2, dimension / 2, dimension / 2);
        topLeft = new QuadTreeNodeImpl(topLeftImage, dimension / 2);
        topRight = new QuadTreeNodeImpl(topRightImage, dimension / 2);
        bottomLeft = new QuadTreeNodeImpl(bottomLeftImage, dimension / 2);
        bottomRight = new QuadTreeNodeImpl(bottomRightImage, dimension / 2);
    }

    public static QuadTreeNode buildFromIntArray(int[][] image) {
        return new QuadTreeNodeImpl(image, image.length);
    }

    @Override
    public QuadTreeNode getTopLeft() {
        if (isLeaf()) throw new NoSuchElementException();
        return topLeft;
    }

    @Override
    public QuadTreeNode getTopRight() {
        if (isLeaf()) throw new NoSuchElementException();
        return topRight;
    }

    @Override
    public QuadTreeNode getBottomLeft() {
        if (isLeaf()) throw new NoSuchElementException();
        return bottomLeft;
    }

    @Override
    public QuadTreeNode getBottomRight() {
        if (isLeaf()) throw new NoSuchElementException();
        return bottomRight;
    }

    @Override
    public int getRelativeColor(int x, int y) {
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) throw new IllegalArgumentException();
        return image[x][y];
    }

    @Override
    public void setRelativeColor(int x, int y, int color) {
        if (x < 0 || y < 0 || x >= dimension || y >= dimension) throw new IllegalArgumentException();
        if (dimension == 1) {
            image[x][y] = color;
            return;
        }
        if (isLeaf()) {
            int[][] topL = divide(image, 0, 0, dimension / 2);
            int[][] topR = divide(image, 0, (dimension / 2), dimension / 2);
            int[][] bottomL = divide(image, (dimension / 2), 0, dimension / 2);
            int[][] bottomR = divide(image, (dimension / 2), dimension / 2, dimension / 2);
            topLeft = new QuadTreeNodeImpl(topL, dimension / 2);
            topRight = new QuadTreeNodeImpl(topR, dimension / 2);
            bottomLeft = new QuadTreeNodeImpl(bottomL, dimension / 2);
            bottomRight = new QuadTreeNodeImpl(bottomR, dimension / 2);
        }
        if (x < dimension / 2 && y < dimension / 2) topLeft.setRelativeColor(x, y, color);
        if (x < dimension / 2 && y >= dimension / 2) topRight.setRelativeColor(x, y - dimension / 2, color);
        if (x >= dimension / 2 && y < dimension / 2) bottomLeft.setRelativeColor(x - dimension / 2, y, color);
        if (x >= dimension / 2 && y >= dimension / 2) bottomRight.setRelativeColor(x - dimension / 2, y - dimension / 2, color);

        image[x][y] = color;
    }

    @Override
    public int getDimension() {
        return this.dimension;
    }

    @Override
    public int getSize() {
        if (isLeaf()) return 1;
        return topLeft.getSize() + topRight.getSize() + bottomLeft.getSize() + bottomRight.getSize() + 1;
    }

    @Override
    public boolean isLeaf() {
        int color = image[0][0];
        for (int i = 0; i < this.dimension; i++)
            for (int j = 0; j < this.dimension; j++)
                if (color != image[i][j]) return false;

        return true;
    }

    private int[][] divide(int[][] image, int startX, int startY, int length) {
        int[][] divided = new int[length][length];
        for (int i = startX, l = 0; l < length; i++, l++)
            for (int j = startY, m = 0; m < length; j++, m++)
                divided[l][m] = image[i][j];

        return divided;
    }

    @Override
    public int[][] toArray() {
        int[][] toArr = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                toArr[i][j] = image[i][j];

        return toArr;
    }

}
