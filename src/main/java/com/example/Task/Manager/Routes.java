package com.example.Task.Manager;

public class Routes {
    public static final String INITIAL = "/";
    public static final String CUSTOMER_BASE = "/customer";
    public static final String CUSTOMER_VALUE = "/customer/{Id}";
    public static final String CUSTOMER_TOGGLE_ID = "/customer/toggle/{Id}";
    public static final String CUSTOMER_ACTIVE = "/customer/active";
    public static final String CUSTOMER_DETAILS_ID = "/customer/details";
    public static final String ADD_TASK ="/addTask";
    public static final String DELETE_TASK ="/deleteTask/{taskId}";
    public static final String UPDATE_TASK ="/updateTask/{taskId}";
    public static final String FIND_TASK ="/findTask/{taskId}";
    public static final String GET_TASK ="/getTask";
    public static final String GET_ACTIVE_TASK = "/getActiveTask";
    public static final String GET_MULTIPLE_TASK = "/getMultipleTask";
    public static final String TOGGLE_TASK_ACTIVATION = "/toggleActivation/{taskId}";
}
