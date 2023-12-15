/*
 * This file is generated by jOOQ.
 */
package com.idb2011.jooq.tables;


import com.idb2011.jooq.DefaultSchema;
import com.idb2011.jooq.Indexes;
import com.idb2011.jooq.Keys;
import com.idb2011.jooq.tables.records.SpringSessionRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SpringSession extends TableImpl<SpringSessionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>spring_session</code>
     */
    public static final SpringSession SPRING_SESSION = new SpringSession();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SpringSessionRecord> getRecordType() {
        return SpringSessionRecord.class;
    }

    /**
     * The column <code>spring_session.primary_id</code>.
     */
    public final TableField<SpringSessionRecord, String> PRIMARY_ID = createField(DSL.name("primary_id"), SQLDataType.CHAR(36).nullable(false), this, "");

    /**
     * The column <code>spring_session.session_id</code>.
     */
    public final TableField<SpringSessionRecord, String> SESSION_ID = createField(DSL.name("session_id"), SQLDataType.CHAR(36).nullable(false), this, "");

    /**
     * The column <code>spring_session.creation_time</code>.
     */
    public final TableField<SpringSessionRecord, Long> CREATION_TIME = createField(DSL.name("creation_time"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>spring_session.last_access_time</code>.
     */
    public final TableField<SpringSessionRecord, Long> LAST_ACCESS_TIME = createField(DSL.name("last_access_time"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>spring_session.max_inactive_interval</code>.
     */
    public final TableField<SpringSessionRecord, Integer> MAX_INACTIVE_INTERVAL = createField(DSL.name("max_inactive_interval"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>spring_session.expiry_time</code>.
     */
    public final TableField<SpringSessionRecord, Long> EXPIRY_TIME = createField(DSL.name("expiry_time"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>spring_session.principal_name</code>.
     */
    public final TableField<SpringSessionRecord, String> PRINCIPAL_NAME = createField(DSL.name("principal_name"), SQLDataType.VARCHAR(100), this, "");

    private SpringSession(Name alias, Table<SpringSessionRecord> aliased) {
        this(alias, aliased, null);
    }

    private SpringSession(Name alias, Table<SpringSessionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>spring_session</code> table reference
     */
    public SpringSession(String alias) {
        this(DSL.name(alias), SPRING_SESSION);
    }

    /**
     * Create an aliased <code>spring_session</code> table reference
     */
    public SpringSession(Name alias) {
        this(alias, SPRING_SESSION);
    }

    /**
     * Create a <code>spring_session</code> table reference
     */
    public SpringSession() {
        this(DSL.name("spring_session"), null);
    }

    public <O extends Record> SpringSession(Table<O> child, ForeignKey<O, SpringSessionRecord> key) {
        super(child, key, SPRING_SESSION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.SPRING_SESSION_IX1, Indexes.SPRING_SESSION_IX2, Indexes.SPRING_SESSION_IX3);
    }

    @Override
    public UniqueKey<SpringSessionRecord> getPrimaryKey() {
        return Keys.SPRING_SESSION_PK;
    }

    @Override
    public SpringSession as(String alias) {
        return new SpringSession(DSL.name(alias), this);
    }

    @Override
    public SpringSession as(Name alias) {
        return new SpringSession(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SpringSession rename(String name) {
        return new SpringSession(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SpringSession rename(Name name) {
        return new SpringSession(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, Long, Long, Integer, Long, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
