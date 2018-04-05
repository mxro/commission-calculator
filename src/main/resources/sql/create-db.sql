create table RANGES(rangeid bigint identity primary key,
				start double not null,
				end double not null, 
				base double not null,
				rate double not null);