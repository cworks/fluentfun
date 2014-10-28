/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs.walk
 * Class: LsVisitor
 * Created: 10/28/14 1:39 PM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs.walk;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;

class LsVisitor extends DefaultVisitor {

    private final PathMatcher matcher;
    private List<Path> listing = new ArrayList<Path>();
    private Path root = null;

    public LsVisitor(Path root, String glob) {
        this.matcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
        this.root = root;
    }

    void visit(Path item) throws IOException {
        Path name = item.getFileName();
        long size = (Long) Files.getAttribute(item, "basic:size");
        if (name != null && matcher.matches(name)) {
            listing.add(item);
        }
    }

    public List<Path> getListing() {
        return listing;
    }
}
