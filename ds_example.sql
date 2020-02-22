CREATE  TABLE "public".group_parameter ( 
	id                   bigserial  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	CONSTRAINT pk_group_parameter_id PRIMARY KEY ( id )
 );

CREATE  TABLE "public"."parameter" ( 
	id                   bigserial  NOT NULL ,
	id_group_parameter   bigint  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	CONSTRAINT pk_table_id PRIMARY KEY ( id ),
	CONSTRAINT fk_parameter_group_parameter FOREIGN KEY ( id_group_parameter ) REFERENCES "public".group_parameter( id )  
 );

CREATE INDEX idx_parameter ON "public"."parameter" ( id_group_parameter );
