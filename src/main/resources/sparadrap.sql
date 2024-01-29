create database if not exists sparadrap;
use sparadrap;

create table if not exists Adresse
(
idAdresse int auto_increment,
numAdresse numeric(4),
nomRueAdresse varchar(50),
codePostalAdresse numeric(5),
villeAdresse varchar(20),
primary key(idAdresse)
);

create table if not exists Personne
(
idPersonne int auto_increment,
nomPersonne varchar(20),
prenomPersonne varchar(20),
idAdresse int,
telPersonne numeric(10),
emailPersonne varchar(50),
primary key (idPersonne),
constraint FK_Adresse foreign key(idAdresse) references Adresse(idAdresse) ON DELETE cascade 
);

create table if not exists mutuelle
(
idMut int auto_increment,
nomMut varchar(20),
idAdresse int,
telMut numeric(10),
emailMut varchar(50),
depMut numeric(2),
tauxRembMut numeric(3),
primary key(idMut),
constraint fk_mutuelle_addresse foreign key(idAdresse) references Adresse(idAdresse) ON DELETE CASCADE
);

create table if not exists Medecin
(
idMedecin int auto_increment,
idPersonne int,
numAgrement bigint(11),
speMedecin varchar(20),
primary key(idMedecin),
constraint fk_Medecin_Personne foreign key (idPersonne) references personne(idpersonne) ON DELETE CASCADE
);

create table if not exists Patient
(
idPat int not null auto_increment,
idPersonne int,
idMut int,
dateNaisPat date,
numSecuPat bigint(15) not null unique,
primary key(idPat),
constraint fk_Patient_Personne foreign key (idPersonne) references personne(idPersonne) ON DELETE CASCADE,
constraint fk_Patient_Mutuelle foreign key (idMut) references Mutuelle(idMut) ON DELETE restrict
);

create table if not exists Ordonance
(
idOrdo int auto_increment,
dateOrdo date,
idPat int,
idMedecin int,
primary key(idOrdo),
constraint fk_ordonance_patient foreign key (idPat) references patient(idPat) ON DELETE cascade,
constraint fk_Ordonance_Medecin foreign key (idMedecin) references Medecin(idMedecin) ON DELETE cascade
);

create table if not exists Medicament
(
idMed int auto_increment,
nomMed varchar(40),
cateMed varchar(20),
prixMed numeric(3.2),
dateServiceMed date,
quantiteMed int,
primary key(idMed)
);

create table if not exists achat
(
idAchat int auto_increment,
idOrdo int,
idPat int,
primary key(idAchat),
constraint fk_achat_ordonance foreign key(idordo) references ordonance (idordo) ON DELETE CASCADE,
constraint fk_achat_patient foreign key(idpat) references patient (idpat) ON DELETE cascade
);

create table if not exists possede
(
idMedecin int,
idPat int,
primary key(idMedecin,idPat),
constraint fk_possede_medecin foreign key (idMedecin) references Medecin(idMedecin) ON DELETE cascade,
constraint fk_possede_Patient foreign key (idPat) references patient(idpat) ON DELETE cascade
);

create table if not exists Historique
(
idHisto int auto_increment,
datHisto datetime not null,
nomMed varchar (50),
patient varchar (50),
idAchat int,
primary key(idHisto),
constraint fk_Historique_achat foreign key (idAchat) references achat(idachat) ON DELETE cascade
);

create table if not exists panier
(
idPanier int auto_increment,
idmed int,
idachat int,
primary key(idPanier),
constraint fk_panier_medicament foreign key (idmed) references medicament(idmed) ON DELETE cascade,
constraint fk_panier_achat foreign key (idachat) references achat(idachat) ON DELETE cascade
);

create table if not exists contient
(
idContient int auto_increment,
idOrdo int,
idMed int,
primary key(idContient),
constraint fk_appartient_ordoannce foreign key (idOrdo) references Ordonance(idOrdo) ON DELETE cascade,
constraint fk_appartient_med foreign key (idMed) references Medicament(idMed) ON DELETE cascade
);

create table if not exists login
(
idLogin int auto_increment,
nomLogin varchar (50),
MDPLogin varchar (250),
roleLogin varchar (50),
primary key(idLogin)
);

create table if not exists employe
(
idEmploye int auto_increment,
idPersonne int,
dateNais date,
primary key(idEmploye),
constraint fk_employe_Personne foreign key (idPersonne) references personne(idPersonne) ON DELETE cascade
);

insert into Adresse (numAdresse, nomRueAdresse, codePostalAdresse, villeAdresse)
	values (123,"RUE DE LA FICTIVITE",75000,"PARIS"),(456,"AVENU DE LA FICTION",75000,"PARIS"),(10,"CHEMIN DES CLOUS",75000,"PARIS"),(12,"RUE DE LA LIBERTE",75000,"PARIS"),
			(32,"BOULEVARD MOZARD",75000,"PARIS"),(11,"PLACE DE LA NATION",75011,"PARIS"),(10,"RUE ANATOLE DE LA FORGE",75017,"PARIS"),(21,"RUE FAIDHERBE",55011,"PARIS"),
			(133,"AVENUE SUFFREN",75007,"PARIS"),(59,"RUE GEOFFROY-SAINT-HILLAIRE",75005,"PARIS"),(1953,"CHARLE LE ROI",67000,"STRASBOURG"),(20,"FOOTIX",75000,"PARIS"),
			(975,"RUE BAUDELAIRE",76600,"HAVRE"),(57,"PLACE MICHELLIN",59000,"LILLE"),(1035,"RUE DES POIRIER",54670,"CUSTINE"),(99,"BOULEVARD GAMBETA",54670,"CUSTINE");
            
insert into Personne (nomPersonne, prenomPersonne, idAdresse, telPersonne, emailPersonne)
	values ("MARTIN","PIERRE",1,0603487571,"MARTIN.PIERRE@GMAIL.COM"),("DURAND","MARIE",2,0611824977,"DURANT.MARIE@GMAIL.COM"),("PETIT","JONATHAN",3,0622030849,"PETIT.JONATHAN@GMAIL.COM"),
			("DUVET","HONORINE",4,0615084926,"DUVET.HONORINE@GMAIL.COM"),("PIERRARD","LAETITIA",5,0648596120,"PIERRARD.LAETITIA@GMAIL.COM"),("GALLET","ANNE",6,0622487594,"GALLET.ANNE@GMAIL.COM"),
            ("MALKA","MICHEL",7,0628497557,"MALKA.MICHEL@GMAIL.COM"),("KHEBICHAT","OMAR",8,0603518774,"KHEBICHAT.OMAR@GMAIL.COM"),("BURSEAUX","SARAH",9,0623351554,"BURSEAUX.SARAH@GMAIL.COM"),
			("RABAH","NACERA",10,0659889589,"RABAH.NACERA@GMAIL.COM"),("NOUVEAU","CLEMENTINE",15,0659487956,"NOUVEAU.CLEMENTINE@GMAIL.COM"),("PINO","RICHARD",16,0612365986,"PINO.RICHARD@GMAIL.COM");
            
insert into mutuelle(nomMut, idAdresse, telMut, emailMut, depMut, tauxRembMut)
	values ("AXA",11, 0619858875,"AXA.SERVICECLIENT@GMAIL.COMm",67,100),("MGEN",12, 0600235898,"MGEN.SERVICECLIENT@GMAIL.COM",75,100),("MAAF",13,0698598748,"MAAF.SERVICECLIENT@GMAIL.COM",76,100),
			("ALIANZ",14,0612457849,"ALIANZ.SERVICECLIENT@GMAIL.COM",67,100);
            
insert into  Medecin(idPersonne, numAgrement, speMedecin)
	values (6,10123456789,"ENDOCRINOLOGUE"),(7,15847754886,"PNEUMOLOGUE"),(8,35148774956,"GENERALISTE"),(9,31547848875,"PEDIATRE"),(10,84975989571,"CARDIOLOGUE");

insert into Patient(idPersonne,idMut, dateNaisPat, numSecuPat)
	values (1,1,"1997-01-01","197017512348622"),(2,3,"2000-05-11","200057533277804"),(3,1,"1990-01-31","190017559644898"),(4,4,"1993-06-27","293087510237157"),(5,2,"1985-11-13","285117511247862");
    
insert into Ordonance(dateOrdo,idPat, idMedecin)
	values ("2023-08-22",1,1),("2023-7-12",02,1),("2022-01-03",4,2),("2023-08-22",3,2),("2023-05-26",5,3),("2023-07-12",2,3),("2022-01-03",4,3),("2023-08-22",5,4),("2023-05-26",3,4),("2023-05-26",1,5);
    
insert into Medicament(nomMed, cateMed, prixMed, dateServiceMed, quantiteMed)
	values ("ANALGESIQUE","ANALGESIQUE",15,"2023-02-01",50),("ANTISPASMODIQUES","ANALGESIQUE",26,"2020-09-01",36),("CORTICOIDE","ANALGESIQUE",15,"2021-07-01",23),
			("BETA-LACTAMINES","ANTIBIOTIQUES",12,"2023-02-01",12),("POLYMYXINES","ANTIBIOTIQUES",24,"2022-06-01",24),("TETRACICLINES","ANTIBIOTIQUES",30,"2023-02-01",6),
            ("ANTITUBERCULEUX","ANTITUBERCULEUX",36,"2022-12-01",14),("ANTIFIONGIQUES","ANTIMYCOSIQUES",11,"2020-09-01",62),("BETA-BLOQUANT","CARDIOLOGIE",24,"2022-06-01",24),
            ("CORRECTEUR DES  BRADYCARDIES","CARDIOLOGIE",15,"2023-02-01",100),("DIURETIQUE","CARDIOLOGIE",38,"2023-08-01",70),("ANTIACNEIQUE","DERMATOLOGIE",52,"2022-06-01",24),
            ("ANTISEPTIQUES","DERMATOLOGIE",26,"2022-02-01",83),("HORMONE THYROIDIENNES","ENDOCRINOLOGIE",27,"2022-06-01",6),("ANDROGENES","ENDOCRINOLOGIE",33,"2022-02-01",2),
            ("ANTIDIARRHEIQUES","GASTRO-ENTEROLOGIE",12,"2022-06-01",54);
            
insert into  achat(idOrdo, idPat)
	values (1,1),(2,2),(3,4),(4,3),(5,5),(6,2),(7,4),(8,5),(9,3),(10,1);

insert into possede(idMedecin,idPat)
	values (1,1),(1,2),(2,4),(2,3),(3,5),(3,2),(3,4),(4,5),(4,3),(5,1);
    
insert into contient(idOrdo, idMed)
	values(1,1),(1,14),(1,15),(2,16),(3,5),(3,11),(3,6),(4,8),(4,1),(5,16),(5,1),(6,7),(7,7),(7,3),(7,2),(7,12),(8,10),(9,13),(9,11),(9,9),(10,10),(10,4);
    
insert into panier(idmed, idachat)
	values(1,1),(14,1),(15,1),(2,8),(2,4),(8,5),(9,6),(5,2),(1,4),(5,1),(2,1),(4,5),(2,3),(6,5),(8,7),(5,9);

insert into login(nomLogin, MDPLogin, roleLogin)
	values('pharmacien', '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.', 'PHARMACIEN'),
			('admin', '$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC', 'ADMIN');

insert into employe(idPersonne, dateNais)
	values (11,"1995-09-22"),(12,"1980-10-05");
    
delimiter |
create trigger delete_patient_personne
before delete on Patient
for each row
begin
	delete from personne where personne.idpersonne = old.idpersonne;
end |
delimiter ;

delimiter |
create trigger delete_personne_adresse
before delete on personne
for each row
begin
	delete from adresse where adresse.idadresse = old.idadresse;
end |
delimiter ;

delimiter |
create trigger delete_medecin_personne
before delete on Medecin
for each row
begin
	delete from personne where personne.idpersonne = old.idpersonne;
end |
delimiter ;

delimiter |
create trigger delete_employe_personne
before delete on Employe
for each row
begin
	delete from personne where personne.idpersonne = old.idpersonne;
end |
delimiter ;