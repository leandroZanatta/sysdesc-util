package br.com.sysdesc.util.html;

public class Table extends Tag {

    public Table() {
        super("table", true);
    }

    public void setHeader(TableRow header) {
        insertContent(header);
    }

    public void addrow(TableRow row) {

        appendContent(row);
    }

}
