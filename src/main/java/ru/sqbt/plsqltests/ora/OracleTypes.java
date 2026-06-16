package ru.sqbt.plsqltests.ora;

import org.springframework.context.annotation.Bean;
import ru.sqbt.plsqltests.core.DbTypes;

import java.sql.Types;

public enum OracleTypes implements DbTypes {

    // Числовые типы
    NUMBER(Types.NUMERIC),          // Общий тип для NUMBER
    INTEGER(Types.INTEGER),         // Для целых чисел
    FLOAT(Types.FLOAT),             // Для чисел с плавающей точкой
    DOUBLE(Types.DOUBLE),           // Для BINARY_DOUBLE

    // Строковые типы
    VARCHAR2(Types.VARCHAR),        // Основной строковый тип
    CHAR(Types.CHAR),               // Фиксированная длина
    NVARCHAR2(Types.NVARCHAR),      // Юникодные строки
    NCHAR(Types.NCHAR),             // Фиксированные юникодные строки

    // Даты и время
    DATE(Types.DATE),               // Дата и время
    TIMESTAMP(Types.TIMESTAMP),     // Точное время с секундами
    TIMESTAMP_WITH_TIME_ZONE(Types.TIMESTAMP_WITH_TIMEZONE),

    // BLOB/CLOB
    CLOB(Types.CLOB),               // Текстовые большие объекты
    NCLOB(Types.NCLOB),             // Юникодные CLOB
    BLOB(Types.BLOB),               // Бинарные данные

    // Логический тип (Oracle не имеет native BOOLEAN, но часто эмулируется)
    BOOLEAN(Types.BOOLEAN),         // Для логических значений (0/1, Y/N, TRUE/FALSE)

    // Для REF CURSOR (PL/SQL)
    CURSOR(Types.REF_CURSOR),

    // Для RAW (бинарные данные фиксированной длины)
    RAW(Types.VARBINARY),

    // Для XMLType 
    XMLTYPE(Types.SQLXML),

    // Для ROWID (часто передаётся как строка)
    ROWID(Types.VARCHAR),

    // Для массивов (PL/SQL TABLE, VARRAY)
    ARRAY(Types.ARRAY),

    // Для объектных типов (STRUCT)
    OBJECT(Types.STRUCT),

    // Для REF (указатель на объект)
    REF(Types.REF),

    // Для PL/SQL PLS_INTEGER / BINARY_INTEGER
    PLS_INTEGER(Types.INTEGER),
    BINARY_INTEGER(Types.INTEGER),

    // Для LONG (устаревший, но иногда встречается)
    LONG(Types.LONGVARCHAR),

    // Для LONG RAW (устаревший)
    LONG_RAW(Types.LONGVARBINARY),

    // Для JSON (Oracle 12c+ — часто как CLOB)
    JSON(Types.CLOB),

    // Для INTERVAL (если нужно — как строка или OTHER)
    INTERVAL(Types.OTHER),

    // Для BFILE (внешние файлы — обычно не поддерживается напрямую)
    BFILE(Types.OTHER);

    OracleTypes(int jdbcType) {
        this.jdbcType = jdbcType;
    }
    
    @Override
    public int getJdbcType() {
        return jdbcType;
    }

    @Override
    public Class<?> getJavaType() {
        return String.class;
    }

    private final int jdbcType;
}