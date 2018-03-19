package com.micetr0.mock_DB;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVParse implements Closeable{

    private BufferedReader reader;

    public CSVParse(String resourceName) throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        if (in == null) {
            throw new IOException("Couldn't open " + resourceName);
        }
        this.reader = new BufferedReader(new InputStreamReader(in));
    }

    public List<String> next() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            return null;
        }
        List<String> tuple = new ArrayList<String>();
        StringTokenizer tok = new StringTokenizer(line, "|");
        while (tok.hasMoreTokens()) {
            tuple.add(tok.nextToken().trim());
        }
        return tuple;
    }

    public void close() throws IOException {
        reader.close();
    }
}