package decorator.csv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVWriter extends Writer {
    private BufferedWriter writer = null;
    private Separator separator = Separator.COMMA;

    public CSVWriter(Writer out)
    {
        super(out);

        if(!(out instanceof BufferedWriter))
            out = new BufferedWriter(out);

        writer = (BufferedWriter) out;
    }

    @Override
    public void write(char[] charBuffer, int off, int len) throws IOException {
        this.writer.write(charBuffer, off, len);
    }
    @Override
    public void flush() throws IOException {
        this.writer.flush();
    }
    @Override
    public void close() throws IOException {
        this.writer.close();
    }
    public void writeSeparator() throws IOException{
        this.writer.append(separator.asChar());
    }

    public void writeToken(String token) throws IOException{
        this.writer.append(token);
    }

    public void writeTokenAndSeparator(String token) throws IOException{
        this.writer.append(token);
        this.writer.append(separator.asChar());
    }

    public Separator getSeparator() {
        return this.separator;
    }

    public void writeTokens(String[] tokens) throws IOException{
        for (int i = 0; i < tokens.length;) {
            this.writer.append(tokens[i]);

            if(++i < tokens.length)
                this.writer.append(separator.asChar());
        }
    }
    public void newLine() throws IOException
    {
        this.writer.newLine();
    }
    public void setSeparator(Separator separator) {
        this.separator = separator;
    }

    public void writeLine(String[] tokens) throws IOException
    {
        this.writeTokens(tokens);
        this.writer.newLine();
    }
}
