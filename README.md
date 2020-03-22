# Aplicatie pentru gestionarea activitatilor intr-o sala de forta

## Descrierea problemei
Intrucat in ziua de azi ne confruntam tot mai mult cu probleme legate de sedentarism sau obezitate, trebuie sa luam in serios miscarea si sportul zilnic. Pentru multi dintre noi cel mai convenient e sa alegem sa mergem la sala pentru a face sport si a ne intretine corpul sanatos. Insa cel mai dificil cand mergem la sala este alegerea exercitiilor, alegerea unui program din multitudinea celor prezente pe internet precum si alegerea unei diete.
Problema de rezolvat o reprezinta implementarea unei aplicatii in vederea gestionarii activitatilor dintr-o sala de forta si monitorizarea acestora, precum si crearea unor programe de exercitii sau de dieta de catre un antrenor.


## Solutia aleasa
 Aplicatia va contine doua tipuri de useri, administrator care poate efectua operatii de tip CRUD, pentru a stoca, sterge si a modifica date din baza de date si antrenor care poate selecta anumite alimente pentru a creea o dieta, precum si exercitii pentru a alcatui un program de antrenament.
 Pentru interfata grafica cu utilizatorul vom folosi Android, iar pentru backend vom folosi librarii preimplementate din Java, precum Hibernate pentru conexiunea cu baza de date, MySQL Workbench pentru gestionarea bazei de date si a tabelelor, iar pentru interactiunea cu interfata grafica se va folosi Spring.
 
## Implementare
In baza de date avem tabela de traineri si de admini precum si tabela de account-uri. Tabelele de admini si traineri sunt unificate prin tabela de user, care are o conexiune de one-to-one cu tabela de account prin campul de username.

### Todos

 - Write MORE Tests
 

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
