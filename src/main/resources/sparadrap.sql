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
constraint fk_Medecin_Personne foreign key (idPersonne) references personne(idpersonne) ON DELETE restrict
);

create table if not exists Patient
(
idPat int auto_increment,
idPersonne int,
idMut int,
dateNaisPat date,
numSecuPat bigint(15),
primary key(idPat),
constraint fk_Patient_Personne foreign key (idPersonne) references personne(idpersonne) ON DELETE CASCADE,
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
primary key(idHisto)
);

create table if not exists contient
(
idOrdo int,
idMed int,
primary key(idOrdo,idMed),
constraint fk_appartient_ordoannce foreign key (idOrdo) references Ordonance(idOrdo) ON DELETE cascade,
constraint fk_appartient_med foreign key (idMed) references Medicament(idMed) ON DELETE cascade
);

create table if not exists panier
(
idmed int,
idachat int,
primary key(idmed,idachat),
constraint fk_panier_medicament foreign key (idmed) references medicament(idmed) ON DELETE cascade,
constraint fk_panier_achat foreign key (idachat) references achat(idachat) ON DELETE cascade
);

insert into Adresse (numAdresse, nomRueAdresse, codePostalAdresse, villeAdresse)
	values (123,"rue de la Fictivite",75000,"Paris"),(456," avenue de la Fiction",75000,"Paris"),(10,"chemin des clous",75000,"Paris"),(12,"rue de la liberte",75000,"Paris"),
			(32,"boulevard mozard",75000,"Paris"),(11,"place de la nation",75011,"Paris"),(10,"rue anatole de la forge",75017,"Paris"),(21,"rue faidherbe",55011,"Paris"),
			(133,"avenue de suffren",75007,"Paris"),(59,"rue geoffroy-saint-hilaire",75005,"Paris"),(1953,"charle le roi",67000,"strasbourg"),(20,"footix",75000,"paris"),
			(975,"baudelaire",76600,"havre"),(57,"place michelin",59000,"lille");
            
insert into Personne (nomPersonne, prenomPersonne, idAdresse, telPersonne, emailPersonne)
	values ("Martin","Pierre",1,0603487571,"Martin.Pierre@gmail.com"),("Durand","Marie",2,0611824977,"Durant.Marie@gmail.com"),("Petit","Jonathan",3,0622030849,"Petit.Jonathan@gmail.com"),
			("Duvet","Honorine",4,0615084926,"Duvet.Honorine@gmail.com"),("Pierrard","Laetitia",5,0648596120,"Pierrard.Laetitia@gmail.com"),("Gallet","Anne",6,0622487594,"Gallet.Anne@gmail.com"),
            ("Malka","Michel",7,0628497557,"Malka.Michel@gmail.com"),("Khebichat","Omar",8,0603518774,"Khebichat.Omar@gmail.com"),("Burseaux","Sarah",9,0623351554,"Burseaux.Sarah@gmail.com"),
			("Rabah","Nacera",10,0659889589,"Rabah.Nacera@gmail.com");

insert into mutuelle(nomMut, idAdresse, telMut, emailMut, depMut, tauxRembMut)
	values ("Axa",11, 0619858875,"axa.serviceClients@gmail.com",67,100),("Mgen",12, 0600235898,"mgen.serviceClients@gmail.com",75,100),("Maaf",13,0698598748,"maaf.serviceClients@gmail.com",76,100),
			("Alianz",14,0612457849,"alianz.serviceClients@gmail.com",67,100);
            
insert into  Medecin(idPersonne, numAgrement, speMedecin)
	values (6,10123456789,"endocrinologue"),(7,15847754886,"pneumologue"),(8,35148774956,"generaliste"),(9,31547848875,"pediatre"),(10,84975989571,"cardiologue");

insert into Patient(idPersonne,idMut, dateNaisPat, numSecuPat)
	values (1,1,"1997-01-01","197017512348622"),(2,3,"2000-05-11","200057533277804"),(3,1,"1990-01-31","190017559644898"),(4,4,"1993-06-27","293087510237157"),(5,2,"1985-11-13","285117511247862");
    
insert into Ordonance(dateOrdo,idPat, idMedecin)
	values ("2023-8-22",1,1),("2023-7-12",2,1),("2022-01-03",4,2),("2023-8-22",3,2),("2023-5-26",5,3),("2023-7-12",2,3),("2022-1-03",4,3),("2023-8-22",5,4),("2023-5-26",3,4),("2023-5-26",1,5);
    
insert into Medicament(nomMed, cateMed, prixMed, dateServiceMed, quantiteMed)
	values ("Analgésique","Analgesiques",15,"2023-2-01",50),("Antispasmodiques","Analgesiques",26,"2020-9-01",36),("Corticoïdes","Analgesiques",15,"2021-7-01",23),
			("beta-lactamines","Antibiotiques",12,"2023-2-01",12),("Polymyxines","Antibiotiques",24,"2022-6-01",24),("Tétracyclines","Antibiotiques",30,"2023-2-01",6),
            ("Antituberculeux","Antitubertuleux",36,"2022-12-01",14),("Antifongiques","Antimycosiques",11,"2020-9-01",62),("Bêta-bloquants","Cardiologie",24,"2022-6-01",24),
            ("Correcteurs des bradycardies","Cardiologie",15,"2023-2-01",100),("Diurétiques","Cardiologie",38,"2023-8-01",70),("Antiacnéiques","Dermatologie",52,"2022-6-01",24),
            ("Antiseptiques","Dermatologie",26,"2022-2-01",83),("Hormones thyroïdiennes","Endocronologie",27,"2022-6-1",6),("Androgènes","Endrocrinologie",33,"2022-2-01",2),
            ("Antidiarrhéiques","Gastro-enterologie",12,"2022-6-01",54);
            
insert into  achat(idOrdo, idPat)
	values (1,1),(2,2),(3,4),(4,3),(5,5),(6,2),(7,4),(8,5),(9,3),(10,1);

insert into possede(idMedecin,idPat)
	values (1,1),(1,2),(2,4),(2,3),(3,5),(3,2),(3,4),(4,5),(4,3),(5,1);
    
insert into contient(idOrdo, idMed)
	values(1,1),(1,14),(1,15),(2,16),(3,5),(3,11),(3,6),(4,8),(4,1),(5,16),(5,1),(6,7),(7,7),(7,3),(7,2),(7,12),(8,10),(9,13),(9,11),(9,9),(10,10),(10,4);
    
insert into panier(idmed, idachat)
	values(1,1),(14,1),(15,1),(2,8),(2,4),(8,5),(9,6),(5,2),(1,4),(5,1),(2,1),(4,5),(2,3),(6,5),(8,7),(5,9);