/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs.walk
 * Class: LsCommand
 * Created: 10/28/14 3:38 PM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs.walk;

import github.cworks.fs.model.Ls;
import github.cworks.fs.model.SortOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static github.cworks.fs.walk.LsComparator.SORT_BY_CREATED;
import static github.cworks.fs.walk.LsComparator.SORT_BY_NAME;
import static github.cworks.fs.walk.LsComparator.SORT_BY_SIZE;
import static github.cworks.fs.walk.LsComparator.desc;
import static github.cworks.fs.walk.LsComparator.getComparator;

public class LsCommand {

    private final Ls ls;
    private List<Path> listing;

    public LsCommand(Ls ls) {
        this.ls = ls;
    }

    public LsCommand execute() throws IOException {

        Path path = Paths.get(ls.getPath());
        LsVisitor visitor = new LsVisitor(path, ls.getGlob());
        Files.walkFileTree(path, Collections.EMPTY_SET, ls.getDepth(), visitor);

        this.listing = visitor.getListing();
        // sort listing
        if(ls.getSortOrder().size() > 0) {
            List<Comparator> comparators = new ArrayList<Comparator>();
            Iterator<Ls.OrderBy> it = ls.getSortOrder().iterator();
            while(it.hasNext()) {
                Ls.OrderBy orderBy = it.next();
                if(orderBy.getProperty().equals("name")) {
                    if(orderBy.getOrder() == SortOrder.DESC) {
                        comparators.add(desc(SORT_BY_NAME));
                    } else {
                        comparators.add(SORT_BY_NAME);
                    }
                } else if(orderBy.getProperty().equals("size")) {
                    if(orderBy.getOrder() == SortOrder.DESC) {
                        comparators.add(desc(SORT_BY_SIZE));
                    } else {
                        comparators.add(SORT_BY_SIZE);
                    }
                } else if(orderBy.getProperty().equals("created")) {
                    if(orderBy.getOrder() == SortOrder.DESC) {
                        comparators.add(desc(SORT_BY_CREATED));
                    } else {
                        comparators.add(SORT_BY_CREATED);
                    }
                }
            }
            sortBy(getComparator(comparators.toArray(new Comparator[comparators.size()])));
        }

        return this;
    }

    void sortBy(Comparator comparator) {
        Collections.sort(listing, comparator);
    }

    public void sortByName() {

        Collections.sort(listing, new Comparator<Path>() {
            @Override
            public int compare(Path p1, Path p2) {
                Integer order = p1.toString().compareTo(p2.toString());

                if(ls.getSortByName() == SortOrder.DESC) {
                    order = order * -1;
                }

                return order;
            }
        });
    }

    public void sortBySize() {

        Collections.sort(listing, new Comparator<Path>() {
            @Override
            public int compare(Path p1, Path p2) {

                Long s1 = 0L, s2 = 0L;
                try {
                    s1 = Files.size(p1);
                    s2 = Files.size(p2);

                } catch (IOException e)
                    { /* trust me I stayed at a holiday inn last night */ }

                Integer order = s1.compareTo(s2);

                if(ls.getSortBySize() == SortOrder.DESC) {
                    order = order * -1;
                }

                return order;
            }
        });
    }

    public List<Path> getListing() {

        Path root = Paths.get(ls.getPath());

        ListIterator<Path> it = listing.listIterator();
        while(it.hasNext()) {
            Path item = it.next();
            it.set(root.relativize(item));
        }

        return Collections.unmodifiableList(listing);
    }
}
