# Gerador de QR Code com ZXing e AWS S3
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Amazon S3](https://img.shields.io/badge/Amazon%20S3-FF9900?style=for-the-badge&logo=amazons3&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)


Este projeto demonstra a integração da biblioteca [ZXing](https://github.com/zxing/zxing) do Google para geração de QR Codes com o armazenamento dos arquivos gerados no Amazon S3.


## 🚀 Tecnologias Utilizadas

- **Java**
- **Maven**
- **Docker**
- **AWS S3**
- **AWS CLI (configurada com credenciais)**
- **AWS EC2**
- **AWS API Gateway**

## 🎯 Objetivo

Demonstrar como:

1. Gerar QR Codes utilizando a biblioteca ZXing.
2. Armazenar os arquivos gerados em um bucket do Amazon S3 via SDK da AWS.

## 🌐 Deploy
- Frontend: Vercel
- Backend: EC2 com IAM Rolem AWS API Gateway.

## 🛡️ Integração com AWS API Gateway
Para permitir que o front-end hospedado na Vercel se comunique com o back-end na EC2 de forma segura e eficiente, foi configurado um proxy reverso utilizando o AWS API Gateway.

## 🚀 Como Executar localmente

### 1. Pré-requisitos

- Java 17+
- Maven
- Docker
- Conta AWS com bucket S3 criado
- AWS CLI instalada e configurada com suas credenciais

### 2. Clonar o repositório

```bash
git https://github.com/mariaeac/qrcode-generator.git
```

### 3. Configurar variáveis de ambiente

Crie um arquivo .env na raíz do projeto:

```
AWS_ACCESS_KEY_ID=SEU_ACCESS_KEY
AWS_SECRET_ACCESS_KEY=SUA_SECRET_KEY
AWS_REGION=SUA_REGION
AWS_BUCKET_NAME=NOME_BUCKET
```

> **Importante:** Nunca comite essas credenciais no repositório.

### 4. Rodar a aplicação localmente:

Compile e execute o projeto:

```bash
mvn clean package
mvn spring-boot:run
```

### 5. Usando Docker (opcional)

```bash
docker build -t <nome_imagem>:X.X .
docker run --env-file .env -p 8080:8080 <nome_imagem>:X.X
```


## 📦 Exemplo de Uso

Ao executar, o projeto gera um QR Code com o conteúdo desejado (ex: URL) e o envia para o S3, retornando a URL pública ou o caminho do objeto no bucket.

## 🔗 Endpoints
### 📌 Gerar um QR Code
- **Método:** `POST`
- **Endpoint:** `/api/v1/qrcode`
- **Corpo da requisição:**

  ```json
  {
  "url": "https://exemplo.com.br"
  }
  ```

