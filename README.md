# java-api-mongodb

Vídeo do api: https://youtu.be/qMM2Z_ICJow

Na API Java é possível fazer o CRUD completo de usuários.

Cada usuário pode estar associado com um post ou mais, assim como é possível o usuário auditar ou comentar o post de outro usuário, caso ele tenha feito a pesquisa em uma localização próxima e não queira criar um outro post.
A pesquisa dos posts pode ser feita por um oceano ou usando “oceansearch” na rota ou também pode ser usado o “fullsearch” para pesquisar qualquer palavra-chave.

A vinculação do post com o usuário ficaria por conta do front-end no momento da criação após o usuário estar autentificado no sistema. É apenas uma representação do relacionamento das entidades.
