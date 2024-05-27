#create database Etat_civil;

use Etat_civil;

drop table Citoyen;
drop table Naissance;
drop table Décès;
drop table administrateur;
drop table super_admin;

create table Citoyen
(CIN int primary key, check (CIN>0),
nom varchar(20) not null,
prénom varchar(20) not null);

insert into Citoyen values
(14035157,"Zouari","Adem"),(14034332,"Mallek","Nour"),(07159487,"Zouari","Saloua"),
(06987615,"Zouari","Ahmed"),(09987654,"Zouari","Walid"),(06854159,"Mallek","Abdeljlil"),
(07051234,"Mallek","Awatef"),(03159265,"Zouari","Ali"),(04159486,"Zouari","Mohamed"),
(03987651,"Zouari","Zakia"),(023112654,"Zouari","Salma"),(001159487,"Zouari","Salem"),
(0012894561,"Zouari","Salma");

create table Naissance
(
Nom varchar(20) not null,
Prénom varchar(20) not null,
Date_de_naissance date not null,
Lieu_de_naissance varchar(20) not null,
CIN_pére int references Citoyen(CIN),check(CIN_pére>=0),
CIN_mére int references Citoyen(CIN),check(CIN_mére>=0),
Nombre_de_retrait_total int,
Nombre_de_retrait_semaine int,
primary key(Nom,Prénom,Date_de_naissance,Lieu_de_naissance));

insert into Naissance values
("Zouari","Adem",'2003-01-05',"Tunis",06987615,07159487,10,3),
("Zouari","Walid",'1989-08-02',"Tunis",06987615,07159487,16,0),
("Zouari","Mohamed Ali",'2007-06-07',"Moknine",06987615,07159487,8,0),
("Mallek","Nour",'2003-01-01',"Ksar hellal",06854159,07051234,10,1),
("Zouari","Saloua",'1963-06-06',"Moknine",04159486,03987651,20,1),
("Zouari","Ahmed",'1960-05-06',"Moknine",03159265,023112654,30,0),
("Bourguiba","Salem",'1905-01-07',"Moknine",0,0,30,0),
("Bourguiba","Salma",'1909-11-22',"Moknine",0,0,12,0);

create table Décès
(Nom varchar(20) not null,
Prénom varchar(20) not null,
Date_de_décès date,
Lieu_de_décès varchar(20),
CIN_pére int references Citoyen(CIN),check(CIN_pére>=0),
CIN_mére int references Citoyen(CIN),check(CIN_mére>=0),
Nombre_de_retrait_total int,
Nombre_de_retrait_semaine int,
primary key (Nom,Prénom,Date_de_décès,Lieu_de_décès));

insert into décès values
("Zouari","Mohamed Ali",'2008-06-07',"Moknine",06987615,07159487,0,0),
("Zouari","Ali",'1995-08-01',"Moknine",001159487,001289456,2,2),
("Zouari","Mohamed",'2008-04-05',"Moknine",001159487,001289456,5,3);

create table administrateur
(CIN int primary key references Citoyen(CIN) ,check(CIN>0),
mot_de_passe varchar(20));

insert into administrateur values
(14034332,"456");

create table super_admin
(CIN int primary key references Citoyen(CIN), check(CIN>0),
mot_de_passe varchar(20));

insert into super_admin values
(14035157,"123");

drop procedure if exists get_nom_p;
drop procedure if exists get_nom_m;
drop procedure if exists get_prénom_p;
drop procedure if exists get_prénom_m;

drop procedure if exists get_nom_p2;
drop procedure if exists get_nom_m2;
drop procedure if exists get_prénom_p2;
drop procedure if exists get_prénom_m2;

delimiter //
create procedure get_nom_p(IN n VARCHAR(20), IN p VARCHAR(20), IN ddn date, IN ldn Varchar(20))
begin
  SELECT nom FROM Citoyen where CIN=(SELECT CIN_pére FROM Naissance where nom=n and prénom=p and ddn=Date_de_naissance and ldn=Lieu_de_naissance);
end;
//
delimiter ;

delimiter //
CREATE PROCEDURE get_nom_m(IN n VARCHAR(20), IN p VARCHAR(20), IN ddn date, IN ldn Varchar(20))
BEGIN
  SELECT nom FROM Citoyen where CIN=(SELECT CIN_mére FROM Naissance where nom=n and prénom=p and ddn=Date_de_naissance and ldn=Lieu_de_naissance);
END;
//
delimiter ;

delimiter //
CREATE PROCEDURE get_prénom_p(IN n VARCHAR(20), IN p VARCHAR(20), IN ddn date, IN ldn Varchar(20))
BEGIN
  SELECT prénom FROM Citoyen where CIN=(SELECT CIN_pére FROM Naissance where nom=n and prénom=p and ddn=Date_de_naissance and ldn=Lieu_de_naissance);
END;
//
delimiter ;

delimiter //
CREATE PROCEDURE get_prénom_m(IN n VARCHAR(20), IN p VARCHAR(20), IN ddn date, IN ldn Varchar(20))
BEGIN
  SELECT prénom FROM Citoyen where CIN=(SELECT CIN_mére FROM Naissance where nom=n and prénom=p and ddn=Date_de_naissance and ldn=Lieu_de_naissance);
END;
//
delimiter ;

delimiter //
create procedure get_nom_p2(IN n VARCHAR(20), IN p VARCHAR(20), IN ddd date, IN ldd Varchar(20))
begin
  SELECT nom FROM Citoyen where CIN=(SELECT CIN_pére FROM Décès where nom=n and prénom=p and ddd=Date_de_décès and ldd=Lieu_de_décès);
end;
//
delimiter ;

delimiter //
CREATE PROCEDURE get_nom_m2(IN n VARCHAR(20), IN p VARCHAR(20), IN ddd date, IN ldd Varchar(20))
BEGIN
  SELECT nom FROM Citoyen where CIN=(SELECT CIN_mére FROM Décès where nom=n and prénom=p and ddd=Date_de_décès and ldd=Lieu_de_décès);
END;
//
delimiter ;

delimiter //
CREATE PROCEDURE get_prénom_p2(IN n VARCHAR(20), IN p VARCHAR(20), IN ddd date, IN ldd Varchar(20))
BEGIN
  SELECT prénom FROM Citoyen where CIN=(SELECT CIN_pére FROM Décès where nom=n and prénom=p and ddd=Date_de_décès and ldd=Lieu_de_décès);
END;
//
delimiter ;

delimiter //
CREATE PROCEDURE get_prénom_m2(IN n VARCHAR(20), IN p VARCHAR(20), IN ddd date, IN ldd Varchar(20))
BEGIN
  SELECT prénom FROM Citoyen where CIN=(SELECT CIN_mére FROM Décès where nom=n and prénom=p and ddd=Date_de_décès and ldd=Lieu_de_décès);
END;
//
delimiter ;

select * from Citoyen;
select * from Naissance;
select * from Décès;
select * from super_admin;
select * from administrateur;