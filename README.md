# Bem vindo ao Repositorio de Teste de Sistema Utilizando Selenium


## Instalando as dependencias

Caso esteja tendo problema para instalar o mavn com ZSH, usar o comando abaixo, ele instalar outro maven
``` 
brew install mvnvm => ele ja baixa e instala o ultimo maven
```


## Instanciar a variavel de Ambiente no MAC
abra o terminal do mac com o comando abaixo
``` 
open ~/.zshrc 
```
ou
```
open ~/.bash_profile
```

e cole o comando abaixo no arquivo que vai abrir

OBS: Voce precisa ter um dos dois instalado e funcionando acima

```
export PATH=~/Users/NOME DO SEU USUARIO DA MAQUINA /PASTA AONDE ESTA O MAVEN/apache-maven-3.8.6[/bin:$PATH

```

## Para Verificar se o MAVEN foi instalado utilizar o comando abaixo:
```
mvn -version 
```


## Ao tentar instalar o CHROMEDRIVER utilizando o MAC com o processador M1 encontrei um problema para poder instalar o CHROMEDRIVER pois falava que eu nao tinha permissao para executa-lo, MESMO EU SENDO USER ROOT DA MAQUINA. Foi ai que pesquisando eu encontrei o comando abaixo que permitiu que eu conseguise executar o CHROMEDRIVER

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


