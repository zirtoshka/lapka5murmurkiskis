package org.example.commands;

public enum CommandEnum {
    ADD("add"),
    ADD_IF_MAX("add_if_max"),
    CLEAR("clear"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    FILTER_CONTAINS_NAME("filter_contains_name"),
    HEAD("head"),
    HELP("HELP"),
    HISTORY("history"),
    INFO("info"),
    PRINT_FIELD_DESCENDING_SEMESTER("print_field_descending_semester_enum"),
    PRINT_UNIQUE_GROUP_ADMIN("print_unique_group_admin"),
    REMOVE_BY_ID("remove_by_id"),
    SAVE("save"),
    SHOW("show"),
    UPDATE_BY_ID("update_by_id");
    private String name;


    CommandEnum(String name) {
        this.name=name;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
