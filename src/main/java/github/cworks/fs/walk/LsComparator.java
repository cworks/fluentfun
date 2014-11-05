/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs.walk
 * Class: LsComparator
 * Created: 11/5/14 1:01 PM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs.walk;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;
import java.util.Date;

import static java.nio.file.Files.readAttributes;
import static java.nio.file.Files.size;

public enum LsComparator implements Comparator<Path> {
    SORT_BY_NAME {
        public int compare(Path p1, Path p2) {
            Integer order = p1.toString().compareTo(p2.toString());
            return order;
        }
    },
    SORT_BY_SIZE {
        public int compare(Path p1, Path p2) {
            Long s1 = 0L, s2 = 0L;
            try {
                s1 = size(p1);
                s2 = size(p2);

            } catch (IOException e)
                { /* trust me I stayed at a holiday inn last night */ }

            return s1.compareTo(s2);
        }
    },
    SORT_BY_CREATED {
        public int compare(Path p1, Path p2) {
            Long now = new Date().getTime();
            FileTime creationTimeP1 = FileTime.fromMillis(now);
            FileTime creationTimeP2 = FileTime.fromMillis(now);
            try {
                BasicFileAttributes attributes = readAttributes(p1, BasicFileAttributes.class);
                creationTimeP1 = attributes.creationTime();
                attributes = readAttributes(p2, BasicFileAttributes.class);
                creationTimeP2 = attributes.creationTime();
            } catch (IOException e) {
            }
            return creationTimeP1.compareTo(creationTimeP2);
        }
    };

    public static Comparator<Path> desc(final Comparator<Path> other) {
        return new Comparator<Path>() {
            public int compare(Path p1, Path p2) {
                return -1 * other.compare(p1, p2);
            }
        };
    }

    public static Comparator<Path> getComparator(final Comparator ... multipleOptions) {
        return new Comparator<Path>() {
            public int compare(Path o1, Path o2) {
                for (Comparator option : multipleOptions) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }
}


