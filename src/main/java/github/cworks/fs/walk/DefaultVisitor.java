/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs.walk
 * Class: DefaultVisitor
 * Created: 10/28/14 1:36 PM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs.walk;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public abstract class DefaultVisitor implements FileVisitor {

    abstract void visit(Path path) throws IOException;

    public FileVisitResult postVisitDirectory(Object dir, IOException exc)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs)
            throws IOException {
        visit((Path) file);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Object file, IOException exc)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
