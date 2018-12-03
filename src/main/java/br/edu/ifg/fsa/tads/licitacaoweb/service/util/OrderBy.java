package br.edu.ifg.fsa.tads.licitacaoweb.service.util;

public class OrderBy {

    private String field;

    private String type;

    public OrderBy() {

    }

    public OrderBy(String field, String type) {
        this.field = field;
        this.type = type;
    }

    public OrderBy(String field, TypeEnum typeEnum) {
        this.field = field;
        this.type = typeEnum.toString();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public enum TypeEnum {ASC, DESC}

}
