package com.github.vertical_blank.sqlformatter.languages;

import com.github.vertical_blank.sqlformatter.core.DialectConfig;
import com.github.vertical_blank.sqlformatter.enums.StringLiteral;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SparkSqlFormatter extends AbstractFormatter {

	private static final List<String> reservedWords = Arrays.asList(
		"ALL",
		"ALTER",
		"ANALYSE",
		"ANALYZE",
		"ARRAY_ZIP",
		"ARRAY",
		"AS",
		"ASC",
		"AVG",
		"BETWEEN",
		"CASCADE",
		"CASE",
		"CAST",
		"COALESCE",
		"COLLECT_LIST",
		"COLLECT_SET",
		"COLUMN",
		"COLUMNS",
		"COMMENT",
		"CONSTRAINT",
		"CONTAINS",
		"CONVERT",
		"COUNT",
		"CUME_DIST",
		"CURRENT ROW",
		"CURRENT_DATE",
		"CURRENT_TIMESTAMP",
		"DATABASE",
		"DATABASES",
		"DATE_ADD",
		"DATE_SUB",
		"DATE_TRUNC",
		"DAY_HOUR",
		"DAY_MINUTE",
		"DAY_SECOND",
		"DAY",
		"DAYS",
		"DECODE",
		"DEFAULT",
		"DELETE",
		"DENSE_RANK",
		"DESC",
		"DESCRIBE",
		"DISTINCT",
		"DISTINCTROW",
		"DIV",
		"DROP",
		"ELSE",
		"ENCODE",
		"END",
		"EXISTS",
		"EXPLAIN",
		"EXPLODE_OUTER",
		"EXPLODE",
		"FILTER",
		"FIRST_VALUE",
		"FIRST",
		"FIXED",
		"FLATTEN",
		"FOLLOWING",
		"FROM_UNIXTIME",
		"FULL",
		"GREATEST",
		"GROUP_CONCAT",
		"HOUR_MINUTE",
		"HOUR_SECOND",
		"HOUR",
		"HOURS",
		"IF",
		"IFNULL",
		"IN",
		"INSERT",
		"INTERVAL",
		"INTO",
		"IS",
		"LAG",
		"LAST_VALUE",
		"LAST",
		"LEAD",
		"LEADING",
		"LEAST",
		"LEVEL",
		"LIKE",
		"MAX",
		"MERGE",
		"MIN",
		"MINUTE_SECOND",
		"MINUTE",
		"MONTH",
		"NATURAL",
		"NOT",
		"NOW()",
		"NTILE",
		"NULL",
		"NULLIF",
		"OFFSET",
		"ON DELETE",
		"ON UPDATE",
		"ON",
		"ONLY",
		"OPTIMIZE",
		"OVER",
		"PERCENT_RANK",
		"PRECEDING",
		"RANGE",
		"RANK",
		"REGEXP",
		"RENAME",
		"RLIKE",
		"ROW",
		"ROWS",
		"SECOND",
		"SEPARATOR",
		"SEQUENCE",
		"SIZE",
		"STRING",
		"STRUCT",
		"SUM",
		"TABLE",
		"TABLES",
		"TEMPORARY",
		"THEN",
		"TO_DATE",
		"TO_JSON",
		"TO",
		"TRAILING",
		"TRANSFORM",
		"TRUE",
		"TRUNCATE",
		"TYPE",
		"TYPES",
		"UNBOUNDED",
		"UNIQUE",
		"UNIX_TIMESTAMP",
		"UNLOCK",
		"UNSIGNED",
		"USING",
		"VARIABLES",
		"VIEW",
		"WHEN",
		"WITH",
		"YEAR_MONTH"
	);

	private static final List<String> reservedTopLevelWords = Arrays.asList(
		"ADD",
		"AFTER",
		"ALTER COLUMN",
		"ALTER DATABASE",
		"ALTER SCHEMA",
		"ALTER TABLE",
		"CLUSTER BY",
		"CLUSTERED BY",
		"DELETE FROM",
		"DISTRIBUTE BY",
		"FROM",
		"GROUP BY",
		"HAVING",
		"INSERT INTO",
		"INSERT",
		"LIMIT",
		"OPTIONS",
		"ORDER BY",
		"PARTITION BY",
		"PARTITIONED BY",
		"RANGE",
		"ROWS",
		"SELECT",
		"SET CURRENT SCHEMA",
		"SET SCHEMA",
		"SET",
		"TBLPROPERTIES",
		"UPDATE",
		"USING",
		"VALUES",
		"WHERE",
		"WINDOW"
	);

	private static final List<String> reservedTopLevelWordsNoIndent = Arrays.asList(
		"EXCEPT ALL",
		"EXCEPT",
		"INTERSECT ALL",
		"INTERSECT",
		"UNION ALL",
		"UNION"
	);

	private static final List<String> reservedNewlineWords = Arrays.asList(
		"AND",
		"CREATE OR",
		"CREATE",
		"ELSE",
		"LATERAL VIEW",
		"OR",
		"OUTER APPLY",
		"WHEN",
		"XOR",
		// joins
		"JOIN",
		"INNER JOIN",
		"LEFT JOIN",
		"LEFT OUTER JOIN",
		"RIGHT JOIN",
		"RIGHT OUTER JOIN",
		"FULL JOIN",
		"FULL OUTER JOIN",
		"CROSS JOIN",
		"NATURAL JOIN",
		// non-standard-joins
		"ANTI JOIN",
		"SEMI JOIN",
		"LEFT ANTI JOIN",
		"LEFT SEMI JOIN",
		"RIGHT OUTER JOIN",
		"RIGHT SEMI JOIN",
		"NATURAL ANTI JOIN",
		"NATURAL FULL OUTER JOIN",
		"NATURAL INNER JOIN",
		"NATURAL LEFT ANTI JOIN",
		"NATURAL LEFT OUTER JOIN",
		"NATURAL LEFT SEMI JOIN",
		"NATURAL OUTER JOIN",
		"NATURAL RIGHT OUTER JOIN",
		"NATURAL RIGHT SEMI JOIN",
		"NATURAL SEMI JOIN"
	);

	@Override
    DialectConfig dialectConfig() {
		return DialectConfig.builder()
						.reservedWords(reservedWords)
						.reservedTopLevelWords(reservedTopLevelWords)
						.reservedTopLevelWordsNoIndent(reservedTopLevelWordsNoIndent)
						.reservedNewlineWords(reservedNewlineWords)
						.stringTypes(Arrays.asList(StringLiteral.DoubleQuote, StringLiteral.SingleQuote, StringLiteral.BackQuote, StringLiteral.Bracket))
						.openParens(Collections.singletonList("("))
						.closeParens(Collections.singletonList(")"))
						.indexedPlaceholderTypes(Collections.singletonList("?"))
						.namedPlaceholderTypes(Collections.singletonList(":"))
						.lineCommentTypes(Collections.singletonList("--"))
						.specialWordChars(Arrays.asList("#", "@")).build();
	}

}
