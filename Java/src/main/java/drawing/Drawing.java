package drawing;

import drawing.shapes.Shape;
import drawing.writing.JPEGWriter;
import drawing.writing.PNGWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Refactor Task 3: (Mis-)Shaped
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Drawing {

    private List<Shape> shapes;

    public Drawing(List<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Draw shapes to a file with given file format.
     *
     * @param format   file format
     * @param filename file name
     */
    public void draw(String format, String filename) {
        try {
            Writer writer;
            if (format.equals("jpeg")) {
                writer = new JPEGWriter(filename + ".jpeg");
            } else if (format.equals("png")) {
                writer = new PNGWriter(filename + ".png");
            } else {
                throw new IOException("Invalid format.");
            }
            for (Shape shape : this.shapes) {
                shape.draw(writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
