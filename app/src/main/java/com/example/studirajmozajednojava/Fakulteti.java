package com.example.studirajmozajednojava;

import java.util.ArrayList;
import java.util.Arrays;

public class Fakulteti {
    public static Fakulet[] fakultetiList = {
            new Fakulet(5, R.drawable.medicinskifakultetmostar, "MEDICINSKI FAKULTET-SVEUČILIŠTE U MOSTARU", "Medicinski fakultet pripada Sveučilštu u Mostaru. Studenti Medicinskog fakulteta obrazuju se za zvanje liječnika opće medicine, odnosno za liječnika osposobljenog za poslove primarne zdravstvene zaštite. Nakon završenog studija student stječe zvanje doktor medicine.", "BiH", "Bijeli brijeg bb", "Mostar", "placeholder@gmail.com", "036/335-600", new String[]{"Studij medicine", "Studij dentalne medicine"}),
            new Fakulet(4, R.drawable.pravnifakultetumostaru, "PRAVNI FAKULTET-SVEUČILIŠTE U MOSTARU", "Pravni fakultet Sveučilišta u Mostaru počeo je s radom 1971. godine, a kao samostalna ustanova radi od 1976. godine. Nastava se odvija na tri nivoa: preddiplomske, diplomske i poslijediplomske studije. Nastava je koncipirana u skladu sa principima Bolonjske deklaracije. Pored matične ustanove u Mostaru, postoje i centri u Vitezu i Orašju.", "BiH", "Matice hrvatske bb", "Mostar", "pravo@pfmo.ba", "036/337-150", new String[]{"Pravni studij", "Studij kriminalistike i sigurnosni menadžment"}),
            new Fakulet(4, R.drawable.gradjevinskisum, "GRADEVINSKI FAKULTET-SVEUČILIŠTE U MOSTARU", "Građevinski fakultet Sveučilita u Mostaru, osnovan je 1978. godine. Po nastavnom planu i programu, usvojenom 2005. godine, studijski program građevinarstva podijeljen je u dva ciklusa: preddiplomske studije koje traju 3 godine, odnosno 6 semestara i diplomske studije koje traju 2 godine, odnosno 4 semestara", "BiH", "Matice hrvatske bb", "Mostar", "gfmo@gfmo.ba", "036/355-000", new String[]{"Studij građevinarstva", "Studij arhitekture i urbanizma"}),
            new Fakulet(3, R.drawable.farmaceutskisum, "FARMACEUTSKI FAKULTET-SVEUČILIŠTE U MOSTARU", "Farmaceutski fakultet Sveučilišta u Mostaru, osposobljava studente za poslove u oblasti biomedicine i zdravstva. Osnovni cilj fakulteta je stvaranje budućih ljekarnika u kontinuitetu. Studenti farmacije se obrazuju ne samo u svrhu zdravstvene zaštite pacijenata, već i u svrhu aktivnog sudjelovanja u promociji zdravlja, prevencije i liječenju bolesti.", "BiH", "Matice hrvatske bb", "Mostar", "franjo.jurilj@sve-mo.ba", "036/312-791", new String[]{"Studij farmacije"}),
            new Fakulet(3, R.drawable.ekonomskifakultetuniveritetdxemalbijedic, "EKONOMSKI FAKULTET-UNIVERZITET U MOSTARU", "Ekonomski fakultet u Mostaru, Univerziteta Džemal Bijedić, kao samostalna ustanova radi od 1976. godine. Na Fakultetu je organizovan dvogodišnji i četverogodišnji dodiplomski studij, te postdiplomski studij.", "BiH", "USRC “Midhat Hujdur-Hujka”", "Mostar", "placeholder@gmail.com", "036/514-912", new String[]{"Akademski dodiplomski studij", "Stručni dodiplomski studij", "Poslovni menadžment", "Menadžment finansija", "Računovodstvo i revizija"}),
            new Fakulet(2, R.drawable.fakultetzdravsvenihstudijaumostaru, "FAKULTET ZDRAVSTVENIH STUDIJA-SVEUČILIŠTE U MOSTARU", "Fakultet zdravstvenih studija u Mostaru počeo je sa radom 2000. godine, prvobitno kao Visoka zdravstvena škola, da bi 2008. godine promijenila naziv u Fakultet zdravstvenih studija. Na fakultetu se izvode preddiplomske i diplomske sveučilišne studije, obavlja stručni i znanstveni rad u znanstvenom području biomedicine, kliničke medicine i javnog zdravstva", "BiH", "Bijeli breg bb", "Mostar", "fzs@sve-mo.ba", "036/337-050", new String[]{"Studij sestrinstva", "Studij fizioterapije", "Studij radiološke tehnologije", "Studij sanitarnog inženjerstva", "Studij primaljstva", "Studij radiološke tehnologije", "Studij kliničke fizioterapije", "Studij kliničke zdravstvene njege", "Studij sanitarnog inženjerstva"}),
            new Fakulet(2, R.drawable.prirodnomatemsum, "FAKULTET PRIRODOSLOVNO-MATEMATIČKIH I ODGOJNIH ZNANOSTI-SVEUČILIŠTE U MOSTARU", "Fakultet prirodoslovno-matematičkih i odgojnih znanosti Sveučilišta u Mostaru, osnovan je reformom Pedagoškog fakulteta 2005. godine. Od samog osnovanja do danas u nastavi se primjenjuju principi Bolonjske deklaracije. Nastava se odvija na tri nivoa studija: preddiplomski, diplomski i poslijediplomske ili doktorske studije. Pored matične ustanove u Mostaru, postoje i odvojena odjeljenja u Livnu, Kreševu o Orašju.", "BiH", "Matice hrvatske bb", "Mostar", "fpmoz.mostar@tel.net.ba", "036/355-455", new String[]{"KineziologijA", "Glazbena umjetnost", "Informatika", "Matematika", "Fizika", "Biologija", "Geografija", "Kemija", "Predškolski odgoj", "Razredna nastava", "Pedagogija", "Znanost o okolišu", "Edukacijska rehabilitacija", "Geografija smjer Turizam i zaštita okoliša", "Informatika – Orašje,Razredna nastava – Orašje", "Predškolski odgoj – Orašje", "Geografija smjer Turizam i zaštita okoliša – Orašje", "Glazbena umjetnost – Kreševo", "Tehnika", "Stručni studij kineziologije – 3 godine"}),
            new Fakulet(3, R.drawable.fakultetstrijarstvairacunarstvaumostaru, "FAKULTET STROJARSTVA I RAČUNARSTVA-SVEUČILIŠTE U MOSTARU", "Fakultet strojarstva i računarstva Sveučilišta u Mostaru, pod ovim imenom kao samostalna ustanova, obavlja svoju djelatnost od 2002. godine. Studiji strojarstva i računarstva svrstavaju se u studije iz grupacije tehničkih znanosti i obrazuju mlade stručnjake kako bi preuzeli bitne uloge u tehnološkom razvoju.", "BiH", "Matice hrvatske bb", "Mostar", "office@fsr.ba", "036/337-001", new String[]{"Studij strojarstva", "Studij računarstva", "Studij elektrotehnike", "Računarstvo", "Strojarstvo"}),
            new Fakulet(2, R.drawable.filozofskisum, "FILOZOFSKI FAKULTET-SVEUČILIŠTE U MOSTARU", "Filozofski fakultet Sveučilišta u Mostaru, osnovan je reformom Pedagoškog fakulteta 2005. godine. Nastava se odvija na tri nivoa: preddiplomske, diplomske i postdiplomske studije. Na fakultetu studira oko 300 studenata, a nastavu drži oko 220 nastavnika.Pored organizovanja zajedničkih konferencija i skupova, fakultet sarađuje i sa brojnim drugim ustanovama i institutima. Pored matične ustanove u Mostaru, postoje i odjeljenja u Kiseljaku i Orašju.", "BiH", "Matice hrvatske bb", "Mostar", "ffmo@ffmo.ba", "036/355-400", new String[]{"Hrvatski jezik i književnost – jednopredmetno", "Hrvatski jezik i književnost – dvopredmetno", "Engleski jezik i književnost – jednopredmetno", "Engleski jezik i književnost – dvopredmetno", "Njemački jezik i književnost – jednopredmetno", "Njemački jezik i književnost – dvopredmetno", "Ruski jezik i književnost – dvopredmetno", "Komparativna književnost – dvopredmetno", "Filozofija – dvopredmetno", "Latinski jezik i rimska književnost – dvopredmetno", "Povijest – dvopredmetno", "Povijest umjetnosti – dvopredmetno", "Arheologija – jednopredmetno", "Arhelogija – dvopredmetno", "Psihologija – jednopredmetno", "Novinarstvo – jednopredmetno", "Novinarstvo – dvopredmetno", "Socijalni rad – jednopredmetno", "Politologija – jednopredmetno", "Informacijske znanosti – jednopredmetno", "Informacijske znanosti – dvopredmetno", "Talijanski jezik i književnost – dvopredmetno", "Studij Logopedije – jednopredmetno", "Odnosi s javnošću – jednopredmetno", "Socijalni rad – Orašje", "Odnosi s javnošću – Brčko"}),
            new Fakulet(2, R.drawable.agronomskisum, "AGRONOMSKI I PREHRAMBENO-TEHNOLOŠKI FAKULTET-SVEUČILIŠTE U MOSTARU", "Agronomski i prehrambeno-tehnološki fakultet u Mostaru, počeo je sa radom 1994. godine usljed nedostatka kadrova u oblasti poljoprivrede. Studenti upisuju jedan od dva smjera: opći smjer i smjer prehrambene tehnologije. Studije se odvijaju na tri nivoa: preddiplomske, diplomske i doktorske studije.", "BiH", "Biskupa čule bb", "Mostar", "agronomski.fakultet@sve-mo.ba", "036/337-102", new String[]{"Studije agronomije", "Studije prehrambene tehnologije"}),
            new Fakulet(4, R.drawable.pravnifakultetuniverzitetdzemalbijedicmostar, "PRAVNI FAKULTET-MOSTAR", "Pravni fakultet u Mostaru, Univerziteta Džemal Bijedić, osnovan je 1971. godine kao odjeljenje Pravnog fakulteta u Sarajevu, da bi 1976. godine postao samostalna ustanova. Nastava se odvija na dva ciklusa studija, dodiplomskim i diplomskim studijama.", "BiH", "Univerzitetski kampus, Mostar", "Mostar", "pf@umno.ba", "036/514-230 ", new String[]{"Akademski dodiplomski studij (Bachelor)", "Opći smjer", "Kriminologija i sigurnosne studije", "Međunarodni odnosi i diplomatija", "Građansko-pravni smjer", "Krivično-pravni smjer"}),
            new Fakulet(3, R.drawable.nastavnickifakultetuniverzitetdemalbijedicmostar, "NASTAVNIČKI FAKULTET-MOSTAR ", "Nastavnički fakultet u Mostaru, Univerziteta Džemal Bijedić, osnovan je 1950. godine u početku kao Pedagoška akademija. Od 2002. godine prerasta u Nastavnički fakultet. Nastava se odvija na dva ciklusa studija. Nastava se odvija po principima Bolonjske deklaracije od 2006. godine. Nastavu pohađa oko 2000 studenata.", "BiH", "Sjeverni logor bb", "Mostar", "nf@umno.ba", "036/514-200", new String[]{"Hemija", "Sport i zdravlje", "Razredna nastava", "Konzervacijska biologija i ekologija", "Psihologija i sociologija", "Pedagogija", "Stručni studij iz oblasti sporta"}),
            new Fakulet(2, R.drawable.masinskifakultetuniverzitetdzemalbijedicmostar, "MAŠINSKI FAKULTET-MOSTAR", "Mašinski fakultet u Mostaru, Univerziteta Džemal Bijedić, osnovan je 1959. godine u početku kao Visoka tehnička škola mašinske struke. Od svog osnivanja do danas, studije je završilo preko 2000 studenata. Nastava se odvija na dva ciklusa studija dodiplomskim i diplomskim (master) studijama.", "BiH", "Univerzitetski kampus", "Mostar", "mf@umno.ba,", "036 571-258", new String[]{"Dizajn proizvoda", "Kompjuterski inženjering", "Energetski smje", "Obnovljivi izvori energije", ""}),
            new Fakulet(3, R.drawable.gradevinskifakutetmostaruniverzitet, "GRAĐEVINSKI FAKULTET-MOSTAR", "Građevinski fakultet, Univerziteta Džemal Bijedić u Mostaru, osnovan je 1978. godine. Na fakultetu studira oko 600 studenata, a nastavu drži oko 30 nastavnika i oko 20 saradnika u nastavi. Nastava se odvija na dva ciklusa studija, dodiplomskim i diplomskim studijima, po konceptu 3+2.", "BiH", "USRC “Mithat Hujdur Hujka”", "Mostar", "studentskagf@umno.ba", "036/514-850", new String[]{"Akademski dodiplomski studij", "Opći odsjek", "Geodezija i geoinformatika", "Konstruktovni odsjek", "Upravljanje okolišom i infrastrukturom"}),
            new Fakulet(2, R.drawable.fakultetinformacijskihtehnologijaumostaru, "FAKULTET INFORMACIJSKIH TEHNOLGIJA- MOSTAR", "Fakultet informacijskih tehnologija u Mostaru, pripada Univerzitetu Džemal Bijedić. Studenti se obrazuju kroz dva ciklusa studija dodiplomske i diplomske (master) studije. Za upis na fakultet informacijskih tehnologija potrebno je položiti prijemni ispit, što nije slučaj za većinu drugih fakulteta, članica Univerziteta Džemal Bijedić.", "BiH", "Sjeverni Logor 12", "Mostar", "esluzba@edu.fit.ba", "036/281-160", new String[]{"Akademski dodiplomski studij", "Diplomski studij"}),
            new Fakulet(3, R.drawable.fakultethumanistickihnauka, "FAKUKTET HUMANISTIČKIH NAUKA-MOSTAR", "Fakultet humanističkih nauka u Mostaru, pripada Univerzitetu Džemal Bijedić i osnovan je 2002. godine. Nastava se odvija kroz tri ciklusa: dodiplomske, diplomske (master) i doktorske studije.", "BiH", "USRC „Mithad Hujdur Hujka“ bb", "Mostar", "celebija.tikvesa@umno.ba", "036/571-359", new String[]{"Bosanski jezik i književnost", "Engleski jezik i književnost", "Turski jezik i književnost", "Njemački jezik i književnost", "Historija i međunarodni odnosi", "Komunikologija", "Bosanski jezik i književnost", "Engleski jezik i književnost", "Njemački jezik i književnost", "Historija", "Komunikologija"}),
            new Fakulet(2, R.drawable.muzickaakademijaistocnosarajevo, "AKADEMIJA LIKOVNIH UMJETNOSTI-SARAJEVO", "Akademija likovnih umjetnosti u Sarajevu osnovana je 1972. godine. Postoje dva ciklusa studija. U planu je izrada trećeg ciklusa studija. Nastava se odvija po principu 4+1.", "BiH", "Obala Maka Dizdara 3", "Sarajevo", "alu@alu.unsa.ba", "033/210-369 ", new String[]{"Nastavnički Odsjek", "Odsjek slikarstvo", "Odsjek kiparstvo", "Odsjek grafika", "Odsjek grafički dizajn", "Odsjek produkt dizajn"}),
            new Fakulet(3, R.drawable.arhitektonskifakultetsarajevo, "ARHITEKTONSKI FAKULTET-SARAJEVO", "Arhitektonski fakultet u Sarajevu osnovan je 1949. godine.Nastava se izvodi po principima Bolonjske deklaracije, i u 3 ciklusa studija (3+2+3). Prvi ciklus je u trajanju od 3 godine (6 semestara), drugi ciklus je u trajanju do 2 godine (4 semestra) i treći ciklus traje 3 godine. Studentima je na raspolaganju opći smjer.", "BiH", "Patriotske lige 30", "Sarajevo", "arh.f.sa@bih.net.ba", "033/226-530", new String[]{"Opći smjer", "doktorske studije"}),
            new Fakulet(3, R.drawable.ekonomskifakultetpale, "EKONOMSKI FAKULTET-SARAJEVO", "Ekonomski fakultet u Sarajevu osnovan je 1952. godine. Postoje 3 ciklusa studija (3+2+3). Nastava se odvija po principima bolonjske deklaracije.", "BiH", "Trg oslobođenja – Alija Izetbegović 1", "Sarajevo", "efsa@efsa.unsa.ba", "033/275-900", new String[]{"Odsjek Ekonomija", "Odsjek Menadžment", "Odsjek Menadžment – engleski jezik", "Odsjek Visoka poslovna škola", "Studij u saradnji sa Griffith College Dablin", "Irska"}),
            new Fakulet(2, R.drawable.elektrotehnickifakultetistocnosarajevo, "ELEKTROTEHNIČKI FAKULTET-SARAJEVO", "Elektrotehnički fakultet u Sarajevu osnovan je 1961. godine. Fakultet pohađa oko 1300 studenata., ", "BiH", "Zmaja od Bosne bb", "Sarajevo", "etf@etf.unsa.ba", "033/250-700", new String[]{"Odsjek za automatiku i elektroniku", "Odsjek za elektroenergetiku", "Odsjek za računarstvo i informatiku", "Odsjek za telekomunikacije"}),
            new Fakulet(2, R.drawable.fakultetislamskihnauka, "FAKULTET ISLAMSKIH NAUKA-SARAJEVO", "Fakultet islamskih nauka u Sarajevu je osnovan 1977. godine.", "BiH", "Ćemerlina 54", "Sarajevo", "placeholder@gmail.com", "033/232-982", new String[]{"Teološki smjer", "Smjer za islamsku vjeronauku i religijski odgoj", "Studijski program za imame", "hatibe i mualime"}),
            new Fakulet(3, R.drawable.kriminalistikasar, "FAKULTET ZA KRIMINALISTIKU, KRIMINOLOGIJU I SIGURNOSNE STUDIJE-SARAJEVO", "Fakultet kriminalističkih nauka u Sarajevu osnovan je 1993. godine.", "BiH", "Zmaja od Bosne 8", "Sarajevo", "fkn@fkn.unsa.ba", "033/561-200", new String[]{"Kriminalistika", "Kriminologija", "Sigurnosne studije", "Upravljanje u kriznim situacijama"}),
            new Fakulet(2, R.drawable.politikasarajevo, "FAKULTET POLITIČKIH NAUKA-SARAJEVO", "Fakultet političkih nauka u Sarajevu osnovan je 1961. godine.", "BiH", "Skanderija 72", "Sarajevo", "http://www.fpn.unsa.ba/", "033/203-562", new String[]{"Odsjek politologija", "Upravljanje državom", "Međunarodni odnosi i diplomatija", "Odsjek sociologija", "Odsjek žurnalistika/ komunikologija", "Odsjek sigurnosne i mirovne studije", "Odsjek socijalni rad"}),
            new Fakulet(2, R.drawable.fakultetfizickogvaspitanjaisporta, "FAKULTET SPORTA I TJELESNOG ODGOJA-SARAJEVO", "Fakultet sporta i tjelesnog odgoja u Sarajevu jedan je od najstarijih institucija u regiji, koji je osnovan 1963. godine.", "BiH", "Patriotske lige 41", "Sarajevo", "dekanat@fasto.unsa.ba", "033/668-768", new String[]{"Opći smjer", "Doktorske studije"}),
            new Fakulet(2, R.drawable.saobracajnidoboj, "FAKULTET ZA SAOBRAĆAJ I KOMUNIKACIJR-SARAJEVO", "Fakultet za saobraćaj i komunikacije u Sarajevu osnovan je 1977. godine.", "BiH", "Zmaja od Bosne 8", "Sarajevo", "info@fsk.unsa.ba", "033/565-200 ", new String[]{"Odsjek za saobraćaj", "Cestovni saobraćaj", "Željeznički saobraćaj", "Zrakoplovni saobraćaj", "Odsjek za komunikacije", "Kompjuterske i informacijske tehnologije", "Poštanske tehnologije", "Komunikacijske tehnologije"}),
            new Fakulet(2, R.drawable.farmaceutskisarajevu, "FARMACEUTSKI FAKULTET-SARAJEVO", "Farmaceutski fakultet u Sarajevu počeo je sa radom 1973. godine.", "BiH", "Zmaja od Bosne 8", "Sarajevo", "placeholder@gmail.com", "033/585-180", new String[]{"Jedinstven studij"}),
            new Fakulet(3, R.drawable.filozofskifakultetpale, "FILOZOFSKI FAKULTET-SARAJEVO ", "Filozofski fakultet u Sarajevu osnovan je 1950. godine. Nastava se odvija po principima Bolonjske deklaracija. Prvi ciklus studija je u trajanju od 3 godine (6 semestara). Nakon završenog prvog ciklusa, studenti upisuju drugi ciklus koji je u trajanju od 2 godine (4 semestra). Treći ciklus studija je u trajanju od 3 godine.", "BiH", "Franje Račkog 1", "Sarajevo", "dekanat@ff.unsa.ba", "033/253-100", new String[]{"Odsjek za anglistiku", "Odsjek za bosanski", "hrvatski i srpski jezik", "Odsjek za filozofiju", "Odsjek za sociologiju", "Odsjek za germanistiku", "Odsjek za historiju", "Katedra za historiju/povijest umjetnosti", "Katedra za arheologiju", "Odsjek za književnost naroda BiH", "Odsjek za komparativnu književnost i bibliotekarstvo", "Odsjek za orijentalnu filologiju", "Odsjek za pedagogiju", "Odsjek za psihologiju", "Odsjek za romanistiku", "Odsjek za slavenske jezike i književnost"}),
            new Fakulet(3, R.drawable.gradjevinskisarajevo, "GRADEVINSKI FAKULTET-SARAJEVO", "Građevinski fakultet u Sarajevu postoji već više od 50 godina.", "BiH", "Patriotske lige 30", "Sarajevo", "placeholder@gmail.com", "033/278-400", new String[]{"Studij građevinarstva", "Studij geodezije"}),
            new Fakulet(2, R.drawable.scenskesarajevo, "AKADEMIJA SCENSKIH UMJETNOSTI-SARAJEVO ", "Moguće je pohađati samo redovan studij. Studijski odsjeci su u trajanju od 3 do 5 godina. Studentima su na raspolaganju sljedeći odseci: Odsjek za glumu, Odsjek za režiju – usmjerenje Multimedijalna režija, Odsjek za režiju – usmjerenje Audivizuelne umjetnosti.", "BiH", "Obala Kulina bana 11", "Sarajevo", "asu@asu.unsa.ba", "033/215-277", new String[]{"Gluma"}),
            new Fakulet(4, R.drawable.medicinskisarajevo, "MEDICINSKI FAKULTET-SARAJEVO", "Medicinski fakultet u Sarajevu počeo je sa radom 1944. godine. Postoje dva ciklusa studija: Integrirani studij koji traje 6 godina i Doktorski studij koji traje 3 godine.", "BiH", "Čekaluša 90", "Sarajevo", "benjamin.vojnikovic@mf.unsa.ba", "033/226-478", new String[]{"Integrirani studij Medicine"}),
            new Fakulet(2, R.drawable.muzickaakademijaistocnosarajevo, "MUZIČKA AKADEMIJA-SARAJEVO", "Muzička akademija u Sarajevu osnovana je 1955. godine.", "BiH", "Josipa Štadlera 1/II", "Sarajevo", "studentska@mas.unsa.ba", "033/200-299", new String[]{"Odsjek za kompoziciju", "Odsjek za dirigovanje", "Orkestarsko dirigovanje", "Horsko dirigovanje", "Odsjek za solo pjevanje", "Odsjek za klavir", "udaraljke", "harfu i srodne istrumente", "Klavir", "Klavir i korepeticija", "Klavir metodika", "Udararljke", "Odsjek za gudačke instrumente", "Volina", "Viola", "Violončelo", "Kontrabas", "Gitara", "Odsjek za duvačke instrumente i harmoniku", "Flauta", "Klarinet", "Saksofon", "Truba", "Horna", "Fagot", "Oboa", "Harmonika", "Odsjek za muzikologiju i etnomuzikologiju", "Muzikologija", "Etnomuzikologija", "Odsjek za muzičku teoriju i pedagogiju"}),
            new Fakulet(2, R.drawable.pedagoskisarajevu, "PEDAGOŠKI FAKULTET-SARAJEVO", "Pedagoški fakultet u Sarajevu osnovan je 1946. godine. Nastava se odvija u 3 ciklusa studija. Prvi ciklus studija je u trajanju od 4 godine (8 semestara). Drugi ciklus studija je u trajanju od godinu dana i treći ciklus studija je u trajanju od 3 godine.", "BiH", "Skenderija 72", "Sarajevo", "pedagoski.fakultet@pf.unsa.ba", "033/214-607", new String[]{"Odsjek za predškolski odgoj", "Odsjek za razrednu nastavu", "Odsjek za kulturu življenja i tehnički odgoj", "Odsjek za edukaciju i rehabilitaciju"}),
            new Fakulet(2, R.drawable.poljoprivredniistocnosarajevo, "POLJOPRIVREDNO-PREHRAMBENI FAKULTET-SARAJEVO", "Poljoprivredno-prehrambeni fakultet u Sarajevu osnovan je 1940. godine. Postoje tri ciklusa studija. Studentima su na raspolaganju sljedeći odseci: Odsjek Biljna proizvodnja, Odsjek Zootehnika, Odsjek Ekonomika poljoprivrede i prehrambene industrije, Odsjek Prehrambene tehnologije, Odjeljenje Brčko Distrikt – Biljna proizvodnja.", "BiH", "Zmaja od Bosne 8", "Sarajevo", "b.skaljic@ppf.unsa.ba", "033/225-727", new String[]{"Odsjek Biljna proizvodnja", "Odsjek Zootehnika", "Odsjek Ekonomika poljoprivrede i prehrambene industrije", "Odsjek Prehrambene tehnologije"}),
            new Fakulet(2, R.drawable.pravnifakultetpale, "PRAVNI FAKULTET-SARAJEVO", "Pravni fakultet u Sarajevu je osnovan 1946. godine. Nastava se odvija na 3 ciklusa studija. Prvi ciklus je u trajanju od 4 godine, drugi ciklus je u trajanju od godinu dana i treći ciklus je u trajanju od 3 godine.", "BiH", "Obala Kulina Bana 7", "Sarajevo", "studentska.pfsa.unsa.ba", "033/225-136", new String[]{"Opći smjer", "doktorske studije"}),
            new Fakulet(4, R.drawable.stomatoloskisarajevo, "STOMATOLOŠKI FAKULTET-SARAJEVO", "Stomatološki fakultet u Sarajevu osnovan je 1960. godine.", "BiH", "Bolnička 4a", "Sarajevo", "dentalschool@sf.unsa.ba", "033/214-249", new String[]{"Opći smjer", "Dentalna higijena"}),
            new Fakulet(2, R.drawable.masinskisarajevo, "MAŠINSKI FAKULTET-SARAJEVO", "Mašinski fakultet u Sarajevu je osnovan 1958. godine.", "BiH", "Vilsonovo šetalište 9", "Sarajevo", "placeholder@gmail.com", "033/729-800", new String[]{"Odsjek za mašinski proizvodni inženjering", "Mašinski proizvodni Inženjering", "Odsjek za industrijsko inženjerstvo i menadžment", "Industrijsko inženjerstvo i menadžment", "Odsjek za energetiku", "procesnu tehniku i okolinsko inženjerstvo", "Energetika", "Procesno inženjerstvo", "Klimatizacija", "grijanje i hlađenje", "Odsjek za tehnologiju drveta", "Tehnologije drveta", "Odsjek za motore i vozila", "Motori i vozila", "Odsjek za odbrambene tehnologije", "Odbrambene tehnologije", "Odsjek za mašinske konstrukcije", "Mašinske konstrukcije"}),
            new Fakulet(2, R.drawable.akademijaumjetnostibanjaluka, "AKADEMIJA UMJETNOSTI-BANJA LUKA", "Akademija umjetnosti u Banja Luci osnovana je prije skoro dvije decenije, 1998. godine. Veliki nedostatak školovanih umjetnika bio je jedan od preduslova za osnivanje Akademije umjetnosti po uzoru na akademije u Novom Sadu i Beogradu. Studenti mogu pohađati nastavu na tri studijska programa: dramske, muzičke i likovne umjetnosti. Od svog osnivanja do danas, Akademiju je završilo više od 550 studenata. Mnogi od njih aktivno učestvuju u kulturnom i javnom životu Republike Srpske. Nastava na svim studijskim programima pohađa se u skladu sa Bolonjskom deklaracijom.", "BiH", "Bulevar vojvode Petra Bojovića 1a", "Banja Luka", "info@aubl.org", "051/348-805", new String[]{"Kompozicija", "Solo pjevanje", "Dirigovanje", "Klavir", "Gitara", "Gudački instrumenti", "Duvački instrumenti", "Etnomuzikologija", "Muzička terija i pedagogija", "Kamerna muzika", "Slikarstvo", "Grafika", "Grafički dizajn", "Gluma", "Pozorišna režija", "Dramaturgija", "Filmski i televizijski smjer", "Animirani film", "Produkcija"}),
            new Fakulet(3, R.drawable.arhitektonskogradbl, "ARHITEKTONSKO-GRADEVINSKI FAKULTET-BANJA LUKA", "Arhitektonsko-građevinski fakultet u Banja Luci osnovan je 1995. godine. Studenti nastavu pohađaju na tri studijska programa: arhitektura, građevinarstvo i geodezija. Fakultet je ostvario saradnju sa brojnim srodnim ustanovama, a posebno se ističe potpisan ugovor o saradnji sa Univerzitetom u Beogradu.", "BiH", "Vojvode Stepe Stepanovića 77/3", "Banja Luka", "info@agfbl.org", "051/462-545", new String[]{"Arhitektura", "geodezija", "gradevinarstvo"}),
            new Fakulet(2, R.drawable.ekonbl, "EKONOMSKI FAKULTET-BANJA LUKA", "Ekonomski fakultet u Banjoj Luci osnovna je 1975. godine. Fakultet svojim predanim radom u obrazovanju budućih ekonomista predstavlja okosnicu ekonomskog razvoja Republike Srpske.", "BiH", "Majke Jugovića 4", "Banja Luka", "kontakt@efbl.org", "051/430-010", new String[]{"Ekonomija i poslovno upravljanje", "Poslovna informatika"}),
            new Fakulet(2, R.drawable.elektrotehnickifakultetubanjaluci, "ELEKTROTEHNIČKI FAKULTET-BANJA LUKA", "Elektrotehnički fakultet u Banja Luci, porijeklo vodi od Tehničkog fakulteta i osnovan je 1962. godine. Od svog osnivanja do danas na fakultetu je diplomiralo više od 2000 studenata.", "BiH", "Patre 5", "Banja Luka", "office@etfbl.net", "051/221-820", new String[]{"Računarstvo i informatika", "Elektronika i telekomunikacije", "Elektroenergetski i industrijski sistemi"}),
            new Fakulet(2, R.drawable.masinskibl, "MAŠINSKI FAKULTET-BANJA LUKA", "Mašinski fakultet u Banja Luci, onsovna je kao odljenje Univerziteta u Sarajevu, 1971. godine. Ovaj fakultet je od svog osnivanja, do danas, završilo preko 1500 diplomiranih mašinskih inženjera i odbranjeno je preko 30 doktorskih disertacija.", "BiH", "Vojvode Stepe Stepanovića 71", "Banja Luka", "masinstvobl@unibl.rs", "051/433-000", new String[]{"Proizvodno mašinstvo", "Energetsko i saobraćajno mašinstvo", "Mehatronika", "Industrijsko inženjerstvo", "Zaštita na radu"}),
            new Fakulet(4, R.drawable.medicinskifakultetbl, "MEDICINSKI FAKULTET-BANJA LUKA", "Medicisnki fakultet u Banja Luci osnovan je 1978. godine i jedan je od članica Univerziteta u Banja Luci. Nastava se odvija na osnovnim akademskim, master akademksim i doktorskim studijama.", "BiH", "Save Mrkalja 14", "Banja Luka", "medicinskifakultetbl@yahoo.com", "051/234-100", new String[]{"Medicina", "Dentalna medicina", "Farmacija", "Sestrinstvo", "Radiološka tehnologija", "Fizioterapija", "Sanitarno inžinjerstvo", "Medicinsko labaratorijska dijagnostistika", "Babištvo"}),
            new Fakulet(2, R.drawable.poljoprivrednibijeljina, "POLJOPRIVREDNI FAKULTET-BANJA LUKA", "Poljoprivredni fakultet u Banja Luci, počeo je sa radom 1992. godine. Od školske 2006/2007 godine, nastava se odvija po principima Bolonjske deklaracije. Od svog osnivanja do danas, fakultet je završilo oko 800 inženjera poljoprivrede, što je od velike važnosti za sektor poljoprivrede u cjelini.", "BiH", "Bulevar vojvode Petra Bojovića 1A", "Banja Luka", "agrobl@blic.net", "051/330-901", new String[]{"Animalna proizvodnja", "Biljna proizvodnja", "Ratarstvo i povrtarstvo", "Hortikultura", "Voćarstvo i vonogradarstvo", "Zaštita biljaka", "Agrarna ekonomijai ruralni razvoj"}),
            new Fakulet(3, R.drawable.pravnibijeljina, "PRAVNI FAKULTET-BANJA LUKA", "Pravni fakultet u Banja luci, postoji više od pola vijeka, a osnovan je 1960. godine. Moderna i dobro organizovana ustanova koja za cilj ima obrazovanje novih pravnika, advokata, sudija, tužioca", "BiH", "Bulevar vojvode Stepe Stepanovića 77", "Banja Luka", "info@pravobl.org", "051/339-001", new String[]{"Pravo"}),
            new Fakulet(3, R.drawable.prirodnomatblt, "PRIRODNO-MATEMATIČKI FAKULTET-BANJA LUKA", "Prirodno-matematički fakultet u Banja Luci, osnovan je 1996. godine. Studenti se obrazuju na osam studijskih programa. Nastava je prilagođena principima Bolonjske deklaracije.", "BiH", "Mladena Stojanovića 2", "Banja Luka", "studentska@pmfbl.org", "051/319-142", new String[]{"Opći smjer", "glavni smjer"}),
            new Fakulet(2, R.drawable.tehnoloskizvornik, "TEHNOLOŠKI FAKULTET-BANJA LUKA", "Tehnološki fakultet u Banjoj Luci, osnovan je 1963. godine. Na fakultetu je od njegovog osnvanja do danas, diplomiralo više od 1300 studenata, odbranjeno je preko 60 magistarskih radova i 30 doktorskih disertacija.", "BiH", "Vojvode Stepe Stepanovića 73", "Banja Luka", "info@tfbl.org", "051/434-357", new String[]{"Diplomirani inženjer hemijske tehnologije", "Diplomirani inženjer prehrambene tehnologije – proizvodni", "Diplomirani inženjer prehrambene tehnologije – Kontrola kvaliteta i higijenske ispravnosti namirnica", "Diplomirani inženjer prehrambene tehnologije – Nutritivni kvalitet hrane i ishrane", "Diplomirani inženjer grafičke tehnologije", "Diplomirani inženjer tekstilnog inženjerstva – Odjevna tehnologija i dizajn", "Diplomirani inženjer tekstilnog inženjerstva – Obućarska tehnologija i dizajn"}),
            new Fakulet(2, R.drawable.politickenaukebl, "FAKULTET POLITIČKIH NAUKA-BANJA LUKA", "Fakultet političkih nauka u Banjoj Luci, osnovan je 2009. godine izdvajanjem određenih studijskih programa sa Filozofskog fakulteta. Od 2012. godine na fakultetu je moguće pohađati i master studije na jednom od 4 smjera.", "BiH", "Bulevar vojvode Petra Bojovića 1a", "Banja Luka", "info@fpnbl.org", "051/304-001", new String[]{"Novinarstvo i komunikologija", "Socijalni rad", "Sociologija", "Politikologija"}),
            new Fakulet(2, R.drawable.fizickobanjaluka, "FAKULTET FIZIČKOG VASPITANJA I SPORTA-BANJA LUKA", "Fakultet fizičkog vaspitanja i sporta u Banjoj Luci, omogućuje studentima školovanje na dva nivoa studija: osnovne i master studije.", "BiH", "Bulevar vojvode Petra Bojovića 1a", "Banja Luka", "ffvis@blic.net", "051/312-280", new String[]{"Diplomirani trener", "Diplomirani kondicioni trener", "Diplomirani menadžer sporta", "Diplomirani trener sportske rekreacije"}),
            new Fakulet(3, R.drawable.largefiloloskifakultetglavniulaz, "FILOLOŠKI FAKULTET-BANJA LUKA", "Filološki fakultet u Banja Luci, osnovan je 2009. godine i spada u jedan od mlađih fakulteta u Republici Srpskoj. Studenti imaju mogućnost da studiraju na pet studijskih programa: srpski, njemački, italijanski i francuski jezik. U planu je otvaranje još dva studijska programa, za španski i ruski jezik.", "BiH", "Bulevar Vojvode Petra Bojovića 1a", "Banja Luka", "info.filoloski@unibl.rs", "051/340-120", new String[]{"Srpski jezik i književnosti", "Engleski jezik i književnosti", "Njemački jezik i književnosti", "Italijanski jezik i književnosti", "Francuski jezik i književnosti", "Ruski i srpski jezik i književnost."}),
            new Fakulet(3, R.drawable.filozofskibanjaluka, "FILOZOFSKI FAKULTET-BANJA LUKA", "Filozofski fakultet u Banjoj Luci, osnovan je 1994. godine i jedna je od članica Univerziteta u Banjoj Luci. Nastava se odvija u dva ciklusa, na osnovnim i master studijama. Osnovne studije traju tri ili četiri godine, dok master studije mogu da budu u trajanju od jedne ili dvije godine.", "BiH", "Univerzitetski grad", "Banja Luka", "fil.fakultet@blic.net", "051/322-780", new String[]{"Filozofija", "Psihologija", "Pedagogija", "Istorija", "Učiteljski studij", "Predškolsko vaspitanje"}),
            new Fakulet(2, R.drawable.sumarskifakultetbanjaluka, "ŠUMARSKI FAKULTET-BANJA LUKA", "Šumarski fakultet u Banjoj Luci, osnovan je 1992. godine i pripada Univerzitetu u Banjoj Luci. Nastava se izvodi u dobro opremljenim kabinetima i laboratorijama. Biblioteka fakulteta posjeduje više od 10.000 udžbenika. Od nastanka fakulteta, do danas, odbranjeno je više od 500 diplomskih radova.", "BiH", "Bulevar Vojvode Stepe Stepanovića 75a", "Banja Luka", "sum_fak@blic.net", "051/464-628", new String[]{"Šumarstvo", "prerada drva"}),
    };

    ArrayList<Fakulet> getQueryMatching(String query) {
        ArrayList<Fakulet> out = new ArrayList<>();
        for (Fakulet currentFakultet:
             fakultetiList) {
            if (currentFakultet.doesMatchSearchQuery(query)) {
                out.add(currentFakultet);
            }
        }
        return out;
    }
    
}

