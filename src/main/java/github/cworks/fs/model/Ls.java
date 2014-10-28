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

/**
 * Semantic Model for listing directory content
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

    public Ls() {

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
        this.sortByName = value;
    }

    public void setSortBySize(SortOrder value) {
        this.sortBySize = value;
    }

    public void setSortByType(SortOrder value) {
        this.sortByType = value;
    }

    public void setSortByModified(SortOrder value) {
        this.sortByModified = value;
    }

    public void setSortByCreated(SortOrder value) {
        this.sortByCreated = value;
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
}
