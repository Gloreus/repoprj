package ru.sqbt.plsqltests.core;

import lombok.Data;

/// Возвращаемое значение, например, результат функции
@Data
public class DbValue {
    Object value;
    DbTypes paramType;
}
