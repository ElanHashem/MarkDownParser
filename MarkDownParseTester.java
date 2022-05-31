

import static org.junit.Assert.assertEquals;

import java.beans.Transient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;


public class MarkDownParseTester {
    
    @Test
    public void testSnippet1() throws IOException
    {
        List<String> expected = List.of( "[a link](url.com)","[a link](url.com)","cod[e","code]");
        String contents = Files.readString(Path.of("Snippet-1.md"));
        assertEquals(MarkDownParse.getLinks(contents),expected);
        

        
    }

    @Test
    public void testSnippet2() throws IOException
    {
        List<String> expected = List.of("[a nested link](b.com)","a nested parenthesized url","some escaped [ brackets ]");
        String contents = Files.readString(Path.of("Snippet-2.md"));
        assertEquals(MarkDownParse.getLinks(contents),expected);
        

        
    }
}
