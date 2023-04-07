package com.odinkirk.codecserver;

import io.cucumber.datatable.DataTable;

import java.util.List;

public class DataTableConverter {


    public static <T> List<T> fromDatatableToList(DataTable dataTable, Class<T> clazz) {
        return dataTable.asList(clazz);
    }
}
