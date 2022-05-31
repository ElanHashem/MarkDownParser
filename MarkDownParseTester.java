

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
        assertEquals(OtherMarkdownParse.getLinks(contents),expected);
        

        
    }

    @Test
    public void testSnippet2() throws IOException
    {
        List<String> expected = List.of("[a nested link](b.com)","a nested parenthesized url","some escaped [ brackets ]");
        String contents = Files.readString(Path.of("Snippet-2.md"));
        assertEquals(OtherMarkdownParse.getLinks(contents),expected);
        

        
    }

    @Test
    public void testSnippet3() throws IOException
    {
        List<String> expected = List.of("[this title text is really long and takes up more than one line and has some line breaks]( https://www.twitter.com )","this title text is really long and takes up more than one line","[this link doesn't have a closing parenthesis](github.com And there's still some more text after that.","[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/ ) And then there's more text");
        String contents = Files.readString(Path.of("Snippet-3.md"));
        assertEquals(OtherMarkdownParse.getLinks(contents),expected);
        

        
    }
}
