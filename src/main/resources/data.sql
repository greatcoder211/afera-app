/*delete from Scandal_Politicians;
delete from Scandal_Parties;
delete from Party_Politicians;
delete from Politician;
delete from Party;
delete from Scandal;
delete from Scandal_Report;
*/
-- 1. Tworzymy Partie (ID zostaną nadane automatycznie: 1, 2, 3)
insert into Party (name, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('SLD', 0.00, 70000000.00); -- ID 1: SLD
insert into Party (name, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('PO', 0.00, 550000000.00); -- ID 2: PO
insert into Party (name, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('PiS', 280000000.00, 0.00); -- ID 3: PiS

-- 2. Tworzymy Polityków i przypisujemy ich do Partii (używając ID partii)
insert into Politician (firstName, lastName, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Leszek', 'Miller', 0.00, 70000000.00);
insert into Politician (firstName, lastName, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Zbigniew', 'Chlebowski', 0.00, 550000000.00);
insert into Politician (firstName, lastName, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Marcin', 'Romanowski', 280000000.00, 0.00);

-- 3. Tworzymy Afery (Scandals)
insert into Scandal (name, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Rywina', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2002, 2003, 0.00, 70000000.00); -- ID 1
insert into Scandal (name, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Hazardowa', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2009, 2009, 0.00, 550000000.00); -- ID 2
insert into Scandal (name, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney)
values ('Afera Funduszu Sprawiedliwości', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2018, 2024, 280000000.00, 0.00); -- ID 3

-- 4. Łączymy Afery z Partiami w tabeli łączącej
insert into Scandal_Parties (scandal, party) values (1, 1); -- Rywin <-> SLD
insert into Scandal_Parties (scandal, party) values (2, 2); -- Hazardowa <-> PO
insert into Scandal_Parties (scandal, party) values (3, 3); -- Fundusz <-> PiS

-- 5. Partie z Politykami
insert into Party_Politicians(party, politician) values (1, 1);
insert into Party_Politicians(party, politician) values (2, 2);
insert into Party_Politicians(party, politician) values (3, 3);

-- 6. Afery z Politykami
insert into Scandal_Politicians(scandal, politician) values (1, 1);
insert into Scandal_Politicians(scandal, politician) values (2, 2);
insert into Scandal_Politicians(scandal, politician) values (3, 3);

-- 7. Opcjonalny raport (na start)
insert into Scandal_Report (scandalName, scandalDescription, sources)
values ('Nowy raport', 'Podsumowanie historycznych afer III RP', 'Archiwa sejmowe');

