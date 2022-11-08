package br.com.wefin.models;

public enum TypePerson {

    FISICA("Fisica", "CPF", "000.000.000-00", CpfGroup.class),
    JURIDICA("Jurídica", "CNPJ", "00.000.000/0000-00", CnpjGroup.class);

    private final String desc;
    private final String doc;
    private final String masc;
    private final Class<?> group;

    private TypePerson(String desc, String doc, String masc, Class<?> group) {
        this.desc = desc;
        this.doc = doc;
        this.masc = masc;
        this.group = group;
    }

    public Class<?> getGroup() {
        return group;
    }
}
