/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs.dsl
 * Class: LsBuilder
 * Created: 10/28/14 10:27 AM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs.dsl;

import github.cworks.fs.model.Ls;
import github.cworks.fs.model.SortOrder;
import github.cworks.fs.model.Unit;
import github.cworks.fs.walk.LsCommand;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static github.cworks.fs.Utilities.isNullOrEmpty;

public class LsBuilder {

    /**
     * The model instance this Builder is delegating to
     */
    private Ls model = new Ls();

    public LsBuilder path(String path) {
        model.setPath(path);
        return this;
    }

    public LsBuilder recursive() {
        model.setRecursive(true);
        return this;
    }

    public LsBuilder recursive(Boolean value) {
        model.setRecursive(value);
        return this;
    }

    public LsBuilder depth(Integer value) {
        model.setDepth(value);
        return this;
    }

    public LsBuilder limit(Integer value) {
        model.setLimit(value);
        return this;
    }

    public LsBuilder glob(String value) {
        model.setGlob(value);
        return this;
    }

    public LsBuilder longFormat() {
        model.setLongFormat(true);
        return this;
    }

    public LsBuilder longFormat(Boolean value) {
        model.setLongFormat(value);
        return this;
    }

    public LsBuilder unit(Unit value) {
        model.setUnit(value);
        return this;
    }

    public LsBuilder includeHidden() {
        model.setIncludeHidden(true);
        return this;
    }

    public LsBuilder includeHidden(Boolean value) {
        model.setIncludeHidden(value);
        return this;
    }

    public LsBuilder sortByName() {
        this.model.setSortByName(SortOrder.ASC);
        return this;
    }

    public LsBuilder sortByName(SortOrder value) {
        this.model.setSortByName(value);
        return this;
    }

    public LsBuilder sortBySize() {
        this.model.setSortBySize(SortOrder.DESC);
        return this;
    }

    public LsBuilder sortBySize(SortOrder value) {
        this.model.setSortBySize(value);
        return this;
    }

    public LsBuilder sortByType() {
        this.model.setSortByType(SortOrder.ASC);
        return this;
    }

    public LsBuilder sortByType(SortOrder value) {
        this.model.setSortByType(value);
        return this;
    }

    public LsBuilder sortByModified() {
        this.model.setSortByModified(SortOrder.DESC);
        return this;
    }

    public LsBuilder sortByModified(SortOrder value) {
        this.model.setSortByModified(value);
        return this;
    }

    public LsBuilder sortByCreated() {
        this.model.setSortByCreated(SortOrder.DESC);
        return this;
    }

    public LsBuilder sortByCreated(SortOrder value) {
        this.model.setSortByCreated(value);
        return this;
    }

    /**
     * Use the model to obtain a listing
     * @return
     */
    public List<Path> listing() throws IOException {
        Ls ls = build();
        LsCommand command = new LsCommand(ls);
        List<Path> listing = command.execute().getListing();

        return listing;
    }

    /**
     * Return the model if it passes muster otherwise throw an exception stating
     * why its cray-cray.
     * @return
     */
    public Ls build() {

        // validate and/or correct model
        if(isNullOrEmpty(model.getPath())) {
            throw new IllegalArgumentException("Path is a required argument.");
        }

        if(model.getDepth() < 0) {
            depth(0); // current directory
        }

        if(model.getLimit() > Ls.LIMIT) {
            limit(Ls.LIMIT);
        }

        return model;
    }

}
