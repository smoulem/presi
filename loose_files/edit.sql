alter session set current_schema = ALTAIR

INSERT INTO ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE (CLIENT_REF, MEMBER_REF, ENTRY_NUMBER, DATE_UPDATED, UPDATED_BY, TRANS_CONTROL, PIP_START_DATE, PIP_END_DATE, PAY, ANNUAL_ALLOWANCE, OPENING_PENSION, CLOSING_PENSION, OPENING_LUMP_SUM, CLOSING_LUMP_SUM, PENSION_INPUT_AMOUNT, CUMULATIVE_PIA, BREACH_IND, SCHEME_PAYS_PENSION_DEBIT, SCHEME_PAYS_LUMP_SUM_DEBIT) VALUES ('CCCCLG', 87, 1, TIMESTAMP '2011-11-17 13:24:00', 'SANDRA', 1, TIMESTAMP '2011-11-17 13:24:00', null, 2000.00, 40000.00, 100.00, 123.00, 1.00, 1.00, 23.00, 23.00, null, 0.00, 0.00)

INSERT INTO ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE (CLIENT_REF, MEMBER_REF, ENTRY_NUMBER, DATE_UPDATED, UPDATED_BY, TRANS_CONTROL, PIP_START_DATE, PIP_END_DATE, PAY, ANNUAL_ALLOWANCE, OPENING_PENSION, CLOSING_PENSION, OPENING_LUMP_SUM, CLOSING_LUMP_SUM, PENSION_INPUT_AMOUNT, CUMULATIVE_PIA, BREACH_IND, SCHEME_PAYS_PENSION_DEBIT, SCHEME_PAYS_LUMP_SUM_DEBIT) VALUES ('CCCCLG', 704, 2, TIMESTAMP '2012-11-17 13:24:00', 'SANDRA', null, TIMESTAMP '2011-12-17 13:24:00', null, 2500.00, 40000.00, 15.00, null, 2.00, null, 10.00, 20.00, null, null, null)

INSERT INTO ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE (CLIENT_REF, MEMBER_REF, ENTRY_NUMBER, DATE_UPDATED, UPDATED_BY, TRANS_CONTROL, PIP_START_DATE, PIP_END_DATE, PAY, ANNUAL_ALLOWANCE, OPENING_PENSION, CLOSING_PENSION, OPENING_LUMP_SUM, CLOSING_LUMP_SUM, PENSION_INPUT_AMOUNT, CUMULATIVE_PIA, BREACH_IND, SCHEME_PAYS_PENSION_DEBIT, SCHEME_PAYS_LUMP_SUM_DEBIT) VALUES ('CCCCLG', 553, 3, TIMESTAMP '2013-11-17 13:24:00', 'SANDRA', null, TIMESTAMP '2013-11-17 13:24:00', null, 1000.00, 80000.00, 10.00, null, 1.50, null, 30.00, 30.00, null, null, null)

INSERT INTO ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE (CLIENT_REF, MEMBER_REF, ENTRY_NUMBER, DATE_UPDATED, UPDATED_BY, TRANS_CONTROL, PIP_START_DATE, PIP_END_DATE, PAY, ANNUAL_ALLOWANCE, OPENING_PENSION, CLOSING_PENSION, OPENING_LUMP_SUM, CLOSING_LUMP_SUM, PENSION_INPUT_AMOUNT, CUMULATIVE_PIA, BREACH_IND, SCHEME_PAYS_PENSION_DEBIT, SCHEME_PAYS_LUMP_SUM_DEBIT) VALUES ('CCCCLG', 554, 4, TIMESTAMP '2014-11-17 13:24:00', 'SANDRA', null, TIMESTAMP '2014-11-17 13:24:00', null, 3000.00, 60000.00, 7.00, null, 11.00, null, 25.00, 50.00, null, null, null)



[2024-11-14 11:26:28] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 11:26:28] completed in 23 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMB_ANN_ALLOW_COMBND_TEMP_VW t
        ) WHERE ROWNUM <= 501
[2024-11-14 11:26:29] 0 rows retrieved in 64 ms (execution: 50 ms, fetching: 14 ms)
[2024-11-14 11:43:27] transaction committed: @MEMB_ANN_…ND_TEMP_VW [@alt-smoulem ]
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMB_ANN_ALLOW_COMBND_TEMP_VW t
        ) WHERE ROWNUM <= 501
[2024-11-14 11:43:36] 0 rows retrieved in 38 ms (execution: 27 ms, fetching: 11 ms)


[2024-11-14 11:26:28] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 11:26:28] completed in 23 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMB_ANN_ALLOW_COMBND_TEMP_VW t
        ) WHERE ROWNUM <= 501
[2024-11-14 11:26:29] 0 rows retrieved in 65 ms (execution: 51 ms, fetching: 14 ms)
[2024-11-14 11:43:27] transaction committed: @MEMB_ANN_…ND_TEMP_VW [@alt-smoulem ]
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMB_ANN_ALLOW_COMBND_TEMP_VW t
        ) WHERE ROWNUM <= 501
[2024-11-14 11:43:36] 0 rows retrieved in 38 ms (execution: 27 ms, fetching: 11 ms)


[2024-11-13 11:56:14] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-13 11:56:14] completed in 34 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE t
        ) WHERE ROWNUM <= 501
[2024-11-13 11:56:15] 0 rows retrieved in 145 ms (execution: 71 ms, fetching: 74 ms)
[2024-11-13 11:56:55] completed in 2 ms
[2024-11-13 11:56:55] completed in 2 ms
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-13 11:56:58] completed in 25 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE t
        ) WHERE ROWNUM <= 501
[2024-11-13 11:56:59] 0 rows retrieved in 62 ms (execution: 27 ms, fetching: 35 ms)
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE t
            ORDER BY MEMBER_REF
        ) WHERE ROWNUM <= 501
[2024-11-13 11:57:12] 0 rows retrieved in 59 ms (execution: 33 ms, fetching: 26 ms)
[2024-11-13 11:57:45] completed in 9 ms
[2024-11-14 10:32:44] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 10:32:44] completed in 25 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE t
            ORDER BY MEMBER_REF
        ) WHERE ROWNUM <= 501
[2024-11-14 10:32:44] 0 rows retrieved in 124 ms (execution: 32 ms, fetching: 92 ms)
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE t
            ORDER BY MEMBER_REF
        ) WHERE ROWNUM <= 501
[2024-11-14 10:47:57] 0 rows retrieved in 47 ms (execution: 26 ms, fetching: 21 ms)
ALTAIR> INSERT INTO ALTAIR.MEMBER_ANNUAL_ALLOWANCE_CARE (CLIENT_REF, MEMBER_REF, ENTRY_NUMBER, DATE_UPDATED, UPDATED_BY, TRANS_CONTROL, PIP_START_DATE, PIP_END_DATE, PAY, ANNUAL_ALLOWANCE, OPENING_PENSION, CLOSING_PENSION, OPENING_LUMP_SUM, CLOSING_LUMP_SUM, PENSION_INPUT_AMOUNT, CUMULATIVE_PIA, BREACH_IND, SCHEME_PAYS_PENSION_DEBIT, SCHEME_PAYS_LUMP_SUM_DEBIT) VALUES ('CCCCLG', 300977, 1, TIMESTAMP '2024-02-26 16:14:00', 'HEYCON', 1, TIMESTAMP '2008-02-26 16:14:00', TIMESTAMP '2025-02-26 16:14:00', null, null, 50000.00, 1000.00, null, 1500.00, null, 200.00, '2', null, null)
[2024-11-14 12:02:05] Cancelling…
[2024-11-14 12:02:08] [72000][1013] ORA-01013: user requested cancel of current operation
[2024-11-14 12:02:08] Position: 19
[2024-11-14 12:02:08] transaction rolled back: @MEMBER_AN…WANCE_CARE [@alt-smoulem ]


[2024-11-14 10:45:07] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 10:45:07] completed in 21 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_BASIC_DETAIL t
        ) WHERE ROWNUM <= 501
[2024-11-14 10:45:08] 500 rows retrieved starting from 1 in 482 ms (execution: 45 ms, fetching: 437 ms)
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_BASIC_DETAIL t
            WHERE NI_NUMBER = 'YW275882D'
        ) WHERE ROWNUM <= 501
[2024-11-14 10:45:32] 2 rows retrieved starting from 1 in 91 ms (execution: 34 ms, fetching: 57 ms)


[2024-11-13 11:56:21] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-13 11:56:21] completed in 32 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_BEN_STATEMENT t
        ) WHERE ROWNUM <= 501
[2024-11-13 11:56:21] 0 rows retrieved in 138 ms (execution: 45 ms, fetching: 93 ms)
[2024-11-13 11:56:53] completed in 2 ms
[2024-11-13 11:56:54] completed in 4 ms


[2024-11-14 09:24:17] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 09:24:18] completed in 35 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANN_ALLOW_COMBND_VIEW t
        ) WHERE ROWNUM <= 501
[2024-11-14 09:24:18] 0 rows retrieved in 72 ms (execution: 48 ms, fetching: 24 ms)
[2024-11-14 09:24:26] completed in 6 ms
[2024-11-14 09:24:26] completed in 3 ms
[2024-11-14 10:31:34] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 10:31:34] completed in 30 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANN_ALLOW_COMBND_VIEW t
        ) WHERE ROWNUM <= 501
[2024-11-14 10:31:34] 0 rows retrieved in 44 ms (execution: 25 ms, fetching: 19 ms)
[2024-11-14 10:31:34] completed in 3 ms
[2024-11-14 10:31:34] completed in 3 ms
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 11:10:36] completed in 24 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANN_ALLOW_COMBND_VIEW t
        ) WHERE ROWNUM <= 501
[2024-11-14 11:10:36] 0 rows retrieved in 43 ms (execution: 27 ms, fetching: 16 ms)
[2024-11-14 11:10:44] completed in 5 ms


[2024-11-13 11:56:23] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-13 11:56:23] completed in 34 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_LEGACY t
        ) WHERE ROWNUM <= 501
[2024-11-13 11:56:23] 0 rows retrieved in 171 ms (execution: 48 ms, fetching: 123 ms)
[2024-11-13 11:56:52] completed in 12 ms
[2024-11-13 11:56:52] completed in 6 ms
[2024-11-14 10:32:47] Connected
ALTAIR> alter session set current_schema = ALTAIR
[2024-11-14 10:32:47] completed in 25 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_LEGACY t
        ) WHERE ROWNUM <= 501
[2024-11-14 10:32:47] 0 rows retrieved in 97 ms (execution: 32 ms, fetching: 65 ms)
ALTAIR> INSERT INTO ALTAIR.MEMBER_ANNUAL_ALLOWANCE_LEGACY (CLIENT_REF, MEMBER_REF, ENTRY_NUMBER, DATE_UPDATED, UPDATED_BY, TRANS_CONTROL, PIP_START_DATE, PIP_END_DATE, PAY, SERVICE, ANNUAL_ALLOWANCE, OPENING_PENSION, CLOSING_PENSION, OPENING_LUMP_SUM, CLOSING_LUMP_SUM, PENSION_INPUT_AMOUNT, CUMULATIVE_PIA, BREACH_IND, SCHEME_PAYS_PENSION_DEBIT, SCHEME_PAYS_LUMP_SUM_DEBIT, FINAL_SALARY_OFF_SET) VALUES ('CCCCLG', 300977, 1, TIMESTAMP '2024-02-26 16:14:00', 'HEYCON', null, TIMESTAMP '2008-02-26 16:14:00', TIMESTAMP '2025-02-26 16:14:00', null, null, 50000.00, 1000.00, null, 1500.00, null, 200.00, 230.00, null, null, null, '5')
[2024-11-14 11:15:44] 1 row affected in 189 ms
ALTAIR> SELECT * FROM (
            SELECT t.*
            FROM ALTAIR.MEMBER_ANNUAL_ALLOWANCE_LEGACY t
        ) WHERE ROWNUM <= 501
[2024-11-14 11:15:44] 1 row retrieved starting from 1 in 39 ms (execution: 23 ms, fetching: 16 ms)
[2024-11-14 11:26:13] completed in 22 ms
[2024-11-14 11:26:13] completed in 3 ms


--
--
-- 
-- 
--
--
--
--
;
Data Source: @alt-smoulem Schema: ALTAIR Table: MEMBER_TASK  
-- auto-generated definition
create table MEMBER_TASK
(
    CLIENT_REF              UNKNOWN,
    MEMBER_REF              UNKNOWN,
    EMPLOYMENT_REF          UNKNOWN,
    PROCEDURE_REF           UNKNOWN,
    TASK_SEQNO              UNKNOWN,
    DATE_UPDATED            UNKNOWN,
    UPDATED_BY              UNKNOWN,
    TASK_CODE               UNKNOWN,
    TASK_VERSION            UNKNOWN,
    HOLDING_STATUS          UNKNOWN,
    PRIORITY_DEFAULT        UNKNOWN,
    DATE_CREATED            UNKNOWN,
    DUE_FOR_ACTION          UNKNOWN,
    COMPLETED               UNKNOWN,
    DUE_FOR_COMPLETION      UNKNOWN,
    PRIORITY                UNKNOWN,
    CURRENT_USER_GROUP      UNKNOWN,
    TIME_ALLOCATION         UNKNOWN,
    TIME_TO_COMPLETE        UNKNOWN,
    LAST_PROCESSED_CONT_SEQ UNKNOWN,
    PREVIOUS_USER_GROUP     UNKNOWN,
    ACCESS_COUNT            UNKNOWN,
    CREATED_BY              UNKNOWN,
    FIRST_ACCESSED_BY       UNKNOWN,
    COMPLETED_BY            UNKNOWN,
    PREV_ACCESSED_BY        UNKNOWN,
    DATE_PREV_ACCESSED      UNKNOWN,
    DATE_REPLY_DUE          UNKNOWN,
    DT_SET_REPLY_DUE_STATUS UNKNOWN,
    DATE_REPLY_RECEIVED     UNKNOWN,
    TIME_TO_REPLY           UNKNOWN,
    EVENT_DATE              UNKNOWN,
    CALCULATION_DATE        UNKNOWN,
    TASK_DESCRIPTION        UNKNOWN,
    NEW_MEMBER_FLAG         UNKNOWN,
    TASK_TEXT               UNKNOWN,
    REPLY_FROM_CODE         UNKNOWN,
    CHECKER_TASK            UNKNOWN,
    TASK_WEIGHTING          UNKNOWN,
    BENCHMARK_ACTUAL_DAYS   UNKNOWN,
    BENCHMARK_DIFF_TOTAL    UNKNOWN,
    ALLOCATED_ELAPSED_TIME  UNKNOWN,
    TOTAL_ELAPSED_TIME      UNKNOWN,
    ACTUAL_ELAPSED_TIME     UNKNOWN,
    ACTUAL_SPENT            UNKNOWN,
    ALLOCATED_IN_OFFICE     UNKNOWN,
    TOTAL_IN_OFFICE         UNKNOWN,
    DAYS_BEFORE_ACTION      UNKNOWN,
    INTERFACE_PRIMARY_KEY   UNKNOWN,
    AUTO_CHOICE_REF         UNKNOWN,
    INTERFACE_CONTROL_REF   UNKNOWN,
    CHOICE_REC_TYPE         UNKNOWN,
    REPLY_DUE_INT_EXT       UNKNOWN,
    ORIGINAL_USER           UNKNOWN,
    TERMINATE               UNKNOWN,
    IMAGE_DOC_REF           UNKNOWN,
    CATEGORY                UNKNOWN,
    MIN_SENIORITY           UNKNOWN,
    WHOLE_EXTERNAL_IND      UNKNOWN,
    REFERRED_BY             UNKNOWN,
    CONDITION_REF           UNKNOWN,
    MAIN_KEY_FLAG           UNKNOWN,
    DAYS_REPLY_DIFF         UNKNOWN,
    BOX_NO                  UNKNOWN,
    TRANS_CONTROL           UNKNOWN,
    PREV_TASK_SEQNO         UNKNOWN,
    PASS_FAIL               UNKNOWN,
    PASS_FAIL_REASON        UNKNOWN,
    constraint UK_MTSK
        unique (),
    constraint FK_MTSK_MPRC
        foreign key () references ??? (),
    constraint FK_MTSK_RUTM
        foreign key () references ??? ()
)
/
 Show table preview 
##
Data Source: @alt-smoulem Schema: ALTAIR Table: RULE_TASK_PARAM  
-- auto-generated definition
create table RULE_TASK_PARAM
(
    CLIENT_REF                    UNKNOWN
        constraint FK_RUTM_CLNT
            references ??? (),
    TASK_CODE                     UNKNOWN,
    TASK_VERSION                  UNKNOWN,
    DATE_UPDATED                  UNKNOWN,
    UPDATED_BY                    UNKNOWN,
    TASK_HOLD_STATUS              UNKNOWN,
    TASK_PRIORITY                 UNKNOWN,
    MIN_SNRTY                     UNKNOWN,
    SHORT_TASK_DESC               UNKNOWN,
    DEF_USR_GRP                   UNKNOWN,
    TIME_BFRE_ACT                 UNKNOWN,
    TIME_TO_COMP                  UNKNOWN,
    ACT_TIME_ALLOC                UNKNOWN,
    CATEGORY                      UNKNOWN,
    TIME_TO_REPLY                 UNKNOWN,
    TASK_WEIGHTING                UNKNOWN,
    DOC_SEQ_NO                    UNKNOWN,
    RPLY_DUE_INT_EXT              UNKNOWN,
    AUTO_CREATE_FLG               UNKNOWN,
    CURR_USR_DFLT                 UNKNOWN,
    CHKR_USR_DFLT                 UNKNOWN,
    REPLY_FRM_CDE                 UNKNOWN,
    TOT_EXTERNAL                  UNKNOWN,
    LONG_TASK_DESC                UNKNOWN,
    TRANS_CONTROL                 UNKNOWN,
    REPLY_DUE_SETTING             UNKNOWN,
    DATE_LAST_EXTRACTED           UNKNOWN,
    MSS_TASK_FLG                  UNKNOWN,
    INITIALISATION_EMAIL_TEMPLATE UNKNOWN,
    PREV_USER_EXCLUSION           UNKNOWN,
    EXECUTABLE_TASK               UNKNOWN,
    PRINT_LOCATION                UNKNOWN,
    PRINT_QUEUE                   UNKNOWN,
    PASS_FAIL_OPTION              UNKNOWN,
    EMAIL_TEMPLATE                UNKNOWN,
    constraint PK_RUTM
        primary key (CLIENT_REF, TASK_CODE, TASK_VERSION),
    constraint FK_RUTM_RUTU
        foreign key (CLIENT_REF, REPLY_FRM_CDE) references ??? ()
)
/

comment on column RULE_TASK_PARAM.REPLY_DUE_SETTING is 'If set to ''A'' (auto) the reply due fields will be set when the task is created. If set to ''N'' (never) the reply due fields will be protected and never set on this task.'
/

create index RIIDX_RUTM_2
    on RULE_TASK_PARAM (CLIENT_REF, REPLY_FRM_CDE)
/

create index IX_RUTM
    on RULE_TASK_PARAM (CLIENT_REF asc, TASK_CODE asc, TASK_VERSION desc)
/
 Show table preview 

##

Data Source: @alt-smoulem Schema: ALTAIR Table: MEMBER_PROCEDURE_COMMENT_LIST  
-- auto-generated definition
create table MEMBER_PROCEDURE_COMMENT_LIST
(
    CLIENT_REF     UNKNOWN,
    MEMBER_REF     UNKNOWN,
    EMPLOYMENT_REF UNKNOWN,
    PROCEDURE_REF  UNKNOWN,
    ENTRY_NUMBER   UNKNOWN,
    DATE_UPDATED   UNKNOWN,
    UPDATED_BY     UNKNOWN,
    COMMENTS       UNKNOWN,
    TRANS_CONTROL  UNKNOWN,
    constraint UK_MPCT
        unique (),
    constraint FK_MPCT_MPRC
        foreign key () references ??? ()
)
/
 Show table preview 
