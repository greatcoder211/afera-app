insert into parties (name, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('SLD', 0.00, 70000000.00);
insert into parties (name, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('PO', 0.00, 550000000.00);
insert into parties (name, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('PiS', 280000000.00, 0.00);

insert into politicians (firstName, lastName, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Leszek', 'Miller', 0.00, 70000000.00);
insert into politicians (firstName, lastName, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Zbigniew', 'Chlebowski', 0.00, 550000000.00);
insert into politicians (firstName, lastName, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Marcin', 'Romanowski', 280000000.00, 0.00);

insert into scandals (name, description, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Rywina', 'Lapowka Miller Rywin i spolka', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2002, 2003, 0.00, 70000000.00);
insert into scandals (name, description, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Hazardowa', '700 milionow zamiast do budzetu poszlo do kieszeni', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2009, 2009, 0.00, 550000000.00);
insert into scandals (name, description, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Funduszu Sprawiedliwości', 'grupa afera', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2018, 2024, 280000000.00, 0.00);

insert into politician_memberships(politicianId, party, entryDate, departureDate) values(1, 1, '1999-04-15', '2021-03-18');
insert into politician_memberships(politician, party, entryDate) values(2, 3, '2023-05-03');
insert into politician_memberships(politician, party, entryDate, departureDate) values(3, 2, '2001-05-01', '2011-08-12');

insert into scandal_parties (scandal_id, party_id) values (1, 1);
insert into scandal_parties (scandal_id, party_id) values (2, 2);
insert into scandal_parties (scandal_id, party_id) values (3, 3);

insert into party_politicians(party_id, politician_id) values (1, 1);
insert into party_politicians(party_id, politician_id) values (2, 2);
insert into party_politicians(party_id, politician_id) values (3, 3);

insert into scandal_politicians(scandal_id, politician_id) values (1, 1);
insert into scandal_politicians(scandal_id, politician_id) values (2, 2);
insert into scandal_politicians(scandal_id, politician_id) values (3, 3);
