/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs.model
 * Class: Ls
 * Created: 10/28/14 9:30 AM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Semantic Model for listing directory content.  Modeled after
 * the standard unix 'ls' command.
 *
 * The idea here is to capture the 'ls' command in a typical
 * command-query Java class.  This class can be used independent of
 * any fluent pattern which would encapsulate this command-query class.
 *
 * @author corbett
 */
public class Ls {

    public static final Integer LIMIT = 1000;
    private String path;
    private Boolean onlyFolders = false;
    private Boolean onlyFiles = false;
    private String glob = "*";
    private Boolean recursive = false;
    private Integer depth = 0;
    private Integer limit = LIMIT;
    private Boolean longFormat = false;
    private Unit unit = Unit.Kilobyte;
    private Boolean includeHidden = false;
    private SortOrder sortByName = SortOrder.DEFAULT;
    private SortOrder sortBySize = SortOrder.DEFAULT;
    private SortOrder sortByType = SortOrder.DEFAULT;
    private SortOrder sortByModified = SortOrder.DEFAULT;
    private SortOrder sortByCreated = SortOrder.DEFAULT;

    /**
     * Private model used to capture sort property and order
     */
    public static class OrderBy {
        private String property;
        private SortOrder order;
        public OrderBy(String property, SortOrder order) {
            this.property = property;
            this.order = order;
        }
        public String getProperty() {
            return this.property;
        }
        public SortOrder getOrder() {
            return this.order;
        }
        public boolean equals(Object object) {
            if(object == null) return false;
            if(getClass() != object.getClass()) return false;
            final OrderBy other = (OrderBy)object;
            if(other.property.equalsIgnoreCase(this.property)) {
                return true;
            } else {
                return false;
            }
        }
        public int hashCode() {
            return this.property.hashCode();
        }
    }

    /**
     * List that contains properties to order the Ls operation on, including the order (DESC, ASC)
     */
    private List<OrderBy> orderBy = new ArrayList<OrderBy>();

    public Ls() {
        //upsert(new OrderBy("name", SortOrder.ASC));
    }

    // -----------------------------------------------------------------------
    // Commands - Can produce alterations to this objects observable state
    // -----------------------------------------------------------------------

    public void setPath(String path) {
        this.path = path;
    }

    public void setOnlyFolders(Boolean value) {
        this.onlyFolders = value;
    }

    public void setOnlyFiles(Boolean value) {
        this.onlyFiles = value;
    }

    public void setGlob(String glob) {
        this.glob = glob;
    }

    public void setRecursive(Boolean value) {
        this.recursive = value;
    }

    public void setDepth(Integer value) {
        this.depth = value;
    }

    public void setLimit(Integer value) {
        this.limit = value;
    }

    public void setLongFormat(Boolean value) {
        this.longFormat = value;
    }

    public void setUnit(Unit value) {
        this.unit = value;
    }

    public void setIncludeHidden(Boolean value) {
        this.includeHidden = value;
    }

    public void setSortByName(SortOrder value) {
        upsert(new OrderBy("name", value));
    }

    public void setSortBySize(SortOrder value) {
        upsert(new OrderBy("size", value));
    }

    public void setSortByType(SortOrder value) {
        upsert(new OrderBy("type", value));
    }

    public void setSortByModified(SortOrder value) {
        upsert(new OrderBy("modified", value));
    }

    public void setSortByCreated(SortOrder value) {
        upsert(new OrderBy("created", value));
    }

    // -----------------------------------------------------------------------
    // Queries - Read-Only, does not produce an alteration of state
    // -----------------------------------------------------------------------

    public String getPath() {
        return path;
    }

    public Boolean isOnlyFolders() {
        return onlyFolders;
    }

    public Boolean isOnlyFiles() {
        return onlyFiles;
    }

    public String getGlob() {
        return glob;
    }

    public Boolean isRecursive() {
        return recursive;
    }

    public Integer getDepth() {
        return depth;
    }

    public Integer getLimit() {
        return limit;
    }

    public Boolean isLongFormat() {
        return longFormat;
    }

    public Unit getUnit() {
        return unit;
    }

    public Boolean isHidden() {
        return includeHidden;
    }

    public SortOrder getSortByName() {
        return sortByName;
    }

    public SortOrder getSortBySize() {
        return sortBySize;
    }

    public SortOrder getSortByType() {
        return sortByType;
    }

    public SortOrder getSortByModified() {
        return sortByModified;
    }

    public SortOrder getSortByCreated() {
        return sortByCreated;
    }

    public List<OrderBy> getSortOrder() {
        return Collections.unmodifiableList(this.orderBy);
    }

    private void upsert(OrderBy value) {
        this.orderBy.remove(value);
        this.orderBy.add(value);
    }
}
