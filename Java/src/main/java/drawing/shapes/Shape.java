package drawing.shapes;

import java.io.IOException;
import java.io.Writer;

/**
 * Refactor Task 3: (Mis-)Shaped
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public interface Shape {

    /**
     * Converts shape into lines.
     *
     * @return lines of this shape.
     */
    Line[] toLines();

    /**
     * Draws lines to file.
     */
    default void draw(Writer writer, String format) {
        Line[] lines = toLines();
        try {
            for (Line line : lines) {
                if (format.equals("jpeg")) {
                    writer.write(line.toJPEG());
                } else if (format.equals("png")) {
                    writer.write(line.toPNG());
                }
                else{
                    throw new IllegalArgumentException("Invalid format.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
