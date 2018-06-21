# teste-mobile-saude

Neste aplicativo, a biblioteca Retrofit foi usada para criar um REST Client e consumir a API Restful disponibilizada.

Na tela de lista de notícias (NewsListActivity), é feita uma chamada à API para pegar o json da lista de notícias. 
Quando a chamada é feita com sucesso, a resposta json é transformada em uma lista de objetos NewsListElement, que representam os elementos dessa lista de notícias simplificadas. A lista é usada para alimentar um RecyclerView, que mostrará as informações de cada elemento (foto, título e data).
O RecyclerView ainda registra "click listeners" para cada elemento no método onBindViewHolder.

Ao clicar em um dos elementos da lista, temos a posição do elemento clicado. Assim, conseguimos o "id" desse elemento e o passamos para uma nova activity (NewsDetailsActivity) através de um Intent.

Ao iniciarmos a NewsDetailsActivity, resgatamos do Intent o "id" da notícia a ser detalhada aqui.
Uma nova chamada à API é feita, buscando agora uma notícia específica, usando o "id" obtido.
Um json com uma notícia mais detalhada é obtido e transformado em um objeto DetailedNews.
Assim, os elementos dessa activity são populados com os dados do objeto (foto, título, categorias - quando presentes, data e conteúdo).
