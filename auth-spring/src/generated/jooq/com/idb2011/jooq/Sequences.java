/*
 * This file is generated by jOOQ.
 */
package com.idb2011.jooq;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in the default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>users_id_seq</code>
     */
    public static final Sequence<Integer> USERS_ID_SEQ = Internal.createSequence("users_id_seq", DefaultSchema.DEFAULT_SCHEMA, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}