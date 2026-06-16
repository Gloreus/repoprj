package ru.sqbt.plsqltests.core;

import lombok.Data;

@Data
///  Параметр запроса или процедуры
public class DbParam {
    String name;
    Object value;
    DbTypes paramType;
    /// In-Out
    ParamMode paramMode;
}
