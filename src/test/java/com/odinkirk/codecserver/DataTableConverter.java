package com.odinkirk.codecserver;

import io.cucumber.datatable.DataTable;

import java.util.List;

/**
 * This class is used to convert a DataTable to a more friendly container..
 */
public class DataTableConverter {


    /**
     * This method is used to convert a DataTable to a List of a given Type.
     * @param dataTable The DataTable to convert.
     * @param clazz The Type to convert to.
     * @return A List of the given Type.
     * @param <T> The Type to convert to.
     */
    public static <T> List<T> fromDatatableToList(DataTable dataTable, Class<T> clazz) {
        return dataTable.asList(clazz);
    }
}
