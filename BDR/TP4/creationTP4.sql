drop table if exists Catalogue;
drop table if exists Articles;
drop table if exists Fournisseurs;



CREATE TABLE Articles(
aid int primary key,                     
anom varchar(30), 
acoul varchar(30)
);


CREATE TABLE Fournisseurs(
fid int primary key,
fnom varchar(30) not null,
fad varchar(70) not null
);


CREATE TABLE Catalogue(
fid int  references Fournisseurs(fid) on update cascade on delete cascade,   
aid int references Articles(aid) on update cascade on delete cascade, 
prix numeric(8,2) not null check (prix >0),
primary key (fid,aid) 
);




INSERT INTO Articles VALUES (1,'Left Handed Toaster Cover','rouge');
INSERT INTO Articles VALUES (2,'Smoke Shifter End','noir');
INSERT INTO Articles VALUES (3,'Acme Widget Washer','rouge');
INSERT INTO Articles VALUES (4,'Acme Widget Washer','argente');
INSERT INTO Articles VALUES (5,'Brake for Crop Circles Sticker','opaque');
INSERT INTO Articles VALUES (6,'Anti-Gravity Turbine Generator','cyan');
INSERT INTO Articles VALUES (7,'Anti-Gravity Turbine Generator','magenta');
INSERT INTO Articles VALUES (8,'Fire Hydrant Cap','rouge');
INSERT INTO Articles VALUES (9,'7 Segment Display','vert');
INSERT INTO Articles VALUES (10,'Microsd Card USB Reader','vert');
INSERT INTO Articles VALUES (11,'Ferrari F430','rouge');



INSERT INTO Fournisseurs VALUES (1,'kiventout','59 rue du Chti, F-75001 Paris');
INSERT INTO Fournisseurs VALUES (2,'Big Red Tool and Die','4 My Way, Bermuda Shorts, OR 90305, USA');
INSERT INTO Fournisseurs VALUES (3,'Perfunctory Parts','99999 Short Pier, Terra Del Fuego, TX 41299, USA');
INSERT INTO Fournisseurs VALUES (4,'Alien Aircaft Inc.','2 Groom Lake, Rachel, NV 51902, USA');
INSERT INTO Fournisseurs VALUES (5,'Autolux','Piazza del Paris, 8, I-20121 Milano');
INSERT INTO Fournisseurs VALUES(6,'HappyCake','De Ruijterkade 11, NL-1011 AA Amsterdam');



INSERT INTO Catalogue VALUES (1,1,36.10);
INSERT INTO Catalogue VALUES (1,2,42.30);
INSERT INTO Catalogue VALUES (1,3,15.30);
INSERT INTO Catalogue VALUES (1,4,20.50);
INSERT INTO Catalogue VALUES (1,5,20.50);
INSERT INTO Catalogue VALUES (1,6,124.23);
INSERT INTO Catalogue VALUES (1,7,124.23);
INSERT INTO Catalogue VALUES (1,8,11.70);
INSERT INTO Catalogue VALUES (1,9,75.20);
INSERT INTO Catalogue VALUES (1,10,5.20);
INSERT INTO Catalogue VALUES (1,11,234543.21);
INSERT INTO Catalogue VALUES (2,1,16.50);
INSERT INTO Catalogue VALUES (2,7,0.55);
INSERT INTO Catalogue VALUES (2,8,7.95);
INSERT INTO Catalogue VALUES (3,8,12.50);
INSERT INTO Catalogue VALUES (3,9,1.00);
INSERT INTO Catalogue VALUES (4,4,57.3);
INSERT INTO Catalogue VALUES (4,5,22.20);
INSERT INTO Catalogue VALUES (4,8,48.6);
INSERT INTO Catalogue VALUES (5,11,234555.67);

