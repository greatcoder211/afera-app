create table if not exists Party ( id identity,
                                    name varchar(50) not null,
                                   confirmedEmbezzledAmountOfMoney decimal(19,2) not null,
                                     unconfirmedEmbezzledAmountOfMoney decimal(19,2) not null );

create table if not exists Politician ( id identity,
                                        firstName varchar(50) not null,
                                        lastName varchar(50) not null,
                                        confirmedEmbezzledAmountOfMoney decimal(19,2) not null,
                                        unconfirmedEmbezzledAmountOfMoney decimal(19,2) not null);

create table if not exists Scandal ( id identity,
                                     name varchar(100) not null,
                                    createdAt timestamp not null,
                                    updatedAt timestamp not null,
                                    startYear int not null,
                                    endYear int,
                                    confirmedEmbezzledAmountOfMoney decimal(19,2) not null,
                                    unconfirmedEmbezzledAmountOfMoney decimal(19,2) not null );

create table if not exists Scandal_Parties ( scandal bigint not null,
                                             party bigint not null );

alter table Scandal_Parties add foreign key (scandal) references Scandal(id);
alter table Scandal_Parties add foreign key (party) references Party(id);

create table if not exists Scandal_Report ( id identity,
                                            scandalName varchar(100) not null,
                                            scandalDescription varchar(255) not null,
                                            sources varchar(255) not null );
create table if not exists Scandal_Politicians( scandal bigint not null,
                                                politician bigint not null   );
alter table Scandal_Politicians add foreign key (scandal) references Scandal(id);
alter table Scandal_Politicians add foreign key (politician) references Politician(id);

create table if not exists Party_Politicians( Party bigint not null,
                                                Politician bigint not null);
alter table Party_Politicians add foreign key (party) references Party(id);
alter table Party_Politicians add foreign key (politician) references Politician(id);