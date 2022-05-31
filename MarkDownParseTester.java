

import java.beans.Transient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;


public class MarkDownParseTester {
    
    @Test
    public void testSnippet1(String args[]) throws IOException
    {
        String[] expected = new String[]{"[a link](url.com)","[a link](url.com)","cod[e","code]"};
        String contents = Files.readString(Path.of("Snippet-1.md"));
        ArrayList<String> actual = MarkDownParse.getLinks(contents);
        for(int i=0;i<expected.length;i++)
        {
            assertEquals(expected[i], actual.get(i));
        }

        
    }
}
