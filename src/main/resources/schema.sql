create table parties(id BIGINT(255) AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), confirmedEmbezzledAmountOfMoney DECIMAL(19, 2), unconfirmedEmbezzledAmountOfMoney DECIMAL(19, 2));
create table politicians(id BIGINT(255), firstName VARCHAR(255), lastName VARCHAR(255), confirmedEmbezzledAmountOfMoney DECIMAL(19, 2), unconfirmedEmbezzledAmountOfMoney DECIMAL(19, 2));
create table scandals(id BIGINT(255), name VARCHAR(255), description VARCHAR(10000), createdAt DATE, updatedAt DATE, startYear INT, endYear INT, confirmedEmbezzledAmountOfMoney DECIMAL(19, 2), unconfirmedEmbezzledAmountOfMoney DECIMAL(19, 2));
create table memberships(id BIGINT(255), party VARCHAR(255), entryDate DATE, departureDate DATE);

create table party_politicians(party_id BIGINT(255), politician_id BIGINT(255));
create table scandal_parties(scandal_id BIGINT(255), party_id BIGINT(255));
create table scandal_politicians(scandal_id BIGINT(255), politician_id BIGINT(255));
create table politician_memberships(politician_id BIGINT(255), membership_id BIGINT(255));

alter table party_politicians add foreign key (politician_id) references politicians(id);
alter table party_politicians add foreign key (party_id) references parties(id);

alter table scandal_parties add foreign key (scandal_id) references scandals(id);
alter table scandal_parties add foreign key (party_id) references parties(id);

alter table scandal_politicians add foreign key (politician_id) references politicians(id);
alter table scandal_politicians add foreign key (scandal_id) references scandals(id);

alter table politician_memberships add foreign key (politician_id) references politicians(id);
alter table politician_memberships add foreign key (membership_id) references memberships(id);
