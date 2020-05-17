package br.com.sysdesc.util.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.sysdesc.util.classes.ListUtil;
import br.com.sysdesc.util.classes.StringUtil;

public class Tag {

    private final String element;

    private final boolean possuiContent;

    private String data = StringUtil.STRING_VAZIA;

    private Map<String, String> parametros = new HashMap<>();

    private List<Tag> content = new ArrayList<>();

    public Tag(String element, boolean possuiContent) {

        this.element = element;
        this.possuiContent = possuiContent;
    }

    public void addData(String data) {

        this.data = data;
    }

    public void addParameter(String parameter, String value) {

        parametros.put(parameter, value);
    }

    public void appendContent(Tag content) {

        if (this.possuiContent) {
            this.content.add(content);
        }
    }

    public void insertContent(Tag content) {

        if (this.possuiContent) {
            this.content.add(0, content);
        }
    }

    public String build() {

        if (!this.possuiContent) {

            return String.format("<%s/>", this.element);
        }

        StringBuilder contentString = new StringBuilder(data);

        if (this.possuiContent && !ListUtil.isNullOrEmpty(content)) {

            this.content.forEach(content -> contentString.append(content.build()));
        }

        return String.format("<%s%s>%s</%s>", this.element, this.montarParametros(), contentString.toString(), this.element);
    }

    private String montarParametros() {

        StringBuilder stringBuilder = new StringBuilder("");

        for (Entry<String, String> entry : parametros.entrySet()) {

            StringBuilder sb = new StringBuilder(" ");

            sb.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");

            stringBuilder.append(sb);
        }

        return stringBuilder.toString();
    }
}
