# Bem vindo ao Repositorio de Teste de Sistema Utilizando Selenium


## Instalando as dependencias

Caso esteja tendo problema para instalar o mavn com ZSH, usar o comando abaixo, ele instalar outro maven
``` 
brew install mvnvm => ele ja baixa e instala o ultimo maven
```


## Instanciar a variavel de Ambiente
no terminal do mac
``` 
open ~/.zshrc 
```



## Verificar se foi instalado
```
mvn -version 
```


## baixar o chromedriver => se voce utiliza o MAC COM CHIP M1 E tiver com problema para liberar a instalação do mesmo usar o comando abaixo

```
sudo spctl --master-disable 
```

```
----------------------------------------------------------------------------------------------------------------------------------------------------
```

## Problemas comum

### Erro de permissão ao executar o script

```bash
# necessário executar apenas uma vez
chmod +x win-execute-test.sh mac-execute-test.sh 
```

### Erros gerais de chromedriver (Google Chrome) ou geckodriver (Firefox)

Certifique que a pasta `./drivers` tenha o driver correspondente à versão do seu browser instalado.

```
----------------------------------------------------------------------------------------------------------------------------------------------------
```

## Usuário MacOS

#### Acessar a pasta aonde tem o arquivo ./mac para poder Rodar todos os testes usar o comando abaixo

```bash
./mac-execute-test.sh
```

#### Rodar testes por tag

```bash
./mac-execute-test.sh @tag-que-queira-rodar
```

### Usuário Windows

#### Rodar todos os testes

```bash
sh win-execute-test.sh
```

#### Rodar testes por tag

```bash
sh win-execute-test.sh @tag-que-queira-rodar
```


