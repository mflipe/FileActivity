# Programação para Dispositivos Móveis Android

## Guia para criação de um projeto Android no Android Studio para uso do recurso de armazenamento de dados em arquivo

Nesse projeto utilizaremos a Activity para permitir que o usuário possa trabalhar com armazenamento de informações em arquivo. O que será apresentado permite o armazenamento de qualquer tipo de arquivo. Para ilustração dos conceitos será utilizado armazenamento de arquivos texto.

O Android permite fazer o armazenamento escolhendo entre dois tipos de armazenamento: Interno e Externo. O interno permite que as informações sempre estejam disponíveis para a aplicação e quando o usuário desinstala a aplicação os dados são automaticamente deletados. O externo. No armazenamento externo o arquivo pode não estar disponível, pois depende da disponibilidade do dispositivo de armazenamento. Além disso, os dados gravados podem ser lidos em outros dispositivos e ao desinstalar a aplicação os dados gravados só serão excluídos se estiverem na pasta padrão criada pela aplicação (por meio da chamada do método (`getExternalFilesDir()`).

O processo para gravação usando armazenamento interno ou externo é igual. O que muda na aplicação é a definição das permissões no arquivo Manifest.xml para gravar ou ler do armazenamento externo. Além disso, é indicado que se faça algumas verificações para saber se o dispositivo de armazenamento externo (memória) está presente para ser usado. A aplicação de exemplo que iremos apresentar vai utilizar o armazenamento interno, aplicando gravações de dados em vários arquivos diferentes, a partir da escolha do usuário. Para isso, a  aplicação apresentará uma lista de arquivos que o usuário deve escolher. Após a escolha de um arquivo, a aplicação irá exibir o conteúdo do arquivo e ainda permitir que o usuário entre com mais informações.