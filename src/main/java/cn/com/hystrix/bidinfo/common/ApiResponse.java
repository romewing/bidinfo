package cn.com.hystrix.bidinfo.common;

import java.io.Serializable;
import java.util.List;

public class ApiResponse<T> implements Serializable {

    private List<T> data;
    private int total;
}
