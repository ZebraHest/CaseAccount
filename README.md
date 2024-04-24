README

Dette projekt er en løsning til BankDatas case.

API'en udsiller tre metoder:
create: Tager to input "name" og "amount". Denne opretter en ny account men givet navn og beløb.
list: Lister alle kendte accounts og data omkring disse.
transfer: Tager tre input "fromId", "toId" og "amount". Denne flytter beløbet fra fromId til toId.

I koden håndterer "Controller" klassen de indkommende kald og sender dem videre til de relevante "handlers" som står for validering og eksekvering.
Der er lavet en adskilledelse mellem backend data klasser og data klasser der bruges til at kommunikere med, dette er for at sikre at der ikke udstilles mere end man ønsker. Samt at der er mulighed for at validerer inden de "rigtige" elementer laves og gemmes.

Data gemmes på nuværende tidspunkt i nogle hashmaps i DataManager, men ville i en endelig udgave være skiftet til en database.
