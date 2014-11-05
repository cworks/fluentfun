/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Baked with love by corbett
 * Project: fluentfun
 * Package: github.cworks.fs
 * Class: LsUse
 * Created: 10/28/14 10:52 AM
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package github.cworks.fs;

import github.cworks.fs.dsl.LsBuilder;
import github.cworks.fs.model.SortOrder;
import github.cworks.fs.model.Unit;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class LsPartOne {

    /**
     * Expression Builder partOne
     * Pros: Straightforward and simple to design and implement
     *       Separation of model and expression builder
     *
     * Cons: Mandatory method calls are obfuscated
     *       Method call order is uncontrolled, lacks wizardry and increases contradictions
     *       Action of obtaining a listing is coupled with Expression Builder
     *       Build method returns a mutable Ls instance
     */
    @Test
    public void partOne() throws IOException {

        LsBuilder ls = new LsBuilder();
        // Change this path to suit your needs
        List<Path> listing = ls.path("/Users/corbett/dev")
            .glob("*")
            .depth(1)
            .sortByCreated(SortOrder.DESC)
            .unit(Unit.Megabyte)
            .listing();

        for(Path item : listing) {
            System.out.println(item);
        }

    }
}
