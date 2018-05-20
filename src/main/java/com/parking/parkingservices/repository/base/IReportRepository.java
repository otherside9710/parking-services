package com.parking.parkingservices.repository.base;

import java.util.HashMap;
import java.util.List;

public interface IReportRepository {

    List getReport(
            HashMap<String, String> params
    );
}
