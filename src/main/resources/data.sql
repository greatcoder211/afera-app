insert into parties (id, name)
values (1, 'PO');
insert into parties (id, name)
values (2, 'PiS');
insert into parties (id, name)
values (3, 'Konfederacja');
insert into parties (id, name)
values (4, 'SLD');

insert into politicians (id, firstName, lastName)
values (1, 'Donald', 'Tusk');
insert into politicians (id, firstName, lastName)
values (2, 'Zbigniew', 'Ziobro');
insert into politicians (id, firstName, lastName)
values (3, 'Marcin', 'Romanowski');
insert into politicians (id, firstName, lastName)
values (4, 'Leszek', 'Miller');
insert into politicians (id, firstName, lastName)
values (5, 'Zbigniew', 'Chlebowski');
insert into politicians (id, firstName, lastName)
values (6, 'Konrad', 'Berkowicz');
insert into politicians (id, firstName, lastName)
values (7, 'Mateusz', 'Morawiecki');

//to be continued, reszta do poprawy jesli chodzi o te "insert into" pierdoly, moze kiedys np. przy pkazji treningu h2 do tego wroce i guckne

insert into scandals (name, description, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Rywina', 'Lapowka Miller Rywin i spolka', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2002, 2003, 0.00, 70000000.00);
insert into scandals (name, description, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Hazardowa', '700 milionow zamiast do budzetu poszlo do kieszeni', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2009, 2009, 0.00, 550000000.00);
insert into scandals (name, description, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Funduszu Sprawiedliwości', 'grupa afera', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2018, 2024, 280000000.00, 0.00);

insert into memberships(id, partyId, entryDate, departureDate) values(1, 1, '1999-04-15', '2021-03-18');
insert into memberships(id, partyId, entryDate) values(2, 3, '2023-05-03');
insert into memberships(id, partyId, entryDate, departureDate) values(3, 2, '2001-05-01', '2011-08-12');

insert into scandal_parties (scandal_id, party_id) values (1, 1);
insert into scandal_parties (scandal_id, party_id) values (2, 2);
insert into scandal_parties (scandal_id, party_id) values (3, 3);

insert into party_politicians(party_id, politician_id) values (1, 1);
insert into party_politicians(party_id, politician_id) values (2, 2);
insert into party_politicians(party_id, politician_id) values (3, 3);

insert into scandal_politicians(scandal_id, politician_id) values (1, 1);
insert into scandal_politicians(scandal_id, politician_id) values (2, 2);
insert into scandal_politicians(scandal_id, politician_id) values (3, 3);
