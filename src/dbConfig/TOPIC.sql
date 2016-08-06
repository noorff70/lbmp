
  CREATE TABLE "WEBLEARNING"."TOPIC" 
   (	"TOPICID" NUMBER NOT NULL ENABLE, 
	"GRADEID" NUMBER NOT NULL ENABLE, 
	"SUBJECTID" NUMBER NOT NULL ENABLE, 
	"TOPICNAME" VARCHAR2(35 BYTE) NOT NULL ENABLE, 
	"GRADESUBJECT" VARCHAR2(20 BYTE), 
	 CONSTRAINT "TOPIC_PK" PRIMARY KEY ("TOPICID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK_TOPIC__GRADEID_ON_GRADE" FOREIGN KEY ("GRADEID")
	  REFERENCES "WEBLEARNING"."GRADE" ("GRADEID") ENABLE, 
	 CONSTRAINT "FK_TOPIC_SUBJECTID_ON_SUBJECT" FOREIGN KEY ("SUBJECTID")
	  REFERENCES "WEBLEARNING"."SUBJECT" ("SUBJECTID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 
